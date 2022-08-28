/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagementsystem;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author kalilinux
 */
public  class VideoFrame implements ActionListener{
  public static String downloadLocation=null;
  JButton playButton = null;
  int idofVideo;
  File deviceLocation;
  ArrayList<String> arrayLocation= new ArrayList<>();
  public void videoFetching(){
      
  }
  @SuppressWarnings("null")
  public VideoFrame() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException{
       System.out.println("hello");
       if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user)){
                    UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                }
      try (Statement stmt = UserDatabases.userConnect.createStatement()) {
          System.out.println("hello");
          
          JFrame videoFrame = new JFrame();
          videoFrame.setSize(500,500);
          videoFrame.setLayout(new GridLayout(3,3,2,2));
          videoFrame.setVisible(true);
          
          FileOutputStream fos = null;
//          videoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          String pathImage = "/home/kalilinux/NetBeansProjects/filemanagementsystem/images/playImage.png";
          int count = 1;
           
          ResultSet result = stmt.executeQuery("select * from VideoTable");
          System.out.println("hellodd");
          ImageIcon playImage = new ImageIcon(pathImage);
          System.out.println("hellodd");
          while(result.next()){
              try {
                  System.out.println("hellodd");
                  idofVideo = result.getInt("Video_Id");
                  playButton = new JButton(playImage);
                  playButton.setBorderPainted(true);
                  videoFrame.add(playButton);
                  downloadLocation = "/home/kalilinux/NetBeansProjects/SqlitePractice/videoDownloaded/bb"+count+".mp4";
                  System.out.println("helloddButton");
                  deviceLocation = new File(downloadLocation);
                  fos = new FileOutputStream(deviceLocation);
                  byte[] buffer = new byte[1024];
                  InputStream inpt = result.getBinaryStream("Video_Blob");
                  while(inpt.read(buffer)>0){
                      fos.write(buffer);
                  }}catch(IOException | SQLException e){
                  System.out.println(e.fillInStackTrace());
              }
           arrayLocation.add(downloadLocation);
          
              
              
                  if(idofVideo==1 && arrayLocation.contains(downloadLocation)){
                     playButton.addActionListener((ae) -> {
                     try{
                      Desktop.getDesktop().open(new File(arrayLocation.get(0)));
                  } catch (IOException ex) {
                      Logger.getLogger(VideoFrame.class.getName()).log(Level.SEVERE, null, ex);
                  }
             });
                  }
          
          if(idofVideo==2 && arrayLocation.contains(downloadLocation)){
           playButton.addActionListener((ae) -> {
                  try {
                      Desktop.getDesktop().open(new File(arrayLocation.get(1)));
                  } catch (IOException ex) {
                      Logger.getLogger(VideoFrame.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
          }
                if(idofVideo==3&& arrayLocation.contains(downloadLocation) ){
           playButton.addActionListener((ae) -> {
                  try {
                      Desktop.getDesktop().open(new File(arrayLocation.get(2)));
                  } catch (IOException ex) {
                      Logger.getLogger(VideoFrame.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
          }  
                if(idofVideo==4 && arrayLocation.contains(downloadLocation) ){
           playButton.addActionListener((ae) -> {
                  try {
                      Desktop.getDesktop().open(new File(arrayLocation.get(3)));
                  } catch (IOException ex) {
                      Logger.getLogger(VideoFrame.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
          }
                if(idofVideo==5 && arrayLocation.contains(downloadLocation) ){
           playButton.addActionListener((ae) -> {
                  try {
                      Desktop.getDesktop().open(new File(arrayLocation.get(4)));
                  } catch (IOException ex) {
                      Logger.getLogger(VideoFrame.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
          }
                if(idofVideo==6 && arrayLocation.contains(downloadLocation) ){
           playButton.addActionListener((ae) -> {
                  try {
                      Desktop.getDesktop().open(new File(arrayLocation.get(5)));
                  } catch (IOException ex) {
                      Logger.getLogger(VideoFrame.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
          }
                if(idofVideo==7 && arrayLocation.contains(downloadLocation) ){
           playButton.addActionListener((ae) -> {
                  try {
                      Desktop.getDesktop().open(new File(arrayLocation.get(6)));
                  } catch (IOException ex) {
                      Logger.getLogger(VideoFrame.class.getName()).log(Level.SEVERE, null, ex);
                  }
              });
          }
              
              System.out.println("evnet");
             count++; 
          
          
      }
          videoFrame.revalidate();
               }
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
    
