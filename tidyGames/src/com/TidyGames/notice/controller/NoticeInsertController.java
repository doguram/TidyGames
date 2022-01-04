package com.TidyGames.notice.controller;

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
import com.TidyGames.notice.model.service.NoticeService;
import com.TidyGames.notice.model.vo.Notice;
import com.TidyGames.notice.model.vo.NoticeFile;
import com.TidyGames.post.model.vo.PostFile;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/noticeInsert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {	//enctype이 multi타입일때만 true 반환
			
			int maxSize = 100*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// jsp에서 작성자, 제목, 내용 받아옴
			String userId = multiRequest.getParameter("userId");
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			
			Notice n = new Notice();
			n.setNotiWriter(userId);
			n.setNotiTitle(title);
			n.setNotiContent(content);
			
			ArrayList<NoticeFile> list = new ArrayList<>();

			for(int i=1; i<=3; i++) {
				String key = "file" + i;
				
				if(multiRequest.getOriginalFileName(key) != null) {	// 넘어온 첨부파일이 있다면
				
					NoticeFile nf = new NoticeFile(); 
					nf.setFileOrigin(multiRequest.getOriginalFileName(key));
					nf.setFileChange(multiRequest.getFilesystemName(key));
					nf.setFilePath("resources/notice_upfiles/");
					
					list.add(nf);	// NoticeFile nf 객체에 넘어온 파일 정보 저장한 뒤 list에 추가
					
				} 
				
			}

			int result = new NoticeService().insertNotice(n, list);
			
			if(result > 0) {	// 성공적으로 글 추가시
				request.getSession().setAttribute("alertMsg", "게시글 등록에 성공하였습니다.");
				response.sendRedirect(request.getContextPath() + "/notice.no?cpage=1");
			} else {
				
				for(NoticeFile f : list) {
					new File(savePath + f.getFileChange()).delete();					
				}
				
				request.getSession().setAttribute("alertMsg", "게시글 등록에 실패하였습니다.");
				response.sendRedirect(request.getContextPath() + "/noticeEnroll.no");
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
