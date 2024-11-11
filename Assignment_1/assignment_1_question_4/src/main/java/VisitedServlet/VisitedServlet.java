package VisitedServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VisitedServlet")
public class VisitedServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        Cookie[] cookies = req.getCookies();
        Cookie visitCookie = null;
        int visitCount = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCookie = cookie;
                    visitCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        if (visitCookie == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        visitCookie = new Cookie("visitCount", Integer.toString(visitCount));
        visitCookie.setMaxAge(24 * 60 * 60);
        res.addCookie(visitCookie);

        out.println("<html><body>");
        out.println("<h1>Visit Count: " + visitCount + "</h1>");
        out.println("</body></html>");
	}
	}
