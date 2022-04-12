package test.commands;

import services.UniManagement;

public class DeleteCourseCommand extends Command {
    private String courseName;

    protected DeleteCourseCommand(UniManagement uniManagement, String courseName) {
        super(uniManagement);
        this.courseName = courseName;
    }

    public static DeleteCourseCommand create(UniManagement uniManagement, String...args){
        return new DeleteCourseCommand(uniManagement, args[1]);
    }

    @Override
    public void execute() {
        uniManagement.deleteCourse(courseName);
    }
}
