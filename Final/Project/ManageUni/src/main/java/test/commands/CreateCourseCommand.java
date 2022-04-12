package test.commands;

import services.UniManagement;

public class CreateCourseCommand extends Command {
    private String name;

    protected CreateCourseCommand(UniManagement uniManagement, String name) {
        super(uniManagement);
        this.name = name;
    }

    public static CreateCourseCommand create(UniManagement uniManagement, String...args) {
        return new CreateCourseCommand(uniManagement, args[1]);
    }

    @Override
    public void execute() {
        uniManagement.createCourse(this.name);
    }
}
