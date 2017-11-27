/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author eabiii
 */
import java.io.Serializable;

public class Student implements Serializable{
    
    private int studentID;
    private String name;
    private int age;
    
    public Student(){}
    
    public Student(int studentID, String name, int age){
        this.studentID=studentID;
        this.name=name;
        this.age=age;
    
    }
    public void setID(int studentID){
        this.studentID=studentID;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int name){
        this.age=age;
    }
    public int getID(){
        return studentID;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    
    
}
