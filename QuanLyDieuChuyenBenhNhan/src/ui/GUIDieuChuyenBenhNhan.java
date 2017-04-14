package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class GUIDieuChuyenBenhNhan extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private TableModel tableMode;
	private JTable table;
	private JButton buttonThemBenhNhan;
	private DefaultMutableTreeNode root;
	private JTree tree;
	private JButton buttonXemThongTin;
	private ArrayList<Department> listDepartment;
	private ArrayList<Room> listRoom;
	private ArrayList<Bed> listBed;

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
		treeModel = new DefaultTreeModel(root);
		treeModel.addTreeModelListener(new MyTreeModelListener());

		// tree
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

		// table
		listBed = new Room().getListBed();
		tableMode = new TableModel(listBed);
		table = new JTable(tableMode);
		pnEastNorth.add(new JScrollPane(table));

		pnEast.add(pnEastNorth, BorderLayout.NORTH);

		// South-East
		JPanel pnEastSouth = new JPanel();
		pnEastSouth.setPreferredSize(new Dimension(670, 40));
		pnEastSouth.add(buttonThemBenhNhan = new JButton("Thêm bệnh nhân"));

		pnEast.add(pnEastSouth, BorderLayout.SOUTH);

		contentPane.add(pnEast, BorderLayout.EAST);

		// event
		updateTree();

		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

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
	}

	private void updateTree() {
		listDepartment = new Hospital().getListDepartment();
		for (Department department : listDepartment) {
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(department);
			treeModel.insertNodeInto(child, root, root.getChildCount());
			listRoom = department.getListRoom();
			for (Room room : listRoom) {
				treeModel.insertNodeInto(new DefaultMutableTreeNode(room), child, child.getChildCount());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(buttonXemThongTin)) {

		} else if (o.equals(buttonThemBenhNhan)) {

		}
	}

	public static void main(String[] args) {
		new GUIDieuChuyenBenhNhan().setVisible(true);
	}

}
