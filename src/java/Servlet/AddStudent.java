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
import javax.servlet.RequestDispatcher;
import PDFCreation.RegistrationPDF;

@WebServlet(name = "AddStudent", urlPatterns = {"/AddStudent"})
public class AddStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");
        String paid = request.getParameter("paid");
        String due = request.getParameter("due");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        StudentBean bean = new StudentBean(name, email, sex, course, fee, paid, due, address, contact);
        int status = StudentDoa.save(bean);
        
        RegistrationPDF.pdf(bean);
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Add Student</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='style.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("navaccountant.html").include(request, response);
        out.println("<div class='container'>");

        out.println("Student is added successfully!");

        request.getRequestDispatcher("AddStudentForm.html").include(request, response);
        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.println("</body>");
        out.println("</html>");

        

    }

}
