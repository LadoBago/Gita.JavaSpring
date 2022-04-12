package bg.newhorizons.students;

public class NonExistingStudentException extends Exception {
    private String facNumber;

    public NonExistingStudentException(String facNumber) {
        this.facNumber = facNumber;
    }

    public String getFacNumber() {
        return facNumber;
    }
}

