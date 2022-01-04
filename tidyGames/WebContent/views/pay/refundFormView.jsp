<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.ArrayList, com.TidyGames.pay.model.vo.*"%>
    
 <%
	ArrayList<PayGame> order = (ArrayList<PayGame>)request.getAttribute("order");
 	Pay pi = (Pay)request.getAttribute("pi");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    /* 화면전체 div */
       #outer{
        width:1500px;
        height: 1500px;
        margin:auto;
     
    }


    #line1{
        width:1200px;
        height:3px;
        background: white
    
    }

    #text{
        width: 1200px;
        height: 100px;
        margin: auto;
    }

   /* 전체 div */
.container {
	width: 1250px;
	margin: auto;
    
}

#line1 {
	width: 1100px;
	height: 2px;
	background: rgba(255, 255, 255, 0.555);
}
/* 테이블영역 */
.tablecontent{
    width: 1135px;
    margin-left: 178px;
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
/* 환불영역 */
.area2{
        width: 1135px;
        height: 320px;
        float: right;
        margin-right: 180px;
       
    }
    .resonse{
        width: 1135px;
        height: 320px;
        background: rgba(0, 0, 0, 0.445);
    }

    /* 환불사유select */
    #why{
        border-radius: 3px;
        border: 1px solid white;
        background: rgb(227, 220, 210);
        color: black;
        height: 30px;
        width: 400px;
        text-align: center;
        margin-left: 20px;
        font-weight: bold;
    }

    .why{
       display: inline-block; 
       
        width: 450px;
        height: 230px;
        margin-left: 90px;
       
       


    }
    /* 추가글영역 */
    #add{
        float: right;
        width: 480px;
        height: 230px;
        margin-right: 70px;
        background: rgb(227, 220, 210);
        border-radius: 6px;
        display: inline-block;
        margin-top: 40px;
       
    }
    /* 추가글작성 */
    #addtext{
        width: 420px;
        height:120px;
        background: rgb(227, 220, 210);
        margin-left: 25px;
        resize: none;

    }

    /* 환불정보 */
    .area3{
        width: 1130px;
        height: 400px;
        margin-top: 350px;
        margin-left: 180px;
    }

    /* 버튼 */
    .area4{
        width: 1200px;
        height: 100px;
        margin: auto;
        text-align: center;
    }

    .radio {
	background: rgb(227, 220, 210);
	width: 300px;
	height: 40px;
	margin: auto;
	margin-top: 10px;
	padding: 10px;
	font-weight: bold;
    font-size: 14px;
    }
</style>
</head>
<body>
    <body style="background:#0e332c;">
        <div id="outer">
            <%@ include file="../common/topbar.jsp"%>
            <%@ include file="../common/navibar.jsp"%>

           

          
            	
            
                    <div class="container">
                        <span style="color: grey; font-size: 18px;">주문내역</span>
                        <span style="color: white; font-size: 25px; font-weight: bold;"> >환불신청</span><br><br><br>
                        <div id="line1"></div>
                        <br>
            
                        <h4 style="color: white; font-size: 19px;">주문내역</h4>
                    </div>   


                    <div class="tablecontent">
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
                                     <img src="<%=contextPath%>/<%=p.getGameImg()%>" Width="130px" height="90px"></td>
                                <td>
                                    <span>
                                        <%=p.getKorName() %> <br>
                   						<%=p.getEngName() %></span>
                                        
                                </td>
                                <td><span><%=p.getPrice() %></span>원 </td>
                                <td style="color: red;">
                                       <span>-<%=p.getPrice()-p.getDiscountPrice()%></span>원
                                    </td>
                                <td><span><%=p.getDiscountPrice() %> </span>원</td>
                            </tr>
                            	<%} %>
        
        
                            <tr>
                                <td style="text-align:left"><span style="font-size: 14px;">주문번호 : <%=pi.getOrderNo()%></span><br>
                                    <span style="font-size: 14px;">주문날짜 : <%=pi.getPayDate() %></span>
                                </td>
                                <td colspan="4" style="text-align: right; height: 70px;">
                                      <span> 총 금액 :
                                       	<%
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
                
                 <div class="area2">
                     <form action="<%=contextPath%>/reEnroll.pa" method="post" onsubmit="return addCheck();">
            			<input type="hidden" name="orderNo" value="<%=pi.getOrderNo()%>">
                         <div class="resonse">
                        

                            <div class="why">
                                     <div class="radio" style="font-size: 18px; font-weight:bold">환불사유</div>
                                    <div class="radio">
                                        <input type="radio" name="why" value="예상했던게임과다름">  <label>예상하던게임과다름</label>
                                    </div>
                                    <div class="radio">
                                        <input type="radio" name="why" value="게임플레이 및 기술적인문제">  <label>게임플레이 및 기술적인문제</label>
                                    </div>
                                    <div class="radio">
                                        <input type="radio" name="why" value="실수로 구매함"> <label>실수로 구매함</label>

                                    </div>
                                    <div class="radio">
                                        <input type="radio" name="why" value="재미없음"><label>재미없음</label>
                                    </div>
                                    <div class="radio">
                                        <input type="radio" name="why" value="기타"><label>기타</label>
                                    </div>
                                
                            </div>

                            
                            <div id="add" >
                                <br>
                                <div style="font-weight:bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;추가글</div><br>
                                
                                <textarea id="addtext" name="addtext" class="addtext" placeholder="추가글을 작성해주세요"></textarea>
    
                            </div>
            
                       
                        
                        </div>

                   

                </div>


                <div class="area3">
                    <h2 style="color: white;">환불정보</h2>
                        
                    <table class="table"style="color: white;">
                      
                        <tr>
                          <th>주문금액</th>
                          <td>결제금액</td>
                          <th><%=pi.getPayAmount() %> 원</th>
                        </tr>
                      
                      <tbody>
                        <tr>
                          <td></td>
                          <td>할인금액</td>
                          <th>-
                       		<%
							int totaldiscount = 0;
                          for (int i = 0; i < order.size(); i++){ 
                         		totaldiscount += (order.get(i).getPrice() - order.get(i).getDiscountPrice());
							}
							%>
						<%=totaldiscount%> 원 
                          	 
                          
                          </th>
                        </tr>
                        <tr>
                            <td></td>
                          <td>사용한POINT</td>
                          <th><%=pi.getPointAmount()%>POINT</th>
                         
                        </tr>
                        <tr>
                            <td></td>
                          <td>환불예정금액</td>
                          <th>
                          		
								<%=total+pi.getPointAmount()%>원
                          
                          </th>
                         
                        </tr>
                        <tr>
                          <td>결제방법</td>
                          <td></td>
                          <th><%=pi.getPayMethod() %></th>
                        </tr>
                      </tbody>
                    </table>
                   


                </div>

                
                <div class="area4">
                    <a href="" class="btn btn-dark"><i class="fa fa-shopping-cart"></i> 취소</a>
                    <input type="hidden" name="cpage" value="1">
                    <button type="submit" class="btn btn-danger">환불신청하기</button>
                </div>


              
        </form>
        
        </div>
        
        <script>
        
        var addtext = document.getElementById("addtext");
        
        function addCheck(){
        	  if(addtext.value.length==0) {
                  // 추가글이 작성되어있지 않을때
                  alert("추가글을 작성해주세요");
                  return false;
              } 
        	
        
        }
        
        
        </script>
       
       
        
        

</body>
</html>