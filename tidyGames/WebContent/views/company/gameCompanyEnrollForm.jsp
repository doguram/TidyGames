 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.game.model.vo.*"%>
<%
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	#enrollform{
	color: orange;
	}
	
     .outer{
        width: 1200px;
        height:1100px;
        display:flex;
        margin: auto;
        margin-top: 70px;
        background: lightgray;
        flex-wrap: wrap;
    }
    
    #outer2{
        width:1500px;
        /* height:1500px; */
        margin:auto;
    }
    .form-area{
        width: 1200px;
        height:1100px;
        display:flex;
        margin: auto;
        margin-top: 70px;
        background: lightgray;
        flex-wrap: wrap;
    }
    .title{
        color: black;
        font-size:25px;
        margin-bottom: 50px;
    }
    .left-area{
        height: 700px;
        width: 700px;
    }
    #big{
        width:700px;
        height:300px;
    }
    .img11 img, .img11 video{
        width:100%;
        height: 100%;
        object-fit: cover;
    }
    #small{
        background: darkgrey;
        width:700px;
        height:120px;
    }
    #small img{
        width:140px;
        height:90px;
        margin:15px;
    }
    .right-area{
        width:500px;
        height: 700px;
        margin-top: 141px;
    }
    #t-img{
        width:450px;
        height:200px;
        margin: auto;
    }
    .right-area div{
        color: black;
        margin-left: 15px;
    }
    #price{
        width: 200px;
        height:40px;
        margin-top: 30px;
    }
    #content{
        width:450px;
        height:110px;
    }
    .category-btn{
        background: rgb(102, 107, 112);
        text-decoration: none;
        font-size: 12px;
        color:black;
        padding: 5px;
        margin: 5px;
        border-radius: 5px;
    }
    .file-area{
        width:1200px;
        height: 200px;
    }
    .file-area button{
        width:130px;
        height: 50px;
        margin:30px;
        border-radius: 7px;
        font-weight: bold;
    }
    .file-area input{
        margin:-10px;
    }
    #alpha{
        margin-left: 100px;
    }
    .menu-name{
        color: rgba(255, 255, 255, 0.712);
        font-weight: bold;
        font-size: 30px;
        margin-top: 50px;
        margin-left:255px;
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
    
    
    <div id="outer2">
    <div id="line_1"></div>
    <div>
    <%@ include file="../common/companySidebar.jsp"%>
    </div>


    <div class="menu-name">
        <h2>게임 업로드</h2>
    </div>

    <div class="outer">
        <form action="<%=contextPath%>/insert.gc" class="form-area" method="post" enctype="multipart/form-data" >
			
            <input type="hidden" value="<%=loginCompany.getCompanyNo()%>" name="cno">
            <div class="left-area">
                <div class="title">
                    <input type="text" placeholder="한글게임명" name="korName" required><br>
                    <input type="text" placeholder="영문게임명" name="engName" required>
                </div>
                
                <div  class="img11" id="big">
                    <video id="video" controls autoplay muted onclick="chooseFile(1);"></video>
                </div>
                <div style="display:none;">
                <input type="file" name="file1" id="file1" onchange="loadImg(this, 1);">
             	</div>
                
                <div class="img11" id="small" align="center">
                	<img id="contentImg1" onclick="chooseFile(2);">
                	<img id="contentImg2" onclick="chooseFile(3);">
                	<img id="contentImg3" onclick="chooseFile(4);">
                	<img id="contentImg4" onclick="chooseFile(5);">
                	<div style="display:none;">
	                    <input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
	                    <input type="file" name="file3" id="file3" onchange="loadImg(this, 3);">
	                    <input type="file" name="file4" id="file4" onchange="loadImg(this, 4);">
	                    <input type="file" name="file5" id="file5" onchange="loadImg(this, 5);">
                    </div>
                </div>
            </div>
            
            <div class="right-area">
                <div class="info-area">
                    <div class="img11" id="t-img">
                    	<img id="titleImg" onclick="chooseFile(6);">
	                    <div style="display:none;">
	                        <input type="file" name="file6" id="file6" onchange="loadImg(this, 6);" required>
	                    </div>
                    </div>
                    <div id="price">
                        <span>판매가 : <input type="text" name="price" placeholder="단위(원)"></span>
                    </div>
                    <br>
                    <div id="content">
                        <textarea name="content" id="content" cols="55" rows="6" placeholder="게임 소개 및 내용 작성"></textarea>
                    </div>
                    <br><br><br>

                    <tr>
                        <th>출시일</th>
                        <td><input type="number" placeholder="예상출시일(숫자만입력)" name="releaseDate"></td>
                    </tr>
                    <br>
                    <tr>
                        <th>장르</th>
                        <td>
                            <select name="genre" id="genre">
                                <option value="">장르선택</option>
                        	<% for(Category c : list) {%>
                        		<option value="<%=c.getCategoryNo()%>"><%=c.getCategoryName()%></option>
                        	<% } %>
                            </select>
                        </td>
                    </tr>
                    <br>
                    <tr>
                        <th>플레이어</th>
                        <td>
                            <select name="player" id="player">
                            	<option value="">플레이어선택</option>
                                <option value="">싱글플레이어</option>
                                <option value="">멀티플레이어</option>
                            </select>
                        </td>
                    </tr>
                    <br>
                    <tr>
                        <th>관련태그</th>
                        <td>
                            <select name="tag" id="tag">
                                <option value="">태그선택</option>
                        	<% for(Category c : list) {%>
                        		<option value="<%=c.getCategoryNo()%>"><%=c.getCategoryName() %></option>
                        	<% } %>
                            </select>
                        </td>
                    </tr>
                    
                </div>   
            </div>
            <br>
            <div class="file-area" align="center">
                <pre style="font-weight: bold; font-size: 17px;">
            알파테스트 첨부      최소사양/요구사항 zip파일 첨부
                                </pre>
                            
                <input type="file" name="alpha" id="alpha">
                <input type="file" name="minimum">
                <br><br>
                <button class="btn btn-sm btn-primary">저장</button>
                <button type="submit" class="btn btn-sm btn-success">게임 승인 요청</button>
            </div>
        </form>
                
    </div>
    </div>

    <script>
        function loadImg(inputFile, num){
             if(inputFile.files.length == 1) { //파일있으면 미리보기
                  
                // 파일을 읽어들이 FileReader 객체 생성
                const reader = new FileReader();
                
                // 파일을 읽어들이는 메소드
                reader.readAsDataURL(inputFile.files[0]);
                // 해당 파일을 읽어들이는 순간 해당 이 파일만의 고유한  url부여

                // 파일 읽어들이기가 완료됐을 때 실행할 함수를 정의해두기
                reader.onload = function(e){ // 매개변수를 써야만 읽어들인 파일 전달받을수있음
                    // e.target.result => 읽어들인 파일의 고유한 url
                    switch(num){
                        case 1:$("#video").attr("src", e.target.result); break;
                        case 2:$("#contentImg1").attr("src", e.target.result); break;
                        case 3:$("#contentImg2").attr("src", e.target.result); break;
                        case 4:$("#contentImg3").attr("src", e.target.result); break;
                        case 5:$("#contentImg4").attr("src", e.target.result); break;
                        case 6:$("#titleImg").attr("src", e.target.result); break;
                    }
                }

             }else{ // 파일 취소된경우 미리보기 사라짐
                switch(num){
                        case 1:$("#video").attr("src", null); break;
                        case 2:$("#contentImg1").attr("src", null); break;
                        case 3:$("#contentImg2").attr("src", null); break;
                        case 4:$("#contentImg3").attr("src", null); break;
                        case 5:$("#contentImg4").attr("src", null); break;
                        case 6:$("#titleImg").attr("src", null); break;
                    }
             }
        }
        
        function chooseFile(num){
    		$("#file" + num).click();
    	}	
    </script>
</body>
</html>
