package model;

import java.io.Serializable;

public class Incident implements Serializable
{
    private int incidentId;
    private String incidentType;
    
    public Incident() {}
    
    public Incident(int incidentId, String incidentType)
    {
        this.incidentId = incidentId;
        this.incidentType = incidentType;
    }
    
    public int getIncidentID() { return incidentId; }
    public void setIncidentID(int reportId) { this.incidentId = incidentId; }
    
    public String getIncidentType() { return incidentType; }
    public void setIncidentType(String reportId) { this.incidentType = incidentType; }
}
