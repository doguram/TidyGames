package com.TidyGames.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.faq.model.service.FaqService;

/**
 * Servlet implementation class FaqInsertController
 */
@WebServlet("/faqInsert.fa")
public class FaqInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int result = new FaqService().insertFaq(userId, title, content);
		 
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 글이 등록되었습니다.");
			response.sendRedirect(request.getContextPath() + "/faqList.fa");
		} else {
			request.getSession().setAttribute("alertMsg", "게시글 등록에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/faqEnrollForm.fa");
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
