package model;

import java.util.Date;

public class BoardMember{
	private String id;
	private int positionID;
	public String effectiveDate;
	public String endDate;
	public int	statusID;
	public int electionID;

	public BoardMember(String id, int positionID, String effectiveDate, String endDate, int statusID, int electionID) {
		super();
		this.id = id;
		this.positionID = positionID;
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
		this.statusID = statusID;
		this.electionID = electionID;
	}
	
	public String getId() {
		return id;
	}
	
	public int getPositionID() {
		return positionID;
	}
	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}
	
}
