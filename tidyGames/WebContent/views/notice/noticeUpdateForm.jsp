<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.TidyGames.notice.model.vo.Notice, java.util.ArrayList, com.TidyGames.notice.model.vo.NoticeFile" %>
<%
	Notice n = (Notice)request.getAttribute("noticeUpdate");
	ArrayList<NoticeFile> fileList = (ArrayList<NoticeFile>)request.getAttribute("noticeUpdateFileList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#notice{color:orange;}
	.outer{
		background-color: #0e332c;
		color:white;
		width:1200px;
		height:1100px;
		margin:auto;
		margin-top:50px;
	}
	.include-area{
		width:1500px;
		margin:auto;
		align:center;
		border-bottom:2px solid rgba(255, 255, 255, 0.555);
	}
	.write-form{
	    background-color: lightgray;
	    width:1100px;
	    height:1000px;
	    margin:auto;
	    margin-top:50px;
	}
	#enroll-form input, #enroll-form textarea{
		width:100%;
		box-sizing:border-box;
	 }
	table{
	    margin:auto;
	    color:rgb(46, 45, 45);
	}
	.deleteBtn{
		margin-right: 30px; 
		margin-top: 5px; 
		border: none; 
		background-color: #0e3322; 
		color: white; 
		border-radius: 10px; 
		width: 70px;
	}
	
</style>
</head>
<body style="background-color: #0e332c;">

	<div class="include-area">
		<%@ include file="../common/topbar.jsp" %>
		<%@ include file="../common/navibar.jsp" %>
	 </div>

    <div class="outer">

        <h2>TIDY NOTICE</h2>

        <div class="write-form">
			<br><br>
            <form action="<%=request.getContextPath()%>/noticeUpdate.no?num=<%= n.getNotiNo() %>" enctype="multipart/form-data" id="enroll-form" method="post" onsubmit="return updateCheck();">
				<!-- <input type="hidden" name="userId" value="<%=loginUser.getMemId()%>"> -->
				<input type="hidden" name="fileCheck1" id="fileCheck1">
				<input type="hidden" name="fileCheck2" id="fileCheck2">
				<input type="hidden" name="fileCheck3" id="fileCheck3">
				
                <table>
                    <tr>
                        <th width="70"><h5>제목</h5></th>
                        <td width="830" heigt="30" colspan="3"><input type="text" name="title" required value="<%= n.getNotiTitle() %>"></td>
                    </tr>
                    <tr><td colspan="4" height="20"></td></tr>
                    <tr>
                        <td colspan="4" style="background:white">
                            <textarea rows="20" name="content" required style="resize:none; text-align: left;" align="left"><%= n.getNotiContent() %></textarea>
                        </td>
                    </tr>
                    <tr>
						<td colspan="4" height="20"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<% if(fileList != null) { %> <!-- 첨부되어있던 파일이 있을 경우 -->
							<% for(int i=0; i<fileList.size(); i++) { %> <!-- fileList에 담긴 파일 수 만큼 반복문 돌리기 -->
								<td><img id="view<%=i+1%>" width="250" height="200" onclick="clickF(<%=i+1%>);" src="<%= fileList.get(i).getFilePath() + fileList.get(i).getFileChange() %>"></td>
							<% } %>
							
							<% if(fileList.size() == 1) { %> <!-- 첨부파일이 1개 있었을 경우 -->
								<td><img id="view2" width="250" height="200" onclick="clickF(2);"></td>
								<td><img id="view3" width="250" height="200" onclick="clickF(3);"></td>
							<% } else if(fileList.size() == 2) { %>
								<td><img id="view3" width="250" height="200" onclick="clickF(3);"></td>
							<% } else if(fileList.size() == 0) {%>
								<td><img id="view1" width="250" height="200" onclick="clickF(1);"></td>
								<td><img id="view2" width="250" height="200" onclick="clickF(2);"></td>
								<td><img id="view3" width="250" height="200" onclick="clickF(3);"></td>
							<% } %>
							
						<% } else {%> <!-- 첨부되어있던 파일이 없을 경우 -->
							<td><img id="view1" width="250" height="200" onclick="clickF(1);"></td>
							<td><img id="view2" width="250" height="200" onclick="clickF(2);"></td>
							<td><img id="view3" width="250" height="200" onclick="clickF(3);"></td>
						<% } %>
					</tr>
					<tr>
						<!--<td colspan="4" height="20"></td>-->
						<td height="20"></td>
						<td align="center"><button type="button" class="deleteBtn" onclick="deleteFile(1)">삭제</button></td>
						<td align="center"><button type="button" class="deleteBtn" onclick="deleteFile(2)">삭제</button></td>
						<td align="center"><button type="button" class="deleteBtn" onclick="deleteFile(3)">삭제</button></td>
					</tr>
                </table>
				
				<div style="display:none">
					<input type="file" id="file1" name="file1" onchange="loadFile(this, 1);">
					<input type="file" id="file2" name="file2" onchange="loadFile(this, 2);">
					<input type="file" id="file3" name="file3" onchange="loadFile(this, 3);">
				</div>
				<br><br>

                <div align="right" style="width:1000px">
                    <button type="button" onclick="history.back();" class="btn btn-sm btn-secondary">뒤로가기</button>
                    <button type="reset" class="btn btn-sm btn-info">되돌리기</button>
                    <button type="submit" class="btn btn-sm btn-success">등록</button>
                </div>

				
            </form>

			<script>
				
				// 0은 그대로, 1은 수정, -1은 삭제
				var check1 = 0;	
				var check2 = 0;
				var check3 = 0;

				function clickF(num) {
                    $("#file" + num).click();
                }

				function loadFile(inputFile, num) {

					if(inputFile.files.length == 1) {	// 파일이 선택되었을 경우
						// 파일을 읽어들일 객체
						const reader = new FileReader();
						// 파일을 읽어들일 메소드
						// 해당 파일을 읽어들이는 순간 해당 파일만의 고유한 url 부여
						reader.readAsDataURL(inputFile.files[0]);

						// 파일 읽어들이기가 완료되었을때 실행할 함수 정의
						reader.onload = function(e) {
							// e.target.result -> 읽어들인 파일의 고유한 url 정의되어있음
							switch(num) {
								case 1 : $("#view1").attr("src", e.target.result); check1 = 1; break;
								case 2 : $("#view2").attr("src", e.target.result); check2 = 1; break;
								case 3 : $("#view3").attr("src", e.target.result); check3 = 1; break;
							}
						}
					}else {	// 선택된 파일이 취소된경우
						switch(num) {
								case 1 : $("#view1").attr("src", null); break;
								case 2 : $("#view2").attr("src", null); break;
								case 3 : $("#view3").attr("src", null); break;
						}
					}
				}

				function deleteFile(num) {

					var file1 = document.getElementById("file1");
					var file2 = document.getElementById("file2");
					var file3 = document.getElementById("file3");

					var view1 = document.getElementById("view1");
					var view2 = document.getElementById("view2");
					var view3 = document.getElementById("view3");

					switch(num) {
						case 1 : $("#view1").attr("src", null); file1.value == null; check1 = 1; break;
						case 2 : $("#view2").attr("src", null); file2.value == null; check2 = 1; break;
						case 3 : $("#view3").attr("src", null); file3.value == null; check3 = 1; break;
					}

				}

				function updateCheck(){

					$("#fileCheck1").attr("value", check1);
					$("#fileCheck2").attr("value", check2);
					$("#fileCheck3").attr("value", check3);

					return true;

				}


			</script>

        </div>
        
    </div>
    


</body>
</html>