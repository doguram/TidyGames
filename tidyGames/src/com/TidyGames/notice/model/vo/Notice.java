package com.TidyGames.notice.model.vo;

public class Notice {
	
	private int notiNo;
	private String notiTitle;
	private String notiContent;
	private String notiDate;
	private String notiStatus;
	private String notiWriter;

	public Notice() {}

	public Notice(int notiNo, String notiTitle, String notiContent, String notiDate, String notiStatus,
			String notiWriter) {
		super();
		this.notiNo = notiNo;
		this.notiTitle = notiTitle;
		this.notiContent = notiContent;
		this.notiDate = notiDate;
		this.notiStatus = notiStatus;
		this.notiWriter = notiWriter;
	}	

	// selectNoticeList + selectNotice용
	public Notice(int notiNo, String notiTitle, String notiContent, String notiDate, String notiWriter) {
		super();
		this.notiNo = notiNo;
		this.notiTitle = notiTitle;
		this.notiContent = notiContent;
		this.notiDate = notiDate;
		this.notiWriter = notiWriter;
	}

	public String getNotiWriter() {
		return notiWriter;
	}

	public void setNotiWriter(String notiWriter) {
		this.notiWriter = notiWriter;
	}

	public int getNotiNo() {
		return notiNo;
	}

	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
	}

	public String getNotiTitle() {
		return notiTitle;
	}

	public void setNotiTitle(String notiTitle) {
		this.notiTitle = notiTitle;
	}

	public String getNotiContent() {
		return notiContent;
	}

	public void setNotiContent(String notiContent) {
		this.notiContent = notiContent;
	}

	public String getNotiDate() {
		return notiDate;
	}

	public void setNotiDate(String notiDate) {
		this.notiDate = notiDate;
	}

	public String getNotiStatus() {
		return notiStatus;
	}

	public void setNotiStatus(String notiStatus) {
		this.notiStatus = notiStatus;
	}

	@Override
	public String toString() {
		return "Notice [notiNo=" + notiNo + ", notiTitle=" + notiTitle + ", notiContent=" + notiContent + ", notiDate="
				+ notiDate + ", notiStatus=" + notiStatus + ", notiWriter=" + notiWriter + "]";
	}
	
}
