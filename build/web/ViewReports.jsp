<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%
    Connection conn = DBConnect.getDBConnection();
    ReportsDAO.getReportList(conn);
    
    ArrayList<Report> report = new ArrayList();

    try { 
        report = ReportsDAO.getReportList(conn);
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
        <h4>Viewing All Reports</h4>
        <table>
            <tr>
                <th>Report No.</th>
                <th>Report Date</th>
                <th>Incident</th>
                <th>Complainant</th>
                <th>Complaint</th>
                <th>Accused</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            <% for (Report r : report) {
                out.print ("<tr>"
                            + "<td>" + r.getReportID() + "</td>"
                            + "<td>" + r.getReportDate() + "</td>"
                            + "<td>" + r.getIncidentType() + "</td>"
                            + "<td>" + r.getComplainant() + "</td>"
                            + "<td>" + r.getComplaint() + "</td>"
                            + "<td>" + r.getAccused() + "</td>"
                            + "<td>" + r.getStatusDescription() + "</td>"
                            + "<td><a href='ReportDetails.jsp?id=" + r.getReportID() + "'><button>View Details</button></a> <a href='ReportTransaction.jsp?id=" + r.getReportID() + "'><button>Settle Payment</button></a> <a href='ResolveReport.jsp?id=" + r.getReportID() + "'><button>Resolve</button></a></td>"
                        + "</tr>");
            } %>
        </table>
    </body>
    
    <style>
        table, th, td
        { 
            border: 1px solid black;
            border-collapse: collapse;
        }
        
        table
        {
            width: 100%;
        }
    </style>
</html>
