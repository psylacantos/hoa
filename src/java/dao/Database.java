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
import java.sql.*;
import model.Student;
import dao.StudentDAO;
import java.util.ArrayList;
public class Database {
    
    private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/JavaSample";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD="fmlygy12";
    
    public static Connection getDBConnection(){
        Connection connect=null;
        try{
            Class.forName(DRIVER_NAME);
            connect=DriverManager.getConnection(JDBC_URL,DB_USER, DB_PASSWORD);
            return connect;
        
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    return connect;
        
    }
    
 //   public static void main(String[] args){
   // Student third= new Student(11550902,"Kekmalung Heavy",44);
 //  Connection connect=Database.getDBConnection();
  // String sql="INSERT INTO STUDENT VALUES(?,?,?);";
 //   ArrayList<Student>students=new ArrayList<>();
 //   try{
 //       students=StudentDAO.getAllStudents(connect);
       // PreparedStatement pStmt =connect.prepareCall(sql);
        
        //ResultSet rs =pStmt.executeQuery();
       // while(rs.next()){
         //   System.out.println("Student ID: "+ rs.getInt(1));
           // System.out.println("\tName: "+ rs.getString(2));
            //System.out.println("\tAge: "+ rs.getInt(3));
          //  pStmt.setInt(1, third.getID());
          //  pStmt.setString(2, third.getName());
          //  pStmt.setInt(3, third.getAge());
            
          //  int isInserted = pStmt.executeUpdate();
         //   if(isInserted !=0){
         //       System.out.println("New meat");
           // }
            
        //}
//    }catch(Exception e){
//        e.printStackTrace();
//        }
    
 //   catch(SQLException e){
    
       // System.out.println(e.getMessage());
        //e.printStackTrace();
  //  }
//  finally{
   //     if(connect !=null){
   //         try{
  //              connect.close();
  //          }catch(SQLException e){
            
  //          }
  //      }
 //   }
 //   for(Student s: students){
 //       System.out.println("Student ID: "+ s.getID());
 //           System.out.println("\tName: "+ s.getName());
//            System.out.println("\tAge: "+ s.getAge());
//    }
        
    
 //   }
    
    
}
    

