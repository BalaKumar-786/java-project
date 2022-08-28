/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagementsystem;

import java.sql.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 *
 * @author kalilinux
 */
public class WritingBlobData {
        
    DatabaseConnection connect = null;

    public WritingBlobData() throws ClassNotFoundException, SQLException {
        DatabaseConnection.DatabaseConnection();
    }
    
        private byte[] readFile(String file) throws IOException {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
           
    }
        public void downloadFile(int fileId, String downloadLocation) throws SQLException, FileNotFoundException, IOException{
            String downloadQuery = "select Video_Blob from VideoTable where Video_Id=?";
            PreparedStatement preDownload = DatabaseConnection.connection.prepareStatement(downloadQuery);
            preDownload.setInt(1, fileId);
            ResultSet res = preDownload.executeQuery();
            File deviceLocation = new File(downloadLocation);
            FileOutputStream fos = new FileOutputStream(deviceLocation);
            byte[] buffer = new byte[1024];
            while(res.next()){
                InputStream inpt = res.getBinaryStream("Video_Blob");
                while(inpt.read(buffer)>0){
                    fos.write(buffer);
                }
            }
        }
        
     public void updatePicture(int imageId, String filename) throws IOException {
        // update sql
        String updateSQL = "UPDATE ImageTable "
                + "SET Image_Blob = ? "
                + "WHERE Img_Id=?";

        try ( PreparedStatement pstmt = DatabaseConnection.connection.prepareStatement(updateSQL)) {

            // set parameters
            pstmt.setBytes(1, readFile(filename));
            pstmt.setInt(2, imageId);
            
            pstmt.executeUpdate();
            System.out.println("Stored the file in the BLOB column.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

     public void uploadVideo(String filenamevideo) throws IOException, SQLException{
         String insertVideo = "insert into VideoTable(Video_Blob) values (?)";
         PreparedStatement videostmt = DatabaseConnection.connection.prepareStatement(insertVideo);
         videostmt.setBytes(1, readFile(filenamevideo));
         videostmt.executeUpdate();
     }
     
        public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
           WritingBlobData blob = new WritingBlobData();
          /* blob.uploadVideo("/home/kalilinux/NetBeansProjects/filemanagementsystem/videos/minion360.mp4");
            System.out.println("inserted");
            */
//          blob.updatePicture(5, "/home/kalilinux/NetBeansProjects/filemanagementsystem/images/stupid.jpg");
        
//          blob.downloadFile(2, "/home/kalilinux/NetBeansProjects/filemanagementsystem/downloadedFromDBMS/dd.mp4");
            
                  }
}
