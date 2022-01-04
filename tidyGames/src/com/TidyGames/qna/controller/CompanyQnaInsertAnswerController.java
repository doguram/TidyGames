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
 * Servlet implementation class CompanyQnaAnswerController
 */
@WebServlet("/insertAnswer.gq")
public class CompanyQnaInsertAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyQnaInsertAnswerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int gqno = Integer.parseInt(request.getParameter("gqno"));
		String answer = request.getParameter("answer");
		
		Qna gq = new Qna();
		gq.setQnaAnswer(answer);
		gq.setQnaNo(gqno);
		
		int result = new QnaService().insertCompanyAnswer(gq);
		
		response.getWriter().print(result);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
