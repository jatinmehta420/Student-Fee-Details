
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.StudentBean;
import DOA.StudentDoa;

@WebServlet(name = "EditStudent", urlPatterns = {"/EditStudent"})
public class EditStudent extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int rollno=Integer.parseInt(request.getParameter("rollno"));
        String name = request.getParameter("name");
        String email= request.getParameter("email");
        String sex = request.getParameter("sex");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");
        String paid= request.getParameter("paid");
        String due= request.getParameter("due");
        String address= request.getParameter("address");
        String contact = request.getParameter("contact");
        
        StudentBean bean = new StudentBean(rollno, name, email, sex, course, fee, paid, due, address, contact);
        int status= StudentDoa.update(bean);
        response.sendRedirect("ViewStudent");
        out.close();
    }

    
}
