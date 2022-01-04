package com.TidyGames.pay.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.pay.model.service.PayService;
import com.TidyGames.pay.model.vo.Refund;

/**
 * Servlet implementation class AdminRefundSearchController
 */
@WebServlet("/adRefundSearch.pa")
public class AdminRefundSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRefundSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String refundSearch = request.getParameter("refundSearch");
		String keyword = request.getParameter("keyword");
		
		
		if(refundSearch.equals("memId")) {
			ArrayList<Refund> list = new PayService().adRefundMemIdSearch(keyword);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/pay/adminRefundListView.jsp").forward(request, response);
		}else {
			ArrayList<Refund> list = new PayService().adRefundorderNoSearch(keyword);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/pay/adminRefundListView.jsp").forward(request, response);
			
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
