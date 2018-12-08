package requests;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/requests/DeleteComment")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the id of the entry to be deleted
		int id = Integer.parseInt( request.getParameter("id"));
		
		// Get a reference to the guest book
		ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
				
		// Remove the element that matches the specified ID
		for (GuestBookEntry entry : guestbookEntries) {
			if (entry.getId() == id) {
				guestbookEntries.remove(entry);
				break;
			}
		}
		
		// Redirect the User back to the main page
		response.sendRedirect("GuestBook");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
