package com.TidyGames.post.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.member.model.vo.Member;
import com.TidyGames.post.model.service.PostService;
import com.TidyGames.post.model.vo.PostLike;

/**
 * Servlet implementation class AjaxLikeDeleteController
 */
@WebServlet("/deletelike.po")
public class AjaxLikeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxLikeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postNo = Integer.parseInt(request.getParameter("pno"));
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		
		PostLike pl = new PostLike();
		pl.setLikePost(postNo);
		pl.setLikeMem(memNo);
		
		int result = new PostService().deleteLike(pl);
		int result2 = 1;
		
		if(result > 0) {
			result2 = new PostService().decreaseLike(postNo);
		}
		
		response.getWriter().print(result * result2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}