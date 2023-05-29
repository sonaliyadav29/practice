package com.mphasis.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.dao.StudentDAO;
import mphasis.com.pojo.Student;

/**
 * Servlet implementation class ReadStudent
 */
public class ReadStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao=new StudentDAO();
		PrintWriter pw=response.getWriter();
		try {
			List<Student> list=dao.displaystudent();
			response.setContentType("text/html");
			pw.print("<html><body><center><h1><i>StudentDetails</i></h1></center>");
			pw.print("<table border='1' align='center'>"
					+ "<tr><th>Studentid</th><th>Studentname</th><th>Studentemail</th><th>Edit Student</th><th>Delete Student</th></tr>");
			for(Student student:list) {
				pw.print("<tr><td>"+student.getSid()+"</td><td>"+student.getSname()+"</td><td>"+student.getSemail()+"</td><td><a href='./EditStudent?id="+student.getSid()+"'>EditStudentName</a></td><td><a href='./DeleteStudent?id="+student.getSid()+"'>DeleteStudent</a></td></tr>");
			}
			pw.print("</table></body></html>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

