package com.TidyGames.pay.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.pay.model.service.PayService;

/**
 * Servlet implementation class AdminRefundUpdateController
 */
@WebServlet("/reupdate.pa")
public class AdminRefundUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRefundUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderNo = Integer.parseInt(request.getParameter("oNo"));
		
		
		int result1 = new PayService().refundUpdate(orderNo);
		
		int result2 =  new PayService().refundUpdate2(orderNo);
		if(result1 > 0  && result2 >0) {
			request.getSession().setAttribute("alertMsg", "환불처리가 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/adrefund.pa");
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
