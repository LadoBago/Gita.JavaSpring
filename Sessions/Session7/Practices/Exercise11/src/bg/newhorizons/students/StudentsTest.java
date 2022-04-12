package bg.newhorizons.students;

import java.util.Set;

public class StudentsTest {

    public static void main(String [] args) {
        StudentManagement studentManagement = new StudentManagementImpl();

        studentManagement.addStudent("1", "Gio", "Java");
        studentManagement.addStudent("2", "Maria", "Java");
        studentManagement.addStudent("1", "Peter", "Security");
        studentManagement.addStudent("4", "Top", "Docker");
        studentManagement.addStudent("5", "Veska", "Cloud technologies");

        Set<Student> javaStudents = studentManagement.getStudentsByCourse("Java");

        // Only Gio and Maria should be included here
        for (Student s : javaStudents) {
            System.out.println(s);
        }

        // 2. Add the source code so that we can remove Veska from the students
        try {
            studentManagement.removeStudent("5");
        } catch (NonExistingStudentException e) {
            e.printStackTrace();
        }

    }
}
