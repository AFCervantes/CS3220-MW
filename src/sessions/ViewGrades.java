package sessions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;


@WebServlet("/students/ViewGrades")
public class ViewGrades extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get the ID of the student who's grades we want to view
		int id = Integer.parseInt(request.getParameter("id"));
		
		// Find the student who matches the id

		// Get the list of Students
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		
		// Find the student matching the credentials entered
		for (Student student : students) {
			if (student.getId() == id) {
				request.getSession().setAttribute("currentStudent", student);
				response.sendRedirect("Grades");
				return;
			}
		}
		
		response.sendRedirect("../ClassRoster.html");;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
