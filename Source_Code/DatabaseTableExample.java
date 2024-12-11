import javax.swing.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.*;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.*;

public class DatabaseTableExample extends JPanel{
    public DatabaseTableExample() {
        // Define database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/train_reservation_system";
        String username = "-";
        String password = "-";

        setSize(700,700);

        // Create the database connection
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Create a statement for executing SQL queries
            Statement statement = connection.createStatement();

            // Define your SQL query
            String sqlQuery = "SELECT * FROM Trains";

            // Execute the query and retrieve the result set
            ResultSet resultSet = statement.executeQuery(sqlQuery);


            // Create a JTable to display the data
            
            JTable table = new JTable(buildTableModel(resultSet));
            table.setBackground(Color.green);
            table.setBounds(20,20,700,500);
            table.setFont(new Font("Ariel", Font.BOLD, 15));

            // Set header background color
            JTableHeader header = table.getTableHeader();
            header.setDefaultRenderer(new HeaderRenderer(table));

            table.setSize(700, 600);
            table.setRowHeight(30); // Set cell height to 50
            table.getColumnModel().getColumn(0).setPreferredWidth(100); // Set cell width for column 0 to 100

            // Add the table to a JScrollPane for scrollability
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(800, 600));
            this.add(scrollPane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // Get column names
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }

        // Create a DefaultTableModel and add data to it
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        while (resultSet.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        }

        tableModel.addColumn("Book ");

       

        return tableModel;
    }



    private static class HeaderRenderer extends DefaultTableCellRenderer {
        public HeaderRenderer(JTable table) {
            setHorizontalAlignment(SwingConstants.CENTER);
            setSize(100, 50);
            setBackground(Color.YELLOW); // Set the header background color
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

}

