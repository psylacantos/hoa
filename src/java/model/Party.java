package model;

import java.io.Serializable;

public class Party implements Serializable
{
    private String userId;
    private String fname;
    private String lname;
    
    
    public Party() {}
    
    public Party(String userId, String fname, String lname)
    {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
    }
    
    public String getUserID() { return userId; }
    
    public String getFirstName() { return fname; }
    
    public String getLastName() { return lname; }
}
