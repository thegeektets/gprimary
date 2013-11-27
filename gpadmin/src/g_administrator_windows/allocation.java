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
public class allocation extends javax.swing.JInternalFrame {
public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
int action;
    public allocation
                () {
        initComponents();
        readcred();
        teachers();
       
      }
    public void teachers(){
        try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String sql="select * from teachers";
ResultSet rs=st.executeQuery(sql);
int r=0;
while(rs.next()){
    
txtteacherid.addItem(""+rs.getInt("idnumber"));
r++; 
    
    }

  


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
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
String sql="select * from subjectallocation where teacherid ='"+txtteacherid.getSelectedItem()+"'";
ResultSet rs=st.executeQuery(sql);
int r=0;
while(rs.next()){
    
    
    
    tblclasses.setValueAt(rs.getInt("class"),r,0);
    tblclasses.setValueAt(rs.getString("stream"),r,1);
     tblclasses.setValueAt(rs.getString("subject"),r,2);
    
   r++; 
    
    }
  


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
    }
   
        
        
    }
   
    public void update(){
                         try {
             
               int r=tblclasses.getSelectedRow();
             
            System.err.println("------updating-------");
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
               int total =0;
               if(txttotal.getText().trim().isEmpty()){
                   total=0;
               }
               else{
               total=Integer.parseInt(txttotal.getText());
               }
                   if(tblclasses.getValueAt(r, 0) == null){
                                    }
                   else{
                          Connection con = DriverManager.getConnection(host, user, pass);
                        System.out.println("------updating-------");
           Statement stm=con.createStatement();
                       String sq=null;
           sq = "select * from teachers where idnumber = '"+txtteacherid.getSelectedItem()+"'" ;
           ResultSet rst=stm.executeQuery(sq);
           if(rst.next()){
                String subject=(String) tblclasses.getValueAt(r,2);
           if(( subject.equals(rst.getString("subject1")))|| (subject.equals(rst.getString("subject2")))||(subject.equals(rst.getString("subject3")))||(subject.equals(rst.getString("subject4")))){
                lblwarning.setText("");
           }else{
               if(subject!=null){
                lblwarning.setText("Warning Teacher "+rst.getString("fullname")
                         +"Id Number"+rst.getInt("idnumber")+"does not teach "+subject);
               }
            }
                       Statement st=con.createStatement();
                       String sql=null;
           sql = "select * from subjects where class = '"+tblclasses.getValueAt(r,0)+"'and subject='"+tblclasses.getValueAt(r,2)+"'" ;
           ResultSet rs =st.executeQuery(sql);
           if(rs.next()){
               total=rs.getInt("subjectsperweek")+total;
               txttotal.setText(""+total);
           }
           else{
               lblwarning.setText("Please update subject record on "+tblclasses.getValueAt(r,2)+" class "+tblclasses.getValueAt(r,0)+" stating wether doubles are allowed or not");
           }     
           }
                   
                         

                   }
           action++;
         
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    public void save(){
         try {
             Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
       Connection con = DriverManager.getConnection(host, user, pass);
       con.setAutoCommit(false);

             int l=tblclasses.getRowCount();
               int r=0;
             
           while(r < l){
                 
                     if(tblclasses.getValueAt(r, 2) == null){
                            r=l;
           
                   }
                   else{
PreparedStatement st=con.prepareStatement("insert into subjectallocation values(?,?,?,?,?)");
    
    
    st.setInt(1,Integer.parseInt((String)txtteacherid.getSelectedItem()));    
    st.setString(2, (String) tblclasses.getValueAt(r,1));
    st.setInt(3,(Integer)tblclasses.getValueAt(r,0));
    st.setString(4,(String)tblclasses.getValueAt(r,2));
    st.setInt(5,Integer.parseInt(""+txtyear.getYear()+""+txtterm.getSelectedItem()));
    
    st.executeUpdate();
    
    r++;
                 }
   
               }
PreparedStatement stm=con.prepareStatement("insert into classallocation values(?,?,?,?)");
    
    
    stm.setInt(1,Integer.parseInt((String)txtteacherid.getSelectedItem()));    
    stm.setInt(2,txtyear.getYear());
    stm.setInt(3,(Integer)txtterm.getSelectedItem());
    stm.setInt(4,Integer.parseInt(txttotal.getText()));
    
    stm.executeUpdate();
    con.commit();
           



    } catch (ClassNotFoundException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(rootPane, "Operation failed "+ex.getMessage()+" try Edit");
    }
      
    }
    public void edit(){
              try {
             Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
       Connection mycon = DriverManager.getConnection(host, user, pass);
      
             int l=tblclasses.getRowCount();
               int r=0;
          PreparedStatement stm=mycon.prepareStatement("delete from subjectallocation where teacherid = ? and subjectallocation.key = ?");
    
    
    stm.setInt(1,Integer.parseInt((String)txtteacherid.getSelectedItem()));    
    stm.setInt(2,Integer.parseInt(""+txtyear.getYear()+""+txtterm.getSelectedItem()));
    
    stm.executeUpdate();
      Connection myycon = DriverManager.getConnection(host, user, pass);
     
      PreparedStatement stmm=myycon.prepareStatement("update classallocation set classallocation.total=? where teacherid = ? and year = ? and term=?");
    
    
    stmm.setInt(1,Integer.parseInt((String)txttotal.getText()));    
    stmm.setInt(2,Integer.parseInt((String)txtteacherid.getSelectedItem()));
    
    stmm.setInt(3,Integer.parseInt(""+txtyear.getYear()));
    stmm.setInt(4,Integer.parseInt(""+txtterm.getSelectedItem()));
    
    stmm.executeUpdate();
   
           while(r<l){
                 
                     if(tblclasses.getValueAt(r, 2)==null){
                            r=l;
           
                   }
                   else{
    
           
PreparedStatement st=mycon.prepareStatement("insert into subjectallocation values(?,?,?,?,?)");
    
    
    st.setInt(1,Integer.parseInt((String)txtteacherid.getSelectedItem()));    
    st.setString(2, (String) tblclasses.getValueAt(r,1));
    st.setInt(3,(Integer)tblclasses.getValueAt(r,0));
    st.setString(4,(String)tblclasses.getValueAt(r,2));
    st.setInt(5,Integer.parseInt(""+txtyear.getYear()+""+txtterm.getSelectedItem()));
    
    st.executeUpdate();
   
    r++;
                 }
   
               }
            



    } catch (ClassNotFoundException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
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
        txtteacherid = new javax.swing.JComboBox();
        btnedit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblclasses = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtterm = new javax.swing.JComboBox();
        txtyear = new com.toedter.calendar.JYearChooser();
        txttotal = new javax.swing.JTextField();
        lblwarning = new javax.swing.JLabel();
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
        lblusername2.setText("Teacher Subject Allocation");

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

        jLabel1.setText("Teacher Id:");

        txtteacherid.setEditable(true);
        txtteacherid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtteacheridActionPerformed(evt);
            }
        });

        btnedit.setBackground(new java.awt.Color(51, 51, 51));
        btnedit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnedit.setForeground(new java.awt.Color(51, 255, 0));
        btnedit.setText("Edit Record");
        btnedit.setToolTipText("");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        jScrollPane2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jScrollPane2KeyTyped(evt);
            }
        });

        tblclasses.setModel(new javax.swing.table.DefaultTableModel(
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
                "CLASS", "STREAM", "SUBJECT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblclasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblclassesMouseClicked(evt);
            }
        });
        tblclasses.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tblclassesInputMethodTextChanged(evt);
            }
        });
        tblclasses.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblclassesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblclassesKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tblclasses);

        jLabel2.setText("Term:");

        jLabel3.setText("Year:");

        jLabel4.setText("Total / Week");

        txtterm.setEditable(true);
        txtterm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        txtterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttermActionPerformed(evt);
            }
        });

        txttotal.setBackground(new java.awt.Color(51, 255, 51));

        lblwarning.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lblwarning.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblwarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtterm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtteacherid, 0, 136, Short.MAX_VALUE)
                            .addComponent(txttotal))
                        .addGap(81, 81, 81)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(btnedit, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(btnexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblusername2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtteacherid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave))
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(lblwarning, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
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
                .addComponent(pnllogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
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
        save();
              JOptionPane.showMessageDialog(rootPane,"Record saved");
        
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Operation failed "+e.getMessage()+" try Edit");
       
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        try{  
               edit();       
                     JOptionPane.showMessageDialog(rootPane,"Record edited successfully");
        
        }
        catch (Exception e){
            e.printStackTrace();
              JOptionPane.showMessageDialog(rootPane,"Edit operation failed");
            
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void txtteacheridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtteacheridActionPerformed
        // TODO add your handling code here:
        try{
         Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String sql="select * from classallocation where teacherid ='"+txtteacherid.getSelectedItem()+"'";
ResultSet rs=st.executeQuery(sql);
if(rs.next()){
   txtyear.setValue(rs.getInt("year"));
   txtterm.setSelectedItem(rs.getInt("term"));
   txttotal.setText(""+rs.getInt("total"));
   populate();
        
}
        } catch (SQLException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(allocation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_txtteacheridActionPerformed

    private void txttermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttermActionPerformed

    private void tblclassesInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblclassesInputMethodTextChanged
        // TODO add your handling code here:
       // update();
    }//GEN-LAST:event_tblclassesInputMethodTextChanged

    private void tblclassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblclassesMouseClicked
        // TODO add your handling code here:
        if(tblclasses.getValueAt(action, 2)==null){
            
        }
        else{
         int selected=tblclasses.getSelectedRow();
        if(selected==action){
      update();
        }}
    }//GEN-LAST:event_tblclassesMouseClicked

    private void jScrollPane2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane2KeyTyped
        // TODO add your handling code here:
    //   update();
    }//GEN-LAST:event_jScrollPane2KeyTyped

    private void jScrollPane2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane2KeyPressed

        
     //  update();        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2KeyPressed

    private void tblclassesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblclassesKeyReleased
        // TODO add your handling code here:
        if(tblclasses.getValueAt(action, 2)==null){
            
        }
        else{
         int selected=tblclasses.getSelectedRow();
        if(selected==action){
      update();
        }}
    }//GEN-LAST:event_tblclassesKeyReleased

    private void tblclassesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblclassesKeyTyped
        // TODO add your handling code here:
     //   update();
    }//GEN-LAST:event_tblclassesKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblusername2;
    private javax.swing.JLabel lblwarning;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JTable tblclasses;
    private javax.swing.JComboBox txtteacherid;
    private javax.swing.JComboBox txtterm;
    private javax.swing.JTextField txttotal;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
