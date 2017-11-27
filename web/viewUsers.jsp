<%-- 
    Document   : view
    Created on : 11 25, 17, 3:11:48 PM
    Author     : Psyla Cantos
--%>

<%@page import="java.sql.Array"%>
<%@ page language = "java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
                <h1>View Users</h1>
                <br>
                <table class="table">
                    <tr>
                        <th>Name</th>
                        <th>Username</th>
                        <th>User Type</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                    <%
                        UsersList ul=(UsersList)request.getAttribute("gurubean");
                        String usernames[] = new String[ul.getUsersNum()];
                        usernames = ul.getUsersList();
                        String temp, name, userID, usertype, status, trial;
                        for (int i=0; i<usernames.length; i++){
                            temp = usernames[i];
                            userID = temp.substring(0, temp.indexOf("|"));
                            temp = temp.substring(temp.indexOf("|")+1);
                            name = temp.substring(0, temp.indexOf("|"));
                            temp = temp.substring(temp.indexOf("|")+1);
                            usertype = temp.substring(0, temp.indexOf("|"));
                            temp = temp.substring(temp.indexOf("|")+1);
                            status = temp.substring(0);

                    %>
                            <tr>
                                <td><%out.println(name);%></td>
                                <td><%out.println(userID);%></td>
                                <td><%out.println(usertype);%></td>
                                <td><%out.println(status);%></td>
                                <% if (!status.equals("INACTIVE")){%>
                                <td class="buttonTD"><form name="frm" action="getUserToDeactivate" method="POST"><input type="hidden" name="userDeac" value="<%out.println(userID);%>"/>
                                        <input type="submit" value="Deactivate" onclick="deactivate()"/></form></td>
                                <%} else{%>
                                <td class="buttonTD"><form name="frm" action="getUserToDeactivate" method="POST"><input type="hidden" name="userDeac" value="<%out.println(userID);%>"/>
                                        <input type="submit" value="Activate" onclick="deactivate()"/></form></td>

                                <%}%>
                            </tr> 
                    <% } %>
                </table>
            </div>
            
        </div>
        
        
        
        <script>
            function deactivate(){
                document.frm.submit();
            }
        </script>
    </body>
</html>
