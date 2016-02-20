

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.*;
// To Print the hall ticket generated.........

/**
 * Servlet implementation class Downloads
 */
public class Downloads extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Downloads() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Servlet method which gets the details and send prints in a pdf format
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition",
		"attachment;filename=downloadfilename.txt");
		StringBuffer sb = new StringBuffer("whatever string you like");
		InputStream in = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
		ServletOutputStream out = response.getOutputStream();
		 
		byte[] outputByte = new byte[1024];
		//copy binary contect to output stream
		while(in.read(outputByte, 0, 1024) != -1)
		{
			out.write(outputByte, 0, 1024);
		}
		in.close();
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
