package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DOA.AccountantDoa;

@WebServlet(name = "DeleteAccountant", urlPatterns = {"/DeleteAccountant"})
public class DeleteAccountant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        AccountantDoa.delete(id);
        response.sendRedirect("ViewAccountant");
    }

}
