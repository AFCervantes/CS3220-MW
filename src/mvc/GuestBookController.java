package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/mvc/GuestBook")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ArrayList<GuestBookEntry> guestbookEntries = new ArrayList<GuestBookEntry>();
		
		guestbookEntries.add(new GuestBookEntry("John Doe", "Hello"));
		guestbookEntries.add(new GuestBookEntry("Mary Jane", "Hi"));
		guestbookEntries.add(new GuestBookEntry("Joe Boxer", "Howdy"));
		
		getServletContext().setAttribute("guestbookEntries", guestbookEntries);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/mvc/GuestBook.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
