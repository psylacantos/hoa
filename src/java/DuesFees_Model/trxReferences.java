/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DuesFees_Model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Kayle Tiu
 */
public class trxReferences implements Serializable {
    protected int id;
    protected double amt;
    protected double intr;
    protected double totamt;
    protected String date;
    
    public trxReferences(double amt, double intr, double totamt, int month, int year){
        try {
            this.id = 1;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","swengg", null);
            PreparedStatement psID = connection.prepareStatement("SELECT * FROM trxReferences ORDER BY 1 DESC LIMIT 1");
            ResultSet rsID = psID.executeQuery();
            
            while (rsID.next()){
                this.id = rsID.getInt("trxID") + 1;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        this.amt = amt;
        this.intr = intr;
        this.totamt = totamt;
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.getActualMaximum(Calendar.DAY_OF_MONTH) - 7;
        this.date = "" + year + "-" + month + "-" + day + "";
        
    }

    public void insValues(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","swengg", null);
            PreparedStatement psInsRMD = connection.prepareStatement("INSERT INTO trxReferences (trxID, amount, interest, totalamount, txnDate)"
                    + "VALUES (?,?,?,?,?)");
            psInsRMD.setInt(1, this.id);
            psInsRMD.setDouble(2, this.amt);
            psInsRMD.setDouble(3, this.intr);
            psInsRMD.setDouble(4, this.totamt);
            psInsRMD.setString(5, this.date);
            psInsRMD.executeUpdate();
        }
        catch (Exception e){
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
     * @return the amt
     */
    public double getAmt() {
        return amt;
    }

    /**
     * @return the intr
     */
    public double getIntr() {
        return intr;
    }

    /**
     * @return the totamt
     */
    public double getTotamt() {
        return totamt;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param amt the amt to set
     */
    public void setAmt(double amt) {
        this.amt = amt;
    }

    /**
     * @param intr the intr to set
     */
    public void setIntr(double intr) {
        this.intr = intr;
    }

    /**
     * @param totamt the totamt to set
     */
    public void setTotamt(double totamt) {
        this.totamt = totamt;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
}
