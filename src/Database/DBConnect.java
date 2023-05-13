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
        public static Connection getConnection() throws SQLException{
//        try {
//            Connection connection = null;
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            connection = (Connection) DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ShopSach;user=sa;password=123456;encrypt=false");
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, "Ket noi database thanh cong");
//            return connection;
//        } catch (ClassNotFoundException e) {
//            System.out.println("Error connecting to SQL Server: " + e.getMessage());   
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, "Ket noi database khong thanh cong", e);
//        }       
//        return null;
//        
////        String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=ShopSach;user=sa;password=123456";
////        try {
////            Connection connection = (Connection) DriverManager.getConnection(connectionString);
////            System.out.println("Connected to SQL Server");
////        } catch (SQLException e) {
////            System.out.println("Error connecting to SQL Server: " + e.getMessage());
////        }
////        return null;



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
}
