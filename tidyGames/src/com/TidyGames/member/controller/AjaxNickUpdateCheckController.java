package com.TidyGames.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.member.model.service.MemberService;

/**
 * Servlet implementation class AjaxNickUpdateCheckController
 */
@WebServlet("/nickUpdateCheck.me")
public class AjaxNickUpdateCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxNickUpdateCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String checkNick = request.getParameter("checkNick");
		String checkId = request.getParameter("checkId");
		
		int count = new MemberService().nickUpdateCheck(checkNick, checkId);
		
		if(count > 0) {
			// 이미 존재하는 닉네임 일 경우 (사용불가)
			response.getWriter().print("NNNNN");
		} else {
			// 존재하지 않는 닉네임 일경우 (사용가능)
			response.getWriter().print("NNNNY");
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
