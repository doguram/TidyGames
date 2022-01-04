package com.TidyGames.report.model.service;

import static com.TidyGames.common.JDBCTemplate.close;
import static com.TidyGames.common.JDBCTemplate.commit;
import static com.TidyGames.common.JDBCTemplate.getConnection;
import static com.TidyGames.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.report.model.dao.ReportDao;
import com.TidyGames.report.model.vo.Report;


public class ReportService {
	
	public int selectBlockCount() {
		
		Connection conn = getConnection();
		
		int listCount = new ReportDao().selectBlockCount(conn);
		
		close(conn);
		
		return listCount;
	}

	
	
	public ArrayList<Report> blacklist(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Report> list = new ReportDao().blacklist(conn, pi);
		
		close(conn);
		return list;
		
	}
	
	public int unblock(String userId) {
		Connection conn = getConnection();
		
		int result = new ReportDao().unblock(conn, userId);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
			close(conn);
			
		return result;
	}
	
	
	public ArrayList<Report> reportWaiting(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Report> list = new ReportDao().reportWaiting(conn, pi);
		
		close(conn);
		return list;
	}
	
	public int accessBlock(String user, int reportNo) {
		Connection conn = getConnection();
		
		int result1 = new ReportDao().accessBlock(conn, user);
		int result2 = new ReportDao().accessDone(conn, reportNo);
		
		int result = result1 * result2;
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
			close(conn);
			
		return result;
			
	}
	public int accessDone(int reportNo) {
		
		Connection conn = getConnection();
		int result = new ReportDao().accessDone(conn, reportNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		} 
			close(conn);
			
		return result;
		
	}
	
	public ArrayList<Report> selectReportList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Report> list = new ReportDao().selectReportList(conn, pi);
		
		close(conn);
		return list;
	}
	
	public int reportAtCommunity(Report r) {
		Connection conn = getConnection();
		int result = new ReportDao().reportAtCommunity(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int reportReplyAtCommunity(Report r) {
		Connection conn = getConnection();
		int result = new ReportDao().reportReplyAtCommunity(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}
