package com.TidyGames.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeListDeleteController
 */
@WebServlet("/noticeListDelete.no")
public class NoticeListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 삭제할 noticeNo들이 담겨있는 배열
		String[] notices = request.getParameterValues("deleteNum");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int result = new NoticeService().deleteNotices(notices);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 삭제되었습니다.");
			response.sendRedirect(request.getContextPath() + "/notice.no?cpage=" + currentPage);
		} else {
			request.getSession().setAttribute("alertMsg", "삭제에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/notice.no?cpage=" + currentPage);
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
