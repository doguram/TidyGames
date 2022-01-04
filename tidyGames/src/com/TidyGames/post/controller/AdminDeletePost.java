package com.TidyGames.post.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.post.model.service.PostService;

/**
 * Servlet implementation class AdminDeletePost
 */
@WebServlet("/deleteAll.po")
public class AdminDeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeletePost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String[] deleteNum = request.getParameterValues("deleteNum");
		int result = 0;
		
		for(String postNo : deleteNum) {
			result = new PostService().deletePost(Integer.parseInt(postNo));
		}
		
		if(result > 0) { 		
			request.getSession().setAttribute("alertMsg", "총 " + deleteNum.length + " 개의 게시물을 삭제하셨습니다.");
			response.sendRedirect(request.getContextPath() + "/list.po?cpage="+currentPage);
		}else { 
			request.setAttribute("errorMsg", "글 삭제에 실패하셨습니다!");
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
