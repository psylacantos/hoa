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
import java.sql.Date;
public class Mappoint {
    
    private int mappointID;
    protected Ref_MappointCategory mappointcategoryID;
    public String xAxis;
    public String yAxis;
    public String title;
    public String description;
    public String userID;
    public Date createDate;
    public boolean removed;
    
    public Mappoint(){}
    /**
     * Constructor for the Mappoint Model
     * @param mappointID unique id
     * @param mappointcategoryID unique id
     * @param xAxis xAxis
     * @param yAxis yAxis
     * @param title title
     * @param description description
     * @param userID user's id
     * @param createDate date created
     * @param removed  removed
     */
    
    public Mappoint(int mappointID, Ref_MappointCategory mappointcategoryID, String xAxis, String yAxis, String title,String description, String userID, Date createDate, boolean removed)
    {
        this.mappointID=mappointID;
        this.mappointcategoryID=mappointcategoryID;
        this.xAxis=xAxis;
        this.yAxis=yAxis;
        this.title=title;
        this.description=description;
        this.userID=userID;
        this.createDate=createDate;
        this.removed=removed;
    }
    /**
     * This method will set mappointcategoryID
     * @param mappointcategoryID 
     */
    
    public void setMappointcategoryID(Ref_MappointCategory mappointcategoryID)
    {
        this.mappointcategoryID=mappointcategoryID;
    }
    /**
     * This method returns the value mappointcategoryID
     * @return mappointcategoryID
     */
    public Ref_MappointCategory getMappointcategoryID()
    {
        return mappointcategoryID;
    }
    
}
