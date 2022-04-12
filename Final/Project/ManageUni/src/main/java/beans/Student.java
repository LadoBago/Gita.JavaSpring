package beans;

import exceptions.TooManyCoursesException;
import helpers.ArrayHelper;

import java.util.Arrays;


public class Student extends User {
    public final int MAX_COURSES = 10;

    private String facNumber;
    private Course[] courses;
    private int lastUsedCourseIndex;

    public Student(int id, String firstName, String lastName, String facNumber) {
        super(id, firstName, lastName);
        this.facNumber = facNumber;
        this.courses = new Course[MAX_COURSES];
        this.lastUsedCourseIndex = 0;
    }

    public Course[] getCourses() {
        if (this.courses == null)
            return null;

        Course[] res =  Arrays.copyOfRange(this.courses, 0, lastUsedCourseIndex);
        return res;
    }

    public boolean addCourse(Course course) throws TooManyCoursesException {
        if (course == null) {
            throw new IllegalArgumentException("parameter course is null");
        }
        if (this.courses.length == MAX_COURSES) {
            throw new TooManyCoursesException(this);
        }

        boolean res = ArrayHelper.addItem(this.courses, course, lastUsedCourseIndex);
        if (res) {
            this.lastUsedCourseIndex++;
        }

        return res;
    }

    public boolean deleteCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("parameter course is null");
        }

        boolean res = ArrayHelper.deleteItem(this.courses, course, lastUsedCourseIndex);
        if (res) {
            this.lastUsedCourseIndex--;
        }

        return res;
    }

}
