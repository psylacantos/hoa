/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Student;
import java.util.*;
import java.sql.*;
/**
 *
 * @author eabiii
 */
public class StudentDAO {
    
    public static ArrayList<Student>getAllStudents(Connection connect)throws SQLException{
    
        ArrayList<Student> students=new ArrayList<>();
        String sql="SELECT STUDENTID, NAME,AGE FROM STUDENT ORDER BY 1;";
        PreparedStatement pStmt=connect.prepareCall(sql);
        ResultSet rs=pStmt.executeQuery();
        while (rs.next()){
            students.add(new Student(rs.getInt(1),rs.getString(2),rs.getInt(3)));
        }
        return students;
        
    }
    
    public static Student getStudentById(Connection connect,int studentId)throws SQLException{
        return new Student();
    }
    
    public static boolean addNewStudent(Student s){
        boolean b=false;
        Connection c=Database.getDBConnection();
        String sql="INSERT INTO STUDENT VALUES(?,?,?);";
        try{
            PreparedStatement p=c.prepareCall(sql);
            p.setInt(1, s.getID());
            p.setString(2, s.getName());
            p.setInt(3, s.getAge());
            int added=p.executeUpdate();
            if(added !=0){
                b=true;
            }
            
        }catch(Exception e){
            e.printStackTrace();
            b=false;
        }finally{
            if(c!=null){
                try{
                    c.close();
                }catch(Exception e){}
            }
        }
        return b;
        
    }
    
    
}
