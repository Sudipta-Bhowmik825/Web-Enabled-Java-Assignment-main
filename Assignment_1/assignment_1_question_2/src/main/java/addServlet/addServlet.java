package addServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)
		throws IOException
	{
		PrintWriter out=res.getWriter();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String savePassword="1234";
		String saveUsername="admin";

		if(username.equals(saveUsername) && password.equals(savePassword) ) {
			
			out.println("Hello Admin");
		}else {
			out.println("Login Failed");
		}

	}
}
