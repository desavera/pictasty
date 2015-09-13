/*
 * Pictasty
 * 
 * PicLayerFactory - given a template and a data source this component will 
 * generate a new Layer in the template format with the data given.
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */

package pictasty.engine;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Iterator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfImportedPage; 
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfObject; 
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfLayer;



public class PicLayerFactory {

    public static PdfLayer create(PdfWriter writer,
                                  final PicTemplateDescriptor desc,
                                  final PicDataSource dataSource) throws IOException {

        PdfContentByte cb = writer.getDirectContent();

        PdfLayer layer = new PdfLayer("PICTASTY ADDED LAYER", writer);

        writer.lockLayer(layer);

        cb.beginLayer(layer);

        ColumnText.showTextAligned(cb, Element.ALIGN_LEFT, new Phrase(
                dataSource.text), desc.Xi, desc.Yi, 0);
        cb.endLayer();

        return layer;
    }
}
