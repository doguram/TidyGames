<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .category-area{
        background:#0e332c;
        margin: auto;
    }
    .category{
        display:inline-block; 
        width:100px;
        height:60px;
    }
    .category a{
        text-decoration: none;
        color:rgb(187, 177, 177);
        font-size:17px;
        display:inline-block;
        font-weight:bold;
        width:100%;
        height:100%;
        line-height:40px;
    }
    .category a:hover{
        text-decoration: none;
        color:orange;
    }

    #top{
        text-decoration: none;
        color:white;
        font-size:20px;
        font-weight:bold;
        display:block;
        line-height:70px;
        height:50px;
    }
    
</style>
</head>
<body>
    <div class="category-area" align="center">
        <p id="top">CATEGORY</p>
        <div class="category"><a href="">액션</a></div>
        <div class="category"><a href="">롤플레잉</a></div>
        <div class="category"><a href="">레이싱</a></div>
        <div class="category"><a href="">시뮬레이션</a></div>
        <div class="category"><a href="">전략</a></div>
        <div class="category"><a href="">스포츠</a></div>
        <div class="category"><a href="">인디</a></div>
        <div class="category"><a href="">캐주얼</a></div>
        <div class="category"><a href="">공포</a></div>
        <div class="category"><a href="">멀티플레이</a></div>
        <div class="category"><a href="">카드</a></div>
    </div>

</body>
</html>