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
public class Billing implements Serializable{
    /**
     * 
     * 
     * 
     */
    
    private int billingID;
    protected int blockNum;
    protected int lotNum;
    private int precedentBilling;
    public double totalDue;
    public double totalPaid;
    public String desc;
    public String status;
    
    public Billing(){}
    /**
     * Main Constructor for the model
     * 
     * @param billingID unique ID
     * @param blockNum  BlockNum from Ref_Properties
     * @param lotNum    LotNum from Ref_Properties
     * @param precedentBilling previous bill
     * @param totalDue total amount
     * @param totalPaid total paid
     */
    public Billing(int billingID, int blockNum, int lotNum, int precedentBilling,double totalDue,double totalPaid)
    {
        this.billingID=billingID;
        this.blockNum=blockNum;
        this.lotNum=lotNum;
        this.precedentBilling=precedentBilling;
        this.totalDue=totalDue;
        this.totalPaid=totalPaid;             
    }
    /**
     * Second Constructor for the model
     * @param billingID unique ID
     * @param blockNum  BlockNum from Ref_Properties
     * @param lotNum    LotNum from Ref_Properties
     * @param precedentBilling previous bill
     * @param totalDue total amount
     * @param totalPaid total paid
     * @param desc description of payment
     * @param status status of payment(PAID,PENDING,OVERDUE)
     */
    public Billing(int billingID, int blockNum, int lotNum, int precedentBilling,double totalDue,double totalPaid,String desc,String status)
    {
        this.billingID=billingID;
        this.blockNum=blockNum;
        this.lotNum=lotNum;
        this.precedentBilling=precedentBilling;
        this.totalDue=totalDue;
        this.totalPaid=totalPaid;  
        this.desc=desc;
        this.status=status;
    }
    
    /**
     * Third Constructor for the model
     * @param blockNum  BlockNum from Ref_Properties
     * @param lotNum    LotNum from Ref_Properties
     * @param precedentBilling previous bill
     * @param totalDue total amount
     * @param totalPaid total paid
     */
    public Billing(int blockNum, int lotNum, int precedentBilling,double totalDue,double totalPaid)
    {
        this.blockNum=blockNum;
        this.lotNum=lotNum;
        this.precedentBilling=precedentBilling;
        this.totalDue=totalDue;
        this.totalPaid=totalPaid;             
    }
    /**
     * This method will set the value of billingID
     * @param billingID 
     */
    
    
    
    public void setID(int billingID)
    {
        this.billingID=billingID;
    }
    /**
     *  This method will set the value of billingID
     * @return billingID
     */
    
    public int getID()
    {
        return billingID;
    }
    
    /**
     * Sets totalDue
     * @param totalDue 
     */
    public void setTotalDue(double totalDue)
    {
        this.totalDue=totalDue;
    }
    /**
     * Returns totaldue
     * @return totalDue
     */
    public double getTotalDue()
    {
            return totalDue;
    }
    /**
     * Sets PrecedentBilling
     * @param precedentBilling 
     */
    public void setPrecedentBilling(int precedentBilling)
    {
        this.precedentBilling=precedentBilling;
    }
    /**
     * Gets Precedent Billing
     * @return 
     */
    public int getPrecedentBilling(){
        return precedentBilling;
    }
    /**
     * sets totalpaid
     * @param totalPaid 
     */
    
    public void setTotalPaid(double totalPaid)
    {
        this.totalPaid=totalPaid;
    }
    
    /**
     * Returns totalpaid
     * @return totalPaid
     */
    public double getTotalPaid()
    {
            return totalPaid;
    }
    
    /**
     * This method will set the value of blockNum
     * @param blockNum 
     */
    
    public void setBlockNum(int blockNum)
    {
        this.blockNum=blockNum;
           
    }
    /**
     * This method returns the value blockNum
     * 
     * 
     * @return blockNum 
     */
    
    public int getBlockNum()
    {
        return blockNum;
    }
    public void setLotNum(int lotNum)
    {
        this.lotNum=lotNum;
           
    }
    /**
     * This method returns the value blockNum
     * 
     * 
     * @return blockNum 
     */
    
    public int getLotNum()
    {
        return lotNum;
    }
    
    /**
     * Sets Description
     * @param desc 
     */
     public void setDesc(String desc)
     {
         this.desc=desc;
     }
     
     /**
      * Return description
      * @return desc
      */
     public String getDesc()
     {
         return desc;
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
