<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.TidyGames.game.model.vo.Category" %>
<% ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>CategoryList</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

#catelistga {
	color: orange;
}

#line1 {
	margin: 0 auto;
	width: 1500px;
	height: 2px;
	background: rgba(255, 255, 255, 0.555);
}

#parent {
	display: grid;
	grid-template-columns: repeat(5, 1fr);
	grid-template-rows: repeat(5, 1fr);
	color: white;
	width: 1500px;
	height: 900px;
	margin: auto;
}

#parent button {
	font-weight: bold;
	font-family: 'Noto Sans KR', sans-serif;
}

#div1 {
	grid-area: 1/2/5/5;
	margin-top: 20px;
}

#enbtn {
	margin-top: 20px;
}

#content {
	margin: 50px;
}

#content button {
	margin: 10px;
}

.addform {
	position: absolute;
	background: lightgrey;
	z-index: 999;
	padding: 15px;
	box-shadow: 0 0 5px gray;
	padding-top: 20px;
	padding-bottom: 0px;
	border-radius: 5px;
	left: 40%;
	display: none;
}

.upform {
	position: absolute;
	background: lightgrey;
	z-index: 999;
	padding: 15px;
	box-shadow: 0 0 5px gray;
	padding-top: 20px;
	padding-bottom: 0px;
	border-radius: 5px;
	left: 40%;
	display: none;
}
</style>


</head>
<body style="background: #0e332c;">

	<%@ include file="../common/topbar.jsp"%>
	<%@ include file="../common/navibar.jsp"%>

	<div id="line1"></div>
	<div id="parent">

		<%@ include file="../common/adminSidebar.jsp"%>

		<div id="div1">
			<div id="header">
				<h1>카테고리 목록</h1>
			</div>
			<div id="enbtn" align="right">
				<button type="button" class="btn btn-info" id="add_category">추가</button>
			</div>

			<div id="content">
				<%
					for (Category c : list) {
				%>
				<button type="button" class="btn btn-light" id="catename"><%=c.getCategoryName()%></button>
				<%
					}
				%>

			</div>




			<div class="addform">
				<form>
					<table style="margin: 10px">
						<tr>
							<td colspan="2"><input type="text"></td>
						</tr>
						<tr align="center" height="50px">
							<td>
								<button type="button" class="btn btn-primary" onclick="add();">등록</button>
							</td>
							<td>
								<button type="button" class="btn btn-secondary" id="add_close">취소</button>
							</td>
						</tr>
					</table>
				</form>
			</div>

			<div class="upform">
				<form>
					<table style="margin: 10px">
						<tr>
							<td colspan="3"><input type="text" name="upCateName"></td>
						</tr>
						<tr align="center" height="50px">
							<td>
								<button type="button" class="btn btn-primary" onclick="up();">수정</button>
							</td>							
							<td>
								<button type="button" class="btn btn-secondary" id="up_close">취소</button>
							</td>
						</tr>
					</table>
				</form>
			</div>



		</div>

	</div>

	<script type="text/javascript">
			var $inInput;
		$(function() {
			$("#add_category").click(function() {
				$(".addform").css("display", "block");
			});

			$("#add_close").click(function() {
				$(".addform").css("display", "");
				$(".addform input").val("");
			});
			$("#content button").click(function() {
				$(".upform").css("display", "block");
				$(".upform input").val(event.target.textContent);	
				$inInput = $(".upform input").val();
			});

			$("#up_close").click(function() {
				$(".upform").css("display", "");
				$(".upform input").val("");
			});
			
			

		})
		
		function up(){
			
			const $upInput = $(".upform input");
			
			
			$.ajax({
				url:"updateCategory.ga",
				data:{upCate:$upInput.val(),inCate:$inInput},
				success:function(){
					console.log("업데이트카테고리 ajax 통신성공!!!");
					swal.fire({
				        icon: "success",
				        title: "수정이 완료되었습니다!"
				}).then((확인) => {
				    
	                  document.location.reload();
				    
				});




				},
				error:function(){
					console.log("업데이트카테고리 ajax 통신실패");
				}
			});
		}
		
		function add(){
			
			const $addInput = $(".addform input");
			
			
			$.ajax({
				url:"addCategory.ga",
				data:{addCate:$addInput.val()},
				success:function(){
					console.log("인설트카테고리 ajax 통신성공!!!");
					swal.fire({
				        icon: "success",
				        title: "추가가 완료되었습니다!"
				}).then((확인) => {
				    
	                  document.location.reload();
				    
				});



				},
				error:function(){
					console.log("업데이트카테고리 ajax 통신실패");
				}
			});
		}
	</script>



</body>


</html>