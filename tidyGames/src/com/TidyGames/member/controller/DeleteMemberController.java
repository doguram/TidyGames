package com.TidyGames.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TidyGames.member.model.service.MemberService;
import com.TidyGames.member.model.vo.Member;

/**
 * Servlet implementation class DeleteMemberController
 */
@WebServlet("/delete.me")
public class DeleteMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getMemId();
		
		int result = new MemberService().deleteMember(userId);
	
		if(result > 0) {
			// 로그아웃처리(session 모두 삭제) 시키고 쿠키 삭제
			session.invalidate();
			
			Cookie[] cookies = request.getCookies();
		    if(cookies != null){
		        for(Cookie c : cookies){
		            if(c.getName().equals("MemSessionId")){
		            	// 기존의 MemSessionId변수에 저장되어있던 키밸류 쿠키를 
		            	// 새롭게 cookie라는 변수에 저장시키면서 밸류값을 null로 변환하여 다시 서버에 추가
		            	Cookie cookie = new Cookie("MemSessionId", null);
		                cookie.setMaxAge(0);
		                cookie.setPath("/");
		                response.addCookie(cookie);
		            } 
		        }
		    }
			
		    // 페이지 이동
			request.getRequestDispatcher("views/member/deleteUserFinish.jsp").forward(request, response);
			
		} else {
			session.setAttribute("alertMsg", "회원탈퇴에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/updateUserPage.me");
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
