<%@page import="java.util.ArrayList"%>
<%@page import="com.mvc.bean.Policy"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<% Policy p = (Policy) request.getAttribute("pol");
        
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>HOA</title>
</head>
<body>
 <center><h2>View Policy</h2></center>
 PolicyID: <%= p.getPolicyID()%> </br>
Description:</br>
<%= p.getPolicydesc()%>
</br></br>
DocumentID:<%= p.getDocument()%></br></br>
Affected:</br>
<%
    ArrayList<String> aff = p.getAffected();
    for(int i=0;i<aff.size();i++){
        out.println(aff.get(i)+"</br>");
    }
%>
</body>
</html>