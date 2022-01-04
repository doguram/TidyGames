package com.TidyGames.pay.model.vo;

public class Pay {

	private int orderNo;
	private int memNo;
	private int payAmount;
	private String payStatus;
	private String payDate;
	private String payMethod;
	private String korName;
	private String engName;
	private String gameImg;
	private int pointAmount;
	private String memId;
	
	
	public void pay() {}
	

	public Pay(int orderNo, int memNo, int payAmount, String payStatus, String payDate, String memId) {
		super();
		this.orderNo = orderNo;
		this.memNo = memNo;
		this.payAmount = payAmount;
		this.payStatus = payStatus;
		this.payDate = payDate;
		this.memId = memId;
	}


	public Pay(int orderNo, int memNo, int payAmount, String payStatus, String payDate, String payMethod,
			int pointAmount) {
		super();
		this.orderNo = orderNo;
		this.memNo = memNo;
		this.payAmount = payAmount;
		this.payStatus = payStatus;
		this.payDate = payDate;
		this.payMethod = payMethod;
		this.pointAmount = pointAmount;
	}


	public Pay(int orderNo, int memNo, int payAmount, String payStatus, String payDate, String payMethod, String korName,
			String engName, String gameImg) {
		super();
		this.orderNo = orderNo;
		this.memNo = memNo;
		this.payAmount = payAmount;
		this.payStatus = payStatus;
		this.payDate = payDate;
		this.payMethod = payMethod;
		this.korName = korName;
		this.engName = engName;
		this.gameImg = gameImg;
	}


	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public int getPayAmount() {
		return payAmount;
	}


	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}


	public String getPayStatus() {
		return payStatus;
	}


	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}


	public String getPayDate() {
		return payDate;
	}


	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}


	public String getPayMethod() {
		return payMethod;
	}


	public void setPayMethod(String method) {
		this.payMethod = payMethod;
	}


	public String getKorName() {
		return korName;
	}


	public void setKorName(String korName) {
		this.korName = korName;
	}


	public String getEngName() {
		return engName;
	}


	public void setEngName(String engName) {
		this.engName = engName;
	}


	public String getGameImg() {
		return gameImg;
	}


	public void setGameImg(String gameImg) {
		this.gameImg = gameImg;
	}

	
	public int getPointAmount() {
		return pointAmount;
	}


	public void setPointAmount(int pointAmount) {
		this.pointAmount = pointAmount;
	}
	

	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	@Override
	public String toString() {
		return "PAY [orderNo=" + orderNo + ", memNo=" + memNo + ", payAmount=" + payAmount + ", payStatus=" + payStatus
				+ ", payDate=" + payDate + ", payMethod=" + payMethod+ ", korName=" + korName + ", engName=" + engName
				+ ", gameImg=" + gameImg + "]";
	}
	
	
	
}
