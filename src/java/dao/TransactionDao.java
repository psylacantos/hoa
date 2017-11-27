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
public class TransactionDao {
    
    /**
     * This method updates the transaction reference table
     * @param tx Transaction reference
     * @return true (Success)
     */
   public static boolean updateTransactionReference( TrxReferences tx )
    {
        boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="UPDATE INTO TRXREFERENCES (TRXID,AMOUNT,INTEREST,TOTALAMOUNT,TRXDATE)VALUES(?,?,?,?,?)";
            
            try{
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1, tx.getTrxID());
            p.setDouble(2, tx.getAmount());
             p.setDouble(3, tx.getInterest());
             p.setDouble(4, tx.getTotalAmount()); 
              java.sql.Date sqlDate = new java.sql.Date(tx.getDate().getTime());
             p.setDate(5,  sqlDate); 
             
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
     * This method will add a transaction reference
     * @param tx
     * @return boo wherein it must be true 
     */
    public static boolean addTransactionReference( TrxReferences tx )
    {
        boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="INSERT INTO TRXREFERENCES (TRXID,AMOUNT,INTEREST,TOTALAMOUNT,TXNDATE)VALUES(?,?,?,?,?)";
            
            try{
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1, tx.getTrxID());
            p.setDouble(2, tx.getAmount());
             p.setDouble(3, tx.getInterest());
             p.setDouble(4, tx.getTotalAmount()); 
              java.sql.Date sqlDate = new java.sql.Date(tx.getDate().getTime());
             p.setDate(5,  sqlDate); 
             
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
    
    public static boolean addHouseMonthlyBill(HouseMonthlyDues h)
    {
        boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="INSERT INTO HouseMonthlyDues (Blocknum,lotnum,mdid,trxid)VALUES(?,?,?,?)";
            
            try{
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1, h.getBlockNum());
            p.setDouble(2, h.getLotNum());
             p.setDouble(3, h.getMdID());
             p.setDouble(4, h.getTrxID()); 
              //java.sql.Date sqlDate = new java.sql.Date(tx.getDate().getTime());
            // p.setDate(5,  sqlDate); 
             
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
     * This method adds to the TrxList table
     * @param tl
     * @return true(Success)
     */
    public static boolean addTrxList(TrxList tl)
    {
        boolean boo=false;
        //int id=TransactionDao.getMaxTJID()+1;
            Connection c=dbconnect.getDBConnection();
            String sql ="INSERT INTO TRXLIST (JOURNALID,TRXID,AMOUNTPAID,STATUS)VALUES(?,?,?,?)";
            
            try{
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1,tl.getJournalID());
              //  java.sql.Date sqlDate = new java.sql.Date(tj.getDate().getTime());

            p.setInt(2, tl.getTrxID());
             p.setDouble(3, tl.getAmount());
             p.setString(4,  tl.getStatus()); 
             
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
     * This method will add a transaction journal
     * @param tj Transaction Journal
     * @return 
     */
    public static boolean addTrxJournal(Transaction_Journal tj)
    {
        boolean boo=false;
        int id=TransactionDao.getMaxTJID()+1;
            Connection c=dbconnect.getDBConnection();
            String sql ="INSERT INTO TRANSACTION_JOURNAL (JOURNALID,TRXDATE,TRXAMNT,TRXAMNTPAID,STATUS)VALUES(?,?,?,?,?)";
            
            try{
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1,id);
                java.sql.Date sqlDate = new java.sql.Date(tj.getDate().getTime());

            p.setDate(2, sqlDate);
             p.setDouble(3, tj.getTrxAmt());
             p.setDouble(4, tj.getTrxAmtPaid()); 
             p.setString(5,  tj.getStatus()); 
             
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
     * This method will update a transaction reference if a bill has been updated
     * @param bbid
     * @param tamount
     * @param interest
     * @return 
     */
    
    public static boolean updateTransactionReference(int bbid,double tamount, double interest)
    {
        boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="UPDATE TRXREFERENCES SET INTEREST=?, TOTALAMOUNT=? WHERE trxid=? ";
            
            try{
            PreparedStatement p=c.prepareCall(sql);
            p.setDouble(1, interest);
            p.setDouble(2, tamount);
             p.setInt(3, bbid);
         //     java.sql.Date sqlDate = new java.sql.Date(tx.getDate().getTime());
          //   p.setDate(5,  sqlDate); 
             
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
     * This method updates the Transaction Journal
     * @param jid
     * @param tamount
     * @param status
     * @return 
     */
    public boolean updateTrxJournal(int jid,double tamount,String status)
    {
        
                boolean boo=false;
            Connection c=dbconnect.getDBConnection();
            String sql ="UPDATE TRANSACTION_JOURNAL SET INTEREST=?, TOTALAMOUNT=? WHERE JOURNALID=? ";
            
            try{
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1, jid);
            p.setDouble(2, tamount);
             p.setString(3, status);
         //     java.sql.Date sqlDate = new java.sql.Date(tx.getDate().getTime());
          //   p.setDate(5,  sqlDate); 
             
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
    
    
      public static int getMaxTJID()
    {
         int bID=-1;
        String sql="SELECT max(journalID)  FROM Transaction_Journal";
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
     * This method returns the maximum id in the trxReference table
     * @return Max Id of TrxReferences
     */
     public static int getMaxTrxID()
    {
         int bID=-1;
        String sql="SELECT max(trxID)  FROM trxReferences";
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
     * This method returns the journalID
     * @param bill
     * @return journalID
     */
     
    public static int getJournalID(int bill)
    {
         int bID=-1;
            System.out.println("billid");
            String sql="SELECT JOURNALID FROM PAYMENTDETAILS WHERE BILLING_BILLINGID=? ";
            Connection c=dbconnect.getDBConnection();
            
            try
            {
                PreparedStatement p=c.prepareCall(sql);
                p.setInt(1, bill);
                p.setInt(2, bID);
                ResultSet rs=p.executeQuery();
                
                while(rs.next())
                {
                    bID=rs.getInt(1);
                   // bill=new Billing();
                   // bill.setID(rs.getInt(1));
                   // bill.setBlockNum(rs.getInt(2));
                   // bill.setLotNum(rs.getInt(3));
                    //bill.setTotalDue(rs.getInt(4));
                                       //  System.out.println("billiswqd");
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
     * This method returns TrxID
     * @param jid
     * @param bif
     * @return TrxId
     */
    
    public static int getTrxID(int jid, int bif)
    {
        int bID=-1;
        System.out.println("joun is"+jid);
            System.out.println("billid is"+bif);
            String sql="select trxreferences.trxid from trxReferences join BILLINGDETAILS on trxReferences.trxID=BILLINGDETAILS.trxID where trxReferences.trxID=? and BILLINGDETAILS.billingID=?";
            Connection c=dbconnect.getDBConnection();
            
            try
            {
                PreparedStatement p=c.prepareCall(sql);
                p.setInt(1, jid);
                p.setInt(2, bif);
                ResultSet rs=p.executeQuery();
                
                while(rs.next())
                {
                    bID=rs.getInt(1);
                    System.out.println("value of bid "+bID);
                   // bill=new Billing();
                   // bill.setID(rs.getInt(1));
                   // bill.setBlockNum(rs.getInt(2));
                   // bill.setLotNum(rs.getInt(3));
                    //bill.setTotalDue(rs.getInt(4));
                                       //  System.out.println("billiswqd");
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
    
    public static int getJTransactionID(int id)
    {
        int bID=-1;
            System.out.println("billid");
            //Billing bill=null;
            String sql="SELECT JOURNALLID FROM TRANSACTION_JOURNAL WHERE JOURNALLID = ?";
            Connection c=dbconnect.getDBConnection();
            
            try
            {
                PreparedStatement p=c.prepareCall(sql);
                p.setInt(1, id);
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
     * This method returns an arraylist containing all values from the Transaction_Journal Table
     * @return
     * @throws SQLException 
     */
    
    public static ArrayList<Transaction_Journal>getJournal()throws SQLException
    {
        ArrayList<Transaction_Journal>j=new ArrayList();
            Connection connect=dbconnect.getDBConnection();
            String sql="SELECT * FROM Transaction_Journal";
            try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 j.add(new Transaction_Journal(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
                 
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
        return j;
    }
    
    /**
     * This method returns an arraylist containing all values from the TrxReferences Table
     * @return
     * @throws SQLException 
     */
    
       public static ArrayList<TrxReferences>getTransactionReferences()throws SQLException
    {
        ArrayList<TrxReferences>tr=new ArrayList();
            Connection connect=dbconnect.getDBConnection();
            String sql="SELECT * FROM TrxReferences";
            try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 tr.add(new TrxReferences(rs.getInt(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDate(5)));
                 
             }
            // System.out.println("good1");
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
        return tr;
    }
         public static ArrayList<TrxReferences>getTransactionReferencesById(int id)throws SQLException
    {
        ArrayList<TrxReferences>tr=new ArrayList();
            Connection connect=dbconnect.getDBConnection();
            String sql="SELECT * FROM TrxReferences where trxid=?";
            try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            pStmt.setInt(1, id);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 tr.add(new TrxReferences(rs.getInt(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDate(5)));
                 
             }
            // System.out.println("good1");
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
        return tr;
    }
       
       /**
     * This method returns an arraylist containing all values from the PaymentDetails Table
     * @return
     * @throws SQLException 
     */
    
    public static ArrayList<PaymentDetails>getPaymentDetails()throws SQLException
    {
        ArrayList<PaymentDetails>p=new ArrayList();
            Connection connect=dbconnect.getDBConnection();
            String sql="SELECT * FROM PaymentDetails";
            try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 p.add(new PaymentDetails(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4)));
                 
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
        return p;
    }
    
    
    
    
}
