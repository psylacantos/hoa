<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declare Kasambahay</title>
    </head>
    <h1>Declare Kasambahay</h1>
    <body>
                
        <form id="kasambahay_form" action="" method="POST">
            <input id="fName" type="text" name="firstName" placeholder="First name" required>
            <input id="lName" type="text" name="lastName" placeholder="Last name" required> <br></br>
            Start date:<br>
            <input id="sDate" type="date" name="startDate" required/> <br></br>
            End date:<br>
            <input id="eDate" type="date" name="endDate" required/> <br></br>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>