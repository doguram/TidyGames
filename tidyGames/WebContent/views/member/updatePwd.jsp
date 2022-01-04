<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.TidyGames.member.model.vo.Member" %>
<%
	String contextPath = request.getContextPath();
	Member searchUser = (Member)session.getAttribute("searchUser");
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
    #search_id_form{
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
        width: 120px;
        height: 35px;
        border-radius: 10px;
        background-color: #0e332c;
        border: none;
        color: white;
        font-weight: bold;
        font-size: 14px;
        margin-top: 170px;
    }
    .code_btn{
        width: 29%; 
        height: 25px;
        border-radius: 5px;
        background-color: #0e332c;
        border: none;
        color: white;
        font-weight: bold;
        font-size: 14px;
    }
    .updatePwd>input{
        width: 60%;
        margin-bottom: 5px;
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
                <form action="<%= contextPath %>/updatePwd.me" method="post" onsubmit="return check();">
                    <div id="search_id_form">
                        <span style="color: white; font-size: 20px; font-weight: bold;">비밀번호 재설정</span>
                        <br><br><hr>

                        <div align="left">
                            <span style="color: white; font-size: 15px; font-weight: bold;">
                                ● 변경할 비밀번호를 입력해주세요.
                            </span>
                            <br><br>

                            <div class="updatePwd">
                                <input type="password" id="updatePwd" name="updatePwd" placeholder="새 비밀번호 입력" style="float: left; margin-right: 10px;">

                                <input type="password" id="checkPwd" placeholder="새 비밀번호 확인" style="float: left; margin-right: 10px;"><br>
                                <br><br>
                                <span style="color: lightgray; font-size: 14px;">
                                    8~16자의 영문 대소문자, 숫자, 특수문자(!,@,#,$,%,^,&,*) 사용 가능합니다.
                                </span>
                                <input type="hidden" name="userId" value="<%= searchUser.getMemId() %>">
                            </div>

                        </div>
                        
                        <button type="submit" class="next_btn">변경</button>

                    </div>
                </form>
                <script>
                    function check(){
                        
                        var updatePwd = document.getElementById("updatePwd").value;
                        var checkPwd = document.getElementById("checkPwd").value;
                        var regExp = /^[a-z\d!@#$%^&*]{8,16}$/i;
                        
                        if(regExp.test(updatePwd) == true) {
                            // 비밀번호 양식이 맞음
                        } else {
                            // 비밀번호 양식이 다름
                            alert("비밀번호 양식을 다시 확인해주세요.");
                            return false;
                        }
                        
                        if(updatePwd == checkPwd) {
                            // 비밀번호가 서로 같음
                        } else{
                            // 비밀번호가 서로 다름
                            alert("비밀번호가 일치하지 않습니다.");
                            return false;
                        }

                        return true;

                    }
                </script>
            </div>
        </content>
    </div>
</body>
</html>