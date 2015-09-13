package pictasty.server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.itextpdf.text.DocumentException;

import pictasty.engine.*;

public class PicReplacerServlet extends HttpServlet {

    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      ServletContext cntx= getServletContext();
      String inputFileName = cntx.getRealPath("data/pictasty-desafio.pdf");
      String outputFileName = cntx.getRealPath("data/pictasty-desafio-out.pdf");

      String logoPhrase = request.getParameter("logophrase");

      try {

      PicFileReplacer.replace(inputFileName,outputFileName,new PicTemplateDescriptor(),new PicDataSource(logoPhrase));

      } catch (DocumentException ex) {

               response.getOutputStream().write(ex.toString().getBytes());
      }

      // retrieve mimeType dynamically
      String mime = cntx.getMimeType(outputFileName);
      if (mime == null) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return;
      }

      response.setContentType(mime);

      File outputfile = new File(outputFileName);
      response.setContentLength((int)outputfile.length());

      FileInputStream outputFileStream = new FileInputStream(outputFileName);
      OutputStream out = response.getOutputStream();

      // Copy the contents of the file to the output stream
       byte[] buf = new byte[1024];
       int count = 0;
       while ((count = outputFileStream.read(buf)) >= 0) {
         out.write(buf, 0, count);
      }
    
      out.close();

    }

    public void destroy() {
        // do nothing.
    }
}

