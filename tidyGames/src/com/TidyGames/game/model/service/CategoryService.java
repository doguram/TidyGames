package com.TidyGames.game.model.service;

import static com.TidyGames.common.JDBCTemplate.close;
import static com.TidyGames.common.JDBCTemplate.commit;
import static com.TidyGames.common.JDBCTemplate.getConnection;
import static com.TidyGames.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.game.model.dao.CategoryDao;
import com.TidyGames.game.model.vo.Category;

public class CategoryService {
	
	
	public ArrayList<Category> selectCategoryList(){
		Connection conn = getConnection();
		ArrayList<Category> list = new CategoryDao().selectCategoryList(conn);
		close(conn);
		return list;
	}
	
	public int updateCategory(Category c) {
		
		Connection conn = getConnection();
		int result = new CategoryDao().updateCategory(conn, c);
		
		if(result > 0) { 
			commit(conn);
		}else { 
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}
	
public int addCategory(Category c) {
		
		Connection conn = getConnection();
		int result = new CategoryDao().addCategory(conn, c);
		
		if(result > 0) { 
			commit(conn);
		}else { 
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}
	
	

}