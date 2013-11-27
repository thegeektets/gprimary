/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_primaryschoolmanagement_client;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PrinterException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author griffin
 */
public class feesrecords extends javax.swing.JInternalFrame {
public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
int action;
JComboBox txtclas;
    public feesrecords
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
 public  void popolate(int s, JTable tbale, ResultSet rs)
    throws SQLException
  {
  Connection  con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
  Statement  stmt = con.createStatement();

    rs.last();
    int rows = rs.getRow();
    rs.first();
    for (int a = 0; a < rows; a++) {
      for (int b = 0; b < s; b++) {
        try {
          tbale.setValueAt(rs.getString(b + 1), a, b);
        }
        catch (Exception e)
        {
          tbale.setValueAt(Integer.valueOf(rs.getInt(a)), a, b);
        }
      }

      rs.next();
    }
  }
  
  public  void create(int s, ResultSet rs, String[] heads) throws SQLException { 
   try{
   Connection   con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
   Statement stmt = con.createStatement();
      DefaultTableModel model = new DefaultTableModel();
      final JTable table = new JTable(model);
      int a = 0;
      while (a < s) {
        model.addColumn(heads[a]);
        a++;
      }

      while (rs.next()) {
        model.addRow(new Object[0]);
      }

      JFrame f = new JFrame("Search Results");
      JMenuBar printmenubar = new JMenuBar();
      JMenu printmenu =new JMenu("Print");
      JMenuItem printitem =new JMenuItem("Print Results");
      f.setSize(1000, 500);
      f.add(new JScrollPane(table));
      printmenubar.add(printmenu);
      printmenu.add(printitem);
      printitem.addActionListener(new ActionListener(){ 
      public void actionPerformed(ActionEvent evt) {
     try {
    boolean complete = table.print();
    if (complete) {
         JOptionPane.showMessageDialog(null, "Results Printed");
    } else {
              
        JOptionPane.showMessageDialog(null, "Printing cancelled by user");   }
   } catch (PrinterException pe) {
             JOptionPane.showMessageDialog(null, "Printing failed"+pe.getMessage());
} 
      }
      }
              );
      f.setJMenuBar(printmenubar);
      
      
      f.setVisible(true);
      popolate(s, table, rs);
      f.setLocation(400, 20);
      f.setDefaultCloseOperation(2);
     } catch (Exception ex) {
      Logger.getLogger(feesrecords.class.getName()).log(Level.SEVERE, null, ex);
    } }
 public String search(String s1,Date s2,String s3,String s4){
     String ss2="";
     if(s1.isEmpty()==false){
         s1=" and feesinstallments.key = '"+s1+"'";
     }
     try{
     if(s2.toString().isEmpty()==false){
        java.sql.Date sqldate =new java.sql.Date(s2.getTime());
         ss2=" and feesinstallments.date = '"+sqldate+"'";
     }
     }
     catch (Exception e){
         
     }
     if(s3.isEmpty()==false){
         s3=" and feesinstallments.paymentoption = '"+s3+"'";
     }
     if(s4.isEmpty()==false){
         s4=" and feesinstallments.recievedby = '"+s4+"'";
     }
     String result="and 1 = 1";
     if(s1.isEmpty()==false){
         result=result+s1;
     }
     if(ss2.isEmpty()==false){
         result=result+ss2;
     }
     if(s3.isEmpty()==false){
         result=result+s3;
     }
     if(s4.isEmpty()==false){
         result=result+s4;
     }
     System.out.println(""+result);
     return result;
 } 
 

 public void advsearch() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
Connection  con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
Statement   stmt = con.createStatement();
            
         String key="";
         if((txtyear.getYear()>0)&&(((String)txtterm.getSelectedItem()).isEmpty()==false)&&(txtadmission.getText().isEmpty()==false)){
         key=""+txtyear.getYear()+(String)txtterm.getSelectedItem()+txtadmission.getText();
         }
         String stream=txtstream.getText();
         Date date=txtdate.getDate();
         String payment=txtpayment.getText();
         String balance=txtbalance.getText();
         String recieved=txtrecieved.getText();
         String sql;
         ResultSet rs;
         if((txtadmission.getText().isEmpty()==true)&&(txtstream.getText().isEmpty()==true)&&(txtbalance.getText().isEmpty()==true)){
             sql="select studentnumber,studentname,cclass,stream,feesinstallments.date,amount,newbalance,paymentoption,transactionid,recievedby  from feesinstallments ,feespayment,student where student.studentnumber=feespayment.studentadm "
                     + "and feesinstallments.key =feespayment.key and feespayment.year = '"+txtyear.getYear()+"'and"
                     + " feespayment.term ='"+txtterm.getSelectedItem()+"'and student.cclass ='"+txtclass.getSelectedItem()+"'"+search(key,date,payment,recieved);  
             System.err.println(""+1);
         rs = stmt.executeQuery(sql);
         }
         else if((txtadmission.getText().isEmpty()==true)&&(txtstream.getText().isEmpty()==true)&&(txtbalance.getText().isEmpty()==false)){
             System.err.println(""+2);
             sql="select studentnumber,studentname,cclass,stream,feesinstallments.date,amount,newbalance,paymentoption,transactionid,recievedby  from feesinstallments ,feespayment,student where student.studentnumber=feespayment.studentadm and feesinstallments.key =feespayment.key and feespayment.year = '"+txtyear.getYear()+"'and feespayment.term ='"+txtterm.getSelectedItem()+"'and student.cclass ='"+txtclass.getSelectedItem()+"'and feespayment.newbalance >='"+Integer.parseInt(txtbalance.getText())+"'"+search(key,date,payment,recieved);   
         rs = stmt.executeQuery(sql);
         }
         else if((txtadmission.getText().isEmpty()==true)&&(txtstream.getText().isEmpty()==false)&&(txtbalance.getText().isEmpty()==true)){
         sql="select studentnumber,studentname,cclass,stream,feesinstallments.date,amount,newbalance,paymentoption,transactionid,recievedby  from feesinstallments ,feespayment,student where student.studentnumber=feespayment.studentadm and feesinstallments.key =feespayment.key and feespayment.year = '"+txtyear.getYear()+"'and feespayment.term ='"+txtterm.getSelectedItem()+"'and student.cclass ='"+txtclass.getSelectedItem()+"'and student.stream ='"+txtstream.getText()+"'"+search(key,date,payment,recieved);    
         rs = stmt.executeQuery(sql);
         System.err.println(""+3);
         }
         else if((txtadmission.getText().isEmpty()==true)&&(txtstream.getText().isEmpty()==false)&&(txtbalance.getText().isEmpty()==false)){
            sql="select studentnumber,studentname,cclass,stream,feesinstallments.date,amount,newbalance,paymentoption,transactionid,recievedby  from feesinstallments ,feespayment,student where student.studentnumber=feespayment.studentadm and feesinstallments.key =feespayment.key and feespayment.year = '"+txtyear.getYear()+"'and feespayment.term ='"+txtterm.getSelectedItem()+"'"
                    + "and student.cclass ='"+txtclass.getSelectedItem()+"'and student.stream ='"+txtstream.getText()+"'and feespayment.newbalance >='"+Integer.parseInt(txtbalance.getText())+"'"+search(key,date,payment,recieved);         
         rs = stmt.executeQuery(sql);
         System.err.println(""+4);
         }
         else if((txtadmission.getText().isEmpty()==false)&&(txtstream.getText().isEmpty()==true)&&(txtbalance.getText().isEmpty()==true)){
                 sql="select studentnumber,studentname,cclass,stream,feesinstallments.date,amount,newbalance,paymentoption,transactionid,recievedby  from feesinstallments ,feespayment,student where student.studentnumber=feespayment.studentadm and feesinstallments.key =feespayment.key and feespayment.year = '"+txtyear.getYear()+"'and feespayment.term ='"+txtterm.getSelectedItem()+"'and student.cclass ='"+txtclass.getSelectedItem()+"'and student.studentnumber='"+txtadmission.getText()+"'"+search(key,date,payment,recieved);      
         rs = stmt.executeQuery(sql);
         System.err.println(""+5);
         }
         else if((txtadmission.getText().isEmpty()==false)&&(txtstream.getText().isEmpty()==true)&&(txtbalance.getText().isEmpty()==false)){
                    sql="select studentnumber,studentname,cclass,stream,feesinstallments.date,amount,newbalance,paymentoption,transactionid,recievedby  from feesinstallments ,feespayment,student where student.studentnumber=feespayment.studentadm and feesinstallments.key =feespayment.key and feespayment.year = '"+txtyear.getYear()+"'and feespayment.term ='"+txtterm.getSelectedItem()+"'and student.cclass ='"+txtclass.getSelectedItem()+"'and student.studentnumber='"+txtadmission.getText()+"'and feespayment.newbalance >='"+Integer.parseInt(txtbalance.getText())+"'"+search(key,date,payment,recieved);      
         rs = stmt.executeQuery(sql);
         System.err.println(""+6);
         }
        else if((txtadmission.getText().isEmpty()==false)&&(txtstream.getText().isEmpty()==false)&&(txtbalance.getText().isEmpty()==true)){
        sql="select studentnumber,studentname,cclass,stream,feesinstallments.date,amount,newbalance,paymentoption,transactionid,recievedby  from feesinstallments ,feespayment,student where student.studentnumber=feespayment.studentadm and feesinstallments.key =feespayment.key and feespayment.year = '"+txtyear.getYear()+"'and feespayment.term ='"+txtterm.getSelectedItem()+"'and student.cclass ='"+txtclass.getSelectedItem()+"'and student.studentnumber='"+txtadmission.getText()+"'and student.stream='"+txtstream.getText()+"'"+search(key,date,payment,recieved);                   
        rs = stmt.executeQuery(sql);
        System.err.println(""+7);
        }
        else if((txtadmission.getText().isEmpty()==false)&&(txtstream.getText().isEmpty()==false)&&(txtbalance.getText().isEmpty()==false)){
            sql="select studentnumber,studentname,cclass,stream,feesinstallments.date,amount,newbalance,paymentoption,transactionid,recievedby  from feesinstallments ,feespayment,student where student.studentnumber=feespayment.studentadm and feesinstallments.key =feespayment.key and feespayment.year = '"+txtyear.getYear()+"'and feespayment.term ='"+txtterm.getSelectedItem()+"'and student.cclass ='"+txtclass.getSelectedItem()+"'and student.studentnumber='"+txtadmission.getText()+"'and student.stream='"+txtstream.getText()+"'and feespayment.newbalance >='"+Integer.parseInt(txtbalance.getText())+"'"+search(key,date,payment,recieved);                    
        rs = stmt.executeQuery(sql);
        System.err.println(""+8);
        }
        else{
                    sql="select studentnumber,studentname,cclass,stream,feesinstallments.date,amount,newbalance,paymentoption,transactionid,recievedby from feesinstallments ,feespayment,student where student.studentnumber=feespayment.studentadm "
                     + "and feesinstallments.key =feespayment.key and feespayment.year = '"+txtyear.getYear()+"'and"
                     + " feespayment.term ='"+txtterm.getSelectedItem()+"'and student.cclass ='"+txtclass.getSelectedItem()+"'"+search(key,date,payment,recieved);
    
        rs = stmt.executeQuery(sql);
        System.err.println(""+9);
        }
         
        
        
      if(rs.first()==false){
          JOptionPane.showMessageDialog(rootPane,"No results for this search");
      }
      else{
      int s = 10;
      create(s, rs, new String[] { "AdmNumber", "Name", "Class", "Stream", "PaymentDate", "AmountPaid","Balance","PaymentMode","TransactionId","RecievedBy" });
        }

      
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
      ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(feesrecords.class.getName()).log(Level.SEVERE, null, ex);
    }
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
        txtclass = new javax.swing.JComboBox();
        btnsave1 = new javax.swing.JButton();
        pnladvanced = new javax.swing.JPanel();
        txtadmission = new javax.swing.JTextField();
        txtbalance = new javax.swing.JTextField();
        txtrecieved = new javax.swing.JTextField();
        txtpayment = new javax.swing.JTextField();
        btnsave2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtstream = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Search Record");
        setToolTipText("");
        setDoubleBuffered(true);
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/g_primaryschoolmanagement_client/hslogo.jpg"))); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblhead.setBackground(new java.awt.Color(204, 255, 204));
        lblhead.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblhead.setText("Search Records :");
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

        txtclass.setEditable(true);
        txtclass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", " " }));

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

        pnladvanced.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Advanced Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        txtadmission.setBackground(new java.awt.Color(153, 255, 102));

        txtbalance.setBackground(new java.awt.Color(153, 255, 102));
        txtbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbalanceActionPerformed(evt);
            }
        });

        txtrecieved.setBackground(new java.awt.Color(153, 255, 102));

        txtpayment.setBackground(new java.awt.Color(153, 255, 102));

        btnsave2.setBackground(new java.awt.Color(51, 51, 51));
        btnsave2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsave2.setForeground(new java.awt.Color(51, 255, 0));
        btnsave2.setText("Advanced Search ");
        btnsave2.setToolTipText("");
        btnsave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsave2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Admission Number:");

        jLabel5.setText("Balance Limit :");

        jLabel6.setText("Payment Date :");

        jLabel7.setText("Recieved By :");

        jLabel8.setText("Payment Mode :");

        txtstream.setBackground(new java.awt.Color(153, 255, 102));

        jLabel9.setText("Stream :");

        javax.swing.GroupLayout pnladvancedLayout = new javax.swing.GroupLayout(pnladvanced);
        pnladvanced.setLayout(pnladvancedLayout);
        pnladvancedLayout.setHorizontalGroup(
            pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnladvancedLayout.createSequentialGroup()
                .addGroup(pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnladvancedLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsave2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnladvancedLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnladvancedLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtrecieved, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnladvancedLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnladvancedLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(txtstream, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnladvancedLayout.createSequentialGroup()
                        .addGroup(pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtadmission)
                            .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnladvancedLayout.setVerticalGroup(
            pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnladvancedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnsave2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtstream, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtadmission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtrecieved, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnladvancedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

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
                                    .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblhead, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(76, 76, 76)))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlloginLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsave1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnexit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnladvanced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 52, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlloginLayout.createSequentialGroup()
                .addComponent(lblhead)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnsave1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnladvanced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    try {
        // TODO add your handling code here:
        advsearch();
    } catch (SQLException ex) {
        Logger.getLogger(feesrecords.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnsave1ActionPerformed

    private void btnsave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsave2ActionPerformed
    try {
        // TODO add your handling code here:
        advsearch();
    } catch (SQLException ex) {
        Logger.getLogger(feesrecords.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnsave2ActionPerformed

    private void txtbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbalanceActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsave1;
    private javax.swing.JButton btnsave2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblhead;
    private javax.swing.JPanel pnladvanced;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JTextField txtadmission;
    private javax.swing.JTextField txtbalance;
    private javax.swing.JComboBox txtclass;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtpayment;
    private javax.swing.JTextField txtrecieved;
    private javax.swing.JTextField txtstream;
    private javax.swing.JComboBox txtterm;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
