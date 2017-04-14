package ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entities.Bed;

public class TableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BEDID = 0;
	private static final int BEDNAME = 1;
	private static final int PRICE = 2;
	private static final int TYPE = 3;
	private static final int STATUS = 4;
	private ArrayList<Bed> listBed;
	private String[] columnNames = { "ID", "NAME", "PRICE", "TYPE", "STATUS" };

	/**
	 * @param listBed
	 */
	public TableModel(ArrayList<Bed> listBed) {
		this.listBed = listBed;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == PRICE)
			return Double.class;
		else
			return String.class;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return listBed.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Bed b = listBed.get(arg0);
		switch (arg1) {
		case BEDID:
			return b.getBedID();
		case BEDNAME:
			return b.getBedName();
		case PRICE:
			return b.getPrice();
		case TYPE:
			return b.getType();
		case STATUS:
			return b.getStatus();
		default:
			return null;
		}
	}

	@Override
	public String toString() {
		return "TableModel [listBed=" + listBed + "]";
	}
	
	

}
