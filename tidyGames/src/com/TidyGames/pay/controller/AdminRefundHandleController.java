package com.TidyGames.pay.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.pay.model.service.PayService;
import com.TidyGames.pay.model.vo.Pay;
import com.TidyGames.pay.model.vo.PayGame;
import com.TidyGames.pay.model.vo.Refund;

/**
 * Servlet implementation class AdminRefundHandleController
 */
@WebServlet("/adRefundHandle.pa")
public class AdminRefundHandleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRefundHandleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		int orderNo = Integer.parseInt(request.getParameter("ono"));
		
		
		ArrayList<PayGame> order = new PayService().rforderList(memNo, orderNo);  
		
		
		request.setAttribute("order", order);
		
		Pay pi = new PayService().payInfo(memNo, orderNo);
		
		request.setAttribute("pi", pi);
		
		Refund re = new PayService().refundContent(memNo, orderNo);
		
		request.setAttribute("re", re);
		request.getRequestDispatcher("views/pay/adminRefundHandleView.jsp").forward(request, response);
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
