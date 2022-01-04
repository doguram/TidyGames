<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#help{color:orange;}
	.outer{
		size:auto;
		background-color: #0e332c;
		color:white;
		width:1200px;
		margin:auto;
		margin-top:50px;
	}
	.navi{border-bottom:2px solid rgba(255, 255, 255, 0.333);}
	.underline{border-bottom:2px solid rgba(83, 79, 79, 0.333);}
	.view-form{
		size:auto;
	    background-color: lightgray;
	    width:1200px;
	    margin:auto;
	}
	#read-form{
		margin:auto;
		width:1100px;
	}
	#enroll-form input, #enroll-form textarea{
		width:100%;
		box-sizing:border-box;
	 }
	 table{
		 color:black;
	 }
</style>
</head>
<body style="background-color: #0e332c;">

	<%@ include file="../common/topbar.jsp" %>
	<div class="navi"><%@ include file="../common/navibar.jsp" %></div>

    <div class="outer">

        <h2 style="float: left;">TIDY HELP |</h2>
        <h4 style="font-style: oblique; line-height: 2; float: left;">&nbsp;&nbsp;FAQ</h4>
		<br>
		<div align="right">
			<!-- 관리자에게만 보이는 버튼 -->
			<a href="" class="btn btn-sm btn-info">수정</a>
			<a href="" class="btn btn-sm btn-danger">삭제</a>
		</div>
		<br>
        <div class="view-form">
			<br><br>
            <div id="read-form">
				
				<div class="underline">
					<table>
						<tr>
							<th width="60"><h5>제목</h5></th>
							<td width="1000"><h6>이곳은 제목 들어갈 자리</h6></td>
						</tr>
						<tr><td colspan="2" height="20"></td></tr>
					</table>
				</div>

				<div class="underline">
					<table>
						<tr><td colspan="2" height="20"></td></tr>
						<tr>
							<th width="50" style="display: flow-root">
								<h5>내용</h5>
							</th>
							<td>
								<p width="1000" height="20000">
									내용이 들어갈 자리
									<br><br><br><br><br><br><br><br>
									내용자리
									<br><br><br><br>
									쓰는중
								</p>
							</td>
						</tr>
					</table>
				</div>
                <br>
				
            </div>		
        </div>
    </div>
	<br>
	<div align="center">
		<a href="" class="btn btn-sm btn-secondary">이전글</a>
		<a href="noticeListView.jsp" class="btn btn-sm btn-secondary">목록</a>
		<a href="" class="btn btn-sm btn-secondary">다음글</a>
	</div>
	<br><br>
</body>
</html>