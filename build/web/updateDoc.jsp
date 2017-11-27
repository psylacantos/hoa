<%-- 
    Document   : update document
    Created on : Nov 25, 2017, 5:59:54 PM
    Author     : Dell
--%>

<%@ page import="java.util.Date" %>
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
        <title>Updating  Document</title>
    </head>
    <body>
        <h1>Updating  Document!!!</h1>
        <br><br>
         <a href="editDocInfo.jsp">Go back</a>
        
        <%
            String checkTitle = request.getParameter("title");
            String checkDesc = request.getParameter("desc");
            
            if(checkTitle == null){
                out.println("<h2>" + checkTitle + "</h2>");
                 out.println("<script type='text/javascript'>alert('Title is NULLL!!!');</script>");
            }
            
            
            //if(temp.isEmpty()){
            if(checkDesc == null){
                out.println("<h2> N31n </h2>");
                out.println("<script type='text/javascript'>alert('Description is NULL!!');</script>");
            }
            
            if(checkTitle != null && checkDesc != null){
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
                    int docuID = Integer.parseInt(temp);
                    
                    Class.forName(driverName);
                    con = DriverManager.getConnection(url,user,psw);

                    String sql = "UPDATE documents set documentTitle=?, description=? WHERE documentID=" + docuID;
                    ps = con.prepareStatement(sql);
                    ps.setString(1,checkTitle);
                    ps.setString(2,checkDesc);
                    
                    int i = ps.executeUpdate();
                    if(i > 0)
                    {
                        out.print("Record Updated Successfully");
                        docuID = -1;
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
