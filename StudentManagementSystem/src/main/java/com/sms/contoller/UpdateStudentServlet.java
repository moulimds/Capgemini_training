package com.sms.contoller;

import java.io.IOException;

import com.sms.dao.StudentDAO;
import com.sms.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student s = new Student();

        s.setStudentId(Integer.parseInt(request.getParameter("studentId")));
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPhone(request.getParameter("phone"));
        s.setCourse(request.getParameter("course"));
        s.setAddress(request.getParameter("address"));
        s.setDateOfBirth(request.getParameter("dateOfBirth"));

        StudentDAO dao = new StudentDAO();

        boolean status = dao.updateStudent(s);

        if (status) {
            response.sendRedirect("ViewStudentServlet");
        } else {
            response.getWriter().println("<h2>Student Update Failed!</h2>");
        }
    }
}