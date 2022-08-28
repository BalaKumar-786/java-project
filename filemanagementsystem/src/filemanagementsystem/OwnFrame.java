/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanagementsystem;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kalilinux
 */
public class OwnFrame implements ActionListener{
  public static ImageIcon img = null;
    public static ResultSet result;
    public static JButton btn;
    public OwnFrame() throws ClassNotFoundException, SQLException{
        if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user)){
                    UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                }
    }
    public void imageView() throws ClassNotFoundException, SQLException {
        JLabel label1 = new JLabel("hhhhh");
         if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user)){
                    UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                }
        int id = 0;
      
        try {
            Statement stmt  = UserDatabases.userConnect.createStatement();
            
             result = stmt.executeQuery("select * from ImageTable");
            System.out.println("above while");
        JFrame frame = new JFrame("hello Frame");
        frame.setLayout(new GridLayout(2, 2, 2, 2));
        while(result.next()){
            id = result.getInt("Image_Id");
                byte[] images = result.getBytes("Image_Blob");
                System.out.println("images"+images.length+"  "+id+"  ");
                img = new ImageIcon(images);
                System.out.println("imageIcon"+img);
                frame.add(btn = new JButton(img));
                if(id==1){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
                if(id==2){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }if(id==3){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
        if(id==4){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
        if(id==5){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
        if(id==6){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
        if(id==7){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
        if(id==8){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
        if(id==9){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
        if(id==10){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
        if(id==11){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }if(id==12){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }if(id==13){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }if(id==14){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }if(id==15){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }if(id==16){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }if(id==17){
                    byte[] imagess = result.getBytes("Image_Blob");
                    ImageIcon imgs = new ImageIcon(imagess);
                btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                JFrame gr = new JFrame();
                gr.add(new JLabel(imgs));
                gr.setSize(300,300);
                gr.setVisible(true);
                }
        });
        }
        }
        
        frame.setSize(500, 500);
        frame.setVisible(true);
        
    }catch(HeadlessException | SQLException e){
            System.out.println(e.fillInStackTrace());
    }
    
    
}
  JLabel label = new JLabel("helloooo");

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
   
}