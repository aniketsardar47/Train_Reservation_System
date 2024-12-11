import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class TrainTicketGeneratorx {

    public static void main(String[] args) {
        generateTrainTicket("John Doe", "Express 123", "2023-11-20 14:30", "A12");
    }

    public static void generateTrainTicket(String passengerName, String trainName, String departureTime, String seatNumber) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("TrainTicket.pdf"));
            document.open();

            // Set fonts
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
            Font infoFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);
            Font labelFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.DARK_GRAY);
            Font valueFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.BLACK);

            // Add title
            Paragraph title = new Paragraph("Train Booking Ticket", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Add passenger information
            document.add(createInfoParagraph("Passenger Name:", passengerName, labelFont, valueFont));
            document.add(createInfoParagraph("Train Name:", trainName, labelFont, valueFont));
            document.add(createInfoParagraph("Departure Time:", departureTime, labelFont, valueFont));
            document.add(createInfoParagraph("Seat Number:", seatNumber, labelFont, valueFont));

            document.close();
            System.out.println("Train ticket generated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Paragraph createInfoParagraph(String label, String value, Font labelFont, Font valueFont) {
        Paragraph paragraph = new Paragraph();
        Chunk labelChunk = new Chunk(label, labelFont);
        Chunk valueChunk = new Chunk(value, valueFont);

        paragraph.add(labelChunk);
        paragraph.add(valueChunk);

        return paragraph;
    }
}
