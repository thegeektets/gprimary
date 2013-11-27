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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author griffin
 */
public class G_PrimarySchoolManager_Client {

public static String dbusername="root";
public static String dbhostip;
public static String dbpassword;

public static String database;
public static String authetication=null;

public static void autheticator(){

        String fileName = "C:\\Program Files\\G Ultimate Developers\\authetication.txt";

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
         
                 if(login[0]!=null){
                authetication=login[0].trim();
                }
                
            } catch (FileNotFoundException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
             
    }
    
}
   public static String MD5(String md5) {
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
         catch(Exception ex) {
                firstwelcome main=new firstwelcome();
        main.setVisible(true);
  
        }
    }

    public static void main(String[] args) {
    try {
        try {
for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
if ("Nimbus".equals(info.getName())) {
  UIManager.setLookAndFeel(info.getClassName());
  break;
}
}
} catch (    ClassNotFoundException  e) {
   
}       catch (InstantiationException ex) {
  Logger.getLogger(G_PrimarySchoolManager_Client.class.getName()).log(Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
  Logger.getLogger(G_PrimarySchoolManager_Client.class.getName()).log(Level.SEVERE, null, ex);
} catch (UnsupportedLookAndFeelException ex) {
  Logger.getLogger(G_PrimarySchoolManager_Client.class.getName()).log(Level.SEVERE, null, ex);
}
dblogincred();
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                    String user = "root";
                    String pass= dbpassword;
Connection con = DriverManager.getConnection(host, user, pass);
     autheticator();
            Statement stmntt = con.createStatement();
                      String sqlt = "Select * from organisation";
                      ResultSet rst = stmntt.executeQuery(sqlt);
           if(rst.next()){
               String org=rst.getString("organisationname");
               String orgkey=MD5(org+"TRFG5M53");
               System.out.println(org);
               System.out.println(orgkey);
               System.out.println(authetication);
               
               if(orgkey.equals(authetication)){
  

login main=new login();
main.setVisible(true);
 }
                   else{
   JOptionPane.showMessageDialog(null,"Sorry autheticity of software cannot be determined exiting");
   System.exit(0);
         }}
  
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(G_PrimarySchoolManager_Client.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
           Logger.getLogger(G_PrimarySchoolManager_Client.class.getName()).log(Level.SEVERE, null, ex);
      JOptionPane.showMessageDialog(null,"Error"+ex.getMessage());
                firstwelcome main=new firstwelcome();
        main.setVisible(true);
  
    
    }
    }
}
