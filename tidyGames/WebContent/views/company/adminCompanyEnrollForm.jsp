<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	        <form action="<%=contextPath%>/insert.co" method="post" id="enroll-form">
	
	            <table>
	                <tr>
	                    <th width="100"><h4>게임사</h4></th>
	                    <td><input type="text" name="companyName" required></td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	                <tr>
	                    <th><h4>아이디</h4></th>
	                    <td><input type="text" name="companyId" required></td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	                <tr>
	                    <th><h4>등록코드</h4></th>
	                    <td><h6 style="color:lightgray;">&nbsp;&nbsp;등록코드는 등록시 자동으로 부여됩니다</h6></td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	                <tr>
	                    <th><h4>대표자</h4></th>
	                    <td><input type="text" name="companyHead" required></td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	                <tr>
	                    <th style="display: flow-root;"><h4>코멘트</h4></th>
	                    <td><textarea name="comment" cols="79" rows="5" style="resize:none"></textarea></td>
	                </tr>
	                <tr><td colspan=2 height="30"></td></tr>
	            </table>
	
	            <div align="right" style="width:700px">
	                <button type="reset" class="btn btn-secondary">취소</button>
	                <button type="submit" class="btn btn-info">등록</button>
	            </div>

        	</form>

        </div>

    </div>
</body>
</html>