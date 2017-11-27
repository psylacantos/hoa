/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author eabiii
 */
import java.util.*;
import java.sql.*;
import model.*;
public class DuesDao {
    
    public static ArrayList<MonthlyDues>md()throws SQLException
    {
        ArrayList<MonthlyDues>md=new ArrayList();
        Connection connect=dbconnect.getDBConnection();
            String sql="SELECT * FROM MonthlyDues";
            try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 md.add(new MonthlyDues(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5)));
                 
             }
             System.out.println("good1");
            }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(connect!=null)
                { 
                    try
                    {
                        connect.close();
                    }catch(Exception e){}
                }
            }
        return md;
    }
    /*
    select REF_PROPERTIES.blocknum,REF_PROPERTIES.lotnum,MONTHLYDUES.amount
from REF_PROPERTIES
join HouseMonthlyDues
on REF_PROPERTIES.blocknum=HouseMonthlyDues.blocknum and REF_PROPERTIES.lotnum=HouseMonthlyDues.lotnum
join MONTHLYDUES
on HouseMonthlyDues.mdID=MONTHLYDUES.mdID
*/
    public static ArrayList<HouseMonthlyDues>hmd()throws SQLException
    {
        ArrayList<HouseMonthlyDues>hmd=new ArrayList();
        Connection connect=dbconnect.getDBConnection();
            String sql="SELECT * FROM HouseMonthlyDues";
            try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 hmd.add(new HouseMonthlyDues(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
                 
             }
             System.out.println("good1");
            }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(connect!=null)
                { 
                    try
                    {
                        connect.close();
                    }catch(Exception e){}
                }
            }
        return hmd;
    }
    
}
