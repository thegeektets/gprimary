
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * student.java
 *
 * Created on Jun 9, 2013, 1:38:14 PM
 */
package g_primaryschoolmanagement_client;

import static g_primaryschoolmanagement_client.search.database;
import static g_primaryschoolmanagement_client.search.dbhostip;
import static g_primaryschoolmanagement_client.search.dbpassword;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author griffin
 */
public class exams extends javax.swing.JInternalFrame {
    /** Creates new form student */
    public exams() {
        dblogincred();
       
        initComponents();
        colorunimportant();
        try {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldetails = new javax.swing.JLabel();
        pnlmain = new javax.swing.JPanel();
        pnlprsnldetails = new javax.swing.JPanel();
        lblparentid = new javax.swing.JLabel();
        lblfullname = new javax.swing.JLabel();
        lblogender = new javax.swing.JLabel();
        lblphone = new javax.swing.JLabel();
        txtyear = new javax.swing.JTextField();
        txtdate = new com.toedter.calendar.JDateChooser();
        txtclass = new javax.swing.JComboBox();
        txtstream = new javax.swing.JComboBox();
        pnlotherdetails = new javax.swing.JPanel();
        lblhome = new javax.swing.JLabel();
        txtentry = new javax.swing.JTextField();
        lblwork = new javax.swing.JLabel();
        txtenumber = new javax.swing.JTextField();
        lblemail = new javax.swing.JLabel();
        txtetype = new javax.swing.JComboBox();
        lblhome1 = new javax.swing.JLabel();
        txtterm = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblresults = new javax.swing.JTable();
        btnnewrecord = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        txtclass1 = new javax.swing.JComboBox();
        txtstream1 = new javax.swing.JComboBox();
        txtterm1 = new javax.swing.JComboBox();
        txtetype1 = new javax.swing.JComboBox();
        txtyear1 = new com.toedter.calendar.JYearChooser();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Exam Details Form");

        lbldetails.setBackground(new java.awt.Color(153, 255, 153));
        lbldetails.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbldetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldetails.setText("Exam Details and Results Data Entry Form");
        lbldetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        lbldetails.setName(""); // NOI18N
        lbldetails.setOpaque(true);

        pnlmain.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        pnlprsnldetails.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblparentid.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblparentid.setText("Examination Date");

        lblfullname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblfullname.setText(" Class");

        lblogender.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblogender.setText("Stream");

        lblphone.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblphone.setText("Year");

        txtyear.setBackground(new java.awt.Color(255, 255, 204));
        txtyear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtdate.setBackground(new java.awt.Color(255, 255, 204));
        txtdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtdateMouseClicked(evt);
            }
        });

        txtclass.setBackground(new java.awt.Color(255, 255, 204));
        txtclass.setEditable(true);
        txtclass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8" }));
        txtclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclassActionPerformed(evt);
            }
        });

        txtstream.setBackground(new java.awt.Color(255, 255, 204));
        txtstream.setEditable(true);
        txtstream.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "North", "South", "East", "West" }));
        txtstream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstreamActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnlprsnldetailsLayout = new org.jdesktop.layout.GroupLayout(pnlprsnldetails);
        pnlprsnldetails.setLayout(pnlprsnldetailsLayout);
        pnlprsnldetailsLayout.setHorizontalGroup(
            pnlprsnldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlprsnldetailsLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnlprsnldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(lblogender, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lblphone, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lblfullname, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, lblparentid, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlprsnldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtyear)
                    .add(txtdate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(txtclass, 0, 192, Short.MAX_VALUE)
                    .add(txtstream, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlprsnldetailsLayout.setVerticalGroup(
            pnlprsnldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlprsnldetailsLayout.createSequentialGroup()
                .add(pnlprsnldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(lblparentid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(7, 7, 7)
                .add(pnlprsnldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(lblfullname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlprsnldetailsLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(txtclass)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlprsnldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(lblogender, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlprsnldetailsLayout.createSequentialGroup()
                        .add(txtstream)
                        .add(4, 4, 4)))
                .add(5, 5, 5)
                .add(pnlprsnldetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblphone, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(txtyear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlotherdetails.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblhome.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblhome.setText("Examination Type");

        txtentry.setBackground(new java.awt.Color(255, 255, 204));
        txtentry.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblwork.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblwork.setText("Entry");

        txtenumber.setBackground(new java.awt.Color(255, 255, 204));
        txtenumber.setToolTipText("examtype-class-stream-term-year");
        txtenumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblemail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblemail.setText("Examination Number");

        txtetype.setBackground(new java.awt.Color(255, 255, 204));
        txtetype.setEditable(true);
        txtetype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Opener Exam", "Midterm Exam", "Endterm Exam" }));
        txtetype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtetypeActionPerformed(evt);
            }
        });

        lblhome1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblhome1.setText("Term");

        txtterm.setBackground(new java.awt.Color(255, 255, 204));
        txtterm.setEditable(true);
        txtterm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1", "2", "3" }));
        txtterm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttermActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pnlotherdetailsLayout = new org.jdesktop.layout.GroupLayout(pnlotherdetails);
        pnlotherdetails.setLayout(pnlotherdetailsLayout);
        pnlotherdetailsLayout.setHorizontalGroup(
            pnlotherdetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlotherdetailsLayout.createSequentialGroup()
                .add(pnlotherdetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblemail)
                    .add(lblwork, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblhome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblhome1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 122, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(pnlotherdetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtterm, 0, 215, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtetype, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtentry)
                    .add(txtenumber)))
        );
        pnlotherdetailsLayout.setVerticalGroup(
            pnlotherdetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlotherdetailsLayout.createSequentialGroup()
                .add(pnlotherdetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtterm, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblhome1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(8, 8, 8)
                .add(pnlotherdetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtetype, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblhome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(pnlotherdetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblwork, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlotherdetailsLayout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(txtentry, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlotherdetailsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblemail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlotherdetailsLayout.createSequentialGroup()
                        .add(1, 1, 1)
                        .add(txtenumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tblresults.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblresults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Examno", "Adm", "Maths", "Insha", "Lugha", "Kiswahili", "Composition", "Grammar", "English", "Science", "Religous Studies", "Social ", "Social Studies "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblresults.setCellSelectionEnabled(true);
        tblresults.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tblresults);

        org.jdesktop.layout.GroupLayout pnlmainLayout = new org.jdesktop.layout.GroupLayout(pnlmain);
        pnlmain.setLayout(pnlmainLayout);
        pnlmainLayout.setHorizontalGroup(
            pnlmainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlmainLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .add(pnlmainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlmainLayout.createSequentialGroup()
                        .add(pnlprsnldetails, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pnlotherdetails, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
        );
        pnlmainLayout.setVerticalGroup(
            pnlmainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlmainLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(pnlmainLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlprsnldetails, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlotherdetails, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 330, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(97, 97, 97))
        );

        btnnewrecord.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnnewrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g_primaryschoolmanagement_client/1372439035_save_edit.png"))); // NOI18N
        btnnewrecord.setText("Add New Record");
        btnnewrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewrecordActionPerformed(evt);
            }
        });

        btnsave.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g_primaryschoolmanagement_client/1372440201_Save.png"))); // NOI18N
        btnsave.setText("Save Record");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnedit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g_primaryschoolmanagement_client/1372440261_filesaveas.png"))); // NOI18N
        btnedit.setText("Edit Record");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        txtsearch.setEditable(false);
        txtsearch.setBackground(new java.awt.Color(255, 255, 204));
        txtsearch.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnsearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g_primaryschoolmanagement_client/1372438975_Search.png"))); // NOI18N
        btnsearch.setText("Find Exam");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        txtclass1.setBackground(new java.awt.Color(255, 255, 204));
        txtclass1.setEditable(true);
        txtclass1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8" }));
        txtclass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclass1ActionPerformed(evt);
            }
        });

        txtstream1.setBackground(new java.awt.Color(255, 255, 204));
        txtstream1.setEditable(true);
        txtstream1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "North", "South", "East", "West" }));

        txtterm1.setBackground(new java.awt.Color(255, 255, 204));
        txtterm1.setEditable(true);
        txtterm1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1", "2", "3" }));

        txtetype1.setBackground(new java.awt.Color(255, 255, 204));
        txtetype1.setEditable(true);
        txtetype1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Opener Exam", "Midterm Exam", "Endterm Exam" }));
        txtetype1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtetype1ActionPerformed(evt);
            }
        });

        txtyear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtyear1MouseEntered(evt);
            }
        });
        txtyear1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtyear1PropertyChange(evt);
            }
        });
        txtyear1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtyear1VetoableChange(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(pnlmain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(btnnewrecord, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(btnsave, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(btnedit, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(225, 225, 225)
                        .add(lbldetails, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 335, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(55, 55, 55)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(txtsearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 197, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(btnsearch, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(txtclass1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtstream1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(txtterm1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtetype1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtyear1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE)))))
                .add(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(93, 93, 93)
                        .add(btnnewrecord)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnsave)
                        .add(18, 18, 18)
                        .add(btnedit))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lbldetails, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                            .add(txtclass1)
                                            .add(txtstream1))
                                        .add(3, 3, 3))
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtterm1)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtyear1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, txtetype1))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(txtsearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(btnsearch))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pnlmain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 535, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public  String dbusername="root";
 public   String dbhostip;
 public   String dbpassword;
public   String database;  
    public  void dblogincred(){
    
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
      public void spop()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn =DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
      Statement S = conn.createStatement();
      String sql;
       if ((this.txtclass.getSelectedItem().toString().length() > 0) && ((this.txtstream.getSelectedItem().toString().length() > 0)))
      {
        sql = "Select studentnumber from student where cclass='" + Integer.parseInt((String)this.txtclass.getSelectedItem()) + "'and student.stream='" + this.txtstream.getSelectedItem() + "'";
      }
      else
      {
           if (this.txtclass.getSelectedItem().toString().length() > 0) {
          sql = "Select studentnumber from student where cclass='" + Integer.parseInt((String)this.txtclass.getSelectedItem()) + "'";
        }
        else
          sql = "Select studentnumber from student where stream='" + this.txtstream.getSelectedItem() + "'";
      }
      ResultSet rset = S.executeQuery(sql);
      int r = 0;
      try
      {
        while (rset.next())
        {
          int adm = rset.getInt("studentnumber");
       
          if (this.txtenumber.getText().length() > 0) {
            this.tblresults.setValueAt(this.txtenumber.getText(), r, 0);
            this.tblresults.setValueAt("" + adm, r, 1);
         
           
            r++;
          } else {
            JOptionPane.showMessageDialog(null, "please input an exam number before you can proceed");
          }
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Please ensure that you have input class and stream details correctly \n Because the ones selected above show no record of studens");
      }

    }
    catch (ClassNotFoundException ex)
    {
      Logger.getLogger(exams.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(exams.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
public void cleartable(){
   int r = 0;
        while (r<60)
        {
          this.tblresults.setValueAt("", r, 0);
          this.tblresults.setValueAt("", r, 1);
          this.tblresults.setValueAt("", r, 2);
          this.tblresults.setValueAt("", r, 3);
          this.tblresults.setValueAt("", r, 4);
          this.tblresults.setValueAt("", r, 5);
          this.tblresults.setValueAt("", r, 6);
          this.tblresults.setValueAt("", r, 7);
         this.tblresults.setValueAt("", r, 8);
         this.tblresults.setValueAt("", r, 9);
         this.tblresults.setValueAt("", r, 10);
         this.tblresults.setValueAt("", r, 11);
         this.tblresults.setValueAt("", r, 12);
         
              r++;
           }
  
}
public void colorunimportant(){
    
        this.tblresults.setColumnSelectionInterval(3, 4);
        this.tblresults.setSelectionBackground(Color.LIGHT_GRAY);
        this.tblresults.setColumnSelectionInterval(6, 7);
        this.tblresults.setSelectionBackground(Color.LIGHT_GRAY);
        this.tblresults.setColumnSelectionInterval(10, 11);
        this.tblresults.setSelectionBackground(Color.LIGHT_GRAY);
        
     
   
}

  public void populatetable(){
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
      Statement S = conn.createStatement();
      String sql = "Select *from score where examno=" + "'"+txtsearch.getText()+"'";
       System.out.println(""+txtsearch.getText());
      ResultSet rset = S.executeQuery(sql);
        int r = 0;
        while (rset.next())
        {
          this.tblresults.setValueAt(rset.getString("examno"), r, 0);
          this.tblresults.setValueAt(rset.getInt("admno"), r, 1);
          this.tblresults.setValueAt(rset.getInt("math"), r, 2);
          this.tblresults.setValueAt(rset.getInt("insha"), r, 3);
          this.tblresults.setValueAt(rset.getInt("lugha"), r, 4);
          this.tblresults.setValueAt(rset.getInt("kiswa"), r, 5);
          this.tblresults.setValueAt(rset.getInt("comp"), r, 6);
          this.tblresults.setValueAt(rset.getInt("grammer"), r, 7);
         this.tblresults.setValueAt(rset.getInt("eng"), r, 8);
         this.tblresults.setValueAt(rset.getInt("science"), r, 9);
         this.tblresults.setValueAt(rset.getInt("re"), r, 10);
         this.tblresults.setValueAt(rset.getInt("social"), r, 11);
         this.tblresults.setValueAt(rset.getInt("socialstudies"), r, 12);
         
         
              r++;
              System.out.println("******p");
        }

      
      
     

      rset.close();
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(exams.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(exams.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    
    
    public void validate(String nu)
  {
    try
    {
      int number = Integer.parseInt(nu);
      if ((number < 0) || (number > 100))
      {
     //   JOptionPane.showMessageDialog(null, "You have input a value " + nu + " which is an incorrect format");
      }
    } catch (Exception e) { //JOptionPane.showMessageDialog(null, "Value " + nu + " input is non numeric all value must be numeric"); 
    }
    
  }



     
  
    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        try{
        String examno = txtsearch.getText();

      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);

      Statement st = con.createStatement();

      String sql = "Select * from exam, score where score.examno=exam.examno and exam.examno = ?";

      PreparedStatement pstmnt = con.prepareStatement(sql);
      pstmnt.setString(1, examno);
      ResultSet rs = pstmnt.executeQuery();
      if(rs.next()){
        JOptionPane.showMessageDialog(rootPane, "Record Found");
        populatetable();
       this.txtyear.setText("" + rs.getInt("yearofadm"));
      this.txtentry.setText("" + rs.getInt("entry"));
        this.txtstream.setSelectedItem("" + rs.getString("stream"));
      this.txtclass.setSelectedItem("" + rs.getInt("cclass"));
      this.txtterm.setSelectedItem("" + rs.getInt("term"));
       this.txtetype.setSelectedItem(rs.getString("examtype"));
     
  
        this.txtenumber.setText("" + rs.getString("examno"));
    
      }
      else{
            JOptionPane.showMessageDialog(rootPane, "Record not found please try again");
  
      }
  
    

    

    
    }
    catch (SQLException ex) {
        ex.printStackTrace();
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(exams.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        
        
        
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
    try {
        // TODO add your handling code here:
  
      
        int r = 0;
        int last = 0;

        last = Integer.parseInt(txtentry.getText());

        String exam = (String)this.txtetype.getSelectedItem();
        int clas = Integer.parseInt((String)this.txtclass.getSelectedItem());
        String stream = (String) this.txtstream.getSelectedItem();
        int trm = Integer.parseInt((String)this.txtterm.getSelectedItem());
        int yr = Integer.parseInt(this.txtyear.getText());
        String no = this.txtenumber.getText();
        int ent = Integer.parseInt(this.txtentry.getText());
        try {       
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(exams.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        Connection conn = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        conn.setAutoCommit(false);
        PreparedStatement stmt = conn.prepareStatement("INSERT into exam values(?,?,?,?,?,?,?)");

        stmt.setString(1, exam);
        stmt.setInt(2, clas);
        stmt.setString(3, stream);
        stmt.setInt(4, trm);
        stmt.setInt(5, yr);
        stmt.setString(6, no);
        stmt.setInt(7, ent);
        stmt.executeUpdate();

         String z = (String)this.txtetype.getSelectedItem();
        String a ="" + tblresults.getValueAt(r, 1);

        int admno = Integer.parseInt(a);

        String examno = "" +tblresults.getValueAt(r, 0);
       
        int comp = 0; int eng = 0; int kis = 0; int math = 0; int science = 0; int composition = 0; int insha = 0; int grammer = 0; int lugha = 0; int social = 0; int religous = 0; int socialstudies = 0;
        while (r < last) {
            a = "" + tblresults.getValueAt(r, 1);
            admno = Integer.parseInt(a);
            examno = "" +tblresults.getValueAt(r, 0);
           String mt =""+ tblresults.getValueAt(r, 2);
            String in = "" + tblresults.getValueAt(r, 3);
            String lu = "" + tblresults.getValueAt(r, 4);
            String ks = "" + tblresults.getValueAt(r, 5);
            String com = "" + tblresults.getValueAt(r, 6);
            String gra = "" + tblresults.getValueAt(r, 7);
            String en = "" + tblresults.getValueAt(r, 8);
            String sc = "" + tblresults.getValueAt(r, 9);
            String re = "" + tblresults.getValueAt(r, 10);
            String soc = "" + tblresults.getValueAt(r, 11);
            String ss = "" + tblresults.getValueAt(r, 12);
            
            

         try
            {
              eng = Integer.parseInt(en); } catch (Exception y) { en = ""+0; } try {
              kis = Integer.parseInt(ks); } catch (Exception y) { ks = ""+0; } try {
              math = Integer.parseInt(mt); } catch (Exception y) { mt = ""+0; } try {
              socialstudies = Integer.parseInt(ss); } catch (Exception y) { ss = ""+0; } try {
              science = Integer.parseInt(sc); } catch (Exception y) { sc = ""+0; } try {
              insha = Integer.parseInt(in); } catch (Exception y) { in = ""+0; }  try {
            lugha = Integer.parseInt(lu); } catch (Exception y) { lu = ""+0; }  try {
            composition = Integer.parseInt(com); } catch (Exception y) { com = ""+0; }  try {
            grammer = Integer.parseInt(gra); } catch (Exception y) { gra = ""+0; }  try {
            religous = Integer.parseInt(re); } catch (Exception y) { re = ""+0; }  try {
            social = Integer.parseInt(soc); } catch (Exception y) { soc = ""+0; }  try {
            socialstudies = Integer.parseInt(ss); } catch (Exception y) { ss = ""+0; } 
            
            
               eng = Integer.parseInt(en); 
              kis = Integer.parseInt(ks); 
              math = Integer.parseInt(mt); 
              socialstudies = Integer.parseInt(ss); 
              science = Integer.parseInt(sc); 
              insha = Integer.parseInt(in); 
              lugha = Integer.parseInt(lu); 
              composition = Integer.parseInt(com); 
              grammer = Integer.parseInt(gra); 
              religous = Integer.parseInt(re); 
              social = Integer.parseInt(soc); 
              socialstudies = Integer.parseInt(ss); 
              
          
     
          
          PreparedStatement stmtt = conn.prepareStatement("INSERT into score(admno,examno,math,insha,lugha,kiswa,comp,grammer,eng,science,re,social,socialstudies)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

          stmtt.setInt(1, admno);
          stmtt.setString(2, examno);
          stmtt.setInt(3, math);
          stmtt.setInt(4, insha);
          stmtt.setInt(5, lugha);
          stmtt.setInt(6, kis);
          stmtt.setInt(7, comp);
          stmtt.setInt(8, grammer);
          stmtt.setInt(9, eng);
          stmtt.setInt(10, science);
          stmtt.setInt(11, religous);
          stmtt.setInt(12, social);
          stmtt.setInt(13, socialstudies);
          
          stmtt.executeUpdate();

          r++;
          conn.commit();
        JOptionPane.showMessageDialog(rootPane, "Save operation successfull");
   
         
    }
   
    
   
        
    } catch (SQLException ex) {
        Logger.getLogger(exams.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(rootPane, "Save operation failed try edit "+ex.getMessage());
               }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void txtdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdateMouseClicked
 JOptionPane.showMessageDialog(rootPane, " successfull");
   
// TODO add your handling code here:

    }//GEN-LAST:event_txtdateMouseClicked

    private void txtclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclassActionPerformed
        // TODO add your handling code here:
        if(txtyear.getText()==null){
            
        
       SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
       String Year = formatNowYear.format(txtdate.getDate());
       txtyear.setText(Year);
        }
    }//GEN-LAST:event_txtclassActionPerformed

    private void txtetypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtetypeActionPerformed
        // TODO add your handling code here:
        String type=(String) txtetype.getSelectedItem();
        String clas=(String) txtclass.getSelectedItem();
        String stream=(String) txtstream.getSelectedItem();
         String term=(String) txtterm.getSelectedItem();
         String year=txtyear.getText();
         
         txtenumber.setText(""+type+"-"+clas+"-"+stream+"-"+term+"-"+year);
         spop();        
         
      
      
      
    }//GEN-LAST:event_txtetypeActionPerformed

    private void txtclass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclass1ActionPerformed

    private void txtetype1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtetype1ActionPerformed
        // TODO add your handling code here:
         String type=(String) txtetype1.getSelectedItem();
        String clas=(String) txtclass1.getSelectedItem();
        String stream=(String) txtstream1.getSelectedItem();
         String term=(String) txtterm1.getSelectedItem();
        int year=txtyear1.getYear();
         
         txtsearch.setText(""+type+"-"+clas+"-"+stream+"-"+term+"-"+year);
    }//GEN-LAST:event_txtetype1ActionPerformed

    private void txtyear1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtyear1MouseEntered
        // TODO add your handling code here:
              String type=(String) txtetype1.getSelectedItem();
        String clas=(String) txtclass1.getSelectedItem();
        String stream=(String) txtstream1.getSelectedItem();
         String term=(String) txtterm1.getSelectedItem();
        int year=txtyear1.getYear();
         
         txtsearch.setText(""+type+"-"+clas+"-"+stream+"-"+term+"-"+year);
     
    }//GEN-LAST:event_txtyear1MouseEntered

    private void txtyear1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtyear1VetoableChange
        // TODO add your handling code here:.
             String type=(String) txtetype1.getSelectedItem();
        String clas=(String) txtclass1.getSelectedItem();
        String stream=(String) txtstream1.getSelectedItem();
         String term=(String) txtterm1.getSelectedItem();
        int year=txtyear1.getYear();
         
         txtsearch.setText(""+type+"-"+clas+"-"+stream+"-"+term+"-"+year);
    }//GEN-LAST:event_txtyear1VetoableChange

    private void txtyear1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtyear1PropertyChange
        // TODO add your handling code here:
              String type=(String) txtetype1.getSelectedItem();
        String clas=(String) txtclass1.getSelectedItem();
        String stream=(String) txtstream1.getSelectedItem();
         String term=(String) txtterm1.getSelectedItem();
        int year=txtyear1.getYear();
         
         txtsearch.setText(""+type+"-"+clas+"-"+stream+"-"+term+"-"+year);
    }//GEN-LAST:event_txtyear1PropertyChange

    private void txtstreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstreamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstreamActionPerformed

    private void btnnewrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewrecordActionPerformed
        // TODO add your handling code here:
  
    this.tblresults.selectAll();
    this.tblresults.clearSelection();
    this.txtetype.setSelectedItem("");
    this.txtclass.setSelectedItem("");
    this.txtstream.setSelectedItem("");
    this.txtterm.setSelectedItem("");
    this.txtyear.setText("");
    txtentry.setText("");
    cleartable();
    this.txtenumber.setText("");
    }//GEN-LAST:event_btnnewrecordActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
         int r = 0;
    int last = 0;
    try
    {
      try
      {
      String examn = this.txtsearch.getText();

        last = Integer.parseInt(this.txtentry.getText());
        String exam = (String)this.txtetype.getSelectedItem();
        int clas = Integer.parseInt((String)this.txtclass.getSelectedItem());
        String stream = (String)this.txtstream.getSelectedItem();
        int trm = Integer.parseInt((String)this.txtterm.getSelectedItem());
        int yr = Integer.parseInt(this.txtyear.getText());
        String no = this.txtenumber.getText();
        int ent = Integer.parseInt(this.txtentry.getText());

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
        PreparedStatement stmt = conn.prepareStatement("Update exam set examtype=?,class=?,stream=?,term=?,yearofadm=?,examno=?,entry=? where examno=" +"'"+ examn+"'");

        stmt.setString(1, exam);
        stmt.setInt(2, clas);
        stmt.setString(3, stream);
        stmt.setInt(4, trm);
        stmt.setInt(5, yr);
        stmt.setString(6, no);
        stmt.setInt(7, ent);
        stmt.executeUpdate();

        Class.forName("com.mysql.jdbc.Driver");
        Connection mycon = DriverManager.getConnection("jdbc:mysql://"+dbhostip+":3306/"+database, dbusername, dbpassword);
 
      int comp = 0; int eng = 0; int kis = 0; int math = 0; int science = 0; int composition = 0; int insha = 0; int grammer = 0; int lugha = 0; int social = 0; int religous = 0; int socialstudies = 0;
        while (r < last) {
          String   a = "" + tblresults.getValueAt(r, 1);
          int  admno = Integer.parseInt(a);
           String examno = "" +tblresults.getValueAt(r, 0);
           String mt =""+ tblresults.getValueAt(r, 2);
            String in = "" + tblresults.getValueAt(r, 3);
            String lu = "" + tblresults.getValueAt(r, 4);
            String ks = "" + tblresults.getValueAt(r, 5);
            String com = "" + tblresults.getValueAt(r, 6);
            String gra = "" + tblresults.getValueAt(r, 7);
            String en = "" + tblresults.getValueAt(r, 8);
            String sc = "" + tblresults.getValueAt(r, 9);
            String re = "" + tblresults.getValueAt(r, 10);
            String soc = "" + tblresults.getValueAt(r, 11);
            String ss = "" + tblresults.getValueAt(r, 12);
            
           
            try
            {
              eng = Integer.parseInt(en); } catch (Exception y) { en = ""+0; } try {
              kis = Integer.parseInt(ks); } catch (Exception y) { ks = ""+0; } try {
              math = Integer.parseInt(mt); } catch (Exception y) { mt = ""+0; } try {
              socialstudies = Integer.parseInt(ss); } catch (Exception y) { ss = ""+0; } try {
              science = Integer.parseInt(sc); } catch (Exception y) { sc = ""+0; } try {
              insha = Integer.parseInt(in); } catch (Exception y) { in = ""+0; }  try {
            lugha = Integer.parseInt(lu); } catch (Exception y) { lu = ""+0; }  try {
            composition = Integer.parseInt(com); } catch (Exception y) { com = ""+0; }  try {
            grammer = Integer.parseInt(gra); } catch (Exception y) { gra = ""+0; }  try {
            religous = Integer.parseInt(re); } catch (Exception y) { re = ""+0; }  try {
            social = Integer.parseInt(soc); } catch (Exception y) { soc = ""+0; }  try {
            socialstudies = Integer.parseInt(ss); } catch (Exception y) { ss = ""+0; } 
            
            
               eng = Integer.parseInt(en); 
              kis = Integer.parseInt(ks); 
              math = Integer.parseInt(mt); 
              socialstudies = Integer.parseInt(ss); 
              science = Integer.parseInt(sc); 
              insha = Integer.parseInt(in); 
              lugha = Integer.parseInt(lu); 
              composition = Integer.parseInt(com); 
              grammer = Integer.parseInt(gra); 
              religous = Integer.parseInt(re); 
              social = Integer.parseInt(soc); 
              socialstudies = Integer.parseInt(ss); 
          
            PreparedStatement stmtt = mycon.prepareStatement("update score set admno=?,examno=?,math=?,insha=?,lugha=?,kiswa=?,comp=?,grammer=?,eng=?,science=?,re=?,social=?,socialstudies=? where examno ='" + examn + "'and admno=" + admno);

          stmtt.setInt(1, admno);
          stmtt.setString(2, examno);
          stmtt.setInt(3, math);
          stmtt.setInt(4, insha);
          stmtt.setInt(5, lugha);
          stmtt.setInt(6, kis);
          stmtt.setInt(7, comp);
          stmtt.setInt(8, grammer);
          stmtt.setInt(9, eng);
          stmtt.setInt(10, science);
          stmtt.setInt(11, religous);
          stmtt.setInt(12, social);
          stmtt.setInt(13, socialstudies);
          stmtt.executeUpdate();

          r++;
        }
        JOptionPane.showMessageDialog(null, "Changes successfully updated");
      }
      catch (Exception e)
      {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Update operation unsuccessfull because\n" + e.getMessage() + "\n Please check all your input to ensure it is correct");
      }
    }
    catch (Exception lang)
    {
      JOptionPane.showMessageDialog(null, "Please Input a valid number of students who took the exam before you can proceed");
    }
        
    }//GEN-LAST:event_btneditActionPerformed

    private void txttermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttermActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnnewrecord;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbldetails;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfullname;
    private javax.swing.JLabel lblhome;
    private javax.swing.JLabel lblhome1;
    private javax.swing.JLabel lblogender;
    private javax.swing.JLabel lblparentid;
    private javax.swing.JLabel lblphone;
    private javax.swing.JLabel lblwork;
    private javax.swing.JPanel pnlmain;
    private javax.swing.JPanel pnlotherdetails;
    private javax.swing.JPanel pnlprsnldetails;
    private javax.swing.JTable tblresults;
    private javax.swing.JComboBox txtclass;
    private javax.swing.JComboBox txtclass1;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtentry;
    private javax.swing.JTextField txtenumber;
    private javax.swing.JComboBox txtetype;
    private javax.swing.JComboBox txtetype1;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JComboBox txtstream;
    private javax.swing.JComboBox txtstream1;
    private javax.swing.JComboBox txtterm;
    private javax.swing.JComboBox txtterm1;
    private javax.swing.JTextField txtyear;
    private com.toedter.calendar.JYearChooser txtyear1;
    // End of variables declaration//GEN-END:variables
}
