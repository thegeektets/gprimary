
package g_administrator_windows;

import java.awt.Color;
import java.awt.Desktop;
import java.beans.PropertyVetoException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Griffin M.
 */
public class main extends javax.swing.JFrame {
      public String dbhostip = null;
    public String dbpassword = null;
    public String database = null;
    public String dbusername = null;
 
    public main() {
        
        initComponents();
       
        readcred();
        orgdetails();
 
        colornavbuttons();
        hidesidebar();
        colorsidebuttons();
        disablenavbuttons();
        
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

        plasticMenuBarUI1 = new com.jgoodies.looks.plastic.PlasticMenuBarUI();
        popmsgs = new javax.swing.JPopupMenu();
        composemenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        readmenu = new javax.swing.JMenuItem();
        desktopPane = new javax.swing.JDesktopPane();
        topbar = new javax.swing.JPanel();
        btnusers = new javax.swing.JButton();
        btnfile = new javax.swing.JButton();
        btndatabase = new javax.swing.JButton();
        btnabout = new javax.swing.JButton();
        btnschool = new javax.swing.JButton();
        pnlhead = new javax.swing.JPanel();
        lblorgname = new javax.swing.JLabel();
        lblorgaddress = new javax.swing.JLabel();
        btnhelp = new javax.swing.JButton();
        footerbar = new javax.swing.JPanel();
        lbluser = new javax.swing.JLabel();
        lblfooter = new javax.swing.JLabel();
        userbar = new javax.swing.JPanel();
        btnmessages = new javax.swing.JButton();
        lypmenus = new javax.swing.JLayeredPane();
        pnlfile = new javax.swing.JPanel();
        btnlogout = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        pnldatabase = new javax.swing.JPanel();
        btnsetup = new javax.swing.JButton();
        btnbackup = new javax.swing.JButton();
        btnrestore = new javax.swing.JButton();
        pnlusers = new javax.swing.JPanel();
        btnaddnew = new javax.swing.JButton();
        btnsearchuser = new javax.swing.JButton();
        btnallusers = new javax.swing.JButton();
        btnblockuser = new javax.swing.JButton();
        btnonlineuser = new javax.swing.JButton();
        btnofflineuser = new javax.swing.JButton();
        pnlschool = new javax.swing.JPanel();
        btnsubjects = new javax.swing.JButton();
        btnteachers = new javax.swing.JButton();
        btncallocation = new javax.swing.JButton();
        btntimetable = new javax.swing.JButton();
        btnfeesreports = new javax.swing.JButton();
        btnfeesstatement = new javax.swing.JButton();
        btnfeesstructure = new javax.swing.JButton();
        btngraduate = new javax.swing.JButton();

        popmsgs.setInheritsPopupMenu(true);

        composemenu.setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
        composemenu.setText("Compose Message");
        composemenu.setInheritsPopupMenu(true);
        composemenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composemenuActionPerformed(evt);
            }
        });
        popmsgs.add(composemenu);
        popmsgs.add(jSeparator1);

        readmenu.setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
        readmenu.setText("Read Messages");
        readmenu.setToolTipText("");
        readmenu.setInheritsPopupMenu(true);
        readmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readmenuActionPerformed(evt);
            }
        });
        popmsgs.add(readmenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("G_Administrator_Panel");
        setFont(new java.awt.Font("FreeSerif", 0, 18)); // NOI18N
        setForeground(java.awt.Color.lightGray);
        setName("admin_frame"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        desktopPane.setBackground(new java.awt.Color(51, 51, 51));
        desktopPane.setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
        desktopPane.setMaximumSize(new java.awt.Dimension(65, 25));
        desktopPane.setMinimumSize(new java.awt.Dimension(65, 25));

        topbar.setOpaque(false);

        btnusers.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnusers.setText("Users");
        btnusers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusersActionPerformed(evt);
            }
        });

        btnfile.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnfile.setText("File");
        btnfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfileActionPerformed(evt);
            }
        });

        btndatabase.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btndatabase.setText("Database");
        btndatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatabaseActionPerformed(evt);
            }
        });

        btnabout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnabout.setText("About");
        btnabout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaboutActionPerformed(evt);
            }
        });

        btnschool.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnschool.setText("School");
        btnschool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnschoolActionPerformed(evt);
            }
        });

        lblorgname.setFont(new java.awt.Font("BatangChe", 3, 14)); // NOI18N
        lblorgname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblorgname.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblorgaddress.setFont(new java.awt.Font("BatangChe", 3, 14)); // NOI18N
        lblorgaddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblorgaddress.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout pnlheadLayout = new javax.swing.GroupLayout(pnlhead);
        pnlhead.setLayout(pnlheadLayout);
        pnlheadLayout.setHorizontalGroup(
            pnlheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlheadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblorgname, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlheadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblorgaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        pnlheadLayout.setVerticalGroup(
            pnlheadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlheadLayout.createSequentialGroup()
                .addComponent(lblorgname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblorgaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnhelp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnhelp.setText("Help");
        btnhelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topbarLayout = new javax.swing.GroupLayout(topbar);
        topbar.setLayout(topbarLayout);
        topbarLayout.setHorizontalGroup(
            topbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topbarLayout.createSequentialGroup()
                .addGroup(topbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topbarLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(pnlhead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(topbarLayout.createSequentialGroup()
                        .addComponent(btnfile, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnusers, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnschool, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhelp, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnabout, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        topbarLayout.setVerticalGroup(
            topbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topbarLayout.createSequentialGroup()
                .addComponent(pnlhead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(topbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndatabase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnusers)
                    .addComponent(btnschool, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnabout)
                    .addComponent(btnhelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        topbar.setBounds(0, 0, 880, 100);
        desktopPane.add(topbar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        footerbar.setOpaque(false);

        lbluser.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lbluser.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblfooter.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblfooter.setForeground(new java.awt.Color(102, 0, 102));
        lblfooter.setText("G Ultimate Developers:2013-All Rights Reserved.");

        javax.swing.GroupLayout footerbarLayout = new javax.swing.GroupLayout(footerbar);
        footerbar.setLayout(footerbarLayout);
        footerbarLayout.setHorizontalGroup(
            footerbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerbarLayout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385))
            .addGroup(footerbarLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        footerbarLayout.setVerticalGroup(
            footerbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerbarLayout.createSequentialGroup()
                .addComponent(lblfooter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        footerbar.setBounds(170, 620, 710, 40);
        desktopPane.add(footerbar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        userbar.setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
        userbar.setOpaque(false);

        btnmessages.setBackground(new java.awt.Color(102, 0, 102));
        btnmessages.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnmessages.setText("Messages");
        btnmessages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmessagesMouseClicked(evt);
            }
        });
        btnmessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmessagesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userbarLayout = new javax.swing.GroupLayout(userbar);
        userbar.setLayout(userbarLayout);
        userbarLayout.setHorizontalGroup(
            userbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnmessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        userbarLayout.setVerticalGroup(
            userbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnmessages)
                .addContainerGap(494, Short.MAX_VALUE))
        );

        userbar.setBounds(780, 110, 90, 530);
        desktopPane.add(userbar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnlfile.setOpaque(false);
        pnlfile.setPreferredSize(new java.awt.Dimension(110, 90));

        btnlogout.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnlogout.setText("Logout");
        btnlogout.setToolTipText("");
        btnlogout.setMaximumSize(new java.awt.Dimension(65, 25));
        btnlogout.setMinimumSize(new java.awt.Dimension(65, 25));
        btnlogout.setPreferredSize(new java.awt.Dimension(65, 25));
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        btnexit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnexit.setText("Exit");
        btnexit.setMaximumSize(new java.awt.Dimension(65, 25));
        btnexit.setMinimumSize(new java.awt.Dimension(65, 25));
        btnexit.setPreferredSize(new java.awt.Dimension(65, 25));
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlfileLayout = new javax.swing.GroupLayout(pnlfile);
        pnlfile.setLayout(pnlfileLayout);
        pnlfileLayout.setHorizontalGroup(
            pnlfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlfileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlfileLayout.setVerticalGroup(
            pnlfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlfile.setBounds(0, 240, 110, 70);
        lypmenus.add(pnlfile, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnldatabase.setFont(new java.awt.Font("FreeSerif", 1, 14)); // NOI18N
        pnldatabase.setOpaque(false);

        btnsetup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsetup.setText("Setup");
        btnsetup.setMaximumSize(new java.awt.Dimension(65, 25));
        btnsetup.setMinimumSize(new java.awt.Dimension(65, 25));
        btnsetup.setPreferredSize(new java.awt.Dimension(65, 25));
        btnsetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsetupActionPerformed(evt);
            }
        });

        btnbackup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnbackup.setText("Backup");
        btnbackup.setMaximumSize(new java.awt.Dimension(65, 25));
        btnbackup.setMinimumSize(new java.awt.Dimension(65, 25));
        btnbackup.setPreferredSize(new java.awt.Dimension(65, 25));
        btnbackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackupActionPerformed(evt);
            }
        });

        btnrestore.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnrestore.setText("Restore");
        btnrestore.setMaximumSize(new java.awt.Dimension(65, 25));
        btnrestore.setMinimumSize(new java.awt.Dimension(65, 25));
        btnrestore.setPreferredSize(new java.awt.Dimension(65, 25));
        btnrestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrestoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnldatabaseLayout = new javax.swing.GroupLayout(pnldatabase);
        pnldatabase.setLayout(pnldatabaseLayout);
        pnldatabaseLayout.setHorizontalGroup(
            pnldatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldatabaseLayout.createSequentialGroup()
                .addGroup(pnldatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnsetup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(btnbackup, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnrestore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnldatabaseLayout.setVerticalGroup(
            pnldatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldatabaseLayout.createSequentialGroup()
                .addComponent(btnsetup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnbackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnrestore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pnldatabase.setBounds(0, 310, 110, 90);
        lypmenus.add(pnldatabase, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnlusers.setMaximumSize(new java.awt.Dimension(65, 25));
        pnlusers.setMinimumSize(new java.awt.Dimension(65, 25));
        pnlusers.setOpaque(false);
        pnlusers.setPreferredSize(new java.awt.Dimension(65, 25));

        btnaddnew.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnaddnew.setText("Add New");
        btnaddnew.setMaximumSize(new java.awt.Dimension(65, 25));
        btnaddnew.setMinimumSize(new java.awt.Dimension(65, 25));
        btnaddnew.setPreferredSize(new java.awt.Dimension(65, 25));
        btnaddnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddnewActionPerformed(evt);
            }
        });

        btnsearchuser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsearchuser.setText("Search ");
        btnsearchuser.setMaximumSize(new java.awt.Dimension(65, 25));
        btnsearchuser.setMinimumSize(new java.awt.Dimension(65, 25));
        btnsearchuser.setPreferredSize(new java.awt.Dimension(65, 25));
        btnsearchuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchuserActionPerformed(evt);
            }
        });

        btnallusers.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnallusers.setText("All Users");
        btnallusers.setMaximumSize(new java.awt.Dimension(65, 25));
        btnallusers.setMinimumSize(new java.awt.Dimension(65, 25));
        btnallusers.setPreferredSize(new java.awt.Dimension(65, 25));
        btnallusers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnallusersActionPerformed(evt);
            }
        });

        btnblockuser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnblockuser.setText("Block User");
        btnblockuser.setMaximumSize(new java.awt.Dimension(65, 25));
        btnblockuser.setMinimumSize(new java.awt.Dimension(65, 25));
        btnblockuser.setPreferredSize(new java.awt.Dimension(65, 25));
        btnblockuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnblockuserActionPerformed(evt);
            }
        });

        btnonlineuser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnonlineuser.setText("Online");
        btnonlineuser.setMaximumSize(new java.awt.Dimension(65, 25));
        btnonlineuser.setMinimumSize(new java.awt.Dimension(65, 25));
        btnonlineuser.setPreferredSize(new java.awt.Dimension(65, 25));
        btnonlineuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnonlineuserActionPerformed(evt);
            }
        });

        btnofflineuser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnofflineuser.setText("Offline ");
        btnofflineuser.setMaximumSize(new java.awt.Dimension(65, 25));
        btnofflineuser.setMinimumSize(new java.awt.Dimension(65, 25));
        btnofflineuser.setPreferredSize(new java.awt.Dimension(65, 25));
        btnofflineuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnofflineuserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlusersLayout = new javax.swing.GroupLayout(pnlusers);
        pnlusers.setLayout(pnlusersLayout);
        pnlusersLayout.setHorizontalGroup(
            pnlusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlusersLayout.createSequentialGroup()
                .addGroup(pnlusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnaddnew, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearchuser, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnallusers, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnblockuser, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnonlineuser, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnofflineuser, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        pnlusersLayout.setVerticalGroup(
            pnlusersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlusersLayout.createSequentialGroup()
                .addComponent(btnaddnew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsearchuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnallusers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnblockuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnonlineuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnofflineuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pnlusers.setBounds(0, 400, 110, 190);
        lypmenus.add(pnlusers, javax.swing.JLayeredPane.DEFAULT_LAYER);

        pnlschool.setOpaque(false);

        btnsubjects.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnsubjects.setText("Subjects");
        btnsubjects.setToolTipText("");
        btnsubjects.setMaximumSize(new java.awt.Dimension(65, 25));
        btnsubjects.setMinimumSize(new java.awt.Dimension(65, 25));
        btnsubjects.setPreferredSize(new java.awt.Dimension(65, 25));
        btnsubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubjectsActionPerformed(evt);
            }
        });

        btnteachers.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnteachers.setText("Teachers");
        btnteachers.setToolTipText("");
        btnteachers.setMaximumSize(new java.awt.Dimension(65, 25));
        btnteachers.setMinimumSize(new java.awt.Dimension(65, 25));
        btnteachers.setPreferredSize(new java.awt.Dimension(65, 25));
        btnteachers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnteachersActionPerformed(evt);
            }
        });

        btncallocation.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btncallocation.setText("Class Allocation");
        btncallocation.setToolTipText("");
        btncallocation.setMaximumSize(new java.awt.Dimension(65, 25));
        btncallocation.setMinimumSize(new java.awt.Dimension(65, 25));
        btncallocation.setPreferredSize(new java.awt.Dimension(65, 25));
        btncallocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncallocationActionPerformed(evt);
            }
        });

        btntimetable.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btntimetable.setText("Time Table");
        btntimetable.setMaximumSize(new java.awt.Dimension(65, 25));
        btntimetable.setMinimumSize(new java.awt.Dimension(65, 25));
        btntimetable.setPreferredSize(new java.awt.Dimension(65, 25));
        btntimetable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimetableActionPerformed(evt);
            }
        });

        btnfeesreports.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btnfeesreports.setText("Fees Reports");
        btnfeesreports.setMaximumSize(new java.awt.Dimension(65, 25));
        btnfeesreports.setMinimumSize(new java.awt.Dimension(65, 25));
        btnfeesreports.setPreferredSize(new java.awt.Dimension(65, 25));
        btnfeesreports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfeesreportsActionPerformed(evt);
            }
        });

        btnfeesstatement.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btnfeesstatement.setText("Fees Statements");
        btnfeesstatement.setMaximumSize(new java.awt.Dimension(65, 25));
        btnfeesstatement.setMinimumSize(new java.awt.Dimension(65, 25));
        btnfeesstatement.setPreferredSize(new java.awt.Dimension(65, 25));
        btnfeesstatement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfeesstatementActionPerformed(evt);
            }
        });

        btnfeesstructure.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btnfeesstructure.setText("Fees Structure");
        btnfeesstructure.setMaximumSize(new java.awt.Dimension(65, 25));
        btnfeesstructure.setMinimumSize(new java.awt.Dimension(65, 25));
        btnfeesstructure.setPreferredSize(new java.awt.Dimension(65, 25));
        btnfeesstructure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfeesstructureActionPerformed(evt);
            }
        });

        btngraduate.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        btngraduate.setText("Graduation ");
        btngraduate.setToolTipText("");
        btngraduate.setMaximumSize(new java.awt.Dimension(65, 25));
        btngraduate.setMinimumSize(new java.awt.Dimension(65, 25));
        btngraduate.setPreferredSize(new java.awt.Dimension(65, 25));
        btngraduate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngraduateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlschoolLayout = new javax.swing.GroupLayout(pnlschool);
        pnlschool.setLayout(pnlschoolLayout);
        pnlschoolLayout.setHorizontalGroup(
            pnlschoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlschoolLayout.createSequentialGroup()
                .addGroup(pnlschoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlschoolLayout.createSequentialGroup()
                        .addComponent(btnsubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlschoolLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlschoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlschoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnfeesstructure, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnfeesstatement, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnfeesreports, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btntimetable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncallocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnteachers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btngraduate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlschoolLayout.setVerticalGroup(
            pnlschoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlschoolLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btngraduate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnteachers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncallocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btntimetable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnfeesstructure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnfeesstatement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnfeesreports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlschool.setBounds(0, -10, 110, 260);
        lypmenus.add(pnlschool, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lypmenus.setBounds(0, 110, 110, 540);
        desktopPane.add(lypmenus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //this function gives the navigation buttons the awesome greenish color
    public void disablenavbuttons(){
        btnfile.setEnabled(false);
        btnusers.setEnabled(false);
        btnschool.setEnabled(false);
        btndatabase.setEnabled(false);
        btnabout.setEnabled(false);
        btnhelp.setEnabled(false);
        btnmessages.setEnabled(false);
          }
    public static void enablenavbuttons(){
         btnusers.setEnabled(true);
        btndatabase.setEnabled(true);
        btnhelp.setEnabled(true);
        btnmessages.setEnabled(true);    
    }
            
 
    public void colornavbuttons(){
        btndatabase.setForeground(Color.black);
        btndatabase.setBackground(Color.getHSBColor( 238,238,238));
        btnfile.setForeground(Color.black);
        btnfile.setBackground(Color.getHSBColor( 238,238,238));
        btnabout.setForeground(Color.black);
        btnabout.setBackground(Color.getHSBColor( 238,238,238));
        btnschool.setForeground(Color.black);
        btnschool.setBackground(Color.getHSBColor( 238,238,238));
        btnhelp.setForeground(Color.black);
        btnhelp.setBackground(Color.getHSBColor( 238,238,238));
        btnusers.setForeground(Color.black);
        btnusers.setBackground(Color.getHSBColor( 238,238,238));
     
    }
    //all the side bar buttons are colored by this function
    public void colorsidebuttons(){
         btnlogout.setForeground(Color.black);
        btnlogout.setBackground(Color.getHSBColor( 238,238,238));
        btnexit.setForeground(Color.black);
        btnexit.setBackground(Color.getHSBColor( 238,238,238));
        btnbackup.setForeground(Color.black);
        btnbackup.setBackground(Color.getHSBColor( 238,238,238));
        btnrestore.setForeground(Color.black);
        btnrestore.setBackground(Color.getHSBColor( 238,238,238));
        btnsetup.setForeground(Color.black);
        btnsetup.setBackground(Color.getHSBColor( 238,238,238));
        btnonlineuser.setForeground(Color.black);
        btnonlineuser.setBackground(Color.getHSBColor( 238,238,238));
        btnofflineuser.setForeground(Color.black);
        btnofflineuser.setBackground(Color.getHSBColor( 238,238,238));
        btnaddnew.setForeground(Color.black);
        btnaddnew.setBackground(Color.getHSBColor( 238,238,238));
        btnallusers.setForeground(Color.black);
        btnallusers.setBackground(Color.getHSBColor( 238,238,238));
        btnblockuser.setForeground(Color.black);
        btnblockuser.setBackground(Color.getHSBColor( 238,238,238));
        btnsearchuser.setForeground(Color.black);
        btnsearchuser.setBackground(Color.getHSBColor( 238,238,238));
        btntimetable.setForeground(Color.black);
        btntimetable.setBackground(Color.getHSBColor( 238,238,238));
        btngraduate.setForeground(Color.black);
        btngraduate.setBackground(Color.getHSBColor( 238,238,238));
        btnteachers.setForeground(Color.black);
        btnteachers.setBackground(Color.getHSBColor( 238,238,238));
         btnsubjects.setForeground(Color.black);
        btnsubjects.setBackground(Color.getHSBColor( 238,238,238));
         btncallocation.setForeground(Color.black);
        btncallocation.setBackground(Color.getHSBColor( 238,238,238));
        btnfeesstructure.setForeground(Color.black);
        btnfeesstructure.setBackground(Color.getHSBColor( 238,238,238));
        btnfeesreports.setForeground(Color.black);
        btnfeesreports.setBackground(Color.getHSBColor( 238,238,238));
        btnfeesstatement.setForeground(Color.black);
        btnfeesstatement.setBackground(Color.getHSBColor( 238,238,238));
       
       
        
        
    }
    //hides the side panels on startup
    public void hidesidebar(){
        pnlfile.setVisible(false);
        pnldatabase.setVisible(false);
        pnlusers.setVisible(false);
        pnlschool.setVisible(false);
    }
    //gives the active nav button the awesome black green
    public  void activenavbutton(JButton b){
        colornavbuttons();
         b.setForeground(Color.green);
         b.setBackground(Color.black);
    }
    //gives the active side button the awesome black green
    public  void activesidebutton(JButton b){
        colorsidebuttons();
        if(b!=null){
         b.setForeground(Color.green);
         b.setBackground(Color.black);
        }
    }    
    //hides all the panels and displays the active one
    public void activepanel(JPanel p){
        hidesidebar();
        if(p!=null){
        p.setVisible(true);
        p.setBounds(0, 0, 110, 300);
        }
    }
    public void login(){
              login lg=new login();
           desktopPane.add(lg);
           int h=lg.getHeight();
           int w=lg.getWidth();
           lg.setBounds(230, 200, w, h);
           lg.setVisible(true);
    }
    public static void load(){
        welcome wl=new welcome();
                 main.desktopPane.add(wl);
        int h=wl.getHeight();
        int w=wl.getWidth();
        wl.setBounds(230, 150, w, h);
        wl.setVisible(true);
      
    }
    public void orgdetails(){
          try {
              Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                    String user = dbusername;
                    String pass= dbpassword;
     Connection con = DriverManager.getConnection(host, user, pass);
     con.setAutoCommit(false);
     Statement st=con.createStatement();
     String sql="select * from organisation";
     ResultSet rs=st.executeQuery(sql);
     rs.next();
     lblorgname.setText(rs.getString("organisationname"));
     lblorgaddress.setText(rs.getString("organisationaddress"));
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          }
        
       
        
    }
    
    private void btnusersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusersActionPerformed
        // TODO add your handling code here:
        activesidebutton(null);
        activenavbutton(btnusers);
        activepanel(pnlusers);
    }//GEN-LAST:event_btnusersActionPerformed

    private void btnfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfileActionPerformed
        // TODO add your handling code here:
       activesidebutton(null);
       activenavbutton(btnfile);
       activepanel(pnlfile);
     
    }//GEN-LAST:event_btnfileActionPerformed

    private void btndatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatabaseActionPerformed
        // TODO add your handling code here:
       activesidebutton(null);
       activenavbutton(btndatabase);
       activepanel(pnldatabase);    
    }//GEN-LAST:event_btndatabaseActionPerformed

    private void btnaboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaboutActionPerformed
        // TODO add your handling code here:
        activenavbutton(btnabout);
        activepanel(null);
           about ab=new about();
                 main.desktopPane.add(ab);
        int h=ab.getHeight();
        int w=ab.getWidth();
        ab.setBounds(150, 150, w, h);
        ab.setVisible(true);
        
    }//GEN-LAST:event_btnaboutActionPerformed

    private void btnschoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnschoolActionPerformed
        // TODO add your handling code here:
        activenavbutton(btnschool);
        activepanel(pnlschool);
    }//GEN-LAST:event_btnschoolActionPerformed

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        // TODO add your handling code here:
        activesidebutton(btnlogout);
          int c=JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to Logout?",null,0);
        if(c==0){
            JOptionPane.showMessageDialog(rootPane,"logging out..");
           
       
   
        } 
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
           activesidebutton(btnexit);
             int c=JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to Exit?",null,0);
        if(c==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnsetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsetupActionPerformed
        // TODO add your handling code here:
           activesidebutton(btnsetup);
             databasesetup dbs=new databasesetup();
           desktopPane.add(dbs);
           int h=dbs.getHeight();
           int w=dbs.getWidth();
           dbs.setBounds(230, 200, w, h);
           dbs.setVisible(true);
    }//GEN-LAST:event_btnsetupActionPerformed

    private void btnbackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackupActionPerformed
        // TODO add your handling code here:
           activesidebutton(btnbackup);
           backup dbs=new backup();
           desktopPane.add(dbs);
           int h=dbs.getHeight();
           int w=dbs.getWidth();
           dbs.setBounds(230, 200, w, h);
           dbs.setVisible(true);
           
    }//GEN-LAST:event_btnbackupActionPerformed

    private void btnrestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrestoreActionPerformed
        // TODO add your handling code here:
           activesidebutton(btnsetup);
           restore dbs=new restore();
           desktopPane.add(dbs);
           int h=dbs.getHeight();
           int w=dbs.getWidth();
           dbs.setBounds(230, 200, w, h);
           dbs.setVisible(true);

           
    }//GEN-LAST:event_btnrestoreActionPerformed

    private void btnaddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnewActionPerformed
        // TODO add your handling code here:
          activesidebutton(btnaddnew);
          newuser nw=new newuser();
           desktopPane.add(nw);
           int h=nw.getHeight();
           int w=nw.getWidth();
           nw.setBounds(230, 90, w, h);
           nw.setVisible(true);
    }//GEN-LAST:event_btnaddnewActionPerformed

    private void btnsearchuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchuserActionPerformed
        // TODO add your handling code here:
          activesidebutton(btnsearchuser);
           searchuser nw=new searchuser();
           desktopPane.add(nw);
           int h=nw.getHeight();
           int w=nw.getWidth();
           nw.setBounds(230, 110, w, h);
           nw.setVisible(true);
    }//GEN-LAST:event_btnsearchuserActionPerformed

    private void btnallusersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnallusersActionPerformed
        // TODO add your handling code here:
          activesidebutton(btnallusers);
          users nw=new users();
           desktopPane.add(nw);
           int h=nw.getHeight();
           int w=nw.getWidth();
           nw.setBounds(230, 110, w, h);
           nw.setVisible(true);
          
    }//GEN-LAST:event_btnallusersActionPerformed

    private void btnblockuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnblockuserActionPerformed
        // TODO add your handling code here:
          activesidebutton(btnblockuser);
           searchuser nw=new searchuser();
           desktopPane.add(nw);
           int h=nw.getHeight();
           int w=nw.getWidth();
           nw.setBounds(230, 110, w, h);
           nw.setVisible(true);
    }//GEN-LAST:event_btnblockuserActionPerformed

    private void btnonlineuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnonlineuserActionPerformed
        // TODO add your handling code here:
          activesidebutton(btnonlineuser);
           users nw=new users();
           desktopPane.add(nw);
           int h=nw.getHeight();
           int w=nw.getWidth();
           nw.setBounds(230, 110, w, h);
           nw.setVisible(true);
    }//GEN-LAST:event_btnonlineuserActionPerformed

    private void btnofflineuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnofflineuserActionPerformed
        // TODO add your handling code here:
        activesidebutton(btnofflineuser);
           users nw=new users();
           desktopPane.add(nw);
           int h=nw.getHeight();
           int w=nw.getWidth();
           nw.setBounds(230, 110, w, h);
           nw.setVisible(true);
    }//GEN-LAST:event_btnofflineuserActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here\
        
        login();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          try {
              // TODO add your handling code here:
                    Class.forName("com.mysql.jdbc.Driver");
                         String host = "jdbc:mysql://"+dbhostip+":3306/"+database;
                                 String user = dbusername;
                                 String pass= dbpassword;
                  Connection con = DriverManager.getConnection(host, user, pass);
              
                 PreparedStatement st = con.prepareStatement("UPDATE users SET status=? where username=?");
                    st.setString(1, "offline");
                    st.setString(2, lbluser.getText() );
                    st.executeUpdate();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_formWindowClosing

    private void btnmessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmessagesActionPerformed
        // TODO add your handling code here:
        
     
    }//GEN-LAST:event_btnmessagesActionPerformed

    private void btnmessagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmessagesMouseClicked
        // TODO add your handling code here:
        popmsgs.show(evt.getComponent(),evt.getX(),evt.getY());
    }//GEN-LAST:event_btnmessagesMouseClicked

    private void composemenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composemenuActionPerformed
        // TODO add your handling code here:
          compose cm=new compose();
                 main.desktopPane.add(cm);
        int h=cm.getHeight();
        int w=cm.getWidth();
        cm.setBounds(230, 150, w, h);
        cm.setVisible(true);
  
        
        
        
        
    }//GEN-LAST:event_composemenuActionPerformed

    private void readmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readmenuActionPerformed
        // TODO add your handling code here:
         read rp=new read();
                 main.desktopPane.add(rp);
        int h=rp.getHeight();
        int w=rp.getWidth();
        rp.setBounds(230, 150, w, h);
        rp.setVisible(true);
  
    }//GEN-LAST:event_readmenuActionPerformed

    private void btngraduateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngraduateActionPerformed
        // TODO add your handling code here:
         graduate gr=new graduate();
                 main.desktopPane.add(gr);
        int h=gr.getHeight();
        int w=gr.getWidth();
        gr.setBounds(230, 150, w, h);
        gr.setVisible(true);
  
    }//GEN-LAST:event_btngraduateActionPerformed

    private void btntimetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimetableActionPerformed
          try {
              // TODO add your handling code here:
                 activesidebutton(btntimetable);
                 timetable tt=new timetable();
                 desktopPane.add(tt);
                 int h=tt.getHeight();
                 int w=tt.getWidth();
                 tt.setBounds(170,90, w, h);
                 tt.setMaximum(true);
                 tt.setVisible(true);
          } catch (PropertyVetoException ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          }
   
    }//GEN-LAST:event_btntimetableActionPerformed

    private void btnteachersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnteachersActionPerformed
        // TODO add your handling code here:
         activesidebutton(btnteachers);
           teachers tr=new teachers();
           desktopPane.add(tr);
           int h=tr.getHeight();
           int w=tr.getWidth();
           tr.setBounds(230, 110, w, h);
           tr.setVisible(true);
    }//GEN-LAST:event_btnteachersActionPerformed

    private void btnsubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubjectsActionPerformed
        // TODO add your handling code here:
        activesidebutton(btnsubjects);
           subjects sb=new subjects();
           desktopPane.add(sb);
           int h=sb.getHeight();
           int w=sb.getWidth();
           sb.setBounds(230, 110, w, h);
           sb.setVisible(true);
    }//GEN-LAST:event_btnsubjectsActionPerformed

    private void btncallocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncallocationActionPerformed
        // TODO add your handling code here:\
           activesidebutton(btncallocation);
           allocation al =new allocation();
           desktopPane.add(al);
           int h=al.getHeight();
           int w=al.getWidth();
           al.setBounds(230, 110, w, h);
           al.setVisible(true);
    }//GEN-LAST:event_btncallocationActionPerformed

    private void btnhelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhelpActionPerformed
        // TODO add your handling code here:
                activenavbutton(btnhelp);
        activepanel(null);
        int c =-JOptionPane.showConfirmDialog(rootPane,"Open User Manual?");
        if(c==0){
                    // TODO add your handling code here:
          
    if (Desktop.isDesktopSupported()) {
   try {
         File input=new File("C://Program Files/usermanual.pdf");
          
            Desktop.getDesktop().open(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("NO PDF READER INSTALLED");
        }
}
  

        }
  
    }//GEN-LAST:event_btnhelpActionPerformed

    private void btnfeesreportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfeesreportsActionPerformed
        // TODO add your handling code here:
        activesidebutton(btnfeesreports);

        paymentreports pr =new paymentreports();
        desktopPane.add(pr);
        int h=pr.getHeight();
        int w=pr.getWidth();
        pr.setBounds(80,110, w, h);

        pr.setVisible(true);

    }//GEN-LAST:event_btnfeesreportsActionPerformed

    private void btnfeesstatementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfeesstatementActionPerformed
        // TODO add your handling code here:
        activesidebutton(btnfeesstatement);
        feesstatements tt=new feesstatements();
        desktopPane.add(tt);
        int h=tt.getHeight();
        int w=tt.getWidth();
        tt.setBounds(90,110, w, h);

        tt.setVisible(true);
    }//GEN-LAST:event_btnfeesstatementActionPerformed

    private void btnfeesstructureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfeesstructureActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        activesidebutton(btnfeesstructure);
        feesstructure tt=new feesstructure();
        desktopPane.add(tt);
        int h=tt.getHeight();
        int w=tt.getWidth();
        tt.setBounds(90,110, w, h);

        tt.setVisible(true);

    }//GEN-LAST:event_btnfeesstructureActionPerformed

    public static void reply(){
          compose cmr=new compose();
                 main.desktopPane.add(cmr);
        int h=cmr.getHeight();
        int w=cmr.getWidth();
        cmr.setBounds(210, 170, w, h);
        cmr.setVisible(true);
  
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
             try {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (    ClassNotFoundException e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}         catch (InstantiationException ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          } catch (UnsupportedLookAndFeelException ex) {
              Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
          }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnabout;
    private javax.swing.JButton btnaddnew;
    private javax.swing.JButton btnallusers;
    private javax.swing.JButton btnbackup;
    private javax.swing.JButton btnblockuser;
    private javax.swing.JButton btncallocation;
    public static javax.swing.JButton btndatabase;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnfeesreports;
    private javax.swing.JButton btnfeesstatement;
    private javax.swing.JButton btnfeesstructure;
    public static javax.swing.JButton btnfile;
    private javax.swing.JButton btngraduate;
    public static javax.swing.JButton btnhelp;
    private javax.swing.JButton btnlogout;
    public static javax.swing.JButton btnmessages;
    private javax.swing.JButton btnofflineuser;
    private javax.swing.JButton btnonlineuser;
    private javax.swing.JButton btnrestore;
    public static javax.swing.JButton btnschool;
    private javax.swing.JButton btnsearchuser;
    private javax.swing.JButton btnsetup;
    private javax.swing.JButton btnsubjects;
    private javax.swing.JButton btnteachers;
    private javax.swing.JButton btntimetable;
    public static javax.swing.JButton btnusers;
    private javax.swing.JMenuItem composemenu;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPanel footerbar;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lblorgaddress;
    private javax.swing.JLabel lblorgname;
    public static javax.swing.JLabel lbluser;
    private javax.swing.JLayeredPane lypmenus;
    private com.jgoodies.looks.plastic.PlasticMenuBarUI plasticMenuBarUI1;
    private javax.swing.JPanel pnldatabase;
    private javax.swing.JPanel pnlfile;
    public static javax.swing.JPanel pnlhead;
    private javax.swing.JPanel pnlschool;
    private javax.swing.JPanel pnlusers;
    private javax.swing.JPopupMenu popmsgs;
    private javax.swing.JMenuItem readmenu;
    private javax.swing.JPanel topbar;
    private javax.swing.JPanel userbar;
    // End of variables declaration//GEN-END:variables
}
