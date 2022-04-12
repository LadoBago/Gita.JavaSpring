package bg.newhorizons;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ScannerStudents {

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        Student student1 = new Student(323, "Gio", "LastName");
        Student student2 = new Student(434, "Joley", "LastName");
        Student student3 = new Student(656, "Ani", "LastName");

        Student[] students = new Student[3];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        System.out.println(students[1].getFirstName());
        student2.setFirstName("Peter");
        System.out.println(students[1].getFirstName());



        // 1. Create 3 students
        // 2. Create an array of students with len of 3
        // 3. Assign the  new crated instances of Student into this array
        // 4. implement the method sortStudentsByFacNumber which sorts the students by fac number
        // 5. call that method using your array of student and sort the students
        // 6. implement the method print
        // 7. call print method and print the students

        sortStudentsByFacNumber(students);
        print(students);
    }

    public static Student readStudent() {
        // do a check if the fac number is already assign to a student.
        // In this case print an error message and invite the user to enter again the fac number
        // Hint: which loop structure will use here ?
        int facNumber;
        boolean facNumberIsAlreadyTaken;
        do {
            facNumberIsAlreadyTaken = false;
            System.out.println("Enter fac number: ");
            facNumber = reader.nextInt();
            for (int f: Student.ALL_FAC_NUMBERS) {

                if (facNumber == f) {
                    facNumberIsAlreadyTaken = true;
                    break;
                }
            }
        } while (facNumberIsAlreadyTaken);

        System.out.println("Enter first name");
        String firstName = reader.nextLine();
        System.out.println("Enter last name");
        String lastName = reader.nextLine();

        return new Student(facNumber, firstName, lastName);
    }

    // 4. sort the students by Fac Number
    public static void sortStudentsByFacNumber(Student[] students) {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getFacNumber(), o2.getFacNumber());
            }
        });
    }

    // 7. print the whole information about each student
    public static void print(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
