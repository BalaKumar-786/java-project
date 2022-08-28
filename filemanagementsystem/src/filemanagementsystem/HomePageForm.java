/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package filemanagementsystem;

import filemanagementsystem.UI.UseableFrame;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author kalilinux
 */
public class HomePageForm extends javax.swing.JFrame {
    String path;
    UploadedFiles upload = new UploadedFiles();
    /**
     * Creates new form HomePageForm
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public HomePageForm() throws ClassNotFoundException, SQLException {
        initComponents();
        DatabaseConnection.DatabaseConnection();
//        if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
//                     UserDatabases.getConnection(UserLoginForm_Index_Page.username);
//                 }
           if(!RecentsUploads.fetchRecents1().equals("")){
            panelView1.setIcon(RecentsUploads.fetchRecents1());
            
            panelView2.setIcon(RecentsUploads.fetchRecents2());
            panelView3.setIcon(RecentsUploads.fetchRecents3());
            
            if(panelView1.getIcon() != null){
                System.out.println(panelView1.getIcon());
            panelView1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
//                    super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                  if(panelView1.getIcon() != null){
                      UseableFrame rphoto  = new UseableFrame();
                      rphoto.setVisible(rootPaneCheckingEnabled);
                  }else{
                      
                  }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }
       
            });
            }
            panelView2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                try {
                    if(panelView2.getIcon() != null){
                    UseableFrame rphoto  = new UseableFrame();
                    rphoto.photoFrame1();
                    rphoto.setVisible(rootPaneCheckingEnabled);
                    }else{
                        panelView2.setText("No Contents Yet");
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            });
            panelView3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                try {
                    if(panelView3.getIcon() != null){
                    UseableFrame rphoto  = new UseableFrame();
                    rphoto.photoFrame2();
                    rphoto.setVisible(rootPaneCheckingEnabled);
                    }else{
                        
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            });
            
    }else{
               recentsUploadsPanel.add(new Label("No Contents Yet..."));
           }
    }
    
    private static byte[] readFile(String file) throws IOException {
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
     private static void uploadVideo(String filenamevideo) throws IOException, SQLException{
         String insertVideo = "insert into VideoTable(Video_Blob) values (?)";
//         PreparedStatement videostmt = DatabaseConnection.connection.prepareStatement(insertVideo);
         PreparedStatement videostmtforUser = UserDatabases.userConnect.prepareStatement(insertVideo);
         videostmtforUser.setBytes(1, readFile(filenamevideo));
         videostmtforUser.executeUpdate();
            System.out.println("uploaded");
     }
     private static void uploadImage(String filenamevideo) throws IOException, SQLException{
         String insertImage = "insert into ImageTable(Image_Blob) values (?)";
//         PreparedStatement videostmt = DatabaseConnection.connection.prepareStatement(insertVideo);
         PreparedStatement imageStmt = UserDatabases.userConnect.prepareStatement(insertImage);
         imageStmt.setBytes(1, readFile(filenamevideo));
         imageStmt.executeUpdate();
            System.out.println("uploaded");
     }
     private static void uploadAudio(String audioFile) throws SQLException, IOException{
         String insertAudio = "insert into AudioTable(Audio_Blob) values (?)";
         PreparedStatement audioStmt = UserDatabases.userConnect.prepareStatement(insertAudio);
         audioStmt.setBytes(1, readFile(audioFile));
         audioStmt.executeUpdate();
         System.out.println("Audio Uploaded");
     }
     private static void uploadDocuments(String pdfFiles) throws IOException, SQLException{
         String insertPdf = "insert into Documents(Pdf_Blob) values (?)";
         PreparedStatement pdfStmt = UserDatabases.userConnect.prepareStatement(insertPdf);
         pdfStmt.setBytes(1, readFile(pdfFiles));
         pdfStmt.executeUpdate();
         System.out.println("Pdf Files Are Uploaded");
     }
     private static void uploadTextFiles(String textFiles) throws SQLException, IOException{
         String insertText = "insert into TextTable (Text_Blob) values (?)";
         PreparedStatement textStmt = UserDatabases.userConnect.prepareStatement(insertText);
         textStmt.setBytes(1, readFile(textFiles));
         textStmt.executeUpdate();
         System.out.println("text file is uploaded");
     }
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dropOn = new javax.swing.JLabel();
        uPloadButton = new javax.swing.JButton();
        recentsUploadsPanel = new javax.swing.JPanel();
        panelView1 = new javax.swing.JLabel();
        panelView2 = new javax.swing.JLabel();
        panelView3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        searchBar = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(java.awt.Color.magenta);
        jPanel2.setFocusCycleRoot(true);

        dropOn.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.disabledShadow"));
        dropOn.setFont(new java.awt.Font("FreeSerif", 1, 24)); // NOI18N
        dropOn.setText("DropONN");

        uPloadButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        uPloadButton.setText("Upload");
        uPloadButton.setFocusable(false);
        uPloadButton.setVerifyInputWhenFocusTarget(false);
        uPloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uPloadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dropOn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 443, Short.MAX_VALUE)
                .addComponent(uPloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropOn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uPloadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );

        recentsUploadsPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        recentsUploadsPanel.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        panelView1.setBackground(javax.swing.UIManager.getDefaults().getColor("ComboBox.selectionBackground"));
        panelView1.setForeground(java.awt.Color.magenta);
        panelView1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelView1.setMaximumSize(new java.awt.Dimension(500, 250));
        panelView1.setMinimumSize(new java.awt.Dimension(200, 100));
        panelView1.setPreferredSize(new java.awt.Dimension(300, 250));
        recentsUploadsPanel.add(panelView1);

        panelView2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recentsUploadsPanel.add(panelView2);
        recentsUploadsPanel.add(panelView3);

        jPanel4.setBackground(new java.awt.Color(236, 252, 252));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(244, 234, 244));
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("Your Recents Uploads");
        jLabel1.setOpaque(true);
        jPanel4.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel1.setBackground(new java.awt.Color(61, 153, 244));

        jPanel5.setBackground(new java.awt.Color(56, 146, 241));

        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(searchBtn))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 123, Short.MAX_VALUE))
        );

        jMenuBar1.setMargin(new java.awt.Insets(5, 15, 15, 15));

        jMenu1.setText("File");

        jMenuItem1.setText("Images");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Videos");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Documents");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Favourite");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setMargin(new java.awt.Insets(0, 10, 0, 0));

        jMenuItem6.setText("Select");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Select All");
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Delete");
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Recents");
        jMenu3.setMargin(new java.awt.Insets(0, 10, 0, 0));
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Most Visit");
        jMenu4.setMargin(new java.awt.Insets(0, 10, 0, 0));
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Liked");
        jMenu5.setMargin(new java.awt.Insets(0, 10, 0, 0));
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(544, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(recentsUploadsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(recentsUploadsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            UploadedFiles imagesFiles = new UploadedFiles();
            imagesFiles.setVisible(true);

            // TODO add your handling code here:
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void uPloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uPloadButtonActionPerformed
        ImageIcon iconimage = null;
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image", "jpg","jpeg","png",".mp4",".webp",".pdf",".text");
            chooser.addChoosableFileFilter(filter);
            int result = chooser.showSaveDialog(null);
            if (result==JFileChooser.APPROVE_OPTION) {
                File selected = chooser.getSelectedFile();
                path = selected.getAbsolutePath();
                System.out.println(path);
                //                jLabel2.setText(path);
                iconimage = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(panelView1.getWidth(),
                    panelView1.getHeight(),Image.SCALE_SMOOTH));

        }else if(result==JFileChooser.CANCEL_OPTION){

        }
        int lastIndex = path.lastIndexOf(".");
        String extension = path.substring(lastIndex);
        if(extension.equals(".jpg")| extension.equals(".png")| extension.equals(".jpeg")|extension.equals("webp") ){
            System.out.println(UserLoginForm_Index_Page.username);
            System.out.println(UserLoginForm_Index_Page.user);
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.user);
                HomePageForm.uploadImage(path);
                panelView1.setIcon(iconimage);
               
                JOptionPane.showMessageDialog(rootPane, "Image Uploaded Successfull ");
            }

        }else if(extension.equals(".mp4")| extension.equals(".mkv")|extension.equals(".Webm")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.user);
            }
            HomePageForm.uploadVideo(path);
//            Video Message
            JOptionPane.showMessageDialog(rootPane, "Video Uploaded Successfull");
        }else if(extension.equals(".pdf")|extension.equals(".txt")|extension.equals(".docx")|extension.equals(".ppt")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user) ){
                UserDatabases.getConnection(UserLoginForm_Index_Page.username);
                HomePageForm.uploadDocuments(path);
            }

//            pdf message
            JOptionPane.showMessageDialog(rootPane, "Pdf File was Uploaded Successfull");
        }
        else if(extension.equals(".audio")){
            if(UserLoginForm_Index_Page.username.equals(UserLoginForm_Index_Page.user)){
                UserDatabases.getConnection(UserLoginForm_Index_Page.user);
                HomePageForm.uploadAudio(path);
            }
        }
        //            panelView1.setIcon(iconimage);
        System.out.println("hello");

        System.out.println("hi");
        this.revalidate();
        }catch(HeadlessException | IOException | SQLException e){

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_uPloadButtonActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnActionPerformed
            
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new HomePageForm().setVisible(true);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(HomePageForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dropOn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel panelView1;
    private javax.swing.JLabel panelView2;
    private javax.swing.JLabel panelView3;
    private javax.swing.JPanel recentsUploadsPanel;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton uPloadButton;
    // End of variables declaration//GEN-END:variables
}
