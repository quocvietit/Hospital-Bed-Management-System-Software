package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIAddPatient extends JFrame implements ActionListener{
	private JPanel pnlNorth;
	private JLabel lbTieuDe;
	private JPanel pnlCenter;
	private JLabel lbPatientID;
	private JLabel lbPatientName;
	private JLabel lbDayOfBirth;
	private JLabel lbIdentityNumber;
	private JLabel lbBedID;
	private JLabel lbRoomID;
	private JTextField txtPatientID;
	private JTextField txtPatientName;
	private JTextField txtDayOfBirth;
	private JTextField txtIdentityNumber;
	private JTextField txtBedID;
	private JTextField txtRoomID;
	private JPanel pnlSouth;
	private JButton buttonDieuChuyenBenhNhan;

	public GUIAddPatient(String bedID) {
		setTitle("Add Patient");
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createGUI();
		
		txtBedID.setText(bedID);
	}

	private void createGUI() {
		setLayout(new BorderLayout());
		// -------- North -----------
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 60));
		pnlNorth.setBackground(Color.cyan);

		pnlNorth.add(lbTieuDe = new JLabel("THÊM THÔNG TIN BỆNH NHÂN"));
		lbTieuDe.setFont(new Font("Arial", Font.BOLD, 26));

		// ----------- Center -----------
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.setLayout(null);

		pnlCenter.add(lbPatientID = new JLabel("Patient ID: "));
		pnlCenter.add(lbPatientName = new JLabel("Patient Name: "));
		pnlCenter.add(lbDayOfBirth = new JLabel("Day Of Birth: "));
		pnlCenter.add(lbIdentityNumber = new JLabel("Identity Number: "));
		pnlCenter.add(lbBedID = new JLabel("Bed ID: "));
		pnlCenter.add(lbRoomID = new JLabel("Room ID: "));

		lbPatientID.setBounds(100,40,100,40);
		lbPatientName.setBounds(100,110,100,30);
		lbDayOfBirth.setBounds(100,180,100,30);
		lbIdentityNumber.setBounds(100,250,100,30);
		lbBedID.setBounds(100, 320, 100, 30);
		lbRoomID.setBounds(100, 390, 100, 30);

		pnlCenter.add(txtPatientID = new JTextField());
		pnlCenter.add(txtPatientName = new JTextField());
		pnlCenter.add(txtDayOfBirth = new JTextField());
		pnlCenter.add(txtIdentityNumber = new JTextField());
		pnlCenter.add(txtBedID = new JTextField());
		pnlCenter.add(txtRoomID = new JTextField());

		txtPatientID.setBounds(220, 40, 420, 30);
		txtPatientName.setBounds(220, 110, 420, 30);
		txtDayOfBirth.setBounds(220, 180, 420, 30);
		txtIdentityNumber.setBounds(220, 250, 420, 30);
		txtBedID.setBounds(220, 320, 420, 30);
		txtRoomID.setBounds(220, 390, 420, 30);

		// ----------- South -----------
		add(pnlSouth = new JPanel(), BorderLayout.SOUTH);
		pnlSouth.setPreferredSize(new Dimension(0, 60));

		pnlSouth.add(buttonDieuChuyenBenhNhan = new JButton("Điều Chuyển Bệnh Nhân"));

		buttonDieuChuyenBenhNhan.addActionListener(this);
		txtBedID.setEnabled(false);
		txtRoomID.setEnabled(false);

		
	}

//	public static void main(String[] args) {
//		new GUIAddPatient().setVisible(true);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(buttonDieuChuyenBenhNhan)){
			
		}
		
	}
}
