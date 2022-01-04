<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.game.model.vo.Game"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tidy Games</title>
<style>
	div{
		box-sizing: border-box;
		color:white;
	}
	#outer{
        width:1500px;
        margin:auto;
    }
	#intro{
        font-size: 33px;
        font-weight: 900;
        color :white;
        margin: 50px 80px 0px 110px;
    }
    #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);

    }
	#line_3{
        width:210px;
        height:3px;
        background: rgba(255, 255, 255, 0.555);
		margin:5px 0px 30px 105px;
    }
	#box{
		width:900px; 
		margin:auto;
	}
	#lbBox{
		border: 2px solid rgba(255, 255, 255, 0.555);
		background: rgba(0, 0, 0, 0.150);
		width:700px; 
		margin:auto;
		padding:0px 10px 100px 0px;
	}
	#sortLb{
		width:100%;
		height:100px;

	}
	#sortLb label{
		color: lightgray;
		margin-right:5px
	}
	
	#sortLb>div{
		float:left;
		width:240px;
		padding: 15px 25px;
	}
	#btn{
		width:26px;
		height:26px;
		margin-left:4px;
		padding:0px;
	}

	#game{
		width:570px;
		height:120px;
		background: rgba(0, 0, 0, 0.333);
		margin:auto;
		margin-bottom: 10px;
	}
	#game>div{
		float:left;
		height:100%;
		/* border: 15px solid rgba(255, 255, 255, 0.555); */
	}
	#gameImg{width:35%;}
		#gameImg>img{
			width:100%;
			height:100%;
			padding:17px;
		}
	#gameText{width:45%;}
	#gameText>p{
		padding-top:20px;
		font-size:23px;
		
	}
	#advice{width:20%;}
	#advice>div{
		padding:10px;
		float:right;
	}
	#ad1{height:65%}
	#ad1>a{
		text-decoration: none;
		color:rgba(255, 255, 255, 0.222)
	}
	#ad2{
		height:10%;
	}
	#ad2>a{
		color:rgba(255, 255, 255, 0.600)
	}
	#ad2>a:hover{
		text-decoration: none;
		color: rgba(255, 166, 0, 0.777); 
	}
	#library{
		color:orange;
	}
	


</style>
</head>
<body style="background:#0e332c;">
	
		<%@ include file="../common/topbar.jsp" %>
		<%@ include file="../common/navibar.jsp" %>

		
		<div id="outer">
			<div id="line_1"></div>
			<div id="box">
				<div id="intro">라이브러리</div>
				<div id="line_3"></div>
				
					<div id="lbBox">
						<div id="sortLb">
					<div>
						<div class="btn-group">
								<label>정렬 기준 :</label>
								<label id="sort">이름순</label>
							<button type="button" id="btn" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
								<span class="caret"></span>
							</button>
							<div class="dropdown-menu">
								<a id="name" class="dropdown-item">이름순</a>
								<a id="newBuy" class="dropdown-item">최신구매</a>
								<a id="oldBuy" class="dropdown-item">과거구매</a>
							</div>
						</div>
					</div>
						</div>

						<div id="gameBox">
						</div>

						</div>
					</div>
				</div> 
		<footer>
			<div style="height:200px">
			</div>
		</footer>
			     
		<script>
	
		
			$(function(){
				
				ajax("이름순");
				$(".dropdown-item").click(function(){
					$("#sort").text($(this).text());
					ajax($(this).text());	
				}) 
				
			}) 
		
	
			function ajax(search) {
				
					
					$.ajax({
						url:"libSort",
						data:{search:search},
						success:function(list){
						var value = "";

							$(list).each(function(index, obj) {
								const starNo = $.trim(obj.count)/20;
								const gameNo = obj.gameNo;
								
								
								// 넘어온 값을 조건문에 돌리기
								var star = "";
								var j = 0;
								if(starNo == 0) {
										star = '<a href="<%= contextPath%>/reviewList.ga?gno=' + obj.gameNo + '">리뷰작성</a>';
									}else {
	     							 	for(j=0; j<starNo; j++) {
	     										 	star += "☆";
	     							 	}
								}
								
								
								value +=
								'<div id="games">' +
									'<div id="game">' +
										'<div id="gameImg">' +
											'<img onclick="move();" src="' + obj.gameImg + '">' +			
											'</div>' +
												'<div id="gameText"> <p class="move">' + obj.engName + '</p>' + '</div>' +
										'<div id="advice">' + 
											'<div id="ad1">' +
												'<a href="<%= contextPath%>/question.gq?gameno=' + obj.gameNo + '">게임 문의</a>' +
											'</div>' +
											'<div id="ad2">' + star +
											
											'</div>' + 
											'</div>' +
											'</div>' +
										'</div>' + 
									'</div>'
							
 							 		star = "";
									
							// 반복ㅋ
							$("#gameBox").html(value);
							})
						
			
						}, error:function(){
							console.log("ajax 통신 실패");
						}
					});	
				}
			
				
		</script>
		
</body>
</html>