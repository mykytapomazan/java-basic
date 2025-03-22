import model.*;
import controller.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(StudentCreator.createStudent("Микита", "Помазан", "Максимович", Sex.MALE, "1"));
        students.add(StudentCreator.createStudent("Марія", "Петренко", "Анатоліївна", Sex.FEMALE, "2"));

        Human departmentHead = new Human("Михаїл", "Джонсон", "Якович", Sex.MALE);

        List<Group> groups = new ArrayList<>();
        groups.add(GroupCreator.createGroup("Група А", departmentHead, students));

        List<Department> departments = new ArrayList<>();
        departments.add(new Department("Комп'ютерні науки", departmentHead, groups));

        Human facultyHead = new Human("Олена", "Шевченко", "Іванівна", Sex.FEMALE);
        List<Faculty> faculties = new ArrayList<>();
        faculties.add(FacultyCreator.createFaculty("ІТ", facultyHead, departments));

        Human universityHead = new Human("Оксана", "Коваленко", "Миколаївна", Sex.FEMALE);
        University university = UniversityCreator.createUniversity("Дніпровська політехніка", universityHead, faculties);

        System.out.println(university);
    }
}
