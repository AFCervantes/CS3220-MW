package practice.todos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToggleDone
 */
@WebServlet("/practice/toggleDone")
public class ToggleDone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
//		ArrayList<Todo> todos = (ArrayList<Todo>) getServletContext().getAttribute("todos");
		ArrayList<Todo> todos = (ArrayList<Todo>) request.getSession().getAttribute("todos");
		
		for (Todo todo : todos)
			if (todo.getId() == id) {
				todo.setDone( !todo.isDone() );
				break;
			}
		
		response.sendRedirect("todo");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
