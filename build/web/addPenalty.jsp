<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<script> 
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add Policy</title>
</head>
<body>
<form action = "ModifyPenalties" method="Post" >
    Enter Level:<input type = "textarea" name = "level"></br>
    Enter Description: <input type = "textarea" name = "desc"></br>
    Enter Fee: <input type = "text" name = "fee"></br>
    Enter Action: <input type = "text" name = "action"></br>
    Enter DocumentID: <input type = "text" name = "documentID"></br>
    


<input type = "submit" name ="Mode" value="Add">
</body>
</html>