/*
 * Pictasty
 * 
 * PicDataSource - a data source to hold a map with 
 * file slots as its key.
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */

package pictasty.engine;

import java.io.*;
import com.itextpdf.text.Image;

public class PicImageSource {

    Image image;

    public PicImageSource(String file_path) {

	try {
    		image = Image.getInstance(file_path);

        } catch (Exception e) {

  		System.out.println("Unable to read from file_path...");
	 	e.printStackTrace();
	}
    }
}
