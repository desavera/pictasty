package pictasty.server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PicReplacerServlet extends HttpServlet {

    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      ServletContext cntx= getServletContext();
      // Get the absolute path of the image
      String filename = cntx.getRealPath("data/pictasty-desafio.png");
      // retrieve mimeType dynamically
      String mime = cntx.getMimeType(filename);
      if (mime == null) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return;
      }

      response.setContentType(mime);
      File file = new File(filename);
      response.setContentLength((int)file.length());

      FileInputStream in = new FileInputStream(file);
      OutputStream out = response.getOutputStream();

      // Copy the contents of the file to the output stream
       byte[] buf = new byte[1024];
       int count = 0;
       while ((count = in.read(buf)) >= 0) {
         out.write(buf, 0, count);
      }
    
      out.close();
      in.close();

    }

    public void destroy() {
        // do nothing.
    }
}

