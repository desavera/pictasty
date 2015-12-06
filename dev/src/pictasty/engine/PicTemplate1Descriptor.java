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


public class PicTemplate1Descriptor {

    public static Font TEMPLATE_1_DEFAULT_FONT = new Font(FontFamily.HELVETICA, 16, Font.BOLD, new BaseColor(108, 153, 235));
    public static String TEMPLATE_1_REPLACEMENT_LAYER_NAME = "DESAFIO";

    // this is a hardcode for template#1
    public static int TEMPLATE_1_Xi = 50;
    public static int TEMPLATE_1_Xf = 500;
    public static int TEMPLATE_1_Yi = 685;
    public static int TEMPLATE_1_Yf = 715;

    
    int Xi,Xf,Yi,Yf;
    Font font = TEMPLATE_1_DEFAULT_FONT;
    String replacementLayerName = TEMPLATE_1_REPLACEMENT_LAYER_NAME;

    public PicTemplate1Descriptor() {

        this.Xi = TEMPLATE_1_Xi;
        this.Xf = TEMPLATE_1_Xf;
        this.Yi = TEMPLATE_1_Yi;
        this.Yf = TEMPLATE_1_Yf;
    }

}
