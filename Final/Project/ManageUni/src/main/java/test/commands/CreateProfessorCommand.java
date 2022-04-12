package test.commands;

import beans.LectorType;
import services.UniManagement;

public class CreateProfessorCommand extends Command {
    private int id;
    private String firstName;
    private String lastName;
    private LectorType lectorType;

    protected CreateProfessorCommand(UniManagement uniManagement, int id, String firstName, String lastName, LectorType lectorType) {
        super(uniManagement);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lectorType = lectorType;
    }

    public static CreateProfessorCommand create(UniManagement uniManagement, String...args){
        return new CreateProfessorCommand(uniManagement, Integer.parseInt(args[1]), args[2], args[3], LectorType.valueOf(args[4]));
    }

    @Override
    public void execute() {
        uniManagement.createLector(id, firstName, lastName, lectorType);
    }
}
