package dao;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.BoardMember;
import model.Document;
import java.sql.Connection;



public class DocumentDao{
	 
	
	public String addDocument(Document doc)
	 {

		
		String desc= doc.desc;	
		String loc = doc.location;
		int folder = doc.folder;
		String createUserID = doc.getCreate_User().getId();
		
		if(createUserID !=null){
			
			createUserID ="'"+createUserID+"'";
		}
		Connection con = null;
		Statement statement = null;
		
		 
		
		 
		try{
		 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234"); //establishing connection
			 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
			 statement.executeQuery("INSERT INTO DOCUMENTS(description,documentLocation,folderID,create_userID)"
			 		+ "value('"+desc+"','"+loc+"',"+folder+","+createUserID+")"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
			 
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			return "Success"; // Just returning appropriate message otherwise
		}
		 
	
	
		 public Document getDocument(int id)
		 {

			
			
			
			
			
			
			Connection con = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			
			
			 
			try{
			 
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoa","root","1234"); //establishing connection
				 statement = con.createStatement(); //Statement is used to write queries. Read more about iticy
				 resultSet = statement.executeQuery("SELECT * from DOCUMENTS WHERE documentID ="+id); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
				 if(!resultSet.next()){
					 
                                    return null;
				 
				 }
				int docID = 0;
				String desc= "";	
				String loc = "";
				int folder = 0;
				BoardMemberDao bdao = new BoardMemberDao();
				BoardMember createUser = null;
				
		
				
				
				
				docID = Integer.parseInt(resultSet.getString("documentID"));
				desc = resultSet.getString("description");
				loc = resultSet.getString("documentLocation");
				folder = Integer.parseInt(resultSet.getString("folderID"));
				createUser = bdao.getBoardMember(resultSet.getString("create_userID"));
				
				
				
				
				
				Document document = new Document(docID,desc,loc,folder,createUser);
				return document;
						
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
				return null; // Just returning appropriate message otherwise
			}
}
