<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% 
        String[] x = (String[])request.getAttribute("affected");            	
%>
<html>
<head>
<script> 
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add Policy</title>
</head>
<body>
<form action = "ModifyPolicy" method="Post" >
    Enter Description: <input type = "textarea" name = "desc"></br>
    Enter DocumentID: <input type = "text" name = "documentID"></br>
    Enter PenaltyID: <input type = "text" name = "penaltyID"></br>
Affected:</br>
<% for(int i=0;i<x.length;i++){
            out.println("<input type = 'checkbox' name = 'affected' value = '"+x[i]+"'>"+x[i]+"</br>");
        }
%>

<input type = "submit" name ="Mode" value="Add">
</body>
</html>