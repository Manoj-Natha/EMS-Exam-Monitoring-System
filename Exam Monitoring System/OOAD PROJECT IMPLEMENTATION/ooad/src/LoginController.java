import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
  @SuppressWarnings("unused")
  
  // Class Student for student class describes about the login activites of student.
class student extends HttpServlet
 {private static final long serialVersionUID = 1L;
	String username;
	String password;
	 // Sets the session username for the new session to be created
	public  HttpServletRequest login(HttpServletRequest request,String s1,String s2)throws ServletException, IOException
	 {
		  HttpServletRequest request1=request;
		  request1.setAttribute("s1",s1);
			request1.setAttribute("s2",s2);
		return request1;
	 }
	
	 
 }
//Class ExamCenter for student class describes about the login activites of ExamCenter.
 class examcenter extends HttpServlet
 {
	// Sets the session username for the new session to be created
	 public  HttpServletRequest  login(HttpServletRequest request, String s1,String s2) throws  ServletException, IOException
	 {
		 HttpServletRequest request1=request;
		  request1.setAttribute("s1",s1);
			request1.setAttribute("s2",s2);
		return request1;
	 }
	 boolean publishResult()
	 {
		 return true;
	 }
	 boolean sendMail()
	 {
		 return true;
	 }
 }
/**
 * Servlet implementation class LoginController
 */
 // Realization of Controller Pattern whether  admin or student has logged in and redirects them to their respective pages.
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    // Servlet doget method to redirect the respective user
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hereman");
		
		String g1=request.getParameter("submitstudentbutton"); 
		String g2=request.getParameter("submitadminbutton");
		if(g1!=null)
		{
			student s=new student();
			String s1=request.getParameter("login");
			String s2=request.getParameter("password");
		    request=s.login(request,s1,s2);
			
		 ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher(response.encodeURL("/LoginCheck.jsp"));
			rd.forward(request, response);
		 }
		if(g2!=null)
		{
			
			examcenter e=new examcenter();
			String s1=request.getParameter("login1");
			String s2=request.getParameter("password1");
			request=e.login(request,s1,s2);
			
			 ServletContext context= getServletContext();
			 System.out.println("MAYBE");
				
			RequestDispatcher rd= context.getRequestDispatcher(response.encodeURL("/LoginCheckAdmin.jsp"));
				rd.forward(request, response);
				System.out.println("MAYBE");
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}