package com.TidyGames.pay.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.member.model.vo.Member;
import com.TidyGames.pay.model.service.PayService;
import com.TidyGames.pay.model.vo.PayGame;

/**
 * Servlet implementation class OrderSearchController
 */
@WebServlet("/orderSearch.pa")
public class OrderSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		String keyword = request.getParameter("keyword");
		// ----------페이징 처리-------------
		int listCount; // 현재 총 게시글 갯수
		int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지 cpage=""에 들어갈 숫자)
		int pageLimit; // 페이지 하단에 보여질 페이징바에 페이지 최대갯수(몇개 단위씩)
		int viewLimit; // 한 페이지내에 보여질 게시글 최대 갯수(몇개 단위씩)
		
		// 몇번 페이지를 요청했는지에 따라서 첫숫자와 끝숫자가 달라짐(12번 선택시 11번과 20번)
		//위의 4개를 가지고 아래 3개의 값을 구해낼꺼임
		int maxPage; // 가장 마지막 페이지(총페이지수)
		int startPage; // 페이징바의 시작수
		int endPage; // 페이징바의 끝수
		
		listCount = new PayService().orderListCount(memNo);
		
		// membersidebar, payviewController에 작성해놓음
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		// * pageLimit : 페이징바의 페이지 최대 갯수(단위)
		pageLimit = 10;
		
		// * boardLimit : 게시글 최대 갯수(단위)
		viewLimit = 10;
		
		//maxPage : 제일 마지막 페이지수(총페이지수)
		maxPage = (int)(Math.ceil((double)listCount/viewLimit));
		
		//*startPage : 시작수
		 
		startPage = (currentPage -1 ) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,viewLimit, maxPage, startPage, endPage);
		
		ArrayList<PayGame> order = new PayService().orderSearch(memNo, keyword, pi);  
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("order", order);
	
		
		request.getRequestDispatcher("views/pay/orderHistoryView.jsp").forward(request, response);
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
