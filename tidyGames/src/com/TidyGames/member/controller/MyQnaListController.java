package com.TidyGames.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.common.model.vo.Attachment;
import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.member.model.service.MemberService;
import com.TidyGames.member.model.vo.Member;
import com.TidyGames.qna.model.service.QnaService;
import com.TidyGames.qna.model.vo.Qna;
import com.TidyGames.report.model.service.ReportService;
/**
 * Servlet implementation class myQnaListController
 */
@WebServlet("/myQna.me")
public class MyQnaListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyQnaListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		
		int listCount;
		int currentPage;
		int pageLimit;
		int viewLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new MemberService().qnaListCount(memNo);
		// 현재 총 게시물이 몇 개인지 알아올 메소드
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		pageLimit = 5;
		viewLimit = 1;
		
		maxPage = (int)Math.ceil((double)listCount / viewLimit);
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, viewLimit, maxPage, startPage, endPage);
		ArrayList<Qna> list = new MemberService().myQnaList(memNo, pi);
		
		if(!list.isEmpty()) {
			int qno = list.get(0).getQnaNo();			
			Attachment at = new QnaService().selectAttachment(qno);
			
			request.setAttribute("at", at);
		}

		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/member/myQnaList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
