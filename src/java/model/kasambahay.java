package Model;

import java.sql.Date;

public class kasambahay 
{
    private String userid;
    private String fname_kasambahay;
    private String lname_kasambahay;
    private Date startDate;
    private Date endDate;
    private int blocknum;
    private int lotnum;
    private String status_kasambahay;

    public kasambahay(String userid, String fname_kasambahay, String lname_kasambahay, Date startDate, Date endDate, int blocknum, int lotnum, String status_kasambahay) {
        this.userid = userid;
        this.fname_kasambahay = fname_kasambahay;
        this.lname_kasambahay = lname_kasambahay;
        this.startDate = startDate;
        this.endDate = endDate;
        this.blocknum = blocknum;
        this.lotnum = lotnum;
        this.status_kasambahay = status_kasambahay;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFname_kasambahay() {
        return fname_kasambahay;
    }

    public void setFname_kasambahay(String fname_kasambahay) {
        this.fname_kasambahay = fname_kasambahay;
    }

    public String getLname_kasambahay() {
        return lname_kasambahay;
    }

    public void setLname_kasambahay(String lname_kasambahay) {
        this.lname_kasambahay = lname_kasambahay;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getStatus_kasambahay() {
        return status_kasambahay;
    }

    public void setStatus_kasambahay(String status_kasambahay) {
        this.status_kasambahay = status_kasambahay;
    }
    
    
}
