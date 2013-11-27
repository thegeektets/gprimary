/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_administrator_windows;

import com.ibatis.common.jdbc.ScriptRunner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author griffin
 */
public class restore extends javax.swing.JInternalFrame {
    private String path;
public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
    public restore() {
        initComponents();
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
        
       // txtusername.setText(dbusername);
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

        brownSugar1 = new com.jgoodies.looks.plastic.theme.BrownSugar();
        pnllogin = new javax.swing.JPanel();
        lbldbpassword = new javax.swing.JLabel();
        lblipaddress = new javax.swing.JLabel();
        txthost = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        btnrestore = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        lblhead = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbldatabase = new javax.swing.JLabel();
        txtdatabase = new javax.swing.JTextField();
        pnlofflinerestore = new javax.swing.JPanel();
        btnofflinerestore = new javax.swing.JButton();
        btnbrowse = new javax.swing.JButton();
        txtfile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setToolTipText("");
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbldbpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbldbpassword.setText("Db Password:");

        lblipaddress.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblipaddress.setText("Host:");

        txthost.setBackground(new java.awt.Color(153, 255, 153));
        txthost.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txthost.setText("172.0.0.1");
        txthost.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txthost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthostActionPerformed(evt);
            }
        });

        txtpassword.setBackground(new java.awt.Color(153, 255, 153));
        txtpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtpassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });

        btnrestore.setBackground(new java.awt.Color(51, 51, 51));
        btnrestore.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnrestore.setForeground(new java.awt.Color(51, 255, 0));
        btnrestore.setText("Online Restore");
        btnrestore.setToolTipText("");
        btnrestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrestoreActionPerformed(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(51, 51, 51));
        btnexit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 0, 0));
        btnexit.setText("Exit");
        btnexit.setToolTipText("");
        btnexit.setMaximumSize(new java.awt.Dimension(92, 28));
        btnexit.setMinimumSize(new java.awt.Dimension(92, 28));
        btnexit.setPreferredSize(new java.awt.Dimension(92, 28));
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        lblhead.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblhead.setText("Restore Database");

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Do not change IP if not in a LAN(local area network)");
        jLabel1.setOpaque(true);

        lbldatabase.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbldatabase.setText("Database :");

        txtdatabase.setBackground(new java.awt.Color(153, 255, 153));
        txtdatabase.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtdatabase.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtdatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdatabaseActionPerformed(evt);
            }
        });

        pnlofflinerestore.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Offline Restore", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12), new java.awt.Color(51, 51, 51))); // NOI18N

        btnofflinerestore.setBackground(new java.awt.Color(51, 51, 51));
        btnofflinerestore.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnofflinerestore.setForeground(new java.awt.Color(51, 255, 0));
        btnofflinerestore.setText("Offline Restore");
        btnofflinerestore.setToolTipText("");
        btnofflinerestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnofflinerestoreActionPerformed(evt);
            }
        });

        btnbrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g_administrator_windows/1372271867_folder_upload.png"))); // NOI18N
        btnbrowse.setText("Select Restore File");
        btnbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbrowseActionPerformed(evt);
            }
        });

        txtfile.setBackground(new java.awt.Color(255, 255, 153));

        jLabel2.setText("(.sql file to restore your data from)");

        javax.swing.GroupLayout pnlofflinerestoreLayout = new javax.swing.GroupLayout(pnlofflinerestore);
        pnlofflinerestore.setLayout(pnlofflinerestoreLayout);
        pnlofflinerestoreLayout.setHorizontalGroup(
            pnlofflinerestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlofflinerestoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlofflinerestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlofflinerestoreLayout.createSequentialGroup()
                        .addComponent(txtfile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnofflinerestore))
                    .addGroup(pnlofflinerestoreLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlofflinerestoreLayout.setVerticalGroup(
            pnlofflinerestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlofflinerestoreLayout.createSequentialGroup()
                .addGroup(pnlofflinerestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnbrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlofflinerestoreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGroup(pnlofflinerestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlofflinerestoreLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnofflinerestore))
                    .addGroup(pnlofflinerestoreLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtfile)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblipaddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbldbpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(lbldatabase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(74, 74, 74)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txthost, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtdatabase)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblhead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnexit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnrestore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlofflinerestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblipaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldbpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnrestore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlofflinerestore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        lblfooter.setBackground(new java.awt.Color(153, 0, 255));
        lblfooter.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblfooter.setForeground(new java.awt.Color(255, 255, 255));
        lblfooter.setText("G Ultimate Developers :2013-All Rights Reserved.");
        lblfooter.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnllogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_btnexitActionPerformed

    private void btnrestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestoreActionPerformed
 JOptionPane.showMessageDialog(rootPane,"Feature not available yet try offline restore");
               // TODO add your handling code here:

    }//GEN-LAST:event_btnrestoreActionPerformed

    private void txthostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthostActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtdatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdatabaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdatabaseActionPerformed

    private void btnofflinerestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnofflinerestoreActionPerformed
        // TODO add your handling code here:
        
        		try {          
          readcred();                   
        // TODO add your handling code here:
  
                String aSQLScriptFilePath = ""+path;
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
                        JOptionPane.showMessageDialog(rootPane,"Database Restoration successfull");
 
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane,"Failed to Execute" + aSQLScriptFilePath
                                        + " The error is " + e.getMessage());
                }
        
  
     

   
        
        
        
        
        
        
    } catch (ClassNotFoundException ex) {
			Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
    }
	
  
     

   
        
        
        
        

        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnofflinerestoreActionPerformed

    private void btnbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbrowseActionPerformed
        // TODO add your handling code here:
 JFileChooser chooser = new JFileChooser();
        ExampleFileFilter filter = new ExampleFileFilter();
        filter.addExtension("sql");
        filter.setDescription("SQL Files");
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == 0)
        {
            this.path = chooser.getSelectedFile().getPath();
            txtfile.setText(path);
            } else {
        } 
    }//GEN-LAST:event_btnbrowseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnbrowse;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnofflinerestore;
    private javax.swing.JButton btnrestore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbldatabase;
    private javax.swing.JLabel lbldbpassword;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblhead;
    private javax.swing.JLabel lblipaddress;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JPanel pnlofflinerestore;
    private javax.swing.JTextField txtdatabase;
    private javax.swing.JTextField txtfile;
    private javax.swing.JTextField txthost;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
