 <%-- 
    Document   : index
    Created on : 11 25, 17, 1:06:39 PM
    Author     : BadgerinoTwo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Village Management System</title>
    </head>
    <body>
        <div>
        <h1></h1>
       

        <div>
          <h2>Approve/Reject Vehicle</h2>
        </div>
        
        <form method="post" action="../approveRejectVehicle">

        <table border="1">
           <tr>
                <td>Plate Number</td>
                <td>Model</td>
                <td>Make</td>
                <td>Year</td>
                <td>Banned</td>
                <td>Options</td>
           </tr>
           
           <input style="display: none" id="mytext" type="text" name="pn">
           
           <script>
               function getValue(objButton){  
                    document.getElementById("mytext").value = objButton.value;
                }
           </script>
           
           <%

           try
           {
               Class.forName("com.mysql.jdbc.Driver");

               String query="SELECT * FROM VEHICLES";
               Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root",null);
               Statement stmt=conn.createStatement();
               ResultSet rs=stmt.executeQuery(query);
               
               
               while(rs.next())
               {
           %>
           
               <tr>
                   <td><%out.print(rs.getString("platenum")); %></td>
                   <td><%out.print(rs.getString("model"));%></td>
                   <td><%out.print(rs.getString("make")); %></td>
                   <td><%out.print(rs.getString("year"));%></td>
                   <td><%out.print(rs.getString("banned"));%></td>
                   <td><button onclick="getValue(this)" type="submit" name="approve" value=<%=rs.getString("platenum")%>>Approve</button></td>
                   <td><button onclick="getValue(this)" type="submit" name="reject" value=<%=rs.getString("platenum")%>>Reject</button></td>
                   <td><button onclick="getValue(this)" type="submit" name="ban" value=<%=rs.getString("platenum")%>>Ban</button></td>
                   <td><button onclick="getValue(this)" type="submit" name="unban" value=<%=rs.getString("platenum")%>>Unban</button></td>
                   
                       
               </tr>
           <%
              }
              %>
           </table>
           
           
           <%
                rs.close();
                stmt.close();
                conn.close();
           }
           catch(Exception e)
           {
                e.printStackTrace();
           }
           %>
               </form>
        </div>
    </body>
</html>
