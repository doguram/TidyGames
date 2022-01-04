package com.TidyGames.faq.model.service;

import static com.TidyGames.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.faq.model.dao.FaqDao;
import com.TidyGames.faq.model.vo.Faq;

public class FaqService {

	public ArrayList<Faq> selectList(){
		
		Connection conn = getConnection();
		
		ArrayList<Faq> list = new FaqDao().selectList(conn);
		
		close(conn);
		return list;
		
	}
	
	public int insertFaq(String userId, String title, String content) {
		
		Connection conn = getConnection();
		
		int result = new FaqDao().insertFaq(conn, userId, title, content);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int deleteFaq(String[] faqNos) {
		
		Connection conn = getConnection();
		
		// 배열 길이만큼의 빈 int배열 생성 : 값은 안담겨있지만 크기만 정해져있음
		int[] result = new int[faqNos.length];
		
		// 반복문 돌리면서 dao faqNos 0번 인덱스부터 한번씩 실행하고 result[1], result[2], ...에 담음
		for(int i=0; i<result.length; i++) {
			result[i] = new FaqDao().deleteFaq(conn, Integer.parseInt(faqNos[i]));
		}
		
		int check = 0;
		for(int i=0; i<result.length; i++) {
			if(result[i] <= 0) {
				// 한번이라도 dao에서 실행하지 못했다면 check = 1, 모두 성공했다면 check = 0
				check = 1;
				
				break;
			}
		}
		
		int num = 0;
		
		if(check == 0) {
			commit(conn);
			num = 1;
		} else {
			rollback(conn);
			num = 0;
		}
		
		close(conn);
		
		return num;
		
	}
	
	public Faq selectFaq(int faqNo) {
		
		Connection conn = getConnection();
		
		Faq f = new FaqDao().selectFaq(conn, faqNo);
		
		close(conn);
		return f;
		
	}
	
	public int updateFaq(int faqNo, String title, String content) {
		
		Connection conn = getConnection();
		
		int result = new FaqDao().updateFaq(conn, faqNo, title, content);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
}
