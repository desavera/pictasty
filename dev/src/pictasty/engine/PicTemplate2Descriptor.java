/*
 * Pictasty
 * 
 * PicTemplateDescriptor - a map for the template data to be manipulated.
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */

package pictasty.engine;


import java.util.Map;
import java.util.Iterator;

import com.itextpdf.text.Font;
import com.itextpdf.text.BaseColor; 
import com.itextpdf.text.PageSize;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;

import com.itextpdf.awt.geom.AffineTransform;

public class PicTemplate2Descriptor {

    public static String LAYER_NAME = "DESAFIO";

    // this is a hardcode for template#2
    public static int X = 730;
    public static int Y = 1530;

    public static int X1 = 730;
    public static int Y1 = 1530;
    public static int X2 = 1160;
    public static int Y2 = 1730;
    public static int X3 = 1540;
    public static int Y3 = 1195;
    public static int X4 = 1150;
    public static int Y4 = 1035;

    AffineTransform transform;

    
    public PicTemplate2Descriptor() {

	transform = new AffineTransform();
        //transform.setToShear(1,1);
        transform.setToIdentity();
        transform.setToTranslation(X,Y);

    }

}
