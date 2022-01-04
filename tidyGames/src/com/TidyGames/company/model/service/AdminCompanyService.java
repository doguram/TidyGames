package com.TidyGames.company.model.service;

import static com.TidyGames.common.JDBCTemplate.close;
import static com.TidyGames.common.JDBCTemplate.commit;
import static com.TidyGames.common.JDBCTemplate.getConnection;
import static com.TidyGames.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.company.model.dao.AdminCompanyDao;
import com.TidyGames.company.model.vo.Company;
import com.TidyGames.game.model.vo.Game;

public class AdminCompanyService {

	public int insertCompany(Company c) {
		Connection conn = getConnection();
		int result = new AdminCompanyDao().insertCompany(conn, c);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new AdminCompanyDao().selectListCount(conn);
		close(conn);
		return listCount;
	}


	public ArrayList<Company> selectCompanyList(PageInfo pi){	
		Connection conn = getConnection();
		ArrayList<Company> list = new AdminCompanyDao().selectCompanyList(conn, pi);
		close(conn);
		return list;
	}
	

	public ArrayList<Company> searchCompany(String companyName) {
		Connection conn = getConnection();
		ArrayList<Company> searchList = new AdminCompanyDao().searchCompany(conn, companyName);
		close(conn);
		return searchList;
	}
	
	public Company selectCompanyDetail(int companyNo) {
		Connection conn = getConnection();
		Company c = new AdminCompanyDao().selectCompanyDetail(conn, companyNo);
		close(conn);
		return c;
	}

	public int updateCompany(Company c) {
		Connection conn = getConnection();
		int result = new AdminCompanyDao().updateCompany(conn, c);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int deleteCompany(int companyNo) {
		Connection conn = getConnection();
		int result = new AdminCompanyDao().deleteCompany(conn, companyNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<Game> selectGameList(int companyNo) {
		Connection conn = getConnection();
		ArrayList<Game> gameList = new AdminCompanyDao().selectGameList(conn, companyNo);
		close(conn);
		return gameList;
	}
	
	


}
