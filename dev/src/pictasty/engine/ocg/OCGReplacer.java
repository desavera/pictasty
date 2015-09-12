/*
 * Pictasty
 * 
 * PicReplacerTest - given a template this component will 
 * replace its content.
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */


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



public class PicReplacer {


    /** The resulting PDF. */
    public static final String SOURCE
        = "../doc/layer-inspector-in.pdf";
    /** The resulting PDF. */
    public static final String RESULT
        = "../doc/layer-inspector-out.pdf";

    public static void main(String[] args)
        throws IOException, DocumentException {

        // Create a reader
        PdfReader reader = new PdfReader(SOURCE);
        // step 1
        Document document = new Document(PageSize.A5.rotate());
        // step 2
        PdfWriter writer
            = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
                                                                                                                                                                                           1,1           Top

