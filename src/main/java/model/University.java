package model;

import java.util.List;

public class University {
    private String name;
    private Human head;
    private List<Faculty> faculties;

    public University(String name, Human head, List<Faculty> faculties) {
        this.name = name;
        this.head = head;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Університет: ").append(name).append(", очолює: ").append(head.toString()).append("\n");
        for (Faculty faculty : faculties) {
            sb.append("  Факультет: ").append(faculty.getName()).append(", очолює: ").append(faculty.getHead().toString()).append("\n");
            for (Department department : faculty.getDepartments()) {
                sb.append("    Кафедра: ").append(department.getName()).append(", очолює: ").append(department.getHead().toString()).append("\n");
                for (Group group : department.getGroups()) {
                    sb.append("      Група: ").append(group.getName()).append(", очолює: ").append(group.getHead().toString()).append("\n");
                    for (Student student : group.getStudents()) {
                        sb.append("        Студент: ").append(student.toString()).append("\n");
                    }
                }
            }
        }
        return sb.toString();
    }
}
