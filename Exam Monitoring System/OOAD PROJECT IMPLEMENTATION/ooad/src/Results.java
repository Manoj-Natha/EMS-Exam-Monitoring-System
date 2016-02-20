

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;


/**
 * Servlet implementation class Results
 */
public class Results extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Results() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // To send mail to candidate requested for the sendmail use case.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		try {
		
			Connection con;
			Statement stmt;
			ResultSet re,re1,re2;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
			stmt=con.createStatement();
			

	        String rollno=(String)request.getParameter("rollno");
	        //username="manoj123";
	        System.out.println("roll number:"+rollno);
			re1=stmt.executeQuery("select * from result where roll_no="+rollno);
			
			
			out.println("<p> your results is : </p>");
			
			out.println("<table border=\"2\">");
			//while(re.next())
			//{
			re1.next();
			out.println("<tr>");
			out.println("<th>ROll number:</th>");		
			out.println("<th> Score in the test</th>");			
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>"+re1.getString(1)+"</td>");		
			out.println("<td>"+re1.getString(2)+"</td>");			
			out.println("</tr>");
			//}

			out.println("</table>");
			
			HttpSession session=request.getSession();
			session.setAttribute("rollno",rollno);
			
			String score=re1.getString(3);
			
			

			re2=stmt.executeQuery("select email from student where roll_no="+rollno);
			re2.next();
			
			String email=re2.getString(1);
			

			
			out.println("<p>"+"your mail id is "+email+"  and score is"+score+"</p>");

			out.println("<form action=\"sendmail\" method=\"get\">");
			
			out.println("<input type=\"submit\" value=\"send mail\">");
			
			out.println("</form>");				
			
			
			out.println("</body></html>");
	
			/*
			request.setAttribute("email_id",email);
			request.setAttribute("marks",score);
			RequestDispatcher rd = request.getRequestDispatcher("sendmail");
			rd.forward(request,response); 
			*/
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//out.println("hello");

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
