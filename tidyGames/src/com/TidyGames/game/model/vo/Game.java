package com.TidyGames.game.model.vo;

public class Game {

	private int gameNo;
	private int companyNo;
	private String korName;
	private String engName;
	private String releaseDate;
	private int price;
	private String gameIntro;
	private String confirm;
	private String upgame;
	private String uploadDate; 
	private double point;
	private String gameStatus;
	private String gameImg;
	private int count;
	
	
	public Game() {}
	
	


	public Game(int gameNo, int companyNo, String korName, String engName, String releaseDate, int price,
			String gameIntro, String confirm, String upgame, String uploadDate, double point, String gameStatus,
			String gameImg, int count) {
		super();
		this.gameNo = gameNo;
		this.companyNo = companyNo;
		this.korName = korName;
		this.engName = engName;
		this.releaseDate = releaseDate;
		this.price = price;
		this.gameIntro = gameIntro;
		this.confirm = confirm;
		this.upgame = upgame;
		this.uploadDate = uploadDate;
		this.point = point;
		this.gameStatus = gameStatus;
		this.gameImg = gameImg;
		this.count = count;
	}



	public Game(int gameNo, int companyNo, String korName, String engName, String releaseDate, int price,
			String gameIntro, String confirm, String upgame, String uploadDate, double point, String gameStatus,
			String gameImg) {
		super();
		this.gameNo = gameNo;
		this.companyNo = companyNo;
		this.korName = korName;
		this.engName = engName;
		this.releaseDate = releaseDate;
		this.price = price;
		this.gameIntro = gameIntro;
		this.confirm = confirm;
		this.upgame = upgame;
		this.uploadDate = uploadDate;
		this.point = point;
		this.gameStatus = gameStatus;
		this.gameImg = gameImg;
	}

	public Game(int gameNo, String korName, String engName, int price, String confirm, String upgame,
			String uploadDate) {
		super();
		this.gameNo = gameNo;
		this.korName = korName;
		this.engName = engName;
		this.price = price;
		this.confirm = confirm;
		this.upgame = upgame;
		this.uploadDate = uploadDate;
	}

	public Game(int gameNo, int companyNo, String korName, String engName, String releaseDate, int price,
			String gameIntro, String confirm, String upgame, String uploadDate, double point, String gameStatus,
			int count) {
		super();
		this.gameNo = gameNo;
		this.companyNo = companyNo;
		this.korName = korName;
		this.engName = engName;
		this.releaseDate = releaseDate;
		this.price = price;
		this.gameIntro = gameIntro;
		this.confirm = confirm;
		this.upgame = upgame;
		this.uploadDate = uploadDate;
		this.point = point;
		this.gameStatus = gameStatus;
		this.count = count;
	}




	public Game(String korName, String engName, int price, String confirm, String upgame, String uploadDate) {
		super();
		this.korName = korName;
		this.engName = engName;
		this.price = price;
		this.confirm = confirm;
		this.upgame = upgame;
		this.uploadDate = uploadDate;
	}

	public Game(int companyNo, String korName, String engName, String releaseDate, int price, String gameIntro,
			String confirm, String upgame, String uploadDate, double point, String gameStatus, String gameImg) {
		super();
		this.companyNo = companyNo;
		this.korName = korName;
		this.engName = engName;
		this.releaseDate = releaseDate;
		this.price = price;
		this.gameIntro = gameIntro;
		this.confirm = confirm;
		this.upgame = upgame;
		this.uploadDate = uploadDate;
		this.point = point;
		this.gameStatus = gameStatus;
		this.gameImg = gameImg;
	}

	public Game(int gameNo, int companyNo, String korName, String engName, String releaseDate, int price, double point,
			String gameStatus, String gameImg, int count) {
		super();
		this.gameNo = gameNo;
		this.companyNo = companyNo;
		this.korName = korName;
		this.engName = engName;
		this.releaseDate = releaseDate;
		this.price = price;
		this.point = point;
		this.gameStatus = gameStatus;
		this.gameImg = gameImg;
		this.count = count;
	}
	
	public Game(int gameNo, String korName, String engName, String uploadDate, String confirm, String gameStatus) {
		super();
		this.gameNo = gameNo;
		this.korName = korName;
		this.engName = engName;
		this.uploadDate = uploadDate;
		this.confirm = confirm;
		this.gameStatus = gameStatus;
	}

	
	
	public Game(int gameNo, String korName, String engName, int price, String confirm, String upgame, String uploadDate,
			double point, String gameImg) {
		super();
		this.gameNo = gameNo;
		this.korName = korName;
		this.engName = engName;
		this.price = price;
		this.confirm = confirm;
		this.upgame = upgame;
		this.uploadDate = uploadDate;
		this.point = point;
		this.gameImg = gameImg;
	}




	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGameIntro() {
		return gameIntro;
	}

	public void setGameIntro(String gameIntro) {
		this.gameIntro = gameIntro;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getUpgame() {
		return upgame;
	}

	public void setUpgame(String upgame) {
		this.upgame = upgame;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	public String getGameImg() {
		return gameImg;
	}

	public void setGameImg(String gameImg) {
		this.gameImg = gameImg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Game [gameNo=" + gameNo + ", companyNo=" + companyNo + ", korName=" + korName + ", engName=" + engName
				+ ", releaseDate=" + releaseDate + ", price=" + price + ", gameIntro=" + gameIntro + ", confirm="
				+ confirm + ", upgame=" + upgame + ", uploadDate=" + uploadDate + ", point=" + point + ", gameStatus="
				+ gameStatus + ", gameImg=" + gameImg + "]";
	}
	
	

	

}
