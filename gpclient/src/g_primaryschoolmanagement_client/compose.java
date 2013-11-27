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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Griffin M
 */
public class compose extends javax.swing.JInternalFrame {
public String dbhostip;
public String dbpassword;
public String database;
    
    public compose() {
        initComponents();
        dblogincred();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlmessage = new javax.swing.JPanel();
        lblto = new javax.swing.JLabel();
        txtto = new javax.swing.JTextField();
        txtsubject = new javax.swing.JTextField();
        lblsubject = new javax.swing.JLabel();
        lblmessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmessage = new javax.swing.JTextArea();
        btnfind = new javax.swing.JButton();
        btnsent = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        lblfooter = new javax.swing.JLabel();

        setClosable(true);

        pnlmessage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblto.setText("TO:");

        txtto.setBackground(new java.awt.Color(153, 255, 102));
        txtto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtsubject.setBackground(new java.awt.Color(153, 255, 102));
        txtsubject.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtsubject.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblsubject.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblsubject.setText("Subject:");

        lblmessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblmessage.setText("Message:");

        txtmessage.setBackground(new java.awt.Color(153, 255, 102));
        txtmessage.setColumns(20);
        txtmessage.setRows(5);
        txtmessage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(txtmessage);

        btnfind.setBackground(new java.awt.Color(102, 102, 102));
        btnfind.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnfind.setForeground(new java.awt.Color(51, 255, 51));
        btnfind.setText("Find");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        btnsent.setBackground(new java.awt.Color(102, 102, 102));
        btnsent.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsent.setForeground(new java.awt.Color(51, 255, 51));
        btnsent.setText("Sent");
        btnsent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsentActionPerformed(evt);
            }
        });

        btnclear.setBackground(new java.awt.Color(102, 102, 102));
        btnclear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btncancel.setBackground(new java.awt.Color(102, 102, 102));
        btncancel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btncancel.setForeground(new java.awt.Color(255, 51, 51));
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlmessageLayout = new javax.swing.GroupLayout(pnlmessage);
        pnlmessage.setLayout(pnlmessageLayout);
        pnlmessageLayout.setHorizontalGroup(
            pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlmessageLayout.createSequentialGroup()
                        .addComponent(lblto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlmessageLayout.createSequentialGroup()
                        .addComponent(lblsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtsubject, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblmessage, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnfind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlmessageLayout.setVerticalGroup(
            pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmessageLayout.createSequentialGroup()
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblto)
                    .addComponent(txtto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsubject)
                    .addComponent(txtsubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblmessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlmessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addGroup(pnlmessageLayout.createSequentialGroup()
                        .addComponent(btnsent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnclear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        lbltitle.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbltitle.setText("Compose Message :");

        lblfooter.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblfooter.setForeground(new java.awt.Color(102, 0, 102));
        lblfooter.setText("G Ultimate Developers:2013 All Rights Reserved");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
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
                .addComponent(lbltitle, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
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
    
        
        
        
        
    }//GEN-LAST:event_btnfindActionPerformed

    catch (ClassNotFoundException ex) {
        Logger.getLogger(compose.class.getName()).log(Level.SEVERE, null, ex);

    }catch (SQLException ex) {
        Logger.getLogger(compose.class.getName()).log(Level.SEVERE, null, ex);
    }}
    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        txtto.setText("");
        txtsubject.setText("");
        txtmessage.setText("");
        
    }//GEN-LAST:event_btnclearActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnsentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsentActionPerformed
    try {
        // TODO add your handling code here:
         int sent=0;
         Class.forName("com.mysql.jdbc.Driver");
         Connection con;
         con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,"root", dbpassword);
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
              String from=main.txtusername.getText();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnsent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblmessage;
    private javax.swing.JLabel lblsubject;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JLabel lblto;
    private javax.swing.JPanel pnlmessage;
    private javax.swing.JTextArea txtmessage;
    private javax.swing.JTextField txtsubject;
    private javax.swing.JTextField txtto;
    // End of variables declaration//GEN-END:variables
}
