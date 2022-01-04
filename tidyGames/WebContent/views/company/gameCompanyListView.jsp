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
	
	#gamelistgc{
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
        margin-left:300px;
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
        margin-left: 300px;
    }
    .uploadList>tbody>tr:hover{
    	background:gray;
    	cursor:pointer;
    }
     #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);

</style>
</head>
<body style="background-color: #0e332c;">

	<%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
    
    <div class="outer">
    <%@ include file="../common/companySidebar.jsp"%>
    <div id="line_1"></div>

        <div class="menu-name">
            <h2>업로드한 게임 목록</h2>
        </div>

        <table class="uploadList">

            <tr>
                <th>번호</th>
                <th>게임명</th>
                <th>가격</th>
                <th>등록일</th>
                <th>승인상태</th>
                <th>업데이트</th>
            </tr>
            <% int index = 1; %>
            <% for(Game g : list) { %>
            <tr>
                <td><%=index++ %></td>
                <td><%=g.getKorName()%>(<%=g.getEngName()%>)</td>
                <td><%=g.getPrice()%></td>
                <td><%=g.getUploadDate()%></td>
                	<% if((g.getConfirm()).equals("Y")) { %>
                <td><a href="gameCompanyEnrollForm.jsp" class="btn1 btn-sm btn-primary">승인</a></td>
                	<% }else if((g.getConfirm()).equals("A")){ %>
                <td><a href="gameCompanyEnrollForm.jsp" class="btn1 btn-sm btn-danger">반려</a></td>	
                	<% }else if((g.getConfirm()).equals("N")) { %>
                <td><a href="gameCompanyEnrollForm.jsp" class="btn1 btn-sm btn-warning">미승인</a></td>
                	<% } %>
                	
                	<% if ((g.getConfirm()).equals("Y")) { %>
                <td><a href="<%=contextPath %>/updateForm.gc?gno=<%=g.getGameNo()%>" class="btn btn-sm btn-primary" id="up">업데이트</a></td>
               		<% } else { %>
               	<td></td>
               	<% } %>
            </tr>
            <% } %>
      

        </table>
    </div>
    
    <script>
    	$('.btn1').click(function () {return false;});
    </script>

	

</body>
</html>