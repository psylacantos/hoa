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

@WebServlet("/RSVServlet")
public class ReportingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int incident = Integer.parseInt(request.getParameter("incident"));
        String party1 = request.getParameter("party1");
        String party2 = request.getParameter("party2");
        String plate = request.getParameter("plate");
        int policy = Integer.parseInt(request.getParameter("policy"));
        int point = Integer.parseInt(request.getParameter("point"));
        String complaint = request.getParameter("complaint");
        
        String sys = String.valueOf(LocalDateTime.now());
        String date  = sys.substring(0,10);
        int reportId = 0;
        
        Connection conn = DBConnect.getDBConnection();
        
        try {  reportId = ReportsDAO.getLastReportID(conn) + 1; }
        catch (SQLException e) { e.printStackTrace(); }
        
        Report report = new Report(reportId, date, 1, incident, complaint, policy, point);
        
        try 
        { 
            ReportsDAO.addReport(conn, report);
            if (incident == 1) { 
                ReportsDAO.Vehicle2User(conn, reportId, "ADMIN", plate);
            } 
            else if (incident == 2) { 
                ReportsDAO.Vehicle2Vehicle(conn, reportId, "ADMIN", plate);
            }
            else if (incident == 3) {
                ReportsDAO.User2User(conn, reportId, "ADMIN", party1);
            }
            else if (incident == 4) {  
                ReportsDAO.User2Anyone(conn, reportId, "ADMIN", party2);
            }
        } 
        catch(SQLException e) { e.printStackTrace(); }
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=UTF-8");
        
        out.println("<html>");
        out.println("<h3>Reports and Security Violations</h3>");
        out.println("<h4>Reporting a Violation</h4>");
        out.println("Thank you for bringing up your concerns. Your report (#" + reportId + ") has been submitted!");
    }
}