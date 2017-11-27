<%-- 
    Document   : Archived Documents
    Created on : Nov 24, 2017, 3:49:13 PM
    Author     : Dell
--%>

<%@ page import="java.util.Date" %>
<%@ page import="java.util.*" %>
<%@page  import = "hoa.swengg.*"%> 
<%@page import = "java.sql.*"%>


<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/hoa2";%>
<%!String user = "root";%>
<%!String psw = "password";%>

<% Class.forName("com.mysql.jdbc.Driver");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Archived Docs</title>
    </head>
    <body>
        <h1>Archived Folders</h1>
        
         <%
            
            int currentUserID = 1;
            out.println("<h2> Current User: " + currentUserID+ "</h2>");
            //String id = request.getParameter("userID");
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3306/";
            String dbName = "hoa2";
            String userId = "root";
            String password = "password";
            

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
            <td><b>Status</b></td>
        </tr>
        
        <%
            //int test = 100;
            try{ 
                connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                statement=connection.createStatement();
                
                
                String sql = "SELECT * FROM folders JOIN ref_folderstatus ON folders.statusID=ref_folderstatus.statusID "
                        + "WHERE ref_folderstatus.statusID = 3 AND create_userID = " +  currentUserID;
                resultSet = statement.executeQuery(sql);
                
                out.println("<form action=\"\">");
                while(resultSet.next()){
                    out.println("<tr bgcolor=\"#DEB887\">");
                    int temp_folderID = resultSet.getInt("folderID") ;
                    String temp_folderName = resultSet.getString("folderName");
                    String temp_folderDesc = resultSet.getString("folderdesc");
                    String temp_parentID = resultSet.getString("parentID");
                    String temp_status = resultSet.getString("status") ;
                    
                    
                    out.println("<tr bgcolor=\"#DEB887\">");
                    out.println("<td>" + temp_folderID +  "</td>");
                    out.println("<td>" + temp_folderName +  "</td>");
                    out.println("<td>" + temp_folderDesc +  "</td>");
                    out.println("<td>" + temp_parentID +  "</td>");
                    out.println("<td>" + temp_status +  "</td>");
                    
        %>
        
           
            <td><input type="radio" name="folderid" value="<%=temp_folderID%>"> </td>
            <td><input type="submit" name = "restoreFolder" value="Restore"></td>
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
        <h2><a href="index.jsp">Back to main</a></h2>
        <h2><a href="archivedDoc.jsp">Refresher</a></h2>
<% 
            String getRadio = "asdf";
            
            //archiveFolder (3)
            //deleteFolder (4)
            // restore (5)
            
            int selectedFolderID=-1; // gets selected foldeerID for 'modify', 'archive', 'delete'
            String status="null"; // for setting if 'archive' OR 'delete' was pressed
            
            // Deleting a selected 'Folder'
            if(request.getParameter("folderid") != null && request.getParameter("deleteFolder")!=null){
                getRadio = request.getParameter("folderid"); //gets Radio button value
                selectedFolderID = Integer.parseInt(getRadio); // parses Radio button value into integer
                status = "4";
                out.println("<h2>Deleting " + selectedFolderID + "</h2>");
                
            }
            
            // Restoring a selected 'Folder'
            if(request.getParameter("folderid") != null && request.getParameter("restoreFolder")!=null){
                getRadio = request.getParameter("folderid"); //gets Radio button value
                selectedFolderID = Integer.parseInt(getRadio); // parses Radio button value into integer
                status = "5";
                out.println("<h2>Restoring " + selectedFolderID + "</h2>");
                
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
                out.println("<h2>PLease Select a folder for action</h2>");
            }    
            
            
            
        %>
        <!------- ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- -------  >
       <!------- ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- -------  >
       <!------- ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- ------- -------  -->
       <table align="center" cellpadding="5" cellspacing="5" border="1">
        <tr>
        </tr>
        
        <tr bgcolor="#A52A2A">
            <td><b>Doc ID</b></td>
            <td><b>Document Title</b></td>
            <td><b>Document Description</b></td>
            <td><b>Location</b></td>
            <td><b>Folder</b></td>
            <td><b>Status</b></td>
        </tr>
        
        <%
            //int test = 100;
            try{ 
                connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                statement=connection.createStatement();
                
                
                String sql = "SELECT * FROM documents JOIN ref_documentstatus ON documents.statusID=ref_documentstatus.statusID "
                        + "WHERE ref_documentstatus.statusID = 3 AND create_userID = " +  currentUserID;
                resultSet = statement.executeQuery(sql);
                
                out.println("<form action=\"\">");
                while(resultSet.next()){
                    out.println("<tr bgcolor=\"#DEB887\">");
                    int temp_docD = resultSet.getInt("documentID") ;
                    String temp_docTitle = resultSet.getString("documentTitle");
                    String temp_docDesc = resultSet.getString("description");
                    String temp_location = resultSet.getString("documentLocation");
                    String temp_folder = resultSet.getString("folderID");
                    int temp_user = resultSet.getInt("create_userID") ;
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
        
            
            <td><input type="radio" name="folderid" value="<%=temp_docD%>"> </td>
            <td><input type="submit" name = "restoreDoc" value="Restore"></td>
            <td><input type="submit" name = "deleteDoc" value="Delete"></td>
            
        

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
            getRadio = "asdf";
            
            //archiveFolder (3)
            //deleteFolder (4)
            // restore (5)
            
            int selectedDocID=-1; // gets selected foldeerID for 'modify', 'archive', 'delete'
            String docstatus="null"; // for setting if 'archive' OR 'delete' was pressed
            
            // Deleting a selected 'Folder'
            if(request.getParameter("folderid") != null && request.getParameter("restoreDoc")!=null){
                getRadio = request.getParameter("folderid"); //gets Radio button value
                selectedDocID = Integer.parseInt(getRadio); // parses Radio button value into integer
                docstatus = "4";
                out.println("<h2>Restoring " + selectedDocID + "</h2>");
                
            }
            
            // Restoring a selected 'Folder'
            if(request.getParameter("folderid") != null && request.getParameter("deleteDoc")!=null){
                getRadio = request.getParameter("folderid"); //gets Radio button value
                selectedDocID = Integer.parseInt(getRadio); // parses Radio button value into integer
                docstatus = "5";
                out.println("<h2>Deleting " + selectedDocID + "</h2>");
                
            }
            
            // selectedFolderID == -1 IF any of the three was pressed: 'modify', 'archive', 'delete' 
            if(selectedDocID != -1){
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

                    String sql = "UPDATE documents set statusID=? WHERE documentID=" + selectedDocID;
                    ps = con.prepareStatement(sql);
                    ps.setString(1,docstatus);
                    
                    int i = ps.executeUpdate();
                    if(i > 0)
                    {
                        out.print("Record Updated Successfully");
                        selectedDocID = -1;
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
                out.println("<h2>PLease Select a folder for action</h2>");
            }    
            
            
            
        %>
        
    </body>
</html>
