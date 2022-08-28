/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagementsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author kalilinux
 */
public class RecentsUploads {
     
    public static Icon fetchRecents1() throws ClassNotFoundException, SQLException{
         ArrayList<byte[]> list = new ArrayList<>();
        DatabaseConnection.DatabaseConnection();
        Statement stmt = DatabaseConnection.connection.createStatement();
        ResultSet result = stmt.executeQuery("select * from ImageTable");
        byte[] blob = null;
        while(result.next()){
            blob =  result.getBytes("Image_Blob");
            list.add(blob);
        }

       System.out.println("leghth  "+list.size());
        System.out.println("last Element  "+Arrays.toString(list.get(list.size()-1)));
        byte[] imageByte1 = list.get(list.size()-1);
        byte[] imageByte2 = list.get(list.size()-2);
        Icon image1 = new ImageIcon(imageByte1);
        Icon image2 = new ImageIcon(imageByte2);
        return image1;
     
    }   
    
    public static Icon fetchRecents2() throws ClassNotFoundException, SQLException{
         ArrayList<byte[]> list = new ArrayList<>();
        DatabaseConnection.DatabaseConnection();
        Statement stmt = DatabaseConnection.connection.createStatement();
        ResultSet result = stmt.executeQuery("select * from ImageTable");
        byte[] blob = null;
        while(result.next()){
            blob =  result.getBytes("Image_Blob");
            list.add(blob);
        }

       System.out.println("leghth  "+list.size());
        System.out.println("last Element  "+Arrays.toString(list.get(list.size()-1)));
        
        byte[] imageByte2 = list.get(list.size()-2);
       
        Icon image2 = new ImageIcon(imageByte2);
        return image2;
     
    }
    public static Icon fetchRecents3() throws ClassNotFoundException, SQLException{
         ArrayList<byte[]> list = new ArrayList<>();
        DatabaseConnection.DatabaseConnection();
        Statement stmt = DatabaseConnection.connection.createStatement();
        ResultSet result = stmt.executeQuery("select * from ImageTable");
        byte[] blob = null;
        while(result.next()){
            blob =  result.getBytes("Image_Blob");
            list.add(blob);
        }

       System.out.println("leghth  "+list.size());
        System.out.println("last Element  "+Arrays.toString(list.get(list.size()-1)));
        
        byte[] imageByte3 = list.get(list.size()-3);
       
        Icon image3 = new ImageIcon(imageByte3);
        return image3;
     
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        System.out.println(RecentsUploads.fetchRecents1());
    }
    
    }
