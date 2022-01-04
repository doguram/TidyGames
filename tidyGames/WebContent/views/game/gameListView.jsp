<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.game.model.vo.*"%>
<%
	ArrayList<Game> list = (ArrayList<Game>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer3{
        background:#0e332c;
        width:1500px;
        height:1000px;
        display: flex;
        margin: auto;
        margin-top: 70px;
    }
    .game-list{
        background: rgb(43, 65, 60);
        width:1000px;
        height:240px;
        margin-bottom: 50px;
        display:flex;
        padding: 15px;
    }

    .game-list>div {
        box-sizing: border-box;
    }
    .game-title-img{
        box-sizing: border-box;
        width: 300px;
        height:205px;
        float: left;
        object-fit: cover;
    }
    .game-name,.star-rating{
        width:180px;
        color: white;
        font-weight: bold;
        flex: 1;
        padding-top: 45px;
    }

    .heart,.cart{
        width:100px;
        height: 205px;
    }
    .drop-group{
        width:300px;
        margin-top: 20px;
    }
    .drop-group>div{
        display:inline-block;
        width:200px;
        height: 120px;
        flex: 1;
    }
    .game-title-img img {
        box-sizing: border-box;
        width:100%;
        height: 100%;
    }
    .cart a, .heart a, .star-rating a{
        text-decoration:none;
        color:lightgrey;
        mouse-cursor:pointer;
    }
    .cart a:hover, .heart a:hover, .star-rating a:hover{
        text-decoration: none;
        color:orange;
    }
    #review-btn{
    	color:black;
    }
    #review-btn:hover{
    	background-color:orange;
    }
    .star-ratings {
        color: #aaa9a9; 
        position: relative;
        unicode-bidi: bidi-override;
        width: max-content;
        -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
        -webkit-text-stroke-width: 1.3px;
        -webkit-text-stroke-color: #000000;
    }
 
    .star-ratings-fill {
        color: #fff58c;
        padding: 0;
        position: absolute;
        z-index: 1;
        display: flex;
        top: 0;
        left: 0;
        overflow: hidden;
        -webkit-text-fill-color: gold;
    }
 
    .star-ratings-base {
        z-index: 0;
        padding: 0;
    }
</style>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>
<body style="background-color: #0e332c;">
    <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>

    <div class="outer3">

        <div class="drop-group">

            <div class="container">
                <div class="title">
                  <select name="sort" id="sort" class="form-control">
                    <option value="">-- 정렬순 선택 --</option>
                    <option value="">출시일순</option>
                    <option value="">높은가격순</option>
                    <option value="">낮은가격순</option>
                    <option value="">리뷰많은순</option>
                    <option value="">별점높은순</option>
                  </select>

                </div>
              </div>
    
              <br><br><br>
    
              <div class="container">
                <div class="title">
                  <select name="sort" id="sort" class="form-control">
                    <option value="">-- 장르 선택 --</option>
                    <option value="">액션</option>
                    <option value="">어드밴처</option>
                    <option value="">슈팅</option>
                    <option value="">시뮬레이션</option>
                    <option value="">퍼즐</option>
                  </select>

                </div>
              </div>
    
              <br><br><br>
    
              <div class="container">
                <div class="title">
                  <select name="sort" id="sort" class="form-control">
                    <option value="">-- 태그별 선택 --</option>
                    <option value="">귀여운</option>
                    <option value="">농장</option>
                    <option value="">힐링</option>
                    <option value="">신나는</option>
                    <option value="">무서운</option>
                  </select>

                </div>
              </div>
              
        </div>

        <div class="emp"></div>
		
        <div class="list-group">
        
			<% if(list.isEmpty()) { %>
			<!-- 키워드와 일치하는 게임이 없을 경우 -->
				<h3 align="center" style="color:white"> 일치하는 게임이 없습니다.</h3>
			<% }else {%>
			<!--  일치하는 게임이 있을 경우 -->
				<% for(Game g : list) { %>
            <div class="game-list">
                <div class="game-title-img">
                
                    <a href="<%=contextPath%>/detail.ga?gno=<%=g.getGameNo()%>"><img src="<%=contextPath%>/<%=g.getGameImg()%>"></a>
                
                </div>
                <div class="game-name" align="center">
                    <%=g.getKorName()%><br>
                    <%=g.getEngName()%>
                    <br><br><br>
                    <h4 style="color: lightgrey; font-size: 14px;">
                        출시일<br>
                    <%=g.getReleaseDate()%>
                    </h4>
                </div>
                <div class="star-rating" align="center">
                    <br>
                    <div class="star-ratings">
                        <div class="star-ratings-fill space-x-2 text-lg" style="width:100%"
                        >
                          <span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                          <span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span>
                        </div>
                    </div>
                    <br><br><br>
                    <a href="<%=contextPath%>/reviewList.ga?gno=<%=g.getGameNo()%>" class="btn btn-sm btn-light" id="review-btn">이 게임의 리뷰</a>
                </div>
                <% if(loginUser == null) { %>

	                <div class="heart" align="center">
	                    <br><br><br>
	                    <a href="<%=contextPath%>/login.me" onclick="return loginMsg();"><i class="far fa-heart fa-2x"></i></a>
	                </div>
	                <div  class="cart" align="center">
	                    <br><br><br>
	                    <a href="<%=contextPath%>/login.me" onclick="return loginMsg();"><i class="fas fa-shopping-cart fa-2x"></i></a>
	                </div>
                <% } else {%>

                <div class="heart" align="center">
                    <br><br><br>
                    
                    <% if(g.getCount() == 0)  {%>
                    
                     	<a href="" onclick="return wishConfirm(<%=g.getGameNo()%>, this)"><i class="far fa-heart fa-2x"></i></a>
                    <% }else  {%>
                    
                   		<a href="" onclick="return wishDelete(<%=g.getGameNo()%>, this)"><i class="fas fa-heart fa-2x"></i></a>
                   
                  	<%} %> 
                  	
                </div>

                <div class="cart" align="center">
                    <br><br><br>
                    
                    
                    <a href="" onclick="return cartConfirm(<%=g.getGameNo()%>);"><i class="fas fa-shopping-cart fa-2x"></i></a>
                </div>

                <% } %>
            </div>
            <% } %>
	        
		<% } %>   

        </div>
    </div>
    
    
    <script>
    
    function loginMsg(){
    	if(!confirm("로그인이 필요합니다. 로그인하시겠습니까?")){
    		return false; 
    	}
    }

   
    
    function cartConfirm(gameNo){
    	
    	$.ajax({
    		url : "cartInsert.pa",
    		data : {
    			
    			gameNo:gameNo
    		},
    		type:"post",
    		success:function(result) {
    			
    			
    			if(result == 1) {
    				if(confirm("장바구니에 담겼습니다. 장바구니로 이동하시겠습니까?")){
    		    		location.href='<%=contextPath%>/cart.pa';
    		    	}
    				
    			}else if(result == 2 ) {
    				alert("장바구니가 이미 존재합니다.")
    			}
    			
    		},error:function() {
    			console.log("장바구니 담기 실패!")
    		}
    	})
    	return false;
    	
   	
    }
    
function wishConfirm(gameNo, aEl){
    	
    	$.ajax({
    		url : "wishInsert.me",
    		data : {
    			
    			gameNo:gameNo
    		},
    		type:"post",
    		success:function(result) {
    		
    			
    			if(result > 0 ) {
 
    				if(confirm("찜목록에 담겼습니다. 찜목록페이지로 이동하시겠습니까?")){
    					
    					location.href='<%=contextPath%>/wishList.me?cpage=1';
    					
    		    	}else {
    		    		// 채워진 하트로 바꿔줘야됨 
    		    		$(aEl).children().removeClass("far");
    		    		$(aEl).children().addClass("fas");
    		    		$(aEl).click(function(){
    		    			return wishDelete(gameNo);
    		    		})
    		    	}
    		    		
    			
    			}
    			
    		},error:function() {
    			console.log("찜목록 담기 실패!")
    		}
    	})
    	
    	
    }
    
    
	function wishDelete(gameNo, aE2){
	
	$.ajax({
		url : "wishDe.me",
		data : {
			
			gameNo:gameNo
		},
		type:"post",
		success:function(result) {
		
				if(result > 0 ) {
					 
    				if(alert("찜목록이 해제되었습니다.")){
    					
    		    		// 빈하트로 채워줘야함
    		    		$(aE2).children().removeClass("fas");
    		    		$(aE2).children().addClass("far");
    		    		$(aE2).click(function(){
    		    			return wishDelete(gameNo);
    		    		})
    		    		
    			}
			
				//alert("찜목록에서 삭제되었습니다.")
				
			
				}
			
			
		},error:function() {
			console.log("찜목록 삭제 실패!")
		}
	})

	
	
		        	
	
}
   			
    </script>

</body>
</html>