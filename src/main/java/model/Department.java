package model;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups);
    }

    @Override
    public String toString() {
        return name + " headed by " + head.toString();
    }
}
