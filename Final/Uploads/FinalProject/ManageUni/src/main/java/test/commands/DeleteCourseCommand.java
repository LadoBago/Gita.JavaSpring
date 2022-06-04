package test.commands;

import services.UniManagement;

public class DeleteCourseCommand extends Command {
    private final String courseName;

    protected DeleteCourseCommand(UniManagement uniManagement, String courseName) {
        super(uniManagement);
        this.courseName = courseName;
    }

    public static DeleteCourseCommand create(UniManagement uniManagement, String...args){
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Error: Expected one parameter");
        }

        return new DeleteCourseCommand(uniManagement, args[1]);
    }

    @Override
    public void execute() {
        if (uniManagement.deleteCourse(courseName)) {
            System.out.println("Deleted");
        }
        else {
            System.out.println("Does not exist");
        }
    }
}
