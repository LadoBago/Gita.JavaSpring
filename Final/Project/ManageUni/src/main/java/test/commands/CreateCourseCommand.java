package test.commands;

import services.UniManagement;

public class CreateCourseCommand extends Command {
    private final String name;

    protected CreateCourseCommand(UniManagement uniManagement, String name) {
        super(uniManagement);
        this.name = name;
    }

    public static CreateCourseCommand create(UniManagement uniManagement, String...args) {
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Error: Expected one parameter");
        }

        return new CreateCourseCommand(uniManagement, args[1]);
    }

    @Override
    public void execute() {
        if (uniManagement.createCourse(this.name) != null) {
            System.out.println("Created course");
        }
        else {
            System.out.println("Course already exists");

        }
    }
}
