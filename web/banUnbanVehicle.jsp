 <%-- 
    Document   : index
    Created on : 11 25, 17, 1:06:39 PM
    Author     : BadgerinoTwo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
        <h1></h1>
        

        <div>
          <h2>Approve/Reject Vehicle</h2>
        </div>
        
        
        <form action="registerVehicle.jsp">
          <p>
            <table>
                    <tr>
                      <th>Plate Number</th>
                      <th>Brand</th>
                      <th>Model</th>
                      <th>Model Year</th>
                      <th>Approve/Reject
                      </th>
                    </tr>
                    <tr>
                      <td>ASD123</td>
                      <td>Toyota</td>
                      <td>Sansa</td>
                      <td>1992</td>
                      <td><button name="approve" value="1">Unban</button>
                          <button name="reject" value="2">Ban</button></td>
                    </tr>
                    <tr>
                      <td>BAS152</td>
                      <td>Isuzu</td>
                      <td>Truck</td>
                      <td>2004</td>
                      <td><button name="approve" value="1">Unban</button>
                          <button name="reject" value="2">Ban</button></td>
                    </tr>
                    <tr>
                      <td>XGQ632</td>
                      <td>Lexus</td>
                      <td>Corvo</td>
                      <td>2009</td>
                      <td><button name="approve" value="1">Unban</button>
                          <button name="reject" value="2">Ban</button></td>
                    </tr>
            </table>
          
        </form>
        </div>
    </body>
</html>
