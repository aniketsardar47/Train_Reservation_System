import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabelTextFieldComboBoxExample extends JFrame {
    private JLabel fromLabel, toLabel;
    private JTextField dateField;
    private JComboBox<String> comboBox;

    public LabelTextFieldComboBoxExample() {
        // Set up the main frame
        setTitle("Label, TextField, ComboBox Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the panel
        JPanel panel = new JPanel();
        addComponents(panel);

        // Add the panel to the frame
        add(panel);

        // Set the frame to be visible
        setVisible(true);
    }

    private void addComponents(JPanel panel) {
        panel.setLayout(new GridLayout(3, 2));

        // From label and text field
        fromLabel = new JLabel("From:");
        JTextField fromTextField = new JTextField();
        panel.add(fromLabel);
        panel.add(fromTextField);

        // To label and text field
        toLabel = new JLabel("To:");
        JTextField toTextField = new JTextField();
        panel.add(toLabel);
        panel.add(toTextField);

        // Date label and text field
        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField();
        panel.add(dateLabel);
        panel.add(dateField);

        // ComboBox
        JLabel comboBoxLabel = new JLabel("Select:");
        String[] options = {"Option 1", "Option 2", "Option 3"};
        comboBox = new JComboBox<>(options);
        panel.add(comboBoxLabel);
        panel.add(comboBox);
    }

    public static void main(String[] args) {
        // Create the UI on the event dispatch thread
        SwingUtilities.invokeLater(() -> new LabelTextFieldComboBoxExample());
    }
}
