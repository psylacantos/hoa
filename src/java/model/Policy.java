package model;

import java.io.Serializable;
import java.util.ArrayList;
import dao.PolicyDao;

public class Policy implements Serializable
{
    private int policyId;
    private String policydesc;
    private int penaltyID;
    private int documentID;
    private String enactment;
    private String stopimplementDate;
    private String enabler;
    private String state;
    private ArrayList<String> affected = new ArrayList<String>();

    public Policy(){

    }
    
    public Policy(int policyId, String policydesc)
    {
        this.policyId = policyId;
        this.policydesc = policydesc;
    }

    public Policy(int ID,String desc,int penalty,int document,String enact,String stopped,String enabler,String state,ArrayList<String> affected){

        policyId = ID;
        policydesc = desc;
        this.penaltyID = penalty;
        this.documentID = document;
        enactment = enact;
        stopimplementDate = stopped;
        this.enabler = enabler;
        this.state = state;
        this.affected = (ArrayList<String>) affected.clone();
    }
    
    public Policy(int id,String desc,int penalty,int document,String enabler,String state,ArrayList<String> affected){
		
		policyId = id;
		policydesc = desc;
		this.penaltyID = penalty;
		this.documentID = document;
		enactment = "9999-12-31";
		stopimplementDate = "9999-12-31";
		this.enabler = enabler;
		this.state = state;
		this.affected = (ArrayList<String>) affected.clone();
		}
        
        public Policy(String desc,int penalty,int document,String enabler,String state,ArrayList<String> affected){
		PolicyDao p = new PolicyDao();
		policyId = p.getMaxID();
		policydesc = desc;
		this.penaltyID = penalty;
		this.documentID = document;
		enactment = "9999-12-31";
		stopimplementDate = "9999-12-31";
		this.enabler = enabler;
		this.state = state;
		this.affected = (ArrayList<String>) affected.clone();
		}

	public int getPolicyID() {
		return policyId;
	}
        
        

	
	public String getPolicydesc() {
		return policydesc;
	}

	public void setPolicydesc(String policydesc) {
		this.policydesc = policydesc;
	}

	public int getPenalty() {
		return penaltyID;
	}

	public void setPenalty(int penalty) {
		this.penaltyID = penalty;
	}

	public int getDocument() {
		return documentID;
	}

	public void setDocument(int document) {
		this.documentID = document;
	}

	public String getEnactment() {
		return enactment;
	}

	public void setEnactment(String enactment) {
		this.enactment = enactment;
	}

	public String getStopimplementDate() {
		return stopimplementDate;
	}

	public void setStopimplementDate(String stopimplementDate) {
		this.stopimplementDate = stopimplementDate;
	}

	public String getEnabler() {
		return enabler;
	}

	public void setEnabler(String enabler) {
		this.enabler = enabler;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<String> getAffected() {
		return affected;
	}

	public void setAffected(ArrayList<String> affected) {
		this.affected = affected;
	}

    
    
    public String getPolicyDescription() { return policydesc; }
}
