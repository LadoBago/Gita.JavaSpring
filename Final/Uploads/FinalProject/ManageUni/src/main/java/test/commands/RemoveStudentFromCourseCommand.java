package test.commands;

import beans.Course;
import beans.Student;
import services.UniManagement;

public class RemoveStudentFromCourseCommand extends Command {
    private final int studentId;
    private final String courseName;

    protected RemoveStudentFromCourseCommand(UniManagement uniManagement, int studentId, String courseName) {
        super(uniManagement);
        this.studentId = studentId;
        this.courseName = courseName;
    }

    public static RemoveStudentFromCourseCommand create(UniManagement uniManagement, String...args){
        if (uniManagement == null) {
            throw new IllegalArgumentException("uniManagement == null");
        }
        if (args.length != 3) {
            throw new IllegalArgumentException("Error: Expected two parameters");
        }

        return new RemoveStudentFromCourseCommand (uniManagement, Integer.parseInt(args[1]), args[2]);
    }

    @Override
    public void execute() {
        Student student = uniManagement.getStudentById(studentId);

        if (student == null) {
            throw new IllegalArgumentException("Could not find the student");
        }

        Course course = uniManagement.getCourseByName(courseName);

        if (course == null) {
            throw new IllegalArgumentException("Could not find the course");
        }

        if (uniManagement.removeStudentFromCourse(student, course)) {
            System.out.println("Removed");
        }
        else {
            System.out.println("Nothing to remove");
        }
    }
}
