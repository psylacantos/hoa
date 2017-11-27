<%-- 
    Document   : Create Document
    Created on : Nov 24, 2017, 5:24:54 PM
    Author     : jansenborja
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import = "java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Document</title>
</head>
<body>
	<div class="container">
		<h3>New Document</h3>
		<hr />
		<form name ="uploadForm" id="uploadForm" action="uploadFile" method="POST" enctype = "multipart/form-data">
                                <%--gets the href's folder ID--%>
				<input type="hidden" name="folder_id" value="<%=request.getParameter("folder_id") %>"/>
                                <label for="file">Upload a Document: </label>
                                    <input class="form-control" type="file" name="file" id="file"/><br>    
                                
                                <label for="id">Document ID:</label>
                                    <input type="number" class="form-control" name="id" id="id"/><br>
                                    
                                   
                                  
                                    <label for="docDescription" >Document Description</label>
				    <input  class="form-control" type ="text" name="docDescription" id="description"><br>
				<br><label for="folder"><b><u>DOCUMENT PERMISSION</b></u></label> 
				<table class="table">
			  <thead>
			  	<tr>
			  		<th> User Type </th>
			  		<th> Read </th>
			  		<th> Update </th>
			  		<th> Delete </th>
			  	</tr>
                          </thead>
                          
			  <tbody>
			  	<tr>
			   		<td> Admin </td>
			  		<td> <input type="checkbox"/> </td>
			  		<td> <input type="checkbox"/> </td>
			  		<td> <input type="checkbox"/> </td>
			  	</tr>
			  	<tr>
			   		<td> Board Members </td>
			  		<td> <input type="checkbox"/> </td>
			  		<td> <input type="checkbox"/> </td>
			  		<td> <input type="checkbox"/> </td>
			  	</tr>
			  </tbody>
			 </table>
				<button type="submit" class="btn btn-primary" value ="Submit" name="submit">Upload</button>
                                <%--returns to the href's folder ID--%>
				<a href="index.jsp" class="btn btn-danger">Back</a>
		</form>
	</div>
	
	
</body>
<script src="JavaScript/jquery.min.js"></script>

</html>