package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/mvc/AddComment")
public class AddCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/mvc/AddComment.jsp")
					.forward(request, response);
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
				request.setAttribute("nameError", "Please enter your name");
			
			if (!isValidMessage)
				request.setAttribute("messageError", "Please enter a message");
			
			
			doGet(request, response);
			return;
			
		}
		
	}

}
