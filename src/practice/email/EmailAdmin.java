package practice.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailAdmin
 */
@WebServlet("/practice/admin")
public class EmailAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean download = request.getParameter("download") != null;
		
		// Set my content type
		if (download) {
			response.setContentType("application/vnd.ms-excel");
	        response.setHeader( "Content-Disposition",
	                "inline; filename=emails.xls" );
		}
		else {
			response.setContentType("text/html");
		}
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our content
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>Email Admin</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Mailing List</h1>");
		
		if (!download) {
			out.println("<div class=\"text-right\">");
			out.println("  <a class=\"btn btn-primary\" href=\"admin?download=xls\">Download XLS</a>");
			out.println("</div>");
		}
		
		out.println("<table class=\"table table-bordered table-striped table-hover\">");
		out.println("  <tr><th>E-mail Address</th><th>Subscribed</th></tr>");
		
		ArrayList<Subscriber> subscribers = (ArrayList<Subscriber>) getServletContext().getAttribute("subscribers");
		for (Subscriber subscriber : subscribers) {
			out.println("<tr><td><a href=\"mailto:" + subscriber.getEmail() + "\">" + subscriber.getEmail() + "</a></td><td>" + subscriber.getDate() + "</td></tr>");		
		}
		
		out.println("</table>");

		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
