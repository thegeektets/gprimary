/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_administrator_windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class timetable extends javax.swing.JInternalFrame {
public String dbhostip=null;
public String dbpassword=null;

public String database =null;
public String dbusername=null;
int action;
String teachers[][]=new String [2][120];
String classes[]=new String [120];
String subjects[][]=new String [4][120];
String msubjects[]=new String [120];
String dsubjects[]=new String [120];
String blocktable[][][];
    public timetable() {
        initComponents();
        readcred();
        teachers();
        subjects();
        classes();
         
       
      }
   public int realsize(String Array []){
        int size=Array.length;
        int realsize=1;
             
     for(int rs=0;rs<size;rs++){
         if(Array[rs] == null){
             
         }
         else{
             realsize++;
         }
     }
     return realsize;
    }
   public String addlesson(int day,String currentclass,int lessonnumber){
       String possible = null;
      //limit variables to the above parameters
       //teacher  that teach that class and not busy in another class during that time of day
       String freeteachers[]=new String [50];
       int tr =teachers.length;
       int allclasses=realsize(classes);
       for(int a=0;a<tr;a++){
       String teacher=teachers[1][a];
       //System.err.println(teacher);
       //check if teacher teacher teachers current class
                   try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
       String user = dbusername;
       String pass= dbpassword;
       Connection con = DriverManager.getConnection(host, user, pass);
       Statement st=con.createStatement();
       String sql="select * from subjectallocation where teacherid ='"+teacher+"'";
       ResultSet rs=st.executeQuery(sql);
       if(rs.next()){
           int al=0;
           //check if teacher is commited elsewhere
           while(al<allclasses){
           if((blocktable[day][al][lessonnumber]!=null) && (blocktable[day][al][lessonnumber].contains(teacher))){
              
           }
           else{
               //teacher not commited
               freeteachers[a]=teacher;
       //        System.err.println("free :"+teacher);
                 
           }
            al++;
           }}}catch (Exception e){
               e.printStackTrace();
           }
       }
       //check lessons that have not been taught at all that day include also doubles that may not have 
       //happened on earlier days of the week and all other lessons that have not been taught
       //also check if teacher is free during that time of day 
       //System.err.println("-----move on to subjects-------");
       String possiblesubjects[]=new String [50];
       int sb=subjects.length;
       for (int a=0;a<sb;a++){
          //defined subjects for this class 
           if(currentclass.contains(""+subjects[0][a])){
               String subject=subjects[1][a];
               //check if free teachers teach this subject
             // System.out.println("Analysis subject :"+subject);
               int fre = 0;
               int lfre=realsize(freeteachers);
          //    System.err.println("freeteacherssize :"+lfre);
               while(fre<lfre){
               String teacher=freeteachers[fre];
               //System.out.println("Analysis teacher :"+teacher);
             
               
                       try {
                 Class.forName("com.mysql.jdbc.Driver");
                 String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                 String user = dbusername;
                 String pass= dbpassword;
                 Connection conmy = DriverManager.getConnection(host, user, pass);
                 // System.err.println("checking --"+currentclass+"--"+teacher+"---"+subject);
                 
                 if((currentclass !=null)&&(teacher !=null)&&(subject !=null)){
                     //System.err.println("checking --"+currentclass+"--"+teacher+"---"+subject);
                 Statement stmy=conmy.createStatement();
                 String search=teacher +" "+currentclass.trim();
               // System.out.println(search);
                 String sqlmy="select * from subjectallocation where concat(teacherid,' ',class,' ',stream) = '"+search+"'";
                 ResultSet rsmy=stmy.executeQuery(sqlmy);
                 if(rsmy.next()){
              //   System.err.println("result true for --"+subject);
                 possiblesubjects[a]=subject;
                 
               }
                 else{
                     System.err.println("?????");
                 }
                 }
           }catch(Exception e){
               System.err.println("oooh sh****t");
               e.printStackTrace();
           }
                fre++;
               }
           }
       }
       
      ///checking priorities to further reduce possible subjects
       int psb=realsize(possiblesubjects);
       //System.err.println("possible subjects here:"+psb);
       String reallypossiblesubjects[]=new String [20];
       
       for(int p=0;p<psb;p++){
           String subject=possiblesubjects[p];
           //check if taught today
           
               if((subject !=null)&&(compare(subject,taughttoday(day,currentclass,subject,lessonnumber))==true)){
                   //subject has been taught today check if it can be taught again
                   System.out.println(subject+ " taught today");
                   if(compare(subject,msubjects)==true){
                       //can be taught more than once in a day 
                       //check if this subject has been taught more than once anyday this week
                       int taught=0;
                       
                       for(int h=0;h<day;h++){
                           int  numberofclasses=realsize(classes);
                           for (int x=0;x<numberofclasses;x++){
                               //eliminate other classes apart from current class;
                               if(blocktable[h][x][0].equals(currentclass)){
                                    for(int y=0;y<Integer.parseInt(txtlessons.getText());y++){
                                        if(blocktable[h][x][y]==subject){
                                            taught++;
                                        }
                                    }
                               }
                           }
                       }
                       if (taught>1){
                         //move on to the next subject 
                          
                           
                       }
                       else{
                           //add to really possible 
                           //move on
                           reallypossiblesubjects[p]=subject;
                           return subject;
                      
                       }
                       
                       
                   }
                   else {
                       //check if doubles are allowed
                       if(compare(subject,dsubjects)==true){
                           //doubles allowed so can be taught again today
                           //check if subject has bee taught more that once this week
                            int taught=0;
                       
                       for(int h=0;h<day;h++){
                           int  numberofclasses=realsize(classes);
                           for (int x=0;x<numberofclasses;x++){
                               //eliminate other classes apart from current class;
                               if(blocktable[h][x][0].equals(currentclass)){
                                    for(int y=0;y<Integer.parseInt(txtlessons.getText());y++){
                                        if(blocktable[h][x][y]==subject){
                                            taught++;
                                        }
                                    }
                               }
                           }
                       }
                       if (taught>1){
                         //move on to the next subject 
                           
                           
                       }
                       else{
                           //add to really possible 
                           //move on
                           reallypossiblesubjects[p]=subject;
                           return subject;
                       }
                           
                           
                       }
                       else{
                       //not possible to teach this subject again today int the same class    
                        
                       }
                   }}
               
               else if (subject !=null){
                   
               //subject has not been taught today
               //check that subject has not exceeded its maximum lessons this week
                   if(checkexceed(day,currentclass,subject)==true){
                    //exceed true move on
                       
                   }
                   else{
                   //subject really possible
               //        System.out.println(subject+ " added to reallpossible");
                 
                      reallypossiblesubjects[p]=subject;
                     //  System.out.println(
                      return subject;
                          
                   }
               }
         if(subject!=null){
          reallypossiblesubjects[p]=subject;
          return subject;
         }
       //  System.out.println( reallypossiblesubjects[p]);
       
           
    }
       int allpossible=(reallypossiblesubjects.length);
       
       // System.out.println(allpossible+" subjects are all possible here");
        
        for(int b=0;b<allpossible;b++){
              possible=reallypossiblesubjects[psb];
          //  System.out.println(""+possible);
           return possible; 
        }
        
        
    return possible;
        
    }
   public String[] taughttoday(int day ,String cclass,String subject,int lessonnumber){
        String taught[]=new String [Integer.parseInt(txtlessons.getText())];
        for(int y=0;y<lessonnumber;y++){
            taught[y]=blocktable[day][classdayindex(day,cclass)][y];    
        
            }
        
        return taught;
        
    }
   public boolean checkexceed(int day,String currentclass,String subject){
     //number of times taught this week
        int taughttimes=0;
        for(int h=0;h<day;h++){
            
            for(int x=0;x<classdayindex(day,currentclass);x++){
                if(blocktable[h][x][0]==currentclass){
                    for(int y=0;y<Integer.parseInt(txtlessons.getText());y++){
                        if(blocktable[h][x][y]==subject){
                            taughttimes++;
                        }
                    }
                }
            }
        }
        if(taughttimes >=lessonsperweek(subject,currentclass)){
            return true;
            
        }
        else{
            return false;
        }
        
        
        
        
    }
   public int lessonsperweek(String subject,String cclass){
        int number=0;
        int alls=subjects.length;
        int al=0;
        while(al<alls){
            
            if(cclass.contains(""+subjects[0][al])){
              if(subject == null ? subjects[1][al] == null : subject.equals(subjects[1][al])){
                  if(subjects[2][al] !=null){
                  number=Integer.parseInt(subjects[2][al]);
                  }
              al++;
              }
              else{
                 al++;
              }
            }
            else{
                al++;
            }
        }
        return number;
        
    }
   public int classdayindex(int day,String currentclass){
        int numberofclasses=realsize(classes);
        int number = 0;
        int stopnumber=day*numberofclasses;
        if(day==0){
            stopnumber=numberofclasses;
        }
        int statnumber=0;
        if(((stopnumber)-numberofclasses)>=0){
            statnumber=stopnumber-numberofclasses;
        }
        
        for(int index=statnumber;index<(stopnumber);index++){
            
        if(blocktable[day][index][0] == null ){
                }
        else if((blocktable[day][index][0]).equals(currentclass)){
                   number=index;
     
        }
            
        }
    return number;
        
    }
   public boolean compare(String search ,String parent[]){
        int l=parent.length;
        for(int c=0;c<l;c++){
            if((search !=null)&&(parent !=null)){
            if(search.equals(parent[c])){
                return true;
            }
           }}
    return false;
    }
   public void teachers(){
        try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String sql="select * from classallocation where year ='"+txtyear.getYear()+"' and term ='"+txtterm.getSelectedItem()+"'";
ResultSet rs=st.executeQuery(sql);
rs.last();
int r=rs.getRow();
rs.beforeFirst();
int l=0;
while(rs.next()){
Connection mycon = DriverManager.getConnection(host, user, pass);
Statement stm=mycon.createStatement();
String sq="select * from teachers where idnumber ='"+rs.getInt("teacherid")+"'";
ResultSet rst=stm.executeQuery(sq);
rst.next();
    
teachers[0][l]=rst.getString("fullname");
teachers[1][l]=""+rst.getString("idnumber");

System.out.print(teachers[0][l] +" "+teachers[1][l]);
System.out.println("");
l++; 
    
    }

  


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
    }
   
      
}
   public void subjects(){
        try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String sql="select * from subjects";
ResultSet rs=st.executeQuery(sql);
rs.last();
int r=rs.getRow();
rs.beforeFirst();
int l=0;
while(rs.next()){
subjects[0][l]=""+rs.getInt("class");
subjects[1][l]=""+rs.getString("subject");
subjects[2][l]=""+rs.getInt("subjectsperweek");
subjects[3][l]=""+rs.getString("doubles");
System.out.print(subjects[0][l] +" "+subjects[1][l]+" "+subjects[2][l]+" "+subjects[3][l]);
System.out.println("");
l++; 
    
    }
int s=l;
int d=0;
int m=0;
for(int a=0;a<s;a++){
    if(subjects[3][a].equals(true)){
        dsubjects[d]=subjects[1][a];
        d++;
    }
    if(Integer.parseInt(subjects[0][a])>(new java.lang.Integer(5))){
        msubjects[m]=subjects[1][a];
        m++;
    }
    
}

  


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
    }
   
      
}
   public void classes(){
        try {
       Class.forName("com.mysql.jdbc.Driver");
       String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
               String user = dbusername;
               String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
Statement st=con.createStatement();
String sql="select * from subjectallocation where subjectallocation.key = "+Integer.parseInt(""+txtyear.getYear()+txtterm.getSelectedItem());
ResultSet rs=st.executeQuery(sql);
int l=0;
while(rs.next()){
classes[l]=""+rs.getInt("class")+" "+rs.getString("stream");

System.out.print(classes[l]);
System.out.println("");
l++; 
    
    }
///removing duplicates from array
int r=l;
//new empty array
String emptyclasses[]= new String [120];
int e=0;
int s=0;
s = emptyclasses.length;

for(int a=0;a<l;a++){
    String newclass=classes[a];
          if(compare(newclass,emptyclasses)==false){
         
              emptyclasses[e]=""+newclass;
             e++;
          }
      }

//clean old classes
int o=r;
for(int c=0;c< o; c++){
    classes[c]=null;
}
//populate new classes
int n=emptyclasses.length;
int ec=0;
while(ec<n){
classes[ec]=emptyclasses[ec];
ec++;
}//print out clean classes
/*System.err.println("final classes");
int f=r;
        for(int a=0;a<f;a++){
            if(classes[a] == null){
            }
            else{
           System.out.print(""+classes[a]);
           System.out.println("");
       }
        }


  
*/

    } catch (ClassNotFoundException ex) {
        Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
    }
     }
   public void blocktable(int lessons ,int days){
         System.err.println("--------Timetable----------");
            
         int numberclasses=0;
         int n=classes.length;
         for(int x=0;x<n;x++){
             if(classes[x]!=null){
                 numberclasses++;
         }
         }
        int x=(numberclasses+2)*days;
        blocktable=new String[days][x][lessons];
        //add days
        x=0;
        int l=0;
        
      DefaultTableModel model = new DefaultTableModel();
      final JTable table = new JTable(model);
      int row=0;
      while (row < lessons) {
            model.addColumn("lesson "+(row+1));
       row++;
      }
      int head = 0;
      while (head < ((numberclasses+2)*days)) {
          
        model.addRow(new Object[0]);
   
          head++;
      }
      
        
   for(int h=0;h<days;h++){
        blocktable[h][x][l]=""+(h+1);
          for(int a=0;a<numberclasses;a++){
                blocktable[h][a][l]=classes[a];
                for(int y=0;y<lessons;y++){
                  blocktable[h][x][y]=addlesson(h," "+blocktable[h][a][y],y);
                table.setValueAt("  "+addlesson(h,""+blocktable[h][a][y],y),x,y);
                     
                 }
          System.out.println("");
               
                l++;
            }
               x++;          
              
        }
   JFrame f = new JFrame("School Timetable");
      JMenuBar printmenubar = new JMenuBar();
      JMenu printmenu =new JMenu("Print");
      JMenuItem printitem =new JMenuItem("Print TimeTable");
      f.setSize(1000,500);
      f.add(new JScrollPane(table));
      
      printmenubar.add(printmenu);
      printmenu.add(printitem);
      printitem.addActionListener(new ActionListener(){ 
      public void actionPerformed(ActionEvent evt) {
     try {
    boolean complete = table.print();
    if (complete) {
         JOptionPane.showMessageDialog(null, "Timetable Printed");
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
      
      f.setDefaultCloseOperation(2);
     
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
        Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
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
        lblusername2 = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtterm = new javax.swing.JComboBox();
        txtyear = new com.toedter.calendar.JYearChooser();
        lblwarning = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtclass1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtclass2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtclass3 = new javax.swing.JTextField();
        txtclass4 = new javax.swing.JTextField();
        txtclass5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtclass6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnschooltimetable = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtclass7 = new javax.swing.JTextField();
        txtclass8 = new javax.swing.JTextField();
        txtclass9 = new javax.swing.JTextField();
        txtclass10 = new javax.swing.JTextField();
        txtclass11 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtlessons = new javax.swing.JTextField();
        lblinformation = new javax.swing.JLabel();
        lblstart = new javax.swing.JLabel();
        lblstop = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtdays = new javax.swing.JTextField();
        lblfooter = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 153));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Timetable");
        setToolTipText("");
        setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/g_administrator_windows/hslogo.jpg"))); // NOI18N

        pnllogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblusername2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblusername2.setText("Create Timetable:");

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

        jLabel2.setText("Term:");

        jLabel3.setText("Year:");

        txtterm.setEditable(true);
        txtterm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));
        txtterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttermActionPerformed(evt);
            }
        });

        lblwarning.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lblwarning.setForeground(new java.awt.Color(255, 0, 0));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Lessons START");

        txtclass1.setBackground(new java.awt.Color(51, 255, 51));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Lessons STOP");

        txtclass2.setBackground(new java.awt.Color(51, 255, 51));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Lessons DURATION");

        txtclass3.setBackground(new java.awt.Color(51, 255, 51));

        txtclass4.setBackground(new java.awt.Color(51, 255, 51));

        txtclass5.setBackground(new java.awt.Color(51, 255, 51));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("First Break");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Second Break");

        txtclass6.setBackground(new java.awt.Color(51, 255, 51));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Third Break");

        btnschooltimetable.setBackground(new java.awt.Color(51, 51, 51));
        btnschooltimetable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnschooltimetable.setForeground(new java.awt.Color(51, 255, 0));
        btnschooltimetable.setText("Generate School TimeTable");
        btnschooltimetable.setToolTipText("");
        btnschooltimetable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnschooltimetableActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Fourth Break");

        txtclass7.setBackground(new java.awt.Color(51, 255, 51));

        txtclass8.setBackground(new java.awt.Color(51, 255, 51));

        txtclass9.setBackground(new java.awt.Color(51, 255, 51));

        txtclass10.setBackground(new java.awt.Color(51, 255, 51));

        txtclass11.setBackground(new java.awt.Color(51, 255, 51));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Lessons per DAY");

        txtlessons.setBackground(new java.awt.Color(51, 255, 51));
        txtlessons.setText("10");
        txtlessons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlessonsActionPerformed(evt);
            }
        });

        lblinformation.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lblinformation.setText("Break information may be inserted later at your own convinence");

        lblstart.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblstart.setText("Start:");

        lblstop.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblstop.setText("Stop:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("DAYS");

        txtdays.setBackground(new java.awt.Color(51, 255, 51));
        txtdays.setText("5");

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
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addComponent(lblinformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtterm, 0, 136, Short.MAX_VALUE)
                            .addComponent(txtyear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnschooltimetable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnexit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtdays, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtlessons, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblwarning, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlloginLayout.createSequentialGroup()
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlloginLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnlloginLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtclass4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlloginLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtclass6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlloginLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtclass7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlloginLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblstart, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtclass5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtclass8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtclass9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtclass10, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtclass11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblstop, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlloginLayout.createSequentialGroup()
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtclass2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtclass1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(txtclass3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        pnlloginLayout.setVerticalGroup(
            pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlloginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblusername2)
                .addGap(7, 7, 7)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnschooltimetable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblwarning, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlessons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtclass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtclass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlloginLayout.createSequentialGroup()
                        .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtclass3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addComponent(lblinformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblstart, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblstop, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclass5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclass8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtclass4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclass9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtclass6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtclass10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtclass7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtclass11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnllogin, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnschooltimetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnschooltimetableActionPerformed

        // TODO add your handling code here:
             blocktable(Integer.parseInt(txtlessons.getText()),Integer.parseInt(txtdays.getText()));
  
    }//GEN-LAST:event_btnschooltimetableActionPerformed

    private void txtlessonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlessonsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlessonsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jgoodies.looks.plastic.theme.BrownSugar brownSugar1;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnschooltimetable;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblinformation;
    private javax.swing.JLabel lblstart;
    private javax.swing.JLabel lblstop;
    private javax.swing.JLabel lblusername2;
    private javax.swing.JLabel lblwarning;
    private javax.swing.JPanel pnllogin;
    private javax.swing.JTextField txtclass1;
    private javax.swing.JTextField txtclass10;
    private javax.swing.JTextField txtclass11;
    private javax.swing.JTextField txtclass2;
    private javax.swing.JTextField txtclass3;
    private javax.swing.JTextField txtclass4;
    private javax.swing.JTextField txtclass5;
    private javax.swing.JTextField txtclass6;
    private javax.swing.JTextField txtclass7;
    private javax.swing.JTextField txtclass8;
    private javax.swing.JTextField txtclass9;
    private javax.swing.JTextField txtdays;
    private javax.swing.JTextField txtlessons;
    private javax.swing.JComboBox txtterm;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
