package com.sms.contoller;

import java.io.IOException;

import com.sms.dao.LoginDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("Username = " + username);
        System.out.println("Password = " + password);

        LoginDAO dao = new LoginDAO();

        boolean status = dao.validateUser(username, password);

        if (status) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("dashboard.html");

        } else {

            response.getWriter().println("<h2>Invalid Username or Password</h2>");
            response.getWriter().println("<a href='login.html'>Try Again</a>");

        }
    }
}