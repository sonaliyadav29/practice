package com.user.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Code to verify the details from the database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_data", "root", "Sona@1234");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // User exists, create a session
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("failure.jsp");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

