package com.TidyGames.post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.common.model.vo.PageInfo;
import com.TidyGames.post.model.service.PostService;
import com.TidyGames.post.model.vo.Post;

/**
 * Servlet implementation class PostListController
 */
@WebServlet("/list.po")
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount = 0;		
		int currentPage = 0; 	
		int pageLimit = 10; 		
		int viewLimit = 15;	
		int maxPage;		
		int startPage;		
		int endPage;	
		
		String search = request.getParameter("search");
		String word = request.getParameter("word");
		
		if(word==null) {
			word = "";
		}
		
		if(search == null) {
			listCount = new PostService().selectPostListCount();	
		} else {
			switch(search) {
			case "r" : 
			case "v" : 
			case "l" : listCount = new PostService().searchPostCount(word); break;
			case "n" : listCount = new PostService().nicknamePostCount(word); break;
			}
		}	
		
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		maxPage = (int)Math.ceil((double)listCount / viewLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, viewLimit, maxPage, startPage, endPage);
		ArrayList<Post> list = new ArrayList<>();
		

		if(search ==null) {
			list = new PostService().selectPostList(pi);			
		} else {
			switch(search) {
			case "r" : 
			case "v" : 
			case "l" : 
			case "n" : list = new PostService().selectSearchList(search, pi, word);
					   break;
			}
		}
		
	
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/post/postListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
