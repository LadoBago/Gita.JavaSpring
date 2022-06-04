package test.commands;

import beans.Course;
import beans.Student;
import exceptions.NoFreePlaceException;
import exceptions.TooManyCoursesException;
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
            throw new IllegalArgumentException("Could not find the student");
        }

        Course course = uniManagement.getCourseByName(courseName);
        if (course == null) {
            throw new IllegalArgumentException("Could not find the course");
        }

        try {
            if (this.uniManagement.addStudentToCourse(student, course)) {
                System.out.println("Assigned");
            }
            else {
                System.out.println("Already assigned");
            }
        } catch (TooManyCoursesException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NoFreePlaceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
