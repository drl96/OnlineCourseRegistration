<%-- 
    Document   : Login
    Created on : Oct 29, 2020, 12:41:33 AM
    Author     : drleo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Online Course Registration</h1>
        <form action="LoginServlet" method="post">
            <label>ID:</label><input type="text" name="id"><br>
            <label>Password:</label><input type="password" name="pwd"><br>
            <input type="submit" value="Login">         
        </form>
    </body>
</html>
