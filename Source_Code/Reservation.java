import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javafx.event.ActionEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.*;

public class Reservation extends JFrame {

    //p1
    JLabel header;

    //p3
    JLabel source,destination;
    JTextField sourcein,destin;
    
    //connection
    String jdbcUrl = "jdbc:mysql://localhost:3306/train_reservation_system";
        String username = "-";
        String password = "-";
    
     Reservation(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setSize(screenSize.width, screenSize.height);
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p1 = new JPanel();
        p1.setSize(100,100);
        p1.setPreferredSize(new Dimension(this.getWidth(), 100));
        p1.setBackground(new Color(217,167,176));

        JPanel p2 = new JPanel();
        p2.setSize(100,100);
        p2.setPreferredSize(new Dimension(500, this.getHeight()));
        p2.setBackground(new Color(166,111,111));

        JPanel p3 = new JPanel(null);
       p2.setPreferredSize(new Dimension(500, 500));
        p3.setBackground(new Color(167,203,217));
        
        JPanel cenp = new JPanel();
        cenp.setSize(700,800);


        JPanel p4 = new JPanel();
        p4.setSize(100,100);
        p4.setPreferredSize(new Dimension(500, this.getHeight()));
        p4.setBackground(new Color(242,224,213));

        JPanel p5 = new JPanel();
        p5.setSize(100,100);
        p5.setPreferredSize(new Dimension(this.getWidth(), 200));
        p5.setBackground(new Color(104,160,166));




        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(p1,BorderLayout.NORTH);
        c.add(p2,BorderLayout.EAST);
        c.add(p3,BorderLayout.CENTER);
        c.add(p4,BorderLayout.WEST);
        c.add(p5,BorderLayout.SOUTH);

        //p1
        header = new JLabel("Train Reservation System");
        Font texts = new Font("TimesRoman", Font.BOLD, 50);
        header.setFont(texts);
        header.setBounds(300,20,800,70);
        p1.add(header);


        //p3
        Font f1 = new Font("SansSerif", Font.ITALIC, 20);
        source = new JLabel("Source: ");
        source.setFont(f1);
        destination = new JLabel("Destination: ");
        destination.setFont(f1);
        sourcein = new JTextField(20);
        sourcein.setBackground(new Color(167,203,217));
        destin = new JTextField(20);
        destin.setBackground(new Color(167,203,217));
        DatabaseTableExample t1 = new DatabaseTableExample();

        source.setBounds(20,10,100,25);
        sourcein.setBounds(130,10,150,25);
        destination.setBounds(400,10,150,25);
        destin.setBounds(550,10,150,25);
        t1.setBounds(30,100,800,600);
     

        p3.add(source);
        p3.add(sourcein);
        p3.add(destination);
        p3.add(destin);
        p3.add(t1);
        



        //p2

        Filters date = new Filters();
        date.setBackground(new Color(242,224,213));
        p4.add(date);



         setVisible(true);


}
        

    public static void main(String[] args) {
        Reservation r1 = new Reservation();
    }
}



