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
public class TrxList implements Serializable{
    
    protected int journalID;
    protected int trxID;
    public double amountpaid;
    public String status;
    
    public TrxList(){}
    
    /**
     * Constructor for the TrxList Model
     * @param journalID journal id from transaction journal table
     * @param trxID trxID from trxReference table
     * @param amountPaid amount paid
     */
    public TrxList(int journalID,int trxID,double amountPaid,String status)
    {
        this.journalID=journalID;
        this.trxID=trxID;
        this.amountpaid=amountPaid;
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
     * @return 
     */
    public int getJournalID(){
        return journalID;
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
    /**
     * This method will set the value of amountpaid
     * @param amountpaid 
     */
    public void setAmount(double amountpaid)
    {
        this.amountpaid=amountpaid;
    }
    /**
     * This method will return the value of amountpaid
     * @return amountpaid
     */
    public double getAmount()
    {
        return amountpaid;
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
     * This method will set the value of status
     * @return status
     */
    public String getStatus()
    {
        return status;
    }
    
}
