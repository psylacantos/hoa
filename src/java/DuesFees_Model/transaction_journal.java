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
public class transaction_journal {
    
    protected int journalID;
    protected String trxDate;
    protected int trxAmount;
    protected int amtPaid;
    protected String status;
    
    protected transaction_journal(int journalID, String trxDate, int trxAmount, int amtPaid, String status){
        this.journalID = journalID;
        this.trxDate = trxDate;
        this.trxAmount = trxAmount;
        this.amtPaid = amtPaid;
        this.status = status;                
    }
    
    protected int getJournalID(){
        return journalID;
    }
    
    protected String getTrxDate(){
        return trxDate;
    }
    
    protected int getTrxAmount(){
        return trxAmount;
    }
    
    protected int getAmtPaid(){
        return amtPaid;
    }
    
    protected String getStatus(){
        return status;
    }
    
}
