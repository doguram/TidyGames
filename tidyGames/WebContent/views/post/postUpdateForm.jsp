<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.TidyGames.post.model.vo.Post, com.TidyGames.common.model.vo.PageInfo"%>
<%
	Post p = (Post)request.getAttribute("p");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#community{color:orange;}
	.outer{
		background-color: #0e332c;
		color:white;
		width:1200px;
		height:1100px;
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
	    height:1000px;
	    margin:auto;
	    margin-top:50px;
	}
	#update-form input, #update-form textarea{
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

        <h2>TIDY COMMUNITY  <i class="far fa-comments"></i></h2>

        <div class="write-form">
			<br><br>
            <form action="<%=request.getContextPath()%>/update.po" id="update-form" method="post">
				<input type="hidden" name="postNo" value="<%=p.getPostNo()%>">
				<input type="hidden" name="currentPage" value="<%=pi.getCurrentPage()%>">
				
                <table>
                    <tr>
                        <th width="70"><h5>제목</h5></th>
                        <td width="830" heigt="30" colspan="3"><input type="text" name="title" required value="<%=p.getPostName()%>"></td>
                    </tr>
                    <tr><td colspan="4" height="20"></td></tr>
                    <tr>
                        <td colspan="4" style="background:white">
                            <textarea class="summernote" rows="30" name="content" required style="resize:none"><%=p.getPostContent()%></textarea>
                        </td>
                    </tr>
                    <tr>
						<td colspan="4" height="20"></td>
					</tr>
                </table>

                <div align="right" style="width:1000px">
                    <button type="button" onclick="history.back();" class="btn btn-sm btn-secondary">뒤로가기</button>
                    <button type="submit" class="btn btn-sm btn-success">수정완료</button>
                </div>
            </form>

        </div>
        
    </div>
    
 


</body>
</html>