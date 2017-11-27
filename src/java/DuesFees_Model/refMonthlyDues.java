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
public class refMonthlyDues implements Serializable {
    
    protected int id;
    protected int sMonth;
    protected int sYear;
    protected int eMonth;
    protected int eYear;
    protected double amtAppr;
    
    public refMonthlyDues(int sMonth, int sYear, int eMonth, int eYear, double amtAppr){
        try {
            this.id = 1;
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","swengg", null);
            PreparedStatement psID = connection.prepareStatement("SELECT * FROM REF_MONTHLYDUES ORDER BY 1 DESC LIMIT 1");
            ResultSet rsID = psID.executeQuery();
            
            while (rsID.next()){
                this.id = rsID.getInt("mduesID") + 1;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        
        this.sMonth = sMonth;
        this.sYear = sYear;
        this.eMonth = eMonth;
        this.eYear = eYear;
        this.amtAppr = amtAppr;
    }
    
    public void insValues(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","swengg", null);
            PreparedStatement psInsRMD = connection.prepareStatement("INSERT INTO REF_MONTHLYDUES (mduesID, startMonth, startYear, endMonth, "
                    + "endYear, amountapproved) VALUES (?,?,?,?,?,?)");
            psInsRMD.setInt(1, this.getId());
            psInsRMD.setInt(2, this.getsMonth());
            psInsRMD.setInt(3, this.getsYear());
            psInsRMD.setInt(4, this.geteMonth());
            psInsRMD.setInt(5, this.geteYear());
            psInsRMD.setDouble(6, this.getAmtAppr());
            psInsRMD.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public int getMonths(){
        int months = 0;
        months = ((this.geteMonth() - this.getsMonth()) + 1) + ((this.geteYear() - this.getsYear()) * 12);
        return months;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the sMonth
     */
    public int getsMonth() {
        return sMonth;
    }

    /**
     * @return the sYear
     */
    public int getsYear() {
        return sYear;
    }

    /**
     * @return the eMonth
     */
    public int geteMonth() {
        return eMonth;
    }

    /**
     * @return the eYear
     */
    public int geteYear() {
        return eYear;
    }

    /**
     * @return the amtAppr
     */
    public double getAmtAppr() {
        return amtAppr;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param sMonth the sMonth to set
     */
    public void setsMonth(int sMonth) {
        this.sMonth = sMonth;
    }

    /**
     * @param sYear the sYear to set
     */
    public void setsYear(int sYear) {
        this.sYear = sYear;
    }

    /**
     * @param eMonth the eMonth to set
     */
    public void seteMonth(int eMonth) {
        this.eMonth = eMonth;
    }

    /**
     * @param eYear the eYear to set
     */
    public void seteYear(int eYear) {
        this.eYear = eYear;
    }

    /**
     * @param amtAppr the amtAppr to set
     */
    public void setAmtAppr(double amtAppr) {
        this.amtAppr = amtAppr;
    }
}
