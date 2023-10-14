package Assignment_5.SetB;

import java.sql.*;
import java.util.Scanner;

public class SetB_3 {
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/Assignment_5";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            System.out.println("Connected to the database");
            String createTable = "CREATE TABLE IF NOT EXISTS District (" +
                    "Name VARCHAR(255) PRIMARY KEY, " +
                    "Area DOUBLE PRECISION, " +
                    "Population BIGINT)";
            PreparedStatement createTableStatement = conn.prepareStatement(createTable);
            createTableStatement.execute();
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Insert");
                System.out.println("2. Modify");
                System.out.println("3. Delete");
                System.out.println("4. Search");
                System.out.println("5. View All");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertDistrict(conn);
                        break;
                    case 2:
                        modifyDistrict(conn);
                        break;
                    case 3:
                        deleteDistrict(conn);
                        break;
                    case 4:
                        searchDistrict(conn);
                        break;
                    case 5:
                        viewAllDistricts(conn);
                        break;
                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 6);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void insertDistrict(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter district name: ");
        String name = scanner.nextLine();
        System.out.print("Enter district area: ");
        double area = scanner.nextDouble();
        System.out.print("Enter district population: ");
        long population = scanner.nextLong();

        String insertQuery = "INSERT INTO District (Name, Area, Population) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, area);
            preparedStatement.setLong(3, population);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("District inserted successfully.");
            } else {
                System.out.println("Failed to insert district.");
            }
        }
    }

    static void modifyDistrict(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter district name to modify: ");
        String name = scanner.nextLine();
        System.out.print("Enter new area: ");
        double area = scanner.nextDouble();
        System.out.print("Enter new population: ");
        long population = scanner.nextLong();

        String updateQuery = "UPDATE District SET Area = ?, Population = ? WHERE Name = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, area);
            preparedStatement.setLong(2, population);
            preparedStatement.setString(3, name);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("District modified successfully.");
            } else {
                System.out.println("District not found.");
            }
        }
    }

    static void deleteDistrict(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter district name to delete: ");
        String name = scanner.nextLine();

        String deleteQuery = "DELETE FROM District WHERE Name = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
            preparedStatement.setString(1, name);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("District deleted successfully.");
            } else {
                System.out.println("District not found.");
            }
        }
    }

    static void searchDistrict(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter district name to search: ");
        String name = scanner.nextLine();

        String searchQuery = "SELECT * FROM District WHERE Name = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(searchQuery)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("District found:");
                System.out.println("Name: " + resultSet.getString("Name"));
                System.out.println("Area: " + resultSet.getDouble("Area"));
                System.out.println("Population: " + resultSet.getLong("Population"));
            } else {
                System.out.println("District not found.");
            }
        }
    }

    static void viewAllDistricts(Connection conn) throws SQLException {
        String viewAllQuery = "SELECT * FROM District";
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(viewAllQuery)) {
            System.out.println("All Districts:");
            System.out.println("Name\tArea\tPopulation");
            System.out.println("---------------------------");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Name") + "\t" +
                        resultSet.getDouble("Area") + "\t" +
                        resultSet.getLong("Population"));
            }
        }
    }
}

