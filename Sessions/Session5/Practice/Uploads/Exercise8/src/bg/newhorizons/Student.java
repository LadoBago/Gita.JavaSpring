package bg.newhorizons;

public class Student {

    public static int MAX_STUDENTS = 1000;

    public static int studentsCounter = 0;
    public static final int[] ALL_FAC_NUMBERS = new int[MAX_STUDENTS];

    private int facNumber;
    private String firstName;
    private String lastName;

    public Student(int facNumber, String firstName, String lastName) {
        if (isFacNumberSigned(facNumber)) {
            throw new IllegalArgumentException("Student already exist");
        }

        this.facNumber = facNumber;
        this.firstName = firstName;
        this.lastName = lastName;

        ALL_FAC_NUMBERS[studentsCounter]  = facNumber;
        studentsCounter++;
    }

    private static boolean isFacNumberSigned(int facNumber) {
        for (int num : ALL_FAC_NUMBERS) {
            if (num == facNumber) {
                return true;
            }
        }

        return false;
    }

    public int getFacNumber() {
        return facNumber;
    }

    public void setFacNumber(int facNumber) {
        this.facNumber = facNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "facNumber=" + facNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
