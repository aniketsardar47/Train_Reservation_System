import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class CustomTabbedPaneDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom TabbedPane Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Tab 1", new JPanel());
            tabbedPane.addTab("Tab 2", new JPanel());
            tabbedPane.addTab("Tab 3", new JPanel());

            // Create a custom UI for the JTabbedPane
            tabbedPane.setUI(new CustomTabbedPaneUI());

            frame.add(tabbedPane);
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}

class CustomTabbedPaneUI extends BasicTabbedPaneUI {
    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        // Set the color for the upper line of panes
        g.setColor(Color.RED); // Change to your desired color

        // Determine the bounds of the tab area
        Rectangle tabArea = tabbedPane.getBoundsAt(0);
        tabArea.height = calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);

        // Paint the upper line of panes with the custom color
        g.fillRect(tabArea.x, tabArea.y, tabArea.width, 2);

        // Call the parent method to paint the tab content
        super.paintTabArea(g, tabPlacement, selectedIndex);
    }
}
