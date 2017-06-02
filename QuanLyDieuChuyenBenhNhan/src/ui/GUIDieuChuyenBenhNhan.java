package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import entities.Bed;
import entities.Department;
import entities.Hospital;
import entities.Room;

public class GUIDieuChuyenBenhNhan extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
<<<<<<< HEAD
=======
	private TableModel tableMode;
>>>>>>> origin/master
	private JTable table;
	private JButton btnAddPatient;
	private DefaultMutableTreeNode root;
	private JTree tree;
	private ArrayList<Department> listDepartment;
	private ArrayList<Room> listRoom;
	private ArrayList<Bed> listBed;
<<<<<<< HEAD
	private String bedName;
	private String roomID;
	private String departmentName;
	private TableModel tableModel;
=======
>>>>>>> origin/master

	private DefaultTreeModel treeModel;

	/**
	 * Create the frame.
	 */
	public GUIDieuChuyenBenhNhan() {
		setTitle("HOSPITAL BED MANAGEMENT");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// ------------- North ---------------
		JPanel pnNorth = new JPanel();
		pnNorth.setPreferredSize(new Dimension(1000, 60));
		Font font = new Font("Times New Roman", Font.BOLD, 35);
		JLabel lblTitle = new JLabel("MANAGEMENT PATIENT"); // title
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.DARK_GRAY);
		pnNorth.add(lblTitle);
		contentPane.add(pnNorth, BorderLayout.NORTH);

		//------------- West ---------------
		JPanel pnWest = new JPanel(new BorderLayout());
		pnWest.setPreferredSize(new Dimension(300, 600));

		// North-West
		JPanel pnWestNorth = new JPanel(new BorderLayout());
		pnWestNorth.setPreferredSize(new Dimension(300, 540));

<<<<<<< HEAD
		// Data tree
		root = new DefaultMutableTreeNode("Department Listing");
		treeModel = new DefaultTreeModel(root);
		treeModel.addTreeModelListener(new MyTreeModelListener());

		//tree
=======
		// add data tree
		root = new DefaultMutableTreeNode("Danh sách khoa");
		treeModel = new DefaultTreeModel(root);
		treeModel.addTreeModelListener(new MyTreeModelListener());

		// tree
>>>>>>> origin/master
		tree = new JTree(treeModel);
		tree.setEditable(false);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);

		JScrollPane jsTree = new JScrollPane(tree);
		pnWestNorth.add(jsTree);
		pnWest.add(pnWestNorth, BorderLayout.NORTH);
		contentPane.add(pnWest, BorderLayout.WEST);

		//-------------- East --------------
		JPanel pnEast = new JPanel(new BorderLayout());
		pnEast.setPreferredSize(new Dimension(670, 600));

		// North-East
		JPanel pnEastNorth = new JPanel(new BorderLayout());
		pnEastNorth.setPreferredSize(new Dimension(670, 540));
<<<<<<< HEAD
		pnEastNorth.add(new JScrollPane(table = new JTable()));
=======

		// table
		listBed = new Room().getListBed();
		tableMode = new TableModel(listBed);
		table = new JTable(tableMode);
		pnEastNorth.add(new JScrollPane(table));

>>>>>>> origin/master
		pnEast.add(pnEastNorth, BorderLayout.NORTH);

		// South-East
		JPanel pnEastSouth = new JPanel();
		pnEastSouth.setPreferredSize(new Dimension(670, 40));
		pnEastSouth.add(btnAddPatient = new JButton("Add Patient"));
		pnEast.add(pnEastSouth, BorderLayout.SOUTH);
		contentPane.add(pnEast, BorderLayout.EAST);

<<<<<<< HEAD
		updateTree();
=======
		// event
		updateTree();

>>>>>>> origin/master
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
<<<<<<< HEAD
				Object nodeInfo = node.getUserObject();
				
				if(nodeInfo instanceof Department){
					Department department = (Department) nodeInfo;
					System.out.println(department.getDepartmentID());
				} else if(nodeInfo instanceof Room){
					Room room = (Room) nodeInfo;
					listBed = room.getListBed();
					System.out.println(room.getRoomID());
					tableModel = new TableModel(listBed);
					table.setModel(tableModel);
				}
			}
		});
		
		btnAddPatient.addActionListener(this);
		btnAddPatient.setEnabled(false);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getBedIDAndRoomID();
				btnAddPatient.setEnabled(true);
			}
		});
=======

				if (node == null) {
					return;
				} else if (node.getLevel() == 2) {
					Object nodeInfo = node.getUserObject();
					Room room = (Room) nodeInfo;
					System.out.println(room.getListBed());
					/*for (Bed bed : listBed) {
						Object[] rowData = { bed.getBedID(), bed.getBedName(), bed.getPrice(), bed.getType(),
								bed.getStatus() };
						tableMode.(rowData);
					}*/

				} else {
					Object nodeInfo = node.getUserObject();
					Department department = (Department) nodeInfo;
					System.out.println(department.getDepartmentID());
				}
			}
		});

		buttonThemBenhNhan.addActionListener(this);
		buttonXemThongTin.addActionListener(this);
>>>>>>> origin/master
	}

	private void updateTree() {
		listDepartment = new Hospital().getListDepartment();
<<<<<<< HEAD
		for(Department department : listDepartment){
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(department);
			treeModel.insertNodeInto(child,root, root.getChildCount());

			listRoom =  department.getListRoom();
			for(Room room : listRoom){
				DefaultMutableTreeNode child1 = new DefaultMutableTreeNode(room);
				treeModel.insertNodeInto(child1, child, child.getChildCount());
			}	
		}
	}

	public void getBedIDAndRoomID(){
		int row = table.getSelectedRow();
		if(row >= 0){
			bedName = (String) table.getValueAt(row, 1);
			roomID = (String) table.getValueAt(row, 4);
		}
	}
=======
		for (Department department : listDepartment) {
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(department);
			treeModel.insertNodeInto(child, root, root.getChildCount());
			listRoom = department.getListRoom();
			for (Room room : listRoom) {
				treeModel.insertNodeInto(new DefaultMutableTreeNode(room), child, child.getChildCount());
			}
		}
	}
>>>>>>> origin/master

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
<<<<<<< HEAD
		if(o.equals(btnAddPatient)){
			String roomName = "";
			Room r = new Room();
			departmentName = r.findDepartment(roomID);
			Department d = new Department();
			for(Room r1 : d.getListRoom1()){
				if(r1.getRoomID().equals(roomID)){
					roomName = r1.getRoomName();
					break;
				}
			}
			GUIAddPatient gui = new GUIAddPatient(bedName, roomName, departmentName);
			gui.setVisible(true);
=======
		if (o.equals(buttonXemThongTin)) {

		} else if (o.equals(buttonThemBenhNhan)) {
>>>>>>> origin/master

		}
	}

	public static void main(String[] args) {
		new GUIDieuChuyenBenhNhan().setVisible(true);
	}

}
