package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.BasicConfigurator;

import convert.XMLConvert;
import entities.Bed;
import entities.BedPatientDetails;
import entities.Patient;
import entities.Room;

public class GUIAddPatient extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlNorth;
	private JLabel lbTieuDe;
	private JPanel pnlCenter;
	private JLabel lbPatientID;
	private JLabel lbPatientName;
	private JLabel lbDayOfBirth;
	private JLabel lbIdentityNumber;
	private JLabel lbBedName;
	private JLabel lbRoomName;
	private JTextField txtPatientID;
	private JTextField txtPatientName;
	private JTextField txtDayOfBirth;
	private JTextField txtIdentityNumber;
	private JTextField txtBedName;
	private JTextField txtRoomName;
	private JPanel pnlSouth;
	private JButton btnSend;
	private JLabel lbDeparment;
	private JTextField txtDepartment;
	private JLabel lbErrorPatientID;
	private JLabel lbErrorPatientName;
	private JLabel lbErrorDayOfBirth;
	private JLabel lbErrorIdentityNumber;
	private String bedID;
	private String roomID;
	private Object pending = "Empty";
	private int row;
	
	public GUIAddPatient() {
		
	}

	public GUIAddPatient(String bedName, String roomName, String departmentName, String bedid, String roomid, int dong){
		setTitle("Add Patient");
		setSize(800,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createGUI();
		
		txtBedName.setText(bedName);
		txtRoomName.setText(roomName);
		txtDepartment.setText(departmentName);
		bedID = bedid;
		roomID = roomid;
		row = dong;
		System.out.println("Room ID: " + roomID);
	}

	private void createGUI() {
		setLayout(new BorderLayout());
		// -------- North -----------
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 60));
		pnlNorth.setBackground(Color.cyan);

		pnlNorth.add(lbTieuDe = new JLabel("ADD INFORMATION PATIENT"));
		lbTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 26));

		// ----------- Center -----------
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.setLayout(null);

		pnlCenter.add(lbPatientID = new JLabel("Patient ID: "));
		pnlCenter.add(lbPatientName = new JLabel("Patient Name: "));
		pnlCenter.add(lbDayOfBirth = new JLabel("Day Of Birth: "));
		pnlCenter.add(lbIdentityNumber = new JLabel("Identity Number: "));
		pnlCenter.add(lbBedName = new JLabel("Bed Name: "));
		pnlCenter.add(lbRoomName = new JLabel("Room Name: "));
		pnlCenter.add(lbDeparment = new JLabel("Department Name: "));

		lbPatientID.setBounds(100,40,100,40);
		lbPatientName.setBounds(100,100,100,30);
		lbDayOfBirth.setBounds(100,160,100,30);
		lbIdentityNumber.setBounds(100,220,100,30);
		lbDeparment.setBounds(100, 280, 120, 30);
		lbBedName.setBounds(100, 340, 100, 30);
		lbRoomName.setBounds(100, 400, 100, 30);

		pnlCenter.add(txtPatientID = new JTextField());
		pnlCenter.add(lbErrorPatientID = new JLabel("PatientID does not exist"));
		pnlCenter.add(txtPatientName = new JTextField());
		pnlCenter.add(lbErrorPatientName = new JLabel("PatientName does not exist"));
		pnlCenter.add(txtDayOfBirth = new JTextField());
		pnlCenter.add(lbErrorDayOfBirth = new JLabel("DayOfBirth does not exist"));
		pnlCenter.add(txtIdentityNumber = new JTextField());
		pnlCenter.add(lbErrorIdentityNumber = new JLabel("IdentityNumber does not exist"));
		pnlCenter.add(txtBedName = new JTextField());
		pnlCenter.add(txtRoomName = new JTextField());
		pnlCenter.add(txtDepartment = new JTextField());

		txtPatientID.setBounds(220, 40, 420, 30);
		lbErrorPatientID.setBounds(220, 70, 420, 20);
		lbErrorPatientID.setForeground(Color.RED);
		txtPatientName.setBounds(220, 100, 420, 30);
		lbErrorPatientName.setBounds(220, 130, 420, 20);
		lbErrorPatientName.setForeground(Color.RED);
		txtDayOfBirth.setBounds(220, 160, 420, 30);
		lbErrorDayOfBirth.setBounds(220, 190, 420, 20);
		lbErrorDayOfBirth.setForeground(Color.RED);
		txtIdentityNumber.setBounds(220, 220, 420, 30);
		lbErrorIdentityNumber.setBounds(220, 250, 420, 20);
		lbErrorIdentityNumber.setForeground(Color.RED);
		txtDepartment.setBounds(220, 280, 420, 30);
		txtBedName.setBounds(220, 340, 420, 30);
		txtRoomName.setBounds(220, 400, 420, 30);
		
		// ----------- South -----------
		add(pnlSouth = new JPanel(), BorderLayout.SOUTH);
		pnlSouth.setPreferredSize(new Dimension(0, 60));
		pnlSouth.add(btnSend = new JButton("Send"));

		btnSend.addActionListener(this);
		txtBedName.setEnabled(false);
		txtRoomName.setEnabled(false);
		txtDepartment.setEnabled(false);
		setVisibleFalse();
	}

	private void setVisibleFalse() {
		lbErrorPatientID.setVisible(false);
		lbErrorPatientName.setVisible(false);
		lbErrorDayOfBirth.setVisible(false);
		lbErrorIdentityNumber.setVisible(false);
	}

//	public static void main(String[] args) {
//		new GUIAddPatient("a","b","c").setVisible(true);
//	}

	@Override
	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if(o.equals(btnSend)){
			setVisibleFalse();
			if(checkout()){
				JOptionPane.showMessageDialog(null, "The PatientID you entered already exists. Please try again.", "Notification", JOptionPane.INFORMATION_MESSAGE);
			} else if(checkPatient()){
				send();
			} else{
				JOptionPane.showMessageDialog(null, "Send Failed", "Notification", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	// Check bệnh nhân đã nhận giường bệnh chưa? 
	private boolean checkout() {
		String patientID = txtPatientID.getText();
		BedPatientDetails b = new BedPatientDetails();
		for(BedPatientDetails b1 : b.getListBedPatientDetails()){
			if(b1.getPatientID().equals(patientID)){
				if(b1.getCheckout().equals("")){
					return true;
				} 
			}
		}
		return false;
	}

	// Check information patient
	private boolean checkPatient() {
		Patient p = new Patient();
		for(Patient p1 : p.getListPatient()){
			if(p1.getPatientID().equals(txtPatientID.getText())){
				System.out.println(p1.getPatientID() + " " + p1.getPatientName() + " " + p1.getDayOfBirth() + " " + p1.getIdentifyNumber());
				lbErrorPatientID.setVisible(false);
				if(p1.getPatientName().equals(txtPatientName.getText())){
					lbErrorPatientName.setVisible(false);
					if(p1.getDayOfBirth().equals(txtDayOfBirth.getText())){
						lbErrorDayOfBirth.setVisible(false);
						if(p1.getIdentifyNumber().equals(txtIdentityNumber.getText())){
							lbErrorIdentityNumber.setVisible(false);
							return true;
						} else{
							lbErrorIdentityNumber.setVisible(true);
							return false;
						}
					} else{
						lbErrorDayOfBirth.setVisible(true);
						return false;
					}
				}else{
					lbErrorPatientName.setVisible(true);
					return false;
				}
			} 
		}
		lbErrorPatientID.setVisible(true);
		return false;
	}

	private void send() {
		String patientID = txtPatientID.getText();
		String patientName = txtPatientName.getText();
		String dayOfBirth = txtDayOfBirth.getText();
		String identityNumber = txtIdentityNumber.getText();
		String departmentName = txtDepartment.getText();
		String bedName = txtBedName.getText();
		String roomName = txtRoomName.getText();
		BasicConfigurator.configure();
		Properties settings = new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		try {
			Context ctx = new InitialContext(settings);
			Object obj = ctx.lookup("ConnectionFactory");
			ConnectionFactory factory = (ConnectionFactory) obj;
			Destination destination = (Destination) ctx.lookup("dynamicQueues/patient");
			Connection con = factory.createConnection("admin", "admin");
			con.start();
			Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(destination);
			
			Patient p = new Patient(patientID, patientName, dayOfBirth, identityNumber, departmentName, bedName, roomName);
			String xml = new XMLConvert<Patient>(p).ObjectToXML(p);
			System.out.println(xml);
			Message msg = session.createTextMessage(xml);
			producer.send(msg);
			
			//shutdown connection
			session.close();
			con.close();
			System.out.println("Finished...");
			btnSend.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Information Patient sent successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
			setStatusIsPending();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// set Status from Empty to Pending
	private void setStatusIsPending() {
		// getlistbed from room with roomid = ?, after that set status is pending
		Room r = new Room();
		for(Bed b : r.getListBed(roomID)){
			if(b.getBedID().equals(bedID) && b.getStatus().equals("Empty")){
				r.updateStatus(bedID);
				break;
			}
		}
		GUIDieuChuyenBenhNhan ui = new GUIDieuChuyenBenhNhan();
		ui.setStatus(roomID, row);
	}
}
