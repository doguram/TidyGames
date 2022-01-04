package com.TidyGames.qna.model.dao;

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
import com.TidyGames.qna.model.vo.Qna;

public class QnaDao {

	private Properties prop = new Properties();
	
	public QnaDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(QnaDao.class.getResource("/db/sql/qna-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int insertQna(Connection conn, Qna qna) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qna.getMemNo());
			pstmt.setString(2, qna.getQnaTitle());
			pstmt.setString(3, qna.getQnaContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		
		return result;
		
	}
	
	public int insertAttachment(Connection conn, Attachment at) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2,  at.getChangeName());
			pstmt.setString(3,  at.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public ArrayList<Qna> qnaWaitList(Connection conn, PageInfo pi) {
		
		ArrayList<Qna> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("qnaWaitList");
		
		int startRow = (pi.getCurrentPage() - 1) * (pi.getViewLimit()) + 1;
		int endRow = startRow + pi.getViewLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Qna(rset.getInt("qna_no")
								  , rset.getInt("mem_no")
								  , rset.getString("qna_title")
								  , rset.getString("report_date")
								  , rset.getString("ans_confirm")
								  , rset.getString("mem_id")
								  , rset.getString("mem_nick")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
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
				close(pstmt);
			}
			
			return listCount;
			
		}
		
		public ArrayList<Qna> qnaDetailView(Connection conn, int qnaNo) {
			
			ArrayList<Qna> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("qnaDetailView");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, qnaNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					list.add(new Qna(
										rset.getInt("qna_no")
									  , rset.getInt("mem_no")
							          , rset.getString("qna_title")
							          , rset.getString("qna_content")
							          , rset.getString("report_date")
							          , rset.getString("ans_content")
							          , rset.getString("ans_date")
							          , rset.getString("mem_nick")));
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		
		public Attachment selectAttachment(Connection conn, int notiNo) {
			
			Attachment at = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectAttachment");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, notiNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					at = new Attachment();
					
					at.setFileNo(rset.getInt("FILE_NO"));
					at.setOriginName(rset.getString("FILE_ORIGIN"));
					at.setChangeName(rset.getString("FILE_CHANGE"));
					at.setFilePath(rset.getString("FILE_PATH"));
				}
				
				} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return at;
			
		}
		
		public int qnaAnswer(Connection conn, String answer, int qno) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("qnaAnswer");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, answer);
				pstmt.setInt(2, qno);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
			
		}
		
		public ArrayList<Qna> selectGameQnaList(Connection conn, PageInfo pi, int companyNo) {
			
			ArrayList<Qna> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectGameQnaList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
				int endRow = startRow + pi.getViewLimit() - 1;
				
				pstmt.setInt(1, companyNo);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Qna( rset.getInt("seq_no"),
									  rset.getString("game_name"),
									  rset.getInt("gqna_no"),
							  		  rset.getString("mem_id"),
							  		  rset.getString("mem_nick"),
							  		  rset.getString("gqna_title"),				  	
							  		  rset.getString("gqna_date"),		  	
							  		  rset.getString("gqna_check")));				  	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
			
		}
		
		public int selectGameQnaListCount(Connection conn, int companyNo) {
			
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectGameQnaListCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, companyNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					listCount = rset.getInt("count");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return listCount;
			
		}
		
		public Qna gameQnaDetailView(Connection conn, int gqnaNo) {
			Qna gq = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("gameQnaDetailView");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gqnaNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					gq = new Qna(rset.getInt("gqna_no"), //문의번호
								rset.getString("game_name"), //게임제목
								rset.getString("gqna_title"), //문의글제목
								rset.getString("mem_nick"), //작성자닉네임
								rset.getString("gqna_date"), //문의작성일시
								rset.getString("gqna_content"), //문의글내용
								rset.getString("company_name"), //게임사명
								rset.getString("gqna_answer_date"), //문의작성일시
								rset.getString("gqna_answer"), //문의내용
								rset.getString("gqna_check")); //문의체크

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return gq;
		}
		
		public Attachment selectGameQnaAttachment(Connection conn, int gqnaNo) {
			
			Attachment at = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectGameQnaAttachment");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gqnaNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					at = new Attachment();
					at.setFileNo(rset.getInt("file_no"));
					at.setOriginName(rset.getString("file_origin"));
					at.setChangeName(rset.getString("file_change"));
					at.setFilePath(rset.getString("file_path"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return at;
			
			
		}
		
		public int insertCompanyAnswer(Connection conn, Qna gq) {
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("insertCompanyAnswer");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, gq.getQnaAnswer());
				pstmt.setInt(2, gq.getQnaNo());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
			
		}
		
		public Qna gameQnaQuestion(Connection conn, int gameNo) {
			Qna gq = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("gameQnaQuestion");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gameNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					gq = new Qna(rset.getInt("company_no"), //게임사번호
								rset.getInt("game_no"), //게임번호
								rset.getString("game_name")); //게임이름

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return gq;
		}
		
		public int insertGameQna(Connection conn, Qna gq) {
			// insert문 => 처리된행수 => 트랜잭션처리
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("insertGameQna");
			
			try {
				pstmt = conn.prepareStatement(sql); // 미완성된 sql
				pstmt.setInt(1, gq.getMemNo());
				pstmt.setInt(2, gq.getGameNo());
				pstmt.setInt(3, gq.getCompanyNo());
				pstmt.setString(4, gq.getQnaTitle());
				pstmt.setString(5, gq.getQnaContent());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}
		
		public int insertGameQnaAttachment(Connection conn, Attachment at) {
			int result = 0;
			PreparedStatement pstmt = null;
			String sql = prop.getProperty("insertGameQnaAttachment");
			
			try {
				pstmt = conn.prepareStatement(sql); // 미완성된 sql
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
			
		}
	
}
