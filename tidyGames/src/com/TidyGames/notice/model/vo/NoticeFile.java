package com.TidyGames.notice.model.vo;

public class NoticeFile {

	private int fileNo;
	private int NotiNo;
	private String fileOrigin;
	private String fileChange;
	private String filePath;
	private String fileStatus;
	
	public NoticeFile() {}

	public NoticeFile(int fileNo, int notiNo, String fileOrigin, String fileChange, String filePath,
			String fileStatus) {
		super();
		this.fileNo = fileNo;
		NotiNo = notiNo;
		this.fileOrigin = fileOrigin;
		this.fileChange = fileChange;
		this.filePath = filePath;
		this.fileStatus = fileStatus;
	}
	
	// selectFileList용
	public NoticeFile(int fileNo, int notiNo, String fileOrigin, String fileChange, String filePath) {
		super();
		this.fileNo = fileNo;
		NotiNo = notiNo;
		this.fileOrigin = fileOrigin;
		this.fileChange = fileChange;
		this.filePath = filePath;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getNotiNo() {
		return NotiNo;
	}

	public void setNotiNo(int notiNo) {
		NotiNo = notiNo;
	}

	public String getFileOrigin() {
		return fileOrigin;
	}

	public void setFileOrigin(String fileOrigin) {
		this.fileOrigin = fileOrigin;
	}

	public String getFileChange() {
		return fileChange;
	}

	public void setFileChange(String fileChange) {
		this.fileChange = fileChange;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	@Override
	public String toString() {
		return "NoticeFile [fileNo=" + fileNo + ", NotiNo=" + NotiNo + ", fileOrigin=" + fileOrigin + ", fileChange="
				+ fileChange + ", filePath=" + filePath + ", fileStatus=" + fileStatus + "]";
	}

	
	
}
