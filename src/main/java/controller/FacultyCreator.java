package controller;

import model.Faculty;
import model.Human;
import model.Department;
import java.util.List;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human dean, List<Department> departments) {
        return new Faculty(name, dean, departments);
    }
}
