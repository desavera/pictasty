/*
 * Pictasty
 * 
 * LayerInspector - an inspector for a PDF file Layer
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
 
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfLayer;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
 
public class ChangeOCG {
 
    public static final String SRC = "../doc/layer-inspector-in.pdf";
    public static final String DEST = "../doc/layer-inspector-out.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ChangeOCG().manipulatePdf(SRC, DEST);
    }
 
 
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        Map<String, PdfLayer> layers = stamper.getPdfLayers();
        PdfLayer layer = layers.get("names");
        layer.setOn(false);
        stamper.close();
        reader.close();
    }
 
}
