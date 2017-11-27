package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.*;

public class ReportsDAO 
{   
    public static ArrayList<Report> getReportList(Connection conn) throws SQLException
    {
        ArrayList<Report> results = new ArrayList();
        String sql = "SELECT securityReportID, incidentTypeID FROM security_violations;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rsmain = ps.executeQuery();
        
        while (rsmain.next())
        {
            if (rsmain.getInt("incidentTypeID") == 1)
            {
                sql = "SELECT sv.securityReportID, sv.reportDate, sv.complaint, it.incidentType, vs.status, concat(u.fname, ' ', u.lname) AS 'complainant', (SELECT concat(u.fname, ' ', u.lname) FROM vehicle2user v2u JOIN user_vehicles uv ON v2u.platenum = uv.plateNum JOIN users u ON uv.userID = u.userID WHERE v2u.securityReportID = sv.securityReportID) AS 'accused' FROM security_violations sv JOIN ref_incidenttype it ON sv.incidentTypeID = it.incidentTypeID JOIN ref_violationstatus vs ON sv.status = vs.statusID JOIN vehicle2user v2u ON sv.securityReportID = v2u.securityReportID JOIN users u ON v2u.userID = u.userID WHERE sv.securityReportID = " + rsmain.getInt("securityReportID") + ";";
                
                PreparedStatement ps2 = conn.prepareStatement(sql);
                ResultSet rs = ps2.executeQuery();

                while (rs.next())
                {
                    results.add(new Report(rs.getInt("securityReportID"), rs.getString("reportDate"), rs.getString("incidentType"), rs.getString("complainant"), rs.getString("complaint"), rs.getString("accused"), rs.getString("status")));
                }
            }
            else if (rsmain.getInt("incidentTypeID") == 2)
            {
                sql = "SELECT sv.securityReportID, sv.reportDate, sv.complaint, it.incidentType, vs.status, concat(u.fname, ' ' , u.lname) AS 'complainant', concat(u2.fname, ' ', u2.lname) AS 'accused' FROM security_violations sv JOIN ref_incidenttype it ON sv.incidentTypeID = it.incidentTypeID JOIN ref_violationstatus vs ON sv.status = vs.statusID JOIN vehicle2vehicle v2v ON sv.securityReportID = v2v.securityReportID JOIN user_vehicles uv ON v2v.complainantplatenum = uv.plateNum LEFT JOIN users u ON uv.userID = u.userID JOIN user_vehicles uv2 ON v2v.accusedplatenum = uv2.plateNum LEFT JOIN users u2 ON uv2.userID = u2.userID WHERE sv.securityReportID = " + rsmain.getInt("securityReportID") + ";";
                
                PreparedStatement ps2 = conn.prepareStatement(sql);
                ResultSet rs = ps2.executeQuery();

                while (rs.next())
                {
                    results.add(new Report(rs.getInt("securityReportID"), rs.getString("reportDate"), rs.getString("incidentType"), rs.getString("complainant"), rs.getString("complaint"), rs.getString("accused"), rs.getString("status")));
                }
            }
            else if (rsmain.getInt("incidentTypeID") == 3)
            {
                sql = "SELECT sv.securityReportID, sv.reportDate, sv.complaint, it.incidentType, vs.status, concat(u.fname, ' ' , u.lname) AS 'complainant', concat(u2.fname, ' ', u2.lname) AS 'accused' FROM security_violations sv JOIN ref_incidenttype it ON sv.incidentTypeID = it.incidentTypeID JOIN ref_violationstatus vs ON sv.status = vs.statusID JOIN user2user u2u ON sv.securityReportID = u2u.securityReportID JOIN users u ON u2u.complainant_userID = u.userID JOIN users u2 ON u2u.accused_userID = u2.userID WHERE sv.securityReportID = " + rsmain.getInt("securityReportID") + ";";
                
                PreparedStatement ps2 = conn.prepareStatement(sql);
                ResultSet rs = ps2.executeQuery();

                while (rsmain.next())
                {
                    results.add(new Report(rs.getInt("securityReportID"), rs.getString("reportDate"), rs.getString("incidentType"), rs.getString("complainant"), rs.getString("complaint"), rs.getString("accused"), rs.getString("status")));
                }
            }
            else if (rsmain.getInt("incidentTypeID") == 4)
            {
                sql = "SELECT sv.securityReportID, sv.reportDate, sv.complaint, it.incidentType, vs.status, concat(u.fname, ' ' , u.lname) AS 'complainant', u2a.otherparty AS 'accused' FROM security_violations sv JOIN ref_incidenttype it ON sv.incidentTypeID = it.incidentTypeID JOIN ref_violationstatus vs ON sv.status = vs.statusID JOIN user2anyone u2a ON sv.securityReportID = u2a.securityReportID JOIN users u ON u2a.userID = u.userID WHERE sv.securityReportID = " + rsmain.getInt("securityReportID") + ";";
                
               PreparedStatement ps2 = conn.prepareStatement(sql);
                ResultSet rs = ps2.executeQuery();

                while (rs.next())
                {
                    results.add(new Report(rs.getInt("securityReportID"), rs.getString("reportDate"), rs.getString("incidentType"), rs.getString("complainant"), rs.getString("complaint"), rs.getString("accused"), rs.getString("status")));
                }
            }
        }
        
        return results;
    }
    
    public static ArrayList<Incident> getIncidentTypeList(Connection conn) throws SQLException
    {
        ArrayList<Incident> results = new ArrayList();
        String sql = "SELECT incidentTypeID, incidentType FROM ref_incidenttype;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            results.add(new Incident(rs.getInt("incidentTypeID"), rs.getString("incidentType")));
        }
        
        return results;
    }
    
    public static ArrayList<Party> getPartyList(Connection conn) throws SQLException
    {
        ArrayList<Party> results = new ArrayList();
        String sql = "SELECT userID, lname, fname FROM users;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            results.add(new Party(rs.getString("userID"), rs.getString("fname"), rs.getString("lname")));
        }
        
        return results;
    }
    
    public static ArrayList<Plate> getPlateList(Connection conn) throws SQLException
    {
        ArrayList<Plate> results = new ArrayList();
        String sql = "SELECT platenum FROM vehicles;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            results.add(new Plate(rs.getString("platenum")));
        }
        
        return results;
    }
    
    public static ArrayList<Policy> getPolicyList(Connection conn) throws SQLException
    {
        ArrayList<Policy> results = new ArrayList();
        String sql = "SELECT policyID, policydesc FROM policies;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            results.add(new Policy(rs.getInt("policyID"), rs.getString("policydesc")));
        }
        
        return results;
    }
    
    public static ArrayList<MapPointReports> getMapPointList(Connection conn) throws SQLException
    {
        ArrayList<MapPointReports> results = new ArrayList();
        String sql = "SELECT mappointID, title, description FROM mappoint;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            results.add(new MapPointReports(rs.getInt("mappointID"), rs.getString("title"), rs.getString("description")));
        }
        
        return results;
    }
    
    public static void addReport(Connection conn, Report report) throws SQLException
    {
        int securityReportID = report.getReportID();
        String reportDate = report.getReportDate();
        int incidentTypeID = report.getIncidentID();
        String complaint = report.getComplaint();
        int status = report.getStatus();
        int violatedpolicyID = report.getPolicyID();
        int mappointID = report.getMapPointID();
        
        String sql = "INSERT INTO security_violations (securityReportID, reportDate, incidentTypeID, complaint, status, violatedpolicyID, mappointID) VALUES (" + securityReportID + ", '" + reportDate + "', " + incidentTypeID + ", '" + complaint + "', " + status + ", " + violatedpolicyID + ", " + mappointID + ");";
        
        try 
        {
            PreparedStatement ps = conn.prepareStatement(sql);
            int isInserted = ps.executeUpdate();
            if (isInserted != 0)
            {
                System.out.print("Report Submitted");
            }
        }
        catch(SQLException e) {}
    }
    
    public static int getLastReportID(Connection conn) throws SQLException
    {
        int lastId = 0;
        String sql = "SELECT securityReportID FROM security_violations ORDER BY securityReportID DESC LIMIT 1;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            lastId = rs.getInt("securityReportID");
        }
        
        return lastId;
    }
    
    public static Report getReportDetailsByID(Connection conn, int reportId) throws SQLException
    {
        int reportID = reportId;
        Report report = new Report();
        String sql = "SELECT incidentTypeID FROM security_violations WHERE securityReportID = " + reportID + ";";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            if (rs.getInt("incidentTypeID") == 1)
            {
                sql = "SELECT sv.securityReportID, sv.reportDate, sv.complaint, sv.resolution, it.incidentType, po.policydesc, pe.penaltyfee, concat(mp.title, ' - ', mp.description) AS 'mappoint', vs.status, concat(u1.fname, ' ', u1.lname) AS 'boardmember', concat(u2.fname, ' ', u2.lname) AS 'securityperson', concat(u3.fname, ' ', u3.lname) AS 'complainant', concat(u4.fname, ' ', u4.lname) AS 'accused', uv1.plateNum FROM security_violations sv JOIN ref_incidenttype it ON sv.incidentTypeID = it.incidentTypeID JOIN policies po ON sv.violatedpolicyID = po.policyID JOIN penalties pe ON po.penaltyID = pe.penaltyID JOIN mappoint mp ON sv.mappointID = mp.mappointID JOIN ref_violationstatus vs ON sv.status = vs.statusID LEFT JOIN users u1 ON sv.boardmemberID = u1.userID LEFT JOIN users u2 ON sv.securityID = u2.userID JOIN vehicle2user v2u ON sv.securityReportID = v2u.securityReportID JOIN user_vehicles uv1 ON v2u.platenum = uv1.plateNum LEFT JOIN users u3 ON v2u.userID = u3.userID LEFT JOIN users u4 ON uv1.userID = u4.userID WHERE sv.securityReportID = " + reportID + ";";
                
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next())
                {
                    report = new Report(rs.getInt("securityReportID"), rs.getString("reportDate"), rs.getString("complaint"), rs.getString("resolution"), rs.getString("incidentType"), rs.getString("policydesc"), rs.getDouble("penaltyfee"), rs.getString("mappoint"), rs.getString("status"), rs.getString("boardmember"), rs.getString("securityPerson"), rs.getString("complainant"), rs.getString("accused"), "N/A", rs.getString("plateNum"));
                }
            }
            else if (rs.getInt("incidentTypeID") == 2)
            {
                sql = "SELECT sv.securityReportID, sv.reportDate, sv.complaint, sv.resolution, it.incidentType, po.policydesc, pe.penaltyfee, concat(mp.title, ' - ', mp.description) AS 'mappoint', vs.status, concat(u1.fname, ' ', u1.lname) AS 'boardmember', concat(u2.fname, ' ', u2.lname) AS 'securityperson', concat(u3.fname, ' ', u3.lname) AS 'complainant', concat(u4.fname, ' ', u4.lname) AS 'accused', v2v.complainantplatenum, v2v.accusedplatenum FROM security_violations sv JOIN ref_incidenttype it ON sv.incidentTypeID = it.incidentTypeID JOIN policies po ON sv.violatedpolicyID = po.policyID JOIN penalties pe ON po.penaltyID = pe.penaltyID JOIN mappoint mp ON sv.mappointID = mp.mappointID JOIN ref_violationstatus vs ON sv.status = vs.statusID LEFT JOIN users u1 ON sv.boardmemberID = u1.userID LEFT JOIN users u2 ON sv.securityID = u2.userID JOIN vehicle2vehicle v2v ON sv.securityReportID = v2v.securityReportID JOIN user_vehicles uv1 ON v2v.complainantplatenum = uv1.plateNum LEFT JOIN users u3 ON uv1.userID = u3.userID JOIN user_vehicles uv2 ON v2v.accusedplatenum = uv2.plateNum LEFT JOIN users u4 ON uv2.userID = u4.userID WHERE sv.securityReportID = " + reportID + ";";
                     
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next())
                {
                    report = new Report(rs.getInt("securityReportID"), rs.getString("reportDate"), rs.getString("complaint"), rs.getString("resolution"), rs.getString("incidentType"), rs.getString("policydesc"), rs.getDouble("penaltyfee"), rs.getString("mappoint"), rs.getString("status"), rs.getString("boardmember"), rs.getString("securityPerson"), rs.getString("complainant"), rs.getString("accused"), rs.getString("complainantplatenum"), rs.getString("accusedplatenum"));
                }
            }
            else if (rs.getInt("incidentTypeID") == 3)
            {
                sql = "SELECT sv.securityReportID, sv.reportDate, sv.complaint, sv.resolution, it.incidentType, po.policydesc, pe.penaltyfee, concat(mp.title, ' - ', mp.description) AS 'mappoint', vs.status, concat(u1.fname, ' ', u1.lname) AS 'boardmember', concat(u2.fname, ' ', u2.lname) AS 'securityperson', concat(u3.fname, ' ', u3.lname) AS 'complainant', concat(u4.fname, ' ', u4.lname) AS 'accused' FROM security_violations sv JOIN ref_incidenttype it ON sv.incidentTypeID = it.incidentTypeID JOIN policies po ON sv.violatedpolicyID = po.policyID JOIN penalties pe ON po.penaltyID = pe.penaltyID JOIN mappoint mp ON sv.mappointID = mp.mappointID JOIN ref_violationstatus vs ON sv.status = vs.statusID LEFT JOIN users u1 ON sv.boardmemberID = u1.userID LEFT JOIN users u2 ON sv.securityID = u2.userID JOIN user2user u2u ON sv.securityReportID = u2u.securityReportID LEFT JOIN users u3 ON u2u.complainant_userID = u3.userID LEFT JOIN users u4 ON u2u.complainant_userID = u4.userID WHERE sv.securityReportID = " +reportID + ";";
                
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next())
                {
                    report = new Report(rs.getInt("securityReportID"), rs.getString("reportDate"), rs.getString("complaint"), rs.getString("resolution"), rs.getString("incidentType"), rs.getString("policydesc"), rs.getDouble("penaltyfee"), rs.getString("mappoint"), rs.getString("status"), rs.getString("boardmember"), rs.getString("securityPerson"), rs.getString("complainant"), rs.getString("accused"), "N/A", "N/A");
                }
            }
            else if (rs.getInt("incidentTypeID") == 4)
            {
                sql = "SELECT sv.securityReportID, sv.reportDate, sv.complaint, sv.resolution, it.incidentType, po.policydesc, pe.penaltyfee, concat(mp.title, ' - ', mp.description) AS 'mappoint', vs.status, concat(u1.fname, ' ', u1.lname) AS 'boardmember', concat(u2.fname, ' ', u2.lname) AS 'securityperson', concat(u3.fname, ' ', u3.lname) AS 'complainant', u2a.otherparty AS 'accused' FROM security_violations sv JOIN ref_incidenttype it ON sv.incidentTypeID = it.incidentTypeID JOIN policies po ON sv.violatedpolicyID = po.policyID JOIN penalties pe ON po.penaltyID = pe.penaltyID JOIN mappoint mp ON sv.mappointID = mp.mappointID JOIN ref_violationstatus vs ON sv.status = vs.statusID LEFT JOIN users u1 ON sv.boardmemberID = u1.userID LEFT JOIN users u2 ON sv.securityID = u2.userID JOIN user2anyone u2a ON sv.securityReportID = u2a.securityReportID LEFT JOIN users u3 ON u2a.userID = u3.userID WHERE sv.securityReportID = " +reportID + ";";
                        
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next())
                {
                    report = new Report(rs.getInt("securityReportID"), rs.getString("reportDate"), rs.getString("complaint"), rs.getString("resolution"), rs.getString("incidentType"), rs.getString("policydesc"), rs.getDouble("penaltyfee"), rs.getString("mappoint"), rs.getString("status"), rs.getString("boardmember"), rs.getString("securityPerson"), rs.getString("complainant"), rs.getString("accused"), "N/A", "N/A");
                }
            }
        }
        
        return report;
    }
    
    public static void Vehicle2User(Connection conn, int reportId, String userId, String plate)
    {
        int securityReportID = reportId;
        String userID = userId;
        String platenum = plate;
        
        String sql = "INSERT INTO vehicle2user (securityReportID, userID, platenum) VALUES (" + securityReportID + ", '" + userID + "', '" + platenum + "');";
        
        try 
        {
            PreparedStatement ps = conn.prepareStatement(sql);
            int isInserted = ps.executeUpdate();
            if (isInserted != 0)
            {
                System.out.print("Report Submitted");
            }
        }
        catch(SQLException e) {}
    }
    
    public static void Vehicle2Vehicle(Connection conn, int reportId, String userId, String plate)
    {
        int securityReportID = reportId;
        String accplate = plate;
        String complate = null;
        
        String sql = "SELECT plateNum FROM user_vehicles WHERE userID = '" + userId + "';";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                complate = rs.getString("plateNum");
            }
            
            sql = "INSERT INTO vehicle2vehicle (securityReportID, complainantplatenum, accusedplatenum) VALUES (" + securityReportID + ", '" + complate + "', '" + accplate + "');";
        
            try 
            {
                ps = conn.prepareStatement(sql);
                int isInserted = ps.executeUpdate();
                if (isInserted != 0)
                {
                    System.out.print("Report Submitted");
                }
            }
            catch(SQLException e) {}
        }
        catch (SQLException e) {}
    }
    
    public static void User2User(Connection conn, int reportId, String userId1, String userId2)
    {
        int securityReportID = reportId;
        String userID1 = userId1;
        String userID2 = userId2;
        
        String sql = "INSERT INTO user2user (securityReportID, complainant_userID, accused_userID) VALUES (" + securityReportID + ", '" + userID1 + "', '" + userID2 + "');";
        
        try 
        {
            PreparedStatement ps = conn.prepareStatement(sql);
            int isInserted = ps.executeUpdate();
            if (isInserted != 0)
            {
                System.out.print("Report Submitted");
            }
        }
        catch(SQLException e) {}
    }
    
    public static void User2Anyone(Connection conn, int reportId, String userId, String otherparty)
    {
        int securityReportID = reportId;
        String userID = userId;
        String other = otherparty;
        
        String sql = "INSERT INTO user2anyone (securityReportID, userID, otherparty) VALUES (" + securityReportID + ", '" + userID + "', '" + other + "');";
        
        try 
        {
            PreparedStatement ps = conn.prepareStatement(sql);
            int isInserted = ps.executeUpdate();
            if (isInserted != 0)
            {
                System.out.print("Report Submitted");
            }
        }
        catch(SQLException e) {}
    }
    
    public static ArrayList<String> getEvidencePhotos(Connection conn, int reportId) throws SQLException
    {
        int reportID = reportId;
        
        ArrayList<String> results = new ArrayList();
        String sql = "SELECT d.documentLocation FROM security_violations sv JOIN photoevidences pe ON sv.securityReportID = pe.securityReportID JOIN documents d ON pe.documentID = d.documentID WHERE sv.securityReportID = " + reportID + ";";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            results.add(rs.getString("documentLocation"));
        }
        
        return results;
    }
    
    public static void resolveReport (Connection conn, int reportId, String re) throws SQLException
    {
        int reportID = reportId;
        String resolution = re;
        
        String sql = "UPDATE security_violations SET resolution = ?, status = ? WHERE securityReportID = " + reportID + ";";
        
        try 
        {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, resolution);
            ps.setInt(2, 5);
            int isInserted = ps.executeUpdate();
            if (isInserted != 0)
            {
                System.out.print("Report Submitted");
            }
        }
        catch(SQLException e) {}
    }
    
    public static void changeStatusToInvestigate(Connection conn, int reportId) throws SQLException
    {
        int reportID = reportId;
        
        String sql = "SELECT status FROM security_violations WHERE securityReportID = " + reportID + ";";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            if (rs.getInt("status") != 5)
            {
                sql = "UPDATE security_violations SET status = ? WHERE securityReportID = " + reportID + ";";
        
                try 
                {
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, 2);
                    int isInserted = ps.executeUpdate();
                    if (isInserted != 0)
                    {
                        System.out.print("Report Submitted");
                    }
                }
                catch(SQLException e) {}
            }
        }
    }
    
    public static int getLastTransactionID(Connection conn) throws SQLException
    {
        int lastId = 0;
        String sql = "SELECT trxID FROM trxreferences ORDER BY trxID DESC LIMIT 1;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            lastId = rs.getInt("trxID");
        }
        
        return lastId;
    }
    
    public static int getLastJournalID(Connection conn) throws SQLException
    {
        int lastId = 0;
        String sql = "SELECT JournalID FROM transaction_journal ORDER BY JournalID DESC LIMIT 1;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next())
        {
            lastId = rs.getInt("JournalID");
        }
        
        return lastId;
    }
    
    public static void payPenalty (Connection conn, int reportId, double payment, double penalty) throws SQLException
    {
        int reportID = reportId;
        double amount = payment;
        double cost = penalty;
        int lastID = ReportsDAO.getLastTransactionID(conn) + 1;
        int lastJournal = ReportsDAO.getLastJournalID(conn) + 1;
        
        String sys = String.valueOf(LocalDateTime.now());
        String date  = sys.substring(0,10);
        
        String sql = "INSERT INTO `hoa`.`trxreferences` (`trxID`, `amount`, `interest`, `totalamount`, `txnDate`) VALUES (?, ?, '0.00', ?, ?);";
        String sql2 = "INSERT INTO `hoa`.`transaction_journal` (`JournalID`, `trxDate`, `trxAmnt`, `trxAmntPaid`) VALUES (?, ?', ?, ?);";
        String sql3 = "INSERT INTO `hoa`.`trxlist` (`journalID`, `trxID`, `amountpaid`) VALUES (?, ?, ?);";
        
        try 
        {
            PreparedStatement ps = conn.prepareStatement(sql);
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            
            ps.setInt(1, lastID); ps.setDouble(2, cost); ps.setDouble(3, cost); ps.setString(4, date);
            ps2.setInt(1, lastJournal); ps2.setString(2, date); ps2.setDouble(3, cost); ps2.setDouble(4, amount);
            ps3.setInt(1, lastJournal); ps3.setInt(2, lastID); ps3.setDouble(3, amount);
            
            int isInserted = ps.executeUpdate();
            int isInserted2 = ps2.executeUpdate();
            int isInserted3 = ps3.executeUpdate();
            
            if (isInserted + isInserted2 + isInserted3 != 0)
            {
                System.out.print("Report Submitted");
            }
        }
        catch(SQLException e) {}
    }
}
