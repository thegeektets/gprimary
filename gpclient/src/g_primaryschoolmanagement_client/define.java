package g_primaryschoolmanagement_client;

import static g_primaryschoolmanagement_client.G_PrimarySchoolManager_Client.database;
import static g_primaryschoolmanagement_client.G_PrimarySchoolManager_Client.dbhostip;
import static g_primaryschoolmanagement_client.G_PrimarySchoolManager_Client.dbpassword;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;

public class define extends JInternalFrame
{
   private JLabel jLabel1;
  private JLabel jLabel3;
  private JLabel lblflatname5;
  private JLabel lblflatname6;
  private JLabel lblflatname7;
  private JTextField txtname;
  private JTextField txtright;
  private JTextField txtuser;
 

  public define()
  {
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
                 firstwelcome main=new firstwelcome();
        main.setVisible(true);
  
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");					
            
        }
         
    }
  private void initComponents()
  {
    this.txtname = new JTextField();
    this.jLabel3 = new JLabel();
    this.lblflatname5 = new JLabel();
    this.jLabel1 = new JLabel();
    this.txtuser = new JTextField();
    this.lblflatname6 = new JLabel();
    this.txtright = new JTextField();
    this.lblflatname7 = new JLabel();

    this.txtname.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        define.this.txtnameActionPerformed(evt);
      }
    });
    this.jLabel3.setFont(new Font("Traditional Arabic", 1, 18));
    this.jLabel3.setIcon(new ImageIcon(getClass().getResource("1372271021_accepted_48.png")));
    this.jLabel3.setText("Okay");
    this.jLabel3.setBorder(BorderFactory.createBevelBorder(0, Color.green, null, Color.green, Color.green));
    this.jLabel3.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        define.this.jLabel3MouseClicked(evt);
      }
    });
    this.lblflatname5.setFont(new Font("Traditional Arabic", 0, 18));
    this.lblflatname5.setText("User Name");
    this.lblflatname5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    this.jLabel1.setFont(new Font("Traditional Arabic", 1, 18));
    this.jLabel1.setIcon(new ImageIcon(getClass().getResource("1372431837_exit.png")));
    this.jLabel1.setText("Exit");
    this.jLabel1.setBorder(BorderFactory.createBevelBorder(0, Color.darkGray, null, Color.darkGray, new Color(51, 51, 51)));
    this.jLabel1.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        define.this.jLabel1MouseClicked(evt);
      }
    });
    this.txtuser.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        define.this.txtuserActionPerformed(evt);
      }
    });
    this.lblflatname6.setFont(new Font("Traditional Arabic", 0, 18));
    this.lblflatname6.setText("Full Name");
    this.lblflatname6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    this.txtright.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        define.this.txtrightActionPerformed(evt);
      }
    });
    this.lblflatname7.setFont(new Font("Traditional Arabic", 0, 18));
    this.lblflatname7.setText("Privilidges");
    this.lblflatname7.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblflatname7, -2, 122, -2).addComponent(this.lblflatname5, -2, 122, -2).addComponent(this.lblflatname6, -2, 122, -2)).addGap(55, 55, 55).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtuser, -2, 228, -2).addComponent(this.txtright, -2, 228, -2).addComponent(this.txtname, -2, 228, -2)).addGap(117, 117, 117)).addGroup(layout.createSequentialGroup().addGap(56, 56, 56).addComponent(this.jLabel3, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 186, 32767).addComponent(this.jLabel1, -2, 113, -2).addGap(55, 55, 55)));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblflatname5, -2, 22, -2).addComponent(this.txtuser, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblflatname6, -2, 22, -2).addComponent(this.txtname, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblflatname7, -2, 22, -2).addComponent(this.txtright, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3, -2, 65, -2).addComponent(this.jLabel1, -2, 65, -2)).addContainerGap(15, 32767)));

    pack();
  }

  private void txtnameActionPerformed(ActionEvent evt)
  {
  }
  public String MD5(String md5) {
   try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
}
  private void jLabel3MouseClicked(MouseEvent evt) {
    try {
      String name = this.txtname.getText();
      String cred = this.txtright.getText();
      String user = this.txtuser.getText();
      String dflt = "1234";
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
      PreparedStatement s = con.prepareStatement("INSERT INTO user values(?,?,?,?,?)");
      s.setString(1, user);
      s.setString(2, MD5(dflt));
      s.setString(3, cred);
      s.setString(4, name);
      s.setString(5, null);

      s.executeUpdate();
      JOptionPane.showMessageDialog(rootPane, user + " Has been registered as a new user and assinged a default password 1234");
    }
    catch (ClassNotFoundException ex) {
      Logger.getLogger(define.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(rootPane, "User can not be registered because"+ex.getMessage());
    }
  }

  private void jLabel1MouseClicked(MouseEvent evt)
  {
     dispose();
  }

  private void txtuserActionPerformed(ActionEvent evt)
  {
  }

  private void txtrightActionPerformed(ActionEvent evt)
  {
  }
}
