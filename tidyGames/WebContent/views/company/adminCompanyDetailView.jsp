<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
	page import = "com.TidyGames.company.model.vo.Company, 
	               com.TidyGames.game.model.vo.Game, java.util.ArrayList"
%>
<%
	Company company = (Company)request.getAttribute("company");
	ArrayList<Game> list = (ArrayList<Game>)request.getAttribute("gameList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#listco {
	color: orange;
}

div {
	box-sizing: border-box;
}

#outer {
	width: 1500px;
	margin: auto;
	color: white;
}

#outer>div {
	float: left;
}

#line_1 {
	width: 100%;
	height: 2px;
	background: rgba(255, 255, 255, 0.555);
}

#detail-area {
	margin-top: 50px;
	margin-left: 150px;
	width: 1000px;
}

#gametable {
	text-align: center;
	color: white;
}

#gametable>tbody>tr:hover {
	background: lightgrey;
	color: black;
	cursor:pointer;
}
</style>
</head>
<body>

	<%@ include file="../common/topbar.jsp"%>
	<%@ include file="../common/navibar.jsp"%>

	<div id="outer">

		<div id="line_1"></div>
		<div>
			<%@ include file="../common/adminSidebar.jsp"%>
		</div>

		<div id="detail-area">
			<h2>게임사 상세 조회</h2>
			<br>
			<div align="right" style="width: 1000px">
				<button type="button" onclick="history.back();" class="btn btn-sm btn-secondary">뒤로가기</button>
				<a href="<%= contextPath %>/updateForm.co?num=<%= company.getCompanyNo() %>" class="btn btn-sm btn-success">수정</a> 
				<a href="<%= contextPath %>/delete.co?num=<%= company.getCompanyNo() %>" class="btn btn-sm btn-danger">삭제</a>
			</div>
			<br>
			<table>
				<tr>
					<th width="100"><h4>게임사</h4></th>
					<td><h5><%=company.getCompanyName()%></h5></td>
				</tr>
				<tr>
					<td colspan=2 height="20"></td>
				</tr>
				<tr>
					<th><h4>아이디</h4></th>
					<td><h5><%=company.getCompanyId()%></h5></td>
				</tr>
				<tr>
					<td colspan=2 height="20"></td>
				</tr>
				<tr>
					<th><h4>등록코드</h4></th>
					<td><h5><%=company.getCompanyPwd()%></h5></td>
				</tr>
				<tr>
					<td colspan=2 height="20"></td>
				</tr>
				<tr>
					<th><h4>대표자</h4></th>
					<td><h5><%=company.getCompanyHead()%></h5></td>
				</tr>
				<tr>
					<td colspan=2 height="20"></td>
				</tr>
				<tr>
					<th style="display: flow-root;"><h4>코멘트</h4></th>
					<td>
						<% if(company.getCompanyComment() != null) {%>
							<p><%=company.getCompanyComment()%></p> <% 
						} else { %>
							<p>등록된 코멘트가 없습니다</p> 
						<% } %>
					</td>
				</tr>
				<tr>
					<td colspan=2 height="20"></td>
				</tr>
				<tr>
					<th><h4>제공게임</h4></th>
					<td></td>
				</tr>
				<tr>
					<td colspan=2><h6>* 클릭시 게임상세 페이지로 이동합니다</h6></td>
			</table>
			<br>
			<div class="gametb" style="size: auto">
				<table class="table table-sm" id="gametable">
					<thead style="background: rgb(80, 88, 83)">
						<th width="50">게임넘버</th>
						<th width="100">한글명</th>
						<th width="100">원문명</th>
						<th width="50">출시일</th>
						<th width="50">등록일</th>
					</thead>
					<tbody>
						<% if(list.isEmpty()) { %>
							<tr>
								<td colspan="5">등록된 게임이 없습니다</td>
							</tr>
						<% } else { %>
							<% for(Game g : list) { %>
								<tr>
									<td><%=g.getGameNo()%></td>
									<td><%=g.getKorName()%></td>
									<td text-overflow="ellipsis" white-space="nowrap"><%=g.getEngName()%></td>
									<td><%=g.getReleaseDate()%></td>
									<td><%=g.getUploadDate()%></td>
								</tr>
							<% } %>
						<% } %>
					</tbody>
				</table>
				<script>
		        	$(function(){
		        		$("#gametable>tbody>tr").click(function(){
		        			location.href = '<%=contextPath%>/detail.ga?gno=' + $(this).children().eq(0).text();
		        		})
		        	})
	        </script>
			</div>
		</div>
	</div>

</body>
</html>