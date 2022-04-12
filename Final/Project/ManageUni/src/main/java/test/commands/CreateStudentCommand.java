package test.commands;

import services.UniManagement;

public class CreateStudentCommand extends Command {
    private int id;
    private String firstName;
    private String lastName;
    private String facNumber;

    protected CreateStudentCommand(UniManagement uniManagement, int id, String firstName, String lastName, String facNumber) {
        super(uniManagement);
        this.id = id;
        this.facNumber = facNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static CreateStudentCommand create(UniManagement uniManagement, String...args){
        return new CreateStudentCommand(uniManagement, Integer.parseInt(args[1]), args[2], args[3], args[4]);
    }

    @Override
    public void execute() {
        uniManagement.createStudent(id, firstName, lastName, facNumber);
    }
}
