/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_administrator_windows;
import g_administrator_windows.dbsetup;
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
public class teachers extends javax.swing.JInternalFrame {

    public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
    public teachers() {
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
        btnadd = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        lblemail = new javax.swing.JLabel();
        lblusername2 = new javax.swing.JLabel();
        lblsex = new javax.swing.JLabel();
        txtresponsibility = new javax.swing.JComboBox();
        btnclear = new javax.swing.JButton();
        lblfullname = new javax.swing.JLabel();
        txtfullname = new javax.swing.JTextField();
        lblidnumber = new javax.swing.JLabel();
        txtidnumber = new javax.swing.JTextField();
        txtdepartment = new javax.swing.JTextField();
        lbldepartment = new javax.swing.JLabel();
        txtsex = new javax.swing.JComboBox();
        pnlsubjects = new javax.swing.JPanel();
        txtsubject1 = new javax.swing.JTextField();
        lblfullname1 = new javax.swing.JLabel();
        txtsubject2 = new javax.swing.JTextField();
        txtsubject4 = new javax.swing.JTextField();
        txtsubject3 = new javax.swing.JTextField();
        lblfullname2 = new javax.swing.JLabel();
        lblfullname3 = new javax.swing.JLabel();
        lblfullname4 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setToolTipText("");
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnadd.setBackground(new java.awt.Color(51, 51, 51));
        btnadd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnadd.setForeground(new java.awt.Color(51, 255, 0));
        btnadd.setText("Add Record");
        btnadd.setToolTipText("");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
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

        lblemail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblemail.setText("Responsibilities");

        lblusername2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername2.setText("Teacher's Profile");

        lblsex.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblsex.setText("Sex");

        txtresponsibility.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtresponsibility.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Subject Teacher", "Class Teacher", "Department Head", "Senior Master", "Deputy Principal", "Principal" }));

        btnclear.setBackground(new java.awt.Color(51, 51, 51));
        btnclear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("Clear");
        btnclear.setToolTipText("");
        btnclear.setMaximumSize(new java.awt.Dimension(92, 28));
        btnclear.setMinimumSize(new java.awt.Dimension(92, 28));
        btnclear.setPreferredSize(new java.awt.Dimension(92, 28));
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        lblfullname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfullname.setText("Fullname:");

        txtfullname.setBackground(new java.awt.Color(153, 255, 153));
        txtfullname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtfullname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtfullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfullnameActionPerformed(evt);
            }
        });

        lblidnumber.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblidnumber.setText("Id number:");

        txtidnumber.setBackground(new java.awt.Color(153, 255, 153));
        txtidnumber.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtidnumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtidnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidnumberActionPerformed(evt);
            }
        });

        txtdepartment.setBackground(new java.awt.Color(153, 255, 153));
        txtdepartment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtdepartment.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtdepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdepartmentActionPerformed(evt);
            }
        });

        lbldepartment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbldepartment.setText("Department");

        txtsex.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female", "" }));

        pnlsubjects.setBorder(javax.swing.BorderFactory.createTitledBorder("Subjects Taught:"));

        txtsubject1.setBackground(new java.awt.Color(255, 255, 153));
        txtsubject1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsubject1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtsubject1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubject1ActionPerformed(evt);
            }
        });

        lblfullname1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfullname1.setText("Subject 1:");

        txtsubject2.setBackground(new java.awt.Color(255, 255, 153));
        txtsubject2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsubject2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtsubject2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubject2ActionPerformed(evt);
            }
        });

        txtsubject4.setBackground(new java.awt.Color(255, 255, 153));
        txtsubject4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsubject4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtsubject4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubject4ActionPerformed(evt);
            }
        });

        txtsubject3.setBackground(new java.awt.Color(255, 255, 153));
        txtsubject3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsubject3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtsubject3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubject3ActionPerformed(evt);
            }
        });

        lblfullname2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfullname2.setText("Subject 2:");

        lblfullname3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfullname3.setText("Subject 4:");

        lblfullname4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfullname4.setText("Subject 3:");

        javax.swing.GroupLayout pnlsubjectsLayout = new javax.swing.GroupLayout(pnlsubjects);
        pnlsubjects.setLayout(pnlsubjectsLayout);
        pnlsubjectsLayout.setHorizontalGroup(
            pnlsubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsubjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlsubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlsubjectsLayout.createSequentialGroup()
                        .addComponent(lblfullname3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(78, 78, 78)
                        .addComponent(txtsubject4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlsubjectsLayout.createSequentialGroup()
                        .addComponent(lblfullname4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(78, 78, 78)
                        .addComponent(txtsubject3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlsubjectsLayout.createSequentialGroup()
                        .addGroup(pnlsubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblfullname1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblfullname2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78)
                        .addGroup(pnlsubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsubject1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsubject2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlsubjectsLayout.setVerticalGroup(
            pnlsubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsubjectsLayout.createSequentialGroup()
                .addGroup(pnlsubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsubject1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfullname1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlsubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlsubjectsLayout.createSequentialGroup()
                        .addGroup(pnlsubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsubject2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblfullname2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlsubjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsubject3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblfullname4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtsubject4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlsubjectsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblfullname3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

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
        btnsearch.setText("Search with ID");
        btnsearch.setToolTipText("");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(51, 51, 51));
        btndelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 0, 0));
        btndelete.setText("Delete Record");
        btndelete.setToolTipText("");
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
                .addComponent(pnlsubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblfullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblidnumber, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsex, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtfullname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtidnumber)
                    .addComponent(txtdepartment)
                    .addComponent(txtresponsibility, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsearch))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addComponent(btnadd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblfullname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblidnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(txtdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbldepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtresponsibility, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsex, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlsubjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete)))
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
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
       
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        try {
           Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
          PreparedStatement s = con.prepareStatement("insert into teachers(idnumber,fullname,sex,department,responsibility,subject1,subject2,subject3,subject4) values(?,?,?,?,?,?,?,?,?)");
      s.setInt(1, Integer.parseInt(txtidnumber.getText()));
      s.setString(2, txtfullname.getText());
      s.setString(3,(String)txtsex.getSelectedItem());
      s.setString(4, txtdepartment.getText());
      s.setString(5,(String)txtresponsibility.getSelectedItem());
      s.setString(6, txtsubject1.getText());
      s.setString(7, txtsubject2.getText());
      s.setString(8, txtsubject3.getText());
      s.setString(9, txtsubject4.getText());
      
      s.executeUpdate();
      JOptionPane.showMessageDialog(rootPane, "Record Saved");
          
          
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teachers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(teachers.class.getName()).log(Level.SEVERE, null, ex);
        }

     
       
        
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        txtfullname.setText("");
        txtidnumber.setText("");
        txtsubject1.setText("");
        txtsubject2.setText("");
        txtsubject3.setText("");
        txtdepartment.setText("");
        txtresponsibility.setSelectedItem("");
        txtsubject4.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void txtfullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfullnameActionPerformed

    private void txtidnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidnumberActionPerformed

    private void txtdepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdepartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdepartmentActionPerformed

    private void txtsubject1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubject1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubject1ActionPerformed

    private void txtsubject2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubject2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubject2ActionPerformed

    private void txtsubject4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubject4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubject4ActionPerformed

    private void txtsubject3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubject3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubject3ActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
                try {
           Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
          ResultSet  rs;
          Statement stm =con.createStatement();
                    rs = stm.executeQuery("select * from teachers where idnumber='"+txtsearch.getText()+"'");
                    if(rs.next()){
      JOptionPane.showMessageDialog(rootPane, "Record found");
                        txtidnumber.setText(""+rs.getInt("idnumber"));
      txtfullname.setText(rs.getString("fullname"));
      txtsex.setSelectedItem(rs.getString("sex"));
      txtdepartment.setText(rs.getString("department"));
      txtresponsibility.setSelectedItem(rs.getString("responsibility"));
      txtsubject1.setText(rs.getString("subject1"));
      txtsubject2.setText(rs.getString("subject2"));
      txtsubject3.setText(rs.getString("subject3"));
      txtsubject3.setText(rs.getString("subject4"));
                    }
                    else{
      JOptionPane.showMessageDialog(rootPane, "Record not found");
                    }
          
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teachers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(teachers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
                  int c =JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record");
                  if(c==0){
                               try {
     
           Class.forName("com.mysql.jdbc.Driver");
           
          Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
          Statement stm =con.createStatement();
          stm.executeUpdate("delete from teachers where idnumber='"+txtsearch.getText()+"'");
                     
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teachers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(teachers.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Something went wrong please try again check record you are trying to delete exists");
      
            
        }
    }
    }//GEN-LAST:event_btndeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsearch;
    private com.jgoodies.looks.plastic.theme.ExperienceBlue experienceBlue1;
    private javax.swing.JLabel lbldepartment;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblfullname;
    private javax.swing.JLabel lblfullname1;
    private javax.swing.JLabel lblfullname2;
    private javax.swing.JLabel lblfullname3;
    private javax.swing.JLabel lblfullname4;
    private javax.swing.JLabel lblidnumber;
    private javax.swing.JLabel lblsex;
    private javax.swing.JLabel lblusername2;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JPanel pnlsubjects;
    private javax.swing.JTextField txtdepartment;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtidnumber;
    private javax.swing.JComboBox txtresponsibility;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JComboBox txtsex;
    private javax.swing.JTextField txtsubject1;
    private javax.swing.JTextField txtsubject2;
    private javax.swing.JTextField txtsubject3;
    private javax.swing.JTextField txtsubject4;
    // End of variables declaration//GEN-END:variables
}
