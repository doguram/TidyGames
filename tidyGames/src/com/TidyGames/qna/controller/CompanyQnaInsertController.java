package com.TidyGames.qna.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.TidyGames.common.MyFileRenamePolicy;
import com.TidyGames.common.model.vo.Attachment;
import com.TidyGames.qna.model.service.QnaService;
import com.TidyGames.qna.model.vo.Qna;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class CompanyQnaInsertController
 */
@WebServlet("/insertQna.gq")
public class CompanyQnaInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyQnaInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10*1024*1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/gqna_upfiles/");
			

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			int memNo = Integer.parseInt(multiRequest.getParameter("memNo"));
			int gameNo = Integer.parseInt(multiRequest.getParameter("gameNo"));
			int companyNo = Integer.parseInt(multiRequest.getParameter("companyNo"));
			String gqnaTitle = multiRequest.getParameter("gqnaTitle");
			String gqnaContent = multiRequest.getParameter("gqnaContent");
			
			Qna gq = new Qna();
			gq.setMemNo(memNo);
			gq.setGameNo(gameNo);
			gq.setCompanyNo(companyNo);
			gq.setQnaTitle(gqnaTitle);
			gq.setQnaContent(gqnaContent);
			
			Attachment at = null; 
			
			if(multiRequest.getOriginalFileName("upfile") != null) { 
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resources/gqna_upfiles/");
			}
			
			int result = new QnaService().insertGameQna(gq, at);
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "게임 문의가 작성되었습니다.");
				response.sendRedirect(request.getContextPath() + "/myGameQna.me?cpage=1"); 
			}else {
				if(at != null) {
					new File(savePath + at.getChangeName()).delete();
				}
				
				request.setAttribute("errorMsg", "게시글 작성 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
			}
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
