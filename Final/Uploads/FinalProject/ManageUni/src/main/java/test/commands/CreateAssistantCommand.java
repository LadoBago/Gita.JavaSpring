package test.commands;

import services.UniManagement;

public class CreateAssistantCommand extends Command {
    private final int id;
    private final String firstName;
    private final String lastName;

    protected CreateAssistantCommand(UniManagement uniManagement, int id, String firstName, String lastName) {
        super(uniManagement);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static CreateAssistantCommand create(UniManagement uniManagement, String...args){
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 4) {
            throw new IllegalArgumentException("Error: Expected three parameters");
        }

        return new CreateAssistantCommand(uniManagement, Integer.parseInt(args[1]), args[2], args[3]);
    }

    @Override
    public void execute() {
        if (uniManagement.createAssistant(id, firstName, lastName) != null) {
            System.out.println("Created assistant");
        }
        else {
            System.out.println("Assistant already exists");

        }
    }
}
