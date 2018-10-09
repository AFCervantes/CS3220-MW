package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.Assignment;

import models.Student;

@WebServlet(urlPatterns = {"/students/Login"}, loadOnStartup = 1)
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		// Create John Doe
		Student student1 = new Student("John Doe", "john@doe.com", "abcd");
		ArrayList<models.Assignment> assignments1 = student1.getAssignments();
		assignments1.add(new models.Assignment("Lab 1", 100.0));
		assignments1.add(new models.Assignment("Lab 2", 87.2));
		assignments1.add(new models.Assignment("Lab 3", 47.7));
		
		// Create Mary Jane
		Student student2 = new Student("Mary Jane", "mary@jane.com", "abcd");
		ArrayList<models.Assignment> assignments2 = student2.getAssignments();
		assignments2.add(new models.Assignment("Lab 1", 99.2));
		assignments2.add(new models.Assignment("Lab 2", 97.4));
		assignments2.add(new models.Assignment("Lab 3", 64.7));
		
		// Create the list of students
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(student1); // Add John
		students.add(student2);	// Add Mary
		
		// Add the list of students to the APPLICATION scope (Also known as the GLOBAL scope)
		getServletContext().setAttribute("students", students);
	
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
		out.println("    <title>Document</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Login</h1>");
		
		String error = (String) request.getAttribute("error");
		
		if (error != null)
			out.println("<p class=\"text-danger\">" + error + "</p>");
		
		out.println("<form action=\"Login\" method=\"post\">");
		out.println("  E-mail: <input type=\"text\" name=\"email\"><br>");
		out.println("  Password: <input type=\"password\" name=\"password\"><br>");
		out.println("  <input type=\"submit\" name=\"loginBtn\" value=\"Login\"><br>");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Get the list of Students
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		
		// Find the student matching the credentials entered
		for (Student student : students) {
			if (student.getEmail().matches(email) && student.getPassword().matches(password)) {
				
				// Get a reference to the session
				HttpSession session = request.getSession();
				
				// Add the Student to the SESSION Scope
				session.setAttribute("currentStudent", student);
				
				// Send the student, who is now "Logged In", to the Student-Only page
				response.sendRedirect("Grades");
				
				return;
			}
		}
		
		// If the credentials were bad, set an ERROR attribute in the REQUEST Scope
		request.setAttribute("error", "Invalid email and/or password");
		
		// Re-display the form
		doGet(request, response);
	}

}
