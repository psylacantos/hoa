package dao;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.BoardMember;
import java.sql.Connection;



public class BoardMemberDao {
	
   
	public String addBoardMember(BoardMember boa)
	 {

		
		String id = boa.getId();
		int positionID = boa.getPositionID();
		String effectiveDate =boa.effectiveDate;
		String endDate = boa.endDate;
		int	statusID = boa.statusID;
		int electionID = boa.electionID;
		
		
		Connection con = null;
		Statement statement = null;
		
		 
		
		 
		try{
                    try {
				Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234");
			statement = con.createStatement();
			statement.executeQuery("INSERT INTO BOARDMEMBER(userID,positionID,effectiveDate,end.Date,statusID,electionID)"
			 		+ "value('"+id+"','"+positionID+"','"+effectiveDate+"','"+endDate+"',"+statusID+","+electionID+")");
			 		 
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
                } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                }
			return "Success"; // Just returning appropriate message otherwise
		}
		 
	
	
		 public BoardMember getBoardMember(String id)
		 {

			
			
			
			
			
			
			Connection con = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			
			
			 
			try{
			 
				 con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234"); //establishing connection
				 statement = con.createStatement(); //Statement is used to write queries. Read more about iticy
				 resultSet = statement.executeQuery("SELECT * from BOARMEMBER WHERE userID ="+id); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
				 if(!resultSet.next()){
					 
                                    return null;
				 
				 }
				 String bid = "";
				int positionID = 0;
				String effectiveDate ="";
				String endDate = "";
				int	statusID = 0;
				int electionID = 0;
				
				
		
				
				
				
				bid = resultSet.getString("userID");
				positionID = Integer.parseInt(resultSet.getString("positionID"));
				effectiveDate = resultSet.getString("effectiveDate");
				endDate = resultSet.getString("endDate");
				statusID = Integer.parseInt(resultSet.getString("statusID"));
				electionID = Integer.parseInt(resultSet.getString("electionID"));
				
				
				
				
				BoardMember board = new BoardMember(bid,positionID,effectiveDate,endDate,statusID,electionID);
				return board;
						
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
				return null; // Just returning appropriate message otherwise
		}
         public String removeBoardMember(String bID){
		
		
		Connection con = null;
		Statement statement = null;
		
		 
		
		 
		try{
                    try {
				Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234");
			statement = con.createStatement();
			statement.executeQuery("UPDATE boardmember"
			 		+ "set statusID=5");
			 		 
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
                } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                }
			return "Success"; // Just returning appropriate message otherwise
		}
}
