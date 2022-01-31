package com.revature.reimbursements.models;

import java.time.Instant;

import com.revature.reimbursements.enums.Reimbursement;
import com.revature.reimbursements.enums.Status;

public class RefundTicket {

	private int ticketId;
	private int refundAmount;
	private Reimbursement refundType;
	private Status refundStatus;
	private Instant timeStamp;
	private int employeeId;
	
	
	public RefundTicket() {
		
	}
	
	public RefundTicket(int refundAmount,Reimbursement refundType,Status refundStatus,int ticketId,int employeeId) {
		this.refundAmount=refundAmount;
		this.refundType=refundType;
		this.refundStatus=refundStatus;
		this.ticketId=ticketId;
		this.employeeId =employeeId;
	}
	
	public RefundTicket(int refundAmount,Reimbursement refundType) {
		
		this.refundAmount=refundAmount;
		this.refundType= refundType;
		this.timeStamp=Instant.now();
		this.refundStatus=Status.PENDING;
		
	}
	

	
	public RefundTicket(int refundAmount,Reimbursement refundType,int ticketID) {
		this(refundAmount,refundType);
		this.ticketId=ticketID;
	}
	
	public RefundTicket(int refundAmount,Reimbursement refundType,int ticketId,int employeeId) {
		this(refundAmount,refundType,ticketId);
		this.employeeId=employeeId;
	}
	
	



	public int getRefundAmount() {
		return refundAmount;
	}
	
	

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Reimbursement getRefundType() {
		return refundType;
	}

	public void setRefundType(Reimbursement refundType) {
		this.refundType = refundType;
	}

	public Status getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(Status refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "RefundTicket [ticketId=" + getTicketId() + ", refundAmount=" + refundAmount + ", refundType=" + refundType
				+ ", refundStatus=" + refundStatus + ", timeStamp=" + timeStamp + ", employeeId=" + employeeId + "]";
	}

	

}
