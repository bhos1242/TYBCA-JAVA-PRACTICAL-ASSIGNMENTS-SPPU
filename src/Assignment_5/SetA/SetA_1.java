package Assignment_5.SetA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SetA_1 {



        public static void main (String[]args){
            final String JDBC_URL = "jdbc:postgresql://localhost:5432/Assignment_5";
            final String USERNAME = "postgres";
            final String PASSWORD = "root";
            // Establishing the connection
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                // Creating the Person table
                String createTableSQL = "CREATE TABLE IF NOT EXISTS Person (PID SERIAL PRIMARY KEY, name VARCHAR(255), gender VARCHAR(10), birth_year INTEGER)";
                PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL);
                createTableStatement.execute();

                // Inserting values into the Person table
                String insertDataSQL = "INSERT INTO Person (name, gender, birth_year) VALUES (?, ?, ?)";
                PreparedStatement insertDataStatement = connection.prepareStatement(insertDataSQL);
                insertDataStatement.setString(1, "vivek b");
                insertDataStatement.setString(2, "Male");
                insertDataStatement.setInt(3, 2002);
                insertDataStatement.executeUpdate();

                insertDataStatement.setString(1, "Yuvraj k");
                insertDataStatement.setString(2, "Male");
                insertDataStatement.setInt(3, 2001);
                insertDataStatement.executeUpdate();

                insertDataStatement.setString(1, "Raj A");
                insertDataStatement.setString(2, "Male");
                insertDataStatement.setInt(3, 2003);
                insertDataStatement.executeUpdate();

                // Retrieving and displaying data from the Person table
                String retrieveDataSQL = "SELECT * FROM Person";
                PreparedStatement retrieveDataStatement = connection.prepareStatement(retrieveDataSQL);
                ResultSet resultSet = retrieveDataStatement.executeQuery();

                System.out.println("PID\tName\t\tGender\tBirth Year");
                System.out.println("-------------------------------------");
                while (resultSet.next()) {
                    int pid = resultSet.getInt("PID");
                    String name = resultSet.getString("name");
                    String gender = resultSet.getString("gender");
                    int birthYear = resultSet.getInt("birth_year");
                    System.out.println(pid + "\t" + name + "\t\t" + gender + "\t" + birthYear);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
