package controller;

import model.Sex;
import model.Student;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Sex gender) {
        return new Student(firstName, lastName, middleName, gender);
    }
}
