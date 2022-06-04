package test.commands;

import beans.LectorType;
import services.UniManagement;

public class CreateProfessorCommand extends Command {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final LectorType lectorType;

    protected CreateProfessorCommand(UniManagement uniManagement, int id, String firstName, String lastName, LectorType lectorType) {
        super(uniManagement);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lectorType = lectorType;
    }

    public static CreateProfessorCommand create(UniManagement uniManagement, String...args){
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 5) {
            throw new IllegalArgumentException("Error: Expected four parameters");
        }

        return new CreateProfessorCommand(uniManagement, Integer.parseInt(args[1]), args[2], args[3], LectorType.valueOf(args[4]));
    }

    @Override
    public void execute() {
        if (uniManagement.createLector(id, firstName, lastName, lectorType) != null) {
            System.out.println("Created " + lectorType.toString());
        }
        else {
            System.out.println("Lector already exists");

        }
    }
}
