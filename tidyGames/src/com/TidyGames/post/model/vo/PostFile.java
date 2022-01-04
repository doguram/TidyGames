package com.TidyGames.post.model.vo;

public class PostFile {
	
	private int fileNo;
	private int refPontNo;
	private String fileOrigin;
	private String fileChange;
	private String filePath;
	private String fileStatus;
	
	public PostFile() {}

	public PostFile(int fileNo, int refPontNo, String fileOrigin, String fileChange, String filePath,
			String fileStatus) {
		super();
		this.fileNo = fileNo;
		this.refPontNo = refPontNo;
		this.fileOrigin = fileOrigin;
		this.fileChange = fileChange;
		this.filePath = filePath;
		this.fileStatus = fileStatus;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getRefPontNo() {
		return refPontNo;
	}

	public void setRefPontNo(int refPontNo) {
		this.refPontNo = refPontNo;
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
		return "PostFile [fileNo=" + fileNo + ", refPontNo=" + refPontNo + ", fileOrigin=" + fileOrigin
				+ ", fileChange=" + fileChange + ", filePath=" + filePath + ", fileStatus=" + fileStatus + "]";
	}
	
	

}
