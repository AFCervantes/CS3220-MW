package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;

@WebServlet("/students/Grades")
public class Grades extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the current student from the SESSION Scope
		Student student = (Student) request.getSession().getAttribute("currentStudent");
		
		// If the current student is null, that means that the User has yet to successfully authenticate
		// via the Login Servlet. So, redirect them back to Login
		if (student == null) {
			response.sendRedirect("Login");
			return;
		}
		
		// Set my content type
		response.setContentType("text/html");
		
		// Get a reference to the Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate our content
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("    <title>" + student.getName() + "'s Grades</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>" + student.getName() + "'s Grades</h1>");
		
		out.println("<table class=\"table table-bordered\">");
		
		// Print the student's scores
		ArrayList<models.Assignment> assignments = student.getAssignments();
		
		for(models.Assignment assignment : assignments) {
			out.println("  <tr>");
			out.println("    <td>" + assignment.getName() + "</td>");
			out.println("    <td>" + assignment.getScore() + "</td>");
			out.println("  </tr>");
		}
		
		out.println("</table>");
		
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
