package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection connec;

	public Database() {
		// TODO Auto-generated constructor stub
		String url = "jdbc:sqlserver://loaclhost;database=HospitalBedManagement";
		String user = "sa";
		String password = "abc@123";
		try {
			connec = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		if (connec == null)
			new Database();
		return connec;
	}
}
