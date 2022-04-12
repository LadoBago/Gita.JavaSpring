package bg.newhorizons.inheritance;

public class Human {
    private String firstName;
    private String lastName;
    private String uniqueNumber;

    public Human(String firstName, String lastName, String uniqueNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uniqueNumber = uniqueNumber;
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

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }
}
