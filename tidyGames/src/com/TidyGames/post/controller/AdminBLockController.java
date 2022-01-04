package com.TidyGames.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.post.model.service.PostService;

/**
 * Servlet implementation class AdminBLockController
 */
@WebServlet("/block.po")
public class AdminBLockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBLockController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memNick = request.getParameter("nickb");
		int currentPage = Integer.parseInt(request.getParameter("cpage"));

		int result = new PostService().blockMember(memNick);
		
		if(result > 0) { 		
			request.getSession().setAttribute("alertMsg", memNick + " 회원을 블락했습니다!");
			response.sendRedirect(request.getContextPath() + "/list.po?cpage="+currentPage);
		}else { 
			request.setAttribute("errorMsg", "블락 처리에 실패하셨습니다!");
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