package requests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Request Info</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        

        out.println("<table class=\"table table-bordered table-striped table-hover\">");
        out.println("  <tr>");
        out.println("    <th>Header</th>");
        out.println("    <th>Value</th>");
        out.println("  </tr>");
        
        // Display the Request Method
        out.println("  <tr>");
        out.println("    <td>Request Method</td>");
        out.println("    <td>" + request.getMethod() + "</td>");
        out.println("  </tr>");
        
        // Request URI
        out.println("  <tr>");
        out.println("    <td>Request URI</td>");
        out.println("    <td>" + request.getRequestURI() + "</td>");
        out.println("  </tr>");
        
        // Request URL
        out.println("  <tr>");
        out.println("    <td>Request URL</td>");
        out.println("    <td>" + request.getRequestURL() + "</td>");
        out.println("  </tr>");
        
        // Context Path
        out.println("  <tr>");
        out.println("    <td>Context Path</td>");
        out.println("    <td>" + request.getContextPath() + "</td>");
        out.println("  </tr>");
        
        // User's Address
        out.println("  <tr>");
        out.println("    <td>Your Address</td>");
        out.println("    <td>" + request.getRemoteAddr() + "</td>");
        out.println("  </tr>");
        
        // Is gzip Supported?
        String encodingHeader = request.getHeader("Accept-Encoding");
        boolean isGzipSupported = encodingHeader.indexOf("gzip") >= 0;
        
        out.println("  <tr>");
        out.println("    <td>GZIP Supported?</td>");
        out.println("    <td>" + isGzipSupported + "</td>");
        out.println("  </tr>");
        
        
        out.println("</table>");
        	
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
