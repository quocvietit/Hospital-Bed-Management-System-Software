package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import entities.Bed;
import entities.Department;
import entities.Hospital;
import entities.Room;
import javafx.scene.control.ScrollPane;

public class GUIDieuChuyenBenhNhan extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTable table;
	private JButton buttonThemBenhNhan;
	private DefaultMutableTreeNode root;
	private JTree tree;
	private JButton buttonXemThongTin;
	private ArrayList<Department> listDepartment;
	private ArrayList<Room> listRoom;
	private ArrayList<Bed> listBed;
	private String bedID;

	private TableModel model;

	private DefaultTreeModel treeModel;

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
<<<<<<< HEAD
=======
		
		listDepartment = new Hospital().getListDepartment();
		
		for(Department r : listDepartment){
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(r.getDepartmentName());
			root.add(node);
		}
>>>>>>> origin/master
		treeModel = new DefaultTreeModel(root);
		treeModel.addTreeModelListener(new MyTreeModelListener());
		
		//tree
		tree = new JTree(treeModel);
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);

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
		
		listBed = new Room().getListBed();
		model = new TableModel(listBed);
		// Print list bed
		System.out.println(model.toString());
		table = new JTable(model);
		pnEastNorth.add(new JScrollPane(table));
		pnEast.add(pnEastNorth, BorderLayout.NORTH);

		// South-East
		JPanel pnEastSouth = new JPanel();
		pnEastSouth.setPreferredSize(new Dimension(670, 40));
		pnEastSouth.add(buttonThemBenhNhan = new JButton("Thêm bệnh nhân"));
		pnEast.add(pnEastSouth, BorderLayout.SOUTH);
		contentPane.add(pnEast, BorderLayout.EAST);
		
		//event 
		updateTree();
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// select tree
				
			}
		});
		
		buttonThemBenhNhan.addActionListener(this);
		buttonXemThongTin.addActionListener(this);
		buttonXemThongTin.setEnabled(false);
		buttonThemBenhNhan.setEnabled(false);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getBedIDAndRoomID();
				buttonThemBenhNhan.setEnabled(true);
			}
		});
	}

	private void updateTree() {
		List<String> list = new ArrayList<String>();
		list.add("k1");
		for(int i=0; i<5; i++){
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(i);
			treeModel.insertNodeInto(child,root, root.getChildCount());
			if(true){
				tree.scrollPathToVisible(new TreePath(child.getPath()));
			}
		}
	}
	
	String roomID;
	
	public void getBedIDAndRoomID(){
		int row = table.getSelectedRow();
		if(row >= 0){
			bedID = (String) table.getValueAt(row, 0);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(buttonXemThongTin)){
			
		}
		else if(o.equals(buttonThemBenhNhan)){
			GUIAddPatient gui = new GUIAddPatient(bedID);
			gui.setVisible(true);
			
		}
	}
	
	public static void main(String[] args) {
		new GUIDieuChuyenBenhNhan().setVisible(true);
	}

}
