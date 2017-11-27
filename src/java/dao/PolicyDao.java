package dao;
 


import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

import model.BoardMember;
import model.Document;
import model.Penalties;
import model.Policy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


 public class PolicyDao {
	 //Adding policies
	 public String addPolicy(Policy policy) {

	
	String desc = policy.getPolicydesc();
	String penalty = null;
	if(policy.getPenalty()!=0){
            penalty = "'"+policy.getPenalty()+"'";
        }
       
	int supportingDocument = policy.getDocument();
	
	Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
	 
	
	 
	try{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234");
		 statement = con.createStatement(); 
		statement.executeUpdate("INSERT INTO POLICIES(policyDesc,enactmentDate,stopImplementDate,penaltyID,supportingDocumentID,state)"
		 		+ "value('"+desc+"','9999-12-31','9999-12-31',"+penalty+","+supportingDocument+",'Created')"); 
		 
	
		 ArrayList<String> aff = policy.getAffected();
                 for(int i =0;i<aff.size();i++){
                     statement.executeUpdate("INSERT INTO affectbypolicy(policyID,audienceID)"
		 		+ "value("+policy.getPolicyID()+","+aff.get(i).substring(0,aff.get(i).indexOf("-"))+")"); 
                 }
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
		return "Success"; // Just returning appropriate message otherwise
	}
	 
         public int getMaxID(){
             Connection con = null;
	Statement statement = null;
	ResultSet resultSet = null;
	 
	
	 
	try{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234");
		 statement = con.createStatement(); 
                 resultSet = statement.executeQuery("SELECT max(policyID) 'Max' from POLICIES"); 
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
	 public Policy getPolicy(int id) {
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
			 resultSet = statement.executeQuery("SELECT * from POLICIES where policyID = "+id); 
			 if(!resultSet.next()){
				 
				 return null;
			 
			 }
			
			 int policyId = 0;
			String desc = "";
			String enact = "";
			String stop = "";
			
			int penalty = 0;
			
			
                        int document = 0;
			
			
			String enabler = null;
			
			String state = "";
			ArrayList<String> affected = new ArrayList<String>();
			 
			 policyId = Integer.parseInt(resultSet.getString("policyID")); //fetch the values present in database
			 desc = resultSet.getString("policydesc");
			 enact = resultSet.getString("enactmentDate");
			 stop = resultSet.getString("stopImplementDate");
				
			penalty = Integer.parseInt(resultSet.getString("penaltyID"));
				
				
			document = Integer.parseInt(resultSet.getString("supportingDocumentID"));
			
			
			enabler = resultSet.getString("enablingBoard");
			
			state = resultSet.getString("State");
			
			resultSet = statement.executeQuery("SELECT  a.name as 'Name',a.audienceID as 'ID' from affectByPolicy af join audienceType a on af.audienceID = a.audienceID where af.policyID = "+id);
			
			while(resultSet.next()){
				 affected.add(resultSet.getString("ID")+"-"+resultSet.getString("Name"));
			     
				 
			}
			Policy policy = new Policy(policyId,desc,penalty,document,enact,stop,enabler,state,affected);
			return policy;
					
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			return null; // Just returning appropriate message otherwise
		}
	
         public ArrayList<String> getAffectedName() {
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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234");
			 statement = con.createStatement(); 
			 resultSet = statement.executeQuery("SELECT name,audienceID from audienceType "); 
			 if(!resultSet.next()){
				 
				 return null;
			 
			 }
			
			resultSet.beforeFirst();
			
			
			ArrayList<String> affected = new ArrayList<String>();
			 
			
			while(resultSet.next()){
				 affected.add(resultSet.getString("audienceID")+"-"+resultSet.getString("name"));			     				 
			}
			return affected;					
		}
		catch(SQLException e){
			e.printStackTrace();}
			return null;
         }
	 public String changeStatePolicy(int policyID,String newState) {
			Connection con = null;
			Statement statement = null;
			try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234");
			
			 statement = con.createStatement(); 
                         if(newState.equals("Approved")){
                            Date d = new Date();
                             DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                             statement.executeUpdate("UPDATE POLICIES "
			 		+ "SET state = 'Approved', enactmentDate = '"+df.format(d)+"' where policyID = " + policyID);
                         }
                         else if(newState.equals("Removed")){
                             Date d = new Date();
                             DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                             statement.executeUpdate("UPDATE POLICIES "
			 		+ "SET state = 'Removed', stopImplementDate = '"+df.format(d)+"' where policyID = " + policyID);
                         }
                         else if(newState.equals("Suspend")){
                              statement.executeUpdate("UPDATE POLICIES "
                                                    + "SET state = 'Suspend' where policyID = " + policyID);
                         }
                         else if(newState.equals("Rejected")){
                              statement.executeUpdate("UPDATE POLICIES "
                                                    + "SET state = 'Rejected' where policyID = " + policyID);
                         }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();} //establishing connection
			return "Success";
         }
         
         public String addAudienceType(String newA) {
		 Connection con = null;
		Statement statement = null;
			 
		try{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234"); 
			 statement = con.createStatement(); 
			 statement.executeUpdate("INSERT INTO audienceType(name) "
                                                          + "values("+newA+")"); 
			
			
			
			 
			
			
			return "Success";					
		}
		catch(SQLException e){
			e.printStackTrace();}
			return null;
         }
    public String modifyPolicy(Policy p) {
        
	
	
	Connection con = null;
	Statement statement = null;
	
	String penalty =null;
        String doc = null;
        int id = p.getPolicyID();
        String desc = p.getPolicydesc();
        String enact = p.getEnactment();
        String end = p.getStopimplementDate();
        int penaltyC = p.getPenalty();
        int document = p.getDocument();
        ArrayList<String> affected = p.getAffected();
	
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234"); //establishing connection
		 statement = con.createStatement(); 
		statement.executeQuery("UPDATE POLICIES"
		 		+ " set policydesc= "+desc+",enactmentDate='"+enact+"',stopImplementDate='"+end+"',penaltyID = "+penaltyC+",supportingDocumentID = "+document+",state = 'Modified'"
                                + " where policyID = "+id); 
		statement.executeQuery("DELETE FROM affectByPolicy where policyID = "+id);
			
		for(int i = 0;i<affected.size();i++){
			statement.executeQuery("INSERT INTO affectByPolicy(policyID,audienceID)"
                                + "values("+id+","+affected.get(i).substring(0,affected.get(i).indexOf("-"))+")");
			     
				 
		}
		 
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
		return "Success"; // Just returning appropriate message otherwise
	}
    public String removePolicy(int id) {
        
	
	
	
	
	
        
       
	
            
        
	this.changeStatePolicy(id, "Removed");
		return "Success"; // Just returning appropriate message otherwise
	}
    
    public String approvePolicy(int id) {
        
	
	
	
	

       
	
            
        
	this.changeStatePolicy(id, "Approved");
		return "Success"; // Just returning appropriate message otherwise
	}
    
    public String suspendPolicy(Policy p) {
        
	
	
	
	
	
        int id = p.getPolicyID();
       
	
            
        
	this.changeStatePolicy(id, "Suspend");
		return "Success"; // Just returning appropriate message otherwise
	}
    public String rejectPolicy(Policy p) {
        
	
	
	
	
	
        int id = p.getPolicyID();
       
	
            
        
	this.changeStatePolicy(id, "Rejected");
	return "Success"; // Just returning appropriate message otherwise
	}
         
}