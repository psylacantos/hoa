package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.USERS;
import model.officer;
public class MapDAO {
    
    public static ArrayList<User> getMarkers(){
		ArrayList<User> markers = new ArrayList<>();
		String sql = "SELECT xAxis, yAxis FROM mappoint;";
		Connection conn = DatabaseUtils.retrieveConnection();
		try{
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()){
				User emp = new User();
				emp.setxAxis(rs.getInt(1));
				emp.setyAxis(rs.getString(2));
				markers.add(mark);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return markers;
	}

	public static boolean addMapPoint(int mappointID, int xAxis, int yAxis){
		boolean isAdded = false;
		Connection conn = DatabaseUtils.retrieveConnection();
		String sql = "INSERT INTO mappoint (xAxis, yAxs, title, description) VALUES (?, ?, ?, ?);";

		try{
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, officer.getxAxis());
                        pStmt.setString(2, officer.getyAxis());
                        pStmt.setString(3, officer.gettitle());
                        pStmt.setString(4, officer.getdescription());

			int hasAdded = pStmt.executeUpdate();
			if(hasAdded != 0){
				isAdded = true;
			}
		}catch(Exception e){
			e.printStackTrace();
			isAdded = false;
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}

		return isAdded;
	}



	public static boolean setMappoint(officer officer){
		boolean isChanged = false;
		String sql = "UPDATE ref_properties SET mappointID = mappointID(?);";
		
		Connection conn = DatabaseUtils.retrieveConnection();
		try{
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, officer.getmappointID());
			
			int result = pStmt.executeUpdate();
			if(result != 0){
				pStmt = conn.prepareStatement(sql2);
				pStmt.setInt(1, loginUser.getmappointID());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){}
			}
		}
		return isChanged;
	}

}
