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
    
    public void populate(){
    try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String key=""+txtyear.getYear()+txtterm.getSelectedItem()+txtcls.getSelectedItem();
String sql="select * from feesdescription where feesdescription.key ='"+key+"'";
ResultSet rs=st.executeQuery(sql);
int r=0;
while(rs.next()){
    
    
    
    tbldescription.setValueAt(rs.getString("item"),r,0);
    tbldescription.setValueAt(rs.getInt("amount"),r,1);
        
   r++; 
    
    }
  


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(feesstructure.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(feesstructure.class.getName()).log(Level.SEVERE, null, ex);
    }
   
        
        
    }
   
    public void update(){
        try {
            System.err.println("------updating-------");
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
         Connection con = DriverManager.getConnection(host, user, pass);
         System.out.println("------updating-------");
         Statement st=con.createStatement();
         String sql=("select newbalance,studentnumber,cclass from feespayment,student  where student.studentnumber = feespayment.studentadm and student.cclass = '"+txtcls.getSelectedItem()+"'");
         ResultSet rs =st.executeQuery(sql);
         while(rs.next()){
         PreparedStatement stm =con.prepareStatement("update feespayment set feespayment.newbalance = ? where feespayment.studentadm = ?");
         stm.setInt(1,(Integer.parseInt(txttotal.getText())+rs.getInt("newbalance")));
         stm.setInt(2,rs.getInt("studentnumber"));
         stm.executeUpdate();
         }               
           JOptionPane.showMessageDialog(rootPane,"students fees records updated")               ;
                        
                         
                         
                         
        } catch (ClassNotFoundException ex) {
        Logger.getLogger(feesstructure.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(feesstructure.class.getName()).log(Level.SEVERE, null, ex);
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

               int l=tbldescription.getRowCount();
               int r=0;
             
           while(r < l){
                 
                     if(tbldescription.getValueAt(r, 1) == null){
                            r=l;
           
                   }
                   else{
PreparedStatement st=con.prepareStatement("insert into feesdescription values(?,?,?,?)");
    
    String key=""+txtyear.getYear()+txtterm.getSelectedItem()+txtcls.getSelectedItem();
    st.setInt(1,(Integer)tbldescription.getValueAt(r,1));    
    st.setString(2, (String) tbldescription.getValueAt(r,0));
    st.setString(3,key);
    st.setString(4,(String)txtcls.getSelectedItem());
   
    st.executeUpdate();
    
    r++;
                 }
   
               }
PreparedStatement stm=con.prepareStatement("insert into feesstructure values(?,?,?,?,?)");
    
    String key=""+txtyear.getYear()+txtterm.getSelectedItem()+txtcls.getSelectedItem();
   
    stm.setInt(5,Integer.parseInt((String)txtcls.getSelectedItem()));    
    stm.setInt(2,txtyear.getYear());
    stm.setInt(3,Integer.parseInt((String)txtterm.getSelectedItem()));
    stm.setInt(4,Integer.parseInt(txttotal.getText()));
    stm.setString(1,key);
    stm.executeUpdate();
    con.commit();
           



    } catch (ClassNotFoundException ex) {
        Logger.getLogger(feesstructure.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(feesstructure.class.getName()).log(Level.SEVERE, null, ex);
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
      
            String key=""+txtyear.getYear()+txtterm.getSelectedItem()+txtcls.getSelectedItem();
   
          PreparedStatement stm=mycon.prepareStatement("delete from feesdescription where feesdescrription.key = ?");
           stm.setString(1,key);
          stm.executeUpdate();
    
         int l=tbldescription.getRowCount();
               int r=0;
             
           while(r < l){
                 
                     if(tbldescription.getValueAt(r, 1) == null){
                            r=l;
           
                   }
                   else{
PreparedStatement st=mycon.prepareStatement("insert into feesdescription values(?,?,?,?)");
    st.setInt(1,(Integer)tbldescription.getValueAt(r,1));    
    st.setString(2, (String) tbldescription.getValueAt(r,0));
    st.setString(3,key);
    st.setString(4,(String)txtcls.getSelectedItem());
   
    st.executeUpdate();
    
    r++;
                 }
   
               }
            
PreparedStatement stmm=mycon.prepareStatement("update feesstructure set total = ?");
    stmm.setInt(1,(Integer.parseInt(txttotal.getText())));    
    stmm.executeUpdate();
    JOptionPane.showMessageDialog(rootPane,"Record updated");


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(feesstructure.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(feesstructure.class.getName()).log(Level.SEVERE, null, ex);
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
        lblhead = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnedit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtterm = new javax.swing.JComboBox();
        txtyear = new com.toedter.calendar.JYearChooser();
        txttotal = new javax.swing.JTextField();
        txtcls = new javax.swing.JComboBox();
        btnsearch = new javax.swing.JButton();
        pnlprint = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldescription = new javax.swing.JTable();
        btnprint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
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
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/g_administrator_windows/hslogo.jpg"))); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnsave.setBackground(new java.awt.Color(51, 51, 51));
        btnsave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsave.setForeground(new java.awt.Color(51, 255, 0));
        btnsave.setText("Save Structure and Update Records");
        btnsave.setToolTipText("");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

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

        btnedit.setBackground(new java.awt.Color(51, 51, 51));
        btnedit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnedit.setForeground(new java.awt.Color(51, 255, 0));
        btnedit.setText("Edit Structure and Update Records");
        btnedit.setToolTipText("");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        jLabel2.setText("Term:");

        jLabel3.setText("Year:");

        jLabel4.setText("Total Fees:");

        txtterm.setEditable(true);
        txtterm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        txtterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttermActionPerformed(evt);
            }
        });

        txttotal.setBackground(new java.awt.Color(51, 255, 51));

        txtcls.setEditable(true);
        txtcls.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));

        btnsearch.setBackground(new java.awt.Color(51, 51, 51));
        btnsearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(51, 255, 0));
        btnsearch.setText("Search  Structure");
        btnsearch.setToolTipText("");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        pnlprint.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Structure Breakdown", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N

        jScrollPane2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jScrollPane2KeyTyped(evt);
            }
        });

        tbldescription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbldescription.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldescriptionMouseClicked(evt);
            }
        });
        tbldescription.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tbldescriptionInputMethodTextChanged(evt);
            }
        });
        tbldescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbldescriptionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbldescriptionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tbldescription);

        javax.swing.GroupLayout pnlprintLayout = new javax.swing.GroupLayout(pnlprint);
        pnlprint.setLayout(pnlprintLayout);
        pnlprintLayout.setHorizontalGroup(
            pnlprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprintLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
        );
        pnlprintLayout.setVerticalGroup(
            pnlprintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlprintLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        btnprint.setBackground(new java.awt.Color(51, 51, 51));
        btnprint.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnprint.setForeground(new java.awt.Color(51, 255, 0));
        btnprint.setText("Print and Preview Structure");
        btnprint.setToolTipText("");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlloginLayout = new javax.swing.GroupLayout(pnllogin);
        pnllogin.setLayout(pnlloginLayout);
        pnlloginLayout.setHorizontalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlloginLayout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtcls, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtyear, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(105, 105, 105)))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlloginLayout.createSequentialGroup()
                                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtterm, 0, 164, Short.MAX_VALUE)
                                            .addComponent(txttotal)))
                                    .addGroup(pnlloginLayout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnprint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))
                        .addComponent(pnlprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addComponent(lblhead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcls, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnsearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnedit)
                        .addGap(25, 25, 25)
                        .addComponent(btnprint)
                        .addGap(18, 18, 18)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlprint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfooter)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String options[]=new String[2];
        options[0]="Only Save";
        options[1]="Save and Update";
        try{
int c = JOptionPane.showOptionDialog(rootPane, "Updating fees records will reflect new structure on all students fees balance records", "Confirm", 0, 1, frameIcon, options, iconable);
if(c==0){            
        save();
              JOptionPane.showMessageDialog(rootPane,"Record saved");
}
else{
    save();
    update();
}
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Operation failed "+e.getMessage()+" try Save Only");
       
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
                 String options[]=new String[2];
        options[0]="Only Edit";
        options[1]="Edit and Update";
        try{
int c = JOptionPane.showOptionDialog(rootPane, "Updating fees records will reflect new structure on all students fees balance records", "Confirm", 0, 1, frameIcon, options, iconable);
if(c==0){            
        edit();
                             JOptionPane.showMessageDialog(rootPane,"Record edited successfully");
 
}
else{
    edit();
    update();
}
         
        }
        catch (Exception e){
            e.printStackTrace();
              JOptionPane.showMessageDialog(rootPane,"Edit operation failed");
            
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void txttermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttermActionPerformed

    private void tbldescriptionInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbldescriptionInputMethodTextChanged
        // TODO add your handling code here:
       // update();
    }//GEN-LAST:event_tbldescriptionInputMethodTextChanged

    private void tbldescriptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldescriptionMouseClicked
        
    }//GEN-LAST:event_tbldescriptionMouseClicked

    private void jScrollPane2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane2KeyTyped
        // TODO add your handling code here:
    //   update();
    }//GEN-LAST:event_jScrollPane2KeyTyped

    private void jScrollPane2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane2KeyPressed

        
     //  update();        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2KeyPressed

    private void tbldescriptionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbldescriptionKeyReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_tbldescriptionKeyReleased

    private void tbldescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbldescriptionKeyTyped
        // TODO add your handling code here:
     //   update();
    }//GEN-LAST:event_tbldescriptionKeyTyped

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
         try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String key=""+txtyear.getYear()+txtterm.getSelectedItem()+txtcls.getSelectedItem();
String sql="select * from feesstructure where key = '"+key+"'";
ResultSet rs =st.executeQuery(sql);
if(rs.next()){
    txttotal.setText(""+rs.getInt("total"));
     populate();
}
         }catch (Exception ex){
             JOptionPane.showMessageDialog(rootPane,"No results");
         }
         
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
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

          
     
      }
    } catch (Exception exr) {
        exr.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+exr.getMessage());
    }
        
    }//GEN-LAST:event_btnprintActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblhead;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JPanel pnlprint;
    private javax.swing.JTable tbldescription;
    private javax.swing.JComboBox txtcls;
    private javax.swing.JComboBox txtterm;
    private javax.swing.JTextField txttotal;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
