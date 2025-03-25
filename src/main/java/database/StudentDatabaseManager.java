package database;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabaseManager {

    public List<Student> getStudentsByBirthMonth(int month) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT last_name, first_name, middle_name, birth_date, record_book_number " +
                "FROM students WHERE EXTRACT(MONTH FROM birth_date) = ?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, month);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String middleName = resultSet.getString("middle_name");
                String birthDate = resultSet.getString("birth_date");
                String recordBookNumber = resultSet.getString("record_book_number");

                students.add(new Student(lastName, firstName, middleName, birthDate, recordBookNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
