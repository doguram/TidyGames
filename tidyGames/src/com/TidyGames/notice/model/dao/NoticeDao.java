package com.TidyGames.notice.model.dao;

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
import com.TidyGames.notice.model.vo.Notice;
import com.TidyGames.notice.model.vo.NoticeFile;
import com.TidyGames.post.model.vo.PostFile;

public class NoticeDao {

	private Properties prop = new Properties();
	
	public NoticeDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(NoticeDao.class.getResource("/db/sql/notice-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int selectListCount(Connection conn) {
	
		// select문 => ResultSet (한개) => int
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("noticeSelectListCount");
		
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
	
	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pi) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("noti_no"),
									rset.getString("noti_title"),
									rset.getString("noti_content"),
									rset.getString("noti_date"),
									rset.getString("noti_writer")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Notice selectNotice(Connection conn, int noticeNo) {
		
		// select문 - 단행조회
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice(rset.getInt("noti_no"),
							   rset.getString("noti_title"),
							   rset.getString("noti_content"),
							   rset.getString("noti_date"),
							   rset.getString("noti_writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}
	
	public int firstNoticeNo(Connection conn) {
		// 1개 컬럼 조회 -> get
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("firstNoticeNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("firstnotice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public int lastNoticeNo(Connection conn) {
		// 1개 컬럼 조회 -> get
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("lastNoticeNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("lastnotice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertNotice(Connection conn, Notice n) {
		
		// insert문
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNotiTitle());
			pstmt.setString(2, n.getNotiContent());
			pstmt.setString(3, n.getNotiWriter());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertFile(Connection conn, ArrayList<NoticeFile> list) {
		
		// NoticeFile 테이블에 list[0], list[1], list[2], ... 값 넣기.
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertFile");
		
		try {
			
			for(NoticeFile f : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, f.getFileOrigin());
				pstmt.setString(2, f.getFileChange());
				pstmt.setString(3, f.getFilePath());
				
				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public ArrayList<NoticeFile> selectFileList(Connection conn, int notiNo) {
		
		// 여러행 조회
		ArrayList<NoticeFile> fileList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectFileList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notiNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				fileList.add(new NoticeFile(rset.getInt("file_no"),
										    rset.getInt("noti_no"),
										    rset.getString("file_origin"),
										    rset.getString("file_change"),
										    rset.getString("file_path")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return fileList;
	}
	
	public int deleteNotice(Connection conn, int noticeNo) {
		
		// update
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int searchTitleCount(Connection conn, String word) {
		
		// select문 count
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchTitleCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}
	
	public int searchContentCount(Connection conn, String word) {
		
		// select문 count
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchContentCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
	}
	
	public ArrayList<Notice> selectTitleList(Connection conn, PageInfo pi, String word) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTitleList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;
			
			pstmt.setString(1, word);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("noti_no"),
									rset.getString("noti_title"),
									rset.getString("noti_content"),
									rset.getString("noti_date"),
									rset.getString("noti_writer")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Notice> selectContentList(Connection conn, PageInfo pi, String word) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectContentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;
			
			pstmt.setString(1, word);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("noti_no"),
									rset.getString("noti_title"),
									rset.getString("noti_content"),
									rset.getString("noti_date"),
									rset.getString("noti_writer")));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int updateNotice(Connection conn, Notice n) {
		
		// update문
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNotiTitle());
			pstmt.setString(2, n.getNotiContent());
			pstmt.setInt(3, n.getNotiNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateFileStatus(Connection conn, int num) {
		
		// update
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateFileStatus");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateFile(Connection conn, ArrayList<NoticeFile> list, int notiNo) {
		
		// NoticeFile 테이블에 list[0], list[1], list[2], ... 값 넣기.
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateFile");
		
		try {
			
			for(NoticeFile f : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, notiNo);
				pstmt.setString(2, f.getFileOrigin());
				pstmt.setString(3, f.getFileChange());
				pstmt.setString(4, f.getFilePath());
				
				result = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
}
