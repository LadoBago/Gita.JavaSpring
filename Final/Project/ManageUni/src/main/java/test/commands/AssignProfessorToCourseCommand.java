package test.commands;

import beans.Course;
import beans.Lector;
import services.UniManagement;

public class AssignProfessorToCourseCommand extends Command {
    private final int id;
    private final String courseName;

    protected AssignProfessorToCourseCommand(UniManagement uniManagement, int id, String courseName) {
        super(uniManagement);
        this.id = id;
        this.courseName = courseName;
    }


    public static AssignProfessorToCourseCommand create(UniManagement uniManagement, String...args) {
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 3) {
            throw new IllegalArgumentException("Error: Expected two parameters");
        }

        return new AssignProfessorToCourseCommand(uniManagement, Integer.parseInt(args[1]), args[2]);
    }

    @Override
    public void execute() {
        Lector lector = uniManagement.getLectorById(id);
        if (lector == null) {
            new IllegalArgumentException("Could not find the lector");
        }

        Course course = uniManagement.getCourseByName(courseName);
        if (course == null) {
            new IllegalArgumentException("Could not find the course");
        }

        this.uniManagement.assignLectorToCourse(lector, course);

    }
}
