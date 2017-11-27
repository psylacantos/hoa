<%-- 
    Document   : viewFolder
    Created on : Nov 23, 2017, 10:33:19 PM
    Author     : Jansen
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.File"%>
<% Class.forName("com.mysql.jdbc.Driver");%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documents</title>
    </head>
    <body>
        <br>
        
        <%
            int currentUserID = 1;
            //String id = request.getParameter("userID");
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3306/";
            String dbName = "hoa";
            String userId = "root";
            String password = "12345";
            

            try {
            Class.forName(driverName);
            }
            catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
            
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            ResultSet folderDetails = null;
            
        %>
        <%
            try{
            connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
            statement = connection.createStatement();
            String folderDetailsQuery ="SELECT folderID, folderName, folderdesc FROM folders WHERE folderId=" + request.getParameter("id");
            folderDetails = statement.executeQuery(folderDetailsQuery);
            folderDetails.first();
        }
             catch (Exception e) {
e.printStackTrace();
}
        %>
        

        <h2><%= folderDetails.getString("folderName") %> Folder</h2><br>
        <h2>UserID: <%= currentUserID%></h2><br>
        
        <a href="createFolder.jsp?id=<%=request.getParameter("id") %>"><button class="btn">New Folder</button></a>
        <a href="createDocument.jsp?id=<%=request.getParameter("id") %>"><button class="btn">New Document</button></a>
       
        


        
        <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr>
        </tr>
        
        <tr bgcolor="#A52A2A">
            <td><b>Folder Name</b></td>
            <td><b>Folder Description</b></td>
            <td><b>Created By</b></td>
            <td><b>Status</b></td>
            
        </tr>
        
        <%
            // catches query errors
            try{ 
                connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                statement=connection.createStatement();
                
                
                String sql = "SELECT folderID, folderName, folderdesc, users.fname, ref_folderstatus.status FROM folders INNER JOIN users INNER JOIN ref_folderstatus WHERE folders.create_userID = users.userID AND folders.statusID = ref_folderstatus.statusID AND folders.parentID IS NOT NULL "
                        + "AND folders.parentID=" + request.getParameter("id");
                        
                
                resultSet = statement.executeQuery(sql);
                while(resultSet.next()){
        %>
        
        <tr bgcolor="#DEB887">
            
            <% 
            int temp_folderID = resultSet.getInt("folderId");
            String temp_desc = resultSet.getString("folderdesc");
            String temp_name = resultSet.getString("fname") ;
            String temp_status = resultSet.getString("status");
            %>
            <td><a href="viewFolder.jsp?id=<%=resultSet.getString("folderId") %>"><%=resultSet.getString("folderName") %></td>
            <td><%=resultSet.getString("folderdesc") %></td>
            <td><%=resultSet.getString("fname") %></td>
            <td><%=resultSet.getString("status") %></td>
            
            

          
            
            <td><a href="editFolderInfo.jsp?id=<%=temp_folderID%>">Modify</td>
            <td><button class="editbtn">Archive</button></td>
            <td><button class="editbtn">Delete</button></td>
        </tr>
        
        <% 
                }   
;
            }
            catch (Exception e) {
            e.printStackTrace();
            }
        %>
        </table>
        
        <a href="index.jsp" class="btn btn-danger">Go Back</a>
            
        
        <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr>
        </tr>
        
        <tr bgcolor="#A52A2A">
            <td><b>Doc ID</b></td>
            <td><b>Document Title</b></td>
            <td><b>Document Description</b></td>
            <td><b>Location</b></td>
            <td><b>Folder</b></td>
            <td><b>Created By</b></td>
            <td><b>Status</b></td>
        </tr>
        
        <%
            try{
                 connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                statement=connection.createStatement();
                
                
                String sql = "SELECT * FROM documents JOIN ref_documentstatus ON documents.statusID=ref_documentstatus.statusID "
                        + "JOIN users ON documents.create_userID = users.userID "
                        + "WHERE (documents.statusID = 1 OR documents.statusID = 2 OR documents.statusID = 5 ) AND create_userID = " +  currentUserID + " "
                        + "AND folderID = " + request.getParameter("id");
                resultSet = statement.executeQuery(sql);
                
                out.println("<form action=\"\">");
                while(resultSet.next()){
                    out.println("<tr bgcolor=\"#DEB887\">");
                    int temp_docD = resultSet.getInt("documentID") ;
                    String temp_docTitle = resultSet.getString("documentTitle");
                    String temp_docDesc = resultSet.getString("description");
                    String temp_location = resultSet.getString("documentLocation");
                    String temp_folder = resultSet.getString("folderID");
                    String temp_user = resultSet.getString("fname") +  resultSet.getString("lname");
                    String temp_status = resultSet.getString("status");
                    
                    out.println("<tr bgcolor=\"#DEB887\">");
                    out.println("<td>" + temp_docD +  "</td>");
                    out.println("<td>" + temp_docTitle +  "</td>");
                    out.println("<td>" + temp_docDesc +  "</td>");
                    out.println("<td>" + temp_location +  "</td>");
                    out.println("<td>" + temp_folder +  "</td>");
                    out.println("<td>" + temp_user +  "</td>");
                    out.println("<td>" + temp_status +  "</td>");
        %>
        
            
            <td><a href="editDocInfo.jsp?id=<%=temp_docD%>">Modify</td>
            <td><button class="editbtn">Modify</button></td>
            <td><button class="editbtn">Archive</button></td>
            <td><button class="editbtn">Delete</button></td>
            
        

        <% 
                }   
            }catch (Exception e) {
            e.printStackTrace();
            }
        %>
        </table>
        </form>
        
        
    </body>
</html>
