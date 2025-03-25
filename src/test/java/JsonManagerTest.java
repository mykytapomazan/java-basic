import controller.*;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonManagerTest {

    private static final String FILE_PATH = "university.json";

    @BeforeEach
    public void setUp() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSerializationAndDeserialization() {
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
        University oldUniversity;
        oldUniversity = UniversityCreator.createUniversity("Дніпровська політехніка", universityHead, faculties);

        JsonManager.writeUniversityToJson(oldUniversity, FILE_PATH);

        University newUniversity = JsonManager.readUniversityFromJson(FILE_PATH);

        assertEquals(oldUniversity, newUniversity, "The universities should be equal after serialization and deserialization.");
    }
}
