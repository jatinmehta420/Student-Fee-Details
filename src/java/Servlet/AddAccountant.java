package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.AccountantBean;
import DOA.AccountantDoa;

@WebServlet(name = "AddAccountant", urlPatterns = {"/AddAccountant"})
public class AddAccountant extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Accountant Added!</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='style.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("navadmin.html").include(request, response);
        out.println("<div class='container'>");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        AccountantBean bean = new AccountantBean(name, email, password, address, contact);
        int status = AccountantDoa.save(bean);
        out.print("<h1>Add Accountant Form</h1>");
        out.println("<p>Accountant is added successfully!</p>");
        request.getRequestDispatcher("AddAccountantForm.html").include(request, response);

        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.println("</body>");
        out.println("</html>");

        out.close();

    }

}
