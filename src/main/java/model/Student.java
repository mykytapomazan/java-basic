package model;

import java.util.Objects;

public class Student {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String recordBookNumber;

    public Student(String lastName, String firstName, String middleName, String birthDate, String recordBookNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + ", Народився: " + birthDate + ", Номер студента: " + recordBookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(lastName, student.lastName) && Objects.equals(firstName, student.firstName) &&
                Objects.equals(middleName, student.middleName) && Objects.equals(birthDate, student.birthDate) &&
                Objects.equals(recordBookNumber, student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, birthDate, recordBookNumber);
    }
}
