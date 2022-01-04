package com.TidyGames.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TidyGames.member.model.service.MemberService;

/**
 * Servlet implementation class UpdateUserPageController
 */
@WebServlet("/updateUserPage.me")
public class UpdateUserPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 받아온 id, 비밀번호 동일하면 내정보수정페이지로 넘겨주기
		// 아니면 alert띄우고 다시 비번 체크페이지
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new MemberService().updateUserCheck(userId, userPwd);
		
		if(result > 0) {
			request.getRequestDispatcher("views/member/updateUser.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "비밀번호를 다시 확인해주세요.");
			
			response.sendRedirect(request.getContextPath() + "/updateUserCheck.me");
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
