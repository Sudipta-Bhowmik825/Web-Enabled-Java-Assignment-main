package SessionServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session=req.getSession(true);
		Boolean isVisited= (Boolean) session.getAttribute("isVisited");
		if(isVisited==null) {
			session.setAttribute("isVisited", false);
            out.println("<html><body>");
            out.println("<h1>Welcome!</h1>");
            out.print("<a href='SessionServlet?killSession=ok'><button>Kill session</button></a>");
            out.println("  ");
            out.print("<a href='SessionServlet'><button>Refresh</button></a>");
            out.println("</body></html>");
		}else {
            out.println("<html><body>");
            out.println("<h1>Already Visited</h1>");
            out.print("<a href='SessionServlet?killSession=ok'><button>Kill session</button></a>");
            out.println("  ");
            out.print("<a href='SessionServlet'><button>Refresh</button></a>");
            out.println("</body></html>");
		}
		String killSession = req.getParameter("killSession");
		if("ok".equals(killSession)) {
			session.invalidate();
            out.println("<html><body>");
            out.println("<h1>Session end</h1>");
            out.println("<a href='SessionServlet'>click here</a>");
            out.println("</body></html>");
		}
	}
}
