package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database 
{
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/hoa";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    
    public static Connection getDBConnection()
    {
        Connection conn = null;
        
        try
        {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            return conn;
        }
        
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        return conn;
    }
}
