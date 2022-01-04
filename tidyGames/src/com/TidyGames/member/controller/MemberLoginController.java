package com.TidyGames.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TidyGames.company.model.service.LoginCompanyService;
import com.TidyGames.company.model.vo.Company;
import com.TidyGames.member.model.service.MemberService;
import com.TidyGames.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/memberLogin.me")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String company = request.getParameter("companyCheck");
		String remember = request.getParameter("rememberMe");
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		Company loginCompany = new LoginCompanyService().loginCompany(userId, userPwd);
		
		if(company == null) { // 회원
			if(loginUser == null) {
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "아이디 혹은 비밀번호를 확인해주세요.");
				request.getRequestDispatcher("views/member/login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser); // 세션에 회원데이터 저장
				if(remember != null) {
					String sessionId = session.getId();
					// Member 테이블의 mem_cookie 컬럼에 값 업데이트
					int result = new MemberService().cookieUpdateMem(userId, sessionId);
					
					// 로그인시 자동 로그인 체크했다면 쿠키에 고유한 세션ID 저장! (서버 켜질때마다 다름)
					if(result > 0) { // mem_cookie컬럼에 값넣기 성공했을때
						Cookie MemSessionId = new Cookie("MemSessionId", session.getId());
						MemSessionId.setPath("/");
						int limitTime = 60*60*24*90;
						MemSessionId.setMaxAge(limitTime);
						
						response.addCookie(MemSessionId);
					} 
				}
				
				response.sendRedirect(request.getContextPath());
			}
		} else { // 게임사
			if(loginCompany == null) {
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "아이디 혹은 등록코드를 확인해주세요.");
				request.getRequestDispatcher("views/member/login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("loginCompany", loginCompany);
				
				if(remember != null) {
					String sessionId = session.getId();
					int result = new LoginCompanyService().cookieUpdateCom(userId, sessionId);
					
					if(result > 0) { 
						Cookie ComSessionId = new Cookie("ComSessionId", session.getId());
						ComSessionId.setPath("/");
						int limitTime = 60*60*24*90;
						ComSessionId.setMaxAge(limitTime);
						
						response.addCookie(ComSessionId);
					} 
				}
				response.sendRedirect(request.getContextPath());
			}
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
