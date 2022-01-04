package com.TidyGames.post.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.post.model.service.PostService;
import com.TidyGames.post.model.vo.PostFile;

/**
 * Servlet implementation class PostDeleteController
 */
@WebServlet("/delete.po")
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postNo = Integer.parseInt(request.getParameter("num"));
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		String savePath = request.getSession().getServletContext().getRealPath("/resources/post_upfiles/");
		
		int result = new PostService().deletePost(postNo);
		
		if(result > 0) {
			ArrayList<PostFile> flist = new PostService().selectPostFile(postNo);
			
			for(PostFile pf : flist) {
				new File(savePath + pf.getFileChange()).delete();					
			}
			
			request.getSession().setAttribute("alertMsg", "게시글이 삭제되었습니다");
			response.sendRedirect(request.getContextPath() + "/list.po?cpage=" + currentPage);
		}else {
			request.setAttribute("errorMsg", "글 삭제에 실패하셨습니다");
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
