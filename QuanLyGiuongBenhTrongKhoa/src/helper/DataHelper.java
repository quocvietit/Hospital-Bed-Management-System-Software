package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.Database;
import entities.BedPatientDetails;

public class DataHelper {

	private static Connection connection;
	
	public static boolean insertData(BedPatientDetails bedPatientDetails) {
		String insertBedPatient = "insert into bedpatientdetails values(?,?,?,?)";
		int date = bedPatientDetails.getCheckin().getDayOfMonth();
		int month = bedPatientDetails.getCheckin().getMonthValue();
		int year = bedPatientDetails.getCheckin().getYear();
		String checkin = date + "/" + month + "/" + year;
		
		connection = Database.getCon();
		try {
			PreparedStatement stmt = connection.prepareStatement(insertBedPatient);
			stmt.setString(1, bedPatientDetails.getBedID());;
			stmt.setString(2, bedPatientDetails.getPatientID());;
			stmt.setString(3, checkin);
			stmt.setString(4, bedPatientDetails.getCheckout());
			int cnt = stmt.executeUpdate();
			if(cnt > 0){
				System.out.println("Insert success");
				return true;
			}
			else{
				System.out.println("Insert fail");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Cannot insert database");
			e.printStackTrace();
		}
				
		return false;
	}
}
