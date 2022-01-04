<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.TidyGames.company.model.vo.Company"%>
<%
	Company comp = (Company)request.getAttribute("comp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#enrollco{color:orange;}
    div{
        box-sizing: border-box;
    }
    #outer{
        width:1500px;
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
	#enroll-area{
		margin-top:50px;
		margin-left:150px;
	}
	#enroll-form input{
        width:600px;
        height:30px;
    }
</style>
</head>
<body>
    
    <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
   
    
    <div id="outer">
        <div id="line_1"></div>
        <div>
            <%@ include file="../common/adminSidebar.jsp" %>
        </div>
        
        <div id="enroll-area"> 
        	<h2>게임사 등록</h2>
	        <br><br><br>
	
	        <form action="<%=contextPath%>/update.co" method="post" id="enroll-form">
	        
	        	<input type="hidden" name="num" value="<%= comp.getCompanyNo() %>">
	
	            <table>
	                <tr>
	                    <th width="100"><h4>게임사</h4></th>
	                    <td><input type="text" name="companyName" required value="<%=comp.getCompanyName()%>"></td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	                <tr>
	                    <th><h4>아이디</h4></th>
	                    <td><input type="text" name="companyId" required value="<%=comp.getCompanyId()%>"></td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	                <tr>
	                    <th><h4>등록코드</h4></th>
	                    <td><%=comp.getCompanyPwd()%></td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	                <tr>
	                    <th><h4>대표자</h4></th>
	                    <td><input type="text" name="companyHead" required value="<%=comp.getCompanyHead()%>"></td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	                <tr>
	                    <th style="display: flow-root;"><h4>코멘트</h4></th>
	                    <td>
	                    	<% if(comp.getCompanyComment() != null) { %>
	                    		<textarea name="comment" cols="79" rows="5" style="resize:none"><%=comp.getCompanyComment()%></textarea>
	                   		<% }else { %>
	                   			<textarea name="comment" cols="79" rows="5" style="resize:none" placeholder="등록된 코멘트가 없습니다"></textarea>
	                   		<%} %>
	                    </td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	            </table>
	
	            <div align="right" style="width:700px">
	                <button type="button" onclick="history.back();" class="btn btn-sm btn-secondary">뒤로가기</button>
	                <button type="submit" class="btn btn-sm btn-info">수정완료</button>
	            </div>

        	</form>

        </div>

    </div>
</body>
</html>