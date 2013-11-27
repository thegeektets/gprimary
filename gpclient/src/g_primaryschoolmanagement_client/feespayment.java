/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_primaryschoolmanagement_client;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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
public class feespayment extends javax.swing.JInternalFrame {

int action;
JComboBox txtclas;
    public feespayment
                () {
        initComponents();
       dblogincred();
       
      }
    
     public String dbusername="root";
 public  String dbhostip;
 public  String dbpassword;
public String database;  
    public  void dblogincred(){
           try {
            StringBuilder sb = new StringBuilder(File.separator);
            sb.append("C:\\Users\\Public\\Documents\\dblogin.txt");
            File f = new File(sb.toString());
            boolean isCreated = f.createNewFile();
            System.out.println(isCreated);
        } catch (IOException ex) {
            Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex);
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
               if(dbhostip.isEmpty()==false){
               int l=dbhostip.indexOf("n");
               int e=dbhostip.indexOf("%");
               
        dbpassword=dbhostip.substring(l+1,e).trim();
        database=dbhostip.substring(e+1).trim();
        dbhostip=dbhostip.substring(0, l).trim();
         System.out.println(""+dbhostip);
         System.out.println(""+database);
         System.out.println(""+dbpassword);
               }
          
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
            
        }
         
    }
   public void cleartable(){
       int end ,r =0;
       int end2 ;
       end =tblpaymentrecord.getRowCount();
       while(r<end){
          tblpaymentrecord.setValueAt("",r,0);
          tblpaymentrecord.setValueAt("",r,1);
          tblpaymentrecord.setValueAt("",r,2);
          tblpaymentrecord.setValueAt("",r,3);
           r++;
       }
       r=0;
       end2=tblbreakdown.getRowCount();
       
       while(r<end2){
          tblbreakdown.setValueAt("",r,0);
          
           r++; 
       }
   } 
   public void insertbreakdown(){
       try{
            Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
      String transactionid =txttransactionid.getText();
       int r=0;
       int end2=tblbreakdown.getRowCount();
       String key =""+txtyear.getYear()+txtterm.getSelectedItem()+txtstudentnumber.getText();
      
       while(r<end2){
           if(tblbreakdown.getValueAt(r,0).toString().isEmpty()){
               r=end2;
               System.out.println("Empty");
           }
           else{
          String item=(String)tblbreakdown.getValueAt(r,0);
          int amount=0;
          if(tblbreakdown.getValueAt(r,1)!=null){
           amount=(Integer)tblbreakdown.getValueAt(r,1);
          }
          
          PreparedStatement stm =conn.prepareStatement("insert into installmentbreakdown values(?,?,?,?)");
          stm.setInt(1, amount);
          stm.setString(2, item);
          stm.setString(3, transactionid);
          stm.setString(4,key);
          stm.executeUpdate();
          
          
       
          
          r++; 
        
       }
       }
       }
       catch (Exception e){
           e.printStackTrace();
       }
   }
   public void populate(){
       cleartable();
         try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
      Statement st = conn.createStatement();
      String key =""+txtyear.getYear()+txtterm.getSelectedItem()+txtstudentnumber.getText();
     
      String sql="select * from feesinstallments where feesinstallments.key='"+key+"'";
      ResultSet rs =st.executeQuery(sql);
      int r=0;
      while(rs.next()){
          
          tblpaymentrecord.setValueAt(txtstudentnumber.getText(),r,0);
          tblpaymentrecord.setValueAt(rs.getDate("date"),r,1);
          tblpaymentrecord.setValueAt(rs.getInt("amount"),r,2);
          tblpaymentrecord.setValueAt(rs.getString("transactionid"),r,3);
          r++;
          
      }
      Statement st2 = conn.createStatement();
      String key2 =""+txtyear.getYear()+txtterm.getSelectedItem()+txtclass.getSelectedItem();
      String sql2="select * from feesdescription where feesdescription.key='"+key2+"'";
      ResultSet rs2 =st2.executeQuery(sql2);
      int r2=0;
      while(rs2.next()){
       tblbreakdown.setValueAt(rs2.getString("Item"),r2,0);
         r2++;
      
        }
         }
         catch (Exception ex){
             
         }
       
         
   }

   


    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        brownSugar1 = new com.jgoodies.looks.plastic.theme.BrownSugar();
        pnllogin = new javax.swing.JPanel();
        btnsearch = new javax.swing.JButton();
        lblusername2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtterm = new javax.swing.JComboBox();
        txtyear = new com.toedter.calendar.JYearChooser();
        txtstudentnumber = new javax.swing.JTextField();
        txtclass = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtstudentname = new javax.swing.JTextField();
        txtstream = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtpayment = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtpayedby = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txttransactionid = new javax.swing.JTextField();
        pnlrecords = new javax.swing.JPanel();
        btnreceipt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbreakdown = new javax.swing.JTable();
        txtpay = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        txtdate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtamount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtrecieved = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpaymentrecord = new javax.swing.JTable();
        btnprintrecord = new javax.swing.JButton();
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

        lblusername2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername2.setText("Student Fees Payment  :");

        jLabel1.setText("Class :");

        jLabel2.setText("Term:");

        jLabel3.setText("Year:");

        jLabel4.setText("Student Name :");

        txtterm.setEditable(true);
        txtterm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        txtterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttermActionPerformed(evt);
            }
        });

        txtyear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtyearMouseClicked(evt);
            }
        });

        txtstudentnumber.setBackground(new java.awt.Color(51, 255, 51));
        txtstudentnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstudentnumberActionPerformed(evt);
            }
        });
        txtstudentnumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtstudentnumberKeyPressed(evt);
            }
        });

        txtclass.setEditable(true);
        txtclass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        txtclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclassActionPerformed(evt);
            }
        });

        jLabel5.setText("Student Adm Number :");

        txtstudentname.setBackground(new java.awt.Color(51, 255, 51));

        txtstream.setBackground(new java.awt.Color(51, 255, 51));

        jLabel6.setText("Payed By :");

        jLabel7.setText("Payment Option :");

        txtpayment.setEditable(true);
        txtpayment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Banker's Cheque", "M-Pesa", "Cash", " " }));
        txtpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpaymentActionPerformed(evt);
            }
        });

        jLabel8.setText("Stream :");

        txtpayedby.setBackground(new java.awt.Color(51, 255, 51));
        txtpayedby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpayedbyActionPerformed(evt);
            }
        });

        jLabel9.setText("Transaction Id:");

        txttransactionid.setBackground(new java.awt.Color(51, 255, 51));

        pnlrecords.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fees Breakdown in relevance to Fees Structure", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N

        btnreceipt.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnreceipt.setText("Issue Receipt");
        btnreceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreceiptActionPerformed(evt);
            }
        });

        tblbreakdown.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblbreakdown);

        txtpay.setBackground(new java.awt.Color(51, 51, 51));
        txtpay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtpay.setForeground(new java.awt.Color(51, 255, 0));
        txtpay.setText("Pay");
        txtpay.setToolTipText("");
        txtpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpayActionPerformed(evt);
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

        javax.swing.GroupLayout pnlrecordsLayout = new javax.swing.GroupLayout(pnlrecords);
        pnlrecords.setLayout(pnlrecordsLayout);
        pnlrecordsLayout.setHorizontalGroup(
            pnlrecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlrecordsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlrecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlrecordsLayout.createSequentialGroup()
                        .addComponent(txtpay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41)
                        .addComponent(btnreceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlrecordsLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlrecordsLayout.setVerticalGroup(
            pnlrecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlrecordsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlrecordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnreceipt)
                    .addComponent(txtpay)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199))
        );

        jLabel10.setText("Date:");

        txtamount.setBackground(new java.awt.Color(51, 255, 51));
        txtamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamountActionPerformed(evt);
            }
        });

        jLabel11.setText("Amount");

        jLabel12.setText("Recieved By:");

        txtrecieved.setBackground(new java.awt.Color(51, 255, 51));

        tblpaymentrecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Admission Number", "Last Payment", "Amount Payed", "Transaction Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblpaymentrecord);

        btnprintrecord.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnprintrecord.setText("Print");
        btnprintrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintrecordActionPerformed(evt);
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
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(txtstudentnumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtstudentname)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblusername2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(txttransactionid))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(txtpayedby))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(49, 49, 49)
                                .addComponent(txtpayment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtstream))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtclass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtterm, 0, 207, Short.MAX_VALUE)
                                    .addComponent(txtamount)))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(txtrecieved)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnprintrecord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlrecords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addComponent(lblusername2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtstudentnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstudentname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstream, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpayedby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttransactionid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtrecieved, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnprintrecord)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlrecords, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 23, Short.MAX_VALUE)
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
      try
    {
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
      Statement st = conn.createStatement();
      String sql="select * from student where studentnumber='"+txtstudentnumber.getText()+"'";
      ResultSet rs =st.executeQuery(sql);
      if(rs.next()){
          populate();
          txtstudentname.setText(""+rs.getString("studentname"));
          txtclass.setSelectedItem(""+rs.getInt("cclass"));
          txtstream.setText(""+rs.getString("stream"));
          
      }
      else{
          JOptionPane.showMessageDialog(rootPane,"Record not found");
      }
      
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpayActionPerformed
        // TODO add your handling code here:
       int newbalance=0;
      int end=tblbreakdown.getRowCount();
      int r=0;
      int sum=0;
      try{
      while(r<end){
          if(tblbreakdown.getValueAt(r,1)!=null){
       sum=sum+(Integer)tblbreakdown.getValueAt(r,1);   
          }
       r++;   
          
      }
      
      if(sum==Integer.parseInt(txtamount.getText())){
       
           try
    {
      
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
      Statement s =con.createStatement();
      ResultSet rs=s.executeQuery("select newbalance from feespayment where studentadm = '"+txtstudentnumber.getText()+"'");
      if(rs.next()){
          newbalance=rs.getInt("newbalance");
      System.out.println(""+newbalance); 
      }
    
      else{
           String key =""+txtyear.getYear()+txtterm.getSelectedItem()+txtclass.getSelectedItem();
     
        Statement stmt =con.createStatement();
      ResultSet rsmt=stmt.executeQuery("select * from feesstructure where feesstructure.key ='"+key+"'");
      if(rsmt.next()){
          newbalance=rsmt.getInt("total");
        System.out.println(""+newbalance);
      }
             
      }
       System.err.println(""+newbalance);
      
      
      PreparedStatement stm =con.prepareStatement("insert into feespayment values(?,?,?,?,?)");
      String key =""+txtyear.getYear()+txtterm.getSelectedItem()+txtstudentnumber.getText();
      stm.setString(1,key) ;
      stm.setInt(2,txtyear.getYear());
      stm.setInt(3,Integer.parseInt((String)txtterm.getSelectedItem()));
      stm.setInt(4,Integer.parseInt(txtstudentnumber.getText()));
      
      stm.setInt(5,(newbalance-Integer.parseInt(txtamount.getText())));
      stm.executeUpdate();
      
     PreparedStatement st =con.prepareStatement("insert into feesinstallments values(?,?,?,?,?,?,?)");
       st.setInt(1,Integer.parseInt(txtamount.getText()));
       Date date =new java.util.Date();
       date=txtdate.getDate();
       java.sql.Date sql =new java.sql.Date(date.getTime());
       st.setDate(2,sql);
       st.setString(3,key);
       st.setString(4, (String) txtpayment.getSelectedItem());
       st.setString(5,txtpayedby.getText());
       st.setString(6,txttransactionid.getText());
       st.setString(7,txtrecieved.getText());
       st.executeUpdate();
       insertbreakdown();
       JOptionPane.showMessageDialog(rootPane,"Transaction successfull");
        PreparedStatement stmu =con.prepareStatement("update feespayment set newbalance = ? where studentadm = ?");
              stmu.setString(2,txtstudentnumber.getText()) ;
              stmu.setInt(1,(newbalance-Integer.parseInt(txtamount.getText())));
              stmu.executeUpdate();
             
       
 
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
           try {
               ex.printStackTrace();
               System.err.println(""+newbalance);
               System.err.println(""+(newbalance-Integer.parseInt(txtamount.getText())));
               
             
               String key =""+txtyear.getYear()+txtterm.getSelectedItem()+txtstudentnumber.getText();
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
              
                PreparedStatement st =conn.prepareStatement("insert into feesinstallments values(?,?,?,?,?,?,?)");
               st.setInt(1,Integer.parseInt(txtamount.getText()));
               Date date =new java.util.Date();
               date=txtdate.getDate();
               java.sql.Date sql =new java.sql.Date(date.getTime());
               st.setDate(2,sql);
               st.setString(3,key);
               st.setString(4, (String) txtpayment.getSelectedItem());
               st.setString(5,txtpayedby.getText());
               st.setString(6,txttransactionid.getText());
               st.setString(7,txtrecieved.getText());
               st.executeUpdate();
               insertbreakdown();
              PreparedStatement stm =conn.prepareStatement("update feespayment set newbalance = ? where studentadm = ?");
              stm.setString(2,txtstudentnumber.getText()) ;
              stm.setInt(1,(newbalance-Integer.parseInt(txtamount.getText())));
              stm.executeUpdate();
               JOptionPane.showMessageDialog(rootPane,"Transaction successfull");
           } catch (SQLException ex1) {
               Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex1);
                     JOptionPane.showMessageDialog(rootPane,"Transaction failed"+ex1.getMessage());
         
           } catch (ClassNotFoundException ex1) {
               Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex1);
           }
        
    
    }
          
      }
      else{
          int c=JOptionPane.showConfirmDialog(rootPane,"Warning The Fees Breakdown does not equal the amount paid are you sure you want to proceed with transaction \n click yes to proceed?");
          if(c==0){
              
           try
    {
      
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
      Statement s =con.createStatement();
      ResultSet rs=s.executeQuery("select newbalance from feespayment where studentadm = '"+txtstudentnumber.getText()+"'");
      if(rs.next()){
          newbalance=rs.getInt("newbalance");
      System.out.println(""+newbalance); 
      }
    
      else{
           String key =""+txtyear.getYear()+txtterm.getSelectedItem()+txtclass.getSelectedItem();
     
        Statement stmt =con.createStatement();
      ResultSet rsmt=stmt.executeQuery("select * from feesstructure where feesstructure.key ='"+key+"'");
      if(rsmt.next()){
          newbalance=rsmt.getInt("total");
        System.out.println(""+newbalance);
      }
             
      }
       System.err.println(""+newbalance);
      
      
      PreparedStatement stm =con.prepareStatement("insert into feespayment values(?,?,?,?,?)");
      String key =""+txtyear.getYear()+txtterm.getSelectedItem()+txtstudentnumber.getText();
      stm.setString(1,key) ;
      stm.setInt(2,txtyear.getYear());
      stm.setInt(3,Integer.parseInt((String)txtterm.getSelectedItem()));
      stm.setInt(4,Integer.parseInt(txtstudentnumber.getText()));
      
      stm.setInt(5,(newbalance-Integer.parseInt(txtamount.getText())));
      stm.executeUpdate();
     PreparedStatement st =con.prepareStatement("insert into feesinstallments values(?,?,?,?,?,?,?)");
       st.setInt(1,Integer.parseInt(txtamount.getText()));
       Date date =new java.util.Date();
       date=txtdate.getDate();
       java.sql.Date sql =new java.sql.Date(date.getTime());
       st.setDate(2,sql);
       st.setString(3,key);
       st.setString(4, (String) txtpayment.getSelectedItem());
       st.setString(5,txtpayedby.getText());
       st.setString(6,txttransactionid.getText());
       st.setString(7,txtrecieved.getText());
       st.executeUpdate();
       insertbreakdown();
       JOptionPane.showMessageDialog(rootPane,"Transaction successfull");
        PreparedStatement stmu =con.prepareStatement("update feespayment set newbalance = ? where studentadm = ?");
              stmu.setString(2,txtstudentnumber.getText()) ;
              stmu.setInt(1,(newbalance-Integer.parseInt(txtamount.getText())));
              stmu.executeUpdate();
             
       
 
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
           try {
               ex.printStackTrace();
               System.err.println(""+newbalance);
               System.err.println(""+(newbalance-Integer.parseInt(txtamount.getText())));
               
             
               String key =""+txtyear.getYear()+txtterm.getSelectedItem()+txtstudentnumber.getText();
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
              
                PreparedStatement st =conn.prepareStatement("insert into feesinstallments values(?,?,?,?,?,?,?)");
               st.setInt(1,Integer.parseInt(txtamount.getText()));
               Date date =new java.util.Date();
               date=txtdate.getDate();
               java.sql.Date sql =new java.sql.Date(date.getTime());
               st.setDate(2,sql);
               st.setString(3,key);
               st.setString(4, (String) txtpayment.getSelectedItem());
               st.setString(5,txtpayedby.getText());
               st.setString(6,txttransactionid.getText());
               st.setString(7,txtrecieved.getText());
               st.executeUpdate();
               insertbreakdown();
              PreparedStatement stm =conn.prepareStatement("update feespayment set newbalance = ? where studentadm = ?");
              stm.setString(2,txtstudentnumber.getText()) ;
              stm.setInt(1,(newbalance-Integer.parseInt(txtamount.getText())));
              stm.executeUpdate();
               JOptionPane.showMessageDialog(rootPane,"Transaction successfull");
           } catch (SQLException ex1) {
               Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex1);
                     JOptionPane.showMessageDialog(rootPane,"Transaction failed"+ex1.getMessage());
         
           } catch (ClassNotFoundException ex1) {
               Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex1);
           }
        
    
    }
          }
                  
      }
      }
      catch (Exception e){
          JOptionPane.showMessageDialog(rootPane, "Something went wrong your transaction cannot be processed please check");
      e.printStackTrace();
      }
      
      
   
    }//GEN-LAST:event_txtpayActionPerformed

    private void txttermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttermActionPerformed
        // TODO add your handling code here:
        populate();
    }//GEN-LAST:event_txttermActionPerformed

    private void txtpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaymentActionPerformed

    private void txtpayedbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpayedbyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpayedbyActionPerformed

    private void btnprintrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintrecordActionPerformed
        // TODO add your handling code here:
          try {
    boolean complete = tblpaymentrecord.print();
    if (complete) {
         JOptionPane.showMessageDialog(null, "Record Printed");
    } else {
              
        JOptionPane.showMessageDialog(null, "Printing cancelled by user");   }
} catch (PrinterException pe) {
             JOptionPane.showMessageDialog(null, "Printing failed"+pe.getMessage());
}
    }//GEN-LAST:event_btnprintrecordActionPerformed

    private void txtamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamountActionPerformed

    private void txtclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclassActionPerformed
        // TODO add your handling code here:
        populate();
    }//GEN-LAST:event_txtclassActionPerformed

    private void txtyearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtyearMouseClicked
        // TODO add your handling code here:
        populate();
    }//GEN-LAST:event_txtyearMouseClicked

    private void btnreceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreceiptActionPerformed
        // TODO add your handling code here:
         try
      {
                 String key =""+txtyear.getYear()+txtterm.getSelectedItem()+txtstudentnumber.getText();
       
          Class.forName("com.mysql.jdbc.Driver");
   
        Connection con =  DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        Map parameters = new HashMap();
        parameters.put("key",(key));
        parameters.put("date", txtdate.getDate());
        parameters.put("transaction", txttransactionid.getText());
        
        JasperReport report = (JasperReport)JRLoader.loadObject(getClass().getResource("paymentreciept.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, con);
        JFrame frame = new JFrame("Payment Receipt");
        frame.getContentPane().add(new JRViewer(jasperPrint));
        frame.setVisible(true);
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
      } catch (SQLException e) {
          e.printStackTrace();
       JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+e.getMessage());

          
      } catch (JRException ed) {
          ed.printStackTrace();
                    JOptionPane.showMessageDialog(rootPane, "Report cannot be displayed \n Error:"+ed.getMessage());

      } catch (ClassNotFoundException ex) {
        Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_btnreceiptActionPerformed

    private void txtstudentnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstudentnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstudentnumberActionPerformed

    private void txtstudentnumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstudentnumberKeyPressed
        // TODO add your handling code here:
        int kycode = evt.getKeyCode();
        if(kycode == java.awt.event.KeyEvent.VK_ENTER){
         try
    {
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
      Statement st = conn.createStatement();
      String sql="select * from student where studentnumber='"+txtstudentnumber.getText()+"'";
      ResultSet rs =st.executeQuery(sql);
      if(rs.next()){
          populate();
          txtstudentname.setText(""+rs.getString("studentname"));
          txtclass.setSelectedItem(""+rs.getInt("cclass"));
          txtstream.setText(""+rs.getString("stream"));
          
      }
      else{
          JOptionPane.showMessageDialog(rootPane,"Record not found");
      }
      
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(feespayment.class.getName()).log(Level.SEVERE, null, ex);
    }    
        }
                
    }//GEN-LAST:event_txtstudentnumberKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnprintrecord;
    private javax.swing.JButton btnreceipt;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblusername2;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JPanel pnlrecords;
    private javax.swing.JTable tblbreakdown;
    private javax.swing.JTable tblpaymentrecord;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox txtclass;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JButton txtpay;
    private javax.swing.JTextField txtpayedby;
    private javax.swing.JComboBox txtpayment;
    private javax.swing.JTextField txtrecieved;
    private javax.swing.JTextField txtstream;
    private javax.swing.JTextField txtstudentname;
    private javax.swing.JTextField txtstudentnumber;
    private javax.swing.JComboBox txtterm;
    private javax.swing.JTextField txttransactionid;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
