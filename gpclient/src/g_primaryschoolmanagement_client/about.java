package g_primaryschoolmanagement_client;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingWorker;
import javax.swing.border.SoftBevelBorder;

public class about extends JInternalFrame
{
  private JLabel label;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLayeredPane jLayeredPane1;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JScrollPane jScrollPane1;
  private JTextArea jTextArea1;
private static final String LABEL_TEXT = "GUltimateDevelopers";
private static final String A_VALID_LINK = "http://gultimatedevelopers.me.pn";
private static final String A_HREF = "<a href=\"";
private static final String HREF_CLOSED = "\">";
private static final String HREF_END = "</a>";
private static final String HTML = "<html>";
private static final String HTML_END = "</html>";



private static void makeLinkable(JLabel c, MouseListener ml) {
    assert ml != null;
    c.setText(htmlIfy(linkIfy(c.getText())));
    c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    c.addMouseListener(ml);
}

private static boolean isBrowsingSupported() {
    if (!Desktop.isDesktopSupported()) {
        return false;
    }
    boolean result = false;
    Desktop desktop = java.awt.Desktop.getDesktop();
    if (desktop.isSupported(Desktop.Action.BROWSE)) {
        result = true;
    }
    return result;

}

private static class LinkMouseListener extends MouseAdapter {

    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
         try {
            URI uri = new java.net.URI((A_VALID_LINK ));
            (new LinkRunner(uri)).execute();
        } catch (URISyntaxException use) {
            throw new AssertionError(use + ": " +A_VALID_LINK ); //NOI18N
        }
    }
}

private static class LinkRunner extends SwingWorker<Void, Void> {

    private final URI uri;

    private LinkRunner(URI u) {
        if (u == null) {
            throw new NullPointerException();
        }
        uri = u;
    }

    @Override
    protected Void doInBackground() throws Exception {
        Desktop desktop = java.awt.Desktop.getDesktop();
        desktop.browse(uri);
        return null;
    }

    @Override
    protected void done() {
        try {
            get();
        } catch (ExecutionException ee) {
            handleException(uri, ee);
        } catch (InterruptedException ie) {
            handleException(uri, ie);
        }
    }

    private static void handleException(URI u, Exception e) {
        JOptionPane.showMessageDialog(null, "Sorry, a problem occurred while trying to open this link in your system's standard browser.", "A problem occured", JOptionPane.ERROR_MESSAGE);
    }
}

private static String getPlainLink(String s) {
    return s.substring(s.indexOf(A_HREF) + A_HREF.length(), s.indexOf(HREF_CLOSED));
}

//WARNING
//This method requires that s is a plain string that requires
//no further escaping
private static String linkIfy(String s) {
    return A_HREF.concat(s).concat(HREF_CLOSED).concat(s).concat(HREF_END);
}

//WARNING
//This method requires that s is a plain string that requires
//no further escaping
private static String htmlIfy(String s) {
    return HTML.concat(s).concat(HTML_END);
}

/**
 * @param args the command line arguments
 */


  public about()  {
    initComponents();
   
    if (isBrowsingSupported()) {
        makeLinkable(label, new LinkMouseListener());
    }

    pack();
   
  }
  

   
   
    
    
  

  private static void open(URI uri) {
    if (Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().browse(uri);
      } catch (IOException e) { /* TODO: error handling */ }
    } else { /* TODO: error handling */ }
  }
  
  private void initComponents()
  {
    this.jPanel1 = new JPanel();
    this.jScrollPane1 = new JScrollPane();
    this.jTextArea1 = new JTextArea();
    this.jPanel2 = new JPanel();
    this.jLayeredPane1 = new JLayeredPane();
    this.jLabel3 = new JLabel();
    this.jLabel1 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jLabel2 = new JLabel();
    this.label = new JLabel(LABEL_TEXT);
    this.label.setBounds(0,120,120,15);
    this.jLayeredPane1.add(this.label, JLayeredPane.DEFAULT_LAYER);

    /* this.label.setBounds(0,120,120,15);
    this.jLayeredPane1.add(this.label, JLayeredPane.DEFAULT_LAYER);
*/
    
     
    setClosable(true);
    setIconifiable(true);
    setMaximizable(true);
    setResizable(true);
    setTitle("About");

    this.jPanel1.setBackground(new Color(0, 0, 0));
    this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));

    this.jTextArea1.setBackground(new Color(51, 51, 255));
    this.jTextArea1.setColumns(20);
    this.jTextArea1.setFont(new Font("Traditional Arabic", 0, 18));
    this.jTextArea1.setForeground(new Color(255, 255, 255));
    this.jTextArea1.setRows(5);
    this.jTextArea1.setText("The G_Primary school manager is a complete custom built program \n created and developed by G Ultimate Developers. \n This system takes care of all your needs in school \n management including students,parents and exam data management and processing.\nIt is equipped with fast search features and reporting \ncapabalities.\nFor more information about the program ,\nBetter customization to suite your needs \nContact Me at \n\t:griffinmuteti31@gmail.com\n\t:winmcn@gmail.com\n\t:+254702990800\n\t:+254722637857\nOr Visit out site at:\n G Ultimate Developers \n Thanks for purchasing :Enjoy using the high school manager");
    this.jTextArea1.setBorder(new SoftBevelBorder(0));
    this.jTextArea1.setFocusable(false);
    this.jScrollPane1.setViewportView(this.jTextArea1);

    this.jPanel2.setBorder(BorderFactory.createBevelBorder(0));

    this.jLabel3.setIcon(new ImageIcon(getClass().getResource("hslogo.jpg")));
    this.jLabel3.setBounds(0, 0, 120,120);
    this.jLayeredPane1.add(this.jLabel3, JLayeredPane.DEFAULT_LAYER);
    
    this.jLabel2.setIcon(new ImageIcon(getClass().getResource("Fullscreen capture 5152013 115827 AM.bmp.jpg")));
    this.jLabel2.setBounds(90, 0, 120,120);
    this.jLayeredPane1.add(this.jLabel2, JLayeredPane.DEFAULT_LAYER);
     
    
    

    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLayeredPane1, -2, 150, -2)));

    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLayeredPane1, -2, 150, -2).addContainerGap(6, 32767)));

    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 495, 32767)).addContainerGap()));

    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 361, -2).addContainerGap(-1, 32767)));

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)));

    pack();
  }
}