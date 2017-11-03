package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DueFeeForm", urlPatterns = {"/DueFeeForm"})
public class DueFeeForm extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        HttpSession session=request.getSession(false);
        if(session==null||session.getAttribute("accountant")==null){
           // System.out.println(session);
            request.getRequestDispatcher("IndirectLogin.html").include(request, response);
        }else{
            request.getRequestDispatcher("DueFee").include(request, response);
        }
        out.close();
    }

}
