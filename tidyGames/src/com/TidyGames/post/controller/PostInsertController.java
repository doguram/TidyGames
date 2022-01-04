package com.TidyGames.post.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.TidyGames.common.MyFileRenamePolicy;
import com.TidyGames.post.model.service.PostService;
import com.TidyGames.post.model.vo.Post;
import com.TidyGames.post.model.vo.PostFile;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class PostInsertController
 */
@WebServlet("/insert.po")
public class PostInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 100*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/post_upfiles/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// postWriter 타입 String => int로 변환해도 String으로 기록해야 해서 int변환 여기서는 안함
			String postWriter = multiRequest.getParameter("memNo");
			String postName = multiRequest.getParameter("title");
			String postContent = multiRequest.getParameter("content");
			
			Post p = new Post();
			p.setPostWriter(postWriter);
			p.setPostName(postName);
			p.setPostContent(postContent);
			if(postWriter.equals("1")) {
				p.setPostNotice("Y");
			} else {
				p.setPostNotice("N");
			}
			
			ArrayList<PostFile> list = new ArrayList<>();
			String key = null;
			
			if(multiRequest.getOriginalFileName("file1") != null) {
				
				for(int i=1; i<=3; i++) {
					key = "file" + i;
					
					
					if(multiRequest.getOriginalFileName(key) != null) {
						
						
						PostFile pf = new PostFile(); 
						pf.setFileOrigin(multiRequest.getOriginalFileName(key));
						pf.setFileChange(multiRequest.getFilesystemName(key));
						pf.setFilePath("resources/post_upfiles/");
						
						list.add(pf);
					} 
					
				}
						
			}
			
	
				
			int result = new PostService().insertPost(p, list);
			
			
			if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/list.po?cpage=1");
			} else {
				
				for(PostFile pf : list) {
					new File(savePath + pf.getFileChange()).delete();					
				}
				
				request.setAttribute("errorMsg", "게시판 글등록 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
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
