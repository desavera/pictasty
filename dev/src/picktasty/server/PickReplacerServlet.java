package picktasty.server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PickReplacerServlet extends HttpServlet {

    private String logoName;

    public void init() throws ServletException {
        logoName = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + logoName + "</h1>");
    }

    public void destroy() {
        // do nothing.
    }
}

/*

public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

       ServletContext cntx= getServletContext();
      // Get the absolute path of the image
      String filename = cntx.getRealPath("Images/button.png");
      // retrieve mimeType dynamically
      String mime = cntx.getMimeType(filename);
      if (mime == null) {
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return;
      }

      resp.setContentType(mime);
      File file = new File(filename);
      resp.setContentLength((int)file.length());

      FileInputStream in = new FileInputStream(file);
      OutputStream out = resp.getOutputStream();

      // Copy the contents of the file to the output stream
       byte[] buf = new byte[1024];
       int count = 0;
       while ((count = in.read(buf)) >= 0) {
         out.write(buf, 0, count);
      }
    out.close();
    in.close();

}
*/
