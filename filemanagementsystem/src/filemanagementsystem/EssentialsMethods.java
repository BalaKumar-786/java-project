/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagementsystem;

import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author kalilinux
 */
public class EssentialsMethods {
        public static String generateRandomNumbers(){
           String random = String.valueOf((int)Math.floor(Math.random()*1000)) ;
            return random;
        }
        public static void updateUserInfo(String phoneNumbers, String userName, String password) throws ClassNotFoundException, SQLException{
            DatabaseConnection.DatabaseConnection();
            String updateInfo = "update UserLogin set User_Name = ?, Password = ? where Phone_Numbers = "+phoneNumbers;
            String selectAllInfo = "select Phone_Numbers from UserLogin";
            PreparedStatement stmt = DatabaseConnection.connection.prepareStatement(selectAllInfo);
            ResultSet result = stmt.executeQuery();
            String phoneNumber = null;
            while(result.next()){
                 phoneNumber = result.getString("Phone_Numbers");
//                System.out.println(phoneNumber);
                if(phoneNumber.equals(phoneNumbers)){
                    PreparedStatement stmtforSelect = DatabaseConnection.connection.prepareStatement(updateInfo);
                    stmtforSelect.setString(1, userName);
                    stmtforSelect.setString(2, password);
                    stmtforSelect.executeUpdate();
                    System.out.println("Updated successfully");
                    break;
                }else{
                    System.out.println("no records found");
                    
                }}
           
        }
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        EssentialsMethods randomNums = new EssentialsMethods();
//        EssentialsMethods.generateRandomNumbers();
//            System.out.println(EssentialsMethods.generateRandomNumbers());
//            EssentialsMethods.updateUserInfo("9812452155", "Ram", "Pothinenihari");
    }
}
