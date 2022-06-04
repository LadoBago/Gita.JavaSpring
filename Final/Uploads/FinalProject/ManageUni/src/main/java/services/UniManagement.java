package services;

import beans.*;
import exceptions.NoFreePlaceException;
import exceptions.TooManyCoursesException;

public interface UniManagement {
    /**
     * Crete a new course with name courseName and return it
     *
     * @return new instance of course with the passed name if it's created or
     * null in another case. A course will be created only if already does not exists
     * another course with the same courseName
     */
    Course createCourse(String courseName);
    /**
     * Delete a course with name courseName
     *
     * @return <code>true</code> only in case the course with passed name was
    removed
     */
    boolean deleteCourse(String courseName);
    /**
     * Creat and return new instance of Student with the passed arguments and initial
     state of the student
     *
     * @return new instance of a student identified with the passed ID, if already does
    not exists,
     * and the other arguments as initial state if it's cerated or
     * null in another case
     */
    Student createStudent(int id, String firstName, String lastName, String
            facNumber);
    /**
     * Delete a student with the passed ID
     *
     * @return <code>true</code> only in cae the student was remvoed
     */
    boolean deleteStudent(int id);
    /**
     * Create a new assistance in the univertity withthe passed arguemtns as initial state
     *
     * @return new created professor assistance identified withthe passed ID, if already
    does not exists with that ID
     */
    Lector createAssistant(int id, String firstName, String lastName);
    /**
     * Delete an professor asisstance with the passed ID, if such exists
     *
     * @return <code>true</code> ONLY in case the assistance was removed
     */
    boolean deleteAssistant(int id);
    /**
     * Create a new professor in the univertity withthe passed arguemtns as initial state
     *
     * @return new created professor identified withthe passed ID, if already
    does not exists with that ID
     */
    Lector createLector(int id, String firstName, String lastName, LectorType lectorType);
    /**
     * Delete an professor with the passed ID, if such exists
     *
     * @return <code>true</code> ONLY in case the professor was removed
     */
    boolean deleteLector(int id);
    /**
     * Aighn an assistant to a course
     *
     * @return <code>true</code> ONLY n case the assistant was succesfully assighed
    to the course
     */
    boolean assignAssistantToCourse(Lector assistant, Course course) throws TooManyCoursesException;
    /**
     * Aighn a professor to a course
     *
     * @return <code>true</code> ONLY n case the professor was succesfully assighed
    to the course
     */
    boolean assignLectorToCourse(Lector lector, Course course) throws TooManyCoursesException;
    /**
     * Add a studnt to a course
     *
     * @return <code.true</code> ONLY inca se the student is successfully added to the
    course
     */
    boolean addStudentToCourse(Student student, Course course) throws TooManyCoursesException, NoFreePlaceException;
    /**
     * Add all students to a course
     *
     * @return <code>true</code> ONLY inc ase all students are added to a course
     */
    boolean addStudentsToCourse(Student[] students, Course course) throws TooManyCoursesException, NoFreePlaceException;
    /**
     * Remvoe a student from a course
     *
     * @return <code>true</code> only in case the student was succesfully removed
    from a course
     */
    boolean removeStudentFromCourse(Student student, Course course);

    Student getStudentById(int id);
    Course getCourseByName(String name);
    Lector getAssistantById(int id);
    Lector getLectorById(int id);

}
