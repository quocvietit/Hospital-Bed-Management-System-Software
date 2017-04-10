package ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entities.Bed;
import entities.Room;

public class GUIRoom extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Bed> listBed ;
	private JTable table;
	private TableModel model;
	public GUIRoom(ArrayList<Bed> listBed){
		setTitle("Room");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		add(new JScrollPane(table = new JTable()));
		model = new TableModel(listBed);
		table.setModel(model);
	}
	
	public ArrayList<Bed> getListBed() {
		return listBed;
	}
	public static void main(String[] args) {
		new GUIRoom(new Room().getListBed()).setVisible(true);
	}
}
