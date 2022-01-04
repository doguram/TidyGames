package com.TidyGames.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.qna.model.service.QnaService;
import com.TidyGames.qna.model.vo.Qna;

/**
 * Servlet implementation class CompanyGameQnaQuestionController
 */
@WebServlet("/question.gq")
public class CompanyGameQnaQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyGameQnaQuestionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int gameNo = Integer.parseInt(request.getParameter("gameno"));
		
		Qna gq = new QnaService().gameQnaQuestion(gameNo);
		
		request.setAttribute("gq", gq);
		
		request.getRequestDispatcher("views/qna/companyGameQnaQuestion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
