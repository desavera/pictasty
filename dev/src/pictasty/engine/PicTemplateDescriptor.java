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

public class PicTemplateDescriptor {

    
    int Xi,Xf,Yi,Yf;

    public PicTemplateDescriptor(int Xi,int Xf,int Yi,int Yf) {

        this.Xi = Xi;
        this.Xf = Xf;
        this.Yi = Yi;
        this.Yf = Yf;
    }

}
