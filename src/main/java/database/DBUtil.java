package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/gender_equality_db";
    private static final String USER = "root";
    private static final String PASSWORD = "snowil@1605S";
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(" connection  esatblished ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}