/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_administrator_windows;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author griffin
 */
public class users extends javax.swing.JInternalFrame {
public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
    public users() {
        initComponents();
        readcred();
       allusers();
      }
    public void cleartable(){
       int e= tblusers.getRowCount();
       int r=0;
       while(r<e){
             tblusers.setValueAt("",r,0);
             tblusers.setValueAt("",r,1);
             tblusers.setValueAt("",r,2);
  r++;
       }
    
}
    public void allusers(){
    try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String sql="select * from users sort order by status";
ResultSet rs=st.executeQuery(sql);
int r=0;
while((rs.next())&&(rs.getString("status").equals("offline"))){
    
    
    
    tblusers.setValueAt(rs.getString("username"),r,0);
    tblusers.setValueAt(rs.getString("fullname"),r,1);
    tblusers.setValueAt(rs.getString("status"),r,2);
   
   r++; 
    
    }
    rs.beforeFirst();
    int s=r;
 while((rs.next())&&(rs.getString("status").equals("online"))){
    
    
    
    tblusers.setValueAt(rs.getString("username"),s,0);
    tblusers.setValueAt(rs.getString("fullname"),s,1);
    tblusers.setValueAt(rs.getString("status"),s,2);
   
   
   s++; 
    
    }
    tblusers.setRowSelectionInterval(r,s-1);
    tblusers.setSelectionBackground(Color.green);
    tblusers.setSelectionForeground(Color.black);
    
     
   




    } catch (ClassNotFoundException ex) {
        Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
    }
   
        
        
    }
    public void onlineusers(){
         try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String sql="select * from users where status='online'";
ResultSet rs=st.executeQuery(sql);
int r=0;
while((rs.next())){
    
    
    
    tblusers.setValueAt(rs.getString("username"),r,0);
    tblusers.setValueAt(rs.getString("fullname"),r,1);
    tblusers.setValueAt(rs.getString("status"),r,2);
   
   r++; 
    
    }
 
    tblusers.setRowSelectionInterval(0,r-1);
    tblusers.setSelectionBackground(Color.green);
    tblusers.setSelectionForeground(Color.black);
    
     
   




    } catch (ClassNotFoundException ex) {
        Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
    }
      
    }
    public void offlineusers(){
         try {
             
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String sql="select * from users where status='offline'";
ResultSet rs=st.executeQuery(sql);
int r=0;
tblusers.selectAll();
tblusers.setSelectionBackground(Color.white);
while((rs.next())){
    
    
    
    tblusers.setValueAt(rs.getString("username"),r,0);
    tblusers.setValueAt(rs.getString("fullname"),r,1);
    tblusers.setValueAt(rs.getString("status"),r,2);
   
   r++; 
    
    }
 
    
     
   




    } catch (ClassNotFoundException ex) {
        Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
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


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brownSugar1 = new com.jgoodies.looks.plastic.theme.BrownSugar();
        pnllogin = new javax.swing.JPanel();
        btnall = new javax.swing.JButton();
        lblusername2 = new javax.swing.JLabel();
        btnoffline = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusers = new javax.swing.JTable();
        btnonline = new javax.swing.JButton();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setToolTipText("");
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnall.setBackground(new java.awt.Color(51, 51, 51));
        btnall.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnall.setForeground(new java.awt.Color(51, 255, 0));
        btnall.setText("All Users");
        btnall.setToolTipText("");
        btnall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnallActionPerformed(evt);
            }
        });

        lblusername2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername2.setText(" Users ");

        btnoffline.setBackground(new java.awt.Color(51, 51, 51));
        btnoffline.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnoffline.setForeground(new java.awt.Color(153, 0, 51));
        btnoffline.setText("Offline Users");
        btnoffline.setToolTipText("");
        btnoffline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnofflineActionPerformed(evt);
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

        tblusers.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Username", "Fullname", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblusers.setEnabled(false);
        jScrollPane1.setViewportView(tblusers);

        btnonline.setBackground(new java.awt.Color(51, 51, 51));
        btnonline.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnonline.setForeground(new java.awt.Color(51, 255, 0));
        btnonline.setText("Online Users");
        btnonline.setToolTipText("");
        btnonline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnonlineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnall, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnonline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnoffline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblusername2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnoffline)
                    .addComponent(btnonline)
                    .addComponent(btnall))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnllogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnofflineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnofflineActionPerformed
        // TODO add your handling code here:
        cleartable();
        offlineusers();
    }//GEN-LAST:event_btnofflineActionPerformed

    private void btnallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnallActionPerformed
        // TODO add your handling code here:
        cleartable();
        allusers();        
    }//GEN-LAST:event_btnallActionPerformed

    private void btnonlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnonlineActionPerformed
        // TODO add your handling code here:
        cleartable();
        onlineusers();
    }//GEN-LAST:event_btnonlineActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnall;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnoffline;
    private javax.swing.JButton btnonline;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblusername2;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JTable tblusers;
    // End of variables declaration//GEN-END:variables
}
