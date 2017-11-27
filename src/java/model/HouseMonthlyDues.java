/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author eabiii
 */
import java.io.*;
import java.util.*;
public class HouseMonthlyDues implements Serializable{
    protected int  blockNum;
    protected int lotNum;
    protected int mdID;
    protected int trxID;
    
    public HouseMonthlyDues(){}
    
    /**
     * Constructor for the HouseMonthlyDues Model
     * 
     * @param blockNum block number
     * @param lotNum lot number
     * @param mdID monthly dues id
     * @param trxID transaction id
     */
    
    public HouseMonthlyDues(int blockNum,int lotNum,int mdID,int trxID)
    {
        this.blockNum=blockNum;
        this.lotNum=lotNum;
        this.mdID=mdID;
        this.trxID=trxID;
    }
    
    
    /**
     * This method will set the value of blockNum
     * @param blockNum 
     */
    
     public void setBlockNum(int blockNum){
        this.blockNum=blockNum;
    }
     /**
      * This method returns the value of blockNum
      * @return blockNum
      */
    
    public int getBlockNum(){
        return blockNum;
    }
    
    /**
     * This method will set the value of lotNum
     * @param lotNum 
     */
    
    public void setLotNum(int lotNum){
        this.lotNum=lotNum;
    }
    
    /**
     * This method will return the value of blockNum
     * @return lotNum
     */
    
    public int getLotNum(){
        return lotNum;
    }
    /**
     * This method will set the value of MdID
     * @param mdID 
     */
    
    public void setMdID(int mdID){
        this.mdID=mdID;
    }
    /**
     * This method will return the value of MdID
     * @return 
     */
    
    public int getMdID(){
        return mdID;
    }
    /**
     * This method will set the value of trxID
     * @param trxID 
     */
    
    public void setTrxID(int trxID){
        this.trxID=trxID;
    }
    
    /**
     * This method will return the value of trxID
     * @return 
     */
    
    public int getTrxID(){
        return trxID;
    }
            
    
}
