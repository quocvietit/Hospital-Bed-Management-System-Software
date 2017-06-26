package ui;

import javax.swing.table.AbstractTableModel;

import entities.BedPatientDetails;

public class PatientTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BEDID = 0;
	private static final int PATIENTID = 1;
	private static final int CHECKIN = 2;
	private static final int CHECKOUT = 3;
	private String[] columnNames = {"BEDID", "PATIENTID", "CHECKIN", "CHECKOUT"};
	private BedPatientDetails bedPatientDetails;
	
	/**
	 * @param columnNames
	 */
	public PatientTableModel(BedPatientDetails bedPatientDetails) {
		this.bedPatientDetails = bedPatientDetails;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int x, int y) {
		switch (y) {
		case BEDID:
			return bedPatientDetails.getBedID();
		case PATIENTID:
			return bedPatientDetails.getPatientID();
		case CHECKIN:
			return bedPatientDetails.getGetCheckin();
		case CHECKOUT:
			return bedPatientDetails.getCheckout();
		default:
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "PatientTableModel [bedPatientDetails=" + bedPatientDetails + "]";
	}

	
	
}
