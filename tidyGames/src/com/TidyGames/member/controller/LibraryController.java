package com.TidyGames.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.game.model.vo.Game;
import com.TidyGames.member.model.service.MemberService;
import com.TidyGames.member.model.vo.Member;
import com.google.gson.Gson;

/**
 * Servlet implementation class LibraryController
 */
@WebServlet("/library.me")
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//int memNo = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
		
		//ArrayList<Game> aa = new MemberService().library(memNo);
		
		//response.setContentType("application/json; charset=UTF-8");
		//new Gson().toJson(aa, response.getWriter());
		
		
//		request.setAttribute("list", list);
		request.getRequestDispatcher("views/member/library.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
