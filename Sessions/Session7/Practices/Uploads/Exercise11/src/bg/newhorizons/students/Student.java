package bg.newhorizons.students;

import java.util.Objects;

public class Student {

    private String name;
    private String course;
    private String facNumber;

    public Student(String name, String course, String facNumber) {
        this.name = name;
        this.course = course;
        this.facNumber = facNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFacNumber() {
        return facNumber;
    }

    public void setFacNumber(String facNumber) {
        this.facNumber = facNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return facNumber.equals(student.facNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", facNumber='" + facNumber + '\'' +
                '}';
    }
}
