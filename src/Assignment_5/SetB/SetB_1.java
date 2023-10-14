package Assignment_5.SetB;

import java.sql.*;

public class SetB_1 {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:postgresql://localhost:5432/Assignment_5";
        String USERNAME = "postgres";
        String PASSWORD = "root";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
//            String createTable = "CREATE TABLE Person1 (\n" +
//                    "    id SERIAL PRIMARY KEY,\n" +
//                    "    name VARCHAR(255) NOT NULL,\n" +
//                    "    gender VARCHAR(10) NOT NULL,\n" +
//                    "    birthdate DATE NOT NULL\n" +
//                    ")";
//            PreparedStatement preparedStatement = conn.prepareStatement(createTable);
//            preparedStatement.execute();
//            System.out.println("Person table created successfully.");

//            String insertData = "INSERT INTO Person1 (name, gender, birthdate)\n" +
//                    "VALUES ('Alice', 'female', '1986-05-15'),\n" +
//                    "       ('Bob', 'male', '1986-08-22'),\n" +
//                    "       ('Charlie', 'male', '1995-03-10'),\n" +
//                    "       ('Diana', 'female', '2002-02-05'),\n" +
//                    "       ('Eva', 'female', '2004-11-18'),\n" +
//                    "       ('Frank', 'male', '2001-07-30')";
//            PreparedStatement insertDataStatement = conn.prepareStatement(insertData);
//            insertDataStatement.execute();
//            System.out.println("Data inserted successfully");

            // Search persons born in 1986
            String query1 = "SELECT * FROM Person1 WHERE EXTRACT(YEAR FROM birthdate) = 1986";
            PreparedStatement statement = conn.prepareStatement(query1);
            ResultSet resultSet1 = statement.executeQuery();
            System.out.println("Persons born in 1986:");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("name"));
            }

            String query2 = "SELECT * FROM Person WHERE EXTRACT(YEAR FROM birthdate) BETWEEN 2000 AND 2005 AND gender = 'female'";
            PreparedStatement statement2 = conn.prepareStatement(query2);
            ResultSet resultSet2 = statement2.executeQuery();
            System.out.println("Females born between 2000-2005:");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
