package com.user.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");

        // Code to store the details in the database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_data", "root", "Sona@1234");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (name, password, email, dob) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, dob);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }
}

