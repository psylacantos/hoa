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
public class houseMonthlyDues implements Serializable{
    protected refProperty rp;
    protected int mdID;
    protected int trxID;
    
    public houseMonthlyDues(refProperty rp, int mdID, int trxID){
        this.rp = rp;
        this.mdID = mdID;
        this.trxID = trxID;
    }
    
    public void insValues(){
        try {
             Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","swengg", null);
            PreparedStatement psInsMD = connection.prepareStatement("INSERT INTO HouseMonthlyDues (blocknum, lotnum, mdID, trxID) VALUES (?,?,?,?)");
            psInsMD.setInt(1, this.rp.getBlocknum());
            psInsMD.setInt(2, this.rp.getLotnum());
            psInsMD.setInt(3, this.mdID);
            psInsMD.setDouble(4, this.trxID);
            psInsMD.executeUpdate();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
