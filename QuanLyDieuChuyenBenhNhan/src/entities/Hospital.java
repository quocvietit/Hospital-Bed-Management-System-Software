package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import database.DbUtils;

public class Hospital {
	private ArrayList<Department> listDepartment;

	public Hospital(){
		listDepartment = new ArrayList<Department>();
	}
	
	public ArrayList<Department> getListDepartment() {
		Connection connec = Database.getCon();
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		try{
			String select = "select * from Department";
			stmt = connec.prepareStatement(select);
			rs = stmt.executeQuery();
			while(rs.next()){
				listDepartment.add(new Department(rs.getString(1), rs.getString(2)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtils.close(rs, stmt);
		}
		return listDepartment;
	}
	
}
