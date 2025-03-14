import controller.*;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human rector = new Human("Іван", "Петрович", "Сидоров", Sex.MALE) {
        };

        Human dean = new Human("Марія", "Іванівна", "Коваль", Sex.FEMALE) {
        };
        Department department = DepartmentCreator.createDepartment("Програмування", dean);

        List<Department> departments = new ArrayList<>();
        departments.add(department);

        Faculty faculty = FacultyCreator.createFaculty("ІТ", dean, departments);

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty);

        University university = UniversityCreator.createUniversity("Дніпровська політехніка", rector, faculties);

        System.out.println(university);
    }
}
