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
		
		ArrayList<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		
		entries.add(new GuestBookEntry(1, "John Doe", "Hello, World!"));
		entries.add(new GuestBookEntry(2, "Mary Jane", "Howdy!"));
		entries.add(new GuestBookEntry(3, "Joe Boxer", "Hi!"));
		
		getServletContext().setAttribute("entries", entries);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/WEB-INF/mvc/GuestBook.jsp" )
				.forward(request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
