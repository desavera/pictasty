package pictasty.server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;

import com.itextpdf.text.DocumentException;


import pictasty.engine.*;

//@WebServlet(name = "PicUploaderServlet", urlPatterns = {"/uploader"})
@MultipartConfig
public class PicUploaderServlet extends HttpServlet {

    //private final static Logger LOGGER = 
     //       Logger.getLogger(PicUploaderServlet.class.getCanonicalName());


    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) 
        throws ServletException, IOException {

        processRequest(request,response);
    }

    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) 
        throws ServletException, IOException {

        processRequest(request,response);

    }

    protected void processRequest(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

        //response.setContentType("text/html;charset=UTF-8");

        ServletContext cntx= getServletContext();


        String templateFileName = cntx.getRealPath("data/pictasty-template1.pdf");
        String finalFileName = cntx.getRealPath("data/pictasty-output.pdf");

        // Create path components to save the file
        final String path = request.getParameter("destination");
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            //writer.println("Hey New file " + fileName + " created at " + path);
            //LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                    //new Object[]{fileName, path});

            PicFileReplacer.replace(templateFileName,finalFileName,new PicTemplate2Descriptor(),new PicImageSource(new String(path + File.separator + fileName).toString()));

	    response.sendRedirect("data/pictasty-output.pdf");

        } catch (DocumentException ex) {

               response.getOutputStream().write(ex.toString().getBytes());

        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

            //LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                    //new Object[]{fne.getMessage()});
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}

