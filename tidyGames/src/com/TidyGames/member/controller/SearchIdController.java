package com.TidyGames.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TidyGames.member.model.service.MemberService;
import com.TidyGames.member.model.vo.Member;

/**
 * Servlet implementation class SearchIdController
 */
@WebServlet("/searchId.me")
public class SearchIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String searchName = request.getParameter("searchName");
		String searchEmail = request.getParameter("searchEmail");
		
		Member searchId = new MemberService().searchUserId(searchName, searchEmail);
				
			if(searchId == null) { // 입력한 이름,이메일 불일치
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "입력한 정보와 일치하는 회원이 없습니다.");
				
				response.sendRedirect(request.getContextPath() + "/inputSearchId.me");
			} else { // 입력한 이름, 이메일 일치
				HttpSession session = request.getSession();
				session.setAttribute("searchId", searchId);
				
				request.getRequestDispatcher("views/member/findId.jsp").forward(request, response);
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
