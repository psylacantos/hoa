/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author rock69qm
 */
public class UserDAO {
    
    public void acceptRequest(String userID){
        
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        Registration_Request rr;
        String sql = "SELECT r.requestID, r.userID_req, r.passwd, r.lname_req, r.fname_req, r.mname_req, r.bDate_req, r.photoID, r.occupationID, r.telNum, r.mobileNum, r.blocknum_req, r.lotnum_req, r.movingIn, r.approved FROM registration_request r "
                + "WHERE r.userID_req = ? ";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            
            if(rs.next()){
                rr = new Registration_Request(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getDate(7),rs.getInt(8), rs.getInt(9),
                rs.getLong(10), rs.getLong(11), rs.getInt(12), rs.getInt(13), rs.getDate(14));
                System.out.println("CHECK OCCUP ID = "+rs.getString(9)+" "+rr.getOccupationID());
                InsertUser(rr);
                rejectRequest(userID);
                
            }
        }catch(Exception e){
            
        }
    }
    
   
    
    public void rejectRequest(String userID){
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        Registration_Request rr;
        String sql = "DELETE FROM registration_request \n" +
        "WHERE userID_req = ?;";
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
                
    }
    
    public boolean occupationExists(String occupation){
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT occupation FROM ref_occupation WHERE occupation = ?; ";
        
        try{
            ps = conn.prepareStatement(query);
            ps.setString(1, occupation.toLowerCase());
            rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }else{
                String query_insert = "INSERT INTO ref_occupation (occupation) VALUES (?); ";
                ps = conn.prepareStatement(query_insert);
                ps.setString(1, occupation);
                ps.executeUpdate();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public int getOccupationId(String occupation){
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT occupationID FROM ref_occupation WHERE occupation = ?; ";
        
        try{
            ps = conn.prepareStatement(query);
            ps.setString(1, occupation);
            rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt("occupationID");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return -1;
    }
    
    public void insertHouseCoor(String userid, int blockNum, int lotNum){
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "INSERT INTO homeowner ( userid, blocknum, lotnum)" 
                +  "VALUES ( ?, ?, ?);";
        
        try{
            ps = conn.prepareStatement(query);
            ps.setString(1, userid);
            ps.setInt(2, blockNum);
            ps.setInt(3, lotNum);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void InsertUser(Registration_Request r)
    {
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "INSERT INTO users ( userID, passwd, lname, fname, mname, bDate, photoID, occupationID, telNum, mobileNum, movingIn)" 
                +  "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try
        {
            
            ps = conn.prepareStatement(query);
            ps.setString(1, r.getUserID());
            ps.setString(2, r.getPasswd());
            
            ps.setString(3, r.getLname());
            ps.setString(4, r.getFname());
            ps.setString(5, r.getMname());
            ps.setDate(6, r.getbDate());
            ps.setInt(7, 1);
            System.out.println("OCCUP ID = "+r.getOccupationID());
            ps.setInt(8, r.getOccupationID());
            ps.setLong(9, r.getTelNum());
            ps.setLong(10, r.getMobileNum());
            ps.setDate(11, r.getMovingIn());
            int isInserted = ps.executeUpdate();
            
            //insertHouseCoor(r.getUserID(), r.getBlocknum(),r.getLotnum());
            
            //ps.setInt(12, r.getBlocknum());
            //ps.setInt(13, r.getLotnum());
            
            
            
           
            if(isInserted!=0)
            {
                insertHouseCoor(r.getUserID(), r.getBlocknum(),r.getLotnum());
                //System.out.println("Registration request has been sent. Kindly wait for an officer to review your request.");
            }
            else
            {
                System.out.println("did not insert");
            }
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        finally
        {
            if(conn!=null)
            {
                try
                {
                    conn.close();
                }
                catch(Exception e)
                {
                    
                }
            }
        }
    }
    
    public void InsertRequest(Registration_Request r)
    {
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "INSERT INTO registration_request ( userID_req, passwd, lname_req, fname_req, mname_req, bDate_req, photoID, occupationID, telNum, mobileNum, blocknum_req, lotnum_req, movingIn, approved)" 
                +  "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try
        {
            occupationExists(r.getOccupation());
                
            int occupation_id =  getOccupationId(r.getOccupation());
            
            ps = conn.prepareStatement(query);
            ps.setString(1, r.getUserID());
            ps.setString(2, r.getPasswd());
            ps.setString(3, r.getLname());
            ps.setString(4, r.getFname());
            ps.setString(5, r.getMname());
            ps.setDate(6, r.getbDate());
            ps.setInt(7, 1);
            ps.setInt(8, occupation_id);
            ps.setLong(9, r.getTelNum());
            ps.setLong(10, r.getMobileNum());
            ps.setInt(11, r.getBlocknum());
            ps.setInt(12, r.getLotnum());
            ps.setDate(13, r.getMovingIn());
            ps.setBoolean(14, false);
            
            
            int isInserted = ps.executeUpdate();
            if(isInserted!=0)
            {
                System.out.println("Registration request has been sent. Kindly wait for an officer to review your request.");
            }
            else
            {
                System.out.println("did not insert");
            }
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        finally
        {
            if(conn!=null)
            {
                try
                {
                    conn.close();
                }
                catch(Exception e)
                {
                    
                }
            }
        }
    }
    
    public boolean usernameExists(String username)
    {
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "select 1 \n" +
            "from (\n" +
            "    select userID_req as username from registration_request\n" +
            "    union all\n" +
            "    select userID as username from users\n" +
            ") a\n" +
            "where username = ?";
        
        try{
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){
                
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        return false;
    }
    
    public ArrayList<Registration_Request> getAllRequests() throws SQLException
    {
        Connection conn = Database.getDBConnection();
        ArrayList <Registration_Request> requests = new ArrayList<Registration_Request>();
        String sql = "SELECT r.requestID, r.userID_req, r.passwd, r.lname_req, r.fname_req, r.mname_req, r.bDate_req, r.photoID, o.occupation, r.telNum, r.mobileNum, r.blocknum_req, r.lotnum_req, r.movingIn, r.approved FROM registration_request r "
                + "INNER JOIN ref_occupation o ON o.occupationID = r.occupationID ORDER BY 1;";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next())
        {
            requests.add(new Registration_Request(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getDate(7),rs.getInt(8), rs.getString(9),
            rs.getLong(10), rs.getLong(11), rs.getInt(12), rs.getInt(13), rs.getDate(14)));
        }
        
        return requests;
        
    }
    
    public void InsertHomemember (homemember h)
    {
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "INSERT INTO homemember (userid, fname_homemember, lname_homemember, renting, blocknum, lotnum, status)" 
                +  "VALUES ( ?, ?, ?, ?, ?, ?, ?);";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setString(1, h.getUserid());
            ps.setString(2, h.getFname_homemember());
            ps.setString(3, h.getLname_homemember());
            ps.setBoolean(4, h.isRenting());
            ps.setInt(5, h.getBlocknum());
            ps.setInt(6, h.getLotnum());
            ps.setString(7, h.getStatus());
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        finally
        {
            if(conn!=null)
            {
                try
                {
                    conn.close();
                }
                catch(Exception e)
                {
                    
                }
            }
        }
    }
    
    public void InsertKasambahay (kasambahay k)
    {
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "INSERT INTO homemember (userid, fname_homemember, lname_homemember, starDate, endDate, blocknum, lotnum, status)" 
                +  "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setString(1, k.getUserid());
            ps.setString(2, k.getFname_kasambahay());
            ps.setString(3, k.getLname_kasambahay());
            ps.setDate(4, k.getStartDate());
            ps.setDate(5, k.getEndDate());
            ps.setInt(6, k.getBlocknum());
            ps.setInt(7, k.getLotnum());
            ps.setString(8, k.getStatus_kasambahay());
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        finally
        {
            if(conn!=null)
            {
                try
                {
                    conn.close();
                }
                catch(Exception e)
                {
                    
                }
            }
        }
    }
    
    public void InsertPet (Pet p)
    {
        Connection conn = Database.getDBConnection();
        PreparedStatement ps;
        ResultSet rs;
        String query = "INSERT INTO user_pets (userid, animaltypeid, petname, vaccinated, photoid, status_pet)" 
                +  "VALUES ( ?, ?, ?, ?, ?, ?);";
        
        try
        {
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getUserid());
            ps.setInt(2, p.getAnimaltypeid());
            ps.setString(3, p.getPetname());
            ps.setBoolean(4, p.isVaccinated());
            ps.setInt(5, p.getPhotoid());
            ps.setString(6, p.getStatus_pet());
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        finally
        {
            if(conn!=null)
            {
                try
                {
                    conn.close();
                }
                catch(Exception e)
                {
                    
                }
            }
        }
    }
}
