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
import com.TidyGames.pay.model.vo.Refund;

/**
 * Servlet implementation class AdminRefundDateController
 */
@WebServlet("/adRefundDate.pa")
public class AdminRefundDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRefundDateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		int memNo = ((Member) request.getSession().getAttribute("loginUser")).getMemNo();
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		String select = request.getParameter("select");
		
		
		if (start == "" || end == "") {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "날짜를 입력해주세요");
			
			
			response.sendRedirect(request.getContextPath()+"/adrefund.pa");
		} else {
			if (select.equals("all")) {
		ArrayList<Refund> list = new PayService().adAllRefundList(start, end);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/pay/adminRefundListView.jsp").forward(request, response);
		
			}else if(select.equals("confirm")) {
				ArrayList<Refund> list = new PayService().adComfirmRefundList(start, end);
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("views/pay/adminRefundListView.jsp").forward(request, response);
				
			}else {
				ArrayList<Refund> list = new PayService().adNoComfirmRefundList(start, end);
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("views/pay/adminRefundListView.jsp").forward(request, response);
				
			}
		
		
		
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
