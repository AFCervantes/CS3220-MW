package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/requests/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Add Comment</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        
        
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        
        if (name == null)
        	name = "";
        
        message = message == null ? "" : message;
        
        out.println("<h1>Add Comment</h1>");
        out.println("<form action=\"AddComment\" method=\"post\">");
        out.println(" 	Name: <input type=\"text\" name=\"name\" value=\"" + name + "\"> <br>");
        
        if (request.getAttribute("nameError") != null)
        	out.println("   <p class=\"text-danger\">Please enter a name</p>");
        
        out.println(" 	Message: <br>");
        out.println(" 	<textarea name=\"message\">" + message + "</textarea><br>");
        
        if (request.getAttribute("messageError") != null)
        	out.println("   <p class=\"text-danger\">Please enter a message</p>");
        
        out.println(" 	<input type=\"submit\" name=\"submitBtn\" value=\"Add Comment\">");
        out.println("</form>");
       
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Read the values of name and message from the request
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		boolean isValidName = name != null && name.trim().length() > 0;
		boolean isValidMessage = message != null && message.trim().length() > 0;
		
		if (isValidName && isValidMessage) {
			// Get a reference to the guest book
			ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
			
			// Add a new entry
			guestbookEntries.add(new GuestBookEntry(name, message));
			
			// Redirect the User back to the main page
			response.sendRedirect("GuestBook");
		}
		else {
			
			if (!isValidName)
				request.setAttribute("nameError", true);
			
			if (!isValidMessage)
				request.setAttribute("messageError", true);
			
			
			doGet(request, response);
			return;
			
		}
		
		
	}

}
