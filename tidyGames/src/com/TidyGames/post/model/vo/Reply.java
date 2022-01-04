package com.TidyGames.post.model.vo;

public class Reply {
	
	private int replyNo;
	private String replyWriter;
	private int refPostNo;
	private String replyContent;
	private String replyEnroll;
	private String replyModify;
	private String replyStatus;
	private int writerNo;
	
	public Reply() {}
	

	public Reply(int replyNo, String replyWriter, String replyContent, String replyEnroll, int writerNo) {
		super();
		this.replyNo = replyNo;
		this.replyWriter = replyWriter;
		this.replyContent = replyContent;
		this.replyEnroll = replyEnroll;
		this.writerNo = writerNo;
	}



	public Reply(int replyNo, String replyWriter, int refPostNo, String replyContent, String replyEnroll,
			String replyModify, String replyStatus, int writerNo) {
		super();
		this.replyNo = replyNo;
		this.replyWriter = replyWriter;
		this.refPostNo = refPostNo;
		this.replyContent = replyContent;
		this.replyEnroll = replyEnroll;
		this.replyModify = replyModify;
		this.replyStatus = replyStatus;
		this.writerNo = writerNo;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public int getRefPostNo() {
		return refPostNo;
	}

	public void setRefPostNo(int refPostNo) {
		this.refPostNo = refPostNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyEnroll() {
		return replyEnroll;
	}

	public void setReplyEnroll(String replyEnroll) {
		this.replyEnroll = replyEnroll;
	}

	public String getReplyModify() {
		return replyModify;
	}

	public void setReplyModify(String replyModify) {
		this.replyModify = replyModify;
	}

	public String getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	public int getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyWriter=" + replyWriter + ", refPostNo=" + refPostNo
				+ ", replyContent=" + replyContent + ", replyEnroll=" + replyEnroll + ", replyModify=" + replyModify
				+ ", replyStatus=" + replyStatus + ", writerNo=" + writerNo + "]";
	}

	

}