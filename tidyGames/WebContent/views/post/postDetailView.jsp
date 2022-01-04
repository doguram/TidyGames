<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.TidyGames.post.model.vo.Post, com.TidyGames.common.model.vo.PageInfo,
				 com.TidyGames.post.model.vo.PostFile, java.util.ArrayList"
%>
<%
	Post p = (Post)request.getAttribute("post");
	Post lpn = (Post)request.getAttribute("lpn");
	Post fpn = (Post)request.getAttribute("fpn");
	ArrayList<PostFile> flist = (ArrayList<PostFile>)request.getAttribute("flist");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#community {
	color: orange;
}
#likezone:hover {
	cursor:pointer;
}
.include-area {
	width: 1500px;
	margin: auto;
	align: center;
	border-bottom: 2px solid rgba(255, 255, 255, 0.555);
}

.outer {
	size: auto;
	background-color: #0e332c;
	color: white;
	width: 1200px;
	margin: auto;
	margin-top: 50px;
}

.underline {
	border-bottom: 2px solid rgba(83, 79, 79, 0.333);
}

.view-form {
	size: auto;
	background-color: lightgray;
	width: 1200px;
	margin: auto;
}

#read-form {
	margin: auto;
	width: 1100px;
}

#enroll-form input, textarea {
	width: 100%;
	box-sizing: border-box;
}

table {
	color: black;
}
.like {
	cursor:pointer;
}
#imgForm{
	width: 100%;
	height: 100%;
	margin: auto;
}
#imgForm>img{
	margin: auto;
}
</style>
</head>
<body style="background-color: #0e332c;">

	<div class="include-area">
		<%@ include file="../common/topbar.jsp"%>
		<%@ include file="../common/navibar.jsp"%>
	</div>
	
	

	<div class="outer">

		<h2>
			TIDY COMMUNITY <i class="far fa-comments"></i>
		</h2>
		
		<br>
		<div align="right">
			<% if(loginUser != null && loginUser.getMemNo() == p.getMemNo()) { %>
				<a href="<%= contextPath %>/updateForm.po?cpage=<%=pi.getCurrentPage()%>&num=<%= p.getPostNo() %>" class="btn btn-sm btn-info">수정</a> 
				<button data-toggle="modal" data-target="#deleteModal" class="btn btn-sm btn-danger">삭제</button>
			<% } else if(loginUser != null) { %>
				<button class="btn btn-sm btn-warning" data-toggle="modal" data-target="#reportPostModal">신고</button>
			<% } %>
		</div>
		<br>
		<div class="view-form">
			<br>
			<br>
			<div id="read-form">

				<div class="underline">
					<table>
						<tr>
							<th width="60"><h5>제목</h5></th>
							<td colspan="7"><h6><%=p.getPostName()%></h6></td>
						</tr>
						<tr>
							<td colspan="8" height="20"></td>
						</tr>
						<tr>
							<th width="60">작성자</th>
							<td width="100"><%=p.getPostWriter()%></td>
							<th width="60">작성일</th>
							<td width="200"><%=p.getPostEnroll()%></td>
							<th width="70">조회수</th>
							<td width="80" colspan="3"><%=p.getPostView()%></td>
						</tr>
						<tr>
							<td colspan="8" height="20"></td>
						</tr>
					</table>
				</div>

				<div class="underline">
					<table>
						<tr>
							<td colspan="7" height="10"></td>
						</tr>
						<tr>
							<td width="90%" colspan="7">
								<p style="width: 80%;">
									<div id="imgForm">
										<% for(int i=0; i<flist.size(); i++) { %>
											<img src="<%= contextPath %>/<%= flist.get(i).getFilePath() + flist.get(i).getFileChange() %>" onerror="this.style.display='none'" width="90%;">
										<% } %>
									</div>
								</p>
							</td>
						</tr>
						<tr>
							<td colspan="7"><pre><%=p.getPostContent()%></pre></td>
						</tr>
						<tr>
							<td colspan="7" height="20"></td>
						</tr>
					</table>
					<table>
							<% if(flist.isEmpty()) { %>
								<th width="80">첨부파일</th>
								<td style='font-size:smaller'>첨부파일이 없습니다</td>
							<% } else { %>
									<th width="1000">첨부파일</th>
								<% for(int i=0; i<flist.size(); i++) { %>
									<tr><td><a download="<%= flist.get(i).getFileOrigin() %>" href="<%=contextPath%>/<%=flist.get(i).getFilePath() + flist.get(i).getFileChange()%>"><%= flist.get(i).getFileOrigin() %></td></tr></a>
								<% } %>
							<% } %>
					</table>
					<br>
					<table align="center">
							<tr>
								<td colspan="7" height="20"></td>
							</tr>
							<tr>
								<% if(loginUser != null) { %>
									<td colsapn="4"></td>
									<td id="likezone" onclick="clickHeart();"></td>
									<th>추천</th>
									<td id="licount"></td>
								<% } else { %>
									<td colsapn="4"></td>
									<td colspan="3">로그인한 이용자만 추천할 수 있습니다</td>
								<% } %>
							</tr>
							<tr>
								<td colspan="7" height="20"></td>
							</tr>
					</table>
				</div>
				<br>
				<div class="comment-view">
					<table align="center">
						<thead>
							<tr>
								<% if(loginUser != null) { %>
									<td colspan="2" width="870">
										<textarea rows="3" style="resize:none" id="replyZone" placeholder="댓글을 작성해주세요!"></textarea>
									</td>
									<td style="text-align:center">
										<button class="btn btn-dark" onclick="insertReply();"><i class="fas fa-comment-dots fa-lg"></i></button>
									</td>
								<% }else { %>
									<td colspan="2" width="870">
										<textarea rows="3" style="resize:none" readonly>로그인 후 이용 가능한 서비스입니다</textarea>
									</td>
									<td style="text-align:center">
										<button class="btn btn-dark" disabled><i class="fas fa-comment-dots fa-lg"></i></button>
									</td>
								<% } %>
							</tr>
							<tr>
								<td colspan="3" height="20"></td>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
				<!-- 댓글 -->

				<br>
			</div><!-- read-form -->
		</div><!-- view-form -->
	</div><!-- outer -->
	<br>
	<div align="center">
		<% if(p.getPostNo() != fpn.getFirstPost()) { %>
			<a href="<%=contextPath%>/detail.po?cpage=<%=pi.getCurrentPage()%>&num=<%=p.getPrevNo()%>" class="btn btn-sm btn-secondary"><i class="fas fa-angle-double-left fa-lg"></i></a> 
		<% } %>
		<a href="<%=contextPath%>/list.po?cpage=<%=pi.getCurrentPage()%>" class="btn btn-sm btn-secondary"><i class="fas fa-align-justify fa-lg"></i></a> 
		<% if(p.getPostNo() != lpn.getLastPost()) { %>
			<a href="<%=contextPath%>/detail.po?cpage=<%=pi.getCurrentPage()%>&num=<%=p.getNextNo()%>" class="btn btn-sm btn-secondary"><i class="fas fa-angle-double-right fa-lg"></i></a>
		<% } %>
	</div>
	<br>
	<br>
	
	
	
	<%-- deleteModal --%>
	<div class="modal" id="deleteModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">잠깐!</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	      <div class="modal-body">
	        	정말 게시물을 삭제하시겠습니까? 예를 누르면 삭제됩니다.
	      </div>
	      <div class="modal-footer">
	      	<button id="deletePost" class="btn btn-info">예</button>
	        <button type="button" class="btn btn-danger" data-dismiss="modal">아니오</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<!-- 글 신고 버튼 모달 -->
	<div class="modal" id="reportPostModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">신고 사유를 선택해주세요</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div>
						<input type="radio" id="r1" name="report" value="1" checked>
						<label for="r1">욕설, 비방, 혐오</label>
					</div>
					<div>
						<input type="radio" id="r2" name="report" value="2">
						<label for="r2">부적절한 홍보</label>
					</div>
					<div>
						<input type="radio" id="r3" name="report" value="3">
						<label for="r3">루머 유포</label>
					</div>
					<div>
						<input type="radio" id="r4" name="report" value="4">
						<label for="r4">음란, 청소년 유해</label>
					</div>
					<div>
						<input type="radio" id="r5" name="report" value="5">
						<label for="r5">개인 정보 유출, 명예훼손</label>
					</div>
					<div>
						<input type="radio" id="r6" name="report" value="6">
						<label for="r6">도배, 스팸</label>
					</div>
					<div>
						<input type="radio" id="r7" name="report" value="7">기타(신고사유를 직접 입력해주세요)
					</div>
					<br>
					<div>
						<label for="r7"><textarea id="etc" cols="60" rows="4" style="resize: none" maxlength="158" placeholder="신고 사유 입력 (최대 160자 이내)"></textarea>
					</div>
					<div class="modal-footer">
						<input type="hidden" id="reportPno" name="reportPno" value="<%=p.getPostNo()%>">
						<input type="hidden" id="reportMem" name="reportMem" value="<%=p.getMemNo()%>">
						<button id="postReport" class="btn btn-info">신고완료</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<script>
			$(function(){
				
				selectLikeStatus();
				selectLikeCount();
				selectReplyList(); //모든 요소가 만들어진 뒤 바로 호출하는 메소드
				
				// window 객체에서 제공하는 setInterval(주기적으로실행시킬함수, ms단위) < 자스에서 배움
				// 1초 간격마다 댓글 목록 실행
				setInterval(selectReplyList, 1000);
				
				
				
				$("#deletePost").click(function(){
					var url = "<%= contextPath %>/delete.po?cpage=<%=pi.getCurrentPage()%>&num=<%= p.getPostNo() %>";
					location.href = url;
				});
				
				
				
			});
			// =================== 신고하기 ====================				
				
				$("#postReport").click(function(){
				
					if(false) {
						alert("로그인 후 사용 가능합니다.");
						
					}else{
						$.ajax({
							url:"report.re",
							data:{
								pno:$("#reportPno").val(),
								mno:$("#reportMem").val(),
								sno:$(':radio[name="report"]:checked').val(),
								etc:$("#etc").val(),
								rno:$("input[name=replyReport]").val(),
								remo:$("input[name=writerReport]").val()
							},
							type:"post",
							success:function(result){
								if(result > 0) {
									alert("신고되었습니다.");
									$(".modal").modal("hide");
								}else{
									alert("다시 입력해주세요.")
								}
							}, error:function(){
								alert("오류가 발생했습니다. 다시 시도해주세요.")
							}
						});
				}
			});
				
				
				
			// =================== 댓글 신고 ====================
				
			function reportReply([renum,remem]) {
				
	        	if(confirm('해당 댓글을 신고하시겠습니까?')==true){
	        		
				}else{
					return false;
				}
            
	    		$.ajax({
					url:"replyReport.re",
					data:{rno:renum,
						  remo:remem,
						  pno:<%=p.getPostNo()%>
					},
					success:function(result){
						if(result > 0){
							alert('신고 처리가 완료되었습니다!');
						}
					}, error:function(){
						console.log("댓글 신고 실패");
					}
				})
			};
      		  
				
				
			// =================== 댓글 =======================
			function insertReply(){
				$.ajax({
					url:"rinsert.po",
					data:{
						rcontent:$("#replyZone").val(),
						pno:<%=p.getPostNo()%>
					},
					type:"post",
					success:function(result){
						if(result > 0) {
							selectReplyList();
							$("#replyZone").val("");
						}
					},error:function(){
						console.log("댓글작성용 ajax 통신 실패");
					}	
				})
			};
			
			function deleteReply(renum) {
				
				if(confirm('댓글을 삭제하시겠습니까?')==true){
					alert('댓글이 삭제되었습니다');
				}else{
					return false;
				}
				
				$.ajax({
					url:"rdelete.po",
					data:{renum:renum},
					success:function(result){
						if(result > 0){
							selectReplyList();
						}
					}, error:function(){
						console.log("댓글작성용 ajax 통신 실패");
					}
				})
			};
			
			function selectReplyList(){
				$.ajax({
					url:"rlist.po",
					data:{pno:<%=p.getPostNo()%>},
					success:function(list){
						let result = "";
						
						
						
						for(let i=0; i<list.length; i++) {
							result += "<input type='hidden' class='reportRmem' value='" + list[i].writerNo + "'>"
				       				+ "<tr>"
				       				+ "<th width='70'>" + list[i].replyWriter + "</th>"
				                   	+ "<td width='800' colspan='3'>" + list[i].replyContent + "</td>"
				                   	+ "</tr>";
				                   	
				              if(<%=loginUser.getMemNo()%> == list[i].writerNo) {
				            	result   +=  "<tr>"
				                   + "<td></td>"
						           + "<td style='font-size:smaller'>" + list[i].replyEnroll + "</td>"
						           + "<td width='50' align='right'><button class='btn btn-sm btn-secondary' onclick='deleteReply(" + list[i].replyNo + ");'><i class='fas fa-trash-alt'></i></button></td>"
						           + "</tr>"
						           +  "<tr><td colspan='3' height='20'></td></tr>";
				              } else {
				            	  result   += "<tr>"
				                   + "<td></td>"
				                   //+ "<input type='hidden' class='writerReport' value='" + list[i].writerNo + "'>"
				                   //+ "<input type='hidden' class='replyReport' value='" + list[i].replyNo + "'>"
						           + "<td style='font-size:smaller'>" + list[i].replyEnroll + "</td>"
						           + "<td width='50' align='right'><button class='btn btn-sm btn-warning' onclick='reportReply([" + list[i].replyNo + "," + list[i].writerNo + "])'><i class='far fa-angry'></i></button></td>"
						           //+ "<td width='50' align='right'><button class='btn btn-sm btn-warning' data-toggle='modal' data-target='#reportPostModal'><i class='far fa-angry'></i></button></td>"
						           + "</tr>"
						           +  "<tr><td colspan='3' height='20'></td></tr>";
				              }
						}
						$(".comment-view tbody").html(result);
					},error:function(){
						console.log("댓글목록조회 ajax통신 실패");
					}
				})
			};
			
			// ======================= 좋아요 ========================
			
			function selectLikeCount(){
				$.ajax({
					url:"lcount.po",
					data:{pno:<%=p.getPostNo()%>},
					success:function(result){
						$("#licount").html(result);
					}
				})
			};
			
			function selectLikeStatus(){
				
				$.ajax({
					url:"lstatus.po",
					data:{pno:<%=p.getPostNo()%>},
					success:function(result){
						if(result>0){
							$("#likezone").html("<i class='fas fa-heart fa-lg' style='color:red' onclick='deleteLike();'></i>");
						}else{
							$("#likezone").html("<i class='far fa-heart fa-lg' onclick='insertLike();'></i>");
						}
					},error:function(){
						console.log("좋아요 상태 조회 ajax 통신 실패");
					}
				})
			};

			function insertLike(){
					$.ajax({
					url:"insertlike.po",
					data:{pno:<%=p.getPostNo()%>},
					success:function(result){
						if(result>0){
							selectLikeCount();
							selectLikeStatus();
						}else{
							alert('글 추천 실패 ㅜㅜ')
						}
					}, error:function(){
						console.log("좋아요 클릭 ajax 통신 실패");
					}
				})
			};
			
			function deleteLike(){
					$.ajax({
					url:"deletelike.po",
					data:{pno:<%=p.getPostNo()%>},
					success:function(result){
						if(result>0){
							selectLikeCount();
							selectLikeStatus();
						}else{
							alert('글 추천 해제 실패 ㅜㅜ')
						}
					}, error:function(){
						console.log("좋아요 해제 ajax 통신 실패");
					}
				})
			};

		</script>
</body>
</html>