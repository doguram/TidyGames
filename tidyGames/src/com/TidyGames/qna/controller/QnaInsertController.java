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
 * Servlet implementation class QnaEnrollFormController
 */
@WebServlet("/insertQna.me")
public class QnaInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			Qna qna = new Qna();
			int Writer = Integer.parseInt(multiRequest.getParameter("user"));
			String Title = multiRequest.getParameter("title");
			String Content = multiRequest.getParameter("content");
			
			qna.setMemNo(Writer);
			qna.setQnaTitle(Title);
			qna.setQnaContent(Content);
			
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("upfile") != null) { // 넘어온 첨부파일이 있을 경우
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resources/board_upfiles/");
			}
			
			int result = new QnaService().insertQna(qna, at);
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "문의글이 등록되었습니다.");
				response.sendRedirect(request.getContextPath());

			}else {
				
				if(at != null) {
					new File(savePath + at.getChangeName()).delete(); 
				}
				request.setAttribute("errorMsg", "오류 발생");
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
