package com.TidyGames.company.model.dao;

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
import com.TidyGames.company.model.vo.Company;
import com.TidyGames.game.model.vo.Game;

public class AdminCompanyDao {
	
	private Properties prop = new Properties(); // 전역변수 private

	public AdminCompanyDao() {
		
		String filePath = AdminCompanyDao.class.getResource("/db/sql/company-admin-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public int insertCompany(Connection conn, Company c) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCompany");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCompanyName());
			pstmt.setString(2, c.getCompanyHead());
			pstmt.setString(3, c.getCompanyComment());
			pstmt.setString(4, c.getCompanyId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	

	public ArrayList<Company> selectCompanyList(Connection conn, PageInfo pi){
		
		ArrayList<Company> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCompanyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Company(rset.getInt("company_no"),
									 rset.getString("company_name"),
									 rset.getString("company_id"),
									 rset.getString("company_pwd"),
									 rset.getDate("company_enroll")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	
	public ArrayList<Company> searchCompany(Connection conn, String companyName){
			
			ArrayList<Company> searchList = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("searchCompany");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, companyName);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					searchList.add(new Company(rset.getInt("company_no"),
										 	   rset.getString("company_name"),
										 	   rset.getString("company_id"),
										 	   rset.getString("company_pwd"),
										 	   rset.getDate("company_enroll")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return searchList;
		}
		
	
	public Company selectCompanyDetail(Connection conn, int companyNo) {
		
		Company c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCompanyDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, companyNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Company();
				c.setCompanyNo(rset.getInt("company_no"));
				c.setCompanyName(rset.getString("company_name"));
				c.setCompanyId(rset.getString("company_id"));
				c.setCompanyPwd(rset.getString("company_pwd"));
				c.setCompanyHead(rset.getString("company_head"));
				c.setCompanyComment(rset.getString("company_comment"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}
	

	public int updateCompany(Connection conn, Company c) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateCompany");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCompanyName());
			pstmt.setString(2, c.getCompanyId());
			pstmt.setString(3, c.getCompanyHead());
			pstmt.setString(4, c.getCompanyComment());
			pstmt.setInt(5, c.getCompanyNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	

	public int deleteCompany(Connection conn, int companyNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteCompany");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, companyNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	

	public ArrayList<Game> selectGameList(Connection conn, int companyNo) {
		ArrayList<Game> gameList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectGameList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, companyNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Game g = new Game();
				g.setGameNo(rset.getInt("game_no"));
				g.setKorName(rset.getString("kor_name"));
				g.setEngName(rset.getString("eng_name"));
				g.setReleaseDate(rset.getString("release_date"));
				g.setUploadDate(rset.getString("upload_date"));
				gameList.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return gameList;
	}
	
	

	
}
