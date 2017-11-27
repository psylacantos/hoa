<%-- 
    Document   : login
    Created on : 11 26, 17, 4:18:55 AM
    Author     : Psyla Cantos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlet.loginCheck, model.UsersList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Village Management System</title>
    </head>
    <body>
        <h1>Village Management System</h1>
        <form action="loginCheck" method="POST">
            <label>Username</label>
            <input type="text" name="usernameLogin"/> <br><br>
            <label>Password</label>
            <input type="password" name="passwordLogin"/> <br><br>
            <input type="submit" value="Login"/>
        </form> <br>
        <p>No account? <a href="create_regrequest.jsp"> Register </a></p>
    </body>
</html>
