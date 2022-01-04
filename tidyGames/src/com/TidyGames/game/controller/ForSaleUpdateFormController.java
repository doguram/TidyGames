package com.TidyGames.game.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.game.model.service.CategoryService;
import com.TidyGames.game.model.service.GameService;
import com.TidyGames.game.model.vo.Attachment3;
import com.TidyGames.game.model.vo.Category;
import com.TidyGames.game.model.vo.Game;
import com.TidyGames.member.model.vo.Member;

/**
 * Servlet implementation class CompanyGameUpdateController
 */
@WebServlet("/forsaleupdateform.ga")
public class ForSaleUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForSaleUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int gameNo = Integer.parseInt(request.getParameter("gno"));
		
		Game g = new GameService().forSaleGame(gameNo);
		ArrayList<Attachment3> alist = new GameService().selectAttachmentList(gameNo);
		ArrayList <Category> list = new CategoryService().selectCategoryList();
		
		request.setAttribute("g", g);
		request.setAttribute("alist", alist);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/game/forSaleUpdateForm.jsp").forward(request, response);
		
		/*
		 * int gameNo = Integer.parseInt(request.getParameter("gno"));
		 * 
		 * 
		 * Game g = new GameService().forSaleGame(gameNo); ArrayList<Attachment3> alist
		 * = new GameService().selectAttachmentList(gameNo); ArrayList <Category> list =
		 * new CategoryService().selectCategoryList();
		 * 
		 * request.setAttribute("g", g); request.setAttribute("alist", alist);
		 * request.setAttribute("list", list);
		 * request.getRequestDispatcher("views/game/forSaleUpdateForm.jsp").forward(
		 * request, response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
