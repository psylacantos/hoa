/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.Date;

/**
 *
 * @author BadgerinoTwo
 */
public class STICKERINVENTORY {
    /**
    * Unique identification of the sticker.
    * <p>
    */
    protected int stickerID;
    /**
    * Year when the sticker was made.
    * <p>
    */
    public int stickerYear;
    /**
    * Cost of the sticker.
    * <p>
    */
    public double cost;
    /**
    * Date when the sticker was released.
    * <p>
    */
    public Date dateReleased;
    /**
    * Sets the stickerID integer attribute of a sticker. 
    * The stickerID should be less or equal to 9 digits.
    * <p>
    * @param  stickerID  an integer that defines the identification of the sticker.
    */
    public void setStickerID(int stickerID){
        this.stickerID = stickerID;
    }
    /**
    * Returns the stickerID integer attribute of a sticker. 
    * <p>
    * @return  the sticker identification of the sticker as an integer attribute (stickerID).
    */
    public int getStickerID(){
        return stickerID;
    }
}
