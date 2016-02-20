

import java.io.IOException;
 
import java.io.PrintWriter;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
//import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
//import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import SendEmail.SendEmail;





/**
 * Servlet implementation class sendmail
 */

// Actual class which sends the mail.
public class sendmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*String email = (String)request.getAttribute("email_id");
		String score = (String)request.getAttribute("marks");*/
		PrintWriter out=response.getWriter();
		try
		{
		Connection con;
		Statement stmt;
		ResultSet re1,re2;
		Class.forName("com.mysql.jdbc.Driver");
		
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
		
		stmt=con.createStatement();
		String rollno=null;
		HttpSession session1=request.getSession();
		rollno=(String)session1.getAttribute("rollno");
		
		
        //String rollno=(String)request.getAttribute("rollno");
		System.out.println("send mail rollno:"+rollno);
		re1=stmt.executeQuery("select * from result where roll_no="+rollno);
		re1.next();
		
		String score=re1.getString(3);
		
		System.out.println("send mail score:"+score);
		re2=stmt.executeQuery("select email from student where roll_no="+rollno);
		re2.next();
		
		String email=re2.getString(1);
		
		
		out.println("<html><body>");
		out.println("<p> your results is : </p>");
		out.println("<p>Mail has been send to "+email+" and your score is "+score+"</p>");
		out.println("</body></html>");
		
			
		
		
		
		//String[] arguments = new String[] {email,score};

		
		   System.out.println("java the great!");
		      // Recipient's email ID needs to be mentioned.
		      String to =email;

		      // Sender's email ID needs to be mentioned
		      String from = "exam.monitoring.system@gmail.com";

		      // Assuming you are sending email from localhost
		      String host = "localhost";

		      // Get system properties
		      Properties properties = System.getProperties();

		      // Setup mail server
		      properties.put("mail.smtp.host", "smtp.gmail.com");
		       properties.put("mail.smtp.auth", "true");
		  properties.put("mail.smtp.port","587");
		  properties.put("mail.smtp.starttls.enable", "true");
		  
		  // Get the default Session object.
		     
		  //Session session = Session.getDefaultInstance(properties);
		  Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {

		    protected PasswordAuthentication getPasswordAuthentication() {
		      return new PasswordAuthentication("exam.monitoring.system@gmail.com", "onlyadminknowsit");
		    }
		  });

		      try{
		         // Create a default MimeMessage object.
		         MimeMessage message = new MimeMessage(session);

		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
		         message.addRecipient(Message.RecipientType.TO,
		                                  new InternetAddress(to));

		         // Set Subject: header field
		         message.setSubject("your result in the test");

		         // Now set the actual message
		         String msgtext="your score in the test is sent through this mail and your score is"+score;
		         message.setText(msgtext);

		         // Send message
		         Transport.send(message);
		         System.out.println("Sent message successfully....");
		      
		}catch (MessagingException mex) {
		        System.out.println("error");
		         mex.printStackTrace();
		      }



		}
		catch(Exception e)
		{
			
		}
		    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
