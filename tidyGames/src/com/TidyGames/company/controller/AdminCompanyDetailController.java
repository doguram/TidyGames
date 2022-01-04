package com.TidyGames.company.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.company.model.service.AdminCompanyService;
import com.TidyGames.company.model.vo.Company;
import com.TidyGames.game.model.vo.Game;

/**
 * Servlet implementation class AdminCompanyDetailController
 */
@WebServlet("/detail.co")
public class AdminCompanyDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCompanyDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int companyNo = Integer.parseInt(request.getParameter("num"));
		
		Company c = new AdminCompanyService().selectCompanyDetail(companyNo);
		ArrayList<Game> gameList = new AdminCompanyService().selectGameList(companyNo);
			
		request.setAttribute("company", c);
		request.setAttribute("gameList", gameList);
		request.getRequestDispatcher("views/company/adminCompanyDetailView.jsp").forward(request,response);
			

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
