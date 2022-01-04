<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    div, input, span{
        box-sizing: border-box;
    }
    .outer{
        width: 1500px;
        height: 800px;
        background-color: #0e332c;
        margin: auto;
        margin-top: 50px;
    }
    #logo>*:hover{
        text-decoration: none;
    }
    #content{
        width: 600px;
        height: 550px;
        background-color: rgba(255, 255, 255, 0.5);
        margin: auto;
        margin-top: 50px;
        border-radius: 100px;
        position: relative;
    }
    #login_form{
        width: 80%;
        height: 80%;
        position: absolute;
        margin: auto;
        top: 0px;
        bottom: 0px;
        left: 0px;
        right: 0px;        
    }
    .login_btn>button{
        width: 100%;
        height: 60px;
        border-radius: 100px;
        background-color: #0e332c;
        border: none;
        color: white;
        font-weight: bold;
        font-size: 15px;
    }
    .login_check>label{
        margin-right: 20px;
    }
    .find_login{
        margin-top: 15px;
    }
    .login_check{
        color: white; 
        font-size: 14px;
        margin-top: 30px;
        margin-bottom: 5px;
    }
    .find_login>a{
        color: white;
        font-size: 13px;
    }
    .find_login>a:hover{
        text-decoration: none;
        color:#0e332c;
        font-weight: bold;
    }
    .sns_login{
        margin-top: 25px;
    }
    .sns_login>button{
        width: 100%;
        height: 40px;
        border: none;
        font-size: 13px;
        margin-bottom: 5px;
        font-weight: 600;
    }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>

</head>
<body style="background-color: #0e332c;">

	<% if(alertMsg != null){  %>
		<script>
			alert("<%= alertMsg %>");
		</script>
		<% session.removeAttribute("alertMsg"); %>
	<% } %>

    <div class="outer">
    <header>
        <div id="logo" align="center">
            <a href="<%= contextPath %>">
                <img src="<%=contextPath%>/resources/image/tidyLogo.png" style="width:80px; height: 50px;"> <br>
                <span style="color: white; font-size: 25px; font-weight: bold;">TIDY GAMES</span>
            </a>
        </div>
    </header>

    <content>
        <div id="content" align="center">
            <form action="<%= contextPath %>/memberLogin.me" method="post">
                <div id="login_form">

                    <span style="color: white; font-size: 30px; font-weight: bold;">HELLO!</span>
                    <br><br><br>

                    <div class="form-group">
                        <br>
                        <input type="text" name="userId" class="form-control" placeholder="아이디" id="id" required>
                    </div> 

                    <div class="form-group">
                        <input type="password" name="userPwd" class="form-control" placeholder="비밀번호" id="pwd" required>
                    </div>

                    <div class="login_check" style="margin-top: 50px;">
                        <!--
                        <label for="rememberId">
                            <input type="checkbox" name="rememberId" id="rememberId"> 아이디 기억
                        </label>
                        -->
                        <label for="rememberMe">
                            <input type="checkbox" name="rememberMe" id="rememberMe" value="rememberMe"> 자동 로그인
                        </label>
                        <label for="companyCheck">
                            <input type="checkbox" name="companyCheck" id="companyCheck" value="companyCheck"> 게임사 회원
                        </label>
                    </div>

                    <div class="login_btn">
                        <button type="submit">LOGIN</button>
                    </div>

                    <div class="find_login">
                        <a href="<%=contextPath%>/inputSearchId.me">아이디 찾기</a> ㅣ
                        <a href="<%=contextPath%>/inputSearchPwd.me">비밀번호 재설정</a> ㅣ
                        <a href="<%=contextPath%>/memberEnrollPage.me">회원가입</a>
                    </div>
                    
                    <!--
                    <hr>
                    <div class="sns_login">

                        <button type="button" style="background-color: #03C75A; color: white;">
                            <img src="<%=contextPath%>/resources/image/naverlogin.png" style="height: 18px; margin-left: 10px;" align="left">
                            <div style="margin-right: 35px;">네이버 아이디로 로그인</div>
                        </button>

                        <button type="button" style="background-color: #FFE90A;">
                            <img src="<%=contextPath%>/resources/image/kakaologin.png" style="height: 20px; margin-left: 9px;" align="left">
                            <div style="margin-right: 35px;">카카오 아이디로 로그인</div>
                        </button>
                    </div>
                    -->

                </div>
            </form>

        </div>

    </content>
    </div>
</body>
</html>