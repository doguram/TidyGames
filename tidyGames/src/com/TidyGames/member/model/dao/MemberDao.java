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

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.game.model.vo.Game;
import com.TidyGames.game.model.vo.Review;
import com.TidyGames.member.model.vo.Member;
import com.TidyGames.qna.model.vo.Qna;

public class MemberDao {

	private Properties prop = new Properties();
	
	public MemberDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(MemberDao.class.getResource("/db/sql/member-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		//select문 - 한행조회
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("mem_no"),
							   rset.getString("mem_id"),
							   rset.getString("mem_pwd"),
							   rset.getString("mem_nick"),
							   rset.getString("mem_name"),
							   rset.getString("mem_birth"),
							   rset.getString("mem_phone"),
							   rset.getString("mem_email"),
							   rset.getString("mem_gender"),
							   rset.getString("mem_address"),
							   rset.getDate("mem_indate"),
							   rset.getString("mem_agr"),
							   rset.getString("mem_pic"),
							   rset.getString("mem_status"),
							   rset.getDate("mem_outdate"),
							   rset.getString("role_id"),
							   rset.getString("mem_access"),
							   rset.getDate("block_date"),
							   rset.getString("mem_cookie"),
							   rset.getString("mem_category"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	public int cookieUpdateMem(Connection conn, String userId, String sessionId) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("cookieUpdateMem");
		
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
	
	public Member loginMemByCookie(Connection conn, String sessionId) {
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("loginMemByCookie");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sessionId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("mem_no"),
							   rset.getString("mem_id"),
							   rset.getString("mem_pwd"),
							   rset.getString("mem_nick"),
							   rset.getString("mem_name"),
							   rset.getString("mem_birth"),
							   rset.getString("mem_phone"),
							   rset.getString("mem_email"),
							   rset.getString("mem_gender"),
							   rset.getString("mem_address"),
							   rset.getDate("mem_indate"),
							   rset.getString("mem_agr"),
							   rset.getString("mem_pic"),
							   rset.getString("mem_status"),
							   rset.getDate("mem_outdate"),
							   rset.getString("role_id"),
							   rset.getString("mem_access"),
							   rset.getDate("block_date"),
							   rset.getString("mem_cookie"),
							   rset.getString("mem_category"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}
		
		public int selectMemberCount(Connection conn) {
			
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectMemberCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					listCount = rset.getInt("COUNT"); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} close(pstmt);
			
			return listCount;			
	}
	
		public ArrayList<Member> selectMemberList(Connection conn, PageInfo pi) {
			
			ArrayList<Member> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectMemberList");
			
			int startRow = (pi.getCurrentPage() - 1) * (pi.getViewLimit()) + 1;
			int endRow = startRow + pi.getViewLimit() - 1;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Member(rset.getInt("mem_no")
									  , rset.getString("mem_id")
									  , rset.getString("mem_nick")
									  , rset.getString("mem_name")
									  , rset.getString("mem_phone")
									  , rset.getString("mem_email")
									  , rset.getString("mem_gender")
									  , rset.getString("mem_address")
									  , rset.getDate("mem_indate")
									  , rset.getString("mem_status")));
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
			
		}
			
		
		public Member selectMember(Connection conn, int memNo) {
			
			Member m = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("selectMember");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, memNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					m = new Member();
					
					m.setMemNo(rset.getInt("mem_no"));
					m.setMemId(rset.getString("mem_id"));
					m.setMemName(rset.getString("mem_name"));
					m.setMemNick(rset.getString("mem_nick"));
					m.setMemBirth(rset.getString("mem_birth"));
					m.setMemGender(rset.getString("mem_gender"));
					m.setMemPhone(rset.getString("mem_phone"));
					m.setMemEmail(rset.getString("mem_Email"));
					m.setMemAddress(rset.getString("mem_address"));
					m.setDate(rset.getString("mem_indate"));
					m.setMemStatus(rset.getString("mem_status"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return m;
			
			
		}

	
	public Member searchUserId(Connection conn, String searchName, String searchEmail) {
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchUserId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			pstmt.setString(2, searchEmail);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("mem_no"),
							   rset.getString("mem_id"));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
	}

	public Member searchUserPwd(Connection conn, String searchId, String searchEmail) {
			
			Member m = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String sql = prop.getProperty("searchUserPwd");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, searchId);
				pstmt.setString(2, searchEmail);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					m = new Member(rset.getInt("mem_no"),
								   rset.getString("mem_id"),
								   rset.getString("mem_pwd"));	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return m;
			
		}
	
	public int checkNum(String searchEmail) {
		
		int num = (int)(Math.random() * 999999 + 100000);
		final String user = "qng582@gmail.com";
		final String password = "iwtbemjusxzzcfbl";
		
		Properties propNum = new Properties();
		propNum.put("mail.smtp.host", "smtp.gmail.com");
		propNum.put("mail.smtp.port", 465);
		propNum.put("mail.smtp.auth", "true");
		propNum.put("mail.smtp.ssl.enable", "true");
		propNum.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(propNum, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
		
		try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));

            //수신자메일주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(searchEmail)); 

            // Subject
            message.setSubject("TIDY GAMES 비밀번호 재설정 인증번호입니다."); //메일 제목을 입력

            // Text
            message.setText("인증번호: " + num);    //메일 내용을 입력

            // send the message
            Transport.send(message); ////전송
            System.out.println("메일 발송 성공!");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

		return num;
	}
	
	public int updatePwd(Connection conn, String userId, String updatePwd) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int idCheck(Connection conn, String checkId) {
		
		//select문 --> 조회된 행수로 반환
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			
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
	
	public int nickCheck(Connection conn, String checkNick) {
		
		//select문 --> 조회된 행수로 반환
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nickCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkNick);
			
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
	
	public int insertMem(Connection conn, Member m) {
		
		// 데이터 추가
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertMem");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemId());
			pstmt.setString(2, m.getMemPwd());
			pstmt.setString(3, m.getMemNick());
			pstmt.setString(4, m.getMemName());
			pstmt.setString(5, m.getMemBirth());
			pstmt.setString(6, m.getMemPhone());
			pstmt.setString(7, m.getMemEmail());
			pstmt.setString(8, m.getMemGender());
			pstmt.setString(9, m.getMemAddress());
			pstmt.setString(10, m.getMemAgr());
			pstmt.setString(11, m.getMemCategory()); 

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

		public int updateMemberList(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemBirth());
			pstmt.setString(2, m.getMemId());
			pstmt.setString(3, m.getMemName());
			pstmt.setString(4, m.getMemNick());
			pstmt.setString(5, m.getMemGender());
			pstmt.setString(6, m.getMemEmail());
			pstmt.setString(7, m.getMemPhone());
			pstmt.setString(8, m.getMemAddress());
			pstmt.setString(9, m.getMemStatus());
			pstmt.setInt(10, m.getMemNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
		
	public int updateUserCheck(Connection conn, String userId, String userPwd) {
		
		// 조회 -> 조회된 행 있는지 확인
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("updateUserCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
	
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
	
	public int nickUpdateCheck(Connection conn, String checkNick, String checkId) {
		
		//select문 --> 조회된 행수로 반환
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nickUpdateCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkNick);
			pstmt.setString(2, checkId);
			
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
	
	public int updateMember(Connection conn, Member m) {
		
		//update문
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemPwd());
			pstmt.setString(2, m.getMemNick());
			pstmt.setString(3, m.getMemName());
			pstmt.setString(4, m.getMemBirth());
			pstmt.setString(5, m.getMemPhone());
			pstmt.setString(6, m.getMemEmail());
			pstmt.setString(7, m.getMemGender());
			pstmt.setString(8, m.getMemAddress());
			pstmt.setString(9, m.getMemAgr());
			pstmt.setString(10, m.getMemCategory());
			pstmt.setString(11, m.getMemId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteMember(Connection conn, String userId) {
		
		//update문
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public ArrayList<Qna> myQnaList(Connection conn, int memNo, PageInfo pi) {
		
		ArrayList<Qna> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myQna");
		
		int startRow = (pi.getCurrentPage() - 1) * (pi.getViewLimit()) + 1;
		int endRow = startRow + pi.getViewLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Qna(
									rset.getInt("qna_no")
						          , rset.getString("qna_title")
						          , rset.getString("qna_content")
						          , rset.getString("report_date")
						          , rset.getString("ans_content")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int qnaListCount(Connection conn, int memNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("qnaListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}
	

	public int gameQnaCount(Connection conn, int memNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("gameQnaCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
		
	}
	
	public ArrayList<Qna> myGameQna(Connection conn, int memNo, PageInfo pi) {
		
		ArrayList<Qna> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myGameQna");
		
		int startRow = (pi.getCurrentPage() - 1) * (pi.getViewLimit()) + 1;
		int endRow = startRow + pi.getViewLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Qna(
									rset.getInt("gqna_no")
						          , rset.getString("company_name")
						          , rset.getString("gqna_title")
						          , rset.getString("gqna_content")
						          , rset.getString("gqna_date")
						          , rset.getString("gqna_answer")
						          , rset.getString("eng_name")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Review> myReviewList(Connection conn, int memNo) {
		
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("review_no")
								  , rset.getString("contents")
								  , rset.getInt("recommend")
								  , rset.getString("upload_date")
								  , rset.getInt("star_no")
								  , rset.getString("kor_name")
								  , rset.getString("eng_name")
								  , rset.getString("game_img")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Game> library(Connection conn, int memNo, String search) {
		
		Game g;
		ArrayList<Game> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("library");
		
		System.out.println(search);
		
		if(search.equals("이름순")) {
			sql += "ORDER BY ENG_NAME";
		}else if(search.equals("과거구매")) {
			sql += "ORDER BY PAY_DATE ASC";
		}else {
			sql += "ORDER BY PAY_DATE DESC";
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {

				g = new Game();
				g.setKorName(rset.getString("kor_name"));
				g.setEngName(rset.getString("eng_name"));
				g.setGameImg(rset.getString("game_img"));
				g.setCount(rset.getInt("star_no"));
				g.setUploadDate(rset.getString("pay_date"));
				g.setGameNo(rset.getInt("game_no"));
				
				list.add(g);			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Member> searchMemId(Connection conn, PageInfo pi, String word) {

		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchMemId");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getViewLimit() + 1;
			int endRow = startRow + pi.getViewLimit() - 1;

			pstmt.setString(1, word);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new Member(rset.getInt("mem_no")
						  , rset.getString("mem_id")
						  , rset.getString("mem_nick")
						  , rset.getString("mem_name")
						  , rset.getString("mem_phone")
						  , rset.getString("mem_email")
						  , rset.getString("mem_gender")
						  , rset.getString("mem_address")
						  , rset.getDate("mem_indate")
						  , rset.getString("mem_status")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
		
}
