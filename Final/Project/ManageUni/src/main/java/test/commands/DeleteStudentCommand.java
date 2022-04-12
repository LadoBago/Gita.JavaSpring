package test.commands;

import services.UniManagement;

public class DeleteStudentCommand extends Command {
    private int id;

    protected DeleteStudentCommand(UniManagement uniManagement, int id) {
        super(uniManagement);
        this.id = id;
    }

    public static DeleteStudentCommand create(UniManagement uniManagement, String...args){
        return new DeleteStudentCommand(uniManagement, Integer.parseInt(args[1]));
    }

    @Override
    public void execute() {
        uniManagement.deleteStudent(id);
    }
}
