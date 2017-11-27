package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.time.LocalDateTime;
import java.io.PrintWriter;
import java.sql.*;
import dao.*;
import model.*;

@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int reportID = Integer.parseInt(request.getParameter("reportId"));
        double paid = Double.parseDouble(request.getParameter("paid"));
        double amount = Double.parseDouble(request.getParameter("cost"));
        
        Connection conn = DBConnect.getDBConnection();
        
        try 
        { 
            ReportsDAO.payPenalty(conn, reportID, paid, amount);  
        } 
        catch(SQLException e) { e.printStackTrace(); }
           
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=UTF-8");
        
        out.println("<html>");
        out.println("<h3>Reports and Security Violations</h3>");
        out.println("<h4>Resolving a Report</h4>");
        out.println("Report #" + reportID + " has been paid!");
    }
}