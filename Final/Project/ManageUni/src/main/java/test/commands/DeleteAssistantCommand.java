package test.commands;

import beans.LectorType;
import services.UniManagement;

public class DeleteAssistantCommand extends Command {
    private int id;

    protected DeleteAssistantCommand(UniManagement uniManagement, int id) {
        super(uniManagement);
        this.id = id;
    }

    public static DeleteAssistantCommand create(UniManagement uniManagement, String...args){
        return new DeleteAssistantCommand(uniManagement, Integer.parseInt(args[1]));
    }

    @Override
    public void execute() {
        uniManagement.deleteAssistant(id);
    }
}
