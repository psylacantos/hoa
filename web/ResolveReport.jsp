<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%
    int reportId = Integer.parseInt(request.getParameter("id"));
    
    Connection conn = DBConnect.getDBConnection();
    ReportsDAO.getReportDetailsByID(conn, reportId);
    
    Report report = new Report();

    try { 
        report = ReportsDAO.getReportDetailsByID(conn, reportId);
    }
    catch ( SQLException e){ e.printStackTrace(); }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reports and Security Violations</title>
    </head>
    <body>
        <form action="ResolveServlet" method="post" id="resform">
            <h4>Resolving a Report</h4>
            <strong>Report No.:</strong> <%= report.getReportID() %><input type="hidden" name="reportId" value="<%= reportId %>"><p>
            <strong>Report Date:</strong> <%= report.getReportDate() %><p>
            <strong>Incident:</strong> <%= report.getIncidentType() %><p>
            <strong>Complainant:</strong> <%= report.getComplainant() %><p>
            <strong>Complaint:</strong> <%= report.getComplaint() %><p>
            <strong>Accused:</strong> <%= report.getAccused() %><p>
            <strong>Violated Policy:</strong> <%= report.getPolicyDescription() %><p>
            <strong>Penalty:</strong> <%= report.getPenalty() %><p>
            <strong>Transaction ID:</strong><%= report.getTrxID() %><p>
            <strong>Resolution:</strong> <textarea name="resolution" cols="30" rows="4" form="resform"></textarea><p>
            <input type="submit" name="submit" value="Resolve">
        </form>
    </body>
</html>
