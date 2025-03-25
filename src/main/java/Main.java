import database.StudentDatabaseManager;
import model.Student;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        StudentDatabaseManager manager = new StudentDatabaseManager();

        int searchMonth = 2;

        List<Student> students = manager.getStudentsByBirthMonth(searchMonth);

        if (students.isEmpty()) {
            System.out.println("Немає студентів, які народились у цьому місяці.");
        } else {
            System.out.println("Студенти, які народились у місяці " + searchMonth + ":");
            for (Student student : students) {
                System.out.println("\t" + student);
            }
        }
    }
}
