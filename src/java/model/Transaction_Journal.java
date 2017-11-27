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

public class Transaction_Journal implements Serializable{
    private int journalID;
    public Date trxDate;
    public double trxAmt;
    public double trxAmtPaid;
    public String status;
    public Transaction_Journal(){}
    
    /**
     * Constructor for the Transaction_Journal Model
     * @param journalID unique id
     * @param trxDate Date
     * @param trxAmt total amount
     * @param trxAmtPaid total amount paid
     */
    public Transaction_Journal(int journalID, Date trxDate, double trxAmt, double trxAmtPaid,String status){
        this.journalID=journalID;
        this.trxDate=trxDate;
        this.trxAmt=trxAmt;
        this.trxAmtPaid=trxAmtPaid;
        this.status=status;
    }
    
    /**
     * This method will set the value of journalID
     * @param journalID 
     */
    public void setJournalID(int journalID){
        this.journalID=journalID;
    }
    /**
     * This method will return the value of journalID
     * @return journalID
     */
    public int getJournalID(){
        return journalID;
    }
    /**
     * This method will set the value of trxDate
     * @param trxDate 
     */
    public void setDate(Date trxDate)
    {
       this.trxDate=trxDate; 
    }
    
    /**
     * This method will return the value of trxDate
     * @return trxDat
     */
    public Date getDate()
    {
        return trxDate;
    }
    /**
     * This method will set the value of trxAmt
     * @param trxAmt 
     */
    public void setTrxAmt(double trxAmt)
    {
        this.trxAmt=trxAmt;
    }
    /**
     * This method will return the value of trxAmt
     * @return trxAmt
     */
    public double getTrxAmt()
    {
        return trxAmt;
    }
    /**
     * This method will set the value of trxAmtPaid
     * @param trxAmtPaid 
     */
    
    public void settrxAmtPaid(double trxAmtPaid)
    {
        this.trxAmtPaid=trxAmtPaid;
    }
    /**
     * This method will return the value of trxAmtPaid
     * @return 
     */
    public double getTrxAmtPaid()
    {
        return trxAmtPaid;
    }
    /**
     * This method will set the value of status
     * @param status 
     */
    
    public void setStatus(String status)
    {
        this.status=status;
    }
    /**
     * This method will get the value of status
     * @return status
     */
    public String getStatus()
    {
        return status;
    }
    
    
}
