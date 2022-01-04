package com.TidyGames.pay.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.member.model.vo.Member;
import com.TidyGames.pay.model.service.PayService;
import com.TidyGames.pay.model.vo.Refund;

/**
 * Servlet implementation class RefundEnrollController
 */
@WebServlet("/reEnroll.pa")
public class RefundEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		String refund = request.getParameter("why");
		String addWriting = request.getParameter("addtext");
		
		Refund re = new Refund();
		
		re.setMemNo(memNo);
		re.setOrderNo(orderNo);
		re.setRefund(refund);
		re.setAddWriting(addWriting);
		
		
		int result = new PayService().enrollRefund(re);
		
		
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "환불요청이 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/orderHistory.pa?cpage=1");
		
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
