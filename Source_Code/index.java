import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class index extends JFrame //implements ActionListener
{
    //panel 1
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton submit;
    JCheckBox c1;
    
    //panel 2
    JLabel user, pass, phone, email, renter;
    JTextField nametxt, mailtxt, phntxt;
    JButton register;
    JPasswordField pfield, rfield;
    JCheckBox c2, c3;

    index() {
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        setBackground(new Color(255, 253, 208));
        // JLabel user = new JLabel("Username");

        UIManager.put("TabbedPane.background", new ColorUIResource(Color.RED));


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setUI(new BasicTabbedPaneUI() {
            protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
                if (isSelected) {
                    g.setColor(new Color(255, 253, 208));
                    g.fillRect(x, y, w, h);
                }
            }

            protected void paintTab(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
                if (isSelected) {
                    g.setColor(new Color(255, 253, 208));
                    g.fillRect(x, y, w, h);
                }
            }
        });


         try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel1.setBackground(new Color(255, 253, 208));
        panel2.setBackground(new Color(255, 253, 208));
        tabbedPane.addTab("Login", new ImageIcon("images/loginnew.png"), panel1);
        tabbedPane.addTab("Register", new ImageIcon("images/usernew.png"), panel2);

        UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(1, 1, 1, 1));
        UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(
                Color.BLACK));


        getContentPane().add(tabbedPane);
        Color creamColor = new Color(255, 253, 208);
        Border upperBorder = BorderFactory.createMatteBorder(50, 50, 50, 50, creamColor);

        tabbedPane.setBorder(upperBorder);
        c.add(tabbedPane);
        Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 15);

        tabbedPane.setBackground(Color.RED);

        //panel1
        l1 = new JLabel("UserName");
        l1.setFont(f1);
        l2 = new JLabel("Password");
        l2.setFont(f1);
        t1 = new JTextField(20);
        t2 = new JPasswordField(8);
        submit = new JButton("Login");
        submit.setFont(f1);
        c1 = new JCheckBox("Show");
        c1.setBackground(creamColor);
        //c1.setBackground(new Color(255, 143, 135));
        l1.setBounds(60, 100, 100, 25);
        t1.setBounds(170, 100, 200, 25);
        l2.setBounds(60, 135, 100, 25);
        t2.setBounds(170, 135, 200, 25);
        c1.setBounds(380, 135, 200, 25);
        submit.setBounds(170, 180, 100, 25);

        panel1.add(l1);
        panel1.add(l2);
        panel1.add(t1);
        panel1.add(t2);
        panel1.add(c1);
        c1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (c1.isSelected()) {
                    t2.setEchoChar((char) 0);
                } else {
                    t2.setEchoChar('*');
                }
            }
        });
        panel1.add(submit);

        //panel2
        user = new JLabel("User Name");
        user.setFont(f1);
        pass = new JLabel("Password");
        pass.setFont(f1);
        renter = new JLabel("Re-Enter Password:");
        renter.setFont(f1);
        email = new JLabel("Email ID:");
        email.setFont(f1);
        phone = new JLabel("Contact no.");
        phone.setFont(f1);
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
        c2.setBackground(creamColor);
        c3.setBackground(creamColor);
        panel2.add(user);
        panel2.add(email);
        panel2.add(phone);
        panel2.add(pass);
        panel2.add(renter);
        panel2.add(nametxt);
        panel2.add(mailtxt);
        panel2.add(phntxt);
        panel2.add(pfield);
        panel2.add(rfield);
        panel2.add(register);
        c2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (c2.isSelected()) {
                    pfield.setEchoChar((char) 0);
                } else {
                    pfield.setEchoChar('*');
                }
            }
        });
        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (c3.isSelected()) {
                    rfield.setEchoChar((char) 0);
                } else {
                    rfield.setEchoChar('*');
                }
            }
        });
        panel2.add(c2);
        panel2.add(c3);
    }


    public static void main(String[] args) {
        index t1 = new index();
        t1.setSize(600, 600);
        t1.setVisible(true);
        t1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t1.setLocation(600, 100);

    }
}