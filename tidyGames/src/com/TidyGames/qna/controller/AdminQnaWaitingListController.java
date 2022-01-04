package com.TidyGames.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.qna.model.service.QnaService;
import com.TidyGames.qna.model.vo.Qna;

/**
 * Servlet implementation class adminQnaWaitingListController
 */
@WebServlet("/qnaList.no")
public class AdminQnaWaitingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQnaWaitingListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount;
		int currentPage;
		int pageLimit;
		int viewLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new QnaService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		pageLimit = 10;
		viewLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / viewLimit);
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, viewLimit, maxPage, startPage, endPage);
		
		ArrayList<Qna> list = new QnaService().qnaWaitList(pi);
		
		
		if(!list.isEmpty()) {			
			request.setAttribute("pi", pi);	
			request.setAttribute("list", list);
		}
			
		request.getRequestDispatcher("views/qna/adminQnaWaitingList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
