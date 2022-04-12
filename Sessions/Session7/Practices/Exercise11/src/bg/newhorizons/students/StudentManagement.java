package bg.newhorizons.students;


import java.util.Set;

public interface StudentManagement {

    Set<Student> getStudentsByCourse(String course);

    Student addStudent(String facNumber, String name, String course);

    boolean removeStudent(String facNumber) throws NonExistingStudentException;
}
