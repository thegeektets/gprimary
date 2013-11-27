/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_administrator_windows;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author griffin
 */
public class read extends javax.swing.JInternalFrame {

    public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
    Connection con;
    String sqlt;  
     ResultSet rst;
    public read() {
        initComponents();
        readcred();
        navigate();
      }
  public void navigate(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
           Statement stmntt = con.createStatement();
            sqlt= "Select * from messages where   messages.to = '" + main.lbluser.getText().toString()+"'";
           rst= stmntt.executeQuery(sqlt);
              } catch (SQLException ex) {
            Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
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
        
        System.out.println("Username :"+dbusername);
         System.out.println("Host:"+dbhostip);
         System.out.println("Password :"+dbpassword);
         System.out.println("Database :"+database);
         
     
          
        }
    public void unread(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
           Connection con;
        con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
        Statement stmnt = con.createStatement();
        String sql = "Select * from messages where  readstatus = "+"'pending'"+" and messages.to = '" + main.lbluser.getText().toString()+"'";
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
       
      }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void read(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
           Connection con;
        con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
        Statement stmnt = con.createStatement();
        String sql = "Select * from messages where  readstatus = "+"'pending'"+" and messages.to = '" + main.lbluser.getText().toString()+"'";
        ResultSet rs = stmnt.executeQuery(sql);
        int r=0;
        String time = null;
        if(rs.next()) {
            
            txtfrom.setText(rs.getString("from"));
            txtsubject.setText(rs.getString("subject"));
            txtmessage.setText(rs.getString("message"));
            time=rs.getString("stamp");
       
                
        }
        PreparedStatement st =con.prepareStatement("Update messages set readstatus ="+"'read'"+"where messages.stamp= '"+time+"' and messages.to='"+ main.lbluser.getText().toString()+"'");
        st.executeUpdate();
        
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
    
    }}
  
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brownSugar1 = new com.jgoodies.looks.plastic.theme.BrownSugar();
        experienceBlue1 = new com.jgoodies.looks.plastic.theme.ExperienceBlue();
        pnllogin = new javax.swing.JPanel();
        lblusername = new javax.swing.JLabel();
        txtsubject = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        lblhead = new javax.swing.JLabel();
        btnreply = new javax.swing.JButton();
        lblfullname = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        lblidnumber = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmessage = new javax.swing.JTextArea();
        txtfrom = new javax.swing.JTextField();
        btnprev = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setToolTipText("");
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
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
            }
        });

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblusername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername.setText("Subject:");

        txtsubject.setBackground(new java.awt.Color(153, 255, 153));
        txtsubject.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsubject.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtsubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubjectActionPerformed(evt);
            }
        });

        btnfind.setBackground(new java.awt.Color(51, 51, 51));
        btnfind.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnfind.setForeground(new java.awt.Color(51, 255, 0));
        btnfind.setText("Find");
        btnfind.setToolTipText("");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(51, 51, 51));
        btnexit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnexit.setForeground(new java.awt.Color(255, 0, 0));
        btnexit.setText("Cancel");
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
        lblhead.setText("Compose Messages");

        btnreply.setBackground(new java.awt.Color(51, 51, 51));
        btnreply.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnreply.setForeground(new java.awt.Color(255, 255, 255));
        btnreply.setText("Reply");
        btnreply.setToolTipText("");
        btnreply.setMaximumSize(new java.awt.Dimension(92, 28));
        btnreply.setMinimumSize(new java.awt.Dimension(92, 28));
        btnreply.setPreferredSize(new java.awt.Dimension(92, 28));
        btnreply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplyActionPerformed(evt);
            }
        });

        lblfullname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfullname.setText("From:");

        txtsearch.setBackground(new java.awt.Color(153, 255, 153));
        txtsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });

        lblidnumber.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblidnumber.setText("Message:");

        txtmessage.setBackground(new java.awt.Color(153, 255, 153));
        txtmessage.setColumns(20);
        txtmessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtmessage.setRows(5);
        txtmessage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(txtmessage);

        txtfrom.setBackground(new java.awt.Color(153, 255, 153));
        txtfrom.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtfrom.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtfrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfromActionPerformed(evt);
            }
        });

        btnprev.setBackground(new java.awt.Color(51, 51, 51));
        btnprev.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnprev.setForeground(new java.awt.Color(255, 255, 255));
        btnprev.setText("Prev");
        btnprev.setToolTipText("");
        btnprev.setMaximumSize(new java.awt.Dimension(92, 28));
        btnprev.setMinimumSize(new java.awt.Dimension(92, 28));
        btnprev.setPreferredSize(new java.awt.Dimension(92, 28));
        btnprev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprevActionPerformed(evt);
            }
        });

        btnnext.setBackground(new java.awt.Color(51, 51, 51));
        btnnext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnnext.setForeground(new java.awt.Color(255, 255, 255));
        btnnext.setText("Next");
        btnnext.setToolTipText("");
        btnnext.setMaximumSize(new java.awt.Dimension(92, 28));
        btnnext.setMinimumSize(new java.awt.Dimension(92, 28));
        btnnext.setPreferredSize(new java.awt.Dimension(92, 28));
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(51, 51, 51));
        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 0, 0));
        btndelete.setText("Delete");
        btndelete.setToolTipText("");
        btndelete.setMaximumSize(new java.awt.Dimension(92, 28));
        btndelete.setMinimumSize(new java.awt.Dimension(92, 28));
        btndelete.setPreferredSize(new java.awt.Dimension(92, 28));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                        .addComponent(btnprev, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreply, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblfullname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblidnumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lblusername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsubject)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addContainerGap(164, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                                .addComponent(txtsearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnfind))
                            .addComponent(lblhead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                    .addContainerGap(171, Short.MAX_VALUE)
                    .addComponent(txtfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfind)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lblfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblidnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnreply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnprev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlloginLayout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(txtfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(219, Short.MAX_VALUE)))
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
                .addComponent(pnllogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubjectActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
       
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
    try {
        Class.forName("com.mysql.jdbc.Driver");
         Connection con;
           con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);

         Statement stmnt = con.createStatement();
         String sql = "Select * from users where username='" + txtsearch.getText()+ "'";
           ResultSet rs = stmnt.executeQuery(sql);

         if (rs.next()) {
               JOptionPane.showMessageDialog(rootPane, "User found");
           
            }
         else{
             
         Statement stm = con.createStatement();
         String sq = "Select * from users where fullname='" + txtsearch.getText()+ "'";
           ResultSet rrs = stm.executeQuery(sq);
           if(rrs.next()){
               JOptionPane.showMessageDialog(rootPane, "User found replacing fullname with username");
               txtsearch.setText(rrs.getString("username"));
           
             
         }
           else{
               JOptionPane.showMessageDialog(rootPane, "Recepient not found");
           }

         }
    
        
        
        
        
    }                                       

    catch (ClassNotFoundException ex) {
        Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);

    }catch (SQLException ex) {
        Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
    }
   
     
       
        
    }//GEN-LAST:event_btnfindActionPerformed

    private void btnreplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplyActionPerformed
        // TODO add your handling code here:
      main.reply();  
        
        
    }//GEN-LAST:event_btnreplyActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtfromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfromActionPerformed

    private void btnprevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprevActionPerformed
        try {
            if(rst.previous()){
                try {
                    txtfrom.setText(rst.getString("from"));
                    txtsubject.setText(rst.getString("subject"));
                    txtmessage.setText(rst.getString("message"));
                      String time = rst.getString("stamp");
                PreparedStatement st =con.prepareStatement("Update messages set readstatus ="+"'read'"+"where messages.stamp= '"+time+"' and messages.to='"+ main.lbluser.getText().toString()+"'");
                st.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
                }
          
                  
          }
          else{
              JOptionPane.showMessageDialog(rootPane,"This is the first message");
          }
        } catch (SQLException ex) {
            Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_btnprevActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:
        try{
        if(rst.next()) {
            
            txtfrom.setText(rst.getString("from"));
            txtsubject.setText(rst.getString("subject"));
            txtmessage.setText(rst.getString("message"));
            String time = rst.getString("stamp");
        PreparedStatement st =con.prepareStatement("Update messages set readstatus ="+"'read'"+"where messages.stamp= '"+time+"' and messages.to='"+ main.lbluser.getText().toString()+"'");
        st.executeUpdate();
        
                
        }
        else{
            JOptionPane.showMessageDialog(rootPane,"This is the last message");
        }
      } catch ( SQLException ex) {
        Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
    } 
        
        
        
    }//GEN-LAST:event_btnnextActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
                   unread();
            read();
  
    }//GEN-LAST:event_formInternalFrameActivated

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try {
            // TODO add your handling code here:
           int c=JOptionPane.showInternalConfirmDialog(rootPane, "Are you  sure you want to delete this message");
       if(c==0){
           
           if(rst.next()){
                 String time = rst.getString("stamp");
                    PreparedStatement st =con.prepareStatement("delete from messages where messages.stamp= '"+time+"' and messages.to='"+ main.lbluser.getText().toString()+"'");
     
                    st.executeUpdate();
                     txtfrom.setText("");
            txtsubject.setText("");
            txtmessage.setText("");
           
        JOptionPane.showMessageDialog(rootPane, "Message has been deleted");
     
       }}
       
                 
        } catch (SQLException ex) {
            Logger.getLogger(read.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }//GEN-LAST:event_btndeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprev;
    private javax.swing.JButton btnreply;
    private com.jgoodies.looks.plastic.theme.ExperienceBlue experienceBlue1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblfullname;
    private javax.swing.JLabel lblhead;
    private javax.swing.JLabel lblidnumber;
    private javax.swing.JLabel lblusername;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JTextField txtfrom;
    private javax.swing.JTextArea txtmessage;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtsubject;
    // End of variables declaration//GEN-END:variables
}
