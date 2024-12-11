import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class tempc {

    public static void main(String[] args) {
      JFrame frame = new JFrame("Simple Message Box Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Create a panel to hold components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create a JTextField
        JTextField textField = new JTextField();
        mainPanel.add(textField, BorderLayout.NORTH);

        // Create a message box panel
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel messageLabel = new JLabel("This is a message box below the text field.");
        messagePanel.add(messageLabel);
        mainPanel.add(messagePanel, BorderLayout.CENTER);

        // Create a button to show a message box
        JButton showMessageButton = new JButton("Show Message");
        showMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "This is a sample message box.");
            }
        });

        mainPanel.add(showMessageButton, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
