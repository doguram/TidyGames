package com.TidyGames.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TidyGames.game.model.service.GameService;
import com.TidyGames.game.model.vo.Game;

/**
 * Servlet implementation class ConfirmUpdateController
 */
@WebServlet("/uploadupdate.ga")
public class UploadUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int gameNo = Integer.parseInt(request.getParameter("gno"));
		String confirm = request.getParameter("confirm");
		Game g = new Game();
		g.setGameNo(gameNo);
		g.setConfirm(confirm);
		
		
		int result = new GameService().uploadUpdate(g);
		
		if(result > 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(g.getConfirm().equals("del")) {
				out.println("<script>alert('삭제되었습니다.'); location.href='" + request.getContextPath() + "/uplist.ga?cpage=1';</script>");		
				out.flush();
			}else {
			out.println("<script>alert('수정되었습니다.'); location.href='" + request.getContextPath() + "/uploaddetail.ga?gno=" + gameNo + "';</script>");			
			out.flush();
			}
		  
		}else {
			System.out.println("오류");
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
