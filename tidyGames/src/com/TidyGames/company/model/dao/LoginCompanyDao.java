package com.TidyGames.company.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.TidyGames.company.model.vo.Company;
import com.TidyGames.member.model.vo.Member;

import static com.TidyGames.common.JDBCTemplate.*;

public class LoginCompanyDao {

	private Properties prop = new Properties();
	
	public LoginCompanyDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(LoginCompanyDao.class.getResource("/db/sql/company-login-mapper.xml").getPath()));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public Company loginCompany(Connection conn, String userId, String userPwd) {
		// select문 - 한행조회
		
		Company c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginCompany");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Company(rset.getInt("company_no"),
								rset.getString("company_name"),
								rset.getString("company_pwd"),
								rset.getString("company_head"),
								rset.getString("company_comment"),
								rset.getDate("company_enroll"),
								rset.getString("company_status"),
								rset.getString("company_id"),
								rset.getString("company_cookie"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}
	
	public int cookieUpdateCom(Connection conn, String userId, String sessionId) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("cookieUpdateCom");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sessionId);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public Company loginComByCookie(Connection conn, String sessionId) {
		
		Company c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginComByCookie");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sessionId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Company(rset.getInt("company_no"),
								rset.getString("company_name"),
								rset.getString("company_pwd"),
								rset.getString("company_head"),
								rset.getString("company_comment"),
								rset.getDate("company_enroll"),
								rset.getString("company_status"),
								rset.getString("company_id"),
								rset.getString("company_cookie"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
		
	}
	
}
