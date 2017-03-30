package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class Main extends JFrame {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
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

		pnNorth.add(lblTitle, BorderLayout.CENTER);
		contentPane.add(pnNorth, BorderLayout.NORTH);

		// Center
		JPanel pnCenter = new JPanel(new BorderLayout());
		pnCenter.setPreferredSize(new Dimension(1000, 600));

		// West
		JPanel pnCenterWest = new JPanel(new BorderLayout());
		pnCenterWest.setPreferredSize(new Dimension(300, 600));

		// North-West
		JPanel pnCenterWestNorth = new JPanel(new BorderLayout());
		pnCenterWestNorth.setPreferredSize(new Dimension(300, 540));

		// add data tree
		root = new DefaultMutableTreeNode("Danh sách khoa");
		DefaultMutableTreeNode khoa1 = new DefaultMutableTreeNode("Khoa 1");
		DefaultMutableTreeNode khoa2 = new DefaultMutableTreeNode("Khoa 2");
		DefaultMutableTreeNode p1 = new DefaultMutableTreeNode("Phòng 1");
		DefaultMutableTreeNode p2 = new DefaultMutableTreeNode("Phòng 2");
		DefaultMutableTreeNode p3 = new DefaultMutableTreeNode("Phòng 3");
		DefaultMutableTreeNode p4 = new DefaultMutableTreeNode("Phòng 4");
		DefaultMutableTreeNode p5 = new DefaultMutableTreeNode("Phòng 5");
		khoa1.add(p1);
		khoa1.add(p2);
		khoa1.add(p3);
		khoa2.add(p4);
		khoa2.add(p5);
		root.add(khoa1);
		root.add(khoa2);

		// Tree
		tree = new JTree(root);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		JScrollPane jsTree = new JScrollPane(tree);
		pnCenterWestNorth.add(jsTree);

		pnCenterWest.add(pnCenterWestNorth, BorderLayout.NORTH);

		// South-West
		JPanel pnCenterWestSouth = new JPanel();
		pnCenterWestSouth.setPreferredSize(new Dimension(300, 40));
		pnCenterWestSouth.add(buttonXemThongTin = new JButton("Xem Thông Tin"));

		pnCenterWest.add(pnCenterWestSouth, BorderLayout.SOUTH);

		pnCenter.add(pnCenterWest, BorderLayout.WEST);

		// East
		JPanel pnCenterEast = new JPanel(new BorderLayout());
		pnCenterEast.setPreferredSize(new Dimension(670, 600));

		// North-East
		JPanel pnCenterEastNorth = new JPanel(new BorderLayout());
		pnCenterEastNorth.setPreferredSize(new Dimension(670, 540));

		// table
		String[] colName = { "Mã giường", "Giá", "Loại giường", "Mã số bệnh nhân" };
		tableMode = new DefaultTableModel(colName, 1);
		table = new JTable(tableMode);
		JScrollPane jsTable = new JScrollPane(table);
		pnCenterEastNorth.add(jsTable);

		pnCenterEast.add(pnCenterEastNorth, BorderLayout.NORTH);

		// South-East
		JPanel pnCenterEastSouth = new JPanel();
		pnCenterEastSouth.setPreferredSize(new Dimension(670, 40));
		pnCenterEastSouth.add(buttonDieuChuyenBenhNhan = new JButton("Điều chuyển bệnh nhân"));

		pnCenterEast.add(pnCenterEastSouth, BorderLayout.SOUTH);

		pnCenter.add(pnCenterEast, BorderLayout.EAST);

		contentPane.add(pnCenter, BorderLayout.CENTER);
		
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
