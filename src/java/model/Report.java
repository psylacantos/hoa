package model;

import java.io.Serializable;

public class Report implements Serializable
{    
    private int reportId;
    private String reportDate;
    private int incidentId;
    private String incidentType;
    private String complaint;
    private String complainant;
    private String accused;
    private int status;
    private String statusDesc;
    private String resolution;
    private int trxId;
    private String boardMemberId;
    private String securityId;
    private int policyId;
    private String policyDesc;
    private int mapId;
    private String boardMember;
    private String securityPerson;
    private String mappoint;
    private double penalty;
    private String comPlate;
    private String accPlate;
    
    public Report () {}
    
    public Report (int reportId, String reportDate, int status, int incidentId, String complaint, int policyId, int mapId)
    {
        this.reportId = reportId;
        this.reportDate = reportDate;
        this.status = status;
        this.incidentId = incidentId;
        this.complaint = complaint;
        this.policyId = policyId;
        this.mapId = mapId;
    }
    
    public Report (int reportId, String reportDate, String incidentType, String complainant, String complaint, String accused, String statusDesc)
    {
        this.reportId = reportId;
        this.reportDate = reportDate;
        this.incidentType = incidentType;
        this.complainant = complainant;
        this.complaint = complaint; 
        this.accused = accused;
        this.statusDesc = statusDesc;
    }
    
    public Report (int reportId, String reportDate, String complaint, String resolution, String incidentType, String policyDesc, double penalty, String mappoint, String statusDesc, String boardMember, String securityPerson, String complainant, String accused, String comPlate, String accPlate)
    {
        this.reportId = reportId;
        this.reportDate = reportDate;
        this.complaint = complaint;
        this.resolution = resolution;
        this.incidentType = incidentType;
        this.policyDesc = policyDesc;
        this.penalty = penalty;
        this.mappoint = mappoint;
        this.statusDesc = statusDesc;
        this.boardMember = boardMember;
        this.securityPerson = securityPerson;
        this.complainant = complainant;
        this.accused = accused;
        this.comPlate = comPlate;
        this.accPlate = accPlate;
    }
    
    public int getReportID() { return reportId; }
    public void setReportID(int reportId) { this.reportId = reportId; }
    
    public String getReportDate() { return reportDate; }
    public void setReportDate(String reportDate) { this.reportDate = reportDate; }
    
    public int getIncidentID() { return incidentId; }
    public void setIncidentID(int incidentId) { this.incidentId = incidentId; }
    
    public String getComplaint() { return complaint; }
    public void setComplaint(String complaint) { this.complaint = complaint; }
    
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    
    public String getResolution() { return resolution; }
    public void setResolution(String resolution) { this.resolution = resolution; }
    
    public int getTrxID() { return trxId; }
    public void setTrxID(int trxId) { this.trxId = trxId; }
    
    public String getBoardMemberID() { return boardMemberId; }
    public void setBoardMemberID(String boardMemberId) { this.boardMemberId = boardMemberId; }
    
    public String getSecurityID() { return securityId; }
    public void setSecurityID(String securityId) { this.securityId = securityId; }
    
    public int getPolicyID() { return policyId; }
    public void setPolicyID(int policyId) { this.policyId = policyId; }
    
    public int getMapPointID() { return mapId; }
    public void setMapPointID(int mapId) { this.mapId = mapId; } 
    
    public String getComplainant() { return complainant; }
    public void setComplainant(String complainant) { this.complainant = complainant; } 
    
    public String getIncidentType() { return incidentType; }
    public void setIncidentType(String incidentType) { this.incidentType = incidentType; } 
    
    public String getAccused() { return accused; }
    public void setAccused(String accused) { this.accused = accused; }
    
    public String getStatusDescription() { return statusDesc; }
    public void setStatusDescription(String statusDesc) { this.statusDesc = statusDesc; }
    
    public String getPolicyDescription() { return policyDesc; }
    public void setPolicyDescription(String policyDesc) { this.policyDesc = policyDesc; }
    
    public String getBoardMember() { return boardMember; }
    public void setBoardMember(String boardMember) { this.boardMember = boardMember; }
    
    public String getSecurityPerson() { return securityPerson; }
    public void setSecurityPerson(String securityPerson) { this.securityPerson = securityPerson; }
    
    public String getMapPoint() { return mappoint; }
    public void setMapPoint(String mappoint) { this.mappoint = mappoint; }
    
    public double getPenalty() { return penalty; }
    public void setPenalty(double penalty) { this.penalty = penalty; }
    
    public String getComplainantPlate() { return comPlate; }
    public void setComplainantPlate(String comPlate) { this.comPlate = comPlate; }
    
    public String getAccusedPlate() { return accPlate; }
    public void setAccusedPlate(String accPlate) { this.accPlate = accPlate; }
}