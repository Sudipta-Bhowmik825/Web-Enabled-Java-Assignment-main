package AutoRefresh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class AutoRefresh extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Auto Refresh</title>");
		res.setHeader("refresh","5;url=reloadedpage");
		out.println("</head>");
		out.println("<body>");
		out.println("This webpage will be reloaded to a new page in 5 seconds ...");
		out.println("</body>");
		out.println("</html>");
	}
}
