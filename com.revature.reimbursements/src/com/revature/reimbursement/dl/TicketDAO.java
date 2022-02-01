package com.revature.reimbursement.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
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
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{					
			String query = "select * from tickets where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{			
//				RefundTicket myTicket = new RefundTicket();
				int myId= rs.getInt("id");	
//				myTicket.setTicketId(myId);				
				Status myRefStatus = Status.valueOf(rs.getString("refund_status"));
//				myTicket.setRefundStatus(myRefStat);
				Reimbursement myRefType = Reimbursement.valueOf(rs.getString("refund_type"));
				int refAmount = rs.getInt("refund_amount");
				int empId = rs.getInt("employee_id");
				Instant timeNow = (rs.getTimestamp("refund_time").toInstant());
				return new RefundTicket(refAmount,myRefType,myRefStatus,timeNow,myId,empId);
				
//				if(timeNow==null) {
//					logger.error("Timestamp not found");
//				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Error with connecting to db");
		}
		return null;
	}

	@Override
	public List<RefundTicket> findAll() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<RefundTicket> refundTickets = new ArrayList<RefundTicket>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from tickets";
	
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
//				RefundTicket myTicket = new RefundTicket();			
				int myId= rs.getInt("id");
				int refAmount = rs.getInt("refund_amount");
				Reimbursement myRefType = Reimbursement.valueOf(rs.getString("refund_type"));
				Status myRefStatus = Status.valueOf(rs.getString("refund_status"));
				int empId = rs.getInt("employee_id");
				Instant timeNow = rs.getTimestamp("refund_time").toInstant();
//				System.out.println(timeNow);
//				if(timeNow==null) {
//					logger.error("Timestamp not found");
//					throw new Exception("return is empty");
//				}
				refundTickets.add(new RefundTicket(refAmount,myRefType,myRefStatus,timeNow,myId,empId));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Something went wrong",e);
		} catch (NullPointerException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return refundTickets;
	}

	@Override
	public void add(RefundTicket newObject) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "insert into tickets "
						+ 	"(refund_amount,refund_type,refund_status,employee_id,refund_time) "
						+ 	"values(?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newObject.getRefundAmount());
			pstmt.setString(2, newObject.getRefundType().toString());
			pstmt.setString(3, newObject.getRefundStatus().toString());
			pstmt.setInt(4, newObject.getEmployeeId());
			pstmt.setTimestamp(5, Timestamp.from(newObject.getTimeStamp()));
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			logger.error("Something went wrong",e);
		}
	}

	@Override
	public void update(RefundTicket newObject) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "update tickets set refund_status=?, refund_time=? where id =?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newObject.getRefundStatus().toString());
			pstmt.setTimestamp(2, Timestamp.from(newObject.getTimeStamp()));
			pstmt.setInt(3, newObject.getTicketId());
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<RefundTicket> filterStatus(Status status) {
		// TODO Auto-generated method stub
		ArrayList<RefundTicket> tickets = new ArrayList<RefundTicket>();
		RefundTicket myTicket = new RefundTicket();
		try (Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "select * from tickets where refund_status = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status.toString());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int myId= rs.getInt("id");
				int refAmount = rs.getInt("refund_amount");
				Reimbursement myRefType = Reimbursement.valueOf(rs.getString("refund_type"));
				Status myRefStatus = Status.valueOf(rs.getString("refund_status"));
				int empId = rs.getInt("employee_id");
				Timestamp timeNow = (rs.getTimestamp("refund_time"));
				myTicket.setRefundStatus(myRefStatus);
				tickets.add(new RefundTicket(refAmount,myRefType));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return tickets;
	}

	@Override
	public List<RefundTicket> getTicketByEmployeeId(Integer employee_id) {
		// TODO Auto-generated method stub
		
		ArrayList<RefundTicket> tickets = new ArrayList<RefundTicket>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from tickets where employee_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, employee_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {		
				int myId= rs.getInt("id");
				int refAmount = rs.getInt("refund_amount");
				Reimbursement myRefType = Reimbursement.valueOf(rs.getString("refund_type"));
				Status myRefStatus = Status.valueOf(rs.getString("refund_status"));
				int empId = rs.getInt("employee_id");
				Instant timeNow = rs.getTimestamp("refund_time").toInstant();
				tickets.add(new RefundTicket(refAmount,myRefType,myRefStatus,timeNow,myId,empId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}
	}


