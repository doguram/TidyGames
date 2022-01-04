package com.TidyGames.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.notice.model.service.NoticeService;
import com.TidyGames.notice.model.vo.Notice;
import com.TidyGames.notice.model.vo.NoticeFile;

/**
 * Servlet implementation class NoticeUpdateFormController
 */
@WebServlet("/noticeUpdatePage.no")
public class NoticeUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		
		Notice n = new NoticeService().selectNotice(num); // 글번호 넘겨서 글정보 가져옴
		ArrayList<NoticeFile> fileList = new NoticeService().selectFileList(num); // 글번호 넘겨서 글 첨부파일 정보 가져옴
		
		request.setAttribute("noticeUpdate", n); // 해당 클릭한 글에 대한 정보
		request.setAttribute("noticeUpdateFileList", fileList); // 해당 클릭한 글에 대한 첨부파일
		
		request.getRequestDispatcher("views/notice/noticeUpdateForm.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
