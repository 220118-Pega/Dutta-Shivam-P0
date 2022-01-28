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
	
	public RefundTicket() {
		
	}
	
	public RefundTicket(int refundAmount,Reimbursement refundType) {
		
		this.refundAmount=refundAmount;
		this.refundType= refundType;
		this.refundStatus=Status.PENDING;
		this.timeStamp=Instant.now();
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
	
	

}
