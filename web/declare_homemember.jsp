<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declare Homemember</title>
    </head>
    <h1>Declare Homemember</h1>
    <body>
                
        <form id="homemember_form" action="AddHomememberServlet" method="POST">
            <input id="fName" type="text" name="firstName" placeholder="First name" required>
            <input id="lName" type="text" name="lastName" placeholder="Last name" required> <br></br>
            Renting:
            <input type="radio" name="renting" value="1"> Yes
            <input type="radio" name="renting" value="0"> No <br></br>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>