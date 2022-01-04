package com.TidyGames.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.member.model.service.WishListService;
import com.TidyGames.member.model.vo.Member;
import com.TidyGames.member.model.vo.WishList;

/**
 * Servlet implementation class MyWishListDeleteController
 */
@WebServlet("/wishDe.me")
public class MyWishListDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyWishListDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		int gameNo =  Integer.parseInt(request.getParameter("gameNo"));
		
		
		WishList d = new WishList();
		d.setMemNo(memNo);
		d.setGameNo(gameNo);
		
		
		int result = new WishListService().deleteWish(d);
		
		
		
		if(result > 0) {
			
			response.getWriter().print(result);
			
		
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
