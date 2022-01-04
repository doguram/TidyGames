package com.TidyGames.qna.model.service;

import static com.TidyGames.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.common.model.vo.Attachment;
import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.qna.model.dao.QnaDao;
import com.TidyGames.qna.model.vo.Qna;

public class QnaService {

	public int insertQna(Qna qna, Attachment at) {
		
		Connection conn = getConnection();

		int result1 = new QnaDao().insertQna(conn, qna);
		int result2 = 1;
		if(at != null) {
			result2 = new QnaDao().insertAttachment(conn, at);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2;
	}
	
	public ArrayList<Qna> qnaWaitList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().qnaWaitList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new QnaDao().selectListCount(conn);
		
		if(listCount > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
			close(conn);
		return listCount;
		
	}
	
	public ArrayList<Qna> qnaDetailView(int qnaNo) {
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().qnaDetailView(conn, qnaNo);
		
		close(conn);
		return list;
	}
	
	public Attachment selectAttachment(int notiNo) {
		Connection conn = getConnection();
		
		Attachment at = new QnaDao().selectAttachment(conn, notiNo);
		close(conn);
		
		return at;
	}
	
	public int qnaAnswer(String answer, int qno) {
		Connection conn = getConnection();
		
		int result = new QnaDao().qnaAnswer(conn, answer, qno);
		
		close(conn);
		return result;
		
	}
	
	public ArrayList<Qna> selectGameQnaList(PageInfo pi, int companyNo){
		Connection conn = getConnection();
		ArrayList<Qna> list = new QnaDao().selectGameQnaList(conn, pi, companyNo);
		close(conn);
		return list;
	}
	
	public int selectGameQnaListCount(int companyNo) {
		Connection conn = getConnection();
		int listCount = new QnaDao().selectGameQnaListCount(conn, companyNo);
		close(conn);
		return listCount;
	}
	
	public Qna gameQnaDetailView(int gqnaNo) {
		Connection conn = getConnection();
		
		Qna gq = new QnaDao().gameQnaDetailView(conn, gqnaNo);
		
		close(conn);
		return gq;
	}
	
	public Attachment selectGameQnaAttachment(int gqnaNo) {
		Connection conn = getConnection();
		
		Attachment at = new QnaDao().selectGameQnaAttachment(conn, gqnaNo);
		close(conn);
		
		return at;
	}
	
	public int insertCompanyAnswer(Qna gq) {
		Connection conn = getConnection();
		int result = new QnaDao().insertCompanyAnswer(conn, gq);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;		
	}
	
	public Qna gameQnaQuestion(int gameNo) {
		Connection conn = getConnection();
		
		Qna gq = new QnaDao().gameQnaQuestion(conn, gameNo);
		
		close(conn);
		return gq;
	}
	
	public int insertGameQna(Qna gq, Attachment at) {
		Connection conn = getConnection();
		
		int result1 = new QnaDao().insertGameQna(conn, gq);
		int result2 = 1;
		if(at != null) {
			result2 = new QnaDao().insertGameQnaAttachment(conn, at);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2;
	}
}
