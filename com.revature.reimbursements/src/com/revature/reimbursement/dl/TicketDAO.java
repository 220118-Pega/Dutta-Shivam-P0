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

import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.enums.Status;
import com.revature.reimbursements.models.RefundTicket;

public class TicketDAO implements DAO<RefundTicket,Integer> {
	private final Logger logger = (Logger) LogManager.getLogger(this.getClass());
	
	
	@Override
	public RefundTicket findById(Integer id) {
		// try with resources block, after the try block finishes executing, 
		//	disposes of the resources for you
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			// ? is a placeholder for parameter we'll be sending our DB						
			String query = "select * from tickets where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			// executeQuery - used for executing select commands
			//	result set 	- holds the result from DB
			ResultSet rs = pstmt.executeQuery();
			// we need to unpack result set to return something to end user
			if(rs.next())
			{
//				Map all other prop of tickets from table to objects
				// Created an object for my refundTicket class to map the props.				
				RefundTicket myTicket = new RefundTicket();
				
				// Mapping my Id from db to class object				
				int myId= rs.getInt("id");
				myTicket.setTicketId(myId);
				
				// Mapping my status from db to class object				
				String refStat = rs.getString("refund_status");
				Status myRefStat = Status.valueOf(refStat);
				myTicket.setRefundStatus(myRefStat);
				
				// Mapping m=				
				String refType = rs.getString("refund_type");
				Reimbursement myRefType = Reimbursement.valueOf(refType);
				int refAmount = rs.getInt("refund_amount");
				return new RefundTicket(refAmount,myRefType,myId);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Error with connecting to db");
		}
		return null;
	}

	@Override
	public List<RefundTicket> findAll() {
		// TODO Auto-generated method stub
		ArrayList<RefundTicket> refundTickets = new ArrayList<RefundTicket>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from tickets";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				
				RefundTicket myTicket = new RefundTicket();
				
				// Mapping my Id from db to class object				
				int myId= rs.getInt("id");
				myTicket.setTicketId(myId);
				System.out.println(myTicket);
				// Mapping my status from db to class object				
				String refStat = rs.getString("refund_status");
				Status myRefStat = Status.valueOf(refStat);
				myTicket.setRefundStatus(myRefStat);
				
				String refType = rs.getString("refund_type");
				Reimbursement myRefType = Reimbursement.valueOf(refType);
				int refAmount = rs.getInt("refund_amount");
				int empId = rs.getInt("employee_id");
				refundTickets.add(new RefundTicket(refAmount,myRefType,myId,empId));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Something went wrong",e);
		}
		return refundTickets;
	}

	@Override
	public void add(RefundTicket newObject) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "insert into tickets "
						+ 	"(refund_amount,refund_type,refund_status,employee_id) "
						+ 	"values(?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newObject.getRefundAmount());
			pstmt.setString(2, newObject.getRefundType().toString());
			pstmt.setString(3, newObject.getRefundStatus().toString());
			pstmt.setInt(4, newObject.getEmployeeId());
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Something went wrong",e);
		}
	}

	@Override
	public void update(RefundTicket newObject) {
		// TODO Auto-generated method stub
		
	}

}
