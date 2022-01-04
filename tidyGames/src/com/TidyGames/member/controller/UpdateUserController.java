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
 * Servlet implementation class UpdateUserController
 */
@WebServlet("/updateUser.me")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserController() {
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
		String address = request.getParameter("address");	// "" | "주소값~~"
		String[] categoryArr = request.getParameterValues("category");
		String agree = request.getParameter("agree");
		
		// address가 ""인지 확인하는 작업
		// ""이라면 null반환. 굳이 안해도 되지만 가입할때 값을 안받으면 null이기 때문에 통일성을 주려고...!
		// 가입시 address가 null이면 ""로 받도록 작업하는 방법도 있음
		if(address.equals("")) {
			address = null;
		}
		
		// categoryArr 배열을 문자열로 바꾸는 작업 
		String category = "";
		if(categoryArr != null) {
			category = String.join(",", categoryArr);
		} else {
			category = null;
		}
		
		// agree가 null인지 확인하는 작업 (null이라면 'N' 반환)
		if(agree == null || agree.equals("")) {
			agree = "N";
		}
		
		Member m = new Member(userId, userPwd, userNick, userName, birth, phone, email, gender, address, agree, category);
		//System.out.println(userId + "\n" + userPwd + "\n" + userNick + "\n" + userName + "\n" + birth + "\n" + phone + "\n" + email + "\n" + gender + "\n" + address + "\n" + category + "\n" + agree);
		
		int result = new MemberService().updateMember(m);
		
		if(result > 0) {
			// 1) 업데이트 성공시 alert 띄우고 
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원 정보 수정이 완료되었습니다.");
			
			// 2) 세션에 담겨있는 loginUser정보 새로운 정보로 다시 담기
			// 일단 조회부터 다시 해온뒤에
			Member loginUser = new MemberService().loginMember(userId, userPwd);
			// 담기!
			session.setAttribute("loginUser", loginUser); // 세션에 다시 저장
			
			// 3) 마이페이지 첫화면 이동
			response.sendRedirect(request.getContextPath() + "/myPage.me");
			
		} else {
			// 업데이트 실패시 alert 띄우고 다시 정보수정창
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원 정보 수정에 실패하였습니다.");
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
