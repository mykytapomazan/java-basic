package model;

public class Department {
    private String name;
    private Human head;

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    @Override
    public String toString() {
        return "    Кафедра: " + name + ", Завідувач: " + head.getFullName();
    }
}
