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
public class ref_properties {
    
    protected int blockNum;
    protected int lotNum;
    private int endLotNum;
    private String street;
    private int propertyStatusID;
    protected int mapPointID;
    
    protected ref_properties(int blocknum, int lotnum, int endlotnum, String street, int propertystatusID, int mappointID){
        this.blockNum = blocknum;
        this.lotNum = lotnum;
        this.endLotNum = endlotnum;
        this.street = street;
        this.propertyStatusID = propertystatusID;
        this.mapPointID = mappointID;
        
    }
    
    protected int getBlockNum(){
        return this.blockNum;
    }
    
    protected int getLotNum(){
        return this.lotNum;
    }
    
}
