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

@WebServlet(name = "EditStudentForm", urlPatterns = {"/EditStudentForm"})
public class EditStudentForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String srollno = request.getParameter("rollno");
        int rollno = Integer.parseInt(srollno);

        StudentBean bean = StudentDoa.getRecordByRoll(rollno);
        out.println("<!DOCTYPE>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Student</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='style.css'/>");
        out.println("</hesd>");
        out.println("<body>");
        request.getRequestDispatcher("navaccountant.html").include(request, response);
        out.println("<div class='container'>");
        out.println("<h1>Edit Students</h1>");
        out.println("<form action='EditStudent' method='post'>");
        out.print("<table>");
        out.print("<tr><td><input type='hidden' name='rollno' value='" + bean.getRollno() + "'/></td></tr>");
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + bean.getName() + "'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + bean.getEmail() + "'/></td></tr>");
        out.print("<tr><td>Sex:</td><td><input type='text' name='sex' value='" + bean.getSex() + "'/></td></tr>");
        out.print("<tr><td>Course:</td><td><input type='text' name='course' value='" + bean.getCourse() + "'/></td></tr>");
        out.print("<tr><td>Fee:</td><td><input type='number' name='fee' value='" + bean.getFee() + "'/></td></tr>");
        out.print("<tr><td>Paid:</td><td><input type='number' name='paid'  value='" + bean.getPaid() + "'/></td></tr>");
        out.print("<tr><td>Due:</td><td><input type='number' name='due'  value='" + bean.getDue() + "'/></td></tr>");
        out.print("<tr><td>Address:</td><td><textarea name='address' style='width:300px;height:100px;'>" + bean.getAddress() + "</textarea></td></tr>");
        out.print("<tr><td>Contact No:</td><td><input type='text' name='contact' value='" + bean.getContact() + "'/></td></tr>");
        out.print("<tr><td colspan='2' align='center'><input type='submit' value='Update Student'/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.println("</div>");
        request.getRequestDispatcher("footer.html").include(request, response);
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

}
