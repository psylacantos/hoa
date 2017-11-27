package model;

import java.io.Serializable;

public class Plate implements Serializable
{
    private String platenum;
    
    
    public Plate() {}
    
    public Plate(String platenum)
    {
        this.platenum = platenum;
    }
    
    public String getPlateNum() { return platenum; }
}
