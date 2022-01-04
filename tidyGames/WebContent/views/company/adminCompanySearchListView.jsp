<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.TidyGames.company.model.vo.Company" %>
<%
	ArrayList<Company> list = (ArrayList<Company>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#listco{color:orange;}
	div{
        box-sizing: border-box;
    }
    #outer{
        width:auto;
        margin:auto;
        color:white;
    }
    #outer>div{
        float:left;
    }
    #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    }
	.list-area{
		width:1000px;
		margin-top:50px;
		margin-left:150px;
	}
	#tbl{
		text-align:center;
		color:white;
	}
	#tbl>tbody>tr:hover{
        background:lightgrey;
    	color:black;
    	opacity:0.9;
    	cursor:pointer;
    }
     .paging-area button{
    	border:none;
    }
	#searchbtn{color:white; background:#0e332c; border:none;}
</style>
</head>
<body style="background-color: #0e332c;">

	<%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>

	<div id="outer">
		<div id="line_1"></div>
        <div>
            <%@ include file="../common/adminSidebar.jsp" %>
        </div>
	
		<div class="list-area">
		    <h2>게임사 목록 조회</h2>
		    <br>
		    <h6>* 클릭시 상세조회 창으로 이동합니다</h6>
		    <br>
		    <form action="">
	            <table class="table table-sm table-bordered" id="tbl">
	                <thead style="background:rgb(80, 88, 83)">
	                	<th width="60">No</th>
	                    <th width="300">게임사</th>
	                    <th>아이디</th>
	                    <th>등록코드</th>
	                    <th>등록일자</th>
	                </thead>
	                <tbody>
	                	<% if(list.isEmpty()) { %>
		                    <tr>    
		                        <td colspan="6">조회된 게시글이 없습니다.</td>
		                    </tr>
	                    <% }else { %>
	                    	<% for(Company c : list) { %>
			                    <tr>	
			                    	<td><%=c.getCompanyNo()%></td>
			                        <td><%=c.getCompanyName()%></td>
			                        <td><%=c.getCompanyId()%></td>
			                        <td><%=c.getCompanyPwd()%></td>
			                        <td><%=c.getCompanyEnroll()%></td>
			                    </tr>
	                    	<% } %>
	                    <% } %>
	                </tbody>
	            </table>
		
		    </form>
	
		    
		    <br><br>
		    
			<div class="search-area" align="center">
				<form action="<%=contextPath%>/search.co" method="get">
					<input name="companyName" type="text" style="width:500px; height:30px;" placeholder="게임사 검색" value="${param.companyName}">
				    <button type="submit" id="searchbtn"><i class="fas fa-search"></i></button>			
				</form>
			</div>
			<br><br>
		</div>

	</div>
	
	<script>
		$(function(){
			$("#tbl>tbody>tr").click(function(){
				
				const num = $(this).children().eq(0).text();
				console.log(num);								
				location.href = '<%=contextPath%>/detail.co?num=' + num;

			})
		})
	</script>
	
	
</body>
</html>