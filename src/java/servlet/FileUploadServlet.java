/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
/**
*    Document   : File Upload Servlet
 *   Created on : Nov 25, 2017, 1:42:55 PM
 *   Author     : Dell
 */

 
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
/**
 * A Java servlet that handles file upload from client.
 *
 * @author www.codejava.net
 */
public class FileUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "directory";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 
    /**
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
    }
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
 
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        // change directory==============================================
        
        String recFilePath = "";
        String recFileDescription = "";
        String recFolderDescription = "";
        String recFolderName = "";
        String recFolderID="";
        String recFileID="";
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        //CHANGE .../HOA2 TO DATABASE NAME=========================
        final String DB_URL="jdbc:mysql://localhost:3306/hoa2";
        final String USER = "root";
        // change password===============================================
        final String PASS = "password";
 
        try {
                // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = null; 
            ResultSet folderDetails = null;
            
            
            statement=conn.createStatement();
            String folderDetailsQuery ="SELECT folderName FROM folders WHERE folderID=" + request.getParameter("id");
            folderDetails = statement.executeQuery(folderDetailsQuery);
            folderDetails.next();


            
                    String uploadPath = "C:\\Users\\Workstation\\Documents\\NetBeansProjects\\SWENGG\\"
                + File.separator+ UPLOAD_DIRECTORY ;
         
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
            
            
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
 
                        // saves the file on disk
                        item.write(storeFile);
                        request.setAttribute("message",
                            "Upload has been done successfully!");
                        
                        
                        
                    }
                }
            }
            

        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage()) ;
            
            
            
        }
        // redirects client to message page
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);
        
        response.sendRedirect("testConnection.jsp");
    }
}