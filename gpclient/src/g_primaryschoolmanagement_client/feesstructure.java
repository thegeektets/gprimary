/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_primaryschoolmanagement_client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
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
public class feesstructure extends javax.swing.JInternalFrame {
public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
int action;
JComboBox txtclas;
    public feesstructure
                () {
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
        btnexit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtterm = new javax.swing.JComboBox();
        txtyear = new com.toedter.calendar.JYearChooser();
        txtcls = new javax.swing.JComboBox();
        btnsave1 = new javax.swing.JButton();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Fees Structure");
        setToolTipText("");
        setDoubleBuffered(true);
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/g_primaryschoolmanagement_client/hslogo.jpg"))); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblhead.setBackground(new java.awt.Color(204, 255, 204));
        lblhead.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblhead.setText("School Fees Structure :");
        lblhead.setOpaque(true);

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

        jLabel2.setText("Term:");

        jLabel3.setText("Year:");

        txtterm.setEditable(true);
        txtterm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        txtterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttermActionPerformed(evt);
            }
        });

        txtcls.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));

        btnsave1.setBackground(new java.awt.Color(51, 51, 51));
        btnsave1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsave1.setForeground(new java.awt.Color(51, 255, 0));
        btnsave1.setText("Search ");
        btnsave1.setToolTipText("");
        btnsave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsave1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(txtcls, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnsave1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addComponent(lblhead)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(456, 456, 456))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void txttermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttermActionPerformed

    private void btnsave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave1ActionPerformed
        // TODO add your handling code here:
                   try {
      try
      {
     String key=""+txtyear.getYear()+txtterm.getSelectedItem()+txtcls.getSelectedItem();

          Class.forName("com.mysql.jdbc.Driver");
   
        Connection con =  DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        Map parameters = new HashMap();
        parameters.put("key",(key));
       
        JasperReport report = (JasperReport)JRLoader.loadObject(getClass().getResource("feesstructure.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, con);
        JFrame frame = new JFrame("Fees Structure");
        frame.getContentPane().add(new JRViewer(jasperPrint));
        frame.setVisible(true);
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      } catch (SQLException e) {
          e.printStackTrace();
       JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+e.getMessage());

          
      } catch (JRException ed) {
          ed.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+ed.getMessage());

      }
    } catch (Exception exr) {
        exr.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+exr.getMessage());
    }
    }//GEN-LAST:event_btnsave1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsave1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblhead;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JComboBox txtcls;
    private javax.swing.JComboBox txtterm;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
