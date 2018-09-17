package intro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/CurrentDateAndTime"}, loadOnStartup=1)
public class CurrentDateAndTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// This code executes once for the life of this particular servlet
		
		int count = 0;  // This is a local variable
		
		// Get a reference to the Servlet Context
		ServletContext context = this.getServletContext();
		
		// Add the count to the servlet context (it's auto boxed as an Integer object)
		context.setAttribute("dateAndTimeCounter", count);		
				
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get a reference to the servlet context
		ServletContext context = this.getServletContext();
		
		// Get a reference to the current count
		int count = (Integer) context.getAttribute("dateAndTimeCounter");
		
		// Increment the counter
		count++;
		
		// Because I update the count in a local variable, I have to overwrite the
		// value stored in the servlet context
		context.setAttribute("dateAndTimeCounter", count);
		
		
		// Set my content type
		response.setContentType("text/html");
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our content
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>Current Date and Time</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Current Date and Time</h1>");
		out.println("<p class=\"lead\">The current date and time is: " + new Date() + "</p>");
		out.println("<a class=\"btn btn-primary\" href=\"DateAndTimeMetrics\">View Metrics</a>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
