package model;

import java.util.List;

public class Faculty {
    private String name;
    private Human dean;
    private List<Department> departments;

    public Faculty(String name, Human dean, List<Department> departments) {
        this.name = name;
        this.dean = dean;
        this.departments = departments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  Факультет: ").append(name).append("\n");
        sb.append("  Декан: ").append(dean.getFullName()).append("\n");
        sb.append("  Кафедри:\n");
        for (Department department : departments) {
            sb.append(department).append("\n");
        }
        return sb.toString();
    }
}
