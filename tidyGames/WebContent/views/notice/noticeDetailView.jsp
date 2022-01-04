<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ 
	page import="com.TidyGames.notice.model.vo.Notice, com.TidyGames.common.model.vo.PageInfo,
	com.TidyGames.notice.model.vo.NoticeFile, java.util.ArrayList"
%>
<%
	Notice noticeDetail = (Notice)session.getAttribute("noticeDetail");
	ArrayList<NoticeFile> fileList = (ArrayList<NoticeFile>)request.getAttribute("fileList");
	int firstNo = (int)request.getAttribute("firstNo");
	int lastNo = (int)request.getAttribute("lastNo");
	int currentPage = (int)request.getAttribute("currentPage");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#notice {
	color: orange;
}

.include-area {
	width: 1500px;
	margin: auto;
	align: center;
	border-bottom: 2px solid rgba(255, 255, 255, 0.555);
}

.outer {
	size: auto;
	background-color: #0e332c;
	color: white;
	width: 1200px;
	margin: auto;
	margin-top: 50px;
}

.underline {
	border-bottom: 2px solid rgba(83, 79, 79, 0.333);
}

.view-form {
	size: auto;
	background-color: lightgray;
	width: 1200px;
	margin: auto;
}

#read-form {
	margin: auto;
	width: 1100px;
}
table {
	color: black;
}
#imgForm{
	width: 100%;
	height: 100%;
	margin: auto;
}
#imgForm>img{
	margin: auto;
}
</style>
</head>
<body style="background-color: #0e332c;">

	<div class="include-area">
		<%@ include file="../common/topbar.jsp"%>
		<%@ include file="../common/navibar.jsp"%>
	</div>
	
	<div class="outer">

		<h2>TIDY NOTICE</h2>
		
		<br>
		<div align="right">
			<% if(loginUser != null && loginUser.getRoleId().equals("A")) { %>
				<a href="<%= contextPath %>/noticeUpdatePage.no?num=<%=noticeDetail.getNotiNo()%>" class="btn btn-sm btn-info">수정</a> 
				<a class="btn btn-sm btn-danger" onclick="deleteNotice();">삭제</a>
			<% } %>
		</div>
		
		<br>
		<div class="view-form">
			<br><br>
			<div id="read-form">

				<div class="underline">
					<table style="width: 100%;">
						<tr>
							<th width="10%"><h5><b>제목</b></h5></th>
							<td width="90%"><h6><b><%= noticeDetail.getNotiTitle() %></b></h6></td>
						</tr>
						<tr>
							<td colspan="2" height="20"></td>
						</tr>
						<tr>
							<th>작성일</th>
							<td><%= noticeDetail.getNotiDate() %></td>
						</tr>
						<tr>
							<td colspan="2" height="20"></td>
						</tr>
					</table>
				</div>

				<div class="underline">
					<table style="width: 100%;">
						<tr>
							<td colspan="2" height="20"></td>
						</tr>
						<tr>
							<th width="10%"><h5>내용</h5></th>
							<td width="90%">
								<p style="width: 80%;">
									<% if(fileList != null) {%>
										<div id="imgForm">
											<% for(int i=0; i<fileList.size(); i++) { %>
												<img src="<%= contextPath %>/<%= fileList.get(i).getFilePath() + fileList.get(i).getFileChange() %>" width="90%;">
											<% } %>
										</div>
									<% } %>
								</p>
								<pre style="width: 1000px;">
<%= noticeDetail.getNotiContent() %>
								</pre>
							</td>
						</tr>
						<tr>
							<th></th>
							<td colspan="2"></td>
						</tr>
						<tr>
							<td colspan="2" height="20"></td>
						</tr>
					</table>
<!-- 첨부파일 -->
					

				 </div>

				<br>
			</div><!-- read-form -->
		</div><!-- view-form -->
	</div><!-- outer -->
	<br>
	<div align="center">
		<% if(noticeDetail.getNotiNo() != firstNo) { %>
			<a href="<%=contextPath%>/noticeDetail.no?cpage=<%=currentPage%>&num=<%=noticeDetail.getNotiNo() - 1%>" class="btn btn-sm btn-secondary"><i class="fas fa-angle-double-left fa-lg"></i></a> 
		<% } %>
		<a href="<%=contextPath%>/notice.no?cpage=<%=currentPage%>" class="btn btn-sm btn-secondary"><i class="fas fa-align-justify fa-lg"></i></a> 
		<% if(noticeDetail.getNotiNo() != lastNo) { %>
			<a href="<%=contextPath%>/noticeDetail.no?cpage=<%=currentPage%>&num=<%=noticeDetail.getNotiNo() + 1%>" class="btn btn-sm btn-secondary"><i class="fas fa-angle-double-right fa-lg"></i></a>
		<% } %>
	</div>

	<br>
	<br>

	<script>
		function deleteNotice(){
			if(confirm("게시글을 삭제하시겠습니까?")){
				location.href="<%=contextPath%>/noticeDelete.no?num=<%=noticeDetail.getNotiNo()%>";
			}
		}

	</script>


</body>
</html>