import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar; 

public class Reservation2 extends JFrame implements ActionListener{

    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1;
    public Reservation2(){

        Container c = getContentPane();
        setVisible(true);
        setSize(600,600);
        setLocation(100, 100);
        c.setLayout(null);
        //JPanel p1= new JPanel();
        c.setBackground(new Color(230, 204, 255));
        JPanel p1= new JPanel();
        p1.setBackground(new Color(230, 204, 255));
        
        Font f1 = new Font("Ariel",Font.BOLD,16);
        l1 = new JLabel("Train Selection");
        l1.setFont(f1);
        l2 = new JLabel("Source");
        l2.setFont(f1);
        t1 = new JTextField(20);
        l3 = new JLabel("Destination");
        l3.setFont(f1);

        t2 = new JTextField(20);
        b1 = new JButton("Search Result");

        l2.setBounds(100,50,200,25);
        t1.setBounds(310,50,150,25);
        l3.setBounds(100,80,200,25);
        t2.setBounds(310,80,150,25);
        p1.setBounds(30,135,500,35);
        b1.setBounds(170,200,150,25);

        c.add(l2);
        c.add(t1);
        c.add(l3);
        c.add(t2);
        c.add(b1);
            
        b1.addActionListener(this);
    }


   

    public void actionPerformed(ActionEvent e){

        String s1 = t1.getText();
        String s2 = t2.getText();       
        System.out.println("Source: "+s1);
        System.out.println("Destination:"+s2);

      
        if(s1.isEmpty() && s2.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Valid Information!!");
        }
        else{
            checkdata d1 = new checkdata();
            int t = d1.checkinfo(s1,s2);
            if(t == -1){
                JOptionPane.showMessageDialog(this,"Please Reenter Information");
            }
            else{
                dispose();
                ShowResult t1 = new ShowResult(t);
            }



        }
    }

    
}