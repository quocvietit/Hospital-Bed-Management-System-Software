package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

<<<<<<< HEAD
import database.Database;
import database.DbUtils;
=======
import Databases.Database;
import Databases.DbUtils;
>>>>>>> origin/master

public class Room {
	private String roomID;
	private String roomName;
	private double price;
<<<<<<< HEAD
	private String departmentID;
	private String typeRoomID;
	private ArrayList<Bed> listBed;
	
	public Room(){
		this("","",0.0,"","");
	}
	
	public Room(String roomID, String roomName, double price, String departmentID, String typeRoomID) {
=======

	private Department department;
	private ArrayList<Bed> listBed;
	// private ArrayList<Patient> listPatient;

	public Room() {
		this("", "", 0.0);
	}

	public Room(String roomID, String roomName, double price) {
>>>>>>> origin/master
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.price = price;
		this.departmentID = departmentID;
		this.typeRoomID = typeRoomID;
		listBed = new ArrayList<Bed>();
<<<<<<< HEAD

=======
		// listPatient = new ArrayList<Patient>();

		/*
		 * Bed b1 = new Bed("b1", "Bed 1", 100, "Normal", "Active"); Bed b2 =
		 * new Bed("b2", "Bed 2", 100, "Plus", "Active"); Bed b3 = new Bed("b3",
		 * "Bed 3", 100, "Normal", "Active");
		 * 
		 * listBed.add(b1); listBed.add(b2); listBed.add(b3);
		 */
>>>>>>> origin/master
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

	public ArrayList<Bed> getListBed() {
		Connection connec = Database.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
<<<<<<< HEAD
		listBed = new ArrayList<Bed>();
=======
		
>>>>>>> origin/master
		try {
			stmt = connec.prepareStatement("select * from Bed where RoomID = ?");
			stmt.setString(1, roomID);
			rs = stmt.executeQuery();
			while (rs.next()) {
<<<<<<< HEAD
				listBed.add(new Bed(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(6)));
=======
				listBed.add(new Bed(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)), rs.getString(4), rs.getString(5)));
>>>>>>> origin/master
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(rs, stmt);
		}
<<<<<<< HEAD
		return listBed;
	}
	
=======
		
		return listBed;
	}

	/*
	 * public void setListPatient(ArrayList<Patient> listPatient) {
	 * this.listPatient = listPatient; }
	 * 
	 * public ArrayList<Patient> getListPatient() { return listPatient; }
	 */

>>>>>>> origin/master
	@Override
	public String toString() {
		return roomName;
	}
<<<<<<< HEAD
	
	// Add bed
//	public boolean addBed(Bed b){
//		if(listBed.contains(b)){
//			return false;
//		}
//		else{
//			b.setRoom(this);
//			return listBed.add(b);
//		}
//	}
	
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
=======

	public boolean addBed(Bed b) {
		if (listBed.contains(b)) {
			return false;
		} else {
			b.setRoom(this);
			return listBed.add(b);
>>>>>>> origin/master
		}
		return "Not found";
	}

}
