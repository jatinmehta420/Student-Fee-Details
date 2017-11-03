package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SearchStudentForm", urlPatterns = {"/SearchStudentForm"})
public class SearchStudentForm extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Search Student</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='style.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("navaccountant.html").include(request, response);
        out.println("<div class='container'>");
        HttpSession session = request.getSession(false);
        if(session==null||session.getAttribute("accountant")==null){
            out.println("<h1>Not Accountant!</h1>");
            request.getRequestDispatcher("AccountantLoginForm.html").include(request, response);
        }else{
            request.getRequestDispatcher("SearchStudentForm.html").include(request, response);
        }
        

        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}


