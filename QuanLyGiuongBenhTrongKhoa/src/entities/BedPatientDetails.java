package entities;

import java.time.LocalDateTime;

public class BedPatientDetails {

	private String bedID;
	private String patientID;
	private LocalDateTime checkin;
	private String checkout;
	
	public BedPatientDetails() {
		this("","",LocalDateTime.now(),"");
	}

	/**
	 * @param bedID
	 * @param patientID
	 * @param checkin
	 * @param checkout
	 */
	public BedPatientDetails(String bedID, String patientID, LocalDateTime checkin, String checkout) {
		super();
		this.bedID = bedID;
		this.patientID = patientID;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public String getBedID() {
		return bedID;
	}

	public void setBedID(String bedID) {
		this.bedID = bedID;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public LocalDateTime getCheckin() {
		return checkin;
	}

	public void setCheckin(LocalDateTime checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
	
}
