/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.io.Serializable;

/**
 *
 * @author Kayle Tiu
 */
public class refProperty implements Serializable {
    protected int blocknum;
    protected int lotnum;
    
    public refProperty (int blocknum, int lotnum){
        this.blocknum = blocknum;
        this.lotnum = lotnum;
    }

    /**
     * @return the blocknum
     */
    public int getBlocknum() {
        return blocknum;
    }

    /**
     * @return the lotnum
     */
    public int getLotnum() {
        return lotnum;
    }

    /**
     * @param blocknum the blocknum to set
     */
    public void setBlocknum(int blocknum) {
        this.blocknum = blocknum;
    }

    /**
     * @param lotnum the lotnum to set
     */
    public void setLotnum(int lotnum) {
        this.lotnum = lotnum;
    }
    
    
}
