package com.TidyGames.notice.model.service;

import static com.TidyGames.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.faq.model.dao.FaqDao;
import com.TidyGames.notice.model.dao.NoticeDao;
import com.TidyGames.notice.model.vo.Notice;
import com.TidyGames.notice.model.vo.NoticeFile;

public class NoticeService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().selectListCount(conn);
		
		close(conn);
		return result;
	}
	
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn, pi);
		
		close(conn);
		return list;
		
	}
	
	public Notice selectNotice(int noticeNo) {
		
		Connection conn = getConnection();
		Notice n = new NoticeDao().selectNotice(conn, noticeNo);
		
		close(conn);
		return n;
		
	}
	
	public int firstNoticeNo() {
		
		Connection conn = getConnection();
		int result = new NoticeDao().firstNoticeNo(conn);
		
		close(conn);
		return result;
		
	}
	
	public int lastNoticeNo() {
		
		Connection conn = getConnection();
		int result = new NoticeDao().lastNoticeNo(conn);
		
		close(conn);
		return result;
		
	}
	
	public int insertNotice(Notice n, ArrayList<NoticeFile> list) {
		
		Connection conn = getConnection();
		
		int result1 = new NoticeDao().insertNotice(conn, n);
		int result2 = 1;	// 첨부파일이 안넘어왔으면 list 추가 없이 1로  return만 잘 넘어가게 함 (dao 안감)

		if(list != null) {	// 첨부파일이 넘어왔다면 list에 추가 (sql문 실행하러 dao)
			result2 = new NoticeDao().insertFile(conn, list);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2;
		
	}
	
	public ArrayList<NoticeFile> selectFileList(int notiNo) {
		
		Connection conn = getConnection();
		
		ArrayList<NoticeFile> fileList = new NoticeDao().selectFileList(conn, notiNo);
		
		close(conn);
		return fileList;
	}
	
	public int deleteNotice(int noticeNo) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteNotice(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int deleteNotices(String[] notices) {
		
		Connection conn = getConnection();
		
		// 배열 길이만큼의 빈 int배열 생성 : 값은 안담겨있지만 크기만 정해져있음
		int[] result = new int[notices.length];
		
		// 반복문 돌리면서 dao에서 0번 인덱스부터 한번씩 실행하고 result[1], result[2], ...에 담음
		for(int i=0; i<result.length; i++) {
			result[i] = new NoticeDao().deleteNotice(conn, Integer.parseInt(notices[i]));
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
	
	public int searchTitleCount(String word) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().searchTitleCount(conn, word);
		
		close(conn);
		return result;
		
	}
	
	public int searchContentCount(String word) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().searchContentCount(conn, word);
		
		close(conn);
		return result;
		
	}
	
	public ArrayList<Notice> searchTitleList(PageInfo pi, String word){
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectTitleList(conn, pi, word);
		
		close(conn);
		return list;
		
	}
	
	public ArrayList<Notice> searchContentList(PageInfo pi, String word){
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectContentList(conn, pi, word);
		
		close(conn);
		return list;
		
	}
	
	public int updateNotice(Notice n, ArrayList<NoticeFile> list, String check1, String check2, String check3, ArrayList<NoticeFile> fileList) {
		
		Connection conn = getConnection();
		
		int result1 = new NoticeDao().updateNotice(conn, n);	// notice 테이블 update
		int result2 = 1;	// 첨부파일이 안넘어왔으면 list 추가 없이 1로  return만 잘 넘어가게 함 (dao 안감)

		// file 상태값 변경 체크용 result
		// 만약에 실행했는데 실패했다면 0
		int result3 = 1;
		int result4 = 1;
		int result5 = 1;
		
		// 변경 혹은 삭제된 배열이 있다면 상태값을 n으로 바꿈
		if(fileList.isEmpty() == false) {	// fileList에 값이 원래 최소 1개 있었다면
			if(check1.equals("1")) {	// 1번 사진박스에 사진이 삭제되거나 변경되었을때
				int num1 = fileList.get(0).getFileNo();	// 원래 있던 첫번째 파일의 번호를 알아낸 뒤 num1에 저장하고 
				result3 = new NoticeDao().updateFileStatus(conn, num1);	// 해당 파일의 status를 n처리 한다.
			}
			if(check2.equals("1")) {	// 2번 사진박스에 사진이 삭제되거나 변경되었을때
				if(fileList.size() == 1) {	// 만약에 fileList에 파일이 1개밖에 없었다면 그냥 변경(추가)된거라 아무것도 안해도되고

				} else {	// 파일이 2개 이상이였다면 2번째 파일의 status를 n처리 한다. 
					int num2 = fileList.get(1).getFileNo();
					result4 = new NoticeDao().updateFileStatus(conn, num2);
				}
			}
			if(check3.equals("1")) {	// 3번 사진박스에 사진이 삭제되거나 변경되었을때
				if(fileList.size() <= 2) {	// 만약에 fileList에 파일이 2개 이하로 있었다면  그냥 변경(추가)된거라 아무것도 안해도되고
				
				} else {
					int num3 = fileList.get(2).getFileNo();
					result5 = new NoticeDao().updateFileStatus(conn, num3);
				}
			}
		}
		
		if(list != null) {	
			// 첨부파일이 넘어왔다면 list에 추가 (sql문 실행하러 dao)
			// 또한 어디가 변경된지 보고 배열에서 
			result2 = new NoticeDao().updateFile(conn, list, n.getNotiNo());
		}
		
		if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0 && result5 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2 * result3 * result4 * result5;
		
	}
	
}
