package com.TidyGames.pay.model.vo;

public class Refund {
	
	private int refundNo;
	private int memNo;
	private int orderNo;
	private String refund;
	private String addWriting;
	private String refundDate;
	private String refundStatus;
	private String memId;
	private int payAmount;
	private String payDate;
	
	
	public Refund() {}


	public Refund(int memNo, int orderNo, String refund, String addWriting) {
		super();
		this.memNo = memNo;
		this.orderNo = orderNo;
		this.refund = refund;
		this.addWriting = addWriting;
	}


	public Refund(int refundNo, int memNo, int orderNo, String refund, String addWriting, String refundDate) {
		super();
		this.refundNo = refundNo;
		this.memNo = memNo;
		this.orderNo = orderNo;
		this.refund = refund;
		this.addWriting = addWriting;
		this.refundDate = refundDate;
	}


	public Refund(int refundNo, int memNo, int orderNo, String refund, String addWriting, String refundDate,
			String refundStatus) {
		super();
		this.refundNo = refundNo;
		this.memNo = memNo;
		this.orderNo = orderNo;
		this.refund = refund;
		this.addWriting = addWriting;
		this.refundDate = refundDate;
		this.refundStatus = refundStatus;
	}


	public Refund(int refundNo, int orderNo, String refund, String addWriting, String refundDate, String refundStatus,
			String memId, int payAmount, String payDate) {
		super();
		this.refundNo = refundNo;
		this.orderNo = orderNo;
		this.refund = refund;
		this.addWriting = addWriting;
		this.refundDate = refundDate;
		this.refundStatus = refundStatus;
		this.memId = memId;
		this.payAmount = payAmount;
		this.payDate = payDate;
	}


	public Refund(String refund, String addWriting) {
		super();
		this.refund = refund;
		this.addWriting = addWriting;
	}


	public Refund(int refundNo, int memNo, int orderNo, String refund, String addWriting, String refundDate,
			String refundStatus, String memId, int payAmount, String payDate) {
		super();
		this.refundNo = refundNo;
		this.memNo = memNo;
		this.orderNo = orderNo;
		this.refund = refund;
		this.addWriting = addWriting;
		this.refundDate = refundDate;
		this.refundStatus = refundStatus;
		this.memId = memId;
		this.payAmount = payAmount;
		this.payDate = payDate;
	}


	public int getRefundNo() {
		return refundNo;
	}


	public void setRefundNo(int refundNo) {
		this.refundNo = refundNo;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public String getRefund() {
		return refund;
	}


	public void setRefund(String refund) {
		this.refund = refund;
	}


	public String getAddWriting() {
		return addWriting;
	}


	public void setAddWriting(String addWriting) {
		this.addWriting = addWriting;
	}


	public String getRefundDate() {
		return refundDate;
	}


	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}


	public String getRefundStatus() {
		return refundStatus;
	}


	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public int getPayAmount() {
		return payAmount;
	}


	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}


	public String getPayDate() {
		return payDate;
	}


	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}


	@Override
	public String toString() {
		return "Refund [refundNo=" + refundNo + ", memNo=" + memNo + ", orderNo=" + orderNo + ", refund=" + refund
				+ ", addWriting=" + addWriting + ", refundDate=" + refundDate + ", refundStatus=" + refundStatus
				+ ", memId=" + memId + ", payAmount=" + payAmount + ", payDate=" + payDate + "]";
	}

	
	
	
	
	
	
}