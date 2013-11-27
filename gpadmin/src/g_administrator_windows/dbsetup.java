/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_administrator_windows;

import com.ibatis.common.jdbc.ScriptRunner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author griffin
 */
public class dbsetup extends javax.swing.JFrame {

    
public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
    
    public dbsetup() {
        initComponents();
    //    readcred();
    }

static boolean canWrite(String folderPath) {
    File file = new File(folderPath);
    String new_file = "dbconfig";
    if (file.isDirectory()) {
        try {
            new File(file + "\\" + new_file).createNewFile();
        } catch (IOException e) {
            return false;
        }
        new File(file + "\\" + new_file).delete();
        return true;
    } else {
        return false;

    }
}


    
    
    
  public void readcred(){

        String fileName = "C:\\Users\\Public\\Documents\\dbconfig.txt";

         try {
            // Use this for reading the data.
            String[] login=new String[10];
            byte[] buffer = new byte[1000];
             FileInputStream inputStream = new FileInputStream(fileName);
                int total = 0;
                int nRead = 0;
                while((nRead = inputStream.read(buffer)) != -1) {
                   
                 login[total]= (new String(buffer));
                        System.out.println("Total:"+total);
                    
                       System.err.println("-------------");
                       
                                total += nRead;
                }
         
               
        /*       if(login[1]!=null){
                dbhostip=login[1].trim();
                }*/
                 if(login[0]!=null){
                dbusername=login[0].trim();
                }
                
            } catch (FileNotFoundException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            int e=dbusername.indexOf("%");
            int n=dbusername.indexOf("^");
            int p=dbusername.indexOf("@");
        dbhostip=dbusername.substring(e+1,n).trim();
      dbpassword=dbusername.substring(n+1,p).trim();
        database=dbusername.substring(p+1).trim();
        dbusername=dbusername.substring(0, e);
        
        txtusername.setText(dbusername);
        txthost.setText(dbhostip);
        txtpassword.setText(dbpassword);
        txtdatabase.setText(database);
         System.out.println("Username :"+dbusername);
         System.out.println("Host:"+dbhostip);
         System.out.println("Password :"+dbpassword);
         System.out.println("Database :"+database);
         
     
          
        }
     

    


        
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlmain = new javax.swing.JPanel();
        lblhead = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        btntest = new javax.swing.JButton();
        lblfooter = new javax.swing.JLabel();
        txthost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        lblipalert = new javax.swing.JLabel();
        txtdatabase = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        btncreate = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlmain.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblhead.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblhead.setText("Database Creation and Configuration");

        btnexit.setBackground(new java.awt.Color(0, 0, 0));
        btnexit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 0, 0));
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btntest.setBackground(new java.awt.Color(0, 0, 0));
        btntest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btntest.setForeground(new java.awt.Color(51, 204, 0));
        btntest.setText("Test Connection");
        btntest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntestActionPerformed(evt);
            }
        });

        lblfooter.setBackground(new java.awt.Color(153, 0, 153));
        lblfooter.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lblfooter.setForeground(new java.awt.Color(255, 255, 255));
        lblfooter.setText("G Ultimate Developers:2013 -All Rights Reserved");
        lblfooter.setOpaque(true);

        txthost.setBackground(new java.awt.Color(153, 255, 153));
        txthost.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txthost.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Host Address");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("DB Password");

        txtpassword.setBackground(new java.awt.Color(153, 255, 153));
        txtpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtpassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblipalert.setBackground(new java.awt.Color(102, 102, 102));
        lblipalert.setFont(new java.awt.Font("Times New Roman", 3, 10)); // NOI18N
        lblipalert.setForeground(new java.awt.Color(0, 255, 0));
        lblipalert.setText("Do not change IP if not in a LAN(local area network)");
        lblipalert.setOpaque(true);

        txtdatabase.setBackground(new java.awt.Color(153, 255, 153));
        txtdatabase.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtdatabase.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("DB Username");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("DB Name");

        txtusername.setBackground(new java.awt.Color(153, 255, 153));
        txtusername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtusername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btncreate.setBackground(new java.awt.Color(0, 0, 0));
        btncreate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btncreate.setForeground(new java.awt.Color(51, 204, 0));
        btncreate.setText("Create Database");
        btncreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncreateActionPerformed(evt);
            }
        });

        btnnext.setBackground(new java.awt.Color(0, 0, 0));
        btnnext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnnext.setForeground(new java.awt.Color(204, 204, 204));
        btnnext.setText("Next");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btnsave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlmainLayout = new javax.swing.GroupLayout(pnlmain);
        pnlmain.setLayout(pnlmainLayout);
        pnlmainLayout.setHorizontalGroup(
            pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlmainLayout.createSequentialGroup()
                        .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlmainLayout.createSequentialGroup()
                                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(44, 44, 44)
                                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtdatabase, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtusername)))
                            .addComponent(jLabel6)
                            .addGroup(pnlmainLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txthost, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                            .addGroup(pnlmainLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(lblhead))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblipalert, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlmainLayout.createSequentialGroup()
                                        .addComponent(btncreate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btntest))
                                    .addComponent(btnsave))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnnext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(btnexit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        pnlmainLayout.setVerticalGroup(
            pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtdatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblipalert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnext)
                    .addComponent(btnsave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnexit)
                    .addComponent(btntest)
                    .addComponent(btncreate))
                .addGap(12, 12, 12)
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnlmain, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlmain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btntestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntestActionPerformed
        // TODO add your handling code here:
        try {
            readcred();
                     JOptionPane.showMessageDialog(rootPane, "Testing Connection");
                      Class.forName("com.mysql.jdbc.Driver");
                      String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                              String user = dbusername;
                              String pass= dbpassword;
      Connection con = DriverManager.getConnection(host, user, pass);
      con.getClientInfo();
                      JOptionPane.showMessageDialog(rootPane, "Test succesfull ,proceed to login and Enjoy :)");
                      /*login lg=new login();
                      dispose();
                      lg.setVisible(true);*/
             
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
                     JOptionPane.showMessageDialog(rootPane, "Test failed please check that you have created the database");
             
                } catch (SQLException ex) {
                    Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
                     JOptionPane.showMessageDialog(rootPane, "Test failed please check that you have created the database");
             
                }
            
            
        
    }//GEN-LAST:event_btntestActionPerformed

    private void btncreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncreateActionPerformed
 
		try {          
 readcred();                   
        // TODO add your handling code here:
  
                String aSQLScriptFilePath = "C:\\Program Files\\G Ultimate Developers\\dbscript.sql";
                // Create MySql Connection
                Class.forName("com.mysql.jdbc.Driver");
          
Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+"/?user="+dbusername+"&password="+dbpassword+"&allowMultiQueries=true");

                try {
                        // Initialize object for ScripRunner
                        ScriptRunner sr = new ScriptRunner(con, false, false);
 
                        // Give the input file to Reader
                        Reader reader = new BufferedReader(
                               new FileReader(aSQLScriptFilePath));
 
                        // Exctute script
                        sr.runScript(reader);
                        JOptionPane.showMessageDialog(rootPane,"Database Creation succefull");
 
                } catch (Exception e) {
                         try {
         aSQLScriptFilePath = "C:\\Program Files(x86)\\G Ultimate Developers\\dbscript.sql";
         // Initialize object for ScripRunner
         ScriptRunner sr = new ScriptRunner(con, false, false);
        Reader reader = new BufferedReader(
         new FileReader(aSQLScriptFilePath));
         // Exctute script
         sr.runScript(reader);
         JOptionPane.showMessageDialog(rootPane,"Database Creation succefull");
        
     } catch (FileNotFoundException ex) {
          JOptionPane.showMessageDialog(rootPane,"Failed to Execute" + aSQLScriptFilePath
                             + " The error is " + e.getMessage());
         Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
     } 
                }
        
  
     

   
        
        
        
        
        
        
    } catch (ClassNotFoundException ex) {
			Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
    }
	
  
     

   
        
        
        
        
        
        
    }//GEN-LAST:event_btncreateActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
    try {
        // TODO add your handling code here:
        readcred();
        Class.forName("com.mysql.jdbc.Driver");
                      String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                              String user = dbusername;
                              String pass= dbpassword;
      Connection con = DriverManager.getConnection(host, user, pass);
      con.getClientInfo();
      adminorgsetup ao =new adminorgsetup();
      dispose();
      ao.setVisible(true);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane,"cannot proceed before a database is created");
    } catch (SQLException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane,"Sorry you cannot proceed before connection is succesfull and a database is created");
    }
        
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
            try {                                        
            // TODO add your handling code here:
            File file = new File("C:\\Users\\Public\\Documents\\");
            file.mkdir();
            String hash="dbconfig";
            String filename=hash+".txt";
            File parent = new File(file,filename);
            parent.createNewFile();

            if(!parent.exists() && !parent.mkdirs()){
            throw new IllegalStateException("Couldn't create dir: " + parent);
            } 
            String fileName = "C:\\Users\\Public\\Documents\\dbconfig.txt";

            try {
                // Assume default encoding.
                FileWriter fileWriter =
                    new FileWriter(fileName);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

                // Note that write() does not automatically
                // append a newline character.
                String username=txtusername.getText();
                String password=txtpassword.getText();
                String hostip=txthost.getText();
                String dbase=txtdatabase.getText();
                bufferedWriter.write(""+username+"%");
                bufferedWriter.newLine();
               
                bufferedWriter.write(""+hostip+"^");
                bufferedWriter.newLine();
                bufferedWriter.write(""+password+"@");
                     bufferedWriter.newLine();
                bufferedWriter.write(""+dbase);


                // Always close files.
                bufferedWriter.close();
                JOptionPane.showMessageDialog(rootPane, "Database Credentials saved successfully");
            }   catch (IOException ex) {
                    Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
                }} catch (IOException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnsaveActionPerformed

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
            java.util.logging.Logger.getLogger(dbsetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dbsetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dbsetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dbsetup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dbsetup().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncreate;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btntest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblhead;
    private javax.swing.JLabel lblipalert;
    private javax.swing.JPanel pnlmain;
    private javax.swing.JTextField txtdatabase;
    private javax.swing.JTextField txthost;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
