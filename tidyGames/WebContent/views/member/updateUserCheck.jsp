<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    div{
        box-sizing: border-box;
    }
    #outer{
        width:1500px;
        margin:auto;
    }
    #outer>div{
        float:left;
    }
    #intro{
        font-size: 30px;
        font-weight: 900;
        color :white;
        margin: 30px 80px 0px 50px;
    }
    #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    }
    #line_3{
        width:200px;
        height:3px;
        background: rgba(255, 255, 255, 0.555);
    }
    #profileBox{
        border:1px solid black;
        background: rgba(0, 0, 0, 0.300);
        width:700px;
        height:360px;
        margin-top: 80px; 
        margin-left: 190px;
        position: relative;
    }
    #text_area{
        width: 80%;
        height: 80%;
        position: absolute;
        margin: auto;
        top: 0px;
        bottom: 0px;
        left: 0px;
        right: 0px;  
    }
    #text_area>div, #text_area>input{
        float: left;
    }
    #updateUser{
        color: orange;
        font-weight: bold;
    }
    .sign_up_main{
        color: white;
        font-size: 15px;
        font-weight: bold;
    }
    #checkPwd{
        /*margin-top:120px;*/
        background: gray;
        border-radius: 100px;
        color: white;
        font-weight: bold;
        border: none;
        font-size: 15px;
        height: 35px;
        width: 70px;
        position: absolute;
        margin: auto;
        top: 250px;
        bottom: 0px;
        left: 0px;
        right: 0px;  
    }
</style>
</head>
<body>
    
    <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
   
    
    <div id="outer">
        <div id="line_1"></div>
        <div>
            <%@ include file="../common/memberSidebar.jsp" %>
        </div>
        
        <div>
            <div id="intro">내 정보 수정</div>
            <div id="line_3" style="margin:10px 50px;"></div>

            <div id="profileBox">
                <form action="<%= contextPath %>/updateUserPage.me" method="post">
                    <div id="text_area">
                        <div class="sign_up_main">● 아이디</div><br>
                        <input type="text" name="userId" value="<%= loginUser.getMemId() %>" style="width: 50%; background-color: gray;" readonly><br><br><br>
        
                        <div class="sign_up_main">● 비밀번호</div><br>
                        <input type="password" name="userPwd" id="userPwd" style ="width: 50%;" required>

                        <button type="submit">확인</button>
                    </div>
                </form>
            </div>

        </div>

    </div>
</body>
</html>