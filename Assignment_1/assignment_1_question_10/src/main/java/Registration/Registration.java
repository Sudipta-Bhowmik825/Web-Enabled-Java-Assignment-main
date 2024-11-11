package Registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String location = req.getParameter("location");
        String education = req.getParameter("education");
        String phoneNumber = req.getParameter("phoneNumber");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String error="";
        Boolean valid = true;
        if (firstName == null || firstName.trim().isEmpty() ||
            middleName == null || middleName.trim().isEmpty() ||
            lastName == null || lastName.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            confirmPassword == null || confirmPassword.trim().isEmpty() ||
            location == null || location.trim().isEmpty() || 
            education == null || education.trim().isEmpty() ||
            phoneNumber == null || education.trim().isEmpty()) {
        	valid=false;
        	error="All Field required";
        }
        if(!Pattern.matches("[a-zA-Z]+",firstName)) {
        	valid=false;
        	error="First name should only contain Alphabet <br/>";
        }
        if(!Pattern.matches("[a-zA-Z]+",middleName)) {
        	valid=false;
        	error="Middle name should only contain Alphabet <br/>";
        }
        if(!Pattern.matches("[a-zA-Z]+",lastName)) {
        	valid=false;
        	error="Last name should only contain Alphabet <br/>";
        }
       
        if(!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",password) || password.length() < 6) 
        {
        	valid=false;
        	error="Password must be at least 6 characters long and contain alphabets, numbers, and special characters.<br>";
        	
        }
        if(!password.equals(confirmPassword)) {
        	valid=false;
        	error="Passwords do not match.<br>";
        }
        if (valid) {
            out.println("<html><body>");
            out.println("<h2>Registration Successful</h2>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h2>Registration Failed</h2>");
            out.println(error);
            out.println("</body></html>");
        }
    }
}