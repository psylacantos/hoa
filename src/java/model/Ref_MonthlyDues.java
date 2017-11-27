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
public class Ref_MonthlyDues implements Serializable{
    private int mDues;
    public int startMonth;
    public int startYear;
    public int endMonth;
    public int endYear;
    public double amountApproved;
    
    public Ref_MonthlyDues(){}
    
    /**
     * Constructo for the Ref_MonthlyDues
     * @param mDues
     * @param startMonth
     * @param startYear
     * @param endMonth
     * @param endYear
     * @param amountApproved 
     */
    
    public Ref_MonthlyDues(int mDues, int startMonth, int startYear, int endMonth, int endYear, double amountApproved){
        this.mDues=mDues;
        this.startMonth=startMonth;
        this.startYear=startYear;
        this.endMonth=endMonth;
        this.endYear=endYear;
        this.amountApproved=amountApproved;
        
    }
    /**
     * This method will set the value of mDues
     * @param mDues 
     */
    
    public void setMDues(int mDues){
        this.mDues=mDues;
    }
    
    /**
     * This method will return the value of blockNum
     * @return blockNum
     */
    public int getMDues(){
        return mDues;
    }
    
    public void setAmount(double amountApproved)
    {
        this.amountApproved=amountApproved;
    }
    
    public double getAmount()
    {
        return amountApproved;
    }
    
    
    
}
