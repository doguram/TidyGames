package com.TidyGames.member.model.service;

import static com.TidyGames.common.JDBCTemplate.close;
import static com.TidyGames.common.JDBCTemplate.commit;
import static com.TidyGames.common.JDBCTemplate.getConnection;
import static com.TidyGames.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.game.model.vo.Game;
import com.TidyGames.game.model.vo.Review;
import com.TidyGames.member.model.dao.MemberDao;
import com.TidyGames.member.model.vo.Member;
import com.TidyGames.qna.model.vo.Qna;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		
		Connection conn = getConnection();
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		
		return m;
		
	}
	
	public int cookieUpdateMem(String userId, String sessionId) {
		
		Connection conn = getConnection();
		int result = new MemberDao().cookieUpdateMem(conn, userId, sessionId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public Member loginMemByCookie(String sessionId) {
		
		Connection conn = getConnection();
		Member m = new MemberDao().loginMemByCookie(conn, sessionId);
		
		close(conn);
		
		return m;
	}

	public int selectMemberCount() {
		Connection conn = getConnection();
		
		int listCount = new MemberDao().selectMemberCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	
	public ArrayList<Member> selectMemberList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectMemberList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	
	public Member selectMember(int memNo) {
		Connection conn = getConnection();
		
		Member m = new MemberDao().selectMember(conn, memNo);
		
		close(conn);
		
		return m;
	
	}
	

	public Member searchUserId(String searchName, String searchEmail) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().searchUserId(conn, searchName, searchEmail);
	
		close(conn);
		
		return m;
		
	}
	
	public Member searchUserPwd(String searchId, String searchEmail) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().searchUserPwd(conn, searchId, searchEmail);
		
		close(conn);
		
		return m;
		
	}
	
	public int checkNum(String searchEmail) {
		
		int num = new MemberDao().checkNum(searchEmail);
		
		return num;
		
	}
	
	public int updatePwd(String userId, String updatePwd) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwd(conn, userId, updatePwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		} 
			close(conn);
		
		return result;
	}
	

	public int idCheck(String checkId) {
		
		Connection conn = getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		close(conn);
		return count;
		
	}
	
	public int nickCheck(String checkNick) {
		
		Connection conn = getConnection();
		
		int count = new MemberDao().nickCheck(conn, checkNick);
		
		close(conn);
		return count;
		
	}
	
	public int insertMem(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMem(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

		public int updateMemberList(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMemberList(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		} 
			close(conn);
		
		return result;
	}
		
	public int updateUserCheck(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updateUserCheck(conn, userId, userPwd);
		
		close(conn);
		
		return result;
		
	}
	
	public int nickUpdateCheck(String checkNick, String checkId) {
		
		Connection conn = getConnection();
		
		int count = new MemberDao().nickUpdateCheck(conn, checkNick, checkId);
		
		close(conn);
		return count;
		
	}
	
	public int updateMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, m);

		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);

		return result;
	}

	public int deleteMember(String userId) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId);

		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);

		return result;
	}
		
	
	public ArrayList<Qna> myQnaList(int memNo, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new MemberDao().myQnaList(conn, memNo, pi);
		
		
		close(conn);
		return list;
		
	}
	
	public int qnaListCount(int memNo) {
		Connection conn = getConnection();
		
		int listCount = new MemberDao().qnaListCount(conn, memNo);
		
		close(conn);
		return listCount;
	}
	
	public int gameQnaCount(int memNo) {
		Connection conn = getConnection();
		
		int listCount = new MemberDao().gameQnaCount(conn, memNo);
		
		close(conn);
		return listCount;
	}
	
	public ArrayList<Qna> myGameQna(int memNo, PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new MemberDao().myGameQna(conn, memNo, pi);
		
		
		close(conn);
		return list;
		
	}
	
	public ArrayList<Review> myReviewList(int memNo) {
		Connection conn = getConnection();
		
		ArrayList<Review> list = new MemberDao().myReviewList(conn, memNo);
		
		close(conn);
		return list;
		
		
	}
	
	public ArrayList<Game> library(int memNo, String search) {
		Connection conn = getConnection();
		
		ArrayList<Game> list = new MemberDao().library(conn, memNo, search);
		
		close(conn);
		return list;
	}
	
	public ArrayList<Member> searchMemId(PageInfo pi, String word) {
		Connection conn = getConnection();
		
		ArrayList<Member> list = new MemberDao().searchMemId(conn, pi, word);
		
		close(conn);
		
		return list;
	}
	
}
