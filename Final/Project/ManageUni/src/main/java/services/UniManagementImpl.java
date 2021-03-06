package services;

import exceptions.NoFreePlaceException;
import exceptions.TooManyCoursesException;

import helpers.ArrayHelper;
import beans.*;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.System.out;

public class UniManagementImpl  implements UniManagement {
    public static final int MAX_STUDENTS = 1000;
    public static final int MAX_COURSES = 10;
    public static final int MAX_LECTORS = 100;
    public static final int MAX_ASSISTANT = 100;

    private final Student[] students;
    private final Course[] courses;
    private final Lector[] assistants;
    private final Lector[] lectors;

    private int lastUsedStudentIndex;
    private int lastUsedCourseIndex;
    private int lastUsedAssistantIndex;
    private int lastUsedLectorIndex;

    public UniManagementImpl() {
        this.students = new Student[MAX_STUDENTS];
        this.courses = new Course[MAX_COURSES];
        this.assistants = new Lector[MAX_LECTORS];
        this.lectors = new Lector[MAX_ASSISTANT];

        lastUsedAssistantIndex = 0;
        lastUsedCourseIndex = 0;
        lastUsedLectorIndex = 0;
        lastUsedStudentIndex = 0;
    }

    @Override
    public Course createCourse(String courseName) {
        Course course = new Course(courseName);

        if (ArrayHelper.addItem(this.courses, course, lastUsedCourseIndex)){
            this.lastUsedCourseIndex++;
            return course;
        }

        return null;
    }

    @Override
    public boolean deleteCourse(String courseName) {
        Course course = this.getCourseByName(courseName);
        if (course == null)
            return false;

        for (Student student : course.getStudents()) {
            removeStudentFromCourse(student, course);
        }

        if (ArrayHelper.deleteItem(this.courses, course, lastUsedCourseIndex)){
            this.lastUsedCourseIndex--;
            return true;
        }

        return false;
    }

    @Override
    public Student createStudent(int id, String firstName, String lastName, String facNumber) {
        Student student = new Student(id, firstName, lastName, facNumber);

        if (ArrayHelper.addItem(this.students, student, lastUsedStudentIndex)){
            this.lastUsedStudentIndex++;
            return student;
        }

        return null;
    }

    @Override
    public boolean deleteStudent(int id) {
        Student student = this.getStudentById(id);
        if (student == null)
            return  false;

        for (Course course : student.getCourses()) {
            this.removeStudentFromCourse(student, course);
        }

        if (ArrayHelper.deleteItem(this.students, student, lastUsedStudentIndex)){
            this.lastUsedStudentIndex--;
            return true;
        }

        return false;
    }

    @Override
    public Lector createAssistant(int id, String firstName, String lastName) {
        Lector assistant = new Lector(id, firstName, lastName, LectorType.ASSISTANT);

        if (ArrayHelper.addItem(this.assistants, assistant, lastUsedAssistantIndex)){
            this.lastUsedAssistantIndex++;
            return assistant;
        }

        return null;
    }

    @Override
    public boolean deleteAssistant(int id) {
        Lector assistant = getAssistantById(id);
        if (assistant == null)
            return false;

        for (Course course : assistant.getCourses()) {
            course.setAssistant(null);
        }

        if (ArrayHelper.deleteItem(this.assistants, assistant, lastUsedAssistantIndex)){
            this.lastUsedAssistantIndex--;
            return true;
        }

        return false;
    }

    @Override
    public Lector createLector(int id, String firstName, String lastName, LectorType lectorType) {
        Lector lector = new Lector(id, firstName, lastName, lectorType);
        if (lector.isAssistant()) {
            throw  new IllegalArgumentException("Lector's type must not be an ASSISTANT");
        }

        if (ArrayHelper.addItem(this.lectors, lector, lastUsedLectorIndex)){
            this.lastUsedLectorIndex++;
            return lector;
        }

        return null;
    }

    @Override
    public boolean deleteLector(int id) {
        Lector lector = getLectorById(id);

        if (lector == null)
            return false;

        for (Course course : lector.getCourses()) {
            course.setLector(null);
        }

        if (ArrayHelper.deleteItem(this.lectors, lector, lastUsedLectorIndex)){
            this.lastUsedLectorIndex--;
            return true;
        }

        return false;
    }

    @Override
    public boolean assignAssistantToCourse(Lector assistant, Course course) throws TooManyCoursesException {
        if (assistant == null) {
            throw new IllegalArgumentException("The parameter assistant is null");
        }
        if (course == null) {
            throw new IllegalArgumentException("The parameter course is null");
        }
        if (!assistant.isAssistant()) {
            throw  new IllegalArgumentException("Lector's type must be an ASSISTANT");
        }

        assistant.addCourse(course);

        if (course.getAssistant() != null) {
            course.getAssistant().deleteCourse(course);
        }

        return course.setAssistant(assistant);
    }

    @Override
    public boolean assignLectorToCourse(Lector lector, Course course) throws TooManyCoursesException {
        if (lector == null) {
            throw new IllegalArgumentException("The parameter lector is null");
        }
        if (course == null) {
            throw new IllegalArgumentException("The parameter course is null");
        }
        if (lector.isAssistant()) {
            throw  new IllegalArgumentException("Lector's type must not be an ASSISTANT");
        }

        lector.addCourse(course);

        if (course.getLector() != null) {
            course.getLector().deleteCourse(course);
        }

        return course.setLector(lector);
    }

    @Override
    public boolean addStudentToCourse(Student student, Course course) throws TooManyCoursesException, NoFreePlaceException {
        if (student == null) {
            throw new IllegalArgumentException("The parameter student is null");
        }
        if (course == null) {
            throw new IllegalArgumentException("The parameter course is null");
        }

        if (!student.addCourse(course)) {
            return false;
        }

        course.addStudent(student);

        return true;
    }

    @Override
    public boolean addStudentsToCourse(Student[] students, Course course) throws TooManyCoursesException, NoFreePlaceException {
        int added = 0;
        for (Student student : students) {
            if (!this.addStudentToCourse(student, course))
                break;
            added++;
        }
        if (added != students.length){
            for (int j = 0; j < added; j++){
                removeStudentFromCourse(students[j], course);
            }
        }

        return added == students.length;
    }

    @Override
    public boolean removeStudentFromCourse(Student student, Course course) {
        if (student == null) {
            throw new IllegalArgumentException("The parameter student is null");
        }
        if (course == null) {
            throw new IllegalArgumentException("The parameter course is null");
        }

        return student.deleteCourse(course) || course.deleteStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        Student res = null;

        for (Student student : this.getStudents()) {
            if (student.getId() == id) {
                res = student;
                break;
            }
        }

        return res;
    }

    @Override
    public Course getCourseByName(String name) {
        Course res = null;

        for (Course course : this.getCourses()) {
            if (course.getName().equalsIgnoreCase(name)) {
                res = course;
                break;
            }
        }

        return res;
    }

    @Override
    public Lector getAssistantById(int id) {
        Lector res = null;

        for (Lector assistant : this.getAssistants()) {
            if (assistant.getId() == id) {
                res = assistant;
                break;
            }
        }

        return res;
    }

    @Override
    public Lector getLectorById(int id) {
        Lector res = null;

        for (Lector lector : this.getLectors()) {
            if (lector.getId() == id) {
                res = lector;
                break;
            }
        }

        return res;
    }

    private Student[] getStudents() {
        return Arrays.copyOfRange(this.students, 0, lastUsedStudentIndex);
    }

    private Lector[] getLectors() {
        return Arrays.copyOfRange(this.lectors, 0, lastUsedLectorIndex);
    }

    private Lector[] getAssistants() {
        return Arrays.copyOfRange(this.assistants, 0, lastUsedAssistantIndex);
    }

    private Course[] getCourses() {
        return Arrays.copyOfRange(this.courses, 0, lastUsedCourseIndex);
    }
}
