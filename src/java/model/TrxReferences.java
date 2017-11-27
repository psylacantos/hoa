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

public class TrxReferences implements Serializable{
    private int trxID;
    public double amount;
    public double interest;
    public double totalAmount;
    public Date trxDate;
    
    public TrxReferences(){}
    
    /**
     * Constructor for the TrxReferences Model
     * @param trxID unique id
     * @param amount amount
     * @param interest interest
     * @param totalAmount amount +interest
     * @param trxDate Date of Transaction
     */
    public TrxReferences(int trxID,double amount, double interest, double totalAmount, Date trxDate){
        this.trxID=trxID;
        this.amount=amount;
        this.interest=interest;
        this.totalAmount=totalAmount;
        this.trxDate=trxDate;
    }
    
    /**
     * This method will set the value of trxID
     * @param trxID 
     */
    public void setTrxID(int trxID){
        this.trxID=trxID;
    }
    
    /**
     * This method will get the value of trxID
     * @return 
     */
    public int getTrxID(){
        return trxID;
    }
    public void setAmount(int amount){
        this.amount=amount;
    }
    
    /**
     * This method will get the value of trxID
     * @return 
     */
    public double getAmount(){
        return amount;
    }
    
    public void setTotalAmount(double totalAmount){
        this.totalAmount=totalAmount;
    }
    
    /**
     * This method will get the value of trxID
     * @return 
     */
    public double getTotalAmount(){
        return totalAmount;
    }
    
     public void setInterest(int interest){
        this.interest=interest;
    }
    
    /**
     * This method will get the value of trxID
     * @return 
     */
    public double getInterest(){
        return interest;
    }
    
     public void setDate(Date trxDate){
        this.trxDate=trxDate;
    }
    
    /**
     * This method will get the value of trxID
     * @return 
     */
    public Date getDate(){
        return trxDate;
    }
    
   
    
}
