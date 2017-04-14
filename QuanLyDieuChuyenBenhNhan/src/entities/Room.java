package entities;

import java.util.ArrayList;

public class Room {
	private String roomID;
	private String roomName;
	private double price;
	
	private Department department;
	private ArrayList<Bed> listBed;
	//private ArrayList<Patient> listPatient;
	
	public Room(){
		this("","",0.0);
	}
	
	public Room(String roomID, String roomName, double price) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.price = price;
		listBed = new ArrayList<Bed>();
		//listPatient = new ArrayList<Patient>();
		
		/*Bed b1 = new Bed("b1", "Bed 1", 100, "Normal", "Active");
		Bed b2 = new Bed("b2", "Bed 2", 100, "Plus", "Active");
		Bed b3 = new Bed("b3", "Bed 3", 100, "Normal", "Active");
		
		listBed.add(b1);
		listBed.add(b2);
		listBed.add(b3);*/
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	public void setListBed(ArrayList<Bed> listBed) {
		this.listBed = listBed;
	}
	
	public ArrayList<Bed> getListBed() {
		return listBed;
	}
	
	public void setListPatient(ArrayList<Patient> listPatient) {
		this.listPatient = listPatient;
	}
	
	public ArrayList<Patient> getListPatient() {
		return listPatient;
	}

	@Override
	public String toString() {
		return roomName;
	}
	
	public boolean addBed(Bed b){
		if(listBed.contains(b)){
			return false;
		}
		else{
			b.setRoom(this);
			return listBed.add(b);
		}
	}
	
}
