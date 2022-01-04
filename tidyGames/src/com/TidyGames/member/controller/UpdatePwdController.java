package com.TidyGames.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.member.model.service.MemberService;

/**
 * Servlet implementation class UpdatePwdController
 */
@WebServlet("/updatePwd.me")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String updatePwd = request.getParameter("updatePwd");
		
		int result = new MemberService().updatePwd(userId, updatePwd);
		
		if(result > 0) {
			// 비밀번호 양식에 맞게 잘 입력해서 변경 성공!
			// 변경 성공창으로 보내기
			request.getRequestDispatcher("views/member/updatePwdFinish.jsp").forward(request, response);	
			
		} else {
			// 비밀번호 변경 실패시... 이긴한데
			// 양식에 안맞으면 애초에 이 servlet으로 올 수 없음
			// 후에 뭔가 올만한 방법이 있는것같으면 에러코드 추가예정
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
