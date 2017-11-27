/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author BadgerinoTwo
 */
public class VEHICLES {
    protected String platenum;
    public String model;
    public String make;
    public Date year;
    public boolean banned;
    
    public void setPlateNum(String platenum){
        this.platenum = platenum;
    }
    public String getPlateNum(){
        return platenum;
    }
}
