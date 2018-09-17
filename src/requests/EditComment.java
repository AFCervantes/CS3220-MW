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

/**
 * Servlet implementation class EditComment
 */
@WebServlet("/requests/EditComment")
public class EditComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private GuestBookEntry getEntry(int id) {
		
		ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
		
		for(GuestBookEntry entry : guestbookEntries) {
			if (entry.getId() == id)
				return entry;			
		}
		
		return null;
	}
	
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		int id = Integer.parseInt( request.getParameter("id"));
 		
 		GuestBookEntry entry = getEntry(id);
 		
 		if (entry == null) {
 			response.sendRedirect("GuestBook");
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
		out.println("    <title>Edit Comment</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<h1>Edit Comment</h1>");
		
		out.println("<form action=\"EditComment\" method=\"post\">");
		out.println("	Name: <input type=\"text\" name=\"name\" value=\"" + entry.getName() + "\"> <br>");
		out.println("	Message: <br>");
		out.println("	<textarea name=\"message\">" + entry.getMessage() + "</textarea> <br>");
		out.println("	<input type=\"submit\" name=\"submitBtn\" value=\"Save Comment\">");
		
		// Use the hidden input type		
		out.println("   <input type=\"hidden\" name=\"id\" value=\"" + entry.getId() + "\">");
		
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");		
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the id from the hidden form field
		int id = Integer.parseInt( request.getParameter("id"));
		
		// Get the updated name and message
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		// Get a reference to the entry we are editing
		GuestBookEntry entry = getEntry(id);
		
		// Update the entry with the new name and/or message
		entry.setName(name);
		entry.setMessage(message);
		
		// Redirect the User back to guest book
		response.sendRedirect("GuestBook");
	}

}





