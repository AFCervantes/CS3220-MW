package responses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/responses/Download", "/image.jpg"})
public class Download extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        // Get the path to the file and create a java.io.File object
        String path = getServletContext()
        					.getRealPath( "/WEB-INF/uploads/RandomImage.jpg" );
        File file = new File( path );

        // Set the response headers. File.length() returns the size of the file
        // as a long, which we need to convert to a String.
        response.setContentType( "image/jpg" );
        response.setHeader( "Content-Length", "" + file.length() );
        response.setHeader( "Content-Disposition",
            "inline; filename=FlockOf.jpg" );

        // Binary files need to read/written in bytes.
        FileInputStream in = new FileInputStream( file );
        OutputStream out = response.getOutputStream();
        byte buffer[] = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );
        in.close();
    }

}




