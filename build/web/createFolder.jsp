<%-- 
    Document   : create Folder
    Created on : 11 25, 17, 7:20:54 AM
    Author     : Jansen
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import = "java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Folder</title>
</head>

<body>
<div class="container">
<h3>Create New Folder</h3>
<hr />
<form name ="uploadForm" id="uploadForm" action="saveFolder" method="POST">
    <label for="id">Folder ID:</label>
    <input type="number" class="form-control" name="id" id="id"/><br>
    <label for="folder">Folder Name:</label> 
    <input type="text" name="name" id="folder" class="form-control"/> <br>
    <label for="folderDescription">Folder Description:</label>
    <input type="text" name="description" id="folderDescription" class="form-control"/> <br> <br>

    <label for="folder"><b><u>FOLDER PERMISSION</b></u></label> 
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
 </table> <br>
    <button type="submit" class="btn btn-primary">Create</button> <br>
  <a href="index.jsp" class="btn btn-danger">Go Back</a>
  
  
</form>

  </div>
</body>
<script src="JavaScript/jquery.min.js"></script>

</html>
