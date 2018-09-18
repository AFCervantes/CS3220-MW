package requests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requests/SimpleAdder")
public class SimpleAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
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
		out.println("    <title>Simple Adder</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		// Read the values of the num1 and num2 request parameters
		// Remember, the values are read as STRINGS
		String strNum1 = request.getParameter("num1");
		String strNum2 = request.getParameter("num2");
		
		// Validate the input
			
		try {
			int sum = Integer.parseInt(strNum1) + Integer.parseInt(strNum2);
			out.println(strNum1 + " + " + strNum2 + " = " + sum);
		} catch (Exception e) {		
			out.println("Please specify two integral values");
		}
		
		out.println("<a href=\"../SimpleAdder.html\">Add Again</a>");
		
		
		
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
