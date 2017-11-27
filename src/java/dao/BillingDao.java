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
public class BillingDao {
     /**
     * @return
     * @throws SQLException 
     */
    /**
     * This method returns an arraylist containing all values from the Billing Table where the condition being the status
     * @param status
     * @return
     * @throws SQLException 
     */    
        public static ArrayList<Billing>getBillingByStatus(String status)throws SQLException
        {
            ArrayList<Billing>billing=new ArrayList();
            Connection connect=dbconnect.getDBConnection();
            String sql="SELECT * FROM BILLING WHERE STATUS=?";
            try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            pStmt.setString(1, status);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 billing.add(new Billing(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getString(8)));
                 
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
        return billing;
        
        
        }
        /**
         * This method gets all the Billing details from the Billing details method
         * @return 
         */
        
        public static ArrayList<BillingDetails>getDetails()
        {
            ArrayList<BillingDetails>bd=new ArrayList();
            Connection connect=dbconnect.getDBConnection();
            String sql="SELECT * FROM BILLINGDETAILS";
            try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 bd.add(new BillingDetails(rs.getInt(1),rs.getInt(2),rs.getString(3)));
                 
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
        return bd;
        }
        
        /**
         * This method gets all the values from the Billing Table
         * @return ArrayList Billing
         * @throws SQLException 
         */
       
        
        
        public static ArrayList<Billing>getBilling()throws SQLException{
            ArrayList<Billing>billing=new ArrayList();
            Connection connect=dbconnect.getDBConnection();
            String sql="SELECT * FROM BILLING";
            try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 billing.add(new Billing(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getString(8)));
                 
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
        return billing;
        }
        
       
        
        
        /**
         * This method returns the Billing ID
         * @param bid
         * @return Billing ID
         */
        
        public static int getBillingID(int bid)
        {
            int bID=-1;
            System.out.println("billid");
            //Billing bill=null;
            String sql="SELECT BILLINGID FROM BILLING WHERE BILLINGID = ?";
            Connection c=dbconnect.getDBConnection();
            
            try
            {
                PreparedStatement p=c.prepareCall(sql);
                p.setInt(1, bid);
                ResultSet rs=p.executeQuery();
                
                while(rs.next())
                {
                    bID=rs.getInt(1);

                }
                
           }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
                                 System.out.println("The id "+bID);
            return bID;
        }
        /**
         * Add a new bill to the database (Called when bill is to be added for the first time)
         * @param b
         * @return boo wherein it must be true
         */
        public static boolean addNewBill(Billing b)
        {
            boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="INSERT INTO BILLING (BILLINGID,BLOCKNUM,LOTNUM,TOTALDUE,TOTALPAID,DESCRIPTION,STATUS)VALUES(?,?,?,?,?,?,?)";
            
            try{
                int id=BillingDao.getMaxID()+1;
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1, id);
            p.setInt(2, b.getBlockNum());
             p.setInt(3, b.getLotNum());
             p.setDouble(4, b.getTotalDue()); 
             p.setDouble(5,  b.getTotalPaid()); 
             p.setString(6, b.getDesc());
             p.setString(7, b.getStatus());
             int added=p.executeUpdate();
             if(added!=0)
             {
                 boo=true;
             }
            }catch(SQLException e){
                boo=false;
                e.printStackTrace();
            }finally
            {
                 if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
            
            
            
            return boo;
        }
        
        
        
        /**
         * Add a new bill to the database (Called when there is an existing bill of the same block and lot number)
         * @param b
         * @return 
         */
        public static boolean addNewBillPB(Billing b)
        {
            boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="INSERT INTO BILLING (BILLINGID,BLOCKNUM,LOTNUM,PRECEDENTBILLING,TOTALDUE,TOTALPAID,DESCRIPTION,STATUS)VALUES(?,?,?,?,?,?,?,?)";
            
            try{
                int id=BillingDao.getMaxID()+1;
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1, id);
            p.setInt(2, b.getBlockNum());
             p.setInt(3, b.getLotNum());
             p.setInt(4, b.getPrecedentBilling()+1);
             p.setDouble(5, b.getTotalDue()); 
             p.setDouble(6,  b.getTotalPaid()); 
             p.setString(7, b.getDesc());
             p.setString(8, b.getStatus());
             System.out.println("PRECEDENT " +b.getPrecedentBilling());
             int added=p.executeUpdate();
             if(added!=0)
             {
                 boo=true;
             }
            }catch(SQLException e){
                boo=false;
                e.printStackTrace();
            }finally
            {
                 if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
            
            
            
            return boo;
        }
        
        /**
         * This method adds a new Billing Detail
         * @param b
         * @param t
         * @param status
         * @return boo wherein it must be true
         */
        
        public static boolean addBillingDetails(int b, int t,String status)
        {
            boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="INSERT INTO BILLINGDETAILS (BILLINGID,TRXID,STATUS)VALUES(?,?,?)";
            try{
           
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1, b);
            p.setInt(2, t);
             p.setString(3, status);
             int added=p.executeUpdate();
             if(added!=0)
             {
                 boo=true;
             }
            }catch(Exception e){
                boo=false;
                e.printStackTrace();
            }
            
            
            
            return boo;
        }
        /**
         * This method adds a payment detail to the paymentdetail table
         * @param b billing id
         * @param j journal id
         * @param t transaction id
         * @param status Status of payment
         * @return true(Success in adding)
         */
        public static boolean addPaymentDetails(int b, int j,int t,String status)
        {
        
            boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="INSERT INTO PAYMENTDETAILS (BILLING_BILLINGID,JOURNALID,TRXID,STATUS)VALUES(?,?,?,?)";
            try{
           
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1, b);
            p.setInt(2, j);
             p.setInt(3, t);
             p.setString(4, status);
             int added=p.executeUpdate();
             if(added!=0)
             {
                 boo=true;
             }
            }catch(Exception e){
                boo=false;
                e.printStackTrace();
            }
            
            
            
            return boo;
        }
        
        /**
         * This method updates the Billing table given the parameters as conditions
         * @param id
         * @param total
         * @param interest
         * @param status
         * @return boo wherein it must be true
         */
        public static boolean updateBill(int id, double total,double interest,String status)
        {
            boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="UPDATE BILLING SET TOTALPAID=?, STATUS=? WHERE BILLINGID=? ";
            try{
            PreparedStatement p=c.prepareCall(sql);
            p.setDouble(1, total);
            p.setString(2, status);
             p.setInt(3,  id); 
             
             int added=p.executeUpdate();
             if(added!=0)
             {
                 boo=true;
             }
            }catch(Exception e){
                boo=false;
                e.printStackTrace();
            }
            return boo;
            
        }
        /**
         * This method updates the status of the billing details
         * @param status
         * @return 
         */
        public static boolean updateDetails(String status,int bid,int tid)
        {
            boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="UPDATE BILLINGDETAILS SET STATUS=? WHERE BILLINGID=? AND TRXID=? ";
            try{
            PreparedStatement p=c.prepareCall(sql);
            p.setString(1, status);
            p.setInt(2, bid);
             p.setInt(3,  tid); 
             
             int added=p.executeUpdate();
             if(added!=0)
             {
                 boo=true;
             }
            }catch(Exception e){
                boo=false;
                e.printStackTrace();
            }
            return boo;
        }
        
        /**
         * This method returns the maximum id of the billing table
         * @return MaxID from the Billing Table
         */
        public static int getMaxID()
    {
         int bID=-1;
        String sql="SELECT max(billingID)  FROM Billing";
        Connection c=dbconnect.getDBConnection();
          try
            {
                PreparedStatement p=c.prepareCall(sql);
                ResultSet rs=p.executeQuery();
                
                while(rs.next())
                {
                    bID=rs.getInt(1);
                }
                
           }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
                                 System.out.println("The id "+bID);
            return bID;
    }
        
        /**
         * This method gets the maximum billing id to be used as the precedent bill
         * @param block block number
         * @param lot lot number
         * @return Maximum billing id -1
         */
        public static int getPrecedentBill(int block, int lot)
        {
            int b=-1;
            String sql="select max(billingID) from billing where blocknum=? and lotnum=?";
            Connection c=dbconnect.getDBConnection();
          try
            {
                PreparedStatement p=c.prepareCall(sql);
                p.setInt(1, block);
                p.setInt(2, lot);
                ResultSet rs=p.executeQuery();
                
                while(rs.next())
                {
                    b=rs.getInt(1);
                }
                
           }catch(Exception e){
            
                e.printStackTrace();
            }finally
            {
                if(c!=null)
                { 
                    try
                    {
                        c.close();
                    }catch(Exception e){}
                }
            }
                                 System.out.println("The id "+b);
            return b-1;
        }
        

    
    
}
