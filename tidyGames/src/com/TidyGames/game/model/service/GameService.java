package com.TidyGames.game.model.service;

import static com.TidyGames.common.JDBCTemplate.close;
import static com.TidyGames.common.JDBCTemplate.commit;
import static com.TidyGames.common.JDBCTemplate.getConnection;
import static com.TidyGames.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.game.model.dao.GameDao;
import com.TidyGames.game.model.vo.Attachment3;
import com.TidyGames.game.model.vo.Category;
import com.TidyGames.game.model.vo.Game;
import com.TidyGames.game.model.vo.Review;

public class GameService {
	
	// 게임 객체 조회(게임리스트)
	public ArrayList<Game> selectList(String keyword, int memNo) {
		
		Connection conn  = getConnection();
		ArrayList<Game> list = new GameDao().selectList(conn, keyword, memNo);
		
		close(conn);
		
		return list;
	}
	// 게임 한개 조회(상세페이지), (게임사 업데이트폼)
	public Game selectGame(int memNo, int gameNo) {
		Connection conn = getConnection();
		Game g = new GameDao().selectGame(conn, memNo, gameNo);
		close(conn);
		return g;
	}
	
	// 리뷰 목록 조회
	public ArrayList<Review> selectReviewList(int gameNo){
		Connection conn = getConnection();
		ArrayList<Review> list = new GameDao().selectReviewList(conn, gameNo);
		close(conn);
		return list;
	}
	// 리뷰작성
	public int insertReview(Review r) {
		Connection conn =  getConnection();
		int result = new GameDao().insertReview(conn, r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	// 게임리스트 (페이징)
	public ArrayList<Game> selectGameList(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<Game> list = new GameDao().selectGameList(conn, pi);
		close(conn);
		return list;
	}
	
	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new GameDao().selectListCount(conn);
		close(conn);
		return listCount;
	}
	// 카테고리객체 조회
	public ArrayList<Category> selectGameCategory(int gameNo){
		Connection conn = getConnection();
		ArrayList<Category> gcList = new GameDao().selectGameCategory(conn, gameNo);
		close(conn);
		return gcList;
	}
	// 게임리스트(게임사별 게임목록 조회)
	public ArrayList<Game> selectGameListGC(int comNo) {
		
		Connection conn = getConnection();
		ArrayList<Game> list = new GameDao().selectGameListGC(conn, comNo);
		close(conn);
		return list;
	}
	// 게임업로드(게임사)
	public int insertGame(Game ga, ArrayList<Attachment3> list, int companyNo, int categoryNo) {
		Connection conn = getConnection();
		
		int result1 = new GameDao().insertGame(conn, ga, companyNo);
		int result2 = new GameDao().insertAttachment(conn, list);
		int result3 = new GameDao().insertCategory(conn, ga, categoryNo);
		
		if(result1 > 0 && result2 > 0 && result3 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2 * result3;
	}
	// 첨부파일 1개 조회
	public Attachment3 selectAttachment(int gameNo) {
		Connection conn = getConnection();
		Attachment3 at = new GameDao().selectAttachment(conn, gameNo);
		close(conn);
		return at;
	}
	// 게임 업데이트(게임사)
	public int updateGame(Game ga, ArrayList<Attachment3> list) {
		
		Connection conn = getConnection();
		int result1 = new GameDao().updateGame(conn, ga);
		
		int result2 = 1;
		
		System.out.println(list);
		
		for(Attachment3 at : list) {
			if(at != null) { // 새로운 첨부파일이 있었을 경우
				if(at.getFileNo() != 0) { // 기존의 첨부파일이 있었을 경우 => Attachment Update
					result2 = new GameDao().updateAttachment(conn, at);
				}else { // => Attachment Insert // 없을경우 
					result2 = new GameDao().insertNewAttachment(conn, at, ga);
				}
				
			}

			
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result1 * result2;
	}
	// 첨부파일객체 조회 (게임업데이트폼)
	public ArrayList<Attachment3> selectAttachmentList(int gameNo) {
		Connection conn = getConnection();
		ArrayList<Attachment3> list = new GameDao().selectAttachmentList(conn, gameNo);
		close(conn);
		return list;
		
	}
	
	public Game forSaleGame(int gameNo) {
		Connection conn = getConnection();
		Game g = new GameDao().forSaleGame(conn, gameNo);
		close(conn);
		return g;
	}
	
	
	public int uploadUpdate(Game g) {
		Connection conn =  getConnection();
		int result = 0;
		
		if(g.getConfirm().equals("del")) {
		result = new GameDao().uploadDelete(conn, g);
		}else {
		result = new GameDao().uploadUpdate(conn, g);
		}
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	// 게임 평균 별점 조회
	public int selectStarAvg(int gameNo) {
		Connection conn = getConnection();
		int starAvg = new GameDao().selectStarAvg(conn, gameNo);
		close(conn);
		return starAvg;
	}
	
	public ArrayList<Game> selectMainGameList() {
		
		Connection conn  = getConnection();
		ArrayList<Game> list = new GameDao().selectMainGameList(conn);
		
		close(conn);
		
		return list;
	}

}