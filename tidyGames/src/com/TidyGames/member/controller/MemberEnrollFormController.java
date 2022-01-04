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
 * Servlet implementation class MemberEnrollFormController
 */
@WebServlet("/memberEnrollForm.me")
public class MemberEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userNick = request.getParameter("userNick");
		String userName = request.getParameter("userName");
		String birth = request.getParameter("year") + "/" + request.getParameter("month") + "/" + request.getParameter("day");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String[] categoryArr = request.getParameterValues("category");
		String agree = request.getParameter("agree");
		
		// categoryArr 배열을 문자열로 바꾸는 작업 
		String category = "";
		if(categoryArr != null) {
			category = String.join(",", categoryArr);
		}
		
		// agree가 null인지 확인하는 작업 (null이라면 'N' 반환)
		if(agree == null || agree.equals("")) {
			agree = "N";
		}
		
		Member m = new Member(userId, userPwd, userNick, userName, birth, phone, email, gender, address, agree, category);
		
		/* 잘 담겼나 확인용
		System.out.println(userId + "\n" + userPwd + "\n" + userNick + "\n" + userName + "\n" + birth + "\n" + phone + "\n" + email + "\n" + gender + "\n" + address + "\n" + category + "\n" + agree);
		*/
		
		int result = new MemberService().insertMem(m);
		
		if(result > 0) {
			// 회원 추가 성공!
			HttpSession session = request.getSession();
			session.setAttribute("insertId", m.getMemId());
			request.getRequestDispatcher("views/member/enrollFormFinish.jsp").forward(request, response);
		} else {
			// 회원 추가 실패
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/memberEnrollPage.me");
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
