package bg.newhorizons.students;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentManagementImpl implements StudentManagement {

    // Change me to Set
    private Set<Student> students = new HashSet<>();

    // return all students from a course
    // Use Predicate here to return only the students from the specified course
    @Override
    public Set<Student> getStudentsByCourse(String course) {
        Predicate<Student> courseListenerPredicate = s -> s.getCourse() != null && s.getCourse().equals(course);
        return students.stream().filter(courseListenerPredicate).collect(Collectors.toSet());
    }

    // add a new Student
    // if there is a Student with same fac number, return null
    @Override
    public Student addStudent(String facNumber, String name, String course)
    {
        if (facNumber == null){
            throw new IllegalArgumentException("facNumber");
        }
        Student student = new Student(name, course, facNumber);
        if (students.contains(student))
            return null;

        students.add(student);
        return student;
    }

    //Removes student with facNumber being passed
    // throws NonExistingStudentException if Student with facNumber does not exist
    @Override
    public boolean removeStudent(String facNumber) throws NonExistingStudentException {
        Student student = new Student("name", "course", facNumber);
        if (!students.contains(student))
        {
            throw new NonExistingStudentException();
        }

        students.remove(student);
        return true;
    }
}
