package com.TidyGames.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.TidyGames.common.MyFileRenamePolicy;
import com.TidyGames.notice.model.service.NoticeService;
import com.TidyGames.notice.model.vo.Notice;
import com.TidyGames.notice.model.vo.NoticeFile;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/noticeUpdate.no")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {	//enctype이 multi타입일때만 true 반환
			
			int maxSize = 100*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int notiNo = Integer.parseInt(multiRequest.getParameter("num"));	//글번호
			String title = multiRequest.getParameter("title");	// 변경된 글제목
			String content = multiRequest.getParameter("content");	// 변경된 글내용
			
			String check1 = multiRequest.getParameter("fileCheck1");	// 1번 파일에 대한 변경사항
			String check2 = multiRequest.getParameter("fileCheck2");	// 2번 파일에 대한 변경사항
			String check3 = multiRequest.getParameter("fileCheck3");	// 3번 파일에 대한 변경사항

			ArrayList<NoticeFile> fileList = new NoticeService().selectFileList(notiNo);
			// 기존의 fileList 가져오기
			// null일수도 있음
			
			Notice n = new Notice();
			n.setNotiNo(notiNo);
			n.setNotiTitle(title);
			n.setNotiContent(content);
			ArrayList<NoticeFile> list = new ArrayList<>();
			
			for(int i=1; i<=3; i++) {
				String key = "file" + i;
				
				if(multiRequest.getOriginalFileName(key) != null) {	// 넘어온 첨부파일이 있다면
				
					NoticeFile nf = new NoticeFile(); 
					nf.setFileOrigin(multiRequest.getOriginalFileName(key));
					nf.setFileChange(multiRequest.getFilesystemName(key));
					nf.setFilePath("resources/notice_upfiles/");
					
					list.add(nf);	// NoticeFile nf 객체에 넘어온 파일 정보 저장한 뒤 list에 추가
									// 넘어온 첨부파일이 3개면 list 크기는 3개, 아니면 2개....
				} 
				
			}
			
			/*
			if(fileList.isEmpty() == false) {
				for(int i=0; i<fileList.size(); i++) {
					System.out.println(fileList.get(i));
					System.out.println(fileList.get(i).getFileNo());
				}
			} else if(fileList.isEmpty() == true) {
				System.out.println("fileList는 비어져있습니다.");
			}
			
			System.out.println("Notice: " + n);
			System.out.println("list: " + list);
			System.out.println("check1: " + check1);
			System.out.println("check2: " + check2);
			System.out.println("check3: " + check3);
			 */
			
			int result = new NoticeService().updateNotice(n, list, check1, check2, check3, fileList);
			
			if(result > 0) {	// 성공적으로 글 업데이트시
				request.getSession().setAttribute("alertMsg", "게시글 수정에 성공하였습니다.");
				response.sendRedirect(request.getContextPath() + "/noticeDetail.no?cpage=1&num=" + n.getNotiNo());
			} else {
				
				for(NoticeFile f : list) {
					new File(savePath + f.getFileChange()).delete();					
				}
				
				request.getSession().setAttribute("alertMsg", "게시글 수정에 실패하였습니다.");
				response.sendRedirect(request.getContextPath() + "/noticeUpdatePage.no?num=" + n.getNotiNo());
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
