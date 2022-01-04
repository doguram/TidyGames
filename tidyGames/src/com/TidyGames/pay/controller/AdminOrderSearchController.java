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

/**
 * Servlet implementation class AdminOrderSearchController
 */
@WebServlet("/adOrderSearch.pa")
public class AdminOrderSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String orderSearch = request.getParameter("orderSearch");
		String keyword = request.getParameter("keyword");
		
	
		
		if(orderSearch.equals("memId")) {
		
		ArrayList<Pay> list = new PayService().adOrderMemIdSearch(keyword);  
		
		request.setAttribute("list", list);
	
		request.getRequestDispatcher("views/pay/adminOrderHistoryView.jsp").forward(request, response);
		}else if(orderSearch.equals("orderNo")) {
		
			
			
			ArrayList<Pay> list = new PayService().adOrderorderNoSearch(keyword);  
			
			request.setAttribute("list", list);
		
			request.getRequestDispatcher("views/pay/adminOrderHistoryView.jsp").forward(request, response);	
			
			
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
