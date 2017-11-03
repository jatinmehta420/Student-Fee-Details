package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DOA.Validation;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AccountantLogin", urlPatterns = {"/AccountantLogin"})
public class AccountantLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Accountant Panel</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='style.css'/>");
        out.println("</head>");
        out.println("<body>");

        request.getRequestDispatcher("navaccountant.html").include(request, response);
        out.println("<div class='container'>");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            boolean status = Validation.validateAccountant(email, password);

            if (status) {
                HttpSession session = request.getSession();
                session.setAttribute("accountant", "true");
                RequestDispatcher rd = request.getRequestDispatcher("accountanthome.html");
                rd.include(request, response);
            } else {
                out.println("<h1>Accountant Login Form</h1>");
                out.println("<p>Sorry, username or password error!</p>");
                RequestDispatcher rd = request.getRequestDispatcher("AccountantLoginForm.html");
                rd.include(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountantLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountantLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.println("</body>");
        out.println("</html>");
    }

}
