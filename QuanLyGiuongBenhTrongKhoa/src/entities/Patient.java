package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Patient")
@XmlType(propOrder={"patientID","patientName","dayOfBirth","identifyNumber","departmentName","bedID","roomID"})
public class Patient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String patientID;
	private String patientName;
	private String dayOfBirth;
	private String identifyNumber;
	private String departmentName;
	private String bedID;
	private String roomID;
	
	public Patient() {
		this("","","","","","","");
	}
	
	/**
	 * @param patientID
	 * @param patientName
	 * @param dayOfBirth
	 * @param identifyNumber
	 * @param departmentName
	 * @param bedID
	 * @param roomID
	 */
	public Patient(String patientID, String patientName, String dayOfBirth, String identifyNumber,
			String departmentName, String bedID, String roomID) {
		super();
		this.patientID = patientID;
		this.patientName = patientName;
		this.dayOfBirth = dayOfBirth;
		this.identifyNumber = identifyNumber;
		this.departmentName = departmentName;
		this.bedID = bedID;
		this.roomID = roomID;
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

	public String getDayOfBirth() {
		return dayOfBirth;
	}
	
	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getBedID() {
		return bedID;
	}

	public void setBedID(String bedID) {
		this.bedID = bedID;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	@Override
	public String toString() {
		return "Patient [patientID=" + patientID + ", patientName=" + patientName + ", dayOfBirth=" + dayOfBirth
				+ ", identifyNumber=" + identifyNumber + ", departmentName=" + departmentName + ", bedID=" + bedID
				+ ", roomID=" + roomID + "]";
	}

}
