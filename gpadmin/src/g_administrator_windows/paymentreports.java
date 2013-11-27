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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;


/**
 *
 * @author griffin
 */
public class paymentreports extends javax.swing.JInternalFrame {
public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
int action;
JComboBox txtclas;
    public paymentreports   () {
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
        pnllogin = new javax.swing.JPanel();
        lblhead = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtterm = new javax.swing.JComboBox();
        txtyear = new com.toedter.calendar.JYearChooser();
        txtcls = new javax.swing.JComboBox();
        btnclasspreview = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        btnstreampreview = new javax.swing.JButton();
        txtstream = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        pnlschoolpayment = new javax.swing.JPanel();
        btntermpreview = new javax.swing.JButton();
        btnyearpreview = new javax.swing.JButton();
        pnlschoolpayment1 = new javax.swing.JPanel();
        btnstreamanalysis = new javax.swing.JButton();
        btnclassanalysis = new javax.swing.JButton();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Fees Termly Payment Reports");
        setToolTipText("");
        setDoubleBuffered(true);
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/g_administrator_windows/hslogo.jpg"))); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblhead.setBackground(new java.awt.Color(204, 255, 204));
        lblhead.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblhead.setText("Fees Termly Payment Reports");
        lblhead.setOpaque(true);

        jLabel1.setText("Class");

        jLabel2.setText("Term:");

        jLabel3.setText("Year:");

        txtterm.setEditable(true);
        txtterm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        txtterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttermActionPerformed(evt);
            }
        });

        txtcls.setEditable(true);
        txtcls.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        txtcls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclsActionPerformed(evt);
            }
        });

        btnclasspreview.setBackground(new java.awt.Color(51, 51, 51));
        btnclasspreview.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnclasspreview.setForeground(new java.awt.Color(51, 255, 0));
        btnclasspreview.setText("Print and Preview Report Per Class");
        btnclasspreview.setToolTipText("");
        btnclasspreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclasspreviewActionPerformed(evt);
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

        btnstreampreview.setBackground(new java.awt.Color(51, 51, 51));
        btnstreampreview.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnstreampreview.setForeground(new java.awt.Color(51, 255, 0));
        btnstreampreview.setText("Print and Preview Report Per Stream");
        btnstreampreview.setToolTipText("");
        btnstreampreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstreampreviewActionPerformed(evt);
            }
        });

        txtstream.setEditable(true);
        txtstream.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "North", "East", "West", "South" }));
        txtstream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstreamActionPerformed(evt);
            }
        });

        jLabel4.setText("Stream");

        pnlschoolpayment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "School Reports", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N

        btntermpreview.setBackground(new java.awt.Color(51, 51, 51));
        btntermpreview.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btntermpreview.setForeground(new java.awt.Color(51, 255, 0));
        btntermpreview.setText("Print and Preview Report Per Term");
        btntermpreview.setToolTipText("");
        btntermpreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermpreviewActionPerformed(evt);
            }
        });

        btnyearpreview.setBackground(new java.awt.Color(51, 51, 51));
        btnyearpreview.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnyearpreview.setForeground(new java.awt.Color(51, 255, 0));
        btnyearpreview.setText("Print and Preview Report Per Year");
        btnyearpreview.setToolTipText("");
        btnyearpreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnyearpreviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlschoolpaymentLayout = new javax.swing.GroupLayout(pnlschoolpayment);
        pnlschoolpayment.setLayout(pnlschoolpaymentLayout);
        pnlschoolpaymentLayout.setHorizontalGroup(
            pnlschoolpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlschoolpaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlschoolpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntermpreview, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnyearpreview, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlschoolpaymentLayout.setVerticalGroup(
            pnlschoolpaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlschoolpaymentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btntermpreview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnyearpreview)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlschoolpayment1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Analysis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N

        btnstreamanalysis.setBackground(new java.awt.Color(51, 51, 51));
        btnstreamanalysis.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnstreamanalysis.setForeground(new java.awt.Color(51, 255, 0));
        btnstreamanalysis.setText("Analysis per stream");
        btnstreamanalysis.setToolTipText("");
        btnstreamanalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstreamanalysisActionPerformed(evt);
            }
        });

        btnclassanalysis.setBackground(new java.awt.Color(51, 51, 51));
        btnclassanalysis.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnclassanalysis.setForeground(new java.awt.Color(51, 255, 0));
        btnclassanalysis.setText("Analysis per class");
        btnclassanalysis.setToolTipText("");
        btnclassanalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclassanalysisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlschoolpayment1Layout = new javax.swing.GroupLayout(pnlschoolpayment1);
        pnlschoolpayment1.setLayout(pnlschoolpayment1Layout);
        pnlschoolpayment1Layout.setHorizontalGroup(
            pnlschoolpayment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlschoolpayment1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlschoolpayment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnstreamanalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclassanalysis, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlschoolpayment1Layout.setVerticalGroup(
            pnlschoolpayment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlschoolpayment1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnstreamanalysis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnclassanalysis)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlschoolpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlschoolpayment1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                                        .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(221, 221, 221)
                                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                                        .addComponent(txtcls, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(71, 71, 71)
                                        .addComponent(btnstreampreview, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlloginLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtyear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(pnlloginLayout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtstream, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnclasspreview, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addComponent(lblhead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcls, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstream, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtyear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnstreampreview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnclasspreview)
                        .addGap(22, 22, 22)))
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnexit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlschoolpayment1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlschoolpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Fees Statement");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void txttermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttermActionPerformed

    private void btnclasspreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclasspreviewActionPerformed
        // TODO add your handling code here:
            try {
      try
      {
     String key=""+txtyear.getYear()+txtterm.getSelectedItem()+txtcls.getSelectedItem();

          Class.forName("com.mysql.jdbc.Driver");
   
        Connection con =  DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        Map parameters = new HashMap();
       parameters.put("class",(txtcls.getSelectedItem()));
       parameters.put("term",(txtterm.getSelectedItem()));
        parameters.put("year",(txtyear.getYear()));
         
        JasperReport report = (JasperReport)JRLoader.loadObject(getClass().getResource("classfeespayment.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, con);
        JFrame frame = new JFrame("Fees Payment");
        frame.getContentPane().add(new JRViewer(jasperPrint));
        frame.setVisible(true);
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      } catch (SQLException e) {
          e.printStackTrace();
       JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+e.getMessage());

          
     
      }
    } catch (Exception exr) {
        exr.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+exr.getMessage());
    }
        
    }//GEN-LAST:event_btnclasspreviewActionPerformed

    private void btnstreampreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstreampreviewActionPerformed

        
             try {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
   
        Connection con =  DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        Map parameters = new HashMap();
            parameters.put("class",(txtcls.getSelectedItem()));
       parameters.put("stream",(txtstream.getSelectedItem()));
        parameters.put("term",(txtterm.getSelectedItem()));
        parameters.put("year",(txtyear.getYear()));
       
        JasperReport report = (JasperReport)JRLoader.loadObject(getClass().getResource("streamfeespayment.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, con);
        JFrame frame = new JFrame("Fees Payment");
        frame.getContentPane().add(new JRViewer(jasperPrint));
        frame.setVisible(true);
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      } catch (SQLException e) {
          e.printStackTrace();
       JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+e.getMessage());

          
     
      }
    } catch (Exception exr) {
        exr.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+exr.getMessage());
    }
        
        
        
        
    }//GEN-LAST:event_btnstreampreviewActionPerformed

    private void btntermpreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermpreviewActionPerformed
        // TODO add your handling code here:
                  try {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
   
        Connection con =  DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        Map parameters = new HashMap();
         parameters.put("term",(txtterm.getSelectedItem()));
        parameters.put("year",(txtyear.getYear()));
       
        JasperReport report = (JasperReport)JRLoader.loadObject(getClass().getResource("termlyfeespayment.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, con);
        JFrame frame = new JFrame("Fees Payment");
        frame.getContentPane().add(new JRViewer(jasperPrint));
        frame.setVisible(true);
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      } catch (SQLException e) {
          e.printStackTrace();
       JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+e.getMessage());

          
     
      }
    } catch (Exception exr) {
        exr.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+exr.getMessage());
    }
        
    }//GEN-LAST:event_btntermpreviewActionPerformed

    private void btnyearpreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnyearpreviewActionPerformed
        // TODO add your handling code here:
                   try {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
   
        Connection con =  DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        Map parameters = new HashMap();
         parameters.put("year",(txtyear.getYear()));
       
        JasperReport report = (JasperReport)JRLoader.loadObject(getClass().getResource("yearfeespayment.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, con);
        JFrame frame = new JFrame("Fees Payment");
        frame.getContentPane().add(new JRViewer(jasperPrint));
        frame.setVisible(true);
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      } catch (SQLException e) {
          e.printStackTrace();
       JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+e.getMessage());

          
     
      }
    } catch (Exception exr) {
        exr.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+exr.getMessage());
    }
    }//GEN-LAST:event_btnyearpreviewActionPerformed

    private void btnstreamanalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstreamanalysisActionPerformed
        
             try {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
   
        Connection con =  DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        Map parameters = new HashMap();
            parameters.put("class",(txtcls.getSelectedItem()));
       parameters.put("stream",(txtstream.getSelectedItem()));
        parameters.put("term",(txtterm.getSelectedItem()));
        parameters.put("year",(txtyear.getYear()));
       
        JasperReport report = (JasperReport)JRLoader.loadObject(getClass().getResource("streampaymentanalysis.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, con);
        JFrame frame = new JFrame("Fees Payment");
        frame.getContentPane().add(new JRViewer(jasperPrint));
        frame.setVisible(true);
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      } catch (SQLException e) {
          e.printStackTrace();
       JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+e.getMessage());

          
     
      }
    } catch (Exception exr) {
        exr.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+exr.getMessage());
    }
    }//GEN-LAST:event_btnstreamanalysisActionPerformed

    private void btnclassanalysisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclassanalysisActionPerformed
       
             try {
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
   
        Connection con =  DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        Map parameters = new HashMap();
            parameters.put("class",(txtcls.getSelectedItem()));
        parameters.put("term",(txtterm.getSelectedItem()));
        parameters.put("year",(txtyear.getYear()));
       
        JasperReport report = (JasperReport)JRLoader.loadObject(getClass().getResource("classpaymentanalysis.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, con);
        JFrame frame = new JFrame("Fees Payment");
        frame.getContentPane().add(new JRViewer(jasperPrint));
        frame.setVisible(true);
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      } catch (SQLException e) {
          e.printStackTrace();
       JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+e.getMessage());

          
     
      }
    } catch (Exception exr) {
        exr.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+exr.getMessage());
    }
    }//GEN-LAST:event_btnclassanalysisActionPerformed

    private void txtstreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstreamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstreamActionPerformed

    private void txtclsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnclassanalysis;
    private javax.swing.JButton btnclasspreview;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnstreamanalysis;
    private javax.swing.JButton btnstreampreview;
    private javax.swing.JButton btntermpreview;
    private javax.swing.JButton btnyearpreview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblhead;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JPanel pnlschoolpayment;
    private javax.swing.JPanel pnlschoolpayment1;
    private javax.swing.JComboBox txtcls;
    private javax.swing.JComboBox txtstream;
    private javax.swing.JComboBox txtterm;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
