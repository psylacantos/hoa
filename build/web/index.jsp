<%-- 
    Document   : Show Folders
    Created on : Nov 25, 2017, 2:51:17 AM
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
        <title>Showing Documents</title>
    </head>
    <body>
        
        <%  int currentUserID = 1;  
            // please do pass session of current user ID to variable above this comment
            int currentFolderID = 0;%>
            
        <h2>Current User: <%out.println(currentUserID);%></h2>
        <h2><a href="index.jsp">Press to Refresh</a></h2>
        <h2><a href="archivedDoc.jsp">Archived folders/documents</a></h2>
        <h2><a href="createFolder.jsp">Create Folder</a></h2>
        <%
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3306/";
            String dbName = "hoa";
            String userId = "root";
            String password = "12345";
        %>
        
        <%
            try {
            Class.forName(driverName);
            }
            catch (ClassNotFoundException e) {
            e.printStackTrace();
            }
            
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
        %>
        
        <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr>
        </tr>
        
        <tr bgcolor="#A52A2A">
            <td><b>Folder ID</b></td>
            <td><b>Folder Name</b></td>
            <td><b>Folder Description</b></td>
            <td><b>parent folder</b></td>
            <td><b>Created by</b></td>
            <td><b>Status</b></td>
            
        </tr>
        
        <%
            try{
                connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                statement=connection.createStatement();
                
                String sql = "SELECT * FROM folders JOIN ref_folderstatus ON folders.statusID=ref_folderstatus.statusID "
                        + "JOIN users ON folders.create_userID = users.userID "
                        + "WHERE parentID IS NULL "
                        + "AND (folders.statusID = 1 OR folders.statusID = 2 OR folders.statusID = 5 ) AND create_userID = " + currentUserID;
                resultSet = statement.executeQuery(sql);
                
                out.println("<form action=\"\">");
                while(resultSet.next()){
                    
                    int temp_folderID = resultSet.getInt("folderID") ;
                    String temp_user = resultSet.getString("fname") + " " + resultSet.getString("lname");
                    String temp_folderName = resultSet.getString("folderName");
                    String temp_folderDesc = resultSet.getString("folderdesc");
                    String temp_parentID = resultSet.getString("parentID");
                    String temp_status = resultSet.getString("status") ;
                    
                    
                    out.println("<tr bgcolor=\"#DEB887\">");
                    
                    out.println("<td> " + temp_folderID +  "</td>");
                    %>
                    <td><a href="viewFolder.jsp?id=<%=resultSet.getString("folderId") %>"><%=resultSet.getString("folderName") %></td>
                    <%
                    out.println("<td>" + temp_folderDesc +  "</td>");
                    out.println("<td>" + temp_parentID +  "</td>");
                    out.println("<td>" + temp_user +  "</td>");
                    out.println("<td>" + temp_status +  "</td>");
                    
                %>
                <td><input type="radio" name="folderid" value="<%=temp_folderID%>"> </td>
                <td><a href="editFolderInfo.jsp?id=<%=temp_folderID%>">Modify</td>
                    
                
                <td><input type="submit" name = "archiveFolder" value="Archive"></td>
                <td><input type="submit" name = "deleteFolder" value="Delete"></td>
        <%
                }
            }
            catch (Exception e) {
            e.printStackTrace();
            }
        %>
         </table>
    </form>
        <% 
            String getRadio = "asdf";
            // created (1)
            //enterFolder
            //modifyFolder (2)
            //archiveFolder (3)
            //deleteFolder (4)
            // restore (5)
            
            int selectedFolderID=-1; // gets selected foldeerID for 'modify', 'archive', 'delete'
            int nextFolder = -1; // gets selected foldeerID for moving into
            String status="null"; // for setting if 'modify', 'archive', OR 'delete' was pressed
            
            // Entering a selected 'Folder'
            if(request.getParameter("folderid") != null && request.getParameter("enterFolder")!=null){
                getRadio = request.getParameter("folderid"); //gets Radio button value
                nextFolder = Integer.parseInt(getRadio); // parses Radio button value into integer
                out.println("<h2>Entering " + nextFolder + "</h2>");
            }
            
            // Modifying a selected 'Folder'
            if(request.getParameter("folderid") != null && request.getParameter("modifyFolder")!=null){
                getRadio = request.getParameter("folderid"); //gets Radio button value
                selectedFolderID = Integer.parseInt(getRadio); // parses Radio button value into integer
                status = "2";
                out.println("<h2>Modifying " + selectedFolderID + "</h2>");
            }
            
            // Archiving a selected 'Folder'
            if(request.getParameter("folderid") != null && request.getParameter("archiveFolder")!=null){
                getRadio = request.getParameter("folderid"); //gets Radio button value
                selectedFolderID = Integer.parseInt(getRadio); // parses Radio button value into integer
                 status = "3";
                out.println("<h2>Archiving " + selectedFolderID + "</h2>");
            }
            
            // Deleting a selected 'Folder'
            if(request.getParameter("folderid") != null && request.getParameter("deleteFolder")!=null){
                getRadio = request.getParameter("folderid"); //gets Radio button value
                selectedFolderID = Integer.parseInt(getRadio); // parses Radio button value into integer
                status = "4";
                out.println("<h2>Deleting " + selectedFolderID + "</h2>");
                
            }
            
            // selectedFolderID == -1 IF any of the three was pressed: 'modify', 'archive', 'delete' 
            if(selectedFolderID != -1){
                Connection con = null;
                PreparedStatement ps = null;
                try
                {
                    //String driverName = "com.mysql.jdbc.Driver";
                    String url = "jdbc:mysql://localhost:3306/hoa2";
                    String user = "root";
                    String psw = "password";
                    
                    Class.forName(driverName);
                    con = DriverManager.getConnection(url,user,psw);

                    String sql = "UPDATE folders set statusID=? WHERE folderID=" + selectedFolderID;
                    ps = con.prepareStatement(sql);
                    ps.setString(1,status);
                    
                    int i = ps.executeUpdate();
                    if(i > 0)
                    {
                        out.print("Record Updated Successfully");
                        selectedFolderID = -1;
                    }
                    else
                    {
                        out.print("There is a problem in updating Record.");
                    }
                }
                catch(SQLException sql)
                {
                    request.setAttribute("error", sql);
                    out.println(sql);
                }
            }
            
            if(selectedFolderID == -1){
                out.println("<h2>Please Select a folder for action</h2>");
            }    
            
            
            
        %>
    </body>
</html>
