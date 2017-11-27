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
public class PaymentDetails implements Serializable {
    
    protected int billingID;
    protected int journalID;
    protected int trxID;
    public String status;
    
    public PaymentDetails(){}
    /**
     * Constructor for the PaymentDetails Model
     * @param billingID billing id from billing table
     * @param journalID journal id from trxList
     * @param trxID trxID from trxList
     */
    public PaymentDetails(int billingID, int journalID,int trxID,String status)
    {
        this.billingID=billingID;
        this.journalID=journalID;
        this.trxID=trxID;
        this.status=status;
    }
    /**
     * This method will set the value of billingID
     * @param billingID 
     */
    public void setBillingID(int billingID)
    {
        this.billingID=billingID;
    }
    /**
     * This method will return the value of billingID
     * @return billingID
     */
    public int getBillingID()
    {
        return billingID;
    }
    /**
     * This method will set the value of journalID
     * @param journalID 
     */
    public void setJournalID(int journalID)
    {
        this.journalID=journalID;
    }
    /**
     * This method will get the value of blockNum
     * @return journalID
     */
    
    public int getJournalID()
    {
        return journalID;
    }
    
    /**
     * This method will set the value of trxID
     * @param trxID 
     */
    public void setTrxID(int trxID)
    {
        this.trxID=trxID;
    }
    
    /**
     * This method will get the value of blockNum
     * @return 
     */
    public int getTrxID()
    {
        return trxID;
    }
    /**
      * Sets status
      * @param status 
      */
    
     public void setStatus(String status)
     {
         this.status=status;
     }
     /**
      * Returns status
      * @return status
      */
     public String getStatus()
     {
         return status;
     }
    
    
}
