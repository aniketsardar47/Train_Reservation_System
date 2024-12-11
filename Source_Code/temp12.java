import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

public class temp12 extends JFrame{

 public static void main(String []args){
    checkdata d1 = new checkdata();
    int t = d1.checkinfo("Kalka","Shimla");
    System.out.println(t);
}
}
