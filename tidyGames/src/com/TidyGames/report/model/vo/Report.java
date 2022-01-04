package com.TidyGames.report.model.vo;

import java.sql.Date;

public class Report {
	
	private int reportNo;
	private int reportedNo;
	private String reported;
	private String reportedName;
	private String reporting;
	private int postNo;
	private String post;
	private String reply;
	private String reportSort;
	private String etc;
	private Date reportDate;
	private String done;
	
	public Report() {}

	public Report(int reportNo, int reportedNo, String reported, String reportedName, String reporting, String post,
			String reply, String reportSort, String etc, Date reportDate, String done) {
		super();
		this.reportNo = reportNo;
		this.reportedNo = reportedNo;
		this.reported = reported;
		this.reportedName = reportedName;
		this.reporting = reporting;
		this.post = post;
		this.reply = reply;
		this.reportSort = reportSort;
		this.etc = etc;
		this.reportDate = reportDate;
		this.done = done;
	}

	public Report(int reportNo, int reportedNo, String reported, String reportedName, String reportSort, String etc,
			Date reportDate) {
		super();
		this.reportNo = reportNo;
		this.reportedNo = reportedNo;
		this.reported = reported;
		this.reportedName = reportedName;
		this.reportSort = reportSort;
		this.etc = etc;
		this.reportDate = reportDate;
	}

	
	public Report(int reportNo, int reportedNo, String reported, String reporting, int postNo, String post,
			String reply, String reportSort, String etc, Date reportDate) {
		super();
		this.reportNo = reportNo;
		this.reportedNo = reportedNo;
		this.reported = reported;
		this.reporting = reporting;
		this.postNo = postNo;
		this.post = post;
		this.reply = reply;
		this.reportSort = reportSort;
		this.etc = etc;
		this.reportDate = reportDate;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public int getReportedNo() {
		return reportedNo;
	}

	public void setReportedNo(int reportedNo) {
		this.reportedNo = reportedNo;
	}

	public String getReported() {
		return reported;
	}

	public void setReported(String reported) {
		this.reported = reported;
	}

	public String getReportedName() {
		return reportedName;
	}

	public void setReportedName(String reportedName) {
		this.reportedName = reportedName;
	}

	public String getReporting() {
		return reporting;
	}

	public void setReporting(String reporting) {
		this.reporting = reporting;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReportSort() {
		return reportSort;
	}

	public void setReportSort(String reportSort) {
		this.reportSort = reportSort;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reportedNo=" + reportedNo + ", reported=" + reported
				+ ", reportedName=" + reportedName + ", reporting=" + reporting + ", post=" + post + ", reply=" + reply
				+ ", reportSort=" + reportSort + ", etc=" + etc + ", reportDate=" + reportDate + ", done=" + done + "]";
	}

}
