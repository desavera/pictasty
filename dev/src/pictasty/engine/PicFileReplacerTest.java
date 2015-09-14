/*
 * PicTasty
 * 
 * PicReplacerTest - a layer replacement test case. T
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Iterator;

import com.itextpdf.text.DocumentException;



import pictasty.engine.*;

public class PicFileReplacerTest {


    public static String RESULT = "layer-out.pdf";

    public static void main(String[] args)
        throws IOException, DocumentException {

        PicFileReplacer.replace(args[0],RESULT,new PicTemplateDescriptor(),new PicDataSource(args[1]));

    }

}
