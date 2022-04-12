package test.commands;

import beans.Course;
import beans.Student;
import services.UniManagement;

public class RemoveStudentFromCourseCommand extends Command {
    private int studentId;
    private String courseName;

    protected RemoveStudentFromCourseCommand(UniManagement uniManagement, int studentId, String courseName) {
        super(uniManagement);
        this.studentId = studentId;
        this.courseName = courseName;
    }

    public static RemoveStudentFromCourseCommand create(UniManagement uniManagement, String...args){
        return new RemoveStudentFromCourseCommand (uniManagement, Integer.parseInt(args[1]), args[2]);
    }

    @Override
    public void execute() {
        Student student = uniManagement.getStudentById(studentId);

        if (student == null) {
            new IllegalArgumentException("Could not find the student");
        }

        Course course = uniManagement.getCourseByName(courseName);

        if (course == null) {
            new IllegalArgumentException("Could not find the course");
        }

        uniManagement.removeStudentFromCourse(student, course);
    }
}
