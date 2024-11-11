package DemoServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String page=req.getParameter("page");
        out.println("<html><body>");
        if("about".equals(page)) {
        	out.println("<h1>About Page</h1>");
        }else if("contact".equals(page)) {
        	out.println("<h1>Contact Page</h1>");
        }
        else {
        	out.println("<h1>Home Page</h1>");
        }
        out.println("</body></html>");
	}
}
