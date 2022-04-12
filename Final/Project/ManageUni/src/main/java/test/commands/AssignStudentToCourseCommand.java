package test.commands;

import beans.Course;
import beans.Student;
import services.UniManagement;

public class AssignStudentToCourseCommand extends Command {
    private int id;
    private String courseName;

    protected AssignStudentToCourseCommand(UniManagement uniManagement, int id, String courseName) {
        super(uniManagement);
        this.id = id;
        this.courseName = courseName;
    }

    public static AssignStudentToCourseCommand create(UniManagement uniManagement, String...args) {
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
