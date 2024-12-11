 import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.xml.crypto.dsig.spec.XPathType.Filter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Filters extends JPanel{
   
   
    public Filters() {
            
            

            JComboBox<String> dateComboBox = new JComboBox<>();
            DefaultComboBoxModel<String> dateComboBoxModel = new DefaultComboBoxModel<>();

            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

            Calendar startDate = Calendar.getInstance();
            startDate.set(2023, Calendar.JANUARY, 12);

            Calendar endDate = Calendar.getInstance();
            endDate.set(2024, Calendar.APRIL, 21);

            while (startDate.before(endDate)) {
                dateComboBoxModel.addElement(dateFormatter.format(startDate.getTime()));
                startDate.add(Calendar.DATE, 1); // Increment date by one day
            }

            dateComboBox.setModel(dateComboBoxModel);
            this.add(dateComboBox);


            JComboBox<String> trainClassesComboBox = new JComboBox<>();
            trainClassesComboBox.setModel(new DefaultComboBoxModel<>(getIndianTrainClasses()));
            this.add(trainClassesComboBox);
 
        }

        private static String[] getIndianTrainClasses() {
        String[] trainClasses = {
            "First AC (1A)",
            "Second AC (2A)",
            "Third AC (3A)",
            "Sleeper Class (SL)",
            "General Class (GN)",
            "Chair Car (CC)",
            "Second Seating (2S)"
        };
        return trainClasses;
    }

    
}

    


