package com.TidyGames.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TidyGames.game.model.service.GameService;
import com.TidyGames.game.model.vo.Review;

/**
 * Servlet implementation class ReviewInsertController
 */
@WebServlet("/insert.ga")
public class ReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int gameNo = Integer.parseInt(request.getParameter("game"));
		String contents = request.getParameter("contents");
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		
		// 로그인한 회원정보 얻어내는 방법 
		// 1. input type="hidden"
		// 2. session영역에 담겨있는 회원객체로부터 뽑기
	
		Review r = new Review();
		r.setGameNo(gameNo);
		r.setContents(contents);
		r.setWriter(String.valueOf(memNo));
		
		int result = new GameService().insertReview(r);
		
		if(result > 0) { // 성공 
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "리뷰작성이 완료되었습니다!");
			response.sendRedirect(request.getContextPath() + "/reviewList.ga");
			
		}else { // 실패 => 리뷰목록페이지 내 글 x(뒤로가기?)
			
			request.setAttribute("errorMsg", "리뷰작성 실패ㅠㅠ");
			response.sendRedirect(request.getContextPath() + "/reviewList.ga");
			
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
