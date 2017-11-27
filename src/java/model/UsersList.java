/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Represents the list of users.
 * @author Psyla Cantos
 * @author SW-ENGG
 * @version 1.0
*/
public class UsersList implements Serializable{
    private static final String DRIVER_NAME= "com.mysql.jdbc.Driver";
    private static final String JDBC_URL= "jdbc:mysql://localhost:3306/hoa?useSSL=false";
    private static final String DB_USER= "root";
    private static final String DB_PASSWORD= "12345";
    
    private int usersNum;            
    private String[] usersList;     
    private String[] homeownersList;
    private String[] homeownerInfo;
    private String usernameDeactivate;

    /**
     * @return the usersNum
     */
    public int getUsersNum() {
        return usersNum;
    }

    /**
     * @param usersNum the usersNum to set
     */
    public void setUsersNum(int usersNum) {
        this.usersNum = usersNum;
    }

    /**
     * @return the usersList
     */
    public String[] getUsersList() {
        return usersList;
    }

    /**
     * @param usersList the usersList to set
     */
    public void setUsersList(String[] usersList) {
        this.usersList = usersList;
    }
    
    /**
     * @return the homeownersList
     */
    public String[] getHomeownersList() {
        return homeownersList;
    }

    /**
     * @param homeownersList the homeownersList to set
     */
    public void setHomeownersList(String[] homeownersList) {
        this.homeownersList = homeownersList;
    }

    /**
     * @return the usernameDeactivate
     */
    public String getUsernameDeactivate() {
        return usernameDeactivate;
    }

    /**
     * @param usernameDeactivate the usernameDeactivate to set
     */
    public void setUsernameDeactivate(String usernameDeactivate) {
        this.usernameDeactivate = usernameDeactivate;
    }
    
    public static Connection getDBConnection(){
       Connection conn = null;
       try{
           Class.forName(DRIVER_NAME);
           conn = DriverManager.getConnection(JDBC_URL,DB_USER, DB_PASSWORD);
           return conn;
       } catch (SQLException e){
           e.printStackTrace();
       } catch (ClassNotFoundException ex){
           ex.printStackTrace();
       }
       return conn;
   }
    
   /**
     * @param username asks for username and retrieves its password, type, and status
     */
   public String dbLogin(String username){
        Connection conn = UsersList.getDBConnection();
        String pw = "";
        try{
            String sql = "select passwd, usertypeID, status from users where userID='".concat(username);
            sql = sql.concat("';");
            System.out.println(sql);
            PreparedStatement pStmt = conn.prepareStatement(sql);
            String password="";
            String status="";
            String usertype="";
            
            ResultSet rs = pStmt.executeQuery();
            
            while(rs.next()){
                password = rs.getString(1);
                usertype=rs.getString(2);
                status = rs.getString(3);
            } 
            
            /*
            if user is inactive, the method will return inactive
            if user is not inactive, the method will return the usertypeID concatenated to the password
            this is to ensure that the controller will know the status, usertype, and password of the user for login
            */
            if (!status.equals("INACTIVE")){
                password = usertype + password;
                return password;
            }
            else{
                password = "inactive";
                return password;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if (conn != null){
                try{
                    conn.close();
                } catch (SQLException e){
                    
                }
            }
        }
        return pw;
   } 
    
   /**
     * @param username asks for the username whose status will be updated in the database
     */
   public boolean dbDeactivate(String username){
       Connection conn = UsersList.getDBConnection();
       boolean boo = false;
        try{
            String sql = "select status from users where userID='".concat(username).concat("';");
            PreparedStatement pStmt = conn.prepareStatement(sql);
            String status="";
            
            ResultSet rs = pStmt.executeQuery();
            
            while(rs.next()){
                status = rs.getString(1);
            } 
            
            /*
            if user is inactive, it will set the status to active
            if user is not  active, it will set the status to inactive
            */
            if (!status.equals("INACTIVE")){
                sql = "update users set status='INACTIVE' where userID='".concat(username).concat("';");
            }
            else{
                sql = "update users set status='ACTIVE' where userID='".concat(username).concat("';");
            }
            pStmt = conn.prepareStatement(sql);
            
            /*
            executeUpdate returns 0 if the statement was not executed. 
            thus, the method will only return true if result is not equal to 0
            */
            int result = pStmt.executeUpdate();
            if (result!=0){
                boo = true;
            }
            
        }catch(SQLException e){
            boo = false;
            e.printStackTrace();
        }
        return boo;
   }
    
   /**
     * retrieves the list of users from the database for system administration
     */
   public void dbViewUsers(){
       Connection conn = UsersList.getDBConnection();

        try{
            /*
            this aims to know the number of users that can log in to the system
            */
            String sql = "select count(userID) from users where usertypeID=1 OR usertypeID=2 OR usertypeID=3;";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            UsersList ul = new UsersList();
            
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()){
                setUsersNum(rs.getInt(1));
            } 
            
            /*
            retrieves all users from the db
            */
            sql = "select u.userID, concat(u.lName, ', ', u.fName), ut.usertype, u.status from users u join ref_usertype ut where u.usertypeID=ut.usertypeid AND (u.usertypeID=1 OR u.usertypeID=2 OR u.usertypeID=3) order by u.status, u.usertypeID;";
            pStmt = conn.prepareStatement(sql);
            
            rs = pStmt.executeQuery();
            
            String usersList[] = new String[getUsersNum()];
            
            /*
            retrieved data will be stored in an array
            */
            String user="";
            int i=0;
            while(rs.next()){
                user = rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4) ; 
                //names [i] = rs.getString(2);
                //usernames[i] = rs.getString(4);
                usersList[i] = user;
                i++;
            }
            
            setUsersList(usersList);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if (conn != null){
                try{
                    conn.close();
                } catch (SQLException e){
                    
                }
            }
        }
   } 
   
   /**
     * retrieves the list of homeowners from the database for other homeowners
     */
   public void dbViewHomeowners(){
       Connection conn = UsersList.getDBConnection();

        try{/*
            retrieves the number of users 
            */
            String sql = "select count(userID) from users where usertypeID=2 OR usertypeID=3;";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            UsersList ul = new UsersList();
            
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()){
                setUsersNum(rs.getInt(1));
            } 
            
            /*
            retrieves user information for homeowners' directory
            */
            sql = "select userID, concat(u.lName, ', ', u.fName, ' ', u.mname), u.telNum, u.mobileNum from users u join ref_occupation ro on u.occupationID=ro.occupationID where status!='INACTIVE';";
            pStmt = conn.prepareStatement(sql);
            
            rs = pStmt.executeQuery();
            
            String usersList[] = new String[getUsersNum()];
            
            String user="";
            int i=0;
            while(rs.next()){
                user = rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getBigDecimal(3) + "|" + rs.getBigDecimal(4) ; 
                //names [i] = rs.getString(2);
                //usernames[i] = rs.getString(4);
                usersList[i] = user;
                i++;
            }
            
            setHomeownersList(usersList);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if (conn != null){
                try{
                    conn.close();
                } catch (SQLException e){
                    
                }
            }
        }
   } 
   
   /**
     * @param user asks the userID in order to view information regarding the user
     */
   public void dbViewHOInfo(String user){
       Connection conn = UsersList.getDBConnection();

        try{
            String sql = "select concat(u.lName, ', ', u.fName, ' ', u.mname), u.bDate, ro.occupation, u.telNum, u.mobileNum, u.movingIn from users u join ref_occupation ro on u.occupationID=ro.occupationID where u.userID='".concat(user).concat("';");
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            ResultSet rs = pStmt.executeQuery();
            
            String usersList[] = new String[6];
            /*
            retrieved information about a specific user will be stored in an array where the length is set to 6 since 6 fields are queried from the db
            */
            int i=0;
            DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
            while(rs.next()){
                usersList[0] = rs.getString(1);
                usersList[1] = df.format(rs.getDate(2));
                usersList[2] = rs.getString(3);
                usersList[3] = (rs.getBigDecimal(4)).toString();
                usersList[4] = (rs.getBigDecimal(5)).toString();
                usersList[5] = df.format(rs.getDate(6));
            }
            
            setHomeownerInfo(usersList);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if (conn != null){
                try{
                    conn.close();
                } catch (SQLException e){
                    
                }
            }
        }
   } 
   
   public static void main(String[] args){
       UsersList us = new UsersList();
       
   }

    /**
     * @return the homeownerInfo
     */
    public String[] getHomeownerInfo() {
        return homeownerInfo;
    }

    /**
     * @param homeownerInfo the homeownerInfo to set
     */
    public void setHomeownerInfo(String[] homeownerInfo) {
        this.homeownerInfo = homeownerInfo;
    }
}
