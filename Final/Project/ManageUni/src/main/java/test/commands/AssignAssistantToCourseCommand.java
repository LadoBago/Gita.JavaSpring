package test.commands;

import beans.Course;
import beans.Lector;
import services.UniManagement;

public class AssignAssistantToCourseCommand extends Command {
    private final int id;
    private final String courseName;

    protected AssignAssistantToCourseCommand(UniManagement uniManagement, int id, String courseName) {
        super(uniManagement);
        this.id = id;
        this.courseName = courseName;
    }

    public static AssignAssistantToCourseCommand create(UniManagement uniManagement, String...args) {
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 3) {
            throw new IllegalArgumentException("Error: Expected two parameters");
        }

        return new AssignAssistantToCourseCommand(uniManagement, Integer.parseInt(args[1]), args[2]);
    }

    @Override
    public void execute() {
        Lector assistant = uniManagement.getAssistantById(id);

        if (assistant == null) {
            new IllegalArgumentException("Could not find the assistant");
        }

        Course course = uniManagement.getCourseByName(courseName);

        if (course == null) {
            new IllegalArgumentException("Could not find the course");
        }

        this.uniManagement.assignAssistantToCourse(assistant, course);

    }
}
