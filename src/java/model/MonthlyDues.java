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
public class MonthlyDues implements Serializable{
    private int mdID;
    public int month;
    public int year;
    public double amount;
    protected int mDues;
    
    public MonthlyDues(){}
    /**
     * Constructor for the MonthlyDues Model
     * 
     * @param mdID unique id
     * @param month month
     * @param year year
     * @param amount amount of dues
     * @param mDues id
     */
    
    public MonthlyDues(int mdID, int month, int year, double amount, int mDues)
    {
        this.mdID=mdID;
        this.month=month;
        this.year=year;
        this.amount=amount;
        this.mDues=mDues;
    }
    
    


    
    /**
     * This method will set the value of MdID
     * @param mdID 
     */
    
    public void setMdID(int mdID){
        this.mdID=mdID;
    }
    
    public double getAmount()
    {
        return amount;
    }
    
    /**
     * This method will return the value of blockNum
     * @return 
     */
    
    public int getMdID(){
        return mdID;
    }
    
    /**
     * This method will set the value of month
     * @param month 
     */
    
    public void setMonth(int month){
        this.month=month;
    }
    
    /**
     * This method will set the value of Month
     * @return 
     */
    
    public int getMonth(){
        return month;
    }
    
    public void setYear(int year){
        this.year=year;
    }
    
    /**
     * This method will set the value of Month
     * @return 
     */
    
    public int getYear(){
        return year;
    }
    
 
    
    
     
     
    
    
}
