package com.TidyGames.pay.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.member.model.service.PointService;
import com.TidyGames.member.model.vo.Member;
import com.TidyGames.member.model.vo.Point;
import com.TidyGames.pay.model.service.PayService;
import com.TidyGames.pay.model.vo.Cart;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/order.pa")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
	
		
		ArrayList<Cart> cart = new PayService().selectCart(memNo);  
		
		request.setAttribute("cart", cart);
	
		Point sum = new PointService().sumPoint(memNo);
		
		request.setAttribute("sum", sum);
		
	
	
		request.getRequestDispatcher("views/pay/payView.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
