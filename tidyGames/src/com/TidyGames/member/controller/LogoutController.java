package com.TidyGames.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout.me")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("alertMsg", "정상적으로 로그아웃 되었습니다.");
		
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
	            } else if(c.getName().equals("ComSessionId")) {
	            	Cookie cookie = new Cookie("ComSessionId", null);
	                cookie.setMaxAge(0);
	                cookie.setPath("/");
	                response.addCookie(cookie);
	            }
	        }
	    }
		
		response.sendRedirect(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
