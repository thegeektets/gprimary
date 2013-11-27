/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_primaryschoolmanagement_client;

import static g_primaryschoolmanagement_client.dbsetup.canWrite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Griffin M
 */
public class readmessages extends javax.swing.JInternalFrame {
public String dbhostip;
public String dbpassword;
public String database;

    Connection con;
    String sqlt;  
    ResultSet rst;
  
    public readmessages() {
        initComponents();
        dblogincred();
         navigate();
     }
      public void navigate(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,"root", dbpassword);
           Statement stmntt = con.createStatement();
            sqlt= "Select * from messages where   messages.to = '" + main.txtusername.getText().toString()+"'";
           rst= stmntt.executeQuery(sqlt);
              } catch (SQLException ex) {
            Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
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

    public void unread(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
           Connection con;
        con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,"root", dbpassword);
        Statement stmnt = con.createStatement();
        String sql = "Select * from messages where  readstatus = "+"'pending'"+" and messages.to = '" + main.txtusername.getText().toString()+"'";
        ResultSet rs = stmnt.executeQuery(sql);
        int r=0;
        while (rs.next()) {
        r++;
                
      }
      if(r!=0){  
        JOptionPane.showMessageDialog(rootPane,"You have "+r+" Unread Messages");
      }
      else{
         int c=JOptionPane.showConfirmDialog(rootPane,"You don't have Unread Messages view older messages");
       if(c==0){
           
                  if(rst.next()) {
            
            txtfrom.setText(rst.getString("from"));
            txtsubject.setText(rst.getString("subject"));
            txtmessage.setText(rst.getString("message"));
                      String time = rst.getString("stamp");
       
                
        }
          
      }
       else{
           dispose();
       }
    }} catch (ClassNotFoundException ex) {
        Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void read(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
           Connection con;
        con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,"root", dbpassword);
        Statement stmnt = con.createStatement();
        String sql = "Select * from messages where  readstatus = "+"'pending'"+" and messages.to = '" + main.txtusername.getText().toString()+"'";
        ResultSet rs = stmnt.executeQuery(sql);
        int r=0;
        String time = null;
        if(rs.next()) {
            
            txtfrom.setText(rs.getString("from"));
            txtsubject.setText(rs.getString("subject"));
            txtmessage.setText(rs.getString("message"));
            time=rs.getString("stamp");
       
                
        }
        PreparedStatement st =con.prepareStatement("Update messages set readstatus ="+"'read'"+"where messages.stamp= '"+time+"' and messages.to='"+ main.txtusername.getText().toString()+"'");
        st.executeUpdate();
        
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
    
    }}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlmessage = new javax.swing.JPanel();
        lblto = new javax.swing.JLabel();
        txtfrom = new javax.swing.JTextField();
        txtsubject = new javax.swing.JTextField();
        lblsubject = new javax.swing.JLabel();
        lblmessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmessage = new javax.swing.JTextArea();
        btnfind = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnprevious = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        btnreply = new javax.swing.JButton();
        btnexit1 = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        lblfooter = new javax.swing.JLabel();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        pnlmessage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblto.setText("From:");

        txtfrom.setEditable(false);
        txtfrom.setBackground(new java.awt.Color(153, 255, 102));
        txtfrom.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtfrom.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtsubject.setEditable(false);
        txtsubject.setBackground(new java.awt.Color(153, 255, 102));
        txtsubject.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsubject.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblsubject.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblsubject.setText("Subject:");

        lblmessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblmessage.setText("Message:");

        txtmessage.setEditable(false);
        txtmessage.setBackground(new java.awt.Color(153, 255, 102));
        txtmessage.setColumns(20);
        txtmessage.setRows(5);
        txtmessage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(txtmessage);

        btnfind.setBackground(new java.awt.Color(102, 102, 102));
        btnfind.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnfind.setForeground(new java.awt.Color(51, 255, 51));
        btnfind.setText("Search");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        btnnext.setBackground(new java.awt.Color(102, 102, 102));
        btnnext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnnext.setForeground(new java.awt.Color(51, 255, 51));
        btnnext.setText("Next");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btnprevious.setBackground(new java.awt.Color(102, 102, 102));
        btnprevious.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnprevious.setForeground(new java.awt.Color(51, 255, 51));
        btnprevious.setText("Previous");
        btnprevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreviousActionPerformed(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(102, 102, 102));
        btnexit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 51, 51));
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        txtsearch.setBackground(new java.awt.Color(153, 255, 102));
        txtsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnreply.setBackground(new java.awt.Color(102, 102, 102));
        btnreply.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnreply.setForeground(new java.awt.Color(0, 204, 0));
        btnreply.setText("Reply");
        btnreply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplyActionPerformed(evt);
            }
        });

        btnexit1.setBackground(new java.awt.Color(102, 102, 102));
        btnexit1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnexit1.setForeground(new java.awt.Color(255, 51, 51));
        btnexit1.setText("Delete");
        btnexit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlmessageLayout = new javax.swing.GroupLayout(pnlmessage);
        pnlmessage.setLayout(pnlmessageLayout);
        pnlmessageLayout.setHorizontalGroup(
            pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlmessageLayout.createSequentialGroup()
                        .addComponent(lblto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnreply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlmessageLayout.createSequentialGroup()
                        .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlmessageLayout.createSequentialGroup()
                                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblmessage, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnprevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnfind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnexit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btnnext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlmessageLayout.createSequentialGroup()
                                .addComponent(lblsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlmessageLayout.setVerticalGroup(
            pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmessageLayout.createSequentialGroup()
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfind)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblto)
                    .addComponent(txtfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreply))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsubject)
                    .addComponent(txtsubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmessageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(lblmessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlmessageLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnnext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnprevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnexit1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnexit)
                        .addGap(43, 43, 43))))
        );

        lbltitle.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbltitle.setText("Read Messages :");

        lblfooter.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblfooter.setForeground(new java.awt.Color(102, 0, 102));
        lblfooter.setText("G Ultimate Developers:2013 All Rights Reserved");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlmessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltitle, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlmessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
    try {
        Class.forName("com.mysql.jdbc.Driver");
         Connection con;
           con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,"root", dbpassword);

         Statement stmnt = con.createStatement();
         String sql = "Select * from users where username='" + txtfrom.getText()+ "'";
           ResultSet rs = stmnt.executeQuery(sql);

         if (rs.next()) {
               JOptionPane.showMessageDialog(rootPane, "User found");
           
            }
         else{
             
         Statement stm = con.createStatement();
         String sq = "Select * from users where fullname='" + txtfrom.getText()+ "'";
           ResultSet rrs = stm.executeQuery(sq);
           if(rrs.next()){
               JOptionPane.showMessageDialog(rootPane, "User found replacing fullname with username");
               txtfrom.setText(rrs.getString("username"));
           
             
         }
           else{
               JOptionPane.showMessageDialog(rootPane, "Recepient not found");
           }

         }
    
        
        
        
        
    }//GEN-LAST:event_btnfindActionPerformed

    catch (ClassNotFoundException ex) {
        Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);

    }catch (SQLException ex) {
        Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
    }}
    private void btnpreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreviousActionPerformed
     try {
            if(rst.previous()){
                try {
                    txtfrom.setText(rst.getString("from"));
                    txtsubject.setText(rst.getString("subject"));
                    txtmessage.setText(rst.getString("message"));
                      String time = rst.getString("stamp");
                PreparedStatement st =con.prepareStatement("Update messages set readstatus ="+"'read'"+"where messages.stamp= '"+time+"' and messages.to='"+ main.txtusername.getText().toString()+"'");
                st.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
                }
          
                  
          }
          else{
              JOptionPane.showMessageDialog(rootPane,"This is the first message");
          }
        } catch (SQLException ex) {
            Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnpreviousActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
     try{
        if(rst.next()) {
            
            txtfrom.setText(rst.getString("from"));
            txtsubject.setText(rst.getString("subject"));
            txtmessage.setText(rst.getString("message"));
            String time = rst.getString("stamp");
        PreparedStatement st =con.prepareStatement("Update messages set readstatus ="+"'read'"+"where messages.stamp= '"+time+"' and messages.to='"+ main.txtusername.getText().toString()+"'");
        st.executeUpdate();
        
                
        }
        else{
            JOptionPane.showMessageDialog(rootPane,"This is the last message");
        }
      } catch ( SQLException ex) {
        Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
    } 
              
        
        
        
    }//GEN-LAST:event_btnnextActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
       
    
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
            unread();
            read();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnreplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplyActionPerformed
        // TODO add your handling code here:
        main.reply();
        
    }//GEN-LAST:event_btnreplyActionPerformed

    private void btnexit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexit1ActionPerformed
       try {
            // TODO add your handling code here:
           int c=JOptionPane.showInternalConfirmDialog(rootPane, "Are you  sure you want to delete this message");
       if(c==0){
           
           if(rst.next()){
                 String time = rst.getString("stamp");
                    PreparedStatement st =con.prepareStatement("delete from messages where messages.stamp= '"+time+"' and messages.to='"+ main.txtusername.getText().toString()+"'");
     
                    st.executeUpdate();
                     txtfrom.setText("");
            txtsubject.setText("");
            txtmessage.setText("");
           
        JOptionPane.showMessageDialog(rootPane, "Message has been deleted");
     
       }}
       
                 
        } catch (SQLException ex) {
            Logger.getLogger(readmessages.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
      
      
    }//GEN-LAST:event_btnexit1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnexit1;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprevious;
    private javax.swing.JButton btnreply;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblmessage;
    private javax.swing.JLabel lblsubject;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lblto;
    private javax.swing.JPanel pnlmessage;
    private javax.swing.JTextField txtfrom;
    private javax.swing.JTextArea txtmessage;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsubject;
    // End of variables declaration//GEN-END:variables
}
