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
public class G_Administrator {
      public static String dbhostip=null;
public static String dbpassword=null;

public static String database =null;
public  static String dbusername=null;
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
    public static void readcred(){

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
           firstwelcome fw= new firstwelcome();
             fw.setVisible(true);
      
    } catch (IOException ex) {
        Logger.getLogger(dbsetup.class.getName()).log(Level.SEVERE, null, ex);
           firstwelcome fw= new firstwelcome();
             fw.setVisible(true);
      
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
     
    public static void main(String[] args) {
                  try {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (    ClassNotFoundException  e) {
   
}         catch (InstantiationException ex) {        
              Logger.getLogger(G_Administrator.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              Logger.getLogger(G_Administrator.class.getName()).log(Level.SEVERE, null, ex);
          } catch (UnsupportedLookAndFeelException ex) {
              Logger.getLogger(G_Administrator.class.getName()).log(Level.SEVERE, null, ex);
          }        
           try{
          readcred();
          autheticator();
                Class.forName("com.mysql.jdbc.Driver");
                      Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database,dbusername, dbpassword);
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
  main main=new main();
main.setVisible(true);
 }
                   else{
   JOptionPane.showMessageDialog(null,"Sorry autheticity of software cannot be determined exiting");
   System.exit(0);
         }
           } 
           else{
             firstwelcome fw= new firstwelcome();
             fw.setVisible(true);
         }
             
          
         } catch (ClassNotFoundException ex) {
              Logger.getLogger(G_Administrator.class.getName()).log(Level.SEVERE, null, ex);
              
          } catch (SQLException ex) {
              Logger.getLogger(G_Administrator.class.getName()).log(Level.SEVERE, null, ex);
              firstwelcome fw= new firstwelcome();
             fw.setVisible(true);
         
          }
         }
}
