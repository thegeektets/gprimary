/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_administrator_windows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
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
 * @author griffin
 */
public class subjects extends javax.swing.JInternalFrame {
public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
    public subjects
                () {
        initComponents();
        readcred();
       
      }
    public void cleartable(){
       int e= tblsubjects.getRowCount();
       int r=0;
       while(r<e){
             tblsubjects.setValueAt("",r,0);
             tblsubjects.setValueAt("",r,1);
             tblsubjects.setValueAt("",r,2);
  r++;
       }
    
}
    public void populate(){
    try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String sql="select * from subjects where class ='"+txtclass.getSelectedItem()+"'";
ResultSet rs=st.executeQuery(sql);
int r=0;
while(rs.next()){
    
    
    
    tblsubjects.setValueAt(rs.getString("subject"),r,0);
    tblsubjects.setValueAt(rs.getString("subjectsperweek"),r,1);
     tblsubjects.setValueAt(rs.getString("doubles"),r,2);
    
   r++; 
    
    }
  


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
    }
   
        
        
    }
    public void add(){
         try {
             int l=tblsubjects.getRowCount();
               int r=0;
             
           while(r<l){
                 
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String subjects = dbusername;
               String pass= dbpassword;
                   if(tblsubjects.getValueAt(r, l).toString().trim()==null){
                            r=l;
           
                   }
                   else{
                       Connection con = DriverManager.getConnection(host, subjects, pass);
PreparedStatement st=con.prepareStatement("insert into subjects values(?,?,?,?)");
    
    
    st.setInt(0,Integer.parseInt((String)txtclass.getSelectedItem()));    
    st.setString(1,(String)tblsubjects.getValueAt(r,0));
    st.setInt(2,Integer.parseInt((String)tblsubjects.getValueAt(r,1)));
    st.setString(3,(String)tblsubjects.getValueAt(r,2));
    
    st.executeUpdate();
    
    r++;
                 }
   
               }



    } catch (ClassNotFoundException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
    }
      
    }
    public void edit(){
        try {
             int l=15;
             
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
               int r=0;
                     if(tblsubjects.getValueAt(r, 1) == null){}
                     
                     else{
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
st.executeUpdate("delete from subjects where class='"+Integer.parseInt((String)txtclass.getSelectedItem())+"'");
                }
                   



    } catch (ClassNotFoundException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
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
        btnsave = new javax.swing.JButton();
        lblusername2 = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtclass = new javax.swing.JComboBox();
        btnedit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblsubjects = new javax.swing.JTable();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setToolTipText("");
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnsave.setBackground(new java.awt.Color(51, 51, 51));
        btnsave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsave.setForeground(new java.awt.Color(51, 255, 0));
        btnsave.setText("Save Record");
        btnsave.setToolTipText("");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        lblusername2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername2.setText("Subjects Offered Per Class");

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

        jLabel1.setText("Class");

        txtclass.setEditable(true);
        txtclass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8" }));
        txtclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclassActionPerformed(evt);
            }
        });

        btnedit.setBackground(new java.awt.Color(51, 51, 51));
        btnedit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnedit.setForeground(new java.awt.Color(51, 255, 0));
        btnedit.setText("Edit Subjects");
        btnedit.setToolTipText("");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        tblsubjects.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "SUBJECT", "LESSONS /WEEK", "DOUBLES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblsubjects);

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(btnedit, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(btnexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblusername2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addComponent(btnsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnedit)
                        .addGap(12, 12, 12)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnllogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        try{
              try {
             int l=tblsubjects.getRowCount();
               int r=0;
             
           while(r<l){
                 
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
                   if(tblsubjects.getValueAt(r, 0) == null){
                            r=l;
           
                   }
                   else{
                       Connection con = DriverManager.getConnection(host, user, pass);
PreparedStatement st=con.prepareStatement("insert into subjects values(?,?,?,?)");
    
    
    st.setInt(1,Integer.parseInt((String)txtclass.getSelectedItem()));    
    st.setString(2,(String)tblsubjects.getValueAt(r,0));
    st.setInt(3, (Integer)tblsubjects.getValueAt(r,1));
    st.setString(4,(String)tblsubjects.getValueAt(r,2));
    
    st.executeUpdate();
    
    r++;
                 }
                   }


 JOptionPane.showMessageDialog(rootPane,"Record Saved");
  
         
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
    }
                       
        }
        catch (Exception e){
            e.printStackTrace();
              JOptionPane.showMessageDialog(rootPane,"Save operation failed");
            
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        try{  
              edit();
                         try {
             int l=tblsubjects.getRowCount();
               int r=0;
             
           while(r<l){
                 
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
                   if(tblsubjects.getValueAt(r, 0) == null){
                            r=l;
           
                   }
                   else{
                       Connection con = DriverManager.getConnection(host, user, pass);
PreparedStatement st=con.prepareStatement("insert into subjects values(?,?,?,?)");
    
    
    st.setInt(1,Integer.parseInt((String)txtclass.getSelectedItem()));    
    st.setString(2,(String)tblsubjects.getValueAt(r,0));
    st.setInt(3,(Integer)tblsubjects.getValueAt(r,1));
    st.setString(4,(String)tblsubjects.getValueAt(r,2));
    
    st.executeUpdate();
    
    r++;
                 }
                   }


 JOptionPane.showMessageDialog(rootPane,"Record Saved");
  
         
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(subjects.class.getName()).log(Level.SEVERE, null, ex);
    }
                      
        }
        catch (Exception e){
            e.printStackTrace();
              JOptionPane.showMessageDialog(rootPane,"Edit operation failed");
            
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void txtclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclassActionPerformed
        // TODO add your handling code here:
        populate();
    }//GEN-LAST:event_txtclassActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblusername2;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JTable tblsubjects;
    private javax.swing.JComboBox txtclass;
    // End of variables declaration//GEN-END:variables
}
