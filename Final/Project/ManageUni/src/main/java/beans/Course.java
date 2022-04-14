package beans;

import exceptions.NoFreePlaceException;
import helpers.ArrayHelper;

import java.util.Arrays;
import java.util.Objects;

public class Course {
    public static final int MAX_STUDENTS = 30;

    public String getName() {
        return name;
    }

    private final String name;
    private final Student[] students;
    private Lector assistant;
    private Lector lector;
    private int lastUsedStudentIndex;

    public Course(String name) {
        this(name, null, null);
    }

    public Course(String name, Lector assistant, Lector lector) {
        if (name == null) {
            throw new IllegalArgumentException("parameter name is null");
        }

        this.name = name;
        this.assistant = assistant;
        this.lector = lector;
        this.students = new Student[MAX_STUDENTS];
    }

    public boolean addStudent(Student student) throws NoFreePlaceException {
        if (student == null) {
            throw new IllegalArgumentException("parameter student is null");
        }

        if (lastUsedStudentIndex == MAX_STUDENTS) {
            throw new NoFreePlaceException(this);
        }

        boolean res = ArrayHelper.addItem(this.students, student, lastUsedStudentIndex);
        if (res) {
            this.lastUsedStudentIndex++;
        }

        return res;
    }
    public boolean deleteStudent(Student student){
        if (student == null) {
            throw new IllegalArgumentException("parameter student is null");
        }

        boolean res = ArrayHelper.deleteItem(this.students, student, lastUsedStudentIndex);
        if (res) {
            this.lastUsedStudentIndex--;
        }

        return res;
    }

    public boolean setAssistant(Lector assistant) {
        if (this.assistant != null && this.assistant.equals(assistant)) {
            return false;
        }

        this.assistant = assistant;
        return true;
    }

    public boolean setLector(Lector lector) {
        if(this.lector != null && this.lector.equals(lector)) {
            return false;
        }

        this.lector = lector;
        return true;
    }

    public Student[] getStudents() {
        if (this.students == null)
            return new Student[0];

        return Arrays.copyOfRange(this.students, 0, lastUsedStudentIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return name.equalsIgnoreCase(course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
