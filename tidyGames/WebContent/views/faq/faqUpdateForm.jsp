<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="com.TidyGames.faq.model.vo.Faq"
%>
<%
	
	Faq f = (Faq)request.getAttribute("f");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#faq{color:orange;}
	.outer{
		background-color: #0e332c;
		color:white;
		width:1200px;
		height:900px;
		margin:auto;
		margin-top:50px;
	}
	.include-area{
		width:1500px;
		margin:auto;
		align:center;
		border-bottom:2px solid rgba(255, 255, 255, 0.555);
	}
	.write-form{
	    background-color: lightgray;
	    width:1100px;
	    height:750px;
	    margin:auto;
	    margin-top:50px;
	}
	#enroll-form input, #enroll-form textarea{
		width:100%;
		box-sizing:border-box;
	 }
	 table{
	     margin:auto;
	     color:rgb(46, 45, 45);
	 }
</style>
</head>
<body style="background-color: #0e332c;">

	<div class="include-area">
		<%@ include file="../common/topbar.jsp" %>
		<%@ include file="../common/navibar.jsp" %>
	 </div>

    <div class="outer">

        <h2 style="float: left;">TIDY HELP |</h2>
        <h4 style="font-style: oblique; line-height: 2; float: left;">&nbsp;&nbsp;FAQ</h4>
        <h4 style="line-height: 2; color: gray; cursor: pointer;" onclick="location.href=''">&nbsp;&nbsp;1:1문의</h4>

        <div class="write-form">
			<br><br>
            <form action="<%=request.getContextPath()%>/faqUpdate.fa" method="post">
				<input type="hidden" name="faqNo" value="<%= f.getFaqNo() %>">
				
                <table>
                    <tr>
                        <th width="70"><h5>제목</h5></th>
                        <td width="830" heigt="30"><input type="text" name="title" required style="width: 100%;" value="<%= f.getFaqTitle() %>"></td>
                    </tr>
                    <tr><td colspan="2" height="20"></td></tr>
                    <tr>
                        <td colspan="2" style="background:white;">
                            <textarea rows="20" name="content" required style="resize:none; width: 100%;"><%= f.getFaqContent() %></textarea>
                        </td>
                    </tr>
                    <tr>
						<td colspan="2" height="20"></td>
					</tr>
                </table>

                <div align="right" style="width:1000px">
                    <button type="button" onclick="history.back();" class="btn btn-sm btn-secondary">뒤로가기</button>
                    <button type="reset" class="btn btn-sm btn-info">되돌리기</button>
                    <button type="submit" class="btn btn-sm btn-success">수정</button>
                </div>
				
            </form>

        </div>
        
    </div>
    


</body>
</html>