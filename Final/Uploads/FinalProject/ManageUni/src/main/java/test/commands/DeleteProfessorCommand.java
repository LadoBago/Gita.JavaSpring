package test.commands;

import services.UniManagement;

public class DeleteProfessorCommand extends Command {
    private final int id;

    protected DeleteProfessorCommand(UniManagement uniManagement, int id) {
        super(uniManagement);
        this.id = id;
    }

    public static DeleteProfessorCommand create(UniManagement uniManagement, String...args){
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Error: Expected one parameter");
        }

        return new DeleteProfessorCommand(uniManagement, Integer.parseInt(args[1]));
    }

    @Override
    public void execute() {
        if (uniManagement.deleteLector(id)) {
            System.out.println("Deleted");
        }
        else {
            System.out.println("Does not exist");
        }
    }
}
