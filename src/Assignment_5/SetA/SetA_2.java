package Assignment_5.SetA;
//Write a program to display information about the ResultSet like number of columns available
//        in the ResultSet and SQL type of the column. Use Person table. (Use ResultSetMetaData).

import javax.xml.transform.Result;
import java.sql.*;

public class SetA_2 {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:postgresql://localhost:5432/Assignment_5";
        String UserName = "postgres";
        String Password = "root";

        try(Connection conn = DriverManager.getConnection(JDBC_URL,UserName,Password)){
            String query = "SELECT * from Person";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int columnCount = resultSetMetaData.getColumnCount();
            System.out.println("Number of columns in resultSet is:"+columnCount);

            //Column Information
            System.out.println("Column Information:");
            for(int i=1;i<=columnCount;i++){
                String columnName = resultSetMetaData.getColumnName(i);
                String columnType = resultSetMetaData.getColumnTypeName(i);
                System.out.println("Column " + i + ": Name=" + columnName + ", SQL Type=" + columnType);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
