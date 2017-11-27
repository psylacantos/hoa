<%-- 
    Document   : editDocInfo
    Created on : Nov 25, 2017, 1:42:55 PM
    Author     : Dell
--%>

<%@ page import="java.util.*" %>
<%@page  import = "hoa.swengg.*"%> 
<%@page import = "java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver");%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
            String temp = request.getParameter("id");
            int docuID = Integer.parseInt(temp);
            
            int seer = docuID;
            //int docuID = 1;
            
            
            
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3306/";
            String dbName = "hoa";
            String userId = "root";
            String password = "12345";
            
            
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            
            //String r = "Roach"; 
            //out.println("<h2>" + r+ "</h2>");
            
            int tempDocuID  = -1;
                String tempTitle = "-";
                String tempDesc = "-";
                String tempLocation = "-";
            try{
                
                connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                statement=connection.createStatement();
                
                String sql = "SELECT * FROM documents WHERE documentID = " + seer;
                resultSet = statement.executeQuery(sql);
                
                
                
                
                while(resultSet.next()){
                    
                    // name; description; location
                    
                     tempDocuID = resultSet.getInt("documentID") ;
                     tempTitle = resultSet.getString("documentTitle");
                     tempDesc = resultSet.getString("description");
                     tempLocation = resultSet.getString("document Location");
                    
                    // pang test lang sana ito 
                    out.println("<td>"+ tempDocuID + "</td><br>");
                    out.println("<td>"+tempTitle + "</td><br>");
                    out.println("<td>"+tempDesc + "</td><br>");
                    out.println("<td>"+tempLocation + "</td><br>");
                    
                }
            }catch (Exception e) {
            e.printStackTrace();
            }
        %>
        
        
        <h2>Editing Document info of ID: <%= docuID%></h2> <br>
        <br>
        
       
        
        <form action="updateDoc.jsp">
            DO NOT EDIT ---> <input type="text" name="id" value="<%= docuID%>"><br><br><br>
            
            New Title: <input type="text" class="form-control" name="title" value="<%= tempTitle%>" required><br>
            New Description: <input type="text" class="form-control" name="desc" value="<%= tempDesc%>" required><br>
            <input type="submit" name="update" value="Update">
          </form> 
        
        <% 
            String checkTitle = request.getParameter("title");
            String checkDesc = request.getParameter("desc");
        %>
        
    </body>
</html>
