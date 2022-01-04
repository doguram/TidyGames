<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.ArrayList, com.TidyGames.pay.model.vo.*, com.TidyGames.member.model.vo.*"%>
    
 <%
	ArrayList<PayGame> order = (ArrayList<PayGame>)request.getAttribute("order");
 	Pay pi = (Pay)request.getAttribute("pi");
 	Member mi = (Member)request.getAttribute("mi");
 %>
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
        font-weight: bold;
        color: white;
        margin-top: 50px;
        margin-left: 100px;
    }


  /* 주문내역 게임 1개 영역 */
  .area2{
        width: 1000px;
        margin-left: 100px;
       
    }
  
    #orderList{
        color:orange;
    }

        /* 테이블 제목단 */
    .table tr {
        color: white;
        text-align: center;
    }
    /* 테이블 제목 */
    thead {
        text-align: center;
    }

    /* 테이블 내용 */
    .table-striped>tbody>tr>td {background-color: #0e1f1c;}


tbody>tr>td>span {
	
	font-size: 18px;
    text-align: center;
   
}
    /* 회원정보 */
    .area3{
        width: 1000px;
        height: 250px;
        margin-top: 30px;
        margin-left: 100px;
        
    }

    /* 결제정보 */
    .area4{
        width: 1000px;
        height: 350px;
        margin-left: 100px;
    }
/* 버튼영역 */
    .area5{
        width: 1000px;
        height: 100px;
        text-align: center;
        margin-left: 310px;
    }
    
</style>
</head>
<body>
    <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
    <div id="outer">
        <div id="line_1"></div>
        <div>
            <%@ include file="../common/adminSidebar.jsp" %>
        </div>

        <div class="area1">
            <span style="color: grey; font-size: 18px;"> 회원주문관리 </span>
            <span style="color:white; font-size: 25px; font-weight: bold;"> >회원주문상세내역</span>
            <div style="background: grey; width: 1000px; height: 2px;"></div>
        </div>
        <br><br><br>
        
    
        <div class="area2">
            <table class="table table-striped">
                <thead>
                    
                    <tr>
                        <th width="200px"></th>
                        <th width="300px">게임명</th>
                        <th>게임가격</th>
                        <th>할인가격</th>
                        <th>결제금액</th>
                    </tr>
                </thead>
                
                
                <tbody>
    
                 	 <%for(PayGame p : order){ %>
                         
                    <tr>
                        <td height="120px" style="text-align: right;">
                            <img src="<%=contextPath%>/<%=p.getGameImg()%>"Width="130px" height="90px"></td>
                        <td>
                            <span>     
                             <%=p.getKorName() %> <br>
                  		  <%=p.getEngName() %> 
                             </span>
                              
                                
                        </td>
                        <td><span><%=p.getPrice() %></span>원 </td>
                        <td style="color: red;">
                               <span>-<%=p.getPrice()-p.getDiscountPrice()%></span>원
                            </td>
                        <td><span><%=p.getDiscountPrice() %></span>원</td>
                    </tr>
                             
                      	<%} %>
                    
    
                    <tr>
                        <td style="text-align:left"><span style="font-size: 14px;">주문번호 :<%=pi.getOrderNo()%>  </span><br>
                            <span style="font-size: 14px;">주문날짜 :  <%=pi.getPayDate() %> </span>
                        </td>
                        <td colspan="4" style="text-align: right; height: 70px;">
                              <span> 총 금액 :  <%
                          				int total = 0;
                          				for(int i=0; i<order.size(); i++) {
                          					total += order.get(i).getDiscountPrice();	
                          				}
                          
                          				%>
                          				<%=total %>
                                        	
                                      
                            </h2>원</span> 
                            </td>
                    </tr>
    
    
                </tbody>
            </table>
            <br> <br> <br>
                

        </div>


              <div class="area3">
                <div class="container" style="color: white;">
                    <h2>회원정보</h2>
                
                    <table class="table"style="color: white;">
                      
                        <tr>
                          <th>구매자 ID</th>
                          <td><%=mi.getMemId() %></td>
                        
                        </tr>
                      
                      <tbody>
                        <tr>
                          <td>닉네임</td>
                          <td><%=mi.getMemNick() %></td>
                         
                        </tr>
                        <tr>
                            <td>E-MAil</td>
                          <td><%=mi.getMemEmail() %></td>
                         
                        </tr>

                        <tr>
                            <td></td>
                            <td></td>
                        </tr>
                        
                      </tbody>
                    </table>
                  </div>
              </div>
        
                <div class="area4" style="float: right; margin-right: 190px;">
                    <div class="container" style="color: white;">
                        <h2>결제정보</h2>
                    
                        <table class="table"style="color: white;">
                        
                            <tr>
                            <th>주문금액</th>
                            <td>결제금액</td>
                            <th><%=pi.getPayAmount() %> 원</th>
                            </tr>
                        
                        <tbody>
                            <tr>
                            <td></td>
                            <td>할인금액
                             
                   
                            
                            
                            </td>
                            <th style="color:red;">-<%
								int totaldiscount = 0;
	                          	for (int i = 0; i < order.size(); i++){ 
	                         		totaldiscount += (order.get(i).getPrice() - order.get(i).getDiscountPrice());
								}
							%>
							<%=totaldiscount%> 원</th>
                            </tr>
                            <tr>
                                <td></td>
                            <td>사용한POINT</td>
                            <th style="color:red;"><%=pi.getPointAmount()%>POINT</th>
                            
                            </tr>
                            <tr>
                                <td></td>
                            <td>총결제금액</td>
                            <th><%=total+pi.getPointAmount()%> 원 </th>
                            
                            </tr>
                            <tr>
                            <td>결제방법</td>
                            <td></td>
                            <th><%=pi.getPayMethod() %></th>
                            </tr>
                        </tbody>
                        </table>
                    </div>

                </div>


                <div class="area5">
                    <a href="<%=request.getContextPath()%>/adorderHistory.pa" class="btn btn-dark"> < 이전 </a>
                   
                </div>


            <br><br><br>
       


     </div>

           
    

</body>
</html>