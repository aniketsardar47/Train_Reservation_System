import java.awt.*;
import java.awt.event.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.*;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class temp extends JFrame implements ActionListener
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

    //connection 
    protected String url = "jdbc:mysql://localhost:3306/train_reservation_system";
    protected String username = "aniket";
    protected String password = "aniket47";

    //encryption
    KeyPair keyPair;
      PublicKey publicKey ;
        PrivateKey privateKey;
           String pfieldc;
             String dfieldc;
             String decryptedpass;

             private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";

    temp() throws Exception{
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        setBackground(new Color(255, 253, 208));
        // JLabel user = new JLabel("Username");


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
            UIManager.setLookAndFeel("nimbus.NimbusLookAndFeel");
            UIManager.put("ToolTip.background", new Color(255, 253, 208));
        } catch (Exception e) {

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
        UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(Color.BLACK));


        getContentPane().add(tabbedPane);
        Color creamColor = new Color(255, 253, 208);
        Border upperBorder = BorderFactory.createMatteBorder(50, 50, 50, 50, creamColor);

        tabbedPane.setBorder(upperBorder);
        c.add(tabbedPane);
        Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 15);

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
        submit.addActionListener(this);

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
        register.addActionListener(this);
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
        // Generate RSA key pair
        keyPair = generateKeyPair();
       publicKey = keyPair.getPublic();
       privateKey = keyPair.getPrivate();
    }

    public void initpasses() throws Exception {
        if(pfield.getText()!=null){
        pfieldc = encrypt(pfield.getText(), publicKey);
        dfieldc = decrypt(pfieldc, privateKey);
        }
        if(t2.getText()!=null){
          decryptedpass =  decrypt(t2.getText(), privateKey);

        }
    }
   

    public void actionPerformed(ActionEvent e){
        try {
                initpasses();  
            } catch (Exception passes) {
               passes.printStackTrace();
            }
        if(e.getSource()==register){
            //pfield, rfield
            String namec = nametxt.getText();
            String mailc = mailtxt.getText();
            String phntxc = phntxt.getText();
            
              
            System.out.println(pfieldc+" encrypted");
                System.out.println(dfieldc+" decrypted");
      
            String rfieldc = rfield.getText();
            String pass = pfield.getText();
            String respass = rfield.getText();


            if(pass.equals(respass)){
                System.out.println(pass+" Password 1");
                System.out.println(respass+" Password 2");
                String print = pass+ "Password 1"+ respass+" Password 2";
               JOptionPane.showMessageDialog(this, print);
        try{
		
    Connection con = DriverManager.getConnection(url, username, password);
    //System.out.println("Connection Established");
    Statement st = con.createStatement();
    String query = "INSERT INTO login(username,passwords,email,contactno) VALUES (?,?,?,?);";
    PreparedStatement preparedStatement = con.prepareStatement(query);
            
    // Set the values
    preparedStatement.setString(1, namec);
    preparedStatement.setString(2, pfieldc);
    preparedStatement.setString(3, mailc);
    preparedStatement.setString(4, phntxc);
    
    int rowsAffected = preparedStatement.executeUpdate();
    //System.out.println("Rows affected: " + rowsAffected);

    con.close();
    }
    catch(SQLException same){
        JOptionPane.showMessageDialog(this,"Something went wrong check your data");
    }
        

    }
    else{
        JOptionPane.showMessageDialog(this, "Password Does not Matched");
        System.out.println(pass+" Password 1");
                System.out.println(respass+" Password 2");

    }
        
        }


        if(e.getSource() == submit){

            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                String query = "SELECT passwords from login WHERE username= ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, t1.getText());

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String retrievedEncryptedPassword = resultSet.getString("passwords");
                    String enteredPassword = t2.getText();
                
                    System.out.println("Retrieved Encrypted Password: " + retrievedEncryptedPassword);
                
                    // Decrypt the retrieved encrypted password
                   
                    System.out.println("Decrypted Password: " + decryptedpass);
                
                    // Check if the entered password matches the stored password
                    if (enteredPassword.equals(decryptedpass)) {
                        System.out.println("Password matched.");
                    } else {
                        System.out.println("Password did not match.");
                    }
                } else {
                    System.out.println("Data not found.");
                }
                

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());;
            }
            
            

        }
    }


    // Generate RSA key pair
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }


       // Modify the encryption method to use RSA_ALGORITHM
    public static String encrypt(String message, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Modify the decryption method to use RSA_ALGORITHM
    public static String decrypt(String encryptedMessage, PrivateKey privateKey) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedMessage);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            String decryptedText = new String(decryptedBytes, "UTF-8"); // Use the appropriate character encoding
            return decryptedText;
        } catch (Exception e) {
            // Handle the exception, e.g., log the error or rethrow with a custom message.
            e.printStackTrace();
            throw new Exception("Decryption error: " + e.getMessage());
        }
    }
    
    



    public static void main(String[] args) throws Exception{
        temp t1 = new temp();
        t1.setSize(600, 600);
        t1.setVisible(true);
        t1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        t1.setLocation(600, 100);

    }
}