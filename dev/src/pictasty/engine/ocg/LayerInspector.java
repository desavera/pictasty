import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Iterator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfLayer;



public class LayerInspector {


    /** The resulting PDF. */
    public static String SOURCE
        = "";
    /** The resulting PDF. */
    public static String RESULT
        = "layer-out.pdf";

    public static void main(String[] args)
        throws IOException, DocumentException {

        SOURCE = args[0];

        // Create a reader
        PdfReader reader = new PdfReader(SOURCE);
        // step 1
        Document document = new Document(PageSize.A5.rotate());
        // step 2
        PdfWriter writer
            = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4


	LayerCounter.count(reader);

        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(RESULT));

        Map<String, PdfLayer> layers = stamper.getPdfLayers();

        int count = 0;

        System.out.println("Will loop through ... \n");
	System.out.println("no layers ? " + layers.isEmpty());

        for(Iterator<String> it = layers.keySet().iterator(); it.hasNext();) {

            System.out.println("Layer # " + count++);
            String key = it.next();
            PdfLayer value = layers.get(key);
            System.out.printf("%s = %d%n", key, value.type());
        }

        //PdfLayer layer = layers.get("PUT DESIGN HERE #2");
        //PdfLayer layer = layers.get("71");

        // step 5
        //document.close();
        reader.close();
    }
}
