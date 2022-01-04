<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.TidyGames.common.model.vo.PageInfo, java.util.ArrayList, com.TidyGames.post.model.vo.Post"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#community {
	color: orange;
}

.include-area {
	width: 1500px;
	margin: auto;
	align: center;
	border-bottom: 2px solid rgba(255, 255, 255, 0.555);
}

.outer {
	background-color: #0e332c;
	color: white;
	width: 1200px;
	height: 1000px;
	margin: auto;
	margin-top: 50px;
}

table {
	text-align: center;
}

#table {
	color: white;
}

tbody>tr:hover {
	background: lightgray;
	color: black;
	cursor: pointer;
	opacity: 0.9;
}

#title:hover {
	text-decoration: underline;
}

.paging-area button {
	border: none;
}

#searchbtn {
	color: white;
	background: #0e332c;
	border: none;
}

#searchbtn:hover, .paging-area button:hover {
	cursor: pointer;
	color: orange;
}

#noticebtn {
	color: white;
	background: lightseagreen;
	border: none;
	border-radius: 3px;
}
</style>
</head>
<body style="background-color: #0e332c;">

	<div class="include-area">
		<%@ include file="../common/topbar.jsp"%>
		<%@ include file="../common/navibar.jsp"%>
	</div>

	<div class="outer">

		<h2>
			TIDY COMMUNITY <i class="far fa-comments"></i>
		</h2>
		<br>
		<br>
		
			<div id="deletebtn" align="right" style="width: 1200px;">
				<% if(loginUser != null && loginUser.getMemId().equals("admin")) { %>
					<a onclick="adminDelete();" class="btn btn-sm btn-danger">삭제</a>
				<% } %>
				<% if(loginUser != null && loginUser.getMemAccess().equals("UNBLOCK")) { %>
					<a href="<%= contextPath %>/enroll.po?memId=<%= loginUser.getMemId() %>" class="btn btn-sm btn-info">글작성</a>
				<% } %>
			</div>
	
			<br>
	
			
			<form id="delForm" method="post">
			<input type="hidden" name="currentPage" value="<%=currentPage%>">
			<table align="center" style="font-size: 12pt" class="table table-sm" id="table">
	
				<thead style="background: rgb(80, 88, 83)">
					<% if(loginUser != null && loginUser.getMemId().equals("admin")) { %>
						<th><input type="checkbox" id="check1"></th>
					<% } %>
						<th width="100">글번호</th>
						<th width="200">작성자</th>
						<th width="500">제목</th>
						<th width="100">조회수</th>
						<th width="100">추천수</th>
						<th width="150">작성일</th>
				</thead>
				<tbody>
					<% if(list.isEmpty()) { %>
						<tr>
							<td colspan="7">조회된 게시글이 없습니다.</td>
						</tr>
					<% }else { %>
						<% for(Post p : list) { %>
							<tr>
								<% if(p.getPostNotice().equals("Y")) { %>
									<input type="hidden" value="<%=p.getPostNo()%>">
								<% if(loginUser != null && loginUser.getMemId().equals("admin")) { %>
									<td><input type="checkbox" class="deleteNum" name="deleteNum" value="<%=p.getPostNo()%>"></td>
								<% } %>
									<td><input type="button" value="공지" id="noticebtn" disabled></td>
									<td><%=p.getPostWriter()%></td>
									<td class="title"><%=p.getPostName()%></td>
									<td><%=p.getPostView()%></td>
									<td><%=p.getPostLike()%></td>
									<td><%=p.getPostEnroll() %></td>
							<% } %>
							</tr>
						<% } %>
						<% for(Post p : list) { %>
							<tr>
								<% if(p.getPostNotice().equals("N")) { %>
									<input type="hidden" value="<%=p.getPostNo()%>">
								<% if(loginUser != null && loginUser.getMemId().equals("admin")) { %>
									<td><input type="checkbox" class="deleteNum" name="deleteNum" value="<%=p.getPostNo()%>"></td>
								<% } %>
									<td><%=p.getPostNo()%></td>
									<td class="memwriter"><%=p.getPostWriter()%></td>
									<td class="title"><%=p.getPostName()%></td>
									<td><%=p.getPostView()%></td>
									<td><%=p.getPostLike()%></td>
									<td><%=p.getPostEnroll() %></td>
								<% } %>
						<% } %><%-- for --%>
							</tr>
					<% } %><%--else --%>
				</tbody>
			</table>
		</form>
		<br>
		<br>
		<% if(request.getParameter("search") == null) { %>
		<div class="paging-area" align="center">
		
				<% if(currentPage != 1) { %>
					<button style="border-radius: 3px;" onclick="location.href='<%=contextPath%>/list.po?cpage=<%=currentPage-1%>';">&lt;</button>
				<% } %>
	
				<% for(int p=startPage; p<=endPage; p++){ %>
	
					<% if(p == currentPage) { %>
						<button disabled style="border-radius: 3px; background: orange; color: white;"><%= p %></button>
					<% }else { %>
						<button style="border-radius: 3px;" onclick="location.href='<%=contextPath%>/list.po?cpage=<%= p %>';"><%= p %></button>
					<% } %>
				
				<% } %>
	
				<% if(currentPage != maxPage) { %>
					<button onclick="location.href='<%=contextPath%>/list.po?cpage=<%=currentPage+1%>';">&gt;</button>
				<% } %>
			</div>
			<% } else if (request.getParameter("search") != null) { %>
				<div class="paging-area" align="center">
				<% if(currentPage != 1) { %>
					<button style="border-radius: 3px;" onclick="location.href='<%=contextPath%>/list.po?cpage=<%=currentPage-1%>&search=<%=request.getParameter("search")%>&word=<%=request.getParameter("word")%>';">&lt;</button>
				<% } %>
	
				<% for(int p=startPage; p<=endPage; p++){ %>
	
					<% if(p == currentPage) { %>
						<button disabled style="border-radius: 3px; background: orange; color: white;"><%= p %></button>
					<% }else { %>
						<button style="border-radius: 3px;" onclick="location.href='<%=contextPath%>/list.po?cpage=<%= p %>&search=<%=request.getParameter("search")%>&word=<%=request.getParameter("word")%>';"><%= p %></button>
					<% } %>
	
				<% } %>
	
				<% if(currentPage != maxPage) { %>
					<button onclick="location.href='<%=contextPath%>/list.po?cpage=<%=currentPage+1%>&search=<%=request.getParameter("search")%>&word=<%=request.getParameter("word")%>';">&gt;</button>
				<% } %>
				</div>
			<% }  %>
		<br>
		<br>
		
		<div class="search-area" align="center">
			<form action="<%=contextPath%>/list.po" method="get">
				<input type="hidden" name="cpage" value="1">
				<select name="search" style="height: 30px;">
					<option value="r" ${(param.search == "r")?"selected":""}>최신순</option>
					<option value="v" ${(param.search == "v")?"selected":""}>조회순</option>
					<option value="l" ${(param.search == "l")?"selected":""}>추천순</option>
					<option value="n" ${(param.search == "n")?"selected":""}>닉네임</option>
				</select> <input type="text" name="word" value="${param.word}" style="width: 500px; height: 30px;">
				<button type="submit" id="searchbtn"><i class="fas fa-search"></i></button>
			</form>
		</div>
	</div>

	<% if(loginUser != null && loginUser.getMemId().equals("admin")) { %>

		<script>
			$(function(){
				$(".title").click(function(){
					location.href = '<%=contextPath%>/detail.po?cpage=<%=currentPage%>&num=' + $(this).prevAll("input").val();
				});
				
				$(".memwriter").click(function(){
					const nickb = $(this).text();
					console.log(nickb);
					if(confirm(nickb + ' 회원을 블락하시겠습니까?')==true){
						location.href = '<%=contextPath%>/block.po?cpage=<%=currentPage%>&nickb=' + nickb;
					}else{
						return false;
					}
				});
				
				// 여긴 내부분
				$("#check1").click(function(){
		            if($(this).is(":checked")){
		                $(":checkbox", $("#table")).prop("checked", true);
		            }else {
		                $(":checkbox", $("#table")).prop("checked", false);
		            }
		        });	
				
			})
			
			// 이 함수는 수민님 코드를 참고! 완전 짱이당
			function adminDelete(){

				const checkboxes = document.getElementsByClassName('deleteNum');
				var checkNum = 0;
				var delForm = document.getElementById('delForm');
				
				for(var i=0; i<checkboxes.length; i++) {
					if(checkboxes[i].checked == true) {
						checkNum += 1;
					}
				}

				if(checkNum == 0) {
					alert("삭제할 게시글을 선택해주세요.");
				} else if(checkNum > 0) {
					if(confirm("정말 삭제하시겠습니까?")){
						delForm.action = "<%= contextPath %>/deleteAll.po";
						delForm.submit();
					}
				}

			}
			
		</script>

	<% } else { %>

		<script>
			$(function(){
				$("#table>tbody>tr").click(function(){
					<% if(loginUser.getMemAccess().equals("BLOCK")) {%>
						alert('블락된 회원은 글 조회를 할 수 없습니다');
					<% }else { %>
						location.href = '<%=contextPath%>/detail.po?cpage=<%=currentPage%>&num=' + $(this).children("input").val();
					<% } %>
				});
				

			})
		</script>

	<% } %>



</body>
</html>