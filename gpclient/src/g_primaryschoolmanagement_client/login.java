/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_primaryschoolmanagement_client;

import static g_primaryschoolmanagement_client.dbsetup.canWrite;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author griffin
 */
public class login extends javax.swing.JFrame {
public String dbhostip;
public String dbpassword;
public String database;

    public login() {
        initComponents();
        dblogincred();
        orgdetails();
    }
    public void orgdetails(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
    Connection con;
      con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,"root", dbpassword);

    Statement stmnt = con.createStatement();
    String sql = "Select * from organisation";
      ResultSet rs = stmnt.executeQuery(sql);

    if (rs.next()) {
        lblorganization.setText(rs.getString("organisationname"));
    }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
      
    }

    public void dblogincred(){
        if(canWrite("C:\\Users\\Public\\Documents")){
            System.out.print("Writing");
        try {
            StringBuilder sb = new StringBuilder(File.separator);
            sb.append("C:\\Users\\Public\\Documents\\dblogin.txt");
            File f = new File(sb.toString());
            boolean isCreated = f.createNewFile();
            System.out.println(isCreated);
        } catch (IOException ex) {
            Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
        }
        String fileName = "C:\\Users\\Public\\Documents\\dblogin.txt";

        try {
            // Use this for reading the data.
            String[] login=new String[10];
            byte[] buffer = new byte[1000];

            FileInputStream inputStream = 
                new FileInputStream(fileName);

            int total = 0;
            int nRead = 0;
            while((nRead = inputStream.read(buffer)) != -1) {
               
             login[total]= (new String(buffer));
                total += nRead;
                
            }
            if(login[1]!=null){
            dbpassword=login[1].trim();
            }
             if(login[0]!=null){
            dbhostip=login[0].trim();
            }
               inputStream.close();
               int l=dbhostip.indexOf("n");
               int e=dbhostip.indexOf("%");
        dbpassword=dbhostip.substring(l+1,e).trim();
        database=dbhostip.substring(e+1).trim();
        dbhostip=dbhostip.substring(0, l).trim();
         System.out.println(""+dbhostip);
         System.out.println(""+database);
         System.out.println(""+dbpassword);
     
          
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");					
            // Or we could just do this: 
            // ex.printStackTrace();
        }}
    }

    public String MD5(String md5) {
   try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlmain = new javax.swing.JPanel();
        lblhead = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        btnlogin = new javax.swing.JButton();
        lblfooter = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        lblusername = new javax.swing.JLabel();
        lblpassword = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        lbllogo = new javax.swing.JLabel();
        lblorganization = new javax.swing.JLabel();
        lblsystem = new javax.swing.JLabel();
        lblhint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlmain.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblhead.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblhead.setText("Client Login Window");

        btnexit.setBackground(new java.awt.Color(0, 0, 0));
        btnexit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 0, 0));
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btnlogin.setBackground(new java.awt.Color(0, 0, 0));
        btnlogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(51, 204, 0));
        btnlogin.setText("Login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        lblfooter.setBackground(new java.awt.Color(153, 0, 153));
        lblfooter.setFont(new java.awt.Font("Vijaya", 1, 14)); // NOI18N
        lblfooter.setForeground(new java.awt.Color(255, 255, 255));
        lblfooter.setText("G Ultimate Developers:2013 -All Rights Reserved");
        lblfooter.setOpaque(true);

        txtusername.setBackground(new java.awt.Color(153, 255, 153));
        txtusername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtusername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblusername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername.setText("Username");

        lblpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblpassword.setText("Password");

        txtpassword.setBackground(new java.awt.Color(153, 255, 153));
        txtpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtpassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g_primaryschoolmanagement_client/logo.jpg"))); // NOI18N

        lblorganization.setBackground(new java.awt.Color(102, 255, 102));
        lblorganization.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblorganization.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblorganization.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblsystem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblsystem.setText("G_PrimarySchoolManagementSystem Client Login");

        lblhint.setBackground(new java.awt.Color(102, 0, 102));
        lblhint.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        lblhint.setForeground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout pnlmainLayout = new javax.swing.GroupLayout(pnlmain);
        pnlmain.setLayout(pnlmainLayout);
        pnlmainLayout.setHorizontalGroup(
            pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmainLayout.createSequentialGroup()
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlmainLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlmainLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                                .addComponent(lblhint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnlogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                                .addComponent(lbllogo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                                        .addComponent(lblusername)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                                        .addComponent(lblpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(lblsystem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblorganization, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        pnlmainLayout.setVerticalGroup(
            pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblorganization, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsystem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlmainLayout.createSequentialGroup()
                        .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblusername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                        .addComponent(lbllogo)
                        .addGap(2, 2, 2)))
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnexit)
                        .addComponent(btnlogin))
                    .addComponent(lblhint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pnlmain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlmain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
    try {
        // TODO add your handling code here:
         String user = this.txtusername.getText();
      String pass = this.txtpassword.getText();
      pass=MD5(pass);
      Class.forName("com.mysql.jdbc.Driver");
      Connection con;
        con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,"root", dbpassword);

      Statement stmnt = con.createStatement();
      String sql = "Select * from users where username='" + user + "'";
        ResultSet rs = stmnt.executeQuery(sql);

      if (rs.next()) {
        if ((pass.equals(MD5("1234"))) && (pass.equals(rs.getString("password")))) {
          JOptionPane.showMessageDialog(rootPane, "New users must login thorugh the new user login window for the first time  ");
        }
        else if (pass.equals(rs.getString("password")))
        {
          JOptionPane.showMessageDialog(rootPane, "\n Login Successfull");
            new main().setVisible(true);
      
           String cred = rs.getString("privilidges");
           String name=rs.getString("fullname");
          main.txtusername.setText(user);
          main.txtfullname.setText(name);
          main.txtstatus.setText("online");
          main.txtcredentials.setText(cred);
        
         PreparedStatement st = con.prepareStatement("UPDATE users SET status=? where username=?");
         st.setString(1, "online");
         st.setString(2, user );
         st.executeUpdate();
        dispose();
           
       if(cred.equals("Administrator")){
           JOptionPane.showMessageDialog(rootPane, "\n Welcome Admin");
           main.btnadd.setEnabled(true);
        }
        }
        else
        {
          JOptionPane.showMessageDialog(rootPane, "Wrong Password please try again");
          this.lblhint.setText("Password hint:" + rs.getString("hint"));
        }
      }
      else
        JOptionPane.showMessageDialog(rootPane, "Wrong Username try again ");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnloginActionPerformed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER){
             try {
        // TODO add your handling code here:
         String user = this.txtusername.getText();
      String pass = this.txtpassword.getText();
      pass=MD5(pass);
      Class.forName("com.mysql.jdbc.Driver");
      Connection con;
        con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,"root", dbpassword);

      Statement stmnt = con.createStatement();
      String sql = "Select * from users where username='" + user + "'";
        ResultSet rs = stmnt.executeQuery(sql);

      if (rs.next()) {
        if ((pass.equals(MD5("1234"))) && (pass.equals(rs.getString("password")))) {
          JOptionPane.showMessageDialog(rootPane, "New users must login thorugh the new user login window for the first time  ");
        }
        else if (pass.equals(rs.getString("password")))
        {
          JOptionPane.showMessageDialog(rootPane, "\n Login Successfull");
            new main().setVisible(true);
      
           String cred = rs.getString("privilidges");
           String name=rs.getString("fullname");
          main.txtusername.setText(user);
          main.txtfullname.setText(name);
          main.txtstatus.setText("online");
          main.txtcredentials.setText(cred);
        
         PreparedStatement st = con.prepareStatement("UPDATE users SET status=? where username=?");
         st.setString(1, "online");
         st.setString(2, user );
         st.executeUpdate();
        dispose();
           
       if(cred.equals("Administrator")){
           JOptionPane.showMessageDialog(rootPane, "\n Welcome Admin");
           main.btnadd.setEnabled(true);
        }
        }
        else
        {
          JOptionPane.showMessageDialog(rootPane, "Wrong Password please try again");
          this.lblhint.setText("Password hint:" + rs.getString("hint"));
        }
      }
      else
        JOptionPane.showMessageDialog(rootPane, "Wrong Username try again ");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    }
   
        }
        
        
    }//GEN-LAST:event_txtpasswordKeyPressed
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblhead;
    private javax.swing.JLabel lblhint;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblorganization;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblsystem;
    private javax.swing.JLabel lblusername;
    private javax.swing.JPanel pnlmain;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
