package com.TidyGames.game.model.dao;

import static com.TidyGames.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.TidyGames.common.model.vo.Attachment;
import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.game.model.vo.Attachment3;
import com.TidyGames.game.model.vo.Category;
import com.TidyGames.game.model.vo.Game;
import com.TidyGames.game.model.vo.Review;

public class GameDao {

private Properties prop = new Properties();

	public GameDao() {
		String filePath = GameDao.class.getResource("/db/sql/game-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Game> selectList(Connection conn, String keyword, int memNo) {
		
		ArrayList <Game> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setString(2, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Game(rset.getInt("game_no"),
								  rset.getInt("company_no"),
								  rset.getString("kor_name"),
								  rset.getString("eng_name"),
								  rset.getString("release_date"),
								  rset.getInt("price"),
								  rset.getDouble("point"),
								  rset.getString("game_status"),
								  rset.getString("game_img"),
								  rset.getInt("count")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Game selectGame(Connection conn, int memNo, int gameNo) {
		
		Game g = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectGame");
		
		try {
			pstmt = conn.prepareStatement(sql);//미완성
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, gameNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				g = new Game(rset.getInt("game_no"),
							 rset.getInt("company_no"),
							 rset.getString("kor_name"),
							 rset.getString("eng_name"),
							 rset.getString("release_date"),
							 rset.getInt("price"),
							 rset.getString("game_intro"),
							 rset.getString("confirm"),
							 rset.getString("upgame"),
							 rset.getString("upload_date"),
							 rset.getDouble("point"),
							 rset.getString("game_status"),
							 rset.getInt("count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return g;
		
	}
// 삭제할지도 모르는 애
public Game selectGameGC(Connection conn, int comNo, int gameNo) {
		
		Game g = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectGameGC");
		
		try {
			pstmt = conn.prepareStatement(sql);//미완성
			pstmt.setInt(1, gameNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				g = new Game(rset.getInt("game_no"),
							 rset.getInt("company_no"),
							 rset.getString("kor_name"),
							 rset.getString("eng_name"),
							 rset.getString("release_date"),
							 rset.getInt("price"),
							 rset.getString("game_intro"),
							 rset.getString("confirm"),
							 rset.getString("upgame"),
							 rset.getString("upload_date"),
							 rset.getDouble("point"),
							 rset.getString("game_status"),
							 rset.getString("game_img"));
							 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return g;
		
	}
	
	
	public ArrayList<Game> selectGameList(Connection conn, PageInfo pi) {
		
		ArrayList<Game> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectGameList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Game(rset.getInt("game_no"),
						  		  rset.getString("company_name"),
						  		  rset.getString("eng_name"),
						  		  rset.getString("upload_date"),
						  		  rset.getString("confirm"),				  	
						  		  rset.getString("game_status")));				  	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	

	public ArrayList<Review> selectReviewList(Connection conn, int gameNo) {
		//여러행조회
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review( rset.getInt("review_no"),
									 rset.getInt("game_no"),
									 rset.getString("writer"),
									 rset.getString("contents"),
									 rset.getInt("recommend"),
									 rset.getString("upload_date"),
									 rset.getInt("star_no"),
									 rset.getInt("mem_no")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int insertReview(Connection conn, Review r) {
		//insert문 => 처리된행수 => 트랜잭션
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getGameNo());
			pstmt.setInt(2, Integer.parseInt(r.getWriter()));
			pstmt.setString(3, r.getContents());
			pstmt.setInt(4, r.getStarNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql); 
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;

	}
	
	public ArrayList<Category> selectGameCategory(Connection conn, int gameNo){
		
		ArrayList<Category> gcList = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectGameCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				gcList.add(new Category(rset.getString("category_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return gcList;
	}
	
	public ArrayList<Game> selectGameListGC(Connection conn, int comNo) {
		ArrayList<Game> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectGameListGC");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Game(rset.getInt("game_no"),
								  rset.getString("kor_name"),
								  rset.getString("eng_name"),
							      rset.getInt("price"),
								  rset.getString("confirm"),
								  rset.getString("upgame"),
								  rset.getString("upload_date")));
									 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int insertGame(Connection conn, Game ga, int companyNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertGame");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, companyNo);
			pstmt.setString(2, ga.getKorName());
			pstmt.setString(3, ga.getEngName());
			pstmt.setString(4, ga.getReleaseDate());
			pstmt.setInt(5, ga.getPrice());
			pstmt.setString(6, ga.getGameIntro());
			pstmt.setString(7, ga.getGameImg());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertAttachment(Connection conn, ArrayList<Attachment3> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		try {
			
			for(Attachment3 at : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setInt(4, at.getFileLevel());
				
				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	// 게임 첨부파일 1개 조회
	public Attachment3 selectAttachment(Connection conn, int gameNo) {
		// select문
		Attachment3 at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				at = new Attachment3();
				at.setFileNo(rset.getInt("file_no"));
				at.setOriginName(rset.getString("origin_name"));
				at.setChangeName(rset.getString("change_name"));
				at.setFilePath(rset.getString("file_path"));
				at.setFileLevel(rset.getInt("file_type"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return at;
		
	}
	// 게임 업데이트
	public int updateGame(Connection conn, Game ga) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateGame");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ga.getKorName());
			pstmt.setString(2, ga.getEngName());
			pstmt.setString(3, ga.getGameIntro());
			pstmt.setInt(4, ga.getPrice());
			pstmt.setInt(5, ga.getGameNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	// 첨부파일 업데이트
	public int updateAttachment(Connection conn, Attachment3 at) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getFileNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int insertNewAttachment(Connection conn, Attachment3 at, Game ga) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ga.getGameNo());
			pstmt.setInt(2, at.getRefBoardNo());
			pstmt.setString(3, at.getOriginName());
			pstmt.setString(4, at.getChangeName());
			pstmt.setString(5, at.getFilePath());
			pstmt.setInt(6, at.getFileLevel());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public ArrayList<Attachment3> selectAttachmentList(Connection conn, int gameNo){
		ArrayList<Attachment3> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAttachmentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment3 at = new Attachment3();
				at.setFileNo(rset.getInt("file_no"));
				at.setChangeName(rset.getString("change_name"));
				at.setFilePath(rset.getString("file_path"));
				at.setFileLevel(rset.getInt("file_type"));
				list.add(at);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
public Game forSaleGame(Connection conn, int gameNo) {
		
		Game g = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("forSaleGame");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				g = new Game(rset.getInt("game_no"),
							 rset.getInt("company_no"),
							 rset.getString("kor_name"),
							 rset.getString("eng_name"),
							 rset.getString("release_date"),
							 rset.getInt("price"),
							 rset.getString("game_intro"),
							 rset.getString("confirm"),
							 rset.getString("upgame"),
							 rset.getString("upload_date"),
							 rset.getDouble("point"),
							 rset.getString("game_status"),
							 rset.getInt("count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return g;
		
	}

public Game uploadGame(Connection conn, int gameNo) {
	
	Game g = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = prop.getProperty("forSaleGame");
	
	try {
		pstmt = conn.prepareStatement(sql);//미완성
		pstmt.setInt(1, gameNo);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			g = new Game(rset.getInt("game_no"),
						 rset.getInt("company_no"),
						 rset.getString("kor_name"),
						 rset.getString("eng_name"),
						 rset.getString("release_date"),
						 rset.getInt("price"),
						 rset.getString("game_intro"),
						 rset.getString("confirm"),
						 rset.getString("upgame"),
						 rset.getString("upload_date"),
						 rset.getDouble("point"),
						 rset.getString("game_status"),
						 rset.getInt("count"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(rset);
		close(pstmt);
	}
	return g;
	
}
public int gameDelete(Connection conn, Game g) {
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("gameDelete");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, g.getGameNo());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}

public int uploadUpdate(Connection conn, Game g) {
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("uploadUpdate");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, g.getConfirm());
		pstmt.setInt(2, g.getGameNo());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
public int uploadDelete(Connection conn, Game g) {
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("gameDelete");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, g.getGameNo());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}
	
	public int insertCategory(Connection conn, Game ga, int categoryNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCategory");
		
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, categoryNo);
				
				result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int selectStarAvg(Connection conn, int gameNo) {
		int starAvg = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectStarAvg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gameNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				starAvg = rset.getInt("star_avg");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return starAvg;
	}
	
	public ArrayList<Game> selectMainGameList(Connection conn){
		ArrayList<Game> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMainGameList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Game(rset.getInt("game_no"),
								  rset.getString("kor_name"),
								  rset.getString("eng_name"),
							      rset.getInt("price"),
								  rset.getString("confirm"),
								  rset.getString("upgame"),
								  rset.getString("upload_date"),
								  rset.getDouble("point"),
								  rset.getString("game_img")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
}
