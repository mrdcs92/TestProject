package practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.JdbcConnection;

public class SqlTest {

	public static void main(String[] args) {
		
		System.out.println("testing");
		System.out.println(getAllEmployees());
		getAllEmployees();
		
	}
	
	public static List<Employee> getAllEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			Connection conn = JdbcConnection.getConnection();
			
			String sql = "select eid, username, epassword, email from employee";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				employees.add(new Employee(rs.getInt("eid"), rs.getString("username"), rs.getString("epassword"), rs.getString("email")));
			}
			ps.close();
			return employees;
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return null;
	}
	
}
