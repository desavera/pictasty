/* PicTasty
 * 
 * PicReplacer - a content replacement component. The output stream 
 * holds the input stream content replaced.
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */

package pictasty.engine;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
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

import com.itextpdf.awt.geom.AffineTransform;


public class PicFileReplacer {


    public static void replace(String inputFileName,String outputFileName,PicTemplate1Descriptor desc,PicDataSource data) throws DocumentException,IOException {

        FileInputStream input = new FileInputStream(inputFileName);
        FileOutputStream output = new FileOutputStream(outputFileName);

        PdfReader reader = new PdfReader(input);
        Document document = new Document(PageSize.A5.rotate());
      
        document.open();
       
        PdfStamper stamper = new PdfStamper(reader,output);

        Map<String, PdfLayer> layers = stamper.getPdfLayers();
        
        int count = 0;

        for(Iterator<String> it = layers.keySet().iterator(); it.hasNext();) {

            String layerName = it.next();

            if (layerName.compareTo(desc.replacementLayerName) == 0) {

                PdfLayer layer = layers.get(layerName);
                layer.setOn(false);
            }
        }

        // this is a hardcode for template#1

        PdfContentByte content = stamper.getOverContent(1);
        ColumnText ct = new ColumnText(content);
        ct.setSimpleColumn(desc.Xi,desc.Yf,desc.Xf,desc.Yi);
        ct.setText(new Phrase(data.text,desc.font));
        ct.go();

        stamper.close();
        reader.close();
    }

    public static void replace(String inputFileName,String outputFileName,PicTemplate2Descriptor desc,PicImageSource data) throws DocumentException,IOException {

        FileInputStream input = new FileInputStream(inputFileName);
        FileOutputStream output = new FileOutputStream(outputFileName);

        PdfReader reader = new PdfReader(input);
        Document document = new Document(PageSize.A5.rotate());
      
        document.open();
       
        PdfStamper stamper = new PdfStamper(reader,output);

        Map<String, PdfLayer> layers = stamper.getPdfLayers();
        
        // this is a hardcode for template#2

        PdfContentByte content = stamper.getOverContent(1);
	//data.image.setAbsolutePosition(desc.X,desc.Y);

   	AffineTransform at = AffineTransform.getTranslateInstance(630,320);
       	at.concatenate(AffineTransform.getScaleInstance(data.image.getScaledWidth()/4, data.image.getScaledHeight()/8));
       	at.concatenate(AffineTransform.getShearInstance(.35,-.95));
       	content.addImage(data.image, at);


        //content.addImage(data.image,desc.transform);
        //content.addImage(data.image);

        stamper.close();
        reader.close();
    }

    public static void replace(String inputFileName,String outputFileName,PicTemplate3Descriptor desc,PicImageSource data) throws DocumentException,IOException {

        FileInputStream input = new FileInputStream(inputFileName);
        FileOutputStream output = new FileOutputStream(outputFileName);

        PdfReader reader = new PdfReader(input);
        Document document = new Document(PageSize.A5.rotate());
      
        document.open();
       
        PdfStamper stamper = new PdfStamper(reader,output);

        Map<String, PdfLayer> layers = stamper.getPdfLayers();
        
        // this is a hardcode for template#2

        PdfContentByte content = stamper.getOverContent(1);
	//data.image.setAbsolutePosition(desc.X,desc.Y);

        //AffineTransform at = AffineTransform.getTranslateInstance(2624,520);
        //AffineTransform at = AffineTransform.getTranslateInstance(1900,650);

       	//desc.transform.concatenate(AffineTransform.getScaleInstance(data.image.getScaledWidth()*4, data.image.getScaledHeight()*2));
       	//desc.transform.concatenate(AffineTransform.getShearInstance(.2,.95));

        //AffineTransform at = AffineTransform.getScaleInstance(desc.width(),desc.height()*.86);
       	//at.concatenate(AffineTransform.getShearInstance(.58,0));
       	//at.concatenate(AffineTransform.getRotateInstance(.52));
       	//at.concatenate(AffineTransform.getTranslateInstance(desc.X2,desc.MAX_HEIGHT - desc.Y2));
       	//at.concatenate(AffineTransform.getTranslateInstance(20,20));
        AffineTransform at = AffineTransform.getTranslateInstance(1950,765);
        at.scale(desc.width(),desc.height()*.86);
        at.scale(.47,.47);
        at.shear(-.58,0);
        //at.shear(-1.73,0);
        at.rotate(.52);
       	content.addImage(data.image, at);


        //content.addImage(data.image,desc.transform);
        //content.addImage(data.image);

        stamper.close();
        reader.close();
    }
}
