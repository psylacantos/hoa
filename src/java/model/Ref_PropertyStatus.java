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
public class Ref_PropertyStatus {
    private int propertystatusID;
    public String propertystatus;
    
    public Ref_PropertyStatus(){}
    
    /**
     * Constructor for the Ref_PropertyStatus
     * @param propertystatusID
     * @param propertyStatus 
     */
    public Ref_PropertyStatus(int propertystatusID, String propertyStatus)
    {
        this.propertystatusID=propertystatusID;
        this.propertystatus=propertyStatus;
    
    }
    /**
     * This method will set the value of propertystatusID
     * @param propertystatusID 
     */
    public void setPropertStatusID(int propertystatusID)
    {
        this.propertystatusID=propertystatusID;
    }
    
    /**
     * This method will return the value of propertystatusID
     * @return 
     */
    public int getPropertyStatusID()
    {
        return propertystatusID;
    }
    
    
    
}
