import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
public class ShowResult extends JFrame{
 Booking b1;
 int currenttrain;
    ShowResult(int result){
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(600, 100);
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/train_reservation_system","-","-");
        String sql = "select * from Trains where TrainID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,result);

        ResultSet rs = ps.executeQuery();

        JTable table = new JTable(buildTableModel(rs));
            table.setBackground(Color.green);
            table.setBounds(20,20,700,200);
            table.setFont(new Font("Ariel", Font.BOLD, 15));

            JTableHeader header = table.getTableHeader();
           header.setDefaultRenderer(new HeaderRenderer(table, this));

            table.setSize(700, 600);
            table.setRowHeight(30); // Set cell height to 50
            table.getColumnModel().getColumn(0).setPreferredWidth(100);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(800, 600));
            this.add(scrollPane);

            JPanel buttonPanel = new JPanel();
            JButton closeButton = new JButton("Book");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   call(result);
                }
            });
            buttonPanel.add(closeButton);

            add(buttonPanel, BorderLayout.SOUTH);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void call(int result){
        this.setVisible(false);
        b1 = new Booking(result);
    }

     public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }


        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        while (resultSet.next()) {
            Object[] rowData = new Object[columnCount + 1];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
        
            tableModel.addRow(rowData);
        }

        return tableModel;
    }



    private static class HeaderRenderer extends DefaultTableCellRenderer {
        private final JTable table;
        private final ShowResult showResult;

        public HeaderRenderer(JTable table, ShowResult showResult) {
            this.table = table;
            this.showResult = showResult;

            setHorizontalAlignment(SwingConstants.CENTER);
            setSize(100, 50);
            setBackground(Color.YELLOW);

            // Add mouse listener to the table header
            table.getTableHeader().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int column = table.columnAtPoint(e.getPoint());
                    // Assuming TrainID is the first column (index 0)
                    if (column == 0) {
                        // Update the currenttrain variable with TrainID
                        showResult.currenttrain = (int) table.getValueAt(0, column);
                        System.out.println("Current TrainID: " + showResult.currenttrain);
                    }
                }
            });
        }
}
}