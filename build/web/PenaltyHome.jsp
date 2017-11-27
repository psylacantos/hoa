<%-- 
    Document   : index
    Created on : 11 26, 17, 2:45:09 AM
    Author     : Anjoh
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Penalty Homepage</title>
</head>
<body>
    <form action ="ModifyPenalties" method ="GET">
        Add Penalty:<input type ="submit" name ="Mode" value="Add"></br>
        View Penalty:<input type ="submit" name ="Mode" value="View">PenaltyID:<input type = "text" name = "penaltyID"></br>
    </form>
</body>
</html>