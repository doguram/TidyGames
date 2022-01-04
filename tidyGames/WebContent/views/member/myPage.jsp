<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tidy Games</title>
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
        font-size: 33px;
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
        width:145px;
        height:3px;
        background: rgba(255, 255, 255, 0.555);
    }
    /* 여기까지 공통 적용 */

    #profileBox{
        border:3px solid black;
        background: rgba(0, 0, 0, 0.300);
        width:700px;
        height:360px;
        margin-top: 80px; 
        margin-left: 190px;
        /*총 길이 : 1500, 센터 : (750 - box)/2 => margin-left*/
    }
    #profileBox>*{
        float: left;
        width: 50%;
    }
    #profileImg>img{
        width:100%;
        height:100%;
    }
    #nick{
        font-size:32px;
        font-weight: bolder;
        color:rgba(255, 255, 255, 0.794);
        margin-top:90px;
        margin-bottom: 0px;
    }
    #id{
        font-size:24px;
        font-weight: bolder;
        color:rgba(0, 0, 0, 0.666);
    }
    #profileImg{
        width:200px;
        height:200px;
        margin: 80px 60px;
    }
    #edit{
        margin: 50px 0px 0px 0px;
        text-decoration: none;
    }
    #edit>a:hover, #edit>span:hover{
        text-decoration: none;
        color: rgba(255, 166, 0, 0.777); 
    }
    #edit>span{
        text-decoration: none;
        color: rgba(255, 255, 255, 0.589);
        cursor: pointer;
    }

</style>
</head>
<body style="background:#0e332c;">
    
    <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
   
    <div id="outer">
        <div id="line_1"></div>
        <div>
            <%@ include file="../common/memberSidebar.jsp" %>
        </div>
        
        <div>
            <div id="intro">프로필</div>
            <div id="line_3" style="margin:10px 50px;"></div>

            <div id="profileBox">

                <div id="box1">
                    <div id="profileImg">
                        <!-- case1. 프로필을 설정하지 않았을 때 -->
                        <img src="<%= contextPath %>/resources/image/profile.png">
                        <!-- case2. 프로필을 설정했을 때 -->
                        <!-- <img> -->
                    </div>
                </div>
            
                <div id="box2">
                    <label id="nick"><%= loginUser.getMemNick() %></label> <br>
                    <label id="id"><%= loginUser.getMemId() %></label>
                    <div id="edit">
                        <a href="<%= contextPath %>/updateUserCheck.me">>> 내 정보 수정</a> <br>
                        <!--<a href="<%= contextPath %>/logout.me">>> 로그아웃</a>-->
                        <span onclick="logout();">>> 로그아웃</span>
                    </div>
                    
                </div>
            </div>

        </div>
        <script>
            function logout(){
            	if(confirm("로그아웃 하시겠습니까?")) {
           	 		location.href = "<%= contextPath%>/logout.me";
            	} 
            }
        </script>

    </div>
</body>
</html>