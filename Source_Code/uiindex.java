import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;

public class uiindex extends JFrame implements ActionListener {
   JLabel header;
   JLabel l1;
   JLabel l2;
   JTextField t1;
   JPasswordField t2;
   JButton submit;
   JCheckBox c1;
   JLabel user;
   JLabel pass;
   JLabel phone;
   JLabel email;
   JLabel renter;
   JTextField nametxt;
   JTextField mailtxt;
   JTextField phntxt;
   JButton register;
   JPasswordField pfield;
   JPasswordField rfield;
   JCheckBox c2;
   JCheckBox c3;

   uiindex() {
      Container var1 = getContentPane();
      var1.setLayout(new BorderLayout());
      var1.setBackground(new Color(118, 232, 190));
      var1.setBackground(new Color(118, 232, 190));
      header = new JLabel("Train Reservation System");
      header.setFont(new Font("Buffalo", 1, 30));
      header.setForeground(new Color(118, 232, 190));
      header.setBounds(80, 5, 400, 40);
      var1.add(header);
      UIManager.put("TabbedPane.background", new ColorUIResource(new Color(118, 232, 190)));
      JTabbedPane var2 = new JTabbedPane();

      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      UIManager.put("TabbedPane.background", new ColorUIResource(new Color(118, 232, 190)));

      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      JPanel var3 = new JPanel();
      var3.setLayout((LayoutManager)null);
      JPanel var4 = new JPanel();
      var4.setLayout((LayoutManager)null);
      var3.setBackground(new Color(128, 193, 255));
      var4.setBackground(new Color(128, 193, 255));
      var2.addTab("Login", new ImageIcon("images/loginnew.png"), var3);
      var2.addTab("Register", new ImageIcon("images/usernew.png"), var4);
      UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(1, 1, 1, 1));
      UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(new Color(118, 232, 190)));
      getContentPane().add(var2);
      MatteBorder var5 = BorderFactory.createMatteBorder(50, 50, 50, 50, new Color(219, 81, 109));
      var2.setBorder(var5);
      var1.add(var2);
      Font var6 = new Font("Buffalo", 1, 15);
      var2.setBackground(new Color(118, 232, 190));
      l1 = new JLabel("USERNAME");
      l1.setFont(var6);
      l2 = new JLabel("PASSWORD");
      l2.setFont(var6);
      t1 = new JTextField(20);
      t2 = new JPasswordField(8);
      submit = new JButton("Login");
      submit.setFont(var6);
      c1 = new JCheckBox("Show");
      c1.setBackground(new Color(128, 193, 255));
      l1.setBounds(60, 100, 100, 25);
      t1.setBounds(170, 100, 200, 25);
      l2.setBounds(60, 135, 100, 25);
      t2.setBounds(170, 135, 200, 25);
      c1.setBounds(380, 135, 200, 25);
      submit.setBounds(170, 180, 100, 25);
      submit.setBackground(new Color(128, 193, 255));
      submit.addActionListener(this);
      var3.add(l1);
      var3.add(l2);
      var3.add(t1);
      var3.add(t2);
      var3.add(c1);
      c1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             if (c1.isSelected()) {
                 t2.setEchoChar((char) 0);
             } else {
                 t2.setEchoChar('*');
             }
         }
     });
      var3.add(submit);
      user = new JLabel("User Name");
      user.setFont(var6);
      pass = new JLabel("Password");
      pass.setFont(var6);
      renter = new JLabel("Re-Enter Password:");
      renter.setFont(var6);
      email = new JLabel("Email ID:");
      email.setFont(var6);
      phone = new JLabel("Contact no.");
      phone.setFont(var6);
      nametxt = new JTextField(20);
      mailtxt = new JTextField(25);
      phntxt = new JTextField(10);
      pfield = new JPasswordField(8);
      rfield = new JPasswordField(8);
      c2 = new JCheckBox("Show");
      c3 = new JCheckBox("Show");
      register = new JButton("Register");
      user.setBounds(60, 60, 100, 25);
      nametxt.setBounds(230, 60, 200, 25);
      email.setBounds(60, 95, 100, 25);
      mailtxt.setBounds(230, 95, 200, 25);
      phone.setBounds(60, 130, 100, 25);
      phntxt.setBounds(230, 130, 200, 25);
      pass.setBounds(60, 165, 100, 25);
      pfield.setBounds(230, 165, 200, 25);
      c2.setBounds(370, 195, 100, 25);
      renter.setBounds(60, 230, 150, 25);
      rfield.setBounds(230, 230, 200, 25);
      c3.setBounds(370, 260, 100, 25);
      register.setBounds(180, 320, 100, 25);
      c2.setBackground(new Color(128, 193, 255));
      c3.setBackground(new Color(128, 193, 255));
      register.setFont(var6);
      var4.add(user);
      var4.add(email);
      var4.add(phone);
      var4.add(pass);
      var4.add(renter);
      var4.add(nametxt);
      var4.add(mailtxt);
      var4.add(phntxt);
      var4.add(pfield);
      var4.add(rfield);
      var4.add(register);
      register.addActionListener(this);
      c2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             if (c2.isSelected()) {
                 pfield.setEchoChar((char) 0);
             } else {
                 pfield.setEchoChar('*');
             }
         }
     });
      c3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             if (c1.isSelected()) {
                 rfield.setEchoChar((char) 0);
             } else {
                 rfield.setEchoChar('*');
             }
         }
     });
      var4.add(c2);
      var4.add(c3);
   }

   public void actionPerformed(ActionEvent var1) {
      String var2;
      String var3;
      if (var1.getSource() == register) {
         System.out.println("Register Called");
         var2 = nametxt.getText();
         var3 = mailtxt.getText();
         String var4 = phntxt.getText();
         String var5 = pfield.getText();
         String var6 = rfield.getText();
         new Information(var2, var3, var4, var5, var6);
      }

      if (var1.getSource() == submit) {
         if (t1.getText().isEmpty()) {
            var2 = null;
         } else {
            var2 = t1.getText();
         }

         if (t2.getText().isEmpty()) {
            var3 = null;
         } else {
            var3 = t2.getText();
         }

         System.out.println("S1 : " + var2 + " S2: " + var3);
         new Information(var2, var3);
      }

   }

   public static void main(String[] var0) {
      uiindex var1 = new uiindex();
      var1.setSize(600, 600);
      var1.setVisible(true);
      var1.setDefaultCloseOperation(3);
      var1.setLocation(600, 100);
   }
}
