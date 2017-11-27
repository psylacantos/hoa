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
            int folderID = Integer.parseInt(temp);
            //int docuID = 1;
            
            
            
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3306/";
            String dbName = "hoa";
            String userId = "root";
            String password = "12345";
            
            
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            
            String r = "Roach"; 
            out.println("<h2>" + r+ "</h2>");
            
            int tempFolderID  = -1;
                String tempFolderName = "-";
                String tempDesc = "-";
                //String tempLocation = "-";
            try{
                
                connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                statement=connection.createStatement();
                
                String sql = "SELECT * FROM folders WHERE folderID = " + folderID;
                resultSet = statement.executeQuery(sql);
                
                
                
                
                while(resultSet.next()){
                    
                    // name; description; location
                    
                     tempFolderID = resultSet.getInt("folderID") ;
                     tempFolderName = resultSet.getString("folderName");
                     tempDesc = resultSet.getString("folderdesc");
                    
                    
                    // pang test lang sana ito 
                    out.println("<td>"+ tempFolderID + "</td><br>");
                    out.println("<td>"+tempFolderName + "</td><br>");
                    out.println("<td>"+tempDesc + "</td><br>");
                    
                    
                }
            }catch (Exception e) {
            e.printStackTrace();
            }
        %>
        
        
        <h2>Editing Folder info of ID: <%= folderID%></h2> <br>
        <br>
        <form action="updateFolder.jsp">
            DO NOT EDIT ---> <input type="text" name="id" value="<%= folderID%>"><br><br><br>
            
            New Folder Name: <input type="text" class="form-control" name="name" value="<%= tempFolderName%>" required><br>
            New description: <input type="text" class="form-control" name="desc" value="<%= tempDesc%>" required><br>
            <input type="submit" value="Submit">
          </form> 
        
    </body>
</html>
