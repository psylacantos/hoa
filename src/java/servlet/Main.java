/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        
        Connection conn = null;
        String driver = "com.mysql.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://localhost:3306/hoa";
        
        String userid = "2";
        int block = 0;
        int lot = 0;
        int trxID = 0;
        ArrayList <Object> duesTxnList;
        ArrayList <Integer> duesTxnIDList;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl, "root", "Je@n_22");
            
            //gets the block and lot of the user/homeowner
            String blockLotSql = "SELECT blocknum, lotnum from users join homeowner on users.userID = homeowner.userid where homeowner.userid = '"+ userid +"';";
            PreparedStatement pStmt = conn.prepareStatement(blockLotSql);
            ResultSet rs = pStmt.executeQuery();
            
            while(rs.next()){
                block = rs.getInt(1);
                lot = rs.getInt(2);
                System.out.println(block);
                System.out.println(lot);
            }
            
            //gets all dues transaction of the user
            String duesTrxID = "SELECT trxID FROM housemonthlydues WHERE  blocknum = "+ block +" AND lotnum = "+ lot +" ;";
            System.out.println(duesTrxID);
            pStmt = conn.prepareStatement(duesTrxID);
            rs = pStmt.executeQuery();
            
            duesTxnIDList = new ArrayList();
            while(rs.next()){
                duesTxnIDList.add(rs.getInt("trxID"));
            }
            
            int j = 1;
            for(int i = 0; i < duesTxnIDList.size(); i++){
                String duesTrx = "SELECT txnDate, totalamount, amountpaid, status  FROM trxreferences join trxlist on trxreferences.trxid = trxlist.trxid WHERE trxreferences.trxID = "+ duesTxnIDList.get(i) +";";
                System.out.println("SELECT txnDate, totalamount, amountpaid, status  FROM trxreferences join trxlist on trxreferences.trxid = trxlist.trxid WHERE trxreferences.trxID = "+ duesTxnIDList.get(i) +";");
                pStmt = conn.prepareStatement(duesTrx);
                rs = pStmt.executeQuery();
                
                duesTxnList = new ArrayList();
                while(rs.next()){
                    duesTxnList.add(rs.getDate("txnDate"));
                    duesTxnList.add(rs.getFloat("totalamount"));
                    duesTxnList.add(rs.getInt("amountpaid"));
                    duesTxnList.add(rs.getString("status"));
                    System.out.println(duesTxnList.get(1));
                }
            }
            
            //gets the due transaction details
           /*
             String duesTrx = "SELECT * FROM trxreferences WHERE trxID = "+ trxID +";";
            pStmt = conn.prepareStatement(duesTrx);
            rs = pStmt.executeQuery();
            
            duesTxnList = new ArrayList();
            while(rs.next()){
                duesTxnList.add(rs.getInt("trxID"));
                duesTxnList.add(rs.getFloat("totalamount"));
                duesTxnList.add(rs.getDate("txnDate"));
            }
            
            //gets the overdue fees of user
            */
            
            
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    
                }
            }
        }
    }
}
