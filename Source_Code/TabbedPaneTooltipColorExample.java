import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class sample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTabbedPane Tooltip Color Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Create tabs with tooltips
        JPanel tab1 = new JPanel();
        tab1.setToolTipText("Tab 1 Tooltip");
        tabbedPane.add("Tab 1", tab1);

        JPanel tab2 = new JPanel();
        tab2.setToolTipText("Tab 2 Tooltip");
        tabbedPane.add("Tab 2", tab2);

        // Create a custom tooltip renderer
        DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // Set the background color of the tooltip
                component.setBackground(Color.YELLOW); // You can change the color as needed
                return component;
            }
        };

        // Apply the custom renderer to the tabbed pane
        tabbedPane.setTabComponentAt(0, tab1);
        tabbedPane.setTabComponentAt(1, tab2);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
