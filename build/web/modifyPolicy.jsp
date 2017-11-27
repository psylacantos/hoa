<%@page import="com.mvc.bean.Policy"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% 
       Policy p = (Policy) request.getAttribute("pol");            	
%>
<html>
<head>
<script> 
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Policy</title>
</head>
<body>
<form action = "ModifyPolicy" method="Post" >
    PolicyID:<input type = "textarea" name = "policyID" value = '<%= p.getPolicyID()%>' hidden><%= p.getPolicyID()%></br>
    Description: <input type = "textarea" name = "desc" value = '<%= p.getPolicydesc()%>'></br>
    Enter DocumentID: <input type = "text" name = "documentID" value = '<%= p.getDocument()%>'></br>
    Enter PenaltyID: <input type = "text" name = "penaltyID" value = '<%= p.getPenalty()%>'></br>
Affected:</br>
<% ArrayList<String> x = (ArrayList<String>) request.getAttribute("affected");
ArrayList<String> checker = p.getAffected();
 String checked = "";
    for(int i=0;i<x.size();i++){
           checked ="";
            if(checker.contains(x.get(i))){
                checked = "checked";
            }
            out.println("<input type = 'checkbox' name = 'affected' value = '"+x.get(i)+"'"+checked+">"+x.get(i)+"</br>");
        }
%>

<input type = "submit" name ="Mode" value="Modify">
</body>
</html>