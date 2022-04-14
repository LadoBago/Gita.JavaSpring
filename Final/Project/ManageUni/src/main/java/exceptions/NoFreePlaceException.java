package exceptions;

import beans.Course;

public class NoFreePlaceException extends Exception {
    private final Course course;

    public NoFreePlaceException(String message, Course course) {
        super(message == null ? "At this course are no more free places remaining" : message);
        this.course = course;
    }

    public NoFreePlaceException(Course course) {
        this(null, course);
    }
}
