/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
/**
 *   Document   : Save Folder Servlet
 *   Created on : Nov 25, 2017, 1:42:55 PM
  *  Author     : Dell
 */

/**
 *
 * @author jansenborja
 */

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addFolder
 */

public class saveFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveFolder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

                
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        final String DB_URL="jdbc:mysql://localhost:3306/hoa2";
        final String USER = "root";
        final String PASS = "password";
        
        // Register JDBC driver
        try {
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
	        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        Statement statement = null;
      	  	ResultSet resultSet = null;
	        statement = conn.createStatement();
	      	String sql ="SELECT folderName FROM folders WHERE folderName='"+request.getParameter("name")+"'";
                resultSet = statement.executeQuery(sql);
                if (isResultSetEmpty(resultSet)) {
		      	PreparedStatement ps = conn.prepareStatement(
	            		"INSERT INTO folders(folderID, folderName, folderdesc, create_userID, statusID) VALUES (?, ?, ?, ?, ?)");
                        //gets the foldID
		        ps.setInt (1, Integer.parseInt(request.getParameter("id")));
                        
                        //gets the FolderName
		        ps.setString(2, request.getParameter("name"));
                        
                        //gets the FolderDescription
		        ps.setString(3, request.getParameter("description"));
                        
                        //for create_userID to, hardcoded to 1
		        ps.setInt (4, 1); 
                        
                        //for statusID, harcoded to 1 because 1 = Created
                        ps.setInt (5, 1);
                        
		        ps.executeUpdate();
		        ps.close();
                        //created folders are saved in the directory folder
		        String uploadPath = "C:\\Users\\Workstation\\Documents\\NetBeansProjects\\SWENGG\\directory\\" + request.getParameter("name");
		        File folderUploadDir = new File(uploadPath);
                if (!folderUploadDir.exists()) {
                	folderUploadDir.mkdir();
                }
                }
	        
	       
        	conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        response.sendRedirect("index.jsp");
		
	}

	public static boolean isResultSetEmpty(ResultSet resultSet) throws SQLException {
	    return !resultSet.first();
	}


	
}
