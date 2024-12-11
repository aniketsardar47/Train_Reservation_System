import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.BaseColor;

public class PdfUtil {

    public static Phrase createParagraph(String text, Font font, BaseColor color) {
        Phrase phrase = new Phrase(text, font);
        phrase.add(new Chunk(" ", font)); // Add a space to separate text and colored background
        phrase.add(new Chunk("\u00a0", new Font(Font.FontFamily.UNDEFINED, 8, Font.UNDEFINED, color))); // Add colored background
        return phrase;
    }

    public static Phrase createParagraph(String text, Font font) {
        return new Phrase(text, font);
    }

    public static Font getFont(int size) {
        return new Font(Font.FontFamily.TIMES_ROMAN, size);
    }

    public static Font getFontBold(int size) {
        return new Font(Font.FontFamily.TIMES_ROMAN, size, Font.BOLD);
    }
}
