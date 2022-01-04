<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.game.model.vo.Review"%>
    
<%
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
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
		/* border: 1px solid rgba(255, 255, 255, 0.555); */
	}
	#outer{
        width:1500px;
        /* height:1500px; */
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
        margin: 30px 0px 0px 50px;
    }
    #line_3{
        width:210px;
        height:3px;
        background: rgba(255, 255, 255, 0.555);
        margin: 8px 0px 0px 50px;
    }
    #box{
    	 width:1290px;	
    	/* border:1px solid rgba(255, 255, 255, 0.222); */
        /* height: */
        
    }
    .tableBox{
        width:1100px;
        height:auto;
        margin: 20px 0px 170px 50px;
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
        /* margin:20px; */
        margin:30px 20px 50px 0px;
    }
    #leftTop span{
        font-size:30px;
        font-weight: bolder;
        color:black;
        margin: 0px 50px 0px 40px;
    }
    #tableOut1{
        padding-top:50px;
        width:100%;
        height:100%;
    }
    #tableOut2{
        width:100%;
        height:100%;
        margin:0px;
        padding:0px;
    }
    #table{
        margin:auto;
        margin-top:15px;
        margin-bottom:15px;
        width:1000px;
        background:none;
        color:black;
    }
   /* 여기까지 */
    .table *{
        font-size:14px;
        /* padding:21px; */
    }
    #myReview{
        color:orange;
    }
    #table input{
        width:100%;
        height:100%;
        padding:0px;
        background:none;
        border:none;
    }
    #content{
        width:70%;
        padding:15px; 
        font-size:17px;
        /* border:none; */
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

    }
    #pTag{
        margin:70px 0px 0px 370px;
    }
    #empty{
        height:400px;
    }
    p>a:hover{
        text-decoration: none;
        color:rgba(255, 166, 0, 0.808);
    }
    #gameList{
        height:200px;
    }
    #pagebar{
        margin: 10px 10px 10px 110px;
    }
    #headerBar{
        font-size: 19px;
        font-weight: 700;
        border: none;
    }
    #table td>span{
        font-size:24px;
        font-weight:600;
    }
    #table td>label{
        margin-left: 6px;
        font-size:18px;
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
                <div id="intro">나의 리뷰</div>
                <div id="line_3"></div>
            </div>
            <!-- <div id="pTag">
                <a href="" style="font-size:20px; font-weight: bold;">내가 작성한 리뷰 2개</a>
            </div> -->
        </div>
        
        
        
        <div class="tableBox">
        
        <% if(list.isEmpty()) { %>
        	<div align="center" style="height:100px;">
        		<span style="font-size:18px; font-weight:800; line-height:100px">작성한 리뷰가 없습니다.</span>
        	</div>
        	
        <% } %>
        
			<% for (Review re : list) { %>
        	<table id="table" class="table table-dark" align="center">
                <tr>
                    <td id="headerBar" colspan="2"><%= re.getUploadDate() %></td>
                </tr>
                <tr>
                    <td rowspan="2" id="content"><%= re.getContents() %></td>
                    <td width="30%" style="height:0px;"><span><%= re.getEngName() %></span>
                    									<% int i = 0; %>
                    									<label><% for(i=0; i<re.getStarNo()/20; i++) { %>
                    											 	☆		
                    											<% } %>
                    									</label></td>
                </tr>
                <tr>
                    <td >
                        <img width="300px" style="margin-top:10px;" src="<%= re.getGameImg() %>">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">추천수 <span style="color:red; font-size:14px"><%= re.getRecommend() %></span></td>
                </tr>
            </table>
            <% } %>
            
            
            
            
            </div>

        </div>



</body>
</html>