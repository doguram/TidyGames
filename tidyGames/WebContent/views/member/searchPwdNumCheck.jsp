<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	int pwdCheckNum = (int)session.getAttribute("pwdCheckNum");
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
    #find_id_form{
        width: 80%;
        height: 70%;
        position: absolute;
        margin: auto;
        top: 0px;
        bottom: 0px;
        left: 0px;
        right: 0px;        
    }
    .search_user>*{
        margin-bottom: 5px;
    }
    .search_user>div{
        width:20%;
        float: left;
        color: white;
        font-size: 15px;
        font-weight: bold;
    }
    .next_btn{
        width: 130px;
        height: 35px;
        border-radius: 10px;
        background-color: #0e332c;
        border: none;
        color: white;
        font-weight: bold;
        font-size: 14px;
        margin-top: 110px;
    }
    .code_btn{
        width: 29%; 
        height: 30px;
        border-radius: 5px;
        background-color: #0e332c;
        border: none;
        color: white;
        font-weight: bold;
        font-size: 14px;
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
                <form action="<%= contextPath %>/checkNum.me" method="post" onsubmit="return check();">
                    <div id="find_id_form">
                        <span style="color: white; font-size: 20px; font-weight: bold;">비밀번호 재설정</span>
                        <br><br><hr>

                        <div align="left">
                            <span style="color: white; font-size: 15px; font-weight: bold;">
                                ● 본인확인 이메일 인증<br>
                            </span>
                            <span style="color: lightgray; font-size: 15px;">
                                입력하신 이메일로 전송된 인증번호(6자리 숫자)를 입력해주세요. <br>
                            </span>
                        </div>
                        <br><br>

                        <div align="left" class="search_user">
                            <div>인증번호</div>
                            <input type="text" id="numCk" name="numCk" style="width: 80%;" required>
                            <br>
                            <input type="hidden" id="pwdCheckNum" name="pwdCheckNum" value="<%= pwdCheckNum %>">
                        </div>
                        <br><br><br>

                        <!--
                        <button type="button" class="next_btn" onclick="page();">이전페이지로</button>
                        -->
                        <button type="submit" class="next_btn">인증번호 확인</button>

                    </div>
                </form>
                <script>
                    /*
                	function page(){
                		
                        location.href ="<%= contextPath %>/inputSearchPwd.me";

                	}
                    */

                    function check(){
                        
                        var numCk = document.getElementById("numCk").value;
                        var pwdCheckNum = document.getElementById("pwdCheckNum").value;

                        if(numCk == pwdCheckNum) {
                            // 인증번호를 제대로 입력했음
                            return true;
                        } else {
                            // 인증번호 제대로 입력 안했음
                            alert("인증번호를 다시 확인해주세요.");
                            return false;
                        }

                    }

                </script>
            </div>
        </content>
    </div>
</body>
</html>