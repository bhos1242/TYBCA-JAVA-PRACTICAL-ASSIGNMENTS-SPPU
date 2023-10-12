package Assignment_5.SetA;

import java.sql.*;

//3. Write a JDBC program to display all the countries located in West Region. Create a table
//        Country in PostgreSQL with fields (Name, continent, Capital,Region). Insert values in the
//        table
public class SetA_3 {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:postgresql://localhost:5432/Assignment_5";
        String USERNAME = "postgres";
        String PASSWORD = "root";

        try(Connection conn = DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD)){
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Country(Name VARCHAR(255),continent VARCHAR(255),Capital VARCHAR(255),Region VARCHAR(255))";

            PreparedStatement createTableStatement = conn.prepareStatement(createTableSQL);
            createTableStatement.execute();

            String insertTableSQL = "INSERT INTO Country(Name,continent,Capital,Region) VALUES(?,?,?,?)";
            PreparedStatement insertTableStatement = conn.prepareStatement(insertTableSQL);
            insertTableStatement.setString(1,"America");
            insertTableStatement.setString(2,"Europe");
            insertTableStatement.setString(3,"Washington");
            insertTableStatement.setString(4,"Western");

            insertTableStatement.executeUpdate();


            String retrieveDataSQL = "SELECT * FROM Country";

            PreparedStatement retrieveDataStatement = conn.prepareStatement(retrieveDataSQL);
            ResultSet resultSet =  retrieveDataStatement.executeQuery();

            System.out.println("Name\tcontinent\tCapital\tRegion");
            System.out.println("----------------------------------");
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String continent = resultSet.getString("continent");
                String capital = resultSet.getString("Capital");
                String region = resultSet.getString("Region");
                System.out.println(name + "\t" + continent + "\t"+ capital + "\t"+ region);
            }


        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
