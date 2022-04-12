package bg.newhorizons.students;

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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", facNumber='" + facNumber + '\'' +
                '}';
    }
}
