<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.TidyGames.game.model.vo.*, java.util.ArrayList"%>
<%
	Game g = (Game)request.getAttribute("g");
	ArrayList<Category> gcList = (ArrayList <Category>)request.getAttribute("gcList");
	ArrayList<Attachment3> list = (ArrayList<Attachment3>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        width: 1200px;
        height:800px;
        display:flex;
        margin: auto;
        margin-top: 70px;
    }
    .title{
        color: white;
        font-size:25px;
    }
    .left-area{
        height: 700px;
        width: 700px;
    }
    #big{
        width:700px;
        height:300px;
        background: rgba(169, 169, 169, 0.178);
    }
    .img11 img{
        width:100%;
        height: 100%;
        object-fit: cover;
    }
    #small{
        background: rgba(169, 169, 169, 0.178);
        width:700px;
        height:120px;
    }
    #small img{
        width:140px;
        height:100px;
        margin:5px;
    }
    .right-area{
        width:500px;
        height:700px;
        margin-top: 91px;
    }
    #t-img{
        width:450px;
        height:200px;
        margin: auto;
    }
    .right-area div{
        color: white;
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
        color:white;
        padding: 5px;
        margin: 5px;
        border-radius: 5px;
    }
    .btn-area div{
        display:inline-block;
    }
    #heart{
        margin:30px 120px 10px 100px;
    }
    #rating{
        margin-left: 50px;
        margin-right: 30px;
    }
    #review-btn{
        background:lightgrey;
        text-decoration: none;
        color:black;
        padding:5px;
        border-radius: 5px;
    }
    #cart a, #heart a, #rating a{
        text-decoration:none;
        color:lightgrey;
    }
    #cart a:hover, #heart a:hover, #rating a:hover{
        text-decoration: none;
        color:orange;
    }
    #review-btn:hover{
       background-color:orange;
    }
</style>
</head>
<body style="background-color: #0e332c;">

   <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>

    <div class="outer">
        <div class="left-area">
        <input type="hidden" value="<%=g.getGameNo()%>">
            <div class="title">
                <p>
                    <%=g.getKorName() %> <br>
                    <%=g.getEngName() %>
                </p>
            </div>
            
            <div  class="img11" id="big" align="center">
            	<video src="<%=contextPath%>/<%=list.get(5).getFilePath() + list.get(5).getChangeName()%>" id="video" width="600" height="300" controls autoplay muted  onclick="chooseFile(1);"></video>

            </div>
            
            <div class="img11" id="small" align="center">
            	<% for(int i=1; i<list.size()-1; i++) {%>
                <img src="<%=contextPath%>/<%=list.get(i).getFilePath() + list.get(i).getChangeName()%>">
                <% } %>
            </div>

            <div id="btn" align="center">
                <button>&lt;</button>
                <button></button>
                <button></button>
                <button></button>
                <button>&gt;</button>
            </div>
            
        </div>

        <div class="right-area">
            <div class="info-area">
                <div id="t-img">
                    <img src="<%=contextPath%>/<%=list.get(0).getFilePath() + list.get(0).getChangeName()%>">
                </div>

                <div id="price">
                    <span>판매가 : <%=g.getPrice() %>원</span>
                </div>
                <div id="content">
                    <span><%=g.getGameIntro() %> </span>
                </div>
                <div id="release-date">
                    <p>
                        출시일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=g.getReleaseDate() %> <br>
                        장르 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=gcList.get(0).getCategoryName()%><br>
                        
                    </p>
                </div>
                <div id="tag">
                    관련태그&nbsp;&nbsp;&nbsp; 
                          <% for(int i=0; i<gcList.size(); i++) {%>
                            <a href="" class="category-btn"><%=gcList.get(i).getCategoryName()%></a>
                            <% } %>
                </div>
            </div>
            <div class="btn-area">
            <% if(loginUser == null) { %>
                <div id="heart">
                    <a href="<%=contextPath%>/login.me" onclick="return loginMsg();"><i class="far fa-heart fa-2x"></i></a>
                </div>
                <div id="cart">

                    <a href="<%=contextPath%>/login.me" onclick="return loginMsg();"><i class="fas fa-shopping-cart fa-2x"></i></a>

                </div>
             <% } else { %>
             
             
                   <div id="heart">
                <% if(g.getCount() == 0) { %>
                        <a href="" onclick="return wishConfirm(<%=g.getGameNo()%>)"><i class="far fa-heart fa-2x"></i></a>
                    
                  <% }else { %>
                    
                       <a href="" onclick="return wishDelete(<%=g.getGameNo()%>)"><i class="fas fa-heart fa-2x"></i></a>
                    <% } %>
                   </div>

                
               
                
                <div class="cart" align="center">

                    <a href="" onclick="return cartConfirm(<%=g.getGameNo()%>);"><i class="fas fa-shopping-cart fa-2x"></i></a>
                </div>





             <% } %>      
                <br>
                <br><br>
                <div id="rating">
                   <a href="">
                       <!-- 별점 띄워줄때 반복문 돌려볼까?-->
                       <i class="fas fa-star fa-lg"></i>
                       <i class="fas fa-star fa-lg"></i>
                       <i class="fas fa-star fa-lg"></i>
                       <i class="fas fa-star fa-lg"></i>
                       <i class="fas fa-star fa-lg"></i>
                    </a>
                </div>
                <div id="go-review">
                    <a href="<%=contextPath%>/reviewList.ga?gno=<%=g.getGameNo()%>" id="review-btn">게임리뷰 보러가기</a>
                </div>
            </div>

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
	
  	
		function wishConfirm(gameNo){
		    	
		    	$.ajax({
		    		url : "wishInsert.me",
		    		data : {
		    			
		    			gameNo:gameNo
		    		},
		    		type:"post",
		    		success:function(result) {
		    			
		    			
		    			if(result == 1) {
		 
		    				if(confirm("찜목록에 담겼습니다. 찜목록페이지로 이동하시겠습니까?")){
		    					
		    					location.href='<%=contextPath%>/wishList.me';
		    		    	}
		    			
		    			}
		    			
		    		},error:function() {
		    			console.log("찜목록 담기 실패!")
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
     					
     					location.href='<%=contextPath%>/wishList.me';
     					
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