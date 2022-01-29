package com.revature.reimbursement.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import com.revature.reimbursements.models.Employee;





public class EmployeeDAO implements DAO<Employee,Integer>{
	private final Logger logger = (Logger) LogManager.getLogger(this.getClass());

	@Override
	public Employee findById(Integer id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			// ? is a placeholder for parameter we'll be sending our DB						
			String query = "select * from employees where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			// executeQuery - used for executing select commands
			//	result set 	- holds the result from DB
			ResultSet rs = pstmt.executeQuery();
			// we need to unpack result set to return something to end user
			if(rs.next())
			{
//				Map all other prop of tickets from table to objects
				// Created an object for my Employee class to map the props.				
				Employee employeeObj = new Employee();
				
				// 1). Mapping my Id from db to class object				
				int myId= rs.getInt("id");
				employeeObj.setEmployeeId(myId);
				
				// 2). Mapping Employee name from db to class objects
				String employeeName=rs.getString("employee_name");
				
				// 3). Mapping	Employee locale-->
				String employeeLocale = rs.getString("employee_locale");
				
				// 4). Mapping employee phone number---->								
				int employeePhoneNumber = rs.getInt("employee_phone");
				return new Employee(employeeName,employeeLocale,employeePhoneNumber);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Error with connecting to db");
		}
		return null;
	}

	@Override
	public List<Employee> findAll() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from employees";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				
//				Map all other prop of tickets from table to objects
				// Created an object for my Employee class to map the props.				
				Employee employeeObj = new Employee();
				
				// 1). Mapping my Id from db to class object				
				int myId= rs.getInt("id");
				employeeObj.setEmployeeId(myId);
				
				// 2). Mapping Employee name from db to class objects
				String employeeName=rs.getString("employee_name");
				
				// 3). Mapping	Employee locale-->
				String employeeLocale = rs.getString("employee_locale");
				
				// 4). Mapping employee phone number---->								
				int employeePhoneNumber = rs.getInt("employee_phone");
				employees.add(new Employee(employeeName,employeeLocale,employeePhoneNumber));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Something went wrong",e);
		}
		return employees;
	}

	@Override
	public void add(Employee newObject) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "insert into employees"
						+ 	"(employee_name,employee_locale,employee_phone) "
						+ 	"values(?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newObject.getEmployeeName());
			pstmt.setString(2, newObject.getEmployeeLocale());
			pstmt.setInt(3, newObject.getPhoneNumber());
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Something went wrong",e);
		}
	}


	@Override
	public void update(Employee newObject) {
		// TODO Auto-generated method stub
		
	}

}
