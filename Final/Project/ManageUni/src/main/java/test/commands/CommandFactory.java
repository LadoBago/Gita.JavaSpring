package test.commands;

import services.UniManagement;

public class CommandFactory {
    private static final String CREATE_STUDENT = "createstudent";
    private static final String CREATE_COURSE = "createcourse";
    private static final String CREATE_ASSISTANT = "createassistant";
    private static final String CREATE_PROFESSOR = "createprofessor";
    private static final String ASSIGN_STUDENT_TO_COURSE = "assignstudenttoCourse";
    private static final String ASSIGN_PROFESSOR_TO_COURSE = "assignprofessortocourse";
    private static final String ASSIGN_ASSISTANT_TO_COURSE = "assignassistanttocourse";
    private static final String DELETE_PROFESSOR = "deleteprofessor";
    private static final String DELETE_ASSISTANT = "deleteassistant";
    private static final String DELETE_STUDENT = "deletestudent";
    private static final String DELETE_COURSE = "deletecourse";
    private static final String REMOVE_STUDENT_FROM_CURSE = "removestudentfromcourse";


    private final UniManagement uniManagement;

    public CommandFactory(UniManagement uniManagement){
        this.uniManagement = uniManagement;
    }

    public Command createCommand(String[] args) {
        Command res = null;

        switch (args[0].toLowerCase()){
            case CREATE_STUDENT:
                res = CreateStudentCommand.create(uniManagement, args);
                break;
            case CREATE_COURSE:
                res = CreateCourseCommand.create(uniManagement, args);
                break;
            case CREATE_ASSISTANT:
                res = CreateAssistantCommand.create(uniManagement, args);
                break;
            case CREATE_PROFESSOR:
                res = CreateProfessorCommand.create(uniManagement, args);
                break;
            case ASSIGN_STUDENT_TO_COURSE:
                res = AssignStudentToCourseCommand.create(uniManagement, args);
                break;
            case ASSIGN_PROFESSOR_TO_COURSE:
                res = AssignProfessorToCourseCommand.create(uniManagement, args);
                break;
            case ASSIGN_ASSISTANT_TO_COURSE:
                res = AssignAssistantToCourseCommand.create(uniManagement, args);
                break;
            case DELETE_PROFESSOR:
                res = DeleteProfessorCommand.create(uniManagement, args);
                break;
            case DELETE_ASSISTANT:
                res = DeleteAssistantCommand.create(uniManagement, args);
                break;
            case DELETE_STUDENT:
                res = DeleteStudentCommand.create(uniManagement, args);
                break;
            case DELETE_COURSE:
                res = DeleteCourseCommand.create(uniManagement, args);
                break;
            case REMOVE_STUDENT_FROM_CURSE:
                res = RemoveStudentFromCourseCommand.create(uniManagement, args);
                break;
        }

        return res;
    }
}
