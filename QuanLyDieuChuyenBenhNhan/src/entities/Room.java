package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import database.DbUtils;

public class Room {
	private String roomID;
	private String roomName;
	private double price;
	private String departmentID;
	private String typeRoomID;
	private ArrayList<Bed> listBed;
	
	public Room(){
		this("","",0.0,"","");
	}
	
	public Room(String roomID, String roomName, double price, String departmentID, String typeRoomID) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.price = price;
		this.departmentID = departmentID;
		this.typeRoomID = typeRoomID;
		listBed = new ArrayList<Bed>();
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getTypeRoomID() {
		return typeRoomID;
	}

	public void setTypeRoomID(String typeRoomID) {
		this.typeRoomID = typeRoomID;
	}

	public void setListBed(ArrayList<Bed> listBed) {
		this.listBed = listBed;
	}

	public ArrayList<Bed> getListBed(String roomID) {
		Connection connec = Database.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		listBed = new ArrayList<Bed>();
		try {
			stmt = connec.prepareStatement("select * from Bed where RoomID = ?");
			stmt.setString(1, roomID);
			rs = stmt.executeQuery();
			while (rs.next()) {
				listBed.add(new Bed(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs, stmt);
		}
		return listBed;
	}
	
	public String toString() {
		return roomName;
	}
	
	// Find department with roomID
	public String findDepartment(String roomID) {
		Department d = new Department();
		for(Room r : d.getListRoom1()){
			if(r.getRoomID().equals(roomID)){
				String departmentID = r.getDepartmentID();
				Hospital h = new Hospital();
				for(Department d1 : h.getListDepartment()){
					if(d1.getDepartmentID().equals(departmentID)){
						return d1.getDepartmentName();
					}
				}
			}
		}
		return "Not found";
	}
	
	// update status is pending
	public boolean updateStatus(String bedID) {
		Connection connection = Database.getCon();
		String updateStatus = "update bed set status = ? where bedid = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(updateStatus);
			stmt.setString(1, "Pending");
			stmt.setString(2, bedID);
			int cnt = stmt.executeUpdate();
			if(cnt > 0){
				System.out.println("Update Status successfully");
				return true;
			}else{
				System.out.println("Update Status failed");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
