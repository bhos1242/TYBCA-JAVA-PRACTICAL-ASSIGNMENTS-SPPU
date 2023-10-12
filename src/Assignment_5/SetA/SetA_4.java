package Assignment_5.SetA;
import java.sql.*;
import java.util.*;
//4. Write a JDBC program to insert the records into the table Employee(ID,name,salary) using
//        PreparedStatement interface. Accept details of Employees from user.

public class SetA_4 {
    public static void main(String[] args) {
        String JDBC_URL = "jdbc:postgresql://localhost:5432/Assignment_5";
        String USERNAME = "postgres";
        String PASSWORD = "root";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Create Employee table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Employee (ID INT PRIMARY KEY, name VARCHAR(255), salary DOUBLE PRECISION)";
            PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL);
            createTableStatement.execute();

            // Insert data into Employee table
            String insertDataSQL = "INSERT INTO Employee (ID, name, salary) VALUES (?, ?, ?)";
            PreparedStatement insertDataStatement = connection.prepareStatement(insertDataSQL);
            insertDataStatement.setInt(1, id);
            insertDataStatement.setString(2, name);
            insertDataStatement.setDouble(3, salary);

            // Execute the insert statement
            int rowsAffected = insertDataStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee record inserted successfully!");
            } else {
                System.out.println("Failed to insert employee record.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
