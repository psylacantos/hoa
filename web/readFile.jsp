<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import = "java.sql.*"%>
<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Text</title>
    </head>
    <body>
        <%
            String temp = request.getParameter("id");
            int docID = Integer.parseInt(temp);
            
            String driverName = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://localhost:3306/";
            String dbName = "hoa";
            String userId = "root";
            String password = "12345";
            
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            
            try{
                
                connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
                statement=connection.createStatement();
                
                String sql = "SELECT * FROM documents WHERE documentID = " + docID;
                resultSet = statement.executeQuery(sql);
                
                
                
                
           
            }catch (Exception e) {
            e.printStackTrace();
            }
            
            
            String jspPath = "C:\\Users\\Workstation\\Documents\\NetBeansProjects\\SWENGG\\directory\\";
            String fileName = resultSet.getString("documentName") +".txt";
            String txtFilePath = jspPath + fileName;
            BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
            //BufferedReader br = new InputStreamReader(new FileInputStream(txtFilePath));
            StringBuilder sb = new StringBuilder();
            String line;

            while((line = reader.readLine())!= null){
                sb.append(line+"\n");
            }
            out.println(sb.toString()); 
        %>
        <a href="index.jsp">Go Back</a>
        

    </body>
</html>