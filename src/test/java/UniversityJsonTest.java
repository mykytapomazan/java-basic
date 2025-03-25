import model.*;
import org.junit.jupiter.api.Test;
import controller.JsonManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityJsonTest {
    private static final String FILE_PATH = "university.json";

    @Test
    public void testJsonSerialization() {
        University oldUniversity = createSampleUniversity();

        JsonManager.writeUniversityToJson(oldUniversity, FILE_PATH);

        University newUniversity = JsonManager.readUniversityFromJson(FILE_PATH);

        assertEquals(oldUniversity, newUniversity, "Об'єкти університетів мають бути еквівалентні");
    }

    private University createSampleUniversity() {
        Student student1 = new Student("Іван", "Іванов", "Іванович", Sex.MALE, "S1");
        Student student2 = new Student("Марія", "Петренко", "Анатоліївна", Sex.FEMALE, "S2");

        Human groupHead = new Human("Олег", "Коваленко", "Миколайович", Sex.MALE);
        List<Student> students = List.of(student1, student2);
        Group group1 = new Group("Група А", groupHead, students);
        Group group2 = new Group("Група Б", groupHead, students);

        Human departmentHead = new Human("Анна", "Шевченко", "Володимирівна", Sex.FEMALE);
        Department department1 = new Department("Кафедра 1", departmentHead, List.of(group1, group2));
        Department department2 = new Department("Кафедра 2", departmentHead, List.of(group1, group2));

        Human facultyHead = new Human("Олександр", "Гончар", "Сергійович", Sex.MALE);
        Faculty faculty1 = new Faculty("Факультет IT", facultyHead, List.of(department1, department2));
        Faculty faculty2 = new Faculty("Факультет Економіки", facultyHead, List.of(department1, department2));

        Human universityHead = new Human("Олена", "Мороз", "Юріївна", Sex.FEMALE);
        return new University("Дніпровська політехніка", universityHead, List.of(faculty1, faculty2));
    }
}
