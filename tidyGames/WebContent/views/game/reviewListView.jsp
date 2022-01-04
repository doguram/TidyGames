<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.game.model.vo.*"%>
<%
	Game g = (Game)request.getAttribute("g");
	Attachment3 at = (Attachment3)request.getAttribute("at");
	int starAvg = (int)request.getAttribute("starAvg");
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .outer{
        width: 1200px;
        height:auto;
        margin: auto;
    }
    .top-line{
        display: inline-block;
        width: 100%;
        height:210px;
        margin-top: 70px;
    }
    .left-area{
        width: 50%;
        height:100%;
        float: left;
        color: white;
        margin: auto;
    }
    .title{
        font-size: 25px;
    }
    .title-img{
        width:50%;
        height:100%;
        float: right;
        object-fit: cover;
    }
    .title-img img{
        width:70%;
        height: 100%;
        margin-right: 80px;
    }
    .middle-area{
        width:100%;
        height: 130px;
        display: inline-block;
    }
    #btngo, #dropdown{
        width:50%;
        height:100%;
    }
    #btngo{
        width:300px;
        margin-left: 500px;
        padding-top: 50px;
    }
    #dropdown{
        float: left;
    }
    #sort, #btn{
        margin-top: 45px;
    }
    .buttom-area{
        width:100%;
        height: 200px;
    }
    .review-list{
        background:rgba(211, 211, 211, 0.281);
        width:80%;
        height:100%;
        margin-top: 20px;
        display: inline-block;
    }
    .content{
        width:70%;
        height:170px;
        float: right;
        margin-top: 10px;
        margin-right: 10px;
    }
    #review-content{
        width:100%;
        height:140px;
        background: rgba(211, 211, 211, 0.644);
    }
    .review-area>thead>tr>th{
        color: white;
    }
    .review-area>thead>tr>td>textarea{
        border-radius: 0  0 15px 0;
        width:700px;
        border: 1px solid black;
    }
    .star-rating {
        display: flex;
        flex-direction: row-reverse;
        font-size: 2.25rem;
        line-height: 2.5rem;
        justify-content: space-around;
        padding: 0 0.2em;
        text-align: center;
        width: 5em;
    }
 
    .star-rating input {
        display: none;
    }
    
    .star-rating label>i{
        -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
        -webkit-text-stroke-width: 1.3px;
        -webkit-text-stroke-color: #35624d;
         cursor: pointer;
    }
    
    .star-rating :checked ~ label>i {
         -webkit-text-fill-color: gold;
    }
    
    .star-rating label>i:hover,
    .star-rating label>i:hover ~ label {
         -webkit-text-fill-color: #fff58c;
    }
    .star{
         font-size: 20px;
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
    .ratings-area{
        font-size: 30px;
    }
    .trtr{
        background: rgb(120, 134, 127);
        color: black;
    }
</style>
</head>
<body style="background-color: #0e332c;">

	<%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>


    <div class="outer" align="center">
        <div class="top-line">
            <div class="left-area">
                <div class="title">
                    <br>
                    <%=g.getKorName()%>
                    <br>
                    <%=g.getEngName()%>
                    <br><br>
                </div>
                <div class="ratings-area" align="center">
                    <div class="star-ratings">
                        <div class="star-ratings-fill space-x-2 text-lg" style="width:<%=starAvg%>%"
                        >
                          <span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                          <span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span><span><i class="fas fa-star"></i></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="title-img">
                <img src="<%=contextPath%>/<%=at.getFilePath() + at.getChangeName()%>">
            </div>
        </div>
        <div class="middle-area">
            <div id="dropdown">
                <select name="sort" id="sort" class="form-control" style="width:160px;">
                    <option value="">==정렬기준==</option>
                    <option value="1">최신순</option>
                    <option value="2">별점높은순</option>
                    <option value="3">별점낮은순</option>
                    <option value="4">추천많은순</option>
                </select>
            </div>
        </div>
        <div class="buttom-area">
        		
			    <div id="review-area">
			    	<table class="review-area">
			    		<thead>
                            <% if(loginUser != null) { //로그인 되어있을 경우%>
			    			<tr>
                                <td></td>
                                <td colspan="2">
                                    <div class="star-rating space-x-4 mx-auto">
                                        <input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
                                        <label for="5-stars" class="star pr-4"><i class="fas fa-star"></i></label>
                                        <input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
                                        <label for="4-stars" class="star"><i class="fas fa-star"></i></label>
                                        <input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
                                        <label for="3-stars" class="star"><i class="fas fa-star"></i></label>
                                        <input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
                                        <label for="2-stars" class="star"><i class="fas fa-star"></i></label>
                                        <input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
                                        <label for="1-star" class="star"><i class="fas fa-star"></i></label>
                                    </div>
                                </td>
                            </tr>
			    			<tr>
			    				<th>리뷰작성</th>
			    				<td>
			    					<textarea id="reviewContent" rows="4" cols="120" style="resize:none"></textarea>
			    				</td>
			    				<td>
			    				<button id="btn" class="btn btn-sm btn-light" onclick="insertReview();">리뷰등록</button>
			    				</td>
								
                            <% }else { // 로그인 안되어있을 경우 %>
                            <tr>
                                <td></td>
                                <td>
                                    <div class="star-rating space-x-4 mx-auto">
                                        <input type="radio" id="5-stars" name="rating" value="5" v-model="ratings"/>
                                        <label for="5-stars" class="star pr-4"><i class="fas fa-star"></i></label>
                                        <input type="radio" id="4-stars" name="rating" value="4" v-model="ratings"/>
                                        <label for="4-stars" class="star"><i class="fas fa-star"></i></label>
                                        <input type="radio" id="3-stars" name="rating" value="3" v-model="ratings"/>
                                        <label for="3-stars" class="star"><i class="fas fa-star"></i></label>
                                        <input type="radio" id="2-stars" name="rating" value="2" v-model="ratings"/>
                                        <label for="2-stars" class="star"><i class="fas fa-star"></i></label>
                                        <input type="radio" id="1-star" name="rating" value="1" v-model="ratings" />
                                        <label for="1-star" class="star"><i class="fas fa-star"></i></label>
                                    </div>
                                </td>
                                <td colspan="2"></td>
                            </tr>
                            <tr>
                                <th>리뷰작성</th>
			    				<td>
			    					<textarea id="reviewContent" rows="4" cols="120" style="resize:none" readonly>로그인 후 이용 가능합니다.</textarea>
			    				</td>
			    				<td><button disabled>리뷰등록</button></td>
                            <% } %> 
			    			</tr>
			    			<tr style="height: 60px;"></tr>
			    		</thead>
			    		<tbody>
                            
                            

			    		</tbody>
			    	
			    	</table>
			    	
			    	<br><br>
			    	
			    	<script>
			    		$(function(){ //페이지로딩되고 곧바로 호출
			    			
			    			selectReviewList();
			    			
			    			setInterval(selectReviewList, 1000); // 1초마다 함수호출
			    			
			    		})
			    		
			    		// ajax로 댓글 작성용
			    		function insertReview(){
			    			
			    		
		                    //별점 선택 안했으면 메시지 표시
		                    if($('input[name="rating"]:checked').val() == null){
		                        alert("별점을 입력해주세요.")
		                        return false;
		                    }
		                    //리뷰 5자 미만이면 메시지 표시
		                    if(document.querySelector('#reviewContent').value.length < 5){
		                        alert("리뷰 내용을 5자 이상 입력해주세요.");
		                        return false;
		                    }
		                    //폼 서밋
			    			$.ajax({
			    				url:"rinsert.ga",
			    				data:{
			    					contents:$("#reviewContent").val(),
			    					gno:<%=g.getGameNo()%>,
			    					star:$('input[name="rating"]:checked').val()
			    				},
			    				type:"post",
			    				success:function(result){
			    					if(result > 0){//댓글작성 성공 => 갱신된 댓글 리스트 조회
			    						selectReviewList();
			    					    $("#reviewContent").val("");
			    					    $('input[name="rating"]').prop("checked", false);
			    					}
			    				},error:function(){
			    					//alert("내용 혹은 별점을 작성 후 다시 시도해주세요.")
			    					console.log("댓글작성용 ajax 통신 실패")
			    				}
			    			})
		                
			    			
			    		}
			    		// ajax로 해당 게시글에 딸린 댓글 목록 조회용
			    		function selectReviewList(){
			    			$.ajax({
			    				url:"rList.ga",
			    				data:{gno:<%=g.getGameNo()%>},
			    				success:function(list){
			    					
			    					//console.log(list);
			    					
			    					let result = "";
			    					let count = 0;
			    					// 반복문이용해서
			    					for(let i=0; i<list.length; i++){
			    						result +=  "<tr class='trtr'>"  
                                                        + "<td colspan='5'>" 
                                                            + "<div class='star-ratings'>"
                                                            + "<div class='star-ratings-fill space-x-2 text-lg' style='width:" + list[i].starNo + "%'" + ">"
                                                                + "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>" + "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>" + "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>"+ "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>"+ "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>"
                                                            + "</div>"
                                                            + "<div class='star-ratings-base space-x-2 text-lg'>"
                                                                + "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>" + "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>" + "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>"+ "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>"+ "<span>" + "<i class='fas fa-star'>" + "</i>" + "</span>"
                                                            + "</div>" 
                                                            + "</div>"
                                                        + "</td>"
                                                        + "<td colspan='3'>" + "</td>"
                                                        + "<td rowspan='3' colspan='2'>" + list[i].recommend + '&nbsp&nbsp' +"<a href=''>"+ "<i style='color:beige;' class='far fa-thumbs-up fa-2x' onclick='recommend()'></i>"+"</a>" + '&nbsp&nbsp&nbsp' + "</td>"
                                                    + "</tr>"
                                                    + "<tr class='trtr'>"
                                                        + "<td colspan='7'>" + list[i].writer + '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp' +  list[i].uploadDate + "</td>"
                                                    + "</tr>"
                                                    + "<tr class='trtr' style='height:100px;'>"
                                                        + "<td colspan='7' style='width:600px;'>" + list[i].contents + "</td>"
                                                    + "</tr>";
                                                        
                                    }
			    					$("#review-area tbody").html(result);
			    					
			    				},error:function(){
			    					console.log("댓글목록조회용 ajax 통신실패");
			    				}
			    			})
			    		}
			    		
			    		function recommend(){
			    			
			    		}

			    	</script>
			    	
			    </div>
        </div>
    </div>
    



</body>
</html>