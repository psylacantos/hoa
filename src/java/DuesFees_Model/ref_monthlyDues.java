/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuesFees_Model;

/**
 *
 * @author Jean Rodriguez
 */
public class ref_monthlyDues {
    
    protected int mDuesID;
    protected int startMonth;
    protected int endMonth;
    protected int startYear;
    protected int endYear;
    protected int amountApproved;
    
    protected ref_monthlyDues(int mDuesID, int startmonth, int endmonth, int startyear, int endyear, int amountapproved){
        
        this.mDuesID = mDuesID;
        this.startMonth = startmonth;
        this.startYear = startyear;
        this.endMonth = endmonth;
        this.endYear = endyear;
        this.amountApproved = amountapproved;
    }
   
    protected int getMDuesID(){
        return this.mDuesID;
    }
    
    protected int getendMonth(){
        return this.endMonth;
    }
    
    protected int getendYear(){
        return this.endYear;
    }
    
    protected int getAmountApproved(){
        return this.amountApproved;
    }
}
