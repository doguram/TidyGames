package com.TidyGames.company.model.service;

import static com.TidyGames.common.JDBCTemplate.*;

import java.sql.Connection;

import com.TidyGames.company.model.dao.LoginCompanyDao;
import com.TidyGames.company.model.vo.Company;
import com.TidyGames.member.model.dao.MemberDao;
import com.TidyGames.member.model.vo.Member;

public class LoginCompanyService {

	public Company loginCompany(String userId, String userPwd) {
		
		Connection conn = getConnection();
		Company c = new LoginCompanyDao().loginCompany(conn, userId, userPwd);
		
		close(conn);
		
		return c;
	}
	
	public int cookieUpdateCom(String userId, String sessionId) {
		
		Connection conn = getConnection();
		int result = new LoginCompanyDao().cookieUpdateCom(conn, userId, sessionId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public Company loginComByCookie(String sessionId) {
		
		Connection conn = getConnection();
		Company c = new LoginCompanyDao().loginComByCookie(conn, sessionId);
		
		close(conn);
		
		return c;
	}
	
}
