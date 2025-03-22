package controller;

import model.Student;
import model.Sex;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Sex sex, String studentId) {
        return new Student(firstName, lastName, middleName, sex, studentId);
    }
}
