package test.commands;

import services.UniManagement;

public class DeleteStudentCommand extends Command {
    private final int id;

    protected DeleteStudentCommand(UniManagement uniManagement, int id) {
        super(uniManagement);
        this.id = id;
    }

    public static DeleteStudentCommand create(UniManagement uniManagement, String...args){
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Error: Expected one parameter");
        }

        return new DeleteStudentCommand(uniManagement, Integer.parseInt(args[1]));
    }

    @Override
    public void execute() {
        if (uniManagement.deleteStudent(id)) {
            System.out.println("Deleted");
        }
        else {
            System.out.println("Does not exist");
        }
    }
}
