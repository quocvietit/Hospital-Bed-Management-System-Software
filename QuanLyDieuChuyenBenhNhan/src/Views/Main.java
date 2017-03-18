package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

import Views.Main.TreeHandler;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTree tree;

	private Renderer renderer = new Renderer();

	private DefaultMutableTreeNode khoaPhucHoiChucNang;

	private DefaultMutableTreeNode khoaUngBuou;

	private DefaultMutableTreeNode khoaNoiSoi;

	private DefaultMutableTreeNode khoaSoSinh;

	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
		setSize(1020, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// North
		JPanel pnNorth = new JPanel();

		Font font = new Font("Times New Roman", Font.BOLD, 30);
		JLabel lblTitle = new JLabel("QUẢN LÝ ĐIỀU CHUYỂN BỆNH NHÂN"); // title
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.DARK_GRAY);

		pnNorth.add(lblTitle);
		contentPane.add(pnNorth, BorderLayout.NORTH);

		// Center
		JPanel pnCenter = new JPanel();
		// West
		JPanel pnCenterWest = new JPanel();
		pnCenterWest.setLayout(new BorderLayout());
		pnCenterWest.setPreferredSize(new Dimension(400, 580));
		
		Border linePnCenterWest = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titlePnCenterWest = new TitledBorder(linePnCenterWest,"Danh sách giường bệnh");
		pnCenterWest.setBorder(titlePnCenterWest);

		khoaPhucHoiChucNang = new DefaultMutableTreeNode(" - Khoa Phục Hồi Chức Năng");
		khoaUngBuou = new DefaultMutableTreeNode(" - Khoa Ung Bướu");
		khoaNoiSoi = new DefaultMutableTreeNode(" Khoa Nội Soi");
		khoaSoSinh = new DefaultMutableTreeNode(" Khoa So Sinh");

		khoaPhucHoiChucNang.add(new DefaultMutableTreeNode("Phòng 1"));

		tree = new JTree(khoaPhucHoiChucNang);
		tree.setCellRenderer(renderer);
		tree.addTreeSelectionListener(new TreeHandler());
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(tree);

		pnCenterWest.add(scrollPane, BorderLayout.CENTER);
		pnCenter.add(pnCenterWest, BorderLayout.WEST);
		contentPane.add(pnCenter, BorderLayout.CENTER);

	}

	public class TreeHandler implements TreeSelectionListener {

		private JLabel textField;

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			TreePath path = e.getPath();
			String text = path.getPathComponent(path.getPathCount() - 1).toString();
			if (path.getPathCount() > 3) {
				text += ": ";
				text += Integer.toString((int) (Math.random() * 50)) + " Wins ";
				text += Integer.toString((int) (Math.random() * 50)) + " Losses";
			}
			textField.setText(text);
		}

	}

}

class Renderer extends JLabel implements TreeCellRenderer {
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		setText(value.toString() + "                   ");
		return this;
	}
}
