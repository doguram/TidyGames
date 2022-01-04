package com.TidyGames.member.model.dao;

import static com.TidyGames.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.member.model.vo.WishList;

public class WishListDao {

	private Properties prop = new Properties();
	
	public WishListDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(MemberDao.class.getResource("/db/sql/wishList-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<WishList> selectWish(Connection conn, int memNo, PageInfo pi) {
		
		// select문 => ResultSet (여러행) => WishList
		ArrayList<WishList> wish = new  ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectWish");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1 ) * pi.getViewLimit() + 1;
			int endRow = startRow +  pi.getViewLimit() - 1;
			
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
		
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				wish.add(new WishList(
								  rset.getInt("mem_no"),	
								  rset.getInt("game_no"),
								  rset.getString("kor_name"),
								  rset.getString("eng_name"),
								  rset.getString("game_intro"),
								  rset.getInt("price"),
								  rset.getInt("point"),
								  rset.getString("CHANGE_NAME"),
								  rset.getString("FILE_PATH")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return wish;
	
	
	}
	
	public ArrayList<WishList> wishSearch(Connection conn, int memNo, String keyword, PageInfo pi) {
		
		// select문 => ResultSet (여러행) => WishList
		ArrayList<WishList> wish = new  ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("wishSearch");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1 ) * pi.getViewLimit() + 1;
			int endRow = startRow +  pi.getViewLimit() - 1;
			
			
			pstmt.setInt(1, memNo);
			pstmt.setString(2, keyword);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
		
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				wish.add(new WishList(
								  rset.getInt("mem_no"),	
								  rset.getInt("game_no"),
								  rset.getString("kor_name"),
								  rset.getString("eng_name"),
								  rset.getString("game_intro"),
								  rset.getInt("price"),
								  rset.getInt("point"),
								  rset.getString("CHANGE_NAME"),
								  rset.getString("FILE_PATH")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return wish;
	
	
	}
	
		
		public int insertWish(Connection conn, WishList wish) {
			
			// insert문 => 처리된행수 => 트랜잭션처리
			
			
			int result =0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("insertWish");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, wish.getMemNo());
				pstmt.setInt(2, wish.getGameNo());
				
				result = pstmt.executeUpdate();
				
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
			
			
		public int deleteWish(Connection conn , WishList d) {

			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("deleteWish");
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, d.getMemNo());
				pstmt.setInt(2, d.getGameNo());
				
				
				result = pstmt.executeUpdate();
				
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		

		public int selectListCount(Connection conn, int memNo) {
			
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectListCount");
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, memNo);
				
				rset = pstmt.executeQuery();
				
				
				if(rset.next()) {
//					count(*) 컬럼의 별칭인 count임
					listCount = rset.getInt("count");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return listCount;
		}
		
		
		
}
