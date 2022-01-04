package com.TidyGames.company.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.TidyGames.common.MyFileRenamePolicy;
import com.TidyGames.game.model.service.GameService;
import com.TidyGames.game.model.vo.Attachment3;
import com.TidyGames.game.model.vo.Game;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class CompanyGameUpdateController
 */
@WebServlet("/update.gc")
public class CompanyGameUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyGameUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 600 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/game_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 공통적으로 수행 : update Game
			int gameNo = Integer.parseInt(multiRequest.getParameter("gno"));
			// 장르, 플레이어, 태그 별로 따로 받아서 담기
			String category = multiRequest.getParameter("category");
			String korName = multiRequest.getParameter("korName");
			String engName = multiRequest.getParameter("engName");
			String gameIntro = multiRequest.getParameter("content");
			int price = Integer.parseInt(multiRequest.getParameter("price"));
			
			Game ga = new Game();
			ga.setGameNo(gameNo);
			ga.setKorName(korName);
			ga.setEngName(engName);
			ga.setGameIntro(gameIntro);
			ga.setPrice(price);
			
			// Attachment에 파일이 없었다면 여러번 insert, 있었다면 여러번 update
			// 일단 모든 파일 at에 반복적으로 담아서 list에 쌓기
			ArrayList<Attachment3> list = new ArrayList<>();
			
			for(int i=1; i<=6; i++) {
				String key = "file" + i; // name이 file1,2,3,4라서 key에 순서대로 담는거임
				String fileNoKey = "originFileNo" + i;
				if(multiRequest.getOriginalFileName(key) != null) { // 새 첨부파일 있을경우
					// Attachment3생성 + 원본명, 수정명, 폴더경로, 파일레벨 담아서 list에 쌓기
					Attachment3 at = new Attachment3();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/game_upfiles/");
					
					if(i == 6) { // 대표이미지일경우
						at.setFileLevel(1);
					}else if(i == 1) { // 동영상일경우
						at.setFileLevel(3);
					}else { //상세이미지일경우
						at.setFileLevel(2);
					}

					
					if(multiRequest.getParameter(fileNoKey) != null) {
						// 기존의 첨부파일 있었을 경우 => Update
						at.setFileNo(Integer.parseInt(multiRequest.getParameter(fileNoKey)));
					}else {
						// 없었을경우 => Insert
						at.setRefBoardNo(gameNo);
					}
					
					list.add(at);
					
				}
			}
			
			int result = new GameService().updateGame(ga, list);
			
				if(result > 0) { //성공메세지
					request.getSession().setAttribute("alertMsg", "성공적으로 업데이트 되었습니다.");
					response.sendRedirect(request.getContextPath() + "/gameList.gc");

				}else { // 실패시 에러페이지 포워딩, 파일 삭제
					
					for(Attachment3 at : list) {
						if(at != null) {
							new File(savePath + at.getChangeName()).delete();
						}
					}
					request.setAttribute("errorMsg", "게임 업데이트 실패");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				}
				
				
			}
			
		}
	
	/*
			Attachment3 at = null;
			
			if(multiRequest.getOriginalFileName("titleFile") != null) { // 첨부파일 있을 경우
				at = new Attachment3();
				at.setOriginName(multiRequest.getOriginalFileName("titleFile"));
				at.setChangeName(multiRequest.getFilesystemName("titleFile"));
				at.setFilePath("resources/game_upfiles/");
				ga.setGameImg(multiRequest.getFilesystemName("titleFile"));
				
				if(multiRequest.getParameter("originFileNo") != null) {
					// 기존의 첨부파일 있었을 경우 => Update
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					
				}else {
					// 없었을경우 => Insert
					at.setRefBoardNo(gameNo);
				}
				
				// 새로 넘어온 파일 없으면 null
				
				int result = new GameService().updateGame(ga, at);
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
