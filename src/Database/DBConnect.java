/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quocd
 */
public class DBConnect {

    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=MANAGER_STUDENT;encrypt=false";
        String username = "sa";
        String password = "123456";
        
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to database!");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Closed to database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
