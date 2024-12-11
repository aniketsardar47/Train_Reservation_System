import java.sql.*;
import javax.swing.*;

import java.lang.*;

public class checkdata extends JFrame {
    public int checkinfo(String s1,String s2){
        try{
           // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train_reservation_system","aniket","aniket47");
            PreparedStatement st = con.prepareStatement("Select TrainID from Trains where DepartureStation=? AND ArrivalStation=? ");
            st.setString(1, s1.substring(0, 1).toUpperCase()+s1.substring(1));
            st.setString(2, s2.substring(0, 1).toUpperCase()+s2.substring(1));
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Train Found");
                return rs.getInt(1);
            }
            else{
                JOptionPane.showMessageDialog(this, "Train Not Found!!");
                return -1;
            }
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
         return -1;
        }

      
        

}
