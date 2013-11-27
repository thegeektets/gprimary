package g_primaryschoolmanagement_client;

import java.awt.Color;
import java.awt.Font;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

public class search extends JInternalFrame
{
    
  
   public static Connection con;
  public static Statement stmt;
  main mf;
  private JButton btnbyadm;
  private JButton btnbyexam;
  private JButton btnbyyear;
   private JButton jButton4;
  private JButton jButton5;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JPanel jPanel2;
  private JPanel jPanel3;
  private JPopupMenu jPopupMenu1;
  private JPopupMenu jPopupMenu2;
  public static JLabel lblpic;
  private JTextField txtadmno;
  private JTextField txtadmno1;
  private JTextField txtcls;
  private JTextField txtexamno;
  private JTextField txtparentid;
  private JTextField txttrm;
  private JTextField txtyear;
  private JComboBox  txtpreviewmode;  
    private JLabel lblpreview;

  public search(main my)
  {
    initComponents();
    this.mf = my;
  
  }
public search()
  {
    initComponents();
  
  }

  public static void popolate(int s, JTable tbale, ResultSet rs)
    throws SQLException
  {
    con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();

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
 public static String dbusername="root";
 public  static String dbhostip;
 public  static String dbpassword;
public  static String database;  
    public static void dblogincred(){
    
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
   public static void create(int s, ResultSet rs, String[] heads) throws SQLException { con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
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
      f.setSize(1000,500);
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
      f.setExtendedState(JFrame.MAXIMIZED_BOTH);
      popolate(s, table, rs);
      f.setDefaultCloseOperation(2);
    } catch (SQLException ex) {
      Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
    } }

  public static void searchstd(int adm) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
      ResultSet rs = stmt.executeQuery("Select studentnumber,studentname,class,stream,house,parentsid ,spic from student where studentnumber=" + adm);
      int s = 6;
      create(s, rs, new String[] { "Admno", "Name", "Class", "Stream", "House", "Parents Idno" });

      rs.first();
      if(rs.getString("spic")!=null){
      ImageIcon spic = new ImageIcon(rs.getString("spic"));
      Image sp = spic.getImage();
      Image resizedImage = sp.getScaledInstance(lblpic.getWidth(), lblpic.getHeight(), 0);
      ImageIcon rim = new ImageIcon(resizedImage);
      lblpic.setIcon(rim);
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
    }
  }

  public static void searchpr(int adm) throws SQLException
  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
      ResultSet rs = stmt.executeQuery("Select parentid,parentname,parent.sex,phone,occupation,residence,spic from parent,student where parentsid=parentid and studentnumber=" + adm);
      int s = 6;
      create(s, rs, new String[] { "Parent Id", "Fullname", "Sex", "Phone", "Occupation", "Residence" });

      rs.first();
      if(rs.getString("spic")!=null){
      ImageIcon spic = new ImageIcon(rs.getString("spic"));
      Image sp = spic.getImage();
      Image resizedImage = sp.getScaledInstance(lblpic.getWidth(), lblpic.getHeight(), 0);
      ImageIcon rim = new ImageIcon(resizedImage);
      lblpic.setIcon(rim);
      }} catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
    }
  }

  public static void searchpar(int parid) throws SQLException { con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
   
      ResultSet rs = stmt.executeQuery("Select studentnumber,parentid,parentname,parent.sex,phone,occupation,residence from parent,student where parlientsid=parentid and parentid=" + parid);
      int s = 6;
      create(s, rs, new String[] { "Parent Id", "Fullname", "Sex", "Phone", "Occupation", "Residence" });

      rs.first();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        } }

  public static void searchexmbyadm(int adm) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
      ResultSet rs = stmt.executeQuery("Select exam.examno,yearofadm,exam.class,term,examtype,studentnumber,studentname,math,insha,lugha,kiswa,comp,grammer,eng,science,re,social,socialstudies,spic from exam,student,score where score.admno=studentnumber and exam.examno=score.examno and studentnumber=" + adm);

      int s = 18;
      create(s, rs, new String[] { "Exam no", "Year", "Form", "Term", "Exam Type", "Admno", "Fullname", "Maths", "Insha", "Lugha", "Kiswa", "Composition", "Grammer","English","Science","Religous/Studies","Social","Social/Studies"});

      rs.first();
      try {
          if(rs.getString("spic")!=null){
        ImageIcon spic = new ImageIcon(rs.getString("spic"));
        Image sp = spic.getImage();
        Image resizedImage = sp.getScaledInstance(lblpic.getWidth(), lblpic.getHeight(), 0);
        ImageIcon rim = new ImageIcon(resizedImage);
        lblpic.setIcon(rim);
          }}
      catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Image not found");
      }
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
    }
  }
public static void searchexmbyadmwithtotals(int adm) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
      ResultSet rs = stmt.executeQuery("Select exam.examno,yearofadm,exam.class,term,examtype,studentnumber,studentname,math,insha,lugha,kiswa,comp,grammer,eng,science,re,social,socialstudies,(math+kiswa+eng+science+socialstudies)  as  Total,spic from exam,student,score where score.admno=studentnumber and exam.examno=score.examno and studentnumber=" + adm);

      int s = 19;
      create(s, rs, new String[] { "Exam no", "Year", "Form", "Term", "Exam Type", "Admno", "Fullname","Maths", "Insha", "Lugha", "Kiswa", "Composition", "Grammer","English","Science","Religous/Studies","Social","Social/Studies","Total"});
      

      rs.first();
      try {
          if(rs.getString("spic")!=null){
        ImageIcon spic = new ImageIcon(rs.getString("spic"));
        Image sp = spic.getImage();
        Image resizedImage = sp.getScaledInstance(lblpic.getWidth(), lblpic.getHeight(), 0);
        ImageIcon rim = new ImageIcon(resizedImage);
        lblpic.setIcon(rim);
          }}
      catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Image not found");
      }
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
    }
  }

  public static void searchexmbyexmno(String exmno) throws SQLException { con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
   
      ResultSet rs = stmt.executeQuery("Select exam.examno,yearofadm,exam.class,term,examtype,studentnumber,studentname,math,insha,lugha,kiswa,comp,grammer,eng,science,re,social,socialstudies, from exam,student,score where score.admno=studentnumber and exam.examno=score.examno and exam.examno= '" + exmno+"'");

      int s = 18;
      create(s, rs, new String[] { "Exam no", "Year", "Form", "Term", "Exam Type", "Admno", "Fullname", "Maths", "Insha", "Lugha", "Kiswa", "Composition", "Grammer","English","Science","Religous/Studies","Social","Social/Studies"});
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        } }
public static void searchexmbyexmnototals(String exmno) throws SQLException { con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
   
      ResultSet rs = stmt.executeQuery("Select exam.examno,yearofadm,exam.class,term,examtype,studentnumber,studentname,math,insha,lugha,kiswa,comp,grammer,eng,science,re,social,socialstudies,(math+kiswa+eng+science+socialstudies) as Total from exam,student,score where score.admno=studentnumber and exam.examno=score.examno and exam.examno='" + exmno+"'");

      int s = 19;
      create(s, rs, new String[] { "Exam no", "Year", "Form", "Term", "Exam Type", "Admno", "Fullname", "Maths", "Insha", "Lugha", "Kiswa", "Composition", "Grammer","English","Science","Religous/Studies","Social","Social/Studies"  ,"Total"});
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        } }
public static void searchexmbyyr(int yr, int cls, int trm) throws SQLException {
    con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
   
      ResultSet rs = stmt.executeQuery("Select exam.examno,yearofadm,exam.class,term,examtype,studentnumber,studentname,math,insha,lugha,kiswa,comp,grammer,eng,science,re,social,socialstudies from exam,student,score where score.admno=studentnumber and exam.examno=score.examno and yearofadm='" + yr + "'" + "and exam.class='" + cls + "'" + "and term='" + trm+"'");

      int s = 18;
      create(s, rs, new String[] { "Exam no", "Year", "Form", "Term", "Exam Type", "Admno", "Fullname", "Maths", "Insha", "Lugha", "Kiswa", "Composition", "Grammer","English","Science","Religous/Studies","Social","Social/Studies" });
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
public static void searchexmbyyrtotal(int yr, int cls, int trm) throws SQLException {
    con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
    stmt = con.createStatement();
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
   
      ResultSet rs = stmt.executeQuery("Select exam.examno,yearofadm,exam.class,term,examtype,studentnumber,studentname,math,insha,lugha,kiswa,comp,grammer,eng,science,re,social,socialstudies,"
              + "(math+kiswa+eng+science+socialstudies) as Total "
              + "from exam,student,score where score.admno=studentnumber and exam.examno=score.examno and yearofadm='" + yr + "'" + "and exam.class='" + cls + "'" + "and term=" + trm);

      int s = 14;
      create(s, rs, new String[] { "Exam no", "Year", "Form", "Term", "Exam Type", "Admno", "Fullname", "Maths", "Insha", "Lugha", "Kiswa", "Composition", "Grammer","English","Science","Religous/Studies","Social","Social/Studies" ,"Total" });
    }
    catch (SQLException ex)
    {
      JOptionPane.showMessageDialog(null, "Record not found" + ex.getMessage());
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

  private void initComponents()
  {
    dblogincred();
    this.jPopupMenu1 = new JPopupMenu();
    this.jPopupMenu2 = new JPopupMenu();
    this.btnbyyear = new JButton();
    this.btnbyadm = new JButton();
    this.jPanel3 = new JPanel();
    this.txtexamno = new JTextField();
    this.jLabel3 = new JLabel();
    this.txtadmno1 = new JTextField();
    this.jLabel4 = new JLabel();
    this.txtcls = new JTextField();
    this.jLabel5 = new JLabel();
    this.txtyear = new JTextField();
    this.jLabel6 = new JLabel();
    this.jLabel7 = new JLabel();
    this.txttrm = new JTextField();
    this.jPanel2 = new JPanel();
    this.txtadmno = new JTextField();
    this.txtparentid = new JTextField();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jButton4 = new JButton();
    this.jButton5 = new JButton();
    this.txtpreviewmode= new JComboBox();
    lblpic = new JLabel();
    this.btnbyexam = new JButton();
    this.lblpreview=new JLabel();
    
    setClosable(true);
    setForeground(Color.lightGray);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("Search ");
    addInternalFrameListener(new InternalFrameListener() {
      public void internalFrameActivated(InternalFrameEvent evt) {
      }
      public void internalFrameClosed(InternalFrameEvent evt) {
      }
      public void internalFrameClosing(InternalFrameEvent evt) {
        search.this.formInternalFrameClosing(evt);
      }

      public void internalFrameDeactivated(InternalFrameEvent evt)
      {
      }

      public void internalFrameDeiconified(InternalFrameEvent evt)
      {
      }

      public void internalFrameIconified(InternalFrameEvent evt)
      {
      }

      public void internalFrameOpened(InternalFrameEvent evt)
      {
      }
    });
    this.btnbyyear.setText("Search Exam by Year...");
    this.btnbyyear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        search.this.btnbyyearActionPerformed(evt);
      }
    });
    this.btnbyadm.setText("Search Exam By Admno");
    this.btnbyadm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          try {
              search.this.btnbyadmActionPerformed(evt);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    });
    this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Search Exams Print Results", 0, 0, new Font("Traditional Arabic", 0, 18)));

    this.txtexamno.setFont(new Font("Traditional Arabic", 0, 18));

    this.jLabel3.setFont(new Font("Traditional Arabic", 0, 18));
    this.jLabel3.setText("Student Admno");
    this.jLabel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    this.txtadmno1.setFont(new Font("Traditional Arabic", 0, 18));
    this.txtadmno1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        search.this.txtadmno1ActionPerformed(evt);
      }
    });
    this.jLabel4.setFont(new Font("Traditional Arabic", 0, 18));
    this.jLabel4.setText("Exam Number");
    this.jLabel4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    this.txtcls.setFont(new Font("Traditional Arabic", 0, 18));

    this.jLabel5.setFont(new Font("Traditional Arabic", 0, 18));
    this.jLabel5.setText("Year");
    this.jLabel5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
    this.txtexamno.setText(""+"Exam Type"+"-"+"Class"+"-"+"Stream"+"-"+"Term"+"-"+"Year");
    this.txtyear.setFont(new Font("Traditional Arabic", 0, 18));
    this.txtyear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        search.this.txtyearActionPerformed(evt);
      }
    });
    this.jLabel6.setFont(new Font("Traditional Arabic", 0, 18));
    this.jLabel6.setText("Class");
    this.jLabel6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    this.jLabel7.setFont(new Font("Traditional Arabic", 0, 18));
    this.jLabel7.setText("Term");
    this.jLabel7.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    this.txttrm.setFont(new Font("Traditional Arabic", 0, 18));
    this.txttrm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        search.this.txttrmActionPerformed(evt);
      }
    });
        this.lblpreview.setFont(new Font("Traditional Arabic", 0, 18));
    this.lblpreview.setText("");
    this.lblpreview.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    this.txtpreviewmode.setFont(new Font("Traditional Arabic", 0, 18));
    this.txtpreviewmode.addItem("Just Raw Data");
    this.txtpreviewmode.addItem("Processed Totals");
    
    
    this.txtpreviewmode.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        search.this.txtpreviewmodeActionPerformed(evt);
      }
    });
    GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
    this.jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel3, -1, 222, 32767).addGap(10, 10, 10).addComponent(this.txtadmno1, -2, 165, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel4, -1, 222, 32767).addGap(10, 10, 10).addComponent(this.txtexamno, -2, 165, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel5, -1, 222, 32767).addGap(10, 10, 10).addComponent(this.txtyear, -2, 165, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel6, -1, 222, 32767).addGap(10, 10, 10).addComponent(this.txtcls, -2, 165, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel7, -1, 222, 32767).addGap(10, 10, 10).addComponent(this.txttrm, -2, 165, -2)).addGroup(jPanel3Layout.createSequentialGroup()).addComponent(this.lblpreview, -1, 222, 32767).addGap(10, 10, 10).addComponent(this.txtpreviewmode, -2, 222, -2)).addContainerGap()));

    jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel3, -1, -1, 32767).addComponent(this.txtadmno1, -2, 29, 32767)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4, -1, 29, 32767).addComponent(this.txtexamno, -2, 29, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel5, -1, -1, 32767).addComponent(this.txtyear, -2, 29, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6, -1, 29, 32767).addComponent(this.txtcls, -2, 29, -2)).addGap(14, 14, 14).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel7, -1, -1, 32767).addComponent(this.txttrm, -2, 29, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblpreview, -1, -1, 32767).addComponent(this.txtpreviewmode, -2, 29, -2)).addContainerGap()));

    this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, "Search student/parent", 0, 0, new Font("Traditional Arabic", 0, 18)));
    
          
              this.txtadmno.setFont(new Font("Traditional Arabic", 0, 18));
    this.txtadmno.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        search.this.txtadmnoActionPerformed(evt);
      }
    });
    this.txtparentid.setFont(new Font("Traditional Arabic", 0, 18));

    this.jLabel1.setFont(new Font("Traditional Arabic", 0, 18));
    this.jLabel1.setText("Student Admno");
    this.jLabel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    this.jLabel2.setFont(new Font("Traditional Arabic", 0, 18));
    this.jLabel2.setText("Parent Idno");
    this.jLabel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    this.jButton4.setText("Search Student");
    this.jButton4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          try {
              search.this.jButton4ActionPerformed(evt);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    });
    this.jButton5.setText("Search Parent");
    this.jButton5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          try {
              search.this.jButton5ActionPerformed(evt);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    });
    lblpic.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2, -1, 192, 32767).addComponent(this.jLabel1, -1, 192, 32767).addComponent(lblpic, GroupLayout.Alignment.LEADING, -2, 192, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtadmno, GroupLayout.Alignment.TRAILING, -2, 165, -2).addComponent(this.txtparentid, GroupLayout.Alignment.TRAILING, -2, 165, -2).addComponent(this.jButton5, GroupLayout.Alignment.TRAILING, -2, 197, -2).addComponent(this.jButton4, GroupLayout.Alignment.TRAILING, -2, 197, -2)).addContainerGap()));

    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel1, -1, -1, 32767).addComponent(this.txtadmno, -2, 29, 32767)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2, -1, 29, 32767).addComponent(this.txtparentid, -2, 29, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jButton4, -2, 48, -2).addGap(34, 34, 34).addComponent(this.jButton5, -2, 48, -2)).addComponent(lblpic, -2, 171, -2)).addContainerGap()));

    this.btnbyexam.setText("Search Exam by Examno");
    this.btnbyexam.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          try {
              search.this.btnbyexamActionPerformed(evt);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    });
   
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -1, -1, 32767).addGap(14, 14, 14)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnbyexam, -2, 197, -2)).addGap(40, 40, 40).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.btnbyyear, -2, 197, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 163, 32767).addComponent(this.btnbyadm, -2, 197, -2).addGap(23, 23, 23)).addGroup(layout.createSequentialGroup().addContainerGap()))))));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnbyexam, -1, 46, 32767).addComponent(this.btnbyadm, -2, 44, -2).addComponent(this.btnbyyear, -2, 44, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false))));

    pack();
  }

  private void btnbyyearActionPerformed(ActionEvent evt) {
    try {
        Class.forName("com.mysql.jdbc.Driver");
   
    
    
      con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
      stmt = con.createStatement();

      String adm = this.txtyear.getText();
      String cls = this.txtcls.getText();
      String trm = this.txttrm.getText();
      if ((adm.isEmpty()) || (cls.isEmpty()) || (trm.isEmpty())) {
        JOptionPane.showMessageDialog(null, "Please input the Year,Class,Term of the exam before you can proceed");
      }
      else
      {
        int ad = Integer.parseInt(adm);
        int cl = Integer.parseInt(cls);
        int tr = Integer.parseInt(trm);
        int c =txtpreviewmode.getSelectedIndex();
        if(c==0){
            searchexmbyyr(ad, cl, tr);
        }
        else if(c==1){
            searchexmbyyrtotal(ad, cl, tr);
      }
    
      }

 
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Record not found");
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

  private void btnbyadmActionPerformed(ActionEvent evt) throws ClassNotFoundException
  {
    try {
        Class.forName("com.mysql.jdbc.Driver");
   
      con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
      stmt = con.createStatement();

      String adm = this.txtadmno1.getText();
      if (adm.isEmpty())
        JOptionPane.showMessageDialog(null, "Please input the admission number of the student before you proceed");
      else {
        try
        {
          int ad = Integer.parseInt(adm);
          int c =txtpreviewmode.getSelectedIndex();
        if(c==0){
          searchexmbyadm(ad);
        }
        else if (c==1){
           searchexmbyadmwithtotals(ad);
           
        }
          } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Record not found");
        }
      }


    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Record not found");
    }
  }

  private void txtadmno1ActionPerformed(ActionEvent evt)
  {
  }

  private void txtyearActionPerformed(ActionEvent evt)
  {
  }

  private void txttrmActionPerformed(ActionEvent evt)
  {
  }

  private void txtadmnoActionPerformed(ActionEvent evt)
  {
  }

  private void jButton4ActionPerformed(ActionEvent evt) throws ClassNotFoundException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
   
      con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
      stmt = con.createStatement();

      String adm = this.txtadmno.getText();
      if (adm.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please input the admission number of the student before you proceed");
      }
      else
      {
        int ad = Integer.parseInt(adm);
     
        
        searchstd(ad);
     
      }
    }
    catch (SQLException ex)
    {
      Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void jButton5ActionPerformed(ActionEvent evt) throws ClassNotFoundException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
   
      con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
      stmt = con.createStatement();

      String adm = this.txtadmno.getText();
      String pr = this.txtparentid.getText();
      if ((adm.isEmpty()) && (pr.isEmpty())) {
        JOptionPane.showMessageDialog(null, "Please input the admission number of the student or the parent id before you proceed");
      }
      else if (adm.isEmpty())
      {
        int ad = Integer.parseInt(pr);
        searchpar(ad);
      }
      else
      {
        int ad = Integer.parseInt(adm);
        searchpr(ad);
      }
    } catch (SQLException ex) {
      Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void btnbyexamActionPerformed(ActionEvent evt) throws ClassNotFoundException {
    try {
        Class.forName("com.mysql.jdbc.Driver");
   
      con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
      stmt = con.createStatement();

      String adm = this.txtexamno.getText();
      if (adm.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please input the exam number of the Exam before you proceed");
      }
      else
      {
        String ad = adm;
        int c =txtpreviewmode.getSelectedIndex();
    if(c==0){
        searchexmbyexmno(ad);
    }
    else if(c==1){
        searchexmbyexmnototals(ad);
    }  
    
   
    }

     
    } catch (SQLException ex) {
      Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void formInternalFrameClosing(InternalFrameEvent evt) {
     dispose();
  }

  private void btngenrActionPerformed(ActionEvent evt)
  {
  }

    private void txtpreviewmodeActionPerformed(ActionEvent evt) {
      
         ////
        
    }
}