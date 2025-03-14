package model;

import java.util.List;

public class University {
    private String name;
    private Human rector;
    private List<Faculty> faculties;

    public University(String name, Human rector, List<Faculty> faculties) {
        this.name = name;
        this.rector = rector;
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Університет: ").append(name).append("\n");
        sb.append("Ректор: ").append(rector.getFullName()).append("\n");
        sb.append("Факультети:\n");
        for (Faculty faculty : faculties) {
            sb.append(faculty).append("\n");
        }
        return sb.toString();
    }
}
