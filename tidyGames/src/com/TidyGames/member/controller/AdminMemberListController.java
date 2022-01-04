package com.TidyGames.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.member.model.service.MemberService;
import com.TidyGames.member.model.vo.Member;
import com.TidyGames.report.model.service.ReportService;

/**
 * Servlet implementation class adminMemberListController
 */
@WebServlet("/memberList.me")
public class AdminMemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberListController() {
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
		
		String word = request.getParameter("word");
		
		System.out.println(word);
		
		listCount = new MemberService().selectMemberCount();
		// 현재 총 게시물이 몇 개인지 알아올 메소드
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		pageLimit = 10;
		viewLimit = 13;
		
		maxPage = (int)Math.ceil((double)listCount / viewLimit);
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, viewLimit, maxPage, startPage, endPage);
		
		ArrayList<Member> list = new ArrayList<>();
		
		if(word==null) {
			list = new MemberService().selectMemberList(pi);
		}else {
			list = new MemberService().searchMemId(pi, word);
		}
			

		request.setAttribute("pi", pi);	
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/member/adminMemberList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
