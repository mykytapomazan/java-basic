package controller;

import model.Group;
import model.Human;
import model.Student;

import java.util.List;

public class GroupCreator {
    public static Group createGroup(String name, Human head, List<Student> students) {
        return new Group(name, head, students);
    }
}
