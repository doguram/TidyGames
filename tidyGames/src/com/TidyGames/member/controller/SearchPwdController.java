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
 * Servlet implementation class SearchPwdController
 */
@WebServlet("/searchPwd.me")
public class SearchPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String searchId = request.getParameter("searchId");
		String searchEmail = request.getParameter("searchEmail");
		
		Member searchUser = new MemberService().searchUserPwd(searchId, searchEmail);
		// 아이디와 이메일을 제대로 입력했는지 확인하는 과정
		
		if(searchUser != null) { 
			//아이디와 이메일을 제대로 입력했을경우 -> 인증번호 보낸 뒤 인증번호jsp로 이동
			//인증번호값 session에 저장
			//입력한 아이디, 이메일 값담긴 Member searchUser session에 저장
			HttpSession session = request.getSession();
			int num = new MemberService().checkNum(searchEmail);

			session.setAttribute("pwdCheckNum", num);
			session.setAttribute("searchUser", searchUser);
			request.getRequestDispatcher("views/member/searchPwdNumCheck.jsp").forward(request, response);

		} else { 
			// 아이디와 이메일이 일치하지 않으면 alert 띄우고 다시 입력페이지로
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "아이디와 이메일주소가 일치하지 않습니다.");
			response.sendRedirect(request.getContextPath() + "/inputSearchPwd.me");
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
