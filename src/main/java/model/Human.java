package model;

public abstract class Human {
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected Sex gender;

    public Human(String firstName, String lastName, String middleName, Sex gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
}
