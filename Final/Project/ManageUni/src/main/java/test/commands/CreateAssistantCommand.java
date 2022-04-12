package test.commands;

import services.UniManagement;

public class CreateAssistantCommand extends Command {
    private int id;
    private String firstName;
    private String lastName;

    protected CreateAssistantCommand(UniManagement uniManagement, int id, String firstName, String lastName) {
        super(uniManagement);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static CreateAssistantCommand create(UniManagement uniManagement, String...args){
        return new CreateAssistantCommand(uniManagement, Integer.parseInt(args[1]), args[2], args[3]);
    }

    @Override
    public void execute() {
        uniManagement.createAssistant(id, firstName, lastName);
    }
}
