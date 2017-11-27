<%-- 
    Document   : viewHomeowners
    Created on : 11 26, 17, 9:10:44 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <tr>
                        <th>Name</th>
                        <th>Telephone Number</th>
                        <th>Mobile Number</th>
                        <th></th>
                    </tr>
                    <%
                        UsersList ul=(UsersList)request.getAttribute("homeownersList");
                        String usernames[] = new String[ul.getUsersNum()];
                        usernames = ul.getHomeownersList();
                        String temp, userID, name, telNum, mobileNum;
                        for (int i=0; i<usernames.length; i++){
                            temp = usernames[i];
                            userID = temp.substring(0, temp.indexOf("|"));
                            temp = temp.substring(temp.indexOf("|")+1);
                            name = temp.substring(0, temp.indexOf("|"));
                            temp = temp.substring(temp.indexOf("|")+1);
                            telNum = temp.substring(0, temp.indexOf("|"));
                            temp = temp.substring(temp.indexOf("|")+1);
                            mobileNum = temp.substring(0);

                    %>
                            <tr>
                                <td><%out.println(name);%></td>
                                <td><%out.println(telNum);%></td>
                                <td><%out.println(mobileNum);%></td>
                                <td class="buttonTD"><form name="frm2" action="viewIndividualHomeownerServlet" method="POST"><input style="display: none;" type="text" name="homeowner" value="<%out.println(userID);%>"/>
                                        <input type="submit" value="View" onclick="submit()"/></form></td>
                            </tr> 
                    <% } %>
                </table>
            </div>
                <script>
                    function submit(){
                        document.frm2.submit();
                    }
                </script>
    </body>
</html>
