package entities;

import java.time.LocalDateTime;

public class Patient {
	private String patientID;
	private String patientName;
	private LocalDateTime dayOfBirth;
	private String identifyNumber;
	
	private Room room;
	private Bed bed;
	
	public Patient() {
		this("","",LocalDateTime.now(),"");
	}

	/**
	 * @param patientID
	 * @param patientName
	 * @param dayOfBirth
	 * @param identifyNumber
	 */
	public Patient(String patientID, String patientName, LocalDateTime dayOfBirth, String identifyNumber) {
		super();
		this.patientID = patientID;
		this.patientName = patientName;
		this.dayOfBirth = dayOfBirth;
		this.identifyNumber = identifyNumber;
		room = new Room();
		bed = new Bed();
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public LocalDateTime getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(LocalDateTime dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	@Override
	public String toString() {
		return "Patient [patientID=" + patientID + ", patientName=" + patientName + ", dayOfBirth=" + dayOfBirth
				+ ", identifyNumber=" + identifyNumber + "]";
	}
	
	
	
}
