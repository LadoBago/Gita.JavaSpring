package beans;

import exceptions.TooManyCoursesException;
import helpers.ArrayHelper;

import java.util.Arrays;


public class Lector extends User {
    public final int MAX_COURSES = 4;

    private LectorType lectorType;
    private Course[] courses;
    private int lastUsedCourseIndex;


    public Lector(int id, String firstName, String lastName, LectorType lectorType) {
        super(id, firstName, lastName);
        this.lectorType = lectorType;
        this.courses = new Course[MAX_COURSES];
        this.lastUsedCourseIndex = 0;
    }

    public boolean addCourse(Course course) throws TooManyCoursesException {
        if (course == null) {
            throw new IllegalArgumentException("parameter course is null");
        }
        if (this.lastUsedCourseIndex == MAX_COURSES) {
            throw new TooManyCoursesException(this);
        }
        boolean res = ArrayHelper.addItem(this.courses, course, lastUsedCourseIndex);
        if (res) {
            lastUsedCourseIndex++;
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

    public boolean isAssistant() {
        return this.lectorType == LectorType.ASSISTANT;
    }

    public Course[] getCourses() {
        if (this.courses == null)
            return null;

        Course[] res =  Arrays.copyOfRange(this.courses, 0, lastUsedCourseIndex);
        return res;
    }

}
