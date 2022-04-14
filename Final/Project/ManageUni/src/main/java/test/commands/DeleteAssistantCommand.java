package test.commands;

import beans.LectorType;
import services.UniManagement;

public class DeleteAssistantCommand extends Command {
    private final int id;

    protected DeleteAssistantCommand(UniManagement uniManagement, int id) {
        super(uniManagement);
        this.id = id;
    }

    public static DeleteAssistantCommand create(UniManagement uniManagement, String...args){
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Error: Expected one parameter");
        }

        return new DeleteAssistantCommand(uniManagement, Integer.parseInt(args[1]));
    }

    @Override
    public void execute() {
        if (uniManagement.deleteAssistant(id)) {
            System.out.println("Deleted");
        }
        else {
            System.out.println("Does not exist");
        }
    }
}
