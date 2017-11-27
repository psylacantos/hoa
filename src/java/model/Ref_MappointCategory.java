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
public class Ref_MappointCategory {
    
    private int mappointcategoryID;
    public String mappointcategory ;
    
    public Ref_MappointCategory(){}
    /**
     * Constructor for the Ref_MappointCategory
     * @param mappointcategoryID
     * @param mappointcategory 
     */
    public Ref_MappointCategory(int mappointcategoryID, String mappointcategory)
    {
        this.mappointcategoryID=mappointcategoryID;
        this.mappointcategory=mappointcategory;
    }
    
}
