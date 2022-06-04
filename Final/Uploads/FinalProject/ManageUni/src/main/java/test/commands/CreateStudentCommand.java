package test.commands;

import services.UniManagement;

public class CreateStudentCommand extends Command {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String facNumber;

    protected CreateStudentCommand(UniManagement uniManagement, int id, String firstName, String lastName, String facNumber) {
        super(uniManagement);
        this.id = id;
        this.facNumber = facNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static CreateStudentCommand create(UniManagement uniManagement, String...args){
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 5) {
            throw new IllegalArgumentException("Error: Expected four parameters");
        }

        return new CreateStudentCommand(uniManagement, Integer.parseInt(args[1]), args[2], args[3], args[4]);
    }

    @Override
    public void execute() {
        if (uniManagement.createStudent(id, firstName, lastName, facNumber) != null) {
            System.out.println("Created student");
        }
        else {
            System.out.println("Student already exists");
        }

    }
}
