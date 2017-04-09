package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import entities.Bed;
import entities.Department;
import entities.Hospital;
import entities.Room;
import javafx.scene.control.ScrollPane;

public class GUIDieuChuyenBenhNhan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private DefaultTableModel tableMode;
	private JTable table;
	private JButton buttonDieuChuyenBenhNhan;
	private DefaultMutableTreeNode root;
	private JTree tree;
	private JButton buttonXemThongTin;
	private ArrayList<Department> listDepartment;
	private ArrayList<Room> listRoom;
	private ArrayList<Bed> listBed;

	private TableModel model;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUIDieuChuyenBenhNhan frame = new GUIDieuChuyenBenhNhan();
//					 //frame.pack(); suitable for system
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public static void main(String[] args) {
		new GUIDieuChuyenBenhNhan().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public GUIDieuChuyenBenhNhan() {
		setTitle("Hệ thống Quản lý giường bệnh");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// North
		JPanel pnNorth = new JPanel();
		pnNorth.setPreferredSize(new Dimension(1000, 60));

		Font font = new Font("Times New Roman", Font.BOLD, 35);
		JLabel lblTitle = new JLabel("QUẢN LÝ ĐIỀU CHUYỂN BỆNH NHÂN"); // title
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.DARK_GRAY);

		pnNorth.add(lblTitle);
		contentPane.add(pnNorth, BorderLayout.NORTH);

		// West
		JPanel pnWest = new JPanel(new BorderLayout());
		pnWest.setPreferredSize(new Dimension(300, 600));

		// North-West
		JPanel pnWestNorth = new JPanel(new BorderLayout());
		pnWestNorth.setPreferredSize(new Dimension(300, 540));

		// add data tree
		root = new DefaultMutableTreeNode("Danh sách khoa");
//		DefaultMutableTreeNode khoa1 = new DefaultMutableTreeNode("Khoa 1");
//		DefaultMutableTreeNode khoa2 = new DefaultMutableTreeNode("Khoa 2");
//		DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("Phòng 1");
//		DefaultMutableTreeNode p2 = new DefaultMutableTreeNode("Phòng 2");
//		DefaultMutableTreeNode p3 = new DefaultMutableTreeNode("Phòng 3");
//		DefaultMutableTreeNode p4 = new DefaultMutableTreeNode("Phòng 4");
//		DefaultMutableTreeNode p5 = new DefaultMutableTreeNode("Phòng 5");
//		khoa1.add(p1);
//		khoa1.add(p2);
//		khoa1.add(p3);
//		khoa2.add(p4);
//		khoa2.add(p5);
//		root.add(khoa1);
//		root.add(khoa2);
		
//		pnWest.add(new JScrollPane(tree = new JTree(root)));
//		listDepartment = new Hospital().getListDepartment();
//		for(Department d : listDepartment){
//			DefaultMutableTreeNode node = new DefaultMutableTreeNode(d);
//			for(Room r : listRoom){
//				DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(r);
//				node.add(node1);
//			}
//			root.add(node);
//		}
		
		listRoom = new Hospital().getListRoom();
		
		for(Room r : listRoom){
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(r);
			root.add(node);
		}

		// Tree
		tree = new JTree(root);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		JScrollPane jsTree = new JScrollPane(tree);
		pnWestNorth.add(jsTree);

		pnWest.add(pnWestNorth, BorderLayout.NORTH);

		// South-West
		JPanel pnWestSouth = new JPanel();
		pnWestSouth.setPreferredSize(new Dimension(300, 40));
		pnWestSouth.add(buttonXemThongTin = new JButton("Xem Thông Tin"));

		pnWest.add(pnWestSouth, BorderLayout.SOUTH);

		contentPane.add(pnWest, BorderLayout.WEST);

		// East
		JPanel pnEast = new JPanel(new BorderLayout());
		pnEast.setPreferredSize(new Dimension(670, 600));

		// North-East
		JPanel pnEastNorth = new JPanel(new BorderLayout());
		pnEastNorth.setPreferredSize(new Dimension(670, 540));

		// table
//		String[] colName = { "Mã giường", "Giá", "Loại giường", "Mã số bệnh nhân" };
//		tableMode = new DefaultTableModel(colName, 1);
//		table = new JTable(tableMode);
//		JScrollPane jsTable = new JScrollPane(table);
//		pnEastNorth.add(jsTable);
		
		pnEastNorth.add(new JScrollPane(table = new JTable()));
		model = new TableModel(listBed);
		table.setModel(model);

		pnEast.add(pnEastNorth, BorderLayout.NORTH);

		// South-East
		JPanel pnEastSouth = new JPanel();
		pnEastSouth.setPreferredSize(new Dimension(670, 40));
		pnEastSouth.add(buttonDieuChuyenBenhNhan = new JButton("Điều chuyển bệnh nhân"));

		pnEast.add(pnEastSouth, BorderLayout.SOUTH);

		contentPane.add(pnEast, BorderLayout.EAST);
		
		//event 
		buttonXemThongTin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Xem thông tin phòng bệnh
				
			}
		});
		
		buttonDieuChuyenBenhNhan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Điều chuyển bệnh nhân
				
			}
		});
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// select tree
				
			}
		});
	}

}
