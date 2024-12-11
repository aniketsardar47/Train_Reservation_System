import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Booking extends JFrame implements ActionListener
{

    TrainTicketGenerator b1;
    int id,price;
    JPanel p1,p2,p3;
    JLabel l1;
    JLabel l2=new JLabel("Booking Procedure");
    int value;
    JTextField txt1;
    JTextField txtage,textField;
    int count;
    int sum;
    JButton next;
    JButton pay;
    JScrollPane scrollPane;
    Font f1 = new Font("TimesNewRoman", Font.BOLD, 16);
    Font f2=new Font("TimesNewRoman", Font.BOLD, 15);

    Booking(int id)
     {
        this.id = id;
        try( Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/train_reservation_system","-", "-");)
        {
            PreparedStatement sql= con.prepareStatement("Select Price from Trains where TrainID= ?");
     sql.setInt(1,id);
     ResultSet resultSet  = sql.executeQuery();
        if(resultSet.next())
        {
            value=resultSet.getInt("Price");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
     getContentPane().setBackground(new Color(118,232,190));
     setSize(600, 600);
     setLocation(100, 100);
     setLayout(null);
     //p1
     p1 = new JPanel();
    p1.setLayout(null);
    p1.setBounds(90, 100, 400, 400);
    p1.setBackground(new Color(153, 187, 255));
    l2.setFont(new Font("Trebuchet MS",Font.BOLD,30));
    l2.setBounds(160,40,300,45);
    l2.setForeground(new Color(153, 0, 0));
     l1 = new JLabel("Enter the no. of Passengers : ");
     l1.setFont(f1);
     next = new JButton("Next");
     txt1 = new JTextField(20);
     l1.setBounds(100, 130, 250, 20);
     txt1.setBounds(130, 170, 150, 30);
     next.setBounds(160, 220, 80, 30);
     next.setFont(f2);
     p1.add(l1);
     p1.add(txt1);
     p1.add(next);
     add(p1);
     add(l2);
     p1.setVisible(true);
     next.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             count = Integer.parseInt(txt1.getText());
             p1.setVisible(false);
             createpane2();
             scrollPane.setVisible(true);

         }
     });
     setVisible(true);
 }

 public void createpane2() {
        //p2
    
     p2 = new JPanel();
     p2.setLayout(null);
     p2.setBackground(new Color(153, 187, 255));
     int yOffset = 50;
     JLabel enter=new JLabel("Enter the name and age of Passenger");
     enter.setBounds(10,10,400,25);
     enter.setFont(f1);
     if(count>=6)
     {
         JLabel note=new JLabel("Please scroll to look furthur ! ");
         note.setBounds(10,40,400,25);
         note.setFont(new Font("TimesNewRoman", Font.BOLD, 13));
         yOffset+=30;
         p2.add(note);
     }
     for (int i = 1; i <= count; i++) {
         JLabel l=new JLabel("Name of Passenger "+i+":");
         l.setBounds(10,yOffset,150,20);
         textField = new JTextField(10);
         textField.setBounds(180, yOffset, 160, 30);
         JLabel age=new JLabel("Age: ");
         age.setBounds(350,yOffset,150,20);
         txtage = new JTextField(10);
         txtage.setBounds(400, yOffset, 160, 30);
         p2.add(textField);
         p2.add(l);
         p2.add(age);
         p2.add(txtage);
         yOffset += 40;
     }
     JButton next1=new JButton("Proceed");
     next1.setBounds(240,yOffset+10,100,30);
     next1.setFont(f2);
     yOffset+=70;
     p2.setPreferredSize(new Dimension(400, yOffset));
     p2.add(enter);
     p2.add(next1);
     scrollPane=new JScrollPane(p2);
     scrollPane.setBounds(0, 130, 600, 300);
     scrollPane.setVisible(false);
     add(scrollPane);
     next1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String check_name=textField.getText();
            String check_age=txtage.getText(); 
            if(check_name.isEmpty() || check_age.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please Enter Valid Information!!");
            }
            else{
             scrollPane.setVisible(false);
             createpane3();
             p3.setVisible(true);
            }
         }
     });
 }

 public void createpane3()
 {
     //p3
     p3 = new JPanel();
     p3.setLayout(null);
     p3.setBackground(new Color(153, 187, 255));
     p3.setBounds(90, 100, 400, 400);
     JLabel amount =new JLabel("Total Tickit Amount: ");
     amount.setBounds(40,100,160,20);
     amount.setFont(f1);
     JLabel amount1 =new JLabel("Total Passengers: ");
     amount1.setBounds(40,150,160,20);
     amount1.setFont(f1);
     JLabel amount2 =new JLabel("Total Amount: ");
     amount2.setBounds(40,200,160,20);
     amount2.setFont(f1);
     JLabel no_person =new JLabel(String.valueOf(count));
     no_person.setFont(f1);
     no_person.setBounds(290,150 , 160, 30);
     JLabel amount_txt1 =new JLabel(String.valueOf(value));
     amount_txt1.setBounds(290,100 , 160, 30);
     amount_txt1.setFont(f1);
     sum=count*value;
     JLabel amount_txt2 =new JLabel(String.valueOf(sum));
     amount_txt2.setBounds(290,200 , 160, 30);
     amount_txt2.setFont(f1);
     pay=new JButton("Pay");
     pay.setFont(f2);
     pay.setBounds(160, 270, 80, 30);
     p3.add(amount);
     p3.add(amount1);
     p3.add(amount2);
     p3.add(no_person);
     p3.add(amount_txt1);
     p3.add(amount_txt2);
     p3.add(pay);
     add(p3);
     pay.addActionListener(this);
     
 }

 public void actionPerformed(ActionEvent e){

    if(e.getSource()==pay){
        new TrainTicketGenerator(id, count, sum);
        this.dispose();
    }
        
 }
}