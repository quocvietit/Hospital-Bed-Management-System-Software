package entities;

import java.util.ArrayList;

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
		
//		Room r1 = new Room("r1", "Room 1", 1000);
//		Room r2 = new Room("r2", "Room 2", 1200);
//		Room r3 = new Room("r3", "Room 3", 1100);
//		
//		listRoom.add(r1);
//		listRoom.add(r2);
//		listRoom.add(r3);
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

	public ArrayList<Room> getListRoom() {
		return listRoom;
	}

	public void setListRoom(ArrayList<Room> listRoom) {
		this.listRoom = listRoom;
	}
	
	@Override
	public String toString() {
		return departmentName;
	}
	
}
