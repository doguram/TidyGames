package com.TidyGames.qna.model.vo;

/**
 * @author Dayn
 *
 */
public class Qna {
   
   private int qnaNo;
   private int memNo;
   private int companyNo;
   private String companyName;
   private String qnaTitle;
   private String qnaContent;
   private String qnaDate;
   private String qnaAnswer;
   private String qnaCheck;
   private String qnaAnswerDate;
   private String qnaStatus;
   private int gameNo;
   private String gameName;
   private String memId;
   private String memNick;
   private int seqNo;
   
   public Qna() {}   
   

	public Qna(int qnaNo, int memNo, int companyNo, String companyName, String qnaTitle, String qnaContent, String qnaDate,
		String qnaAnswer, String qnaCheck, String qnaAnswerDate, String qnaStatus, int gameNo, String gameName,
		String memId, String memNick, int seqNo) {
	super();
	this.qnaNo = qnaNo;
	this.memNo = memNo;
	this.companyNo = companyNo;
	this.companyName = companyName;
	this.qnaTitle = qnaTitle;
	this.qnaContent = qnaContent;
	this.qnaDate = qnaDate;
	this.qnaAnswer = qnaAnswer;
	this.qnaCheck = qnaCheck;
	this.qnaAnswerDate = qnaAnswerDate;
	this.qnaStatus = qnaStatus;
	this.gameNo = gameNo;
	this.gameName = gameName;
	this.memId = memId;
	this.memNick = memNick;
	this.seqNo = seqNo;
}





	/**
	 * dahyun myQnaList
	 * @param qnaNo
	 * @param qnaTitle
	 * @param qnaContent
	 * @param qnaDate
	 * @param qnaAnswer
	 */
	public Qna(int qnaNo, String qnaTitle, String qnaContent, String qnaDate, String qnaAnswer) {
	super();
	this.qnaNo = qnaNo;
	this.qnaTitle = qnaTitle;
	this.qnaContent = qnaContent;
	this.qnaDate = qnaDate;
	this.qnaAnswer = qnaAnswer;
}
	

	/**
	 * dahyun qnaDetailView
	 * @param qnaNo
	 * @param memNo
	 * @param qnaTitle
	 * @param qnaContent
	 * @param qnaDate
	 * @param qnaAnswer
	 * @param qnaAnswerDate
	 * @param memNick
	 */
	public Qna(int qnaNo, int memNo, String qnaTitle, String qnaContent, String qnaDate, String qnaAnswer,
			String qnaAnswerDate, String memNick) {
		super();
		this.qnaNo = qnaNo;
		this.memNo = memNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaAnswer = qnaAnswer;
		this.qnaAnswerDate = qnaAnswerDate;
		this.memNick = memNick;
	}

	
	/**
	 * dahyun qnaWaitList
	 * @param qnaNo
	 * @param memNo
	 * @param qnaTitle
	 * @param qnaDate
	 * @param qnaStatus
	 * @param memId
	 * @param memNick
	 */
	public Qna(int qnaNo, int memNo, String qnaTitle, String qnaDate, String qnaStatus, String memId, String memNick) {
		super();
		this.qnaNo = qnaNo;
		this.memNo = memNo;
		this.qnaTitle = qnaTitle;
		this.qnaDate = qnaDate;
		this.qnaStatus = qnaStatus;
		this.memId = memId;
		this.memNick = memNick;
	}
	
	


	public Qna(int qnaNo, String companyName, String qnaTitle, String qnaContent, String qnaDate, String qnaAnswer,
			String gameName) {
		super();
		this.qnaNo = qnaNo;
		this.companyName = companyName;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaAnswer = qnaAnswer;
		this.gameName = gameName;
			}
	public Qna( int seqNo,String gameName, int qnaNo, String memId,String memNick, String qnaTitle, String qnaDate, String qnaCheck  
			) {
		super();
		this.seqNo = seqNo;
		this.gameName = gameName;
		this.qnaNo = qnaNo;
		this.memId = memId;
		this.memNick = memNick;
		this.qnaTitle = qnaTitle;
		this.qnaDate = qnaDate;
		this.qnaCheck = qnaCheck;

	}
		
	

	public Qna(int qnaNo, String gameName, String qnaTitle, String memNick, String qnaDate, String qnaContent, String companyName,
			 String qnaAnswerDate, String qnaAnswer, String qnaCheck) {
		super();
		this.qnaNo = qnaNo;
		this.gameName = gameName;
		this.qnaTitle = qnaTitle;
		this.memNick = memNick;
		this.qnaDate = qnaDate;
		this.qnaContent = qnaContent;
		this.companyName = companyName;
		this.qnaAnswerDate = qnaAnswerDate;
		this.qnaAnswer = qnaAnswer;
		this.qnaCheck = qnaCheck;
	}
	
	


	public Qna(int companyNo, int gameNo, String gameName) {
		super();
		this.companyNo = companyNo;
		this.gameNo = gameNo;
		this.gameName = gameName;
	}
	
	


	public Qna(int memNo, int gameNo, int companyNo, String qnaTitle, String qnaContent) {
		super();
		this.memNo = memNo;
		this.gameNo = gameNo;
		this.companyNo = companyNo;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
	}


	public int getQnaNo() {
		return qnaNo;
	}
	
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	
	public int getMemNo() {
		return memNo;
	}
	
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	
	public int getCompanyNo() {
		return companyNo;
	}
	
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	
	public String getQnaTitle() {
		return qnaTitle;
	}
	
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	
	public String getQnaContent() {
		return qnaContent;
	}
	
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	
	public String getQnaDate() {
		return qnaDate;
	}
	
	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}
	
	public String getQnaAnswer() {
		return qnaAnswer;
	}
	
	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}
	
	public String getQnaCheck() {
		return qnaCheck;
	}
	
	public void setQnaCheck(String qnaCheck) {
		this.qnaCheck = qnaCheck;
	}
	
	public String getQnaAnswerDate() {
		return qnaAnswerDate;
	}
	
	public void setQnaAnswerDate(String qnaAnswerDate) {
		this.qnaAnswerDate = qnaAnswerDate;
	}
	
	public String getQnaStatus() {
		return qnaStatus;
	}
	
	public void setQnaStatus(String qnaStatus) {
		this.qnaStatus = qnaStatus;
	}
	
	public int getGameNo() {
		return gameNo;
	}
	
	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}
	
	public String getGameName() {
		return gameName;
	}
	
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public String getMemId() {
		return memId;
	}
	
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public String getMemNick() {
		return memNick;
	}
	
	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	@Override
	public String toString() {
		return "Qna [qnaNo=" + qnaNo + ", memNo=" + memNo + ", companyNo=" + companyNo + ", companyName=" + companyName
				+ ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent + ", qnaDate=" + qnaDate + ", qnaAnswer="
				+ qnaAnswer + ", qnaCheck=" + qnaCheck + ", qnaAnswerDate=" + qnaAnswerDate + ", qnaStatus=" + qnaStatus
				+ ", gameNo=" + gameNo + ", gameName=" + gameName + ", memId=" + memId + ", memNick=" + memNick
				+ ", seqNo=" + seqNo + "]";
	}

	
	
	   
   
   
}