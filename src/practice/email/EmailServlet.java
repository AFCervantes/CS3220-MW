package practice.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/practice/email")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();
		
		getServletContext().setAttribute("subscribers", subscribers);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set my content type
		response.setContentType("text/html");
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our content
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>Subscribe</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Sign-Up for our Newsletter!</h1>");
		
		if (request.getAttribute("subscribed") == null) {			
			out.println("<form action=\"email\" method=\"post\">");
			out.println("  Enter your e-mail: <input type=\"text\" name=\"email\"> <br>");
			out.println("  <input type=\"submit\" name=\"subitBtn\" value=\"Sign-Up!\">");
			out.println("</form>");
		}
		else {
			out.println("<p class=\"lead\"><code>" + request.getParameter("email") + "</code> has been successfully added to our mailing list.</p>");
		}
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		ArrayList<Subscriber> subscribers = (ArrayList<Subscriber>) getServletContext().getAttribute("subscribers");
		
		subscribers.add(new Subscriber(email));
		
		request.setAttribute("subscribed", true);
		
		doGet(request, response);
	}

}











