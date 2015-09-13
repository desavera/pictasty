/*
 * PicTasty
 * 
 * PicReplacer - a content replacement component. The output stream 
 * holds the input stream content replaced.
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */

package pictasty.engine;


import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Iterator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfImportedPage; 
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfLayer;



public class PicReplacer {

    public static Font DEFAULT_FONT = new Font(FontFamily.HELVETICA, 16, Font.BOLD, new BaseColor(108, 153, 235));
    public static String REPLACEMENT_LAYER_NAME = "DESAFIO";

    public static int Xi = 50;
    public static int Xf = 500;
    public static int Yi = 685;
    public static int Yf = 715;


    public static void replace(InputStream input,OutputStream output,String newText) throws DocumentException,IOException {

        PdfReader reader = new PdfReader(input);
        Document document = new Document(PageSize.A5.rotate());
      
        document.open();
       
        PdfStamper stamper = new PdfStamper(reader,output);

        Map<String, PdfLayer> layers = stamper.getPdfLayers();
        
        int count = 0;

        for(Iterator<String> it = layers.keySet().iterator(); it.hasNext();) {

            String layerName = it.next();

            if (layerName.compareTo(REPLACEMENT_LAYER_NAME) == 0) {

                PdfLayer layer = layers.get(layerName);
                layer.setOn(false);
            }
        }

        PdfContentByte content = stamper.getOverContent(1);
        ColumnText ct = new ColumnText(content);
        ct.setSimpleColumn(Xi,Yf,Xf,Yi);
        ct.setText(new Phrase(newText,DEFAULT_FONT));
        ct.go();

        stamper.close();
        reader.close();
    }
}

