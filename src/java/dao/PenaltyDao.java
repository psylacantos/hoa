package dao;
 

import java.sql.DriverManager;
import java.util.ArrayList;

import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
import model.Penalties;
import java.sql.Connection;


 public class PenaltyDao {
	 //Adding penalties
	 
	 
	 
	 public String addPenalty(Penalties penalty){

	
	int level= penalty.getLevel();
	
	
	String desc = penalty.getDesc();
        if(desc!=null)
            desc = "'"+desc+"'";
	double fee = penalty.fee;
	String action = penalty.action;
        if(action!=null)
            action = "'"+action+"'";
	int supportingDocument = penalty.getDocument();
	
	Connection con = null;
	Statement statement = null;
	
	 
	
	 
	try{
	 
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234"); //establishing connection
		 statement = con.createStatement(); 
		 statement.executeUpdate("INSERT INTO PENALTIES(penaltyLevel,penaltydescription,penaltyfee,penaltyaction,enablingDocumentID)"
		 		+ "value("+level+","+desc+","+fee+","+action+","+supportingDocument+")");
                
		 
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		return "Success"; 
	}
	public int getMaxID(){
             Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
	 
	
	 
	try{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234");
		 statement = con.createStatement(); 
                 resultSet = statement.executeQuery("SELECT max(penaltyID) 'Max' from PENALTIES"); 
                if(!resultSet.next()){

                        return 1;

                }
                return Integer.parseInt(resultSet.getString("Max"));
             
         }
	catch(SQLException e){
		e.printStackTrace();
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
		return 1; // Just returning appropriate message otherwise
	} 
	 
        
        public Penalties getPenalty(int id) {
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;	 
		try{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234"); //establishing connection
			 statement = con.createStatement(); 
			 resultSet = statement.executeQuery("SELECT * from PENALTIES where penaltyID = "+id); 
			 if(!resultSet.next()){
				 
				 return null;
			 
			 }
			
			 
			
			
			 
			 int penaltyId = Integer.parseInt(resultSet.getString("penaltyID")); //fetch the values present in database
			 int level = Integer.parseInt(resultSet.getString("penaltyLevel"));
                         String desc = resultSet.getString("penaltydescription");
			 double fee = Double.parseDouble(resultSet.getString("penaltyFee"));
			 String action = resultSet.getString("penaltyAction");
                         String doc = resultSet.getString("enablingDocumentID");
                         int document = 0;
                         if(doc==null)
			 document = 0;
                         else
                             document = Integer.parseInt(doc);
			
			
			
			
			
			Penalties pen = new Penalties(penaltyId,level,desc,fee,action,document);
			return pen;
					
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			return null;
		}

	
	
	public String modifyPenalty(Penalties p) {
			
			Connection con = null;
			Statement statement = null;
			int ID = p.getId();
			int level = p.getLevel();
                        String desc = p.desc;
                        double fee = p.fee;
                        String action = p.action;
                        int docID = p.getDocument();
                        String doc =null;
                        if(desc!=null)
                            desc = "'"+desc+"'";
                        if(action!=null)
                            action = "'"+action+"'";
                        if(docID!=0)
                            doc = ""+docID;
			try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234");
			
			 statement = con.createStatement(); 
			statement.executeUpdate("UPDATE PENALTIES"
			 		+ " SET penaLtylevel = "+level+",penaltydescription = "+desc+",penaltyfee = "+fee+",action = "+action+",docID ="+doc+""
                                        + "  where penaltyID = " + ID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //establishing connection
			return "Success";
		}
}