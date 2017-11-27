<%-- 
    Document   : viewIndividualHomeowner
    Created on : 11 26, 17, 10:20:35 PM
    Author     : Lenovo
--%>

<%@page import="model.UsersList"%>
<%@page import="model.UsersList" %>
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
                <h1>Homeowners Directory</h1>
                <br>
                <table class="table">
            <%
                UsersList ul=(UsersList)request.getAttribute("ho");
                String usernames[] = new String[ul.getUsersNum()];
                usernames = ul.getHomeownerInfo();
            %>    
                <tr>
                        <td>Name: </td>
                        <td><%out.println(usernames[0]);%></td>
                    </tr> 
                    <tr>
                        <td>Birth date: </td>
                        <td><%out.println(usernames[1]);%></td>
                    </tr> 
                    <tr>
                        <td>Occupation: </td>
                        <td><%out.println(usernames[2]);%></td>
                    </tr> 
                    <tr>
                        <td>Telephone Number: </td>
                        <td><%out.println(usernames[3]);%></td>
                    </tr> 
                    <tr>
                        <td>Mobile Number: </td>
                        <td><%out.println(usernames[4]);%></td>
                    </tr> 
                    <tr>
                        <td>Moving In Date: </td>
                        <td><%out.println(usernames[5]);%></td>
                    </tr> 
        </table>
            </div>
        </div>
    </body>
</html>
