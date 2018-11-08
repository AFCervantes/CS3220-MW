package mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import models.GuestBookEntry;

@WebServlet("/mvc/Delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ArrayList = null;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		
			for (GuestBookEntry entry : guestbookEntries) {
				if (entry.getId() == id) {
					guestbookEntries.remove( entry );
					break;
				}
			}
		}catch(Exception e) {}
		
		response.sendRedirect("GuestBook");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
