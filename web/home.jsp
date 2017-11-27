<%-- 
    Document   : home
    Created on : 11 26, 17, 3:39:16 PM
    Author     : Psyla Cantos
--%>

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
                <%
                  String usertype = (String)session.getAttribute("usertype"); 
                %>
                <% if (usertype.equals("2")){%>
                <a class="link" href="#"><ul>Security and Reports Violation</ul></a>
                    <a href='MakeAReport.jsp'><li>File a Report</li></a>
                    <a href='ViewReports.jsp'><li>View Reports</li></a>
                <%}
                else if (usertype.equals("3")){%>
                <a class="link" href="#"><ul>Security and Reports Violation</ul></a>
                    <a href='MakeAReport.jsp'><li>File a Report</li></a>
                <%}%>
                <a class="link" href="#"><ul>Vehicle and Vehicle Pass Admin</ul></a>
                <%
                   if (usertype.equals("3")){
                       out.println("<a href='registerVehicle.jsp'><li>Register Vehicle</li></a>");
                   }
                   else if (usertype.equals("2")){
                       out.println("<a href='approveRejectVehicle.jsp'><li>Approve Vehicle</li></a>");
                   }
                %>
                <a class="link" href="#"><ul>Monthly Dues and Fees Processing</ul></a>
                <% if (usertype.equals("2")){%>
                <a class="link" href="#"><ul>Monthly Dues and Fees Processing</ul></a>
                    <a href='MakeAReport.jsp'><li>Input Dues</li></a>
                <%}%>
                <a class="link" href="#"><ul>User Management, Registration, Directory Management</ul></a>
                <%
                   if (usertype.equals("1")){
                       out.println("<a href='/hoa/viewUsersGet'><li>View Users</li></a>");
                   }
                   if (usertype.equals("2")){
                       out.println("<a href='declare_homemember.jsp'><li>Homeowners' Directory</li></a>");
                       out.println("<a href='declare_kasambahay.jsp'><li>Homeowners' Directory</li></a>");
                       out.println("<a href='declare_pet.html'><li>Declare Pet</li></a>");
                       out.println("<a href='requestlist.jsp'><li>Registration Requests</li></a>");
                       out.println("<a href='/hoa/viewHomeownersGet'><li>Homeowners' Directory</li></a>");
                   }
                   else if (usertype.equals("3")){
                       out.println("<a href='declare_homemember.jsp'><li>Homeowners' Directory</li></a>");
                       out.println("<a href='declare_kasambahay.jsp'><li>Homeowners' Directory</li></a>");
                       out.println("<a href='declare_pet.html'><li>Declare Pet</li></a>");
                       out.println("<a href='/hoa/viewHomeownersGet'><li>Homeowners' Directory</li></a>");
                   }
                %>
                    <a href='policyMgmt.jsp'><ul>Policy Management</ul></a>
                    <a href='communitymap.jsp'><ul>Community Map</ul></a>
                <% if (usertype.equals("2")){%>
                <a class="link" href="index.jsp"><ul>Document Management</ul></a>
                <%}%>
            </div>
            <div class="content">
                <h1 style="display: block; margin: auto;">Welcome to your Village Management System!</h1>
            </div>
            
        </div>
    </body>
</html>
