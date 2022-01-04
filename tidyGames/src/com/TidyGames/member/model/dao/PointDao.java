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
import com.TidyGames.member.model.vo.Member;
import com.TidyGames.member.model.vo.Point;
import com.TidyGames.pay.model.vo.Pay;

public class PointDao {

	private Properties prop = new Properties();

	public PointDao() {

		try {
			prop.loadFromXML(new FileInputStream(MemberDao.class.getResource("/db/sql/point-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int pointListCount(Connection conn, int memNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("pointListCount");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
//				count(*) 컬럼의 별칭인 count임
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
	
	
	
	
	
	public ArrayList<Point> selectPoint(Connection conn, int memNo, PageInfo pi) {

		ArrayList<Point> point = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectPoint");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() -1 ) * pi.getViewLimit() + 1;
			int endRow = startRow +  pi.getViewLimit() - 1;
			
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				point.add(new Point(rset.getInt("mem_no"), 
									rset.getInt("point_amount"), 
									rset.getString("point_date"),
									rset.getString("point_content"), 
									rset.getInt("order_no")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return point;
	}
	
	public ArrayList<Point> selectAllPoint(Connection conn, int memNo, String start, String end, PageInfo pi) {

		ArrayList<Point> point = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllPoint");

		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() -1 ) * pi.getViewLimit() + 1;
			int endRow = startRow +  pi.getViewLimit() - 1;
			pstmt.setInt(1, memNo);
			pstmt.setString(2, start);
			pstmt.setString(3, end);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				point.add(new Point(rset.getInt("mem_no"), 
									rset.getInt("point_amount"), 
									rset.getString("point_date"),
									rset.getString("point_content"), 
									rset.getInt("order_no")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return point;
	}


	public ArrayList<Point> selectSave(Connection conn, int memNo, String start, String end, PageInfo pi) {

		ArrayList<Point> point = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSave");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() -1 ) * pi.getViewLimit() + 1;
			int endRow = startRow +  pi.getViewLimit() - 1;
			
			pstmt.setInt(1, memNo);
			pstmt.setString(2, start);
			pstmt.setString(3, end);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				point.add(new Point(rset.getInt("mem_no"), 
									rset.getInt("point_amount"), 
									rset.getString("point_date"),
									rset.getString("point_content"), 
									rset.getInt("order_no")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return point;
	}

	public ArrayList<Point> selectUse(Connection conn, int memNo, String start, String end, PageInfo pi) {

		ArrayList<Point> point = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectUse");

		try {
			pstmt = conn.prepareStatement(sql);

			
			int startRow = (pi.getCurrentPage() -1 ) * pi.getViewLimit() + 1;
			int endRow = startRow +  pi.getViewLimit() - 1;
			
			
			pstmt.setInt(1, memNo);
			pstmt.setString(2, start);
			pstmt.setString(3, end);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				point.add(new Point(rset.getInt("mem_no"), 
									rset.getInt("point_amount"), 
									rset.getString("point_date"),
									rset.getString("point_content"), 
									rset.getInt("order_no")));
						}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return point;
	}

	
	public ArrayList<Point> selectOlddate(Connection conn, int memNo) {

		ArrayList<Point> point = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectOlddate");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memNo);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				point.add(new Point(rset.getInt("mem_no"), 
									rset.getInt("point_amount"), 
									rset.getString("point_date"),
									rset.getString("point_content"), 
									rset.getInt("order_no")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return point;
	}
	
	
	public Point sumPoint(Connection conn, int memNo) {
		
		Point sum = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("sumPoint");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				sum = new Point(rset.getInt("sum"));
						
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return sum;
		
	}
	
	
	public ArrayList<Point> adPointList(Connection conn) {
		

		ArrayList<Point> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adPointList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Point(rset.getInt("mem_no"),
								   rset.getString("mem_id"),
								   rset.getInt("sum")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
		
	}
	
	
	public int adInsertPoint(Connection conn, String memNo, int pa, String pc) {
		
		int result =0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("adInsertPoint");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memNo);
			pstmt.setInt(2, pa);
			pstmt.setString(3, pc);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public ArrayList<Point> adPointSearch(Connection conn, String memId) {
		

		ArrayList<Point> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adPointSearch");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Point(rset.getInt("mem_no"),
								   rset.getString("mem_id"),
								   rset.getInt("sum")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
		
	}
	
		
	public Member memNick(Connection conn, int memNo) {
		
		Member mNic = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("memNick");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mNic = new Member(rset.getString("MEM_NICK")
								 );
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mNic;
	
	
	}
	

}
