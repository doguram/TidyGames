<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.game.model.vo.Game"%>
<%
	ArrayList<Game> list = (ArrayList<Game>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#updateformgc{
	color: orange;
	}
    .outer{
        width:1500px;
        height:800px;
        margin: auto;
    }
    table {
        width:1010px;
        border: 1px solid grey;
        border-collapse:collapse;
        margin: auto;
        margin-top: 100px;
        text-align: center;
        
    }
    th {
        background: rgb(236, 240, 236); 
        color: black;
        border: 1px solid rgb(109, 106, 106);
    }
    tr, td{
        border: 1px solid rgb(109, 106, 106);
        color: honeydew;
    }
    .menu-name{
        color: rgba(255, 255, 255, 0.712);
        font-weight: bold;
        font-size: 30px;
        margin-top: 50px;
        margin-left: 90px;
    }
    
    #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    }
</style>
</head>
<body style="background-color: #0e332c;">
	<%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
    
    <div class="outer">
	<div id="line_1"></div>
	
	<div>
    <%@ include file="../common/companySidebar.jsp"%>
	
	</div>
        <div class="menu-name">
            <h2>보유 게임 목록</h2>
        </div>

        <table class="uploadList">

            <tr>
                <th>번호</th>
                <th>게임명</th>
                <th>가격</th>
                <th>마지막 업데이트 날짜</th>
                <th>업데이트</th>
            </tr>
            <% int index = 0; %>
            <% for(Game g : list) { %>
            <tr>
                <td><%= index++ %></td>
                <td><%=g.getKorName()%>(<%=g.getEngName()%>)</td>
                <td><%=g.getPrice()%></td>
                <td><%=g.getUploadDate()%></td>
                	<% if((g.getConfirm()).equals("Y")) { %>
                <td><a href="gameCompanyEnrollForm.jsp" class="btn btn-sm btn-primary">승인</a></td>
                	<% }else if((g.getConfirm()).equals("A")){ %>
                <td><a href="gameCompanyEnrollForm.jsp" class="btn btn-sm btn-danger">반려</a></td>	
                	<% }else if((g.getConfirm()).equals("N")) { %>
                <td><a href="gameCompanyEnrollForm.jsp" class="btn btn-sm btn-warning">미승인</a></td>
                	<% } %>
                	
                	<% if ((g.getUpgame()).equals("Y")) { %>
                <td><a href="gameCompanyUpdateForm.jsp" class="btn btn-sm btn-primary">업데이트</a></td>
               		<% } else { %>
               	<td></td>
               	<% } %>
            </tr>
            <% } %>

      

        </table>


    </div>

	

</body>
</html>