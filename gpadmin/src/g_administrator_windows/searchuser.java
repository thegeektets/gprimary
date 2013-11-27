/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_administrator_windows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author griffin
 */
public class searchuser extends javax.swing.JInternalFrame {
    public String dbhostip = null;
    public String dbpassword = null;
    public String database = null;
    public String dbusername = null;
 
    public searchuser() {
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

        brownSugar1 = new com.jgoodies.looks.plastic.theme.BrownSugar();
        pnllogin = new javax.swing.JPanel();
        lblpassword = new javax.swing.JLabel();
        lblusername = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        btnedit = new javax.swing.JButton();
        btnblock = new javax.swing.JButton();
        txtcpassword = new javax.swing.JPasswordField();
        lblcpassword = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        lblusername2 = new javax.swing.JLabel();
        lblhome = new javax.swing.JLabel();
        txthome = new javax.swing.JTextField();
        lblbirthday = new javax.swing.JLabel();
        lblsex = new javax.swing.JLabel();
        txtsex = new javax.swing.JComboBox();
        txtdate = new com.toedter.calendar.JDateChooser();
        lblsearch = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        lblusername1 = new javax.swing.JLabel();
        txtfullname = new javax.swing.JTextField();
        btnunblock = new javax.swing.JButton();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setToolTipText("");
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblpassword.setText("Password:");

        lblusername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername.setText("Username:");

        txtusername.setBackground(new java.awt.Color(153, 255, 153));
        txtusername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtusername.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });

        txtpassword.setBackground(new java.awt.Color(153, 255, 153));
        txtpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtpassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnedit.setBackground(new java.awt.Color(51, 51, 51));
        btnedit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnedit.setForeground(new java.awt.Color(51, 255, 0));
        btnedit.setText("Edit");
        btnedit.setToolTipText("");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnblock.setBackground(new java.awt.Color(51, 51, 51));
        btnblock.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnblock.setForeground(new java.awt.Color(255, 0, 0));
        btnblock.setText("Block");
        btnblock.setToolTipText("");
        btnblock.setMaximumSize(new java.awt.Dimension(92, 28));
        btnblock.setMinimumSize(new java.awt.Dimension(92, 28));
        btnblock.setPreferredSize(new java.awt.Dimension(92, 28));
        btnblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnblockActionPerformed(evt);
            }
        });

        txtcpassword.setBackground(new java.awt.Color(153, 255, 153));
        txtcpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcpassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblcpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblcpassword.setText("Confirm:");

        lblemail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblemail.setText("Email Address");

        txtemail.setBackground(new java.awt.Color(153, 255, 153));
        txtemail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtemail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        lblusername2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername2.setText("Find User ");

        lblhome.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblhome.setText("Home");

        txthome.setBackground(new java.awt.Color(153, 255, 153));
        txthome.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txthome.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txthome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthomeActionPerformed(evt);
            }
        });

        lblbirthday.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblbirthday.setText("Birthday");

        lblsex.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblsex.setText("Sex");

        txtsex.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", "" }));

        lblsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblsearch.setText("Search");

        txtsearch.setBackground(new java.awt.Color(153, 255, 153));
        txtsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });

        btnsearch.setBackground(new java.awt.Color(51, 51, 51));
        btnsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(51, 255, 0));
        btnsearch.setText("Search");
        btnsearch.setToolTipText("");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
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

        lblusername1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername1.setText("Fullname:");

        txtfullname.setBackground(new java.awt.Color(153, 255, 153));
        txtfullname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtfullname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtfullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfullnameActionPerformed(evt);
            }
        });

        btnunblock.setBackground(new java.awt.Color(51, 51, 51));
        btnunblock.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnunblock.setForeground(new java.awt.Color(51, 255, 0));
        btnunblock.setText("Unblock");
        btnunblock.setToolTipText("");
        btnunblock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnunblockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnedit)
                .addGap(18, 18, 18)
                .addComponent(btnblock, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblcpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblusername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblusername1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtusername, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtfullname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtemail)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addComponent(lblhome, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthome))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsex, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblbirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtsex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(lblsearch, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsearch)
                                .addGap(23, 23, 23))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(lblusername2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(btnunblock)))
                .addContainerGap())
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addComponent(lblusername2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch)
                    .addComponent(btnunblock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblusername1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblhome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblbirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsex, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnedit)
                    .addComponent(btnblock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(lblfooter, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusernameActionPerformed

    private void btnblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnblockActionPerformed
 int c=JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to block "+txtusername.getText());
 if (c==0){     
 try {
                     Class.forName("com.mysql.jdbc.Driver");
                   String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                           String user = dbusername;
                           String pass= dbpassword;
            Connection con = DriverManager.getConnection(host, user, pass);
            con.setAutoCommit(false);
            Statement st=con.createStatement();
            String sql="select * from users where username='"+txtsearch.getText()+"'";
            ResultSet rs=st.executeQuery(sql);
            rs.next();
           PreparedStatement s = con.prepareStatement("INSERT INTO blockedusers values(?,?,?,?,?,?,?,?,?,?,?,?)");
      s.setInt(1, rs.getInt("idnumber"));
      s.setString(2, rs.getString("username"));
      s.setString(3, rs.getString("fullname"));
      s.setString(4, rs.getString("password"));
      s.setString(5, "offline");
      s.setString(6, rs.getString("email"));
      s.setDate(7, rs.getDate("birthday"));
      s.setString(8, rs.getString("sex"));
      s.setString(9, rs.getString("hint"));
      s.setString(10, rs.getString("department"));
      s.setString(11, rs.getString("privilidges"));
      s.setString(12, rs.getString("home"));
      s.executeUpdate();
      
      Statement stm=con.createStatement();
      String sq="delete from users where username='"+txtsearch.getText()+"'";
      stm.execute(sq);
      con.commit();
      JOptionPane.showMessageDialog(rootPane, txtusername.getText() + " Has been blocked");
      
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchuser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchuser.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
    }//GEN-LAST:event_btnblockActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try {
            // TODO add your handling code here:
                 Class.forName("com.mysql.jdbc.Driver");
               String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                       String user = dbusername;
                       String pass= dbpassword;
        Connection con = DriverManager.getConnection(host, user, pass);
        if(txtpassword.getText().isEmpty()==false){
            if(txtpassword.getText().equals(txtcpassword.getText())){
                PreparedStatement st =con.prepareStatement("Update users set username=?,fullname=?,password=?,email=?,home=?,birthday=?,sex=? where username='"+txtsearch.getText()+"'");
                st.setString(1, txtusername.getText());
                st.setString(2, txtfullname.getText());
                st.setString(3, MD5(txtpassword.getText()));
                st.setString(4, txtemail.getText());
                st.setString(5, txthome.getText());
                  java.util.Date date=txtdate.getDate();
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
     
                 st.setDate(6, sqldate);
                 st.setString(7, (String) txtsex.getSelectedItem());
                 st.executeUpdate();
                JOptionPane.showMessageDialog(rootPane,"Update successfull");
                
                
                
                
                
            }
            else{
             JOptionPane.showMessageDialog(rootPane, "passwords do match record cannot be updated");
            }
        }
        else{
                    PreparedStatement st =con.prepareStatement("Update users set username=?,fullname=?,email=?,home=?,birthday=?,sex=? where username='"+txtsearch.getText()+"'");
                st.setString(1, txtusername.getText());
                st.setString(2, txtfullname.getText());
                st.setString(3, txtemail.getText());
                st.setString(4, txthome.getText());
                  java.util.Date date=txtdate.getDate();
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
     
                 st.setDate(5, sqldate);
                 st.setString(6, (String) txtsex.getSelectedItem());
                 st.executeUpdate();
                 JOptionPane.showMessageDialog(rootPane,"Update successfull");
                
        
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchuser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchuser.class.getName()).log(Level.SEVERE, null, ex);
        }
  
       
        
    }//GEN-LAST:event_btneditActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txthomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthomeActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        try {
            // TODO add your handling code here:
                 
           Class.forName("com.mysql.jdbc.Driver");
           String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                   String user = dbusername;
                   String pass= dbpassword;
    Connection con = DriverManager.getConnection(host, user, pass);
    Statement st=con.createStatement();
    String sql="select * from users where username='"+txtsearch.getText()+"'";
    ResultSet rs=st.executeQuery(sql);
    if(rs.next()){
        JOptionPane.showMessageDialog(rootPane,"Record found");   
        txtusername.setText(rs.getString("username"));
        txtfullname.setText(rs.getString("fullname"));
        txtemail.setText(rs.getString("email"));
        txtdate.setDate(rs.getDate("birthday"));
        txthome.setText(rs.getString("home"));
        txtsex.setSelectedItem(rs.getString("sex"));
    }else{
         Statement stm=con.createStatement();
   
        String sqlm="select * from users where fullname='"+txtsearch.getText()+"'";
    ResultSet rsm=stm.executeQuery(sql);
    if(rsm.next()){
         JOptionPane.showMessageDialog(rootPane,"Record found replacing search text with username");
         txtsearch.setText(rsm.getString("username"));
  
     txtusername.setText(rsm.getString("username"));
        txtfullname.setText(rsm.getString("fullname"));
        txtemail.setText(rsm.getString("email"));
        txtdate.setDate(rsm.getDate("birthday"));
        txthome.setText(rsm.getString("home"));
        txtsex.setSelectedItem(rsm.getString("sex"));
    }
    else{
     JOptionPane.showMessageDialog(rootPane,"No result found");   
    }}  } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchuser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchuser.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    }//GEN-LAST:event_btnsearchActionPerformed
    
    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_btnexitActionPerformed

    private void txtfullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameActionPerformed

    private void btnunblockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnunblockActionPerformed
        // TODO add your handling code here:
        int c=JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to unblock "+txtsearch.getText());
 if (c==0){     
 try {
                     Class.forName("com.mysql.jdbc.Driver");
                   String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                           String user = dbusername;
                           String pass= dbpassword;
            Connection con = DriverManager.getConnection(host, user, pass);
            con.setAutoCommit(false);
            Statement st=con.createStatement();
            String sql="select * from blockedusers where username='"+txtsearch.getText()+"'";
            ResultSet rs=st.executeQuery(sql);
            rs.next();
           PreparedStatement s = con.prepareStatement("INSERT INTO users values(?,?,?,?,?,?,?,?,?,?,?,?)");
      s.setInt(1, rs.getInt("idnumber"));
      s.setString(2, rs.getString("username"));
      s.setString(3, rs.getString("fullname"));
      s.setString(4, rs.getString("password"));
      s.setString(5, "offline");
      s.setString(6, rs.getString("email"));
      s.setDate(7, rs.getDate("birthday"));
      s.setString(8, rs.getString("sex"));
      s.setString(9, rs.getString("hint"));
      s.setString(10, rs.getString("department"));
      s.setString(11, rs.getString("privilidges"));
      s.setString(12, rs.getString("home"));
      s.executeUpdate();
      
      Statement stm=con.createStatement();
      String sq="delete from blockedusers where username='"+txtsearch.getText()+"'";
      stm.execute(sq);
      con.commit();
      JOptionPane.showMessageDialog(rootPane, txtsearch.getText() + " Has been unblocked");
      
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchuser.class.getName()).log(Level.SEVERE, null, ex);
      
        } catch (SQLException ex) {
            Logger.getLogger(searchuser.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, txtusername.getText() + " Could not unblocked check if username is right");
      
        }
 }
    
                                            

  
       
    }//GEN-LAST:event_btnunblockActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnblock;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnunblock;
    private javax.swing.JLabel lblbirthday;
    private javax.swing.JLabel lblcpassword;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblhome;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblsearch;
    private javax.swing.JLabel lblsex;
    private javax.swing.JLabel lblusername;
    private javax.swing.JLabel lblusername1;
    private javax.swing.JLabel lblusername2;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JPasswordField txtcpassword;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txthome;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JComboBox txtsex;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
