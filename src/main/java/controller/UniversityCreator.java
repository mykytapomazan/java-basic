package controller;

import model.University;
import model.Human;
import model.Faculty;

import java.util.List;

public class UniversityCreator {
    public static University createUniversity(String name, Human head, List<Faculty> faculties) {
        return new University(name, head, faculties);
    }
}
