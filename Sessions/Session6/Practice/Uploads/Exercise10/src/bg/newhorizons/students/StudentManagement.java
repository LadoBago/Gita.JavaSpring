package bg.newhorizons.students;

import java.util.List;

public interface StudentManagement {

    List<Student> getStudentsByCourse(String course);

    List<Student> getStudents();

    Student addStudent(String facNumber, String name, String course);

    boolean removeStudent(String facNumber) throws NonExistingStudentException;
}
