package com.TidyGames.company.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.company.model.service.AdminCompanyService;
import com.TidyGames.company.model.vo.Company;

/**
 * Servlet implementation class AdminCompanyUpdateFormController
 */
@WebServlet("/updateForm.co")
public class AdminCompanyUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCompanyUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int companyNo = Integer.parseInt(request.getParameter("num"));
		
		Company c = new AdminCompanyService().selectCompanyDetail(companyNo);
		
		request.setAttribute("comp", c);
		
		request.getRequestDispatcher("views/company/adminCompanyUpdateForm.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
