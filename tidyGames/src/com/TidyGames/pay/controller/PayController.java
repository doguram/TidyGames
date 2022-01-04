package com.TidyGames.pay.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TidyGames.member.model.vo.Member;
import com.TidyGames.pay.model.service.PayService;
import com.TidyGames.pay.model.vo.Cart;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/pay.pa")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		int payAmount = Integer.parseInt(request.getParameter("total"));
		String payMethod = request.getParameter("payment");
		String usePoint = request.getParameter("usePoint");
		int savePoint = Integer.parseInt(request.getParameter("savePoint"));
		int totalPrice = payAmount-Integer.parseInt(usePoint);
		String[] gameNo = request.getParameterValues("gameNo");
	
		
		int result = new PayService().insertPay(memNo, totalPrice, payMethod, gameNo, usePoint, savePoint);
		
		
		if(result > 0) {
		
			request.getSession().setAttribute("alertMsg", "결제가 성공적으로 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/orderHistory.pa?cpage=1");
			
			
		}else {
			
			//pay테이블에 insert 실패
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
