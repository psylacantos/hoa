<%-- 
    Document   : updateFolder
    Created on : Nov 25, 2017, 7:04:11 PM
    Author     : Dell
--%>
<%@ page import="java.util.*" %>
<%@page  import = "hoa.swengg.*"%> 
<%@page import = "java.sql.*"%>

<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/hoa";%>
<%!String user = "root";%>
<%!String psw = "12345";%>

<% Class.forName("com.mysql.jdbc.Driver");%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updating  Folder</title>
    </head>
    
    <body>
        <h1>Updating  Folder</h1>
        
        
        
        <%
            String checkName = request.getParameter("name");
            String checkDesc = request.getParameter("desc");
            
            if(checkName == null){
                
                 out.println("<script type='text/javascript'>alert('Name is NULLL!!!');</script>");
            }
            
            
            //if(temp.isEmpty()){
            if(checkDesc == null){
               
                out.println("<script type='text/javascript'>alert('Description is NULL!!');</script>");
            }
            

            if(checkName != null && checkDesc != null){
                out.println("<script type='text/javascript'>alert('Updating Document!!!');</script>");
                
                Connection con = null;
                PreparedStatement ps = null;
                
                try{
                    String url = "jdbc:mysql://localhost:3306/hoa2";
                    String user = "root";
                    String psw = "password";
                    
                    //checkTitle
                    //checkDesc
                    
                    String temp = request.getParameter("id");
                    int folderID = Integer.parseInt(temp);
                    
                    Class.forName(driverName);
                    con = DriverManager.getConnection(url,user,psw);

                    String sql = "UPDATE folders set folderName=?, folderdesc=? WHERE folderID=" + folderID;
                    ps = con.prepareStatement(sql);
                    ps.setString(1,checkName);
                    ps.setString(2,checkDesc);
                    
                    int i = ps.executeUpdate();
                    if(i > 0)
                    {
                        out.print("Record Updated Successfully");
                        folderID = -1;
                    }
                    else
                    {
                        out.print("There is a problem in updating Record.");
                    }
                }catch(SQLException sql)
                {
                    request.setAttribute("error", sql);
                    out.println(sql);
                }
                
            }

        %>
        
        
        
        
    </body>
</html>
