/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author BadgerinoTwo
 */
public class USERS {
    protected String userID;
    public String passwd;
    protected int usertypeID;
    public String lname;
    public String fname;
    public String mame;
    public Date bDate;
    protected int photoID;
    protected int occupationID;
    public Date movingIn;
    protected int movingOutclearID;
    protected int trxID;
    protected String username;
    
    public void setUsername (String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getUserID(){
        return userID;
    }
    public void setUserTypeID(int usertypeID){
        this.usertypeID = usertypeID;
    } 
    public int getUserTypeID(){
        return usertypeID;
    }
    public void setPhotoID(int photoID){
        this.photoID = photoID;
    }
    public int getPhotoID(){
        return photoID;
    }
    public void setOccupationID(int occupationID){
        this.occupationID = occupationID;
    }
    public int getOccupationID(){
        return occupationID;
    }
    public void setMovingOutclearID(int movingOutclearID){
        this.movingOutclearID = movingOutclearID;
    }
    public int getMovingOutclearID(){
        return movingOutclearID;
    }
    public void setTrxID(int trxID){
        this.trxID = trxID;
    }
    public int getTrxID(){
        return trxID;
    }
}
