<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.TidyGames.pay.model.vo.*, com.TidyGames.member.model.vo.*, com.TidyGames.game.model.vo.*"%>

<%
	ArrayList<Cart> cart = (ArrayList<Cart>) request.getAttribute("cart");
	Point sum = (Point) request.getAttribute("sum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#outer {
	width: 1500px;
	margin: auto;
}
/* 전체 div */
.container {
	width: 1250px;
	
	margin: auto;
}

#line1 {
	width: 1100px;
	height: 2px;
	background: rgba(255, 255, 255, 0.555);
}
/* 테이블 제목단 */
.table tr {
	color: white;
}
/* 테이블 제목 */
thead {
	text-align: center;
}

/* 테이블 내용 */
tbody {
	background-color: #0e1f1c;
	text-align: center;
}

.area {
	width: 1010px;
	height: 800px;
	margin: auto;

}

#left, #right {
	height: 800px;

	box-sizing: border-box;
	float: left;
}

#left {
	width: 500px;
}

#right {
	width: 500px;
}

#left-up, #left-down {
	width: 100%;
	
	box-sizing: border-box;
	float: left;
}

#left-up {
	height: 40%;
}

#left-down {
	height: 60%;
}
/* 할인적용 */
.area1 {
	background: rgb(227, 220, 210);
	width: 300px;
	height: 50px;
	margin: auto;
	margin-top: 30px;
	padding: 10px;
	font-weight: bold;
	font-size: 18px;
	position: relative;
}
/* 전액사용 버튼 */
.use_btn {
	border-radius: 3px;
	border: none;
	background: lightgray;
	font-weight: bold;
	font-size: 13px;
	width: 80px;
	height: 30px;
	position: absolute;
	left: 310px;
	top: 10px
}

#left h3, #right h3 {
	font-size: 18px;
	color: white;
	margin-left: 100px;
	font-weight: bold;
}

#usePoint {
	width: 100px;
	background: rgb(227, 220, 210);
	border-radius: 5px;
}

/* 결제수단 */
.area2 {
	background: rgb(227, 220, 210);
	width: 300px;
	height: 60px;
	margin: auto;
	margin-top: 30px;
	padding: 10px;
	font-weight: bold;
	font-size: 18px;
}
/* 최종결제정보1 */
.area3 {
	background: rgb(227, 220, 210);
	width: 300px;
	height: 60px;
	margin: auto;
	margin-top: 10px;
	padding: 10px;
	font-weight: bold;
	font-size: 18px;
}
/* 최종결제금액2 */
.area4 {
	background: rgb(227, 220, 210);
	width: 300px;
	height: 60px;
	margin: auto;
	margin-top: 30px;
	padding: 10px;
	font-weight: bold;
	font-size: 18px;
}
/* 이용약관 */
#check {
	color: white;
	margin-top: 30px;
}

.area5 {
	width: 400px;
	
	margin-left: 80px;
	text-align: left;
}

.area6 {
	
	width: 230px;
	height: 50px;
	margin: auto;
}

.table-striped td>h4 {
	font-size: 18px;
	margin-top: 30px;
}

 #agreeForm>label{
        color:white;
        margin-left: 5px;
    }
 #agreeForm>input{
     width: 15px;
     height: 15px;
 }
</style>
</head>
<body style="background: #0e332c;">
	<div id="outer">
		<%@ include file="../common/topbar.jsp"%>
		<%@ include file="../common/navibar.jsp"%>
	</div>


	<form action="<%=contextPath%>/pay.pa" method="post" onsubmit="return enrollCheck();">
		<div class="container">
			<span style="color: white; font-size: 25px; font-weight: bold;">구매/결제</span>
			<span style="color: grey; font-size: 18px;"> >결제완료</span> <br> <br>
			<div id="line1"></div>
			<br>


			<table class="table table-striped">
				<thead>
					<tr>

						<th width="200px"></th>
						<th width="300px">게임명</th>
						<th>게임가격</th>
						<th>할인가격</th>
						<th>결제금액</th>
					</tr>
				</thead>
				<tbody>

					<%
						for (Cart c : cart) {
					%>
					<tr>
					<input type="hidden" name="gameNo" value="<%=c.getGameNo()%>">
					
						<td height="120px" style="text-align: right;"><img
							src="<%=contextPath%>/<%=c.getGameImg()%>" Width="130px"
							height="90px"></td>
						<td><h4 style="margin-top: 30px;">
								<%=c.getKorName()%>
								<br>
								<%=c.getEngName()%></h3></td>
						<td><h4><%=c.getPrice()%>원
							</h4></td>
						<td><h4 style="color: red;">
								-<%=c.getPrice() - c.getDiscountPrice()%>원
							</h4></td>
						<td><h4><%=c.getDiscountPrice()%>원
							</h4></td>
					</tr>
					<%
						}
					%>


					<tr>
						<td colspan="5" style="text-align: right; height: 70px;"><h4>
								총 결제금액 :
								<%
							int total = 0;
						for (int i = 0; i < cart.size(); i++) {
							total += cart.get(i).getDiscountPrice();
						}
						%>
								<%=total%>원
							</h4></td>
					</tr>


				</tbody>
			</table>
			<br> <br> <br>
		</div>




		<div class="area">
			<div id="left">
				<div id="left-up">
					<h3>할인적용</h3>
					<div class="area1">&nbsp;TIDY POINT</div>
					<div class="area1">
						<span style="font-size: 15px; text-align: center; color: grey;">&nbsp;
							보유 POINT</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div style="text-align: right; display: inline-block; width: 100px;" id="pointsum"><%=sum.getSum()%></div>&nbsp;<span style="float: right;"></span>POINT
						<div>
							<!-- <button class="use_btn">전액사용</button> -->
						</div>
					</div>
					<div class="area1">
					
						<span style="font-size: 15px; text-align: center; color: grey;">&nbsp;
							사용할 POINT</span> 
					   <%if(sum.getSum()> 0){ %>
							<span style="text-align: right;">
							<input type="text" name="usePoint" id="usePoint" style="text-aglign:right;" value="0">
							</span>&nbsp;POINT
						<%} else {%>
							<input type="text" name="usePoint" id="usePoint" disabled>&nbsp;POINT
						<% } %>	
					</div>
				</div>


				<div id="left-down">
					<h3>결제수단</h3>
					<div class="area2">
						<input type="radio" name="payment" value="Credit" checked> <img
							src="<%=contextPath%>/resources/image/creditcard.png"
							width="50px" height="40px"> Credit Card
					</div>
					<div class="area2">
						<input type="radio" name="payment" value="KAKAOPAY"> <img
							src="<%=contextPath%>/resources/image/kakao.png" width="70px"
							height="40px"> KaokoPay
					</div>
					<div class="area2">
						<input type="radio" name="payment" value="NAVERPAY">&nbsp;
						<img src="<%=contextPath%>/resources/image/naverpay.png"
							width="50px" height="30px"> &nbsp;&nbsp;NaverPay

					</div>
					<div class="area2">
						<input type="radio" name="payment" value="TOSS">&nbsp;&nbsp;
						<img src="<%=contextPath%>/resources/image/toss.png" width="50px"
							height="30px"> &nbsp;Toss
					</div>
				</div>

			</div>

			<div id="right">
				<h3>최종결제정보</h3>
				<div class="area3">
					<span style="font-size: 15px; text-align: center; color: grey;">&nbsp;
						상품금액</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

					<%
						int totalprice = 0;
					for (int i = 0; i < cart.size(); i++) {
						totalprice += cart.get(i).getPrice();
					}
					%>


					<div style="text-align: right; display: inline-block; width: 80px;"><%=totalprice%>
					</div>&nbsp;원
					&nbsp;
				</div>
				<div class="area3" style="color: red;">
					<span style="font-size: 15px; text-align: center; color: red;">&nbsp;
						할인금액</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div style="text-align: right; display: inline-block; width: 80px;">
						-
						<%
								int discount = 0;
							for (int i = 0; i < cart.size(); i++) {
								discount += (cart.get(i).getPrice() - cart.get(i).getDiscountPrice());
							}
							%>
						<%=discount%>
						
			
					</div>&nbsp;원
					&nbsp;

				</div>
				<div class="area3">
					<span style="font-size: 15px; text-align: center; color: grey;">&nbsp;
						사용 POINT</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div style="text-align: right; display: inline-block; width: 70px;" id="usearea">0</div>&nbsp;POINT
					&nbsp;
				</div>
				<div class="area4">
					<span style="font-size: 15px; text-align: center; color: grey;">&nbsp;
						최종결제금액</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div style="text-align: right; display: inline-block; width: 80px;" id="finalpay"><%=total%></div>
					&nbsp;원
					<input type="hidden" name="total" value="<%=total%>">
				</div>
				<div class="area4">
					<span style="font-size: 15px; text-align: center; color: grey;">&nbsp;
						적립 TIDY POINT(5%)</span><br>
						
						
					<div style="text-align: right;" ><%=Math.round(total * 0.05)%>&nbsp;POINT
					</div>
					&nbsp;
					
					<input type="hidden" name="savePoint" value="<%=Math.round(total* 0.05)%>">

				</div>
				<br> <br>

				<div class="area5" id="agreeForm">
				
					 <input type="checkbox" id="allAgree" onclick="checkAll(this);">
                     <label for="allAgree">모두 동의합니다.</label> <br>

                     <input type="checkbox" id="agree1" class="agrees">
                     <label for="agree1">(필수) 구매하실 상품의 상품정보 및 가격을
						확인하였으며,  이에 동의합니다(전자상거래법 제 8조 제 2항)</label> <br>

                     <input type="checkbox" id="agree2" class="agrees"> 
                     <label for="agree2" style="margin-bottom: 0px;">(필수) 상품 구매시 환불요청은 결제완료 후
						2일간 가능하며, <br>포인트는 환불승인이되면 반환됩니다..</label> <br>
                     

				</div>





			</div>
			<br> <br> <br>



		</div>

		<div class="area6">
			<button type="submit" class="btn btn-primary"><i class="fa fa-shopping-cart" ></i> 결제하기</button> 
			<a href="<%=request.getContextPath()%>/cart.pa" class="btn btn btn-secondary"> 장바구니로</a>
		</div>
	</form>


	</div>



	<br>
	<br>


	<script>

		$(function(){
			
			$("#usePoint").keyup(function(){
				const tmp = $("#usePoint").val();
				
				$("#usearea").html(tmp);
			})
			
			
			
		})
		
		$(function(){
			
			$("#usePoint").keyup(function(){
			const tmp = $("#usePoint").val();
			//보유포인트-사용포인트
			$("#pointsum").html(<%=sum.getSum()%>-tmp)
			

			})
			
			
			
		})
		
		
		
		$(function(){
			
			$("#usePoint").keyup(function(){
			const tmp = $("#usePoint").val();
			
			//게임총가격 -할인가격 -사용포인트
			$("#finalpay").html(<%=totalprice%>-<%=discount%>-tmp) // 최종금액으로 전달
			

			})
			
			
			
		})
		
		function checkAll(checkAll){
 
                        const checkboxes 
                            = document.getElementsByClassName('agrees');
                        
                        for(var i=0; i<checkboxes.length; i++) {
                            checkboxes[i].checked = checkAll.checked;
                        }
                    }

	
		

        function enrollCheck(){
        	 // 필수동의용 객체
            var agree1 = document.getElementById("agree1");
            var agree2 = document.getElementById("agree2");
        	
            
            if(agree1.checked == false) {
                // 필수동의1 체크되어있지 않다면
                alert("필수약관에 모두 동의해주셔야 가입이 가능합니다.");
                return false;
            } else if(agree2.checked == false) {
                // 필수동의2 체크되어있지 않다면
                alert("필수약관에 모두 동의해주셔야 가입이 가능합니다.");
                return false;
            }


            return true;
        	
        	
        	
        }
		
		
		
		</script>


	






</body>
</html>