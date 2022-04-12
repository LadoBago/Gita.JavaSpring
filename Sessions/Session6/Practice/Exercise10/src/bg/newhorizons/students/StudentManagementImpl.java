package bg.newhorizons.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentManagementImpl implements StudentManagement {

    private List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getStudents() {
        return students;
    }

    // return all students from a course
    // Use Predicate here to return only the students from the specified course
    @Override
    public List<Student> getStudentsByCourse(String course) {
        return students.stream().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getCourse().equals(course);
            }
        }).collect(Collectors.toList());
    }

    // add a new Student
    // if there is a Student with same fac number, return null
    // Use Predicate to find if there is a user with facNumber or not
    @Override
    public Student addStudent(String facNumber, String name, String course) {
        if (getStudentByFac(facNumber).isPresent())
            return null;
        Student student = new Student(name, course, facNumber);
        this.students.add(student);
        return  student;
    }

    //Removes student with facNumber being passed
    @Override
    public boolean removeStudent(String facNumber) throws NonExistingStudentException {
        Optional<Student> student = getStudentByFac(facNumber);
        if (student.isEmpty())
            throw new NonExistingStudentException(facNumber);

        return this.students.remove(student.get());
    }

    private Optional<Student> getStudentByFac(String facNumber){
        return this.students.stream()
                .filter(s -> s != null && s.getFacNumber() != null && s.getFacNumber().equals(facNumber))
                .findFirst();
    }
}
