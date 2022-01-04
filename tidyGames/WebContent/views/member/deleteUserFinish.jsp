<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
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
    #delete_form{
        width: 80%;
        height: 80%;
        position: absolute;
        margin: auto;
        top: 0px;
        bottom: 0px;
        left: 0px;
        right: 0px;        
    }
    .delete_btn>button{
        width: 100%;
        height: 60px;
        border-radius: 100px;
        background-color: #0e332c;
        border: none;
        color: white;
        font-weight: bold;
        font-size: 15px;
        margin-top: 180px;
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
                <div id="delete_form">
                    <div align="center" style="color: white; font-weight: bold; margin-top:150px;">
                        <span>회원 탈퇴가 완료되었습니다.</span><br>
                        <span>그동안 TIDY GAMES을 이용해주셔서 감사합니다.</span>
                    </div>

                    <div class="delete_btn">
                        <button type="button" onclick="home();">홈으로</button>
                    </div>
                </div>
            </form>
            <script>
                function home(){
                    location.href = "<%= contextPath %>";
                }
            </script>
        </div>
    </content>

    </div>
</body>
</html>