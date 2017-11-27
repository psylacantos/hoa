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
    ReportsDAO.getEvidencePhotos(conn, reportId);
    
    Report report = new Report();
    ArrayList<String> photo = new ArrayList();

    try { 
        report = ReportsDAO.getReportDetailsByID(conn, reportId);
        photo = ReportsDAO.getEvidencePhotos(conn, reportId);
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
        <h4>Report Details</h4>
        <strong>Report No.:</strong> <%= report.getReportID() %><br>
        <strong>Report Date:</strong> <%= report.getReportDate() %><br>
        <strong>Incident:</strong> <%= report.getIncidentType() %><br>
        <strong>Complainant:</strong> <%= report.getComplainant() %><br>
        <strong>Complaint:</strong> <%= report.getComplaint() %><br>
        <strong>Accused:</strong> <%= report.getAccused() %><br>
        <strong>Complainant Plate:</strong> <%= report.getComplainantPlate() %><br>
        <strong>Accused Plate:</strong> <%= report.getAccusedPlate() %><br>
        <strong>Violated Policy:</strong> <%= report.getPolicyDescription() %><br>
        <strong>Penalty:</strong> <%= report.getPenalty() %><br>
        <strong>Map Point:</strong> <%= report.getMapPoint() %><br>
        <strong>Status:</strong> <%= report.getStatusDescription() %><br>
        <strong>Resolution:</strong> <%= report.getResolution() %><br>
        <strong>Board Member:</strong> <%= report.getBoardMember() %><br>
        <strong>Security Personnel:</strong> <%= report.getSecurityPerson() %><br>
        <strong>Evidence Photos:</strong><br>
        <% for (String p : photo) {
            out.print("<img src='" + p + "' width='20%' height='20%' alt='" + p + "'><br>");
        }
         %>
         <p><form action="InvestigateServlet" method="post">
             <input type="hidden" name="reportId" value="<%= reportId %>">
             <input type="submit" name="submit" value="Update to Investigating">
         </form>
    </body>
</html>
