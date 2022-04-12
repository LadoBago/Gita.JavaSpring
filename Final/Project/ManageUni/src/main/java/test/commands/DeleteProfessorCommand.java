package test.commands;

import services.UniManagement;

public class DeleteProfessorCommand extends Command {
    private int id;

    protected DeleteProfessorCommand(UniManagement uniManagement, int id) {
        super(uniManagement);
        this.id = id;
    }

    public static DeleteProfessorCommand create(UniManagement uniManagement, String...args){
        return new DeleteProfessorCommand(uniManagement, Integer.parseInt(args[1]));
    }

    @Override
    public void execute() {
        uniManagement.deleteLector(id);
    }
}
