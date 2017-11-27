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
        <title>Village Management System</title>
    </head>
    <body>
        <div>
        <h1></h1>
        

        <div>
          <h2>Vehicle Registration</h2>
        </div>

        <form method="post" action="../registerVehicle">
          <p>
            <label>Plate Number</label>
            <input required type="text" name="platenum" placeholder="Enter Vehicle Plate Number...">
          </p>
          
              
          <p>
                
            <label>Vehicle Brand</label>
            <input requiredtype="text" name="model" placeholder="Enter Vehicle Brand...">
          </p>
            <label>Vehicle Model</label>
            <input required type="text" name="make" placeholder="Enter Vehicle Model...">
          </p>
          
          <p>
              <label>Vehicle Model Year</label><br>
            <input required type="date" name="year"><br>
            <input type="submit">
          </p>
         
        </form>
        </div>
    </body>
</html>
