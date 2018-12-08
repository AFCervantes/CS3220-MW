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

@WebServlet("/requests/EditComment")
public class EditComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private GuestBookEntry getEntry(int id) {
		
		// Get a reference to the guest book
		ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
		
		// Find the entry that matches the specified ID
		for(GuestBookEntry entry : guestbookEntries) {
			if (entry.getId() == id)
				return entry;
		}
		
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry entry = getEntry(id);
		
		// If we can't find the entry specified, send the user back to the guest book
		if(entry == null) {
			response.sendRedirect("GuestBook");
			return;
		}
		
		response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Edit Comment</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        
        out.println("<h1>Edit Comment</h1>");
        out.println("<form action=\"EditComment\" method=\"post\">");
        out.println(" 	Name: <input type=\"text\" name=\"name\" value=\"" + entry.getName() + "\"> <br>");
        out.println(" 	Message: <br>");
        out.println(" 	<textarea name=\"message\">" + entry.getMessage() + "</textarea><br>");
        out.println("   <input type=\"hidden\" name=\"id\" value=\"" + entry.getId() + "\">");
        out.println(" 	<input type=\"submit\" name=\"submitBtn\" value=\"Save Comment\">");
        
        out.println("</form>");
       
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry entry = getEntry(id);
		
		entry.setName(name);
		entry.setMessage(message);
		
		// Go back to guest book
		response.sendRedirect("GuestBook");
		
	}

}
