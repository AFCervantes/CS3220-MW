package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

/**
 * Servlet implementation class AddCommentController
 */
@WebServlet("/mvc/AddComment")
public class AddCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/mvc/AddComment.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("add") != null) {
			
			// Read the name and the message that was submitted by the form
			String name = request.getParameter("name");
			String message = request.getParameter("message");
			
			boolean isValidName = name != null && name.trim().length() > 0;
			boolean isValidMessage = message != null && message.trim().length() > 0;
			
			
			// Add new entry to the guest book
			if (isValidName && isValidMessage) {
				// get a reference to the array list of guest book entries
				ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
				
				// Create a new entry and add it to the guestbook
				guestbookEntries.add(new GuestBookEntry(name, message));
			} 
			else {
				
				// Problem with the name?
				if (!isValidName)
					request.setAttribute("nameError", "Invalid Name");
			
				if (!isValidMessage)
					request.setAttribute("messageError", "Invalid Message");
				
				request.getRequestDispatcher("/WEB-INF/mvc/AddComment.jsp")
					.forward(request, response);
				return;
			}
			
			
			
		}
		
		// Redirect the User back to the main guestbook page
		response.sendRedirect("GuestBook");		
	}

}
