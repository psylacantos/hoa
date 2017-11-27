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
public class trxList {
    
    protected int journalID;
    protected int trxID;
    protected int amountPaid;
    protected String status;
    
    protected trxList(int journalID, trxReferences trxID, int amountPaid, String status){
        this.journalID = journalID;
        this.trxID = trxID.getTrxID();
        this.amountPaid = amountPaid;
        this.status = status;
    }
    
    protected int getAmountPaid(){
        return amountPaid;
    }
    
    protected String getStatus(){
        return status;
    }
    
    
}
