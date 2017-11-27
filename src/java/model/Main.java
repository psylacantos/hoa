package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main 
{

    public static void main(String[] args) 
    {
        Connection conn = Database.getDBConnection();
        String insertRequest = "INSERT INTO REGISTRATION_REQUEST VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try
        {
            PreparedStatement pStmt = conn.prepareStatement(insertRequest);
            
            
            int isInserted = pStmt.executeUpdate();
            if(isInserted!=0)
            {
                System.out.println("Registration request sent. Please wait for a HOA officer to review your request.");
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
    
}
