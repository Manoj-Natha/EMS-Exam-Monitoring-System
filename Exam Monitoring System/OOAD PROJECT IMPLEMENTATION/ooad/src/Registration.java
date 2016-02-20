

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class Registration
 */
@SuppressWarnings("unused")
// Registration to register for the exam by choosing the time slot and also getting the printed hall ticket.
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// Get all the details and prints the hall ticket when print is pressed establish connection with database
	// to register a candidate for a GRE Exam
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String locations=request.getParameter("location");
		String date=request.getParameter("testdate");
		String timing=request.getParameter("timing");
		String title="HallTicket";
		System.out.println("\n" + uname + "\n" + locations);
		PrintWriter out=response.getWriter();
		Connection con;
		ResultSet re;
		PreparedStatement stmt;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
		String sql=("insert into register values (?,?,?,?)");
		stmt=con.prepareStatement(sql);
		stmt.setString(1,uname);
		stmt.setString(2,date);
		stmt.setString(3,locations);
		stmt.setString(4,timing);
		stmt.executeUpdate();
		sql="select * from student where username=?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,uname);
		re=stmt.executeQuery();
		if(re.next()) {
			response.setContentType("text/html");
			String roll=re.getString(1);
			String f_name=re.getString(2);
			String l_name=re.getString(3);
			String dob=re.getString(4);//Need to change later
			String email=re.getString(8);
			String mobile=re.getString(7);
			out.println("<html> \n" +
						"<head>\n"+
						"<title>" + title + "</title>\n" +
						"<script>\n" +
						"function printer() {\n" +
						"window.print();\n" +
						"}\n" +
						"</script>\n" +
						"</head>\n" +
						"<body bgcolor=\"bisque\">\n" +
						"<center>\n" +
						"<br />\n" +
						"<h4>Please print this hall ticket and bring it during the exam</h4>\n" +
						"<br />\n" +
						"<table cellspacing=10 cellpadding=10 border=1>\n" +
						"<tr>\n" +
						"<td> First Name:" + "</td>\n" +
						"<td>" + f_name + "</td>\n" +
						"</tr>\n"+
						"<tr>\n" +
						"<td> Last Name: </td>\n" +
						"<td>" + l_name + "</td>\n" +
						"</tr>\n" +
						"<tr>\n" +
						"<td> Registration no: </td>\n" +
						"<td>" + roll + "</td>\n" +
						"</tr>\n" +
						"<tr>\n" +
						"<td> Date of Birth: </td>\n" +
						"<td>" + dob + "</td>\n" +
						"</tr>\n" +
						"<tr>\n" +
						"<td> Email: </td>\n" +
						"<td>" + email + "</td>\n" +
						"</tr>\n" +
						"<tr>\n" +
						"<td> Mobile number: </td>\n" +
						"<td>" + mobile + "</td>\n" +
						"</tr>\n" +
						"<tr>\n" +
						"<td> Exam date: </td>\n" +
						"<td>" + date + "</td>\n" +
						"</tr>\n" +
						"<tr>\n" +
						"<td> Exam Location: </td>\n" +
						"<td>" + locations + "</td>\n" +
						"</tr>\n" +
						"<tr>\n" +
						"<td> Exam Time: </td>\n" +
						"<td>" + timing + "</td>\n" +
						"</tr>\n" +
						"</table>\n" +
						"<br />\n" +
						"This is a computer generated hall ticket and hence does not require any signature\n" +
						"<br />" +
						"<button onclick=\"printer()\">Print</button>\n" +
						"</center>\n" +
						"</body>\n" +
						"<html>"
					);
						
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
