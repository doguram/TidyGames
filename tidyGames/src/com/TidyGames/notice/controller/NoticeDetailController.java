package com.TidyGames.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TidyGames.notice.model.service.NoticeService;
import com.TidyGames.notice.model.vo.Notice;
import com.TidyGames.notice.model.vo.NoticeFile;

/**
 * Servlet implementation class NoticeDetailController
 */
@WebServlet("/noticeDetail.no")
public class NoticeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//PostService ps = new PostService();
		int noticeNo = Integer.parseInt(request.getParameter("num"));	// 사용자가 요청한 글번호	
		int currentPage = Integer.parseInt(request.getParameter("cpage"));	// 사용자가 요청한 글이 포함된 페이지
		
		Notice n = new NoticeService().selectNotice(noticeNo);	// 유효한 게시글인지 확인하고 조회해오기. 유효하지 않으면 null

		//PageInfo pi = new PageInfo();
		//pi.setCurrentPage(currentPage);

		if(n != null) {
			
			// 유효한 게시글이라면 해당 게시물번호를 이용하여 첨부파일 list 조회해오기
			ArrayList<NoticeFile> fileList = new NoticeService().selectFileList(n.getNotiNo());
			
			int firstNo = new NoticeService().firstNoticeNo();
			int lastNo = new NoticeService().lastNoticeNo();
			
			request.setAttribute("firstNo", firstNo);
			request.setAttribute("lastNo", lastNo);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("fileList", fileList);
			
			HttpSession session = request.getSession();
			session.setAttribute("noticeDetail", n);
			
			request.getRequestDispatcher("views/notice/noticeDetailView.jsp").forward(request, response);
			
		}else {
			request.setAttribute("errorMsg", "글 조회에 실패하셨습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
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
