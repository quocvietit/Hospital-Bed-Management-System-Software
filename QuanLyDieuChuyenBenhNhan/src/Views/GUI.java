package Views;

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

import Databases.Database;

public class GUI extends JFrame {

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

	private DefaultTreeModel treeModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					 //frame.pack(); suitable for system
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
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

		// table
		String[] colName = { "Mã giường", "Giá", "Loại giường", "Mã số bệnh nhân" };
		tableMode = new DefaultTableModel(colName, 1);
		table = new JTable(tableMode);
		JScrollPane jsTable = new JScrollPane(table);
		pnEastNorth.add(jsTable);

		pnEast.add(pnEastNorth, BorderLayout.NORTH);

		// South-East
		JPanel pnEastSouth = new JPanel();
		pnEastSouth.setPreferredSize(new Dimension(670, 40));
		pnEastSouth.add(buttonDieuChuyenBenhNhan = new JButton("Điều chuyển bệnh nhân"));

		pnEast.add(pnEastSouth, BorderLayout.SOUTH);

		contentPane.add(pnEast, BorderLayout.EAST);
		
		//event 
		updateTree();
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

	private void updateTree() {
		// TODO Auto-generated method stub
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
	
	private List<String> getDS() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
