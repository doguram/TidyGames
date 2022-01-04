package com.TidyGames.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.post.model.service.PostService;
import com.TidyGames.post.model.vo.Post;

/**
 * Servlet implementation class PostUpdateController
 */
@WebServlet("/update.po")
public class PostUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Post p = new Post();
		p.setPostNo(postNo);
		p.setPostName(title);
		p.setPostContent(content);
		int result = new PostService().updatePost(p);
		
		if(result > 0) { 		
			request.getSession().setAttribute("alertMsg", "게시글을 수정하였습니다");
			response.sendRedirect(request.getContextPath() + "/detail.po?cpage="+currentPage+"&num="+postNo);
		}else { 
			request.setAttribute("errorMsg", "게시글 수정 실패!");
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
