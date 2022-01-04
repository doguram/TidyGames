<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String insertId = (String)session.getAttribute("insertId");
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
        height: 600px;
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
        margin-top: 200px;
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
</head>
<body style="background-color: #0e332c;">
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
            <form action="" method="">
                <div id="login_form">

                    <span style="color: white; font-size: 30px; font-weight: bold;">WELCOME!</span>
                    <br><br>

                    <div align="center" style="color: white; font-weight: bold; margin-top:50px;">
                        <span>회원님의 아이디는 <%= insertId %> 입니다.</span>
                        <br>
                        <span>TIDY GAMES의 가족이 되어주셔서 감사합니다!</span>
                        <% session.removeAttribute("insertId"); %>
                    </div>

                    <div class="login_btn">
                        <button type="button" onclick="loginPage();">LOGIN</button>
                    </div>

                </div>
            </form>
            <script>
                function loginPage(){
                    location.href = "<%= contextPath %>/login.me";
                }
            </script>
        </div>
    </content>

    </div>
</body>
</html>