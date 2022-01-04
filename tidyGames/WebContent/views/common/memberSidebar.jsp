<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #div{ box-sizing: border-box;}
    #sidebarOut{
        height:800px;
        width:210px;
    }
    #sideBox{
        background: rgba(0, 0, 0, 0.212);
        border:2px solid rgba(255, 255, 255, 0.333);
        border-top: none;
        width:100%;
        height:600px;
    }
    #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    }
    #line_2{
        width:100%;
        height:1px;
        background: rgba(255, 255, 255, 0.333);
    }
    #sideBox>ul{
        list-style-type: none;
        padding: 12px;
        margin:0px;
        text-align: center;
    }
    div>ul>li{
        padding: 2px;
        font-weight: lighter;
        font-size:15px;
    }
    div a{
        text-decoration: none;
        color:rgba(255, 255, 255, 0.589);
    }
    #myPageBtn{
        font-size: 18px; 
        color:rgb(85, 73, 59); 
    }
    #sideBox a:hover{
        text-decoration: none;
        color: rgba(255, 166, 0, 0.777); 
    }
    #tidy{
        font-size:20px;
        color:white;
        /* background: rgba(82, 48, 34, 0.438); */
    }

    

</style>
</head>
<body style="background:#0e332c;">

        <div id="sidebarOut">
            
        <div id="sideBox">
            <ul id="tidy">Tidy Games</ul>
            <div id="line_2"></div>
            <ul>
                <li id="myPageBtn" style="font-weight: bolder; margin-top:15px;">마이페이지</li>
                <li><a href="views/member/updateUserCheck.jsp" id="updateUser">내 정보 수정</a></li>
                <li>
                
                <a href="<%= request.getContextPath() %>/cart.pa" id="cartbar">장바구니</a>
               		  
                </li>
            
            </ul>
            <div id="line_2"></div>
            <ul>
                <li><a href="<%= request.getContextPath() %>/wishList.me?cpage=1" id="wishListbar">찜한 내역 조회</a></li>
                <li><a href="<%= request.getContextPath() %>/orderHistory.pa?cpage=1" id="orderbar">주문 내역 조회</a></li>
                <li><a href="<%= request.getContextPath() %>/pointHistory.me?cpage=1" id="pointbar">포인트 이력 조회</a></li>
            </ul>
            <div id="line_2"></div>
            <ul>
                <li><a href="<%= request.getContextPath() %>/myQna.me?cpage=1" id="myQna">나의 문의 내역</a></li>
                <li><a href="<%= request.getContextPath() %>/myReview.me" id="myReview">내 리뷰 조회</a></li>
            </ul>
        </div>


    </div>
</body>
</html>