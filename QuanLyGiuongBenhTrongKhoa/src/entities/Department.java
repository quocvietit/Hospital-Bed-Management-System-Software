package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import database.DbUtils;

public class Department {
	private String departmentID;
	private String departmentName;
	
	// List Room
	private ArrayList<Room> listRoom;
	
	public Department(){
		this("", "");
	}

	public Department(String departmentID, String departmentName) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		listRoom = new ArrayList<Room>();
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public ArrayList<Room> getListRoom(String id) {
		Connection connec = Database.getCon();
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		try{
			stmt = connec.prepareStatement("select * from Room where DepartmentID = ?");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while(rs.next()){
				listRoom.add(new Room(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), rs.getString(5)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtils.close(rs, stmt);
		}
		return listRoom;
	}
	
	public ArrayList<Room> getListRoom1() {
		ArrayList<Room> listRoom1 = new ArrayList<Room>();
		Connection connec = Database.getCon();
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		try{
			stmt = connec.prepareStatement("select * from Room");
			rs = stmt.executeQuery();
			while(rs.next()){
				listRoom1.add(new Room(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), rs.getString(5)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtils.close(rs, stmt);
		}
		return listRoom1;
	}

	public void setListRoom(ArrayList<Room> listRoom) {
		this.listRoom = listRoom;
	}
	
	@Override
	public String toString() {
		return departmentName;
	}
	
	
}
