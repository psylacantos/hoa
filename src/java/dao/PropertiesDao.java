
package dao;



import java.util.*;
import java.sql.*;
import model.*;

public class PropertiesDao {
    /**
     * This method gets all the values of the Ref_Properties table
     * @return ArrayList of Ref_Properties
     */
    
    public static ArrayList<Ref_Properties>getRef_Properties()
    {
        ArrayList<Ref_Properties>properties=new ArrayList();
        Connection connect=dbconnect.getDBConnection();
        String sql="SELECT * FROM REF_PROPERTIES";
          try
            {
            
            PreparedStatement pStmt=connect.prepareCall(sql);
            ResultSet rs=pStmt.executeQuery();
             while (rs.next()){
                 properties.add(new Ref_Properties(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getInt(6)));
                 
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
        return properties;
    }
    
}
