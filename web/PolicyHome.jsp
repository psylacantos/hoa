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
<title>Policy Homepage</title>
</head>
<body>
    <form action ="ModifyPolicy" method ="GET">
        Add Policy:<input type ="submit" name ="Mode" value="Add"></br>
        Remove Policy:<input type ="submit" name ="Mode" value="Remove">PolicyID:<input type = "text" name = "policyID"></br>
        Approve Policy:<input type ="submit" name ="Mode" value="Approve">PolicyID:<input type = "text" name = "policyIDA"></br>
        Suspend Policy:<input type ="submit" name ="Mode" value="Suspend">PolicyID:<input type = "text" name = "policyIDS"></br>
        View Policy:<input type ="submit" name ="Mode" value="View">PolicyID:<input type = "text" name = "policyIDV"></br>
    </form>
</body>
</html>