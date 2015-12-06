/*
 * PicTasty
 * 
 * PicReplacerTest - a layer replacement test case. T
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */

package pictasty.engine;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Iterator;

import com.itextpdf.text.DocumentException;


public class PicFileReplacerTest {


    public static String RESULT1 = "layer-out-1.pdf";
    public static String RESULT2 = "layer-out-2.pdf";

    public static void main(String[] args)
        throws IOException, DocumentException {

        PicFileReplacer.replace(args[0],RESULT1,new PicTemplate1Descriptor(),new PicDataSource(args[1]));
        PicFileReplacer.replace(args[0],RESULT2,new PicTemplate2Descriptor(),new PicImageSource(args[1]));

    }

}

