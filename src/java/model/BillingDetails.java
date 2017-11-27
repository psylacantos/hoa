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
public class BillingDetails implements Serializable{
    /**
     * Billing Details Model
     * 
     */
    protected int billingID;
    protected int trxID;
    public String status;
    
    public BillingDetails(){}
    /**
     * Contructor for the Billing Details
     * @param billingID billing id
     * @param trxID transaction id
     */
    public BillingDetails(int billingID, int trxID){
        this.billingID=billingID;
        this.trxID=trxID;
    }
        public BillingDetails(int billingID, int trxID,String status){
        this.billingID=billingID;
        this.trxID=trxID;
        this.status=status;
    }
    /**
     * This method will set the value of billingID
     * 
     * @param billingID 
     */
    
    public void setBillingID(int billingID){
        this.billingID=billingID;
    }
    /**
     * This method returns the value BillingID
     * 
     * @return  
     */
    
    public int getBillingID(){
        return billingID;
    }
    
    /**
     * This method will set the value of trxID
     * 
     * @param trxID 
     */
    
    
    public void setTrxID(int trxID){
        this.trxID=trxID;
    }
    
    /**
     * This method returns trxID
     * 
     * @return trxID
     */
    
    public int getTrxID(){
        return trxID;
    }
    /**
     * Sets Status
     * @param status 
     */
    
    public void setStatus(String status){
        this.status=status;
    }
    
    /**
     * Gets Status
     * 
     * @return status
     */
    
    public String getStatus(){
        return status;
    }
    
}
