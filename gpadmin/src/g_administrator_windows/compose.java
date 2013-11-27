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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author griffin
 */
public class compose extends javax.swing.JInternalFrame {

    public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
    public compose() {
        initComponents();
        readcred();
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
        experienceBlue1 = new com.jgoodies.looks.plastic.theme.ExperienceBlue();
        pnllogin = new javax.swing.JPanel();
        lblusername = new javax.swing.JLabel();
        txtsubject = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        lblusername2 = new javax.swing.JLabel();
        btnsent = new javax.swing.JButton();
        lblfullname = new javax.swing.JLabel();
        txtto = new javax.swing.JTextField();
        lblidnumber = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmessage = new javax.swing.JTextArea();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setToolTipText("");
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N

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

        lblusername2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername2.setText("Compose Messages");

        btnsent.setBackground(new java.awt.Color(51, 51, 51));
        btnsent.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsent.setForeground(new java.awt.Color(255, 255, 255));
        btnsent.setText("Sent");
        btnsent.setToolTipText("");
        btnsent.setMaximumSize(new java.awt.Dimension(92, 28));
        btnsent.setMinimumSize(new java.awt.Dimension(92, 28));
        btnsent.setPreferredSize(new java.awt.Dimension(92, 28));
        btnsent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsentActionPerformed(evt);
            }
        });

        lblfullname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfullname.setText("To :");

        txtto.setBackground(new java.awt.Color(153, 255, 153));
        txtto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttoActionPerformed(evt);
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

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addComponent(lblfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnfind)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblusername2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                                .addComponent(btnsent, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblidnumber, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(lblusername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblidnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .addComponent(lblfooter)
                .addContainerGap(31, Short.MAX_VALUE))
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
         String sql = "Select * from users where username='" + txtto.getText()+ "'";
           ResultSet rs = stmnt.executeQuery(sql);

         if (rs.next()) {
               JOptionPane.showMessageDialog(rootPane, "User found");
           
            }
         else{
             
         Statement stm = con.createStatement();
         String sq = "Select * from users where fullname='" + txtto.getText()+ "'";
           ResultSet rrs = stm.executeQuery(sq);
           if(rrs.next()){
               JOptionPane.showMessageDialog(rootPane, "User found replacing fullname with username");
               txtto.setText(rrs.getString("username"));
           
             
         }
           else{
               JOptionPane.showMessageDialog(rootPane, "Recepient not found");
           }

         }
    
        
        
        
        
    }                                       

    catch (ClassNotFoundException ex) {
        Logger.getLogger(compose.class.getName()).log(Level.SEVERE, null, ex);

    }catch (SQLException ex) {
        Logger.getLogger(compose.class.getName()).log(Level.SEVERE, null, ex);
    }
   
     
       
        
    }//GEN-LAST:event_btnfindActionPerformed

    private void btnsentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsentActionPerformed
        // TODO add your handling code here:
         int sent=0;
         try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con;
         con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
         Statement stmnt = con.createStatement();
         String sql = "Select * from users where username='" + txtto.getText()+ "'";
         ResultSet rs = stmnt.executeQuery(sql);
         if (rs.next()) {
           sent=1;
            }
         else{
             
         Statement stm = con.createStatement();
         String sq = "Select * from users where fullname='" + txtto.getText()+ "'";
         ResultSet rrs = stm.executeQuery(sq);
           if(rrs.next()){
               JOptionPane.showMessageDialog(rootPane, "replacing fullname with username");
               txtto.setText(rrs.getString("username"));
               sent=1;
             
         }
           else{
               JOptionPane.showMessageDialog(rootPane, "Recepient not found message cannot be sent");
           }

         }
         if(sent==1){
             String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
              PreparedStatement st = con.prepareStatement("insert into messages values(?,?,?,?,?,?)");
              String from=main.lbluser.getText();
              System.out.println(""+from);
         st.setString(1,from );
         st.setString(2, txtto.getText() );
         st.setString(3,"pending");
        st.setString(4, txtsubject.getText());
        st.setString(5,txtmessage.getText());
        st.setString(6,timeStamp);
        
         st.executeUpdate();
           JOptionPane.showMessageDialog(rootPane, "Message sent");
           txtto.setText("");
           txtmessage.setText("");
           txtsubject.setText("");
             
         }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(compose.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(compose.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        
    }//GEN-LAST:event_btnsentActionPerformed

    private void txttoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnsent;
    private com.jgoodies.looks.plastic.theme.ExperienceBlue experienceBlue1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblfullname;
    private javax.swing.JLabel lblidnumber;
    private javax.swing.JLabel lblusername;
    private javax.swing.JLabel lblusername2;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JTextArea txtmessage;
    private javax.swing.JTextField txtsubject;
    private javax.swing.JTextField txtto;
    // End of variables declaration//GEN-END:variables
}
