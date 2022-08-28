/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagementsystem;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kalilinux
 */
public class DatabaseConnection {
// public static Statement stmtForUserLogin;
 public static Connection connection;
// public static Connection connectionMysql;
    public static void DatabaseConnection() throws ClassNotFoundException, SQLException {
        //      Database Connection Establishing
//        String dbConnectionMSQL = "jdbc:mysql://localhost:3306/filemanagementsystemmysql";
        String dbLocationsqlite = "jdbc:sqlite:/home/kalilinux/NetBeansProjects/filemanagementsystem/sqlite-tools-linux-x86-3380100/sqlitetools/FileDBMS.db";
        try {
            Class.forName("org.sqlite.JDBC");
//            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbLocationsqlite);
//            connectionMysql = DriverManager.getConnection(dbConnectionMSQL,"root","");
        System.out.println("connection");
        /*
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM UserLogin");
        result.getRow();
         System.out.println(result.getString("User_Name"));
        
       */
   
    }catch (ClassNotFoundException ex) {
            Logger.getLogger(Filemanagementsystem.class.getName()).log(Level.SEVERE, null, ex);
    
}}
    
    
   
   
}
