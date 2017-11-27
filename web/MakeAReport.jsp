<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.*"%>
<%@page import="model.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%
    Connection conn = DBConnect.getDBConnection();
    ReportsDAO.getIncidentTypeList(conn);
    ReportsDAO.getPartyList(conn);
    ReportsDAO.getPlateList(conn);
    ReportsDAO.getPolicyList(conn);
    ReportsDAO.getMapPointList(conn);
    
    ArrayList<Incident> incident = new ArrayList();
    ArrayList<Party> party = new ArrayList();
    ArrayList<Plate> plate = new ArrayList();
    ArrayList<Policy> policy = new ArrayList();
    ArrayList<MapPointReports> map = new ArrayList();

    try { 
        incident = ReportsDAO.getIncidentTypeList(conn);
        party = ReportsDAO.getPartyList(conn);
        plate = ReportsDAO.getPlateList(conn);
        policy = ReportsDAO.getPolicyList(conn);
        map = ReportsDAO.getMapPointList(conn);
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
        <h3>Reports and Security Violations</h3>
        <h4>Reporting a Violation</h4>
        <form id="report" action='RSVServlet' method='post'>
            Nature of Report: <select name="incident" >
                <%  
                    for (Incident i : incident) { out.print("<option value='" + i.getIncidentID() + "'>" + i.getIncidentType() + "</option>"); }
                %>
            </select></p>
            Name of Party to Report (if applicable): <select name="party1">
                <option value="NULL">N/A</option>
                <%  
                    for (Party p : party) { out.print("<option value='" + p.getUserID() + "'>" + p.getFirstName() + " " + p.getLastName() + "</option>"); }
                %>
            </select></p>
            &nbsp &nbsp  Others (if reporting an outside party): <input type="text" name="party2" cols="30"></p>
            Plate No. of Vehicle to Report (if applicable): <select name="plate">
                <option value="NULL">N/A</option>
                <%  
                    for (Plate pl : plate) { out.print("<option value='" + pl.getPlateNum() + "'>" + pl.getPlateNum() + "</option>"); }
                %>
            </select></p>
            Violated Policy: <select name="policy">
                <%  
                    for (Policy po : policy) { out.print("<option value='" + po.getPolicyID() + "'>" + po.getPolicyDescription() + "</option>"); }
                %>
            </select></p>
            Map Point: <select name="point">
               <%  
                    for (MapPointReports m : map) { out.print("<option value='" + m.getMapPointID() + "'>" + m.getTitle() + " - " + m.getDescription() + "</option>"); }
                %>
            </select></p>
            Complaint: <textarea name="complaint" cols="30" rows="4" form="report"></textarea></p>
            <input type="submit" name="submit" value="Submit Report">
        </form>
    </body>
</html>
