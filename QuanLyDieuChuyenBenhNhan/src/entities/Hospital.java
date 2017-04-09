package entities;

import java.util.ArrayList;

public class Hospital {
//	private ArrayList<Department> listDepartment;
	private ArrayList<Room> listRoom;
	public Hospital(){
//		listDepartment = new ArrayList<Department>();
		listRoom = new ArrayList<Room>();
		
//		Department d1 = new Department("d1","Department 1");
//		Department d2 = new Department("d2","Department 2");
		
		Room r1 = new Room("r1", "Room 1", 1000);
		Room r2 = new Room("r2", "Room 2", 1200);
		Room r3 = new Room("r3", "Room 3", 1100);
		
		r1.addBed(new Bed("b1", "Bed 1", 100, "Normal", "Actice"));
		r1.addBed(new Bed("b2", "Bed 2", 100, "Normal", "Actice"));
		r2.addBed(new Bed("b3", "Bed 3", 100, "Normal", "Actice"));
		r3.addBed(new Bed("b4", "Bed 4", 100, "Normal", "Actice"));
		
		listRoom.add(r1);
		listRoom.add(r2);
		listRoom.add(r3);
		
//		listDepartment.add(d1);
//		listDepartment.add(d2);
	}
	
//	public ArrayList<Department> getListDepartment() {
//		return listDepartment;
//	}
	
	public ArrayList<Room> getListRoom() {
		return listRoom;
	}
}
