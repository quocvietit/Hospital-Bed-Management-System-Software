package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
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
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import org.apache.log4j.BasicConfigurator;

import convert.XMLConvert;
import entities.Bed;
import entities.BedPatientDetails;
import entities.Department;
import entities.Patient;
import entities.Room;
import helper.DataHelper;

public class GUIDepartment1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnPatientView;
	private JTabbedPane tabbedPane;
	private JComponent jcListRoom;
	private JComponent jcListPatient;
	private DefaultMutableTreeNode root;
	private JTree tree;
	private JList<String> jlistPatient;
	private JTable table;
	private JButton btnXuatGiuong;
	private JButton btnDoiGiuong;
	private JButton btnSave;
	private DefaultTreeModel treeModel;
	private ArrayList<Room> listRoom;
	private ArrayList<Bed> listBed;
	private TableModel tableModel;
	private DefaultListModel<String> listModel;
	private ArrayList<Patient> listPatient = new ArrayList<Patient>();
	private JLabel lbPatientID;
	private JTextField txtPatientID;
	private JTextField txtPatientName;
	private JLabel lbPatientName;
	private JLabel lbDayOfBirth;
	private JTextField txtDayOfBirth;
	private JLabel lbIdentityNumber;
	private JTextField txtIdentityNumber;
	private JLabel lbBedID;
	private JTextField txtBedID;
	private JLabel lbRoomID;
	private JTextField txtRoomID;
	private JLabel lbDeparment;
	private JTextField txtDepartment;
	private JButton btnSearch;
	private JTextField txtSearch;
	private PatientTableModel patientTableModel;

	/**
	 * Create the frame.
	 */
	public GUIDepartment1() throws Exception{
		setTitle("HOSPITAL BED MANAGEMENT");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// North
		JPanel pnlNorth = new JPanel();
		pnlNorth.setPreferredSize(new Dimension(1000, 120));
		JPanel pnlTitle = new JPanel();
		pnlTitle.setPreferredSize(new Dimension(1000, 50));
		Font font = new Font("Times New Roman", Font.BOLD, 35);
		JLabel lbTitle = new JLabel("BED MANAGEMENT");
		lbTitle.setFont(font);
		lbTitle.setForeground(Color.RED);
		pnlTitle.add(lbTitle);
		pnlNorth.add(pnlTitle);
		
		JPanel pnlSearch = new JPanel();
		pnlSearch.setPreferredSize(new Dimension(1000, 40));
		pnlSearch.add(btnSearch = new JButton("Search PatientID"));
		pnlSearch.add(txtSearch = new JTextField());
		pnlNorth.add(pnlSearch);
		// insert Search
		txtSearch.setPreferredSize(new Dimension(300, 30));
		contentPane.add(pnlNorth, BorderLayout.NORTH);

		// West
		JPanel pnWest = new JPanel(new BorderLayout());
		pnWest.setPreferredSize(new Dimension(300, 600));

		// North-West
		JPanel pnWestNorth = new JPanel(new BorderLayout());
		pnWestNorth.setPreferredSize(new Dimension(300, 490));

		// Data tree
		root = new DefaultMutableTreeNode("Department 1");
		treeModel = new DefaultTreeModel(root);
		treeModel.addTreeModelListener(new MyTreeModelListener());

		// Tree
		tree = new JTree(treeModel);
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);
		JScrollPane jsTree = new JScrollPane(tree);

		// List
		JScrollPane jsList = new JScrollPane(jlistPatient = new JList<String>());

		// Tabbed Panes
		jcListRoom = jsTree;
		jcListPatient = jsList;
		tabbedPane = new JTabbedPane();
		tabbedPane.add("List Room", jcListRoom);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabbedPane.add("Patient Waiting", jcListPatient);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);

		pnWestNorth.add(tabbedPane);
		pnWest.add(pnWestNorth, BorderLayout.NORTH);

		// South-West
		JPanel pnWestSouth = new JPanel();
		pnWestSouth.setPreferredSize(new Dimension(300, 40));
		pnWestSouth.add(btnPatientView = new JButton("Patient View"));
		btnPatientView.setPreferredSize(new Dimension(150, 30));
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
		pnEast1North.setPreferredSize(new Dimension(670, 490));

		// Table
		pnEast1North.add(new JScrollPane(table = new JTable()));
		pnEast1.add(pnEast1North, BorderLayout.NORTH);

		// South-East1
		JPanel pnEast1South = new JPanel();
		pnEast1South.setLayout(new BoxLayout(pnEast1South, BoxLayout.X_AXIS));
		pnEast1South.setPreferredSize(new Dimension(670, 40));

		JPanel pnXuatGiuong = new JPanel();
		pnXuatGiuong.add(btnXuatGiuong = new JButton("Xuất Giường"));
		pnEast1South.add(pnXuatGiuong);

		JPanel pnDoiGiuong = new JPanel();
		pnDoiGiuong.add(btnDoiGiuong = new JButton("Đổi Giường"));
		pnEast1South.add(pnDoiGiuong);

		pnEast1.add(pnEast1South, BorderLayout.SOUTH);
		pnEastMain1.add(pnEast1);

		// Tab ListPatient
		JPanel pnEastMain2 = new JPanel();
		pnEastMain2.setLayout(new BorderLayout());

		// East2
		JPanel pnEast2 = new JPanel(new BorderLayout());
		pnEast2.setPreferredSize(new Dimension(670, 600));

		// North-East2
		JPanel pnEast2North = new JPanel();
		pnEast2North.setLayout(new BoxLayout(pnEast2North, BoxLayout.Y_AXIS));
		pnEast2North.setPreferredSize(new Dimension(670, 490));
		pnEast2North.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		// Label information
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBorder(new EmptyBorder(25, 50, 25, 10));
		pnThongTin.setPreferredSize(new Dimension(650, 50));
		JLabel lblThongTinBenhNhan;
		pnThongTin.add(lblThongTinBenhNhan = new JLabel("PATIENT INFORMATION"));
		lblThongTinBenhNhan.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblThongTinBenhNhan.setForeground(Color.DARK_GRAY);
		pnEast2North.add(pnThongTin);

		// Gridlayout
		JPanel pnGridLayout = new JPanel(new GridLayout(7, 1, 20, 20));
		pnGridLayout.setPreferredSize(new Dimension(650, 400));
		pnGridLayout.setBorder(new EmptyBorder(10, 90, 30, 90));
		pnGridLayout.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel pnl1;
		pnGridLayout.add(pnl1 = new JPanel());
		pnl1.add(lbPatientID = new JLabel("PatientID: "));
		pnl1.add(txtPatientID = new JTextField());
		lbPatientID.setPreferredSize(new Dimension(120, 30));
		txtPatientID.setPreferredSize(new Dimension(350, 30));
		
		JPanel pnl2;
		pnGridLayout.add(pnl2 = new JPanel());
		pnl2.add(lbPatientName = new JLabel("Patient Name: "));
		pnl2.add(txtPatientName = new JTextField());
		lbPatientName.setPreferredSize(new Dimension(120, 30));
		txtPatientName.setPreferredSize(new Dimension(350, 30));
		
		JPanel pnl3;
		pnGridLayout.add(pnl3 = new JPanel());
		pnl3.add(lbDayOfBirth = new JLabel("Day Of Birth: "));
		pnl3.add(txtDayOfBirth = new JTextField());
		lbDayOfBirth.setPreferredSize(new Dimension(120, 30));
		txtDayOfBirth.setPreferredSize(new Dimension(350, 30));
		
		JPanel pnl4;
		pnGridLayout.add(pnl4 = new JPanel());
		pnl4.add(lbIdentityNumber = new JLabel("Identity Number: "));
		pnl4.add(txtIdentityNumber = new JTextField());
		lbIdentityNumber.setPreferredSize(new Dimension(120, 30));
		txtIdentityNumber.setPreferredSize(new Dimension(350, 30));
		
		JPanel pnl5;
		pnGridLayout.add(pnl5 = new JPanel());
		pnl5.add(lbDeparment = new JLabel("Deparment Name: "));
		pnl5.add(txtDepartment = new JTextField());
		lbDeparment.setPreferredSize(new Dimension(120, 30));
		txtDepartment.setPreferredSize(new Dimension(350, 30));
		
		JPanel pnl6;
		pnGridLayout.add(pnl6 = new JPanel());
		pnl6.add(lbBedID = new JLabel("BedID: "));
		pnl6.add(txtBedID = new JTextField());
		lbBedID.setPreferredSize(new Dimension(120, 30));
		txtBedID.setPreferredSize(new Dimension(350, 30));
		
		JPanel pnl7;
		pnGridLayout.add(pnl7 = new JPanel());
		pnl7.add(lbRoomID = new JLabel("RoomID: "));
		pnl7.add(txtRoomID = new JTextField());
		lbRoomID.setPreferredSize(new Dimension(120, 30));
		txtRoomID.setPreferredSize(new Dimension(350, 30));

		pnEast2North.add(pnGridLayout);
		pnEast2.add(pnEast2North, BorderLayout.NORTH);

		// South-East2
		JPanel pnEast2South = new JPanel();
		pnEast2South.setPreferredSize(new Dimension(670, 40));
		pnEast2South.add(btnSave = new JButton("Save"));

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

		updateTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				Object nodeInfo = node.getUserObject();
				
				if(nodeInfo instanceof Room){
					Room room = (Room) nodeInfo;
					listBed = room.getListBed(room.getRoomID());
					System.out.println(room.getRoomID());
					tableModel = new TableModel(listBed);
					table.setModel(tableModel);
				}
			}
		});
		
		// event button
		btnPatientView.addActionListener(this);
		btnSave.addActionListener(this);
		btnXuatGiuong.addActionListener(this);
		btnDoiGiuong.addActionListener(this);
		btnSearch.addActionListener(this);
		btnPatientView.setEnabled(false);
		
		listModel = new DefaultListModel<String>();
		jlistPatient.setModel(listModel);
		jlistPatient.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				btnPatientView.setEnabled(true);
			}
		});
		
		Receive();
	}

	private void Receive() throws Exception{
		BasicConfigurator.configure();
		Properties settings = new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		Context ctx = new InitialContext(settings);
		Object obj = ctx.lookup("ConnectionFactory");
		ConnectionFactory factory = (ConnectionFactory) obj;
		Destination destination = (Destination) ctx.lookup("dynamicQueues/patient");
		Connection con = factory.createConnection("admin", "admin");
		con.start();
		Session session = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);

		MessageConsumer consumer = session.createConsumer(destination);
		System.out.println("Listening...");
		
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message msg) {
				try {
					if (msg instanceof TextMessage) {
						TextMessage textMess = (TextMessage) msg;
						String text = textMess.getText();
						System.out.println("Received: " + text);
						textMess.acknowledge();
						
						try {
							String xml = text;
							Patient patient = new Patient();
							patient = new XMLConvert<Patient>(patient).XMLToObject(xml);
							System.out.println("Patient: " + patient.getPatientID());
							listPatient.add(patient);
							addItemToListModel(patient.getPatientID());
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Error convert XML");
						}
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	private void updateTree() {
		Department d = new Department();
		listRoom = d.getListRoom("D1");
		for(Room room : listRoom){
			DefaultMutableTreeNode child = new DefaultMutableTreeNode(room);
			treeModel.insertNodeInto(child,root, root.getChildCount());
			
		}
	}

	protected void resetTab1() {
		table.clearSelection();
		btnDoiGiuong.setEnabled(false);
		btnXuatGiuong.setEnabled(false);
	}

	protected void resetTab2() {
//		lblTextMaBenhNhan.setText("");
//		lblTextTenBenhNhan.setText("");
//		lblTextMaPhong.setText("");
//		lblTextPhong.setText("");
		btnSave.setEnabled(false);
	}
	
	public void addItemToListModel(String item){
		listModel.addElement(item);
	}
	
	public static void main(String[] args) throws Exception{
		new GUIDepartment1().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnPatientView)){
			if (tabbedPane.getSelectedIndex() == 0) {
				// tab Danh sach phong
			} else {
				// tab patient room
				int index = jlistPatient.getSelectedIndex();
				if(index != -1){
					Patient patient = listPatient.get(index);
					txtPatientID.setText(patient.getPatientID());
					txtPatientName.setText(patient.getPatientName());
					txtDayOfBirth.setText(patient.getDayOfBirth());
					txtIdentityNumber.setText(patient.getIdentifyNumber());
					txtDepartment.setText(patient.getDepartmentName());
					txtBedID.setText(patient.getBedID());
					txtRoomID.setText(patient.getRoomID());
				}
				btnPatientView.setText("Called the patient " + txtPatientName.getText());
				btnSearch.setEnabled(false);
				btnSave.setEnabled(true);
				close();
			}
		} else if(o.equals(btnSave)){
			int optionPane = JOptionPane.showConfirmDialog(null, "Are you sure!", "Confirm", JOptionPane.YES_NO_OPTION);
			if (optionPane == 0) {
				int index = -1;
				for(int i = 0; i < listModel.size(); i++){
					if(listModel.get(i).equals(txtPatientID.getText())){
						index = i;
						break;
					}
				}
				
				if(index != -1){
					listModel.remove(index);
					listPatient.remove(index);
					String patientID = txtPatientID.getText();
					String bedName = txtBedID.getText();
					String bedID = convertBedID(bedName);
					LocalDateTime checkin = LocalDateTime.now();
					BedPatientDetails bedPatient = new BedPatientDetails(bedID, patientID, checkin, "");
					boolean insert = DataHelper.insertData(bedPatient);
					if(insert){
						clearText();
						btnPatientView.setText("Patient View");
						btnPatientView.setEnabled(true);
						btnSave.setEnabled(false);
						btnSearch.setEnabled(true);
						Room r = new Room();
						r.updateStatus(bedID);
						JOptionPane.showMessageDialog(null, "Save successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						System.out.println("Update fail");
				}
			}
		} else if(o.equals(btnXuatGiuong)){
			int optionPane = JOptionPane.showConfirmDialog(null, "Bệnh nhân xuất giường!", "Confirm",
					JOptionPane.YES_NO_OPTION);
			if (optionPane == 0) {
				System.out.println("select: " + optionPane);
				// update data
			}
		} else if(o.equals(btnDoiGiuong)){
			String maGiuong = JOptionPane.showInputDialog("Mã giường cần đổi?");
			System.out.println(maGiuong);
			// lấy thông tin giường và đổi giường
		} else if(o.equals(btnSearch)){
			if(!findPatient()){
				BedPatientDetails bedPatient = new BedPatientDetails("", "", "", "");
				patientTableModel = new PatientTableModel(bedPatient);
				table.setModel(patientTableModel);
				JOptionPane.showMessageDialog(null, "The PatientID does not exist", "Notification", JOptionPane.INFORMATION_MESSAGE);
			}
		} 
	}

	// convert bedName to bedID
	private String convertBedID(String bedName) {
		Room r = new Room();
		for(Bed b : r.getListBed1()){
			if(b.getBedName().equals(bedName)){
				return b.getBedID();
			}
		}
		return "Not found";
	}

	// Find Patient
	private boolean findPatient() {
		String patientID = txtSearch.getText();
		BedPatientDetails b = new BedPatientDetails();
		for(BedPatientDetails b1 : b.getListBedPatientDetails()){
			System.out.println(b1.getBedID() + " " + b1.getPatientID() + " " + b1.getGetCheckin());
			if(b1.getPatientID().equals(patientID) && b1.getCheckout().equals("")){
				if(checkBedID(b1.getBedID())){
					String bedID = b1.getBedID();
					String checkin = b1.getGetCheckin();
					String checkout = b1.getCheckout();
					BedPatientDetails bedPatient = new BedPatientDetails(bedID, patientID, checkin, checkout);
					patientTableModel = new PatientTableModel(bedPatient);
					table.setModel(patientTableModel);
					return true;
				} else
					return false;
			}
		}
		return false;
	}

	// check bedID is instanceof Department1 or not
	private boolean checkBedID(String bedID) {
		Department d = new Department();
		for(Room r : d.getListRoom("D1")){
			Room r1 = new Room();
			for(Bed b : r1.getListBed(r.getRoomID())){
				if(b.getBedID().equals(bedID)){
					return true;
				}
			}
		}
		return false;
	}

	private void clearText() {
		txtBedID.setText("");
		txtDayOfBirth.setText("");
		txtDepartment.setText("");
		txtIdentityNumber.setText("");
		txtPatientID.setText("");
		txtPatientName.setText("");
		txtRoomID.setText("");
	}

	private void close() {
		txtPatientID.setEnabled(false);
		txtPatientName.setEnabled(false);
		txtDayOfBirth.setEnabled(false);
		txtIdentityNumber.setEnabled(false);
		txtDepartment.setEnabled(false);
		txtBedID.setEnabled(false);
		txtRoomID.setEnabled(false);
		btnSave.setEnabled(true);
		btnPatientView.setEnabled(false);
	}
	
}
