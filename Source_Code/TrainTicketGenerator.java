import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.BaseColor;

public class TrainTicketGenerator {

   

    public TrainTicketGenerator(int ticketId,int total,int price) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/train_reservation_system";
        String dbUser = "aniket";
        String dbPassword = "aniket47";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            
            String sql = "SELECT * FROM Trains WHERE TrainID = ?";
            
            String sql2 = "Update Trains set TotalSeats=TotalSeats-? where TrainID=?";
            try{
                PreparedStatement ps = connection.prepareStatement(sql2);
                ps.setInt(1, total);
                ps.setInt(2, ticketId);
                int ra = ps.executeUpdate();
                if(ra!=0){
                    System.out.println("Rows Affected "+ra);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(new JFrame(),"Exception Occured: "+e.getMessage());
            }

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, ticketId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream("Tickit/sTrainTicket.pdf"));
                        document.open();

                        Image logo = Image.getInstance("images/rail.png");
                        logo.scaleToFit(200, 100);
                        document.add(logo);

                        PdfUtil pdfUtil = new PdfUtil();

                        document.add(pdfUtil.createParagraph("\n\nTrain Ticket", pdfUtil.getFontBold(28)));
                        document.add(pdfUtil.createParagraph("\nTicket ID: " + resultSet.getInt("TrainID"), pdfUtil.getFont(22)));
                        document.add(pdfUtil.createParagraph("\nTotal Passengers: " + total, pdfUtil.getFont(22)));
                        document.add(pdfUtil.createParagraph("\nTrain Name: " + resultSet.getString("TrainName"), pdfUtil.getFont(22)));
                        document.add(pdfUtil.createParagraph("\nDeparture Time: " + resultSet.getString("DepartureTime"), pdfUtil.getFont(22)));
                        document.add(pdfUtil.createParagraph("\nPrice: " + price, pdfUtil.getFont(22)));
                        document.add(pdfUtil.createParagraph("\nTrain Booking Successful ", pdfUtil.getFontBold(22),BaseColor.RED));
                        document.close();

                        JOptionPane.showMessageDialog(new JFrame(),"Train ticket generated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(),"Ticket not found!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new TrainTicketGenerator(8,4,500);
    }

   
}
