package Model;

import java.sql.Date;

public class Registration_Request
{
    private String userID;
    private String passwd;
    private String lname;
    private String fname;
    private String mname;
    private Date bDate;
    private int photoID;
    private String occupation;
    private int occupationID;
    private long telNum;
    private long mobileNum;
    private int blocknum;
    private int lotnum;
    private Date movingIn;
    private boolean approved;

    public Registration_Request(String userID, String passwd, String lname, String fname, String mname, Date bDate, int photoID, String occupation, long telNum, long mobileNum, int blocknum, int lotnum, Date movingIn) {
        this.userID = userID;
        this.passwd = passwd;
        this.lname = lname;
        this.fname = fname;
        this.mname = mname;
        this.bDate = bDate;
        this.photoID = photoID;
        this.occupation = occupation;
        this.telNum = telNum;
        this.mobileNum = mobileNum;
        this.blocknum = blocknum;
        this.lotnum = lotnum;
        this.movingIn = movingIn;
        this.approved = false;
        occupationID = -1;
        
    }
    
    public Registration_Request(String userID, String passwd, String lname, String fname, String mname, Date bDate, int photoID, int occupationID, long telNum, long mobileNum, int blocknum, int lotnum, Date movingIn) {
        this.userID = userID;
        this.passwd = passwd;
        this.lname = lname;
        this.fname = fname;
        this.mname = mname;
        this.bDate = bDate;
        this.photoID = photoID;
        this.occupationID = occupationID;
        this.telNum = telNum;
        this.mobileNum = mobileNum;
        this.blocknum = blocknum;
        this.lotnum = lotnum;
        this.movingIn = movingIn;
        this.approved = false;
        this.occupation = occupation;
        
    }

    public int getOccupationID() {
        return occupationID;
    }

    public void setOccupationID(int occupationID) {
        this.occupationID = occupationID;
    }

    
    public Date getMovingIn() {
        return movingIn;
    }

    public void setMovingIn(Date movingIn) {
        this.movingIn = movingIn;
    }
    

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupationID(String occupation) {
        this.occupation = occupation;
    }

    public long getTelNum() {
        return telNum;
    }

    public void setTelNum(int telNum) {
        this.telNum = telNum;
    }

    public long getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(int mobileNum) {
        this.mobileNum = mobileNum;
    }

    public int getBlocknum() {
        return blocknum;
    }

    public void setBlocknum(int blocknum) {
        this.blocknum = blocknum;
    }

    public int getLotnum() {
        return lotnum;
    }

    public void setLotnum(int lotnum) {
        this.lotnum = lotnum;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
    
    
}
