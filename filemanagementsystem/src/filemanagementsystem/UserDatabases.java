/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagementsystem;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author kalilinux
 */
public class UserDatabases {
    public static Connection userConnect = null;
    public static void getConnection(String database_Name) throws ClassNotFoundException, SQLException{
        String databaseURL = "jdbc:sqlite:/home/kalilinux/NetBeansProjects/filemanagementsystem/sqlite-tools-linux-x86-3380100/"+database_Name+".db";
        Class.forName("org.sqlite.JDBC");
         userConnect = DriverManager.getConnection(databaseURL);
        System.out.println("Connection found");
    }
    public static void UserDatabases(String databaseName) throws ClassNotFoundException, SQLException{
        getConnection(databaseName);
        Statement stmt = userConnect.createStatement();
        System.out.println("dtatabase created successfully");
        String sqlVideo = "CREATE TABLE IF NOT EXISTS "
                + "VideoTable"//video table
                + "(Video_Id INTEGER primary key, "
                + "Video_Blob BLOB,"
                + "Video_Name TEXT,Video_Size TEXT,"
                + "Video_Type TEXT);";
               
        String sqlAudio = "CREATE TABLE IF NOT EXISTS AudioTable"
                + "(Audio_Id INTEGER primary key,"
                + "Audio_Blob BLOB,"
                + "Audio_Name TEXT,"
                + "Audio_Size TEXT,"
                + "Audio_Type TEXT);";
        String sqlImage = "CREATE TABLE IF NOT EXISTS ImageTable"
                + "(Image_Id INTEGER primary key,"
                + "Image_Blob BLOB,"
                + "Image_Name TEXT,"
                + "Image_Size TEXT,"
                + "Image_Type TEXT);";
        String sqlPdf = "CREATE TABLE IF NOT EXISTS Documents"
                + "(Pdf_Id INTEGER primary key,"
                + "Pdf_Blob BLOB,"
                + "Pdf_Name TEXT,"
                + "Pdf_Type TEXT,"
                + "Pdf_Size TEXT);";
        stmt.executeUpdate(sqlVideo);
        stmt.executeUpdate(sqlAudio);
        stmt.executeUpdate(sqlPdf);
        stmt.executeUpdate(sqlImage);
        System.out.println("Table Cretaed Successfully");
        
    }
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        UserDatabases("Prahlad786");
//        getConnection("Krishnasahh");
//    }
}
