/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author Kayle Tiu
 */
public class monthlyDues implements Serializable{
    protected int id;
    protected int month;
    protected int year;
    protected double amt;
    protected int rmdID;
    
    public monthlyDues(int month, int year, double amt, int rmdID){
        try {
            this.id = 1;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","swengg", null);
            PreparedStatement psID = connection.prepareStatement("SELECT * FROM MONTHLYDUES ORDER BY 1 DESC LIMIT 1");
            ResultSet rsID = psID.executeQuery();
            
            while (rsID.next()){
                this.id = rsID.getInt("mdID") + 1;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        this.month = month;
        this.year = year;
        this.amt = amt;
        this.rmdID = rmdID;
    }
    
    public void insValues(){
        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","swengg", null);
            PreparedStatement psInsMD = connection.prepareStatement("INSERT INTO MONTHLYDUES (mdID, month, year, amount, mduesID) VALUES (?,?,?,?,?)");
            psInsMD.setInt(1, this.getId());
            psInsMD.setInt(2, this.getMonth());
            psInsMD.setInt(3, this.getYear());
            psInsMD.setDouble(4, this.getAmt());
            psInsMD.setInt(5, this.getRmdID());
            psInsMD.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
       
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the amt
     */
    public double getAmt() {
        return amt;
    }

    /**
     * @return the rmdID
     */
    public int getRmdID() {
        return rmdID;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @param amt the amt to set
     */
    public void setAmt(double amt) {
        this.amt = amt;
    }

    /**
     * @param rmdID the rmdID to set
     */
    public void setRmdID(int rmdID) {
        this.rmdID = rmdID;
    }
    
}
