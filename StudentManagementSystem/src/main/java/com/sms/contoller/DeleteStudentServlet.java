package com.sms.contoller;

import java.io.IOException;

import com.sms.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentId = Integer.parseInt(request.getParameter("studentId"));

        StudentDAO dao = new StudentDAO();

        boolean status = dao.deleteStudent(studentId);

        if (status) {
            response.sendRedirect("ViewStudentServlet");
        } else {
            response.getWriter().println("<h2>Student Delete Failed!</h2>");
        }
    }
}