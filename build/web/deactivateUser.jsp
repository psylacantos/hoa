<%-- 
    Document   : deactivateUser
    Created on : 11 26, 17, 4:23:03 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css">
        <title>Village Management System</title>
    </head>
    <body>
        <div class="header">
            <h3 class="logout">Logout</h3>
            <a class="link" href="home.jsp"><h3>Village Management System </h3></a>
            
        </div>
        <div class="body">
            <div class="sidebar">
                <a class="link" href="#"><ul>Security and Reports Violation</ul></a>
                <a class="link" href="#"><ul>Vehicle and Vehicle Pass Admin</ul></a>
                <a class="link" href="#"><ul>Monthly Dues and Fees Processing</ul></a>
                <a class="link" href="#"><ul>User Management, Registration, Directory Management</ul></a>
                <a class="link" href="#"><ul>Policy Management and Community Mapping </ul></a>
                <a class="link" href="#"><ul>Document Management</ul></a>
            </div>
            <div class="content">
                <h1>Change Account Status</h1>
                <form action="deactivateUserinDB" method="POST">
                    <%
                    // String username = (String)request.getAttribute("deactivate");  
                    String ul = (String)request.getAttribute("deactivate");
                    %>
                    <label> Username </label>
                    <input type="text" name="userDeac" value="<%out.println(ul);%>" style="margin: 10px 50px;"></label> <br><br>
                    <input type="submit" value="Change Status" style="margin: 10px 130px;"/>
                </form> 
            </div>
        
         
    </body>
</html>
