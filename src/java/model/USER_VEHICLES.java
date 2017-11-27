/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BadgerinoTwo
 */
public class USER_VEHICLES {
    protected String plateNum;
    protected String userID;
    protected int stickerID;
    public boolean stickerPaid;
    protected int trxID;
    protected String stickerissuedBy;
    
    public void setPlateNum(String plateNum){
        this.plateNum = plateNum;
    }
    public String getPlateNum(){
        return plateNum;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getUserID(){
        return userID;
    }
    public void setStickerID(int stickerID){
        this.stickerID = stickerID;
    }
    public int getStickerID(){
        return stickerID;
    }
    public void setTrxID(int trxID){
        this.trxID = trxID;
    }
    public int getTrxID(){
        return trxID;
    }
    public void setStickerIssuedBy(String stickerissuedBy){
        this.stickerissuedBy = stickerissuedBy;
    }
    public String getStickerIssuedBy(){
        return stickerissuedBy;
    }
}
