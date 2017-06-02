package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import database.DbUtils;

public class BedPatientDetails {

	private String bedID;
	private String patientID;
	private String checkin;
	private String checkout;
	
	public BedPatientDetails() {
		this("","","","");
	}

	/**
	 * @param bedID
	 * @param patientID
	 * @param checkin
	 * @param checkout
	 */
	public BedPatientDetails(String bedID, String patientID, String checkin, String checkout) {
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

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	@Override
	public String toString() {
		return "BedPatientDetails [bedID=" + bedID + ", patientID=" + patientID + ", checkin=" + checkin + ", checkout="
				+ checkout + "]";
	}
	
	// Get List BedPatientDetails
	public ArrayList<BedPatientDetails> getListBedPatientDetails() {
		ArrayList<BedPatientDetails> listBedPatientDetails = new ArrayList<BedPatientDetails>();
		Connection connec = Database.getCon();
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		try{
			stmt = connec.prepareStatement("select * from BedPatientDetails");
			rs = stmt.executeQuery();
			while(rs.next()){
				listBedPatientDetails.add(new BedPatientDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtils.close(rs, stmt);
		}
		return listBedPatientDetails;
	}
	
}
