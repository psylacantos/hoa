<%@page import="Model.Registration_Request"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.UserDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

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
            <div class="sidebar"> <!--dictates what is shown in the sidebar
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
                <table style="width:100%" border="1">
                    <tr><th>Username</th><th>Name</th><th>Birth Date</th><th>PhotoID</th><th>Occupation</th><th>Telephone Number</th><th>Mobile Number</th>
                        <th>Block No.</th><th>Lot No.</th><th>Move In Date</th><th></th></tr>
                <form action="ApproveRequest" method="POST">
                <%

                    UserDAO uDao = new UserDAO();
                    ArrayList<Registration_Request> registration_list = uDao.getAllRequests();
                    for(int i=0; i<registration_list.size(); i++)
                    {
                %>

                    <tr><td><%=registration_list.get(i).getUserID()%></td><td><%=registration_list.get(i).getFname() + " " + registration_list.get(i).getMname()+ " " + registration_list.get(i).getLname() + " "%>
                        </td><td><%=registration_list.get(i).getbDate()%></td><td>PhotoID</td><td><%=registration_list.get(i).getOccupation()%></td><td><%=registration_list.get(i).getTelNum()%></td>
                        <td><%=registration_list.get(i).getMobileNum()%></td><td><%=registration_list.get(i).getBlocknum()%></td><td><%=registration_list.get(i).getLotnum()%></td><td><%=registration_list.get(i).getMovingIn()%></td>
                        <td><input type="hidden"  name="uName_hd" value="<%=registration_list.get(i).getUserID()%>"/><button type="submit" id="apprvBtn" name="accept">Approve</button><button name="reject" id="rjctBtn" type="submit">Reject</button></td></tr>
                <%}
                %>
                </form>
                </table>
                <script src="script/jquery-3.2.1.min.js"></script>
                <script>
                    function approveRequest(userId){

                    }
                </script>


            </div>
        </div>
    </body>

