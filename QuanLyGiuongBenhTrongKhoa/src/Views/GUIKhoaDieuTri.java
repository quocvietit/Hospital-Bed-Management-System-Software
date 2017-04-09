package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class GUIKhoaDieuTri extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKhoaDieuTri frame = new GUIKhoaDieuTri();
					// frame.pack(); suitable for system
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPane;
	private JButton buttonXemThongTin;
	private JTabbedPane tabbedPane;
	private JComponent jcDanhSachPhong;
	private JComponent jcDanhSachBenhNhan;
	private DefaultMutableTreeNode root;
	private JTree tree;
	private JList list;
	private DefaultTableModel tableMode;
	private JTable table;
	private JButton buttonXuatGiuong;
	private JButton buttonDoiGiuong;
	private JLabel lblTextMaBenhNhan;
	private JLabel lblTextTenBenhNhan;
	private JLabel lblTextPhong;
	private JLabel lblTextMaPhong;
	private JButton buttonNhanBenhNhan;

	/**
	 * Create the frame.
	 */
	public GUIKhoaDieuTri() {
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
		JLabel lblTitle = new JLabel("Quản lý giường bệnh trong khoa");
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

		// Data tree
		root = new DefaultMutableTreeNode("Danh sách phòng");
		DefaultMutableTreeNode phong1 = new DefaultMutableTreeNode("Phòng 1");
		DefaultMutableTreeNode phong2 = new DefaultMutableTreeNode("Phòng 2");
		DefaultMutableTreeNode phong3 = new DefaultMutableTreeNode("Phòng 3");
		root.add(phong1);
		root.add(phong2);
		root.add(phong3);

		// Tree
		tree = new JTree(root);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		JScrollPane jsTree = new JScrollPane(tree);

		// List
		list = new JList<>();
		JScrollPane jsList = new JScrollPane(list);

		// Tabbed Panes
		jcDanhSachPhong = jsTree;
		jcDanhSachBenhNhan = jsList;
		tabbedPane = new JTabbedPane();
		tabbedPane.add("Phòng", jcDanhSachPhong);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.add("Bệnh Nhân", jcDanhSachBenhNhan);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);

		pnWestNorth.add(tabbedPane);

		pnWest.add(pnWestNorth, BorderLayout.NORTH);

		// South-West
		JPanel pnWestSouth = new JPanel();
		pnWestSouth.setPreferredSize(new Dimension(300, 40));
		pnWestSouth.add(buttonXemThongTin = new JButton("Xem Thông Tin"));

		pnWest.add(pnWestSouth, BorderLayout.SOUTH);

		contentPane.add(pnWest, BorderLayout.WEST);

		// East
		JPanel pnEast = new JPanel();
		pnEast.setPreferredSize(new Dimension(670, 600));

		// Tab Danh Sach Phong
		JPanel pnEastMain1 = new JPanel();
		pnEastMain1.setLayout(new BorderLayout());

		// East1
		JPanel pnEast1 = new JPanel(new BorderLayout());
		pnEast1.setPreferredSize(new Dimension(670, 600));

		// North-East1
		JPanel pnEast1North = new JPanel(new BorderLayout());
		pnEast1North.setPreferredSize(new Dimension(670, 540));

		// Table
		String[] colName = { "Mã Giường", "Giá", "Loại", "Trạng Thái", "Mã Bệnh Nhân", "Tên Bệnh Nhân" };
		tableMode = new DefaultTableModel(colName, 1);
		table = new JTable(tableMode);
		JScrollPane jsTable = new JScrollPane(table);
		pnEast1North.add(jsTable);

		pnEast1.add(pnEast1North, BorderLayout.NORTH);

		// South-East1
		JPanel pnEast1South = new JPanel();
		pnEast1South.setLayout(new BoxLayout(pnEast1South, BoxLayout.X_AXIS));
		pnEast1South.setPreferredSize(new Dimension(670, 40));

		JPanel pnXuatGiuong = new JPanel();
		pnXuatGiuong.add(buttonXuatGiuong = new JButton("Xuất Giường"));
		pnEast1South.add(pnXuatGiuong);

		JPanel pnDoiGiuong = new JPanel();
		pnDoiGiuong.add(buttonDoiGiuong = new JButton("Đổi Giường"));
		pnEast1South.add(pnDoiGiuong);

		pnEast1.add(pnEast1South, BorderLayout.SOUTH);

		pnEastMain1.add(pnEast1);

		// Tab danh sach benh nhan
		JPanel pnEastMain2 = new JPanel();
		pnEastMain2.setLayout(new BorderLayout());

		// East2
		JPanel pnEast2 = new JPanel(new BorderLayout());
		pnEast2.setPreferredSize(new Dimension(670, 600));

		// North-East2
		JPanel pnEast2North = new JPanel();
		pnEast2North.setLayout(new BoxLayout(pnEast2North, BoxLayout.Y_AXIS));
		pnEast2North.setPreferredSize(new Dimension(670, 540));
		pnEast2North.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		// Label information
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBorder(new EmptyBorder(25, 50, 25, 10));
		pnThongTin.setPreferredSize(new Dimension(650, 50));
		JLabel lblThongTinBenhNhan;
		pnThongTin.add(lblThongTinBenhNhan = new JLabel("Thông Tin Bệnh Nhân"));
		lblThongTinBenhNhan.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblThongTinBenhNhan.setForeground(Color.DARK_GRAY);
		pnEast2North.add(pnThongTin);

		// Gridlayout
		JPanel pnGridLayout = new JPanel(new GridLayout(4, 2));
		pnGridLayout.setPreferredSize(new Dimension(650, 400));
		pnGridLayout.setBorder(new EmptyBorder(0, 50, 10, 10));
		pnGridLayout.setAlignmentX(CENTER_ALIGNMENT);

		JLabel lblMaBenhNhan;
		pnGridLayout.add(lblMaBenhNhan = new JLabel("Mã Bệnh Nhân:"));
		pnGridLayout.add(lblTextMaBenhNhan = new JLabel("123"));

		JLabel lblTenBenhNhan;
		pnGridLayout.add(lblTenBenhNhan = new JLabel("Tên Bệnh Nhân:"));
		pnGridLayout.add(lblTextTenBenhNhan = new JLabel("Nguyen văn A"));

		JLabel lblPhong;
		pnGridLayout.add(lblPhong = new JLabel("Phòng: "));
		pnGridLayout.add(lblTextPhong = new JLabel("Phong 1"));

		JLabel lblMaPhong;
		pnGridLayout.add(lblMaPhong = new JLabel("Mã phòng "));
		pnGridLayout.add(lblTextMaPhong = new JLabel("XYZ1"));

		lblMaBenhNhan.setPreferredSize(lblTenBenhNhan.getPreferredSize());
		lblPhong.setPreferredSize(lblTenBenhNhan.getPreferredSize());
		lblMaPhong.setPreferredSize(lblTenBenhNhan.getPreferredSize());

		lblTextMaBenhNhan.setPreferredSize(lblTextTenBenhNhan.getPreferredSize());
		lblTextPhong.setPreferredSize(lblTextTenBenhNhan.getPreferredSize());
		lblTextMaPhong.setPreferredSize(lblTextTenBenhNhan.getPreferredSize());

		pnEast2North.add(pnGridLayout);

		pnEast2.add(pnEast2North, BorderLayout.NORTH);

		// South-East2
		JPanel pnEast2South = new JPanel();
		pnEast2South.setPreferredSize(new Dimension(670, 40));
		pnEast2South.add(buttonNhanBenhNhan = new JButton("Nhận Bệnh Nhân"));

		pnEast2.add(pnEast2South, BorderLayout.SOUTH);

		pnEastMain2.add(pnEast2);

		// Defaut main 1
		pnEast.removeAll();
		pnEast.setLayout(new BorderLayout(0, 0));
		pnEast.add(pnEastMain1);
		pnEast.validate();
		pnEast.repaint();

		contentPane.add(pnEast, BorderLayout.EAST);

		// Defaut
		resetTab1();
		resetTab2();
		// event tab
		tabbedPane.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 0) {
					pnEast.removeAll();
					pnEast.setLayout(new BorderLayout(0, 0));
					pnEast.add(pnEastMain1);
					pnEast.validate();
					pnEast.repaint();
					resetTab1();
					resetTab2();
				} else {
					pnEast.removeAll();
					pnEast.setLayout(new BorderLayout(0, 0));
					pnEast.add(pnEastMain2);
					pnEast.validate();
					pnEast.repaint();
					resetTab2();
					resetTab2();
				}
			}
		});

		// event button
		buttonXemThongTin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tabbedPane.getSelectedIndex() == 0) {
					// tab Danh sach phong
				} else {
					// tab Danh sach Benh Nhan
				}

			}
		});

		buttonNhanBenhNhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int optionPane = JOptionPane.showConfirmDialog(null, "Xác nhận đã nhận bệnh nhân!", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (optionPane == 0) {
					System.out.println("select: " + optionPane);
					// update data
				}
			}
		});

		buttonXuatGiuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int optionPane = JOptionPane.showConfirmDialog(null, "Bệnh nhân xuất giường!", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (optionPane == 0) {
					System.out.println("select: " + optionPane);
					// update data
				}
			}
		});

		buttonDoiGiuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String maGiuong = JOptionPane.showInputDialog("Mã giường cần đổi?");
				System.out.println(maGiuong);
				// lấy thông tin giường và đổi giường

			}
		});
	}

	protected void resetTab1() {
		table.clearSelection();
		buttonDoiGiuong.setEnabled(false);
		buttonXuatGiuong.setEnabled(false);
	}

	protected void resetTab2() {
		lblTextMaBenhNhan.setText("");
		lblTextTenBenhNhan.setText("");
		lblTextMaPhong.setText("");
		lblTextPhong.setText("");
		buttonNhanBenhNhan.setEnabled(false);
	}

}
