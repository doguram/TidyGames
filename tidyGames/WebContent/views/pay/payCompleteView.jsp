<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
     #outer{
        width:1500px;
        margin:auto;
    }
    /* 전체 div */
    .container{
        width: 1250px;
        
        border: 1px solid red;
        margin: auto;
    }

    #line1{
        width:1100px;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    
    }

    .area1{
        width: 800px;
        height: 300px;
        background: rgb(227, 220, 210);
        margin:auto;
        text-align: center;
        font-size: 25px;
        font-weight: bold;
    }

    .area2{
        margin:auto;
        width: 800px;
        height: 200px;
        
    }
    .table th{
        color: white;
        text-align: center;
    }
    .table td{
        color: white;
        text-align: center;
    }

    .area3{
        border: solid 1px blue;
        width: 800px;
        height: 200px;
        margin: auto;
        text-align: center;
    }
</style>
</head>
<body style="background:#0e332c;">

    <div id="outer">
        <%@ include file="../common/topbar.jsp"%>
        <%@ include file="../common/navibar.jsp"%>
    </div>

    <div class="container">
        <span style="color: grey; font-size: 18px;">구매/결제</span>
        <span style="color:white; font-size: 25px; font-weight: bold;"> >결제완료</span>
        <br><br>
        <div id="line1"></div><br>  
        
            <div class="area1">
                <br><br><span>닉네임</span>님의 <br>구매/결제가 완료되었습니다.<br>구매해주셔서 감사합니다.
                <br><span style="font-size: 15px;">주문번호:</span>
            </div>
            <br><br><br><br>
            <div class="area2">
                <table class="table">
                    <tr>
                        <th width="250px"> 총 상품금액</th>
                        <th width="250px"> 할인금액</th>
                        <th width="300px">결제예정금액</th>
                    </tr>
        
                    <tr>
                        <td ><span class="price">0</span>원</td>
                        <td> - <span class="price">0</span>원</td>
                        <td> = <span class="price">0</span>원</td>
                    </tr>
        
                    <tr>
                       <td colspan="3" style="text-align: right;">결제방식 : <span>kakaopay</span></td>
                       
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>

            <div class="area3">
                
                    <a href="#" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> 결제하기</a>
                    <a href="#" class="btn btn btn-secondary"> 장바구니로</a>
            
            </div>
    </div>
</body>
</html>