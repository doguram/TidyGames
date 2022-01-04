package com.TidyGames.faq.model.vo;

public class Faq {
	
	private int faqNo;
	private String faqTitle;
	private String faqContent;
	private int categoryNo;
	private String faqDate;
	private String faqStatus;
	private String faqWriter;
	
	public Faq() {}

	public Faq(int faqNo, String faqTitle, String faqContent, int categoryNo, String faqDate, String faqStatus,
			String faqWriter) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.categoryNo = categoryNo;
		this.faqDate = faqDate;
		this.faqStatus = faqStatus;
		this.faqWriter = faqWriter;
	}

	public String getFaqWriter() {
		return faqWriter;
	}

	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getFaqDate() {
		return faqDate;
	}

	public void setFaqDate(String faqDate) {
		this.faqDate = faqDate;
	}

	public String getFaqStatus() {
		return faqStatus;
	}

	public void setFaqStatus(String faqStatus) {
		this.faqStatus = faqStatus;
	}

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", categoryNo="
				+ categoryNo + ", faqDate=" + faqDate + ", faqStatus=" + faqStatus + ", faqWriter=" + faqWriter + "]";
	}

	
}
