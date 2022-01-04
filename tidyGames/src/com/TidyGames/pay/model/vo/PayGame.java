package com.TidyGames.pay.model.vo;

public class PayGame {

	private int orderNo;
	private int gameNo;
	private int memNo;
	private int payAmount;
	private String payStatus;
	private String payDate;
	private String payMethod;
	private String korName;
	private String engName;
	private String gameImg;
	private int discountPrice;
	private int price;
	
	public void PayGame() {}

	public PayGame(int orderNo, int gameNo) {
		super();
		this.orderNo = orderNo;
		this.gameNo = gameNo;
	}
	
	
	



	public PayGame(int orderNo, int gameNo, int memNo, int payAmount, String payStatus, String payDate,
			String payMethod, String korName, String engName, String gameImg, int discountPrice, int price) {
		super();
		this.orderNo = orderNo;
		this.gameNo = gameNo;
		this.memNo = memNo;
		this.payAmount = payAmount;
		this.payStatus = payStatus;
		this.payDate = payDate;
		this.payMethod = payMethod;
		this.korName = korName;
		this.engName = engName;
		this.gameImg = gameImg;
		this.discountPrice = discountPrice;
		this.price = price;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
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

	public void setPayMethod(String payMethod) {
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

	
	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PayGame [orderNo=" + orderNo + ", gameNo=" + gameNo + ", memNo=" + memNo + ", payAmount=" + payAmount
				+ ", payStatus=" + payStatus + ", payDate=" + payDate + ", payMethod=" + payMethod + ", korName="
				+ korName + ", engName=" + engName + ", gameImg=" + gameImg + ", discountPrice=" + discountPrice
				+ ", price=" + price + "]";
	}
	
	
}
