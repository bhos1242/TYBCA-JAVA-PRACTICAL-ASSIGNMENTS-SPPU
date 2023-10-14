package Assignment_5.SetB;

import java.sql.*;

public class SetB_2 {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:postgresql://localhost:5432/Assignment_5";
        String USERNAME = "postgres";
        String PASSWORD = "root";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Create Course table
            String createTable = "CREATE TABLE IF NOT EXISTS Course (" +
                    "CODE SERIAL PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "department VARCHAR(255), " +
                    "number_of_students INTEGER)";

            PreparedStatement createTableStatement = conn.prepareStatement(createTable);
            createTableStatement.execute();
            System.out.println("Course table created successfully");

            // Insert data into Course table
            String insertTable = "INSERT INTO Course (name, department, number_of_students) VALUES (?, ?, ?)";
            PreparedStatement insertTableStatement = conn.prepareStatement(insertTable);
            insertTableStatement.setString(1, "vivek");
            insertTableStatement.setString(2, "BCA");
            insertTableStatement.setInt(3, 160);
            insertTableStatement.execute();

            insertTableStatement.setString(1, "yuvraj");
            insertTableStatement.setString(2, "BSC");
            insertTableStatement.setInt(3, 180);
            insertTableStatement.execute();

            // Update number_of_students for "BCA Science" to 100
            String updateQuery = "UPDATE Course SET number_of_students = 100 WHERE department = 'BCA'";

            PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Number of students updated for 'BCA'");
            } else {
                System.out.println("No records found for 'BCA'");
            }

            // Retrieve and print data from Course table
            String getData = "SELECT * FROM Course";
            PreparedStatement getDataStatement = conn.prepareStatement(getData);
            ResultSet resultSet = getDataStatement.executeQuery();
            System.out.println("PID\tName\t\tDepartment\tNumber of Students");
            System.out.println("-------------------------------------");
            while (resultSet.next()) {
                int code = resultSet.getInt("CODE");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                int numberOfStudents = resultSet.getInt("number_of_students");
                System.out.printf("%d\t%s\t\t%s\t\t%d\n", code, name, department, numberOfStudents);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
