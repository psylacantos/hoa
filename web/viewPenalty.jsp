<%@page import="com.mvc.bean.Penalties"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mvc.bean.Policy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<% Penalties p = (Penalties) request.getAttribute("penalty");
        
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>HOA</title>
</head>
<body>
 <center><h2>View Penalty</h2></center>
 PenaltyID: <%= p.getId()%> </br>
 Level:<%= p.getLevel()%></br>
Description:</br>
<%= p.getDesc()%>
</br></br>
Fee:<%= p.fee %></br>
Action:</br>
DocumentID:<%= p.getDocument()%></br></br>

</body>
</html>