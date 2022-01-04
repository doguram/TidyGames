<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		width: 1500px;
		height: 800px;
		margin: auto;
		margin-top: 20px;
	}
	
	#content_text>span{
		color: white;
		text-decoration: none;
		font-size: 18px;
		font-weight: 500;
		margin: 10px;
		width: 100%;
		height: 10%;
	}
	#content_text>span:hover{
		cursor: pointer;
	}
	#content_game{
		width: 100%;
		height: 90%;
	}
	#content_game>div>div{
		width: 100%;
		height: 30%;
	}
	#content_game>div>div>div{
		width: 30%;
		height: 100%;
		float: left;
		margin: 10px;
		margin-left: 30px;
	}
	#content_rank, #content_sale, #content_free{
		display: none;
	}
	.whiteText{
		color: white;
	}
	.imageSize{
		width: 350px;
		height: 150px;
	}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #0e332c;">
	<div class="outer">

		<div id="content" align="center">

			<div id="content_text" style="margin-bottom: 50px;">
				<span id="text_new" onclick="changeGame('new');" style="color:orange">NEW</span>
				<span id="text_rank" onclick="changeGame('rank');">RANK</span>
				<span id="text_sale" onclick="changeGame('sale');">SALE</span>
				<span id="text_free" onclick="changeGame('free');">FREE</span>
			</div>
			
			<div id="content_game">
				<div id="content_new">
					<div id="content_new_1">
						<div>
							<a href=""><img src="resources/game_upfiles/2021122802212888478.jpg" class="imageSize"></a>
							<a href=""><p class="whiteText">Astroneer</p></a>
						</div>
						<div>
							<a href=""><img src="resources/game_upfiles/2021122802195271823.jpg" class="imageSize"></a>
							<a href=""><p class="whiteText">Sid Meiers Civilization Vl</p></a>
						</div>
						<div>
							<a href=""><img src="resources/game_upfiles/2021122802183463509.jpg" class="imageSize"></a>
							<a href=""><p class="whiteText">Among Us</p></a>
						</div>
					</div>

					<div id="content_new_2">
						<div>
							<a href=""><img src="resources/game_upfiles/2021122802152219308.jpg" class="imageSize"></a>
							<a href=""><p class="whiteText">Turmoil</p></a>
						</div>
						<div>
							<a href=""><img src="resources/game_upfiles/2021122802132766215.jpg" class="imageSize"></a>
							<a href=""><p class="whiteText">60 Seconds</p></a>
						</div>
						<div>
							<a href=""><img src="resources/game_upfiles/2021122801590671451.jpg" class="imageSize"></a>
							<a href=""><p class="whiteText">Green Hell</p></a>
						</div>
					</div>

					<div id="content_new_3">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">new게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">new게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">new게임명</p></a>
						</div>
					</div>
				</div> <!-- new div -->

				<div id="content_rank">
					<div id="content_rank_1">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">rank게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">rank게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">rank게임명</p></a>
						</div>
					</div>

					<div id="content_rank_2">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">rank게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">rank게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">rank게임명</p></a>
						</div>
					</div>

					<div id="content_rank_3">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">rank게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">rank게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">rank게임명</p></a>
						</div>
					</div>
				</div> <!-- rank div -->

				<div id="content_sale">
					<div id="content_sale_1">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">sale게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">sale게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">sale게임명</p></a>
						</div>
					</div>

					<div id="content_sale_2">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">sale게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">sale게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">sale게임명</p></a>
						</div>
					</div>

					<div id="content_sale_3">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">sale게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">sale게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">sale게임명</p></a>
						</div>
					</div>
				</div> <!-- sale div -->

				<div id="content_free">
					<div id="content_free_1">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">free게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">free게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">free게임명</p></a>
						</div>
					</div>

					<div id="content_free_2">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">free게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">free게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">free게임명</p></a>
						</div>
					</div>

					<div id="content_free_3">
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">free게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">free게임명</p></a>
						</div>
						<div>
							<a href=""><img src="" class="imageSize"></a>
							<a href=""><p class="whiteText">free게임명</p></a>
						</div>
					</div>
				</div> <!-- free div -->

			</div> <!-- game div -->

			<script>
				function changeGame(type){

					let text_new = document.getElementById('text_new');
					let text_rank = document.getElementById('text_rank');
					let text_sale = document.getElementById('text_sale');
					let text_free = document.getElementById('text_free');

					let content_new = document.getElementById('content_new');
					let content_rank = document.getElementById('content_rank');
					let content_sale = document.getElementById('content_sale');
					let content_free = document.getElementById('content_free');

					switch(type) {
						case 'new':
							text_new.style.color = "orange";
							text_rank.style.color = "white";
							text_sale.style.color = "white";
							text_free.style.color = "white";
							content_rank.style.display = "none";
							content_sale.style.display = "none";
							content_free.style.display = "none";
							content_new.style.display = "block";
							break;
						case 'rank':
							text_new.style.color = "white";
							text_rank.style.color = "orange";
							text_sale.style.color = "white";
							text_free.style.color = "white";
							content_new.style.display = "none";
							content_sale.style.display = "none";
							content_free.style.display = "none";
							content_rank.style.display = "block";
							break;
						case 'sale': 
							text_new.style.color = "white";
							text_rank.style.color = "white";
							text_sale.style.color = "orange";
							text_free.style.color = "white";
							content_free.style.display = "none";
							content_new.style.display = "none";
							content_rank.style.display = "none";
							content_sale.style.display = "block";
							break;
						case 'free':
							text_new.style.color = "white";
							text_rank.style.color = "white";
							text_sale.style.color = "white";
							text_free.style.color = "orange";
							content_new.style.display = "none";
							content_rank.style.display = "none";
							content_sale.style.display = "none";
							content_free.style.display = "block";
							break;
					}

				}

			</script>

		</div> <!-- content div -->

	
	</div> <!-- outer div -->
</body>
</html>