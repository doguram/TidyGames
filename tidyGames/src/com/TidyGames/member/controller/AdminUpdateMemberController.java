package com.TidyGames.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.member.model.service.MemberService;
import com.TidyGames.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/updateMember.me")
public class AdminUpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUpdateMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int memNo = Integer.parseInt(request.getParameter("memNo"));
			String memBirth = request.getParameter("memBirth");
			String memId = request.getParameter("memId");
			String memName = request.getParameter("memName");
			String memNick = request.getParameter("memNick");
			String memGender = request.getParameter("memGender");
			String memPhone = request.getParameter("memPhone");
			String memEmail = request.getParameter("memEmail");
			String memAddress = request.getParameter("memAddress");
			String memDate = request.getParameter("memDate");
			String memStatus = request.getParameter("memStatus");
			
			
			Member m = new Member();
			m.setMemNo(memNo);
			m.setMemBirth(memBirth);
			m.setMemId(memId);
			m.setMemName(memName);
			m.setMemNick(memNick);
			m.setMemGender(memGender);
			m.setMemPhone(memPhone);
			m.setMemEmail(memEmail);
			m.setMemAddress(memAddress);
			m.setDate(memDate);
			m.setMemStatus(memStatus);
			
			
			
			int result = new MemberService().updateMemberList(m);
			
			if(result > 0) {
				
				response.setContentType("text/html; charset=UTF-8");
				 
				PrintWriter out = response.getWriter();
				 
				out.println("<script>alert('수정되었습니다.'); location.href='" + request.getContextPath() + "/memberList.me?cpage=1';</script>");
				 
				out.flush();
				
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
