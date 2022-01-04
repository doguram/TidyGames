<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.TidyGames.common.model.vo.PageInfo, java.util.ArrayList, com.TidyGames.notice.model.vo.Notice" %>
<%
    PageInfo pi = (PageInfo)request.getAttribute("pi");
    ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
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
	#notice{color:orange;}
    .include-area{
		width:1500px;
		margin:auto;
		align:center;
		border-bottom:2px solid rgba(255, 255, 255, 0.555);
	}
	.outer{
		background-color: #0e332c;
		color:white;
		width:1200px;
		height:1000px;
		margin:auto;
		margin-top:50px;
	}
	table {text-align:center;}
	#table{color:white;}
	tbody>tr:hover{
    	background:lightgray;
    	color:black;
    	cursor:pointer;
    	opacity:0.9;
    }
    #title:hover{
    	text-decoration:underline;
    }
    .paging-area button{
    	border:none;
    }
    #submitbtn{color:white; background:#0e332c; border:none;}
    #submitbtn:hover{cursor:pointer; color:orange;}
</style>
</head>
<body style="background-color: #0e332c;">

	<div class="include-area">
		<%@ include file="../common/topbar.jsp" %>
		<%@ include file="../common/navibar.jsp" %>
	</div>
    
    <div class="outer">

        <h2>TIDY NOTICE</h2>
        <br><br>

        <!--
        <form role="form" method="post">  
        	<input type="hidden" name="currentPage" value="<%=currentPage%>">
		</form>
        -->
          
            <div id="deletebtn" align="right" style="width:1200px;">
                <!--관리자계정에서만보이는 버튼-->
                <% if(loginUser != null && loginUser.getRoleId().equals("A")) { %>
                    <a onclick="delectNotice();" class="btn btn-sm btn-danger">삭제</a>
                    <a href="<%= contextPath %>/noticeEnroll.no" class="btn btn-sm btn-info">글작성</a>
                <% } %>
            </div>

            <br>

            <table align="center" style="font-size: 12pt" class="table table-sm" id="table">

                <thead style="background:rgb(80, 88, 83)">
                    <!--체크박스 ; 관리자만 보이게-->
                    <% if(loginUser != null && loginUser.getRoleId().equals("A")) { %>
                    	<th><input type="checkbox" id="check1"></th>
                    <% } %>
                    <th width="100">글번호</th>
                    <th width="900">제목</th>
                    <th width="150">작성일</th>
                </thead>
                <tbody>
                    <% if(list.isEmpty()) { %>
                        <!--게시물이 없을 경우-->
	                    <tr>    
	                        <td colspan="4">조회된 게시글이 없습니다.</td>
	                    </tr>
	                <% }else { %>
                        <!--게시물 있을 경우-->
                        <tr>
							<form method="post" id="noticeForm">
							<input type="hidden" name="currentPage" value="<%= currentPage %>">
	                        <% for(Notice n : list) { %>
			                    <tr>
			                    	<% if(loginUser != null && loginUser.getRoleId().equals("A")) { %>
											<td><input type="checkbox" class="deleteNum" name="deleteNum" value="<%= n.getNotiNo() %>"></td>
											<% } %>
											<td class="num"><%= n.getNotiNo() %></td>
											<td class="title"><%= n.getNotiTitle() %></td>
											<td class="notiDate"><%= n.getNotiDate() %></td>
										</tr>
									<% } %>
								</tr>
							</form>
                    <% } %>

                </tbody>
            </table>

            <br><br>

            <div class="paging-area" align="center">
            
	        	<% if(currentPage != 1) { %>
	            	<button style="border-radius:3px;" onclick="location.href='<%=contextPath%>/notice.no?cpage=<%=currentPage-1%>';"> &lt; </button>
	            <% } %>
	            
	            <% for(int p=startPage; p<=endPage; p++){ %>
	            	
	            	<% if(p == currentPage) { %>
	            		<button disabled style="border-radius:3px; background:orange; color:white;"><%= p %></button>
	            	<% }else { %>
	            		<button style="border-radius:3px;" onclick="location.href='<%=contextPath%>/notice.no?cpage=<%= p %>';"><%= p %></button>
	            	<% } %>
	            	
	            <% } %>
	            
	            <% if(currentPage != maxPage) { %>
	            	<button onclick="location.href='<%=contextPath%>/notice.no?cpage=<%=currentPage+1%>';"> &gt; </button>
	            <% } %>
        	</div>
            <br><br>

			<div class="search-area" align="center">
				<form action="<%=contextPath%>/notice.no" method="get" onsubmit="return checkSearch();">
					<input type="hidden" name="cpage" value="1">
					<select name="search" style="height: 30px;">
						<option selected value="searchTitle" ${(param.search == "searchTitle")?"selected":""}>제목</option>
						<option value="searchContent" ${(param.search == "searchContent")?"selected":""}>내용</option>
					</select> <input type="text" id="searchWord" name="word" value="${param.word}" style="width: 500px; height: 30px;">
					<button type="submit" id="searchbtn"><i class="fas fa-search"></i></button>
				</form>
			</div>

    </div>

    <% if(loginUser != null && loginUser.getRoleId().equals("A")) { %>
		
		<script>
			$(function(){
                // 게시글을 클릭하면 해당 게시글의 글번호를 num으로 넘기면서 이동
				$(".num").click(function(){
					location.href = '<%=contextPath%>/noticeDetail.no?cpage=<%=currentPage%>&num=' + $(this).text();
				});
				
				$(".title").click(function(){
					location.href = '<%=contextPath%>/noticeDetail.no?cpage=<%=currentPage%>&num=' + $(this).prev().text();
				});
				
				$(".notiDate").click(function(){
					location.href = '<%=contextPath%>/noticeDetail.no?cpage=<%=currentPage%>&num=' + $(this).prev().prev().text();
				});
			
				$("#check1").click(function(){
		            if($(this).is(":checked")){
		                $(":checkbox", $("table")).prop("checked", true);
		            }else {
		                $(":checkbox", $("table")).prop("checked", false);
		            }
		        })	
				
			})

			function delectNotice(){

				const checkboxes = document.getElementsByClassName('deleteNum');
				var checkNum = 0;
				var noticeForm = document.getElementById('noticeForm');
				
				for(var i=0; i<checkboxes.length; i++) {
					if(checkboxes[i].checked == true) {
						checkNum += 1;
					}
				}

				if(checkNum == 0) {
					alert("삭제할 게시글을 선택해주세요.");
				} else if(checkNum > 0) {
					if(confirm("정말 삭제하시겠습니까?")){
					noticeForm.action = "<%= contextPath %>/noticeListDelete.no";
					noticeForm.submit();
					}
				}

			}
		</script>
	
	<% } else { %>
	
		<script>
			$(function(){
				$(".num").click(function(){
					location.href = '<%=contextPath%>/noticeDetail.no?cpage=<%=currentPage%>&num=' + $(this).text();
				});
				
				$(".title").click(function(){
					location.href = '<%=contextPath%>/noticeDetail.no?cpage=<%=currentPage%>&num=' + $(this).prev().text();
				});
				
				$(".notiDate").click(function(){
					location.href = '<%=contextPath%>/noticeDetail.no?cpage=<%=currentPage%>&num=' + $(this).prev().prev().text();
				});
			})

		</script>
	
	<% } %>

	<script>
		function checkSearch() {

			var searchWord = document.getElementById("searchWord");

			if(searchWord.value == null || searchWord.value == "" || searchWord.value == " ") {
				alert("검색어를 입력해주세요.");
				return false;
			} else {
				return true;
			}

		}
	</script>

</body>
</html>