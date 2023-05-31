<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration and Login</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="RegistrationServlet" method="post">
        Name: <input type="text" name="name" required><br>
        Password: <input type="password" name="password" required><br>
        Email: <input type="email" name="email" required><br>
        Date of Birth: <input type="date" name="dob" required><br>
        <input type="submit" value="Register">
    </form>

    <h1>User Login</h1>
    <form action="LoginServlet" method="post">
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
