package model;

import java.util.List;

public class Department {
    private String name;
    private Human head;
    private List<Group> groups;

    public Department(String name, Human head, List<Group> groups) {
        this.name = name;
        this.head = head;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return name + " headed by " + head.toString();
    }
}
