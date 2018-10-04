package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.GuestBookEntry;

@WebServlet("/sessions/AddCommentWithSessions")
public class AddCommentWithSessions extends HttpServlet {
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
		out.println("    <title>Add Comment</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Add Comment <small>with Sessions</small></h1>");
		out.println("<form action=\"AddCommentWithSessions\" method=\"post\">");		
		
		// Instead of getting the name from the cookie, let's check to see if the name
		// exists in the session
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		// If the name didn't exist in the session, then the value will be null.
		// So, we'll display the input form element. Otherwise, we just display the User's name
		if (name == null)
			out.println("	Name: <input type=\"text\" name=\"name\"> <br>");
		else
			out.println("<strong>" + name + "</strong> <br>");
		
		out.println("	Message: <br>");		
		out.println("	<textarea name=\"message\"></textarea> <br>");			
		out.println("	<input type=\"submit\" name=\"submitBtn\" value=\"Add Comment\">");
		out.println("</form>");
				
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("submitBtn") != null) {
			
			// Read the name and the message that was submitted by the form
			String name = request.getParameter("name");
			String message = request.getParameter("message");
			
			if (name == null)
				name = (String) request.getSession().getAttribute("name");
			
			boolean isValidName = name != null && name.trim().length() > 0;
			boolean isValidMessage = message != null && message.trim().length() > 0;
			
			// Add new entry to the guest book
			if (isValidName && isValidMessage) {
				// get a reference to the array list of guest book entries
				ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
				
				// Create a new entry and add it to the guestbook
				guestbookEntries.add(new GuestBookEntry(name, message));
				
				// Add the 'name' attribute to the session
				request.getSession().setAttribute("name", name);
				
			} 
			else {
				
				// Problem with the name?
				if (!isValidName)
					request.setAttribute("nameError", "Invalid Name");
			
				if (!isValidMessage)
					request.setAttribute("messageError", "Invalid Message");
				
				doGet(request, response);
				return;
			}
			
		}
		
		// Redirect the User back to the main guestbook page
		response.sendRedirect("../requests/GuestBook");
	}

}
