package controller;

import model.University;
import model.Human;
import model.Faculty;
import java.util.List;

public class UniversityCreator {
    public static University createUniversity(String name, Human rector, List<Faculty> faculties) {
        return new University(name, rector, faculties);
    }
}
