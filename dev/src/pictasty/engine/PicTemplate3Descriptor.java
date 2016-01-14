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

public class PicTemplate3Descriptor {

    public static String LAYER_NAME = "DESAFIO";

    // this is a hardcode for template#3
    public static double X1 = 812;
    public static double Y1 = 1180;
    public static double X2 = 2624;
    public static double Y2 = 2320;
    public static double X5 = 3992;
    public static double Y5 = 1632;
    public static double X3 = X1;
    public static double Y3 = Y2;
    public static double X4 = X5;
    public static double Y4 = Y2;

    public static double MAX_HEIGHT = 3149;

    
    public PicTemplate3Descriptor() {


    }

    public double width() {

        return Math.sqrt((X5 - X2)*(X5 - X2) + (Y5 - Y4)*(Y5 - Y4));
    }

    public double height() {

        return Math.sqrt((Y1 - Y3)*(Y1 - Y3) + (X2 - X3)*(X2 - X3));
    }

}
