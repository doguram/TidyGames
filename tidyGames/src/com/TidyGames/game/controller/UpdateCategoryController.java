package com.TidyGames.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.game.model.service.CategoryService;
import com.TidyGames.game.model.vo.Category;

/**
 * Servlet implementation class UpdateCategoryController
 */
@WebServlet("/updateCategory.ga")
public class UpdateCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String upCate = request.getParameter("upCate");
		String inCate = request.getParameter("inCate");
		
		Category c = new Category();
		c.setCategoryName(upCate);
		c.setCheckCategoryName(inCate);
		
		int result = new CategoryService().updateCategory(c);
		
		if(result > 0) {
			
		}else {
			
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
