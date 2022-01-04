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
import com.TidyGames.pay.model.service.PayService;
import com.TidyGames.pay.model.vo.Cart;

/**
 * Servlet implementation class MyWishListInsertController
 */
@WebServlet("/wishInsert.me")
public class MyWishListInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyWishListInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		int gameNo =  Integer.parseInt(request.getParameter("gameNo"));
	
		
		
		WishList wish = new WishList();
		
		wish.setMemNo(memNo);
		wish.setGameNo(gameNo);
		
		
			int result = new WishListService().insertWish(wish);
			
			
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
