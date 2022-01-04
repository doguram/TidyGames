package com.TidyGames.member.model.service;

import static com.TidyGames.common.JDBCTemplate.close;
import static com.TidyGames.common.JDBCTemplate.commit;
import static com.TidyGames.common.JDBCTemplate.getConnection;
import static com.TidyGames.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.member.model.dao.PointDao;
import com.TidyGames.member.model.vo.Member;
import com.TidyGames.member.model.vo.Point;

public class PointService {
	
	public int pointListCount(int memNo) {
		Connection conn = getConnection();
		int listCount = new PointDao().pointListCount(conn, memNo);
		
		close(conn);
		
		return listCount;
	
	
	
	}

	public ArrayList<Point> selectPoint(int memNo, PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Point> point = new PointDao().selectPoint(conn, memNo, pi);

		close(conn);

		return point;

	}
	
	public ArrayList<Point> selectAllPoint(int memNo, String start, String end, PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Point> point = new PointDao().selectAllPoint(conn, memNo, start, end, pi);

		close(conn);

		return point;

	}

	public ArrayList<Point> selectSave(int memNo, String start, String end, PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Point> point = new PointDao().selectSave(conn, memNo, start, end, pi);

		close(conn);

		return point;

	}

	public ArrayList<Point> selectUse(int memNo, String start, String end, PageInfo pi) {

		Connection conn = getConnection();

		ArrayList<Point> point = new PointDao().selectUse(conn, memNo, start, end, pi);

		close(conn);

		return point;
	}

	
	public ArrayList<Point> selectOlddate(int memNo) {

		Connection conn = getConnection();

		ArrayList<Point> point = new PointDao().selectOlddate(conn, memNo);

		close(conn);

		return point;

	}
	public Point sumPoint(int memNo) {
		Connection conn = getConnection();
		
		Point sum = new PointDao().sumPoint(conn, memNo);
		
		close(conn);
		
		return sum;
		
	
	}
	
	public ArrayList<Point> adPointList() {
		Connection conn = getConnection();

		ArrayList<Point> list = new PointDao().adPointList(conn);

		close(conn);

		return list;
		
	}
	
	public int adInsertPoint(String memNo, int pa , String pc) {
		
		Connection conn = getConnection();
		
		int result = new PointDao().adInsertPoint(conn, memNo, pa, pc);
		
	
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
		
	public ArrayList<Point> adPointSearch(String memId) {
		Connection conn = getConnection();

		ArrayList<Point> list = new PointDao().adPointSearch(conn, memId);

		close(conn);

		return list;
		
	}
	
	
	//관리자 포인트상세내역 닉네임알아오기
	
	public Member memNick(int memNo) {
		Connection conn = getConnection();

		Member mNic = new PointDao().memNick(conn, memNo);

		close(conn);

		return  mNic;
		
		
		
		
		
	}
	
	
	
}
