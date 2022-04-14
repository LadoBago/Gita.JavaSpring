package exceptions;

import beans.User;

public class TooManyCoursesException extends Exception {
    private final User user;

    public TooManyCoursesException(String message, User user) {
        super(message == null ? "Maximum allowed number of courses is exceeded" : message);
        this.user = user;
    }
    public TooManyCoursesException(User user) {
        this(null, user);
    }
}
