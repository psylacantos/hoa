/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.*;

/**
 * allProperties Object
 * An <b>allProperties<b> object contains an Array List of refProperty(s)
 * @author Kayle Tiu
 */
public class allProperties implements Serializable {
    protected ArrayList <refProperty> arp = new ArrayList <refProperty> ();
    
    public allProperties(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","swengg", null);
            PreparedStatement psID = connection.prepareStatement("SELECT * FROM REF_PROPERTIES");
            ResultSet rsID = psID.executeQuery();
            while (rsID.next()){
                arp.add(new refProperty(rsID.getInt("blocknum"), rsID.getInt("lotnum")));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        for (int i = 0; i < this.arp.size(); i++){
            System.out.println("i: " + i + " lotnum: " + this.arp.get(i).getLotnum() + " blocknum: " + this.arp.get(i).getBlocknum());
        }
    }
    
    
    public void addProperty(refProperty rp ){
        this.arp.add(rp);
    }
    
    public refProperty getProperty(int index){
        return this.arp.get(index);
    }
    
    public int getArpSize(){
        return this.arp.size();
    }
    
}
