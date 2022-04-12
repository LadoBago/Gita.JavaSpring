package bg.newhorizons.students;

import java.util.List;

public class StudentsTest {

    public static void main(String [] args) {
        StudentManagement studentManagement = new StudentManagementImpl();

        studentManagement.addStudent("1", "Gio", "Java");
        studentManagement.addStudent("2", "Maria", "Java");
        studentManagement.addStudent("1", "Peter", "Security");
        studentManagement.addStudent("4", "Top", "Docker");
        studentManagement.addStudent("5", "Veska", "Cloud technologies");

        List<Student> javaStudents = studentManagement.getStudentsByCourse("Java");

        // Only Gio and Maria should be included here
        for (Student s : javaStudents) {
            System.out.println(s);
        }

        System.out.println("-----------");
        // 2. Add the source code so that we can remove Veska from the students
        try {
            if (studentManagement.removeStudent("5")){
                System.out.println("Student was deleted");
            }
        } catch (NonExistingStudentException e) {
            System.out.println("Could not find student by facNumber=" + e.getFacNumber());
            //e.printStackTrace();
        }
        for (Student s : studentManagement.getStudents()) {
            System.out.println(s);
        }

    }
}
