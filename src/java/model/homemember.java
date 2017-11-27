package Model;

public class homemember 
{
    private String userid;
    private String fname_homemember;
    private String lname_homemember;
    private boolean renting;
    private int blocknum;
    private int lotnum;
    private String status;

    public homemember(String userid, String fname_homemember, String lname_homemember, boolean renting, int blocknum, int lotnum, String status) 
    {
        this.userid = userid;
        this.fname_homemember = fname_homemember;
        this.lname_homemember = lname_homemember;
        this.renting = renting;
        this.blocknum = blocknum;
        this.lotnum = lotnum;
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFname_homemember() {
        return fname_homemember;
    }

    public void setFname_homemember(String fname_homemember) {
        this.fname_homemember = fname_homemember;
    }

    public String getLname_homemember() {
        return lname_homemember;
    }

    public void setLname_homemember(String lname_homemember) {
        this.lname_homemember = lname_homemember;
    }

    public boolean isRenting() {
        return renting;
    }

    public void setRenting(boolean renting) {
        this.renting = renting;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
