package com.TidyGames.company.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.company.model.service.AdminCompanyService;

/**
 * Servlet implementation class AdminCompanyDeleteController
 */
@WebServlet("/delete.co")
public class AdminCompanyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCompanyDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int companyNo = Integer.parseInt(request.getParameter("num"));
		
		int result = new AdminCompanyService().deleteCompany(companyNo);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "해당 게임사 정보가 삭제되었습니다");
			response.sendRedirect(request.getContextPath() + "/list.co?cpage=1");
		} else {
			request.setAttribute("errorMsg", "게임사 삭제에 실패하셨습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
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
