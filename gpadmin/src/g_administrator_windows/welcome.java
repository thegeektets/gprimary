/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package g_administrator_windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author griffin
 */
public class welcome extends javax.swing.JInternalFrame {

    /**
     * Creates new form welcome
     */
    public welcome() {
        initComponents();
              pnlmain.setBackground(Color.getHSBColor( 238,238,238));
        fillbar();

    }

     public void fillbar(){
  jpbwait.setStringPainted(true);
 
  jpbwait.setValue(0);

  int timerDelay = 20;
  new javax.swing.Timer(timerDelay , new ActionListener() {
     private int index = 0;
     private int maxIndex = 100;
     public void actionPerformed(ActionEvent e) {
        if (index < maxIndex) {
           jpbwait.setValue(index);
           index++;
        } else {
          jpbwait.setValue(maxIndex);
           ((javax.swing.Timer)e.getSource()).stop(); // stop the timer
           dispose();//dispose welcome on fill
          main.btnfile.setEnabled(true);
          main.btnabout.setEnabled(true);
          main.btnschool.setEnabled(true);
          main.pnlhead.setBackground(Color.getHSBColor( 238,238,238));
             }
     }
  }).start();

 jpbwait.setValue(jpbwait.getMinimum());

        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlmain = new javax.swing.JPanel();
        lblmain = new javax.swing.JLabel();
        lblwait = new javax.swing.JLabel();
        lblthankyou = new javax.swing.JLabel();
        jpbwait = new javax.swing.JProgressBar();
        lbllogom = new javax.swing.JLabel();
        lblogo = new javax.swing.JLabel();
        lblfooter = new javax.swing.JLabel();

        pnlmain.setBackground(new java.awt.Color(51, 255, 51));

        lblmain.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblmain.setText("WELCOME ADMINISTRATOR");
        lblmain.setToolTipText("");

        lblwait.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblwait.setText("please wait while the system loads");

        lblthankyou.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lblthankyou.setText("Thank-you for using our products.");

        jpbwait.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lbllogom.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lbllogom.setText("Providing Business Solutions");

        lblogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/g_administrator_windows/logo.jpg"))); // NOI18N
        lblogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout pnlmainLayout = new javax.swing.GroupLayout(pnlmain);
        pnlmain.setLayout(pnlmainLayout);
        pnlmainLayout.setHorizontalGroup(
            pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblmain, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpbwait, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblwait, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbllogom, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblogo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblthankyou))
        );
        pnlmainLayout.setVerticalGroup(
            pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmainLayout.createSequentialGroup()
                .addComponent(lblmain, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblwait)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpbwait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbllogom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblthankyou, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
        );

        pnlfooter.setFont(new java.awt.Font("FreeSerif", 2, 14)); // NOI18N
        pnlfooter.setOpaque(false);

        lblfooter.setBackground(new java.awt.Color(153, 0, 255));
        lblfooter.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        lblfooter.setForeground(new java.awt.Color(255, 255, 255));
        lblfooter.setText("G Ultimate Developers :2013-All Rights Reserved.");
        lblfooter.setOpaque(true);

        javax.swing.GroupLayout pnlfooterLayout = new javax.swing.GroupLayout(pnlfooter);
        pnlfooter.setLayout(pnlfooterLayout);
        pnlfooterLayout.setHorizontalGroup(
            pnlfooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlfooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblfooter, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlfooterLayout.setVerticalGroup(
            pnlfooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlfooterLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblfooter))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(pnlfooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addComponent(pnlfooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(29, 29, 29)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jpbwait;
    private javax.swing.JLabel lblfooter;
    private javax.swing.JLabel lbllogom;
    private javax.swing.JLabel lblmain;
    private javax.swing.JLabel lblogo;
    private javax.swing.JLabel lblthankyou;
    private javax.swing.JLabel lblwait;
    final javax.swing.JPanel pnlfooter = new javax.swing.JPanel();
    private javax.swing.JPanel pnlmain;
    // End of variables declaration//GEN-END:variables
}
