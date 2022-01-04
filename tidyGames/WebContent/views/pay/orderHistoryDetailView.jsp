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
        height: 1200px;
    }
    #outer>div{
        float:left;
    } 
    #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    }
    /* 글 영역*/
    .area1{
        width: 1000px;
        height: 100px;
        border: 3px solid blue;
        font-weight: bold;
        color: white;
        margin-top: 50px;
        margin-left: 100px;
    }


  /* 주문내역 게임 1개 영역 */
  .area2{
        width: 1000px;
        height: 280px;
        border: 1px solid violet;
        margin-left: 100px;
       
    }
  
    #orderList{
        color:orange;
    }

    /* 회원정보 */
    .area3{
        width: 1000px;
        height: 250px;
        border: 1px solid violet;
        margin-top: 30px;
        margin-left: 100px;
        
    }

    /* 결제정보 */
    .area4{
        width: 1000px;
        height: 350px;
        border: 1px solid violet;
    
        margin-left: 100px;
    }
/* 버튼영역 */
    .area5{
        width: 1000px;
        height: 100px;
        border: 1px solid violet;
        text-align: center;
        margin-left: 310px;
    }

    #orderbar{
        color:orange;
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

        <div class="area1">
            <span style="color: grey; font-size: 18px;"> 주문내역조회 </span>
            <span style="color:white; font-size: 25px; font-weight: bold;"> >주문상세내역</span>
            <div style="background: grey; width: 1000px; height: 2px;"></div>
        </div>
        <br><br><br>
        
    
        <div class="area2">

                <table class="table table-borderless" style="width: 1000px; color:white; border:1px solid grey; background:rgba(20, 20, 20, 0.87)">
                    <thead>
                    <tr>
                        <th colspan="5" style="font-size: 25px; font-weight: bold;">BattleGround</th>
                    
                    </tr>

                
                    </thead>
                    <tbody >
                    <tr>
                        <th colspan="5"><div style="width:950px; height: 2px; background: grey;"></div></th>
                        
                    </tr>
                    <tr>
                        
                        <td colspan="2" rowspan="2" width="200px" height="100px" style="text-align: center;">
                            <img src="<%=contextPath%>/resources/image/battlefield.JPG" width="100px" height="120px">

                        </td> 
                        <td width ="500" height="40px">
                            <br>
                            <div>주문번호 : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <a href="">100000</a></div><br>
                            <div>결제날짜 :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>2021-11-10</span></div><br>
                            
                        </td>
                        </td>
                        
                        <td width = "300px"> 
                            <div style="text-align: center;">결제금액<span style="font-size: 25px;"><br>100000</span></div><br>
                        </td>
                    </tr>

                    
                    </tbody>
                </table>
            </div>
              <div class="area3">
                <div class="container" style="color: white;">
                    <h2>회원정보</h2>
                
                    <table class="table"style="color: white;">
                      
                        <tr>
                          <th>구매자 ID</th>
                          <td>user12</td>
                        
                        </tr>
                      
                      <tbody>
                        <tr>
                          <td>닉네임</td>
                          <td>호빵</td>
                         
                        </tr>
                        <tr>
                            <td>E-MAil</td>
                          <td>hobun@gmail.com</td>
                         
                        </tr>

                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        
                      </tbody>
                    </table>
                  </div>
              </div>
            
                <div class="area4">
                    <div class="container" style="color: white;">
                        <h2>결제정보</h2>
                    
                        <table class="table"style="color: white;">
                        
                            <tr>
                            <th>주문금액</th>
                            <td>결제금액</td>
                            <th>61,000원</th>
                            </tr>
                        
                        <tbody>
                            <tr>
                            <td></td>
                            <td>할인금액</td>
                            <th style="color:red;">-35000원</th>
                            </tr>
                            <tr>
                                <td></td>
                            <td>사용한POINT</td>
                            <th style="color:red;">-3000POINT</th>
                            
                            </tr>
                            <tr>
                                <td></td>
                            <td>총결제금액</td>
                            <th>27500원</th>
                            
                            </tr>
                            <tr>
                            <td>결제방법</td>
                            <td></td>
                            <th>KAKAOPAY</th>
                            </tr>
                        </tbody>
                        </table>
                    </div>

                </div>


                <div class="area5">
                    <a href="#" class="btn btn-dark"> < 이전 </a>
                   
                </div>


            <br><br><br>
       


     </div>

           
    

</body>
</html>