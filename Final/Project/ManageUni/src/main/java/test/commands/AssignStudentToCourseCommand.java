package test.commands;

import beans.Course;
import beans.Student;
import services.UniManagement;

public class AssignStudentToCourseCommand extends Command {
    private final int id;
    private final String courseName;

    protected AssignStudentToCourseCommand(UniManagement uniManagement, int id, String courseName) {
        super(uniManagement);
        this.id = id;
        this.courseName = courseName;
    }

    public static AssignStudentToCourseCommand create(UniManagement uniManagement, String...args) {
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 3) {
            throw new IllegalArgumentException("Error: Expected two parameters");
        }

        return new AssignStudentToCourseCommand(uniManagement, Integer.parseInt(args[1]), args[2]);
    }

    @Override
    public void execute() {
        Student student = uniManagement.getStudentById(id);
        if (student == null) {
            new IllegalArgumentException("Could not find the student");
        }

        Course course = uniManagement.getCourseByName(courseName);
        if (course == null) {
            new IllegalArgumentException("Could not find the course");
        }

        this.uniManagement.addStudentToCourse(student, course);
    }
}
