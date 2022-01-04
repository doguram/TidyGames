<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page
	import="java.util.ArrayList, com.TidyGames.qna.model.vo.Qna,
			com.TidyGames.common.model.vo.*"
 %>
    
<% 
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
	Attachment at = (Attachment)request.getAttribute("at");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int listCount = pi.getListCount();
%>    	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tidy Games</title>
<style>
    div{
		box-sizing: border-box;
		color:black;
	}
	#outer{
        width:1500px;
        margin:auto;
    }
    #outer>div{float:left;}
    .line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    }
    #intro{
        width:210px;
        font-size: 33px;
        font-weight: 900;
        color :white;
        margin: 30px 0px 0px 110px;
    }
    #line_3{
        width:210px;
        height:3px;
        background: rgba(255, 255, 255, 0.555);
        margin: 8px 0px 0px 110px;
    }
    #box{
    	width:1290px;	
    }
    #tableBox{
        width:800px;
        height:610px;
        margin: 20px 0px 100px 105px;
        background-color: rgb(197, 197, 197);
        border: 10px solid rgba(255, 255, 255, 0.555);
    }
    #top>div{
        float:left;
    }
    #pTag>*{
        float:left;
    }
    #leftTop{   
        width:100%;
        margin:30px 20px 50px 0px;
    }
    #leftTop span{
        font-size:30px;
        font-weight: bolder;
        color:black;
        margin: 0px 50px 0px 40px;
    }
    #tableOut1{
        padding-top:20px;
        width:100%;
        height:60%;
    }
    #tableOut2{
        width:100%;
        height:34%;
        padding:0px 40px;
    }
    #table{
        margin:auto;
        width:700px;
        background:none;
        color:black;
    }
    .table *{
        font-size:14px;
        padding:20px;
    }
    #myQna{
        color:orange;
    }
    #table input{
        width:100%;
        height:100%;
        padding:0px;
        background:none;
        border:none;
    }
    .content{
        margin:0px;
        width:100%;
        background:none;
        border:none;
    }
    #answerTable{
        background:none;
        color:black;
    }
    textarea:focus, input:focus{
        outline:none;
    }
    #top a{
        font-size:18px;
        color:rgba(255, 255, 255, 0.666);
        margin:5px;
    }
    #pTag{
        margin:50px 0px 0px 20px;
    }
    #empty{
        height:400px;
    }
    p>a:hover{
        text-decoration: none;
        color:rgba(255, 166, 0, 0.808);
    }
    #table a{
    	padding:0px;
    	color:black;
    }

</style>
</head>
<body style="background:#0e332c;">

    <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
    
    
    <div id="outer">
        <div class="line_1"></div>
        
        <div>
            <%@ include file="../common/memberSidebar.jsp" %>
        </div>

        <div id="top">
            <div>
                <div id="intro">나의 문의내역</div>
            </div>
            <div id="pTag">
                <p><a href="<%= contextPath %>/myGameQna.me?cpage=1">게임관련 문의</a></p>
                <p style="margin:0px 5px;">|</p>
                <p><a style="font-weight:bolder; color:rgba(255, 166, 0, 0.700)">1:1 문의내역</a></p>
            </div>
        </div>
        
            	
           	<% if(list.isEmpty()) { %>
            	   <div id="box">
            <div></div>
            <div id="tableBox" style="height:300px">
            <div id="tableOut1" align="center">
            		<span style="font-size:20px; font-weight:700">작성한 1:1 문의가 없습니다.</span>
            </div>
            
        
           	<% }else { %>

            	

        <div id="box">
            <div></div>
            <div id="tableBox">
            <div id="tableOut1">
                <table id="table" class="table table-dark" align="center">
               	<% for(Qna qo : list) { %>
                    <tr>
                        <th width="30" style="font-size:17px">제목</th>
                        <td width="300" style="padding-left:0px">
                            <input type="text" style="font-size:16px" value="<%= qo.getQnaTitle() %>" readonly>
                        </td>
                        <th width="70">작성자</th>
                        <td style="padding-left:0px"><%= loginUser.getMemNick() %></td>
                        <td align=right>작성일시 | <%= qo.getQnaDate() %></td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            <textarea name="content" class="content" cols="10" rows="8" style="resize:none" readonly><%= qo.getQnaContent() %></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th width="80">첨부파일 </th>
                        <td colspan="4">
                       	 <% if(!(at == null)) { %>
                			<a download="<%= at.getOriginName() %>" href="<%=contextPath%>/<%=at.getFilePath() + at.getChangeName()%>"><%= at.getOriginName() %></a>
                       <% } %>
                       </td>

                    </tr>
            
                </table>
                
           
            </div>
            <div id="tableOut2">
                <table id="answerTable" class="table table-dark" align="center">
                    <tr class="">
                        <th width="55" style="padding-right:0px"> 답변 | </th>
                        <th>Tidy Games</th>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <textarea name="answer" id="answerArea" class="content" cols="10" rows="3" style="resize:none"><%= qo.getQnaAnswer() %></textarea>
                        </td>
                    </tr>
           		<% } %>
                </table>
            </div>
           	<% } %>
          		<% if(!list.isEmpty()) { %>
	                    <div class="paging-area" align="center">
	                        <!-- 첫 페이지에서는 이전으로 비활성화 -->
	 						<% if(currentPage != 1) { %>
	            				<button onclick="location.href='<%=contextPath%>/myQna.me?cpage=<%=currentPage-1%>';"> &lt; </button>
	           				 <% } %>
	                        
	                        <% for(int p=startPage; p<=endPage; p++) { %>
	                        <!-- 페이징 버튼 활성화 조건 게시물수에 따른 버튼 활성화  -->
	                            <% if(p == currentPage) { %>
	                                <button disabled><%= p %></button>
	                            <% }else { %>
	                                <button onclick="location.href='<%= contextPath %>/myQna.me?cpage=<%= p %>';"><%= p %></button>
	                            <% } %>
	                        <% } %>
	                        
	                        <% if(currentPage != maxPage) { %>
	                            	<button onclick="location.href='<%=contextPath%>/myQna.me?cpage=<%=currentPage+1%>';"> &gt; </button>
	                            <!-- 현재 페이지가 마지막 페이지일 땐 다음으로 버튼 비활성화 -->
	                        <% } %>
	                    <% } %>
	                    
        </div>
                
        </div>
        
        <footer>
            <div style="height:100px"></div>
        </footer>
    </div>


</body>
</html>