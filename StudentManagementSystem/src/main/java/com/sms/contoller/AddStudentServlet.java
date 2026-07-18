package com.sms.contoller;

import java.io.IOException;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student s = new Student();

        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPhone(request.getParameter("phone"));
        s.setCourse(request.getParameter("course"));
        s.setAddress(request.getParameter("address"));
        s.setDateOfBirth(request.getParameter("dateOfBirth"));

        StudentDAO dao = new StudentDAO();

        boolean status = dao.addStudent(s);

        if (status) {
            response.sendRedirect("dashboard.html");
        } else {
            response.getWriter().println("<h2>Student Not Added!</h2>");
        }
    }
}