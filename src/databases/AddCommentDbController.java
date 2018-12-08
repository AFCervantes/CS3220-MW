package databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;


@WebServlet("/databases/AddComment")
public class AddCommentDbController extends HttpServlet {
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
			
			Connection c = null; // Defined here for scope
	        try {

	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu120";
	        	
	    		String username = "cs3220stu120";
	    		String password = "";
	    	
	    		// Connect to the database
	    		c = DriverManager.getConnection(url, username, password);
	    		
	    		// Create a statement object
	    		Statement stmt = c.createStatement();
	    		
	    		// Insert the new entry into the database
//	    		String sql = "INSERT INTO `guestbook` (`id`, `name`, `message`) VALUES (NULL, '" + name + "', '" + message + "')";
//	    		System.out.println(sql);
//	    		int rowsAffected = stmt.executeUpdate(sql);
	    		
	    		String sql = "INSERT INTO guestbook (id, name, message) VALUES (NULL, ?, ?)";
	    		PreparedStatement pstmt = c.prepareStatement(sql);
	    		
	    		pstmt.setString(1, name);
	    		pstmt.setString(2, message);
	    		
	    		int rowsAffected = pstmt.executeUpdate();
	    		
	    		System.out.println(rowsAffected + " row(s) affected.");
	 
	        }
	        catch (SQLException e) {
	        	throw new ServletException( e );
	        }
	        finally {
	        	try {
	        		if ( c != null ) c.close();
	        	}
	        	catch( SQLException e) {
	        		throw new ServletException( e );
	        	}
	        }
					
			
			// Redirect the User back to the main page
			response.sendRedirect("Guestbook");
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
