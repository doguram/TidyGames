<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.ArrayList, com.TidyGames.pay.model.vo.*"%>
    
<%
ArrayList<Refund> list = (ArrayList<Refund>)request.getAttribute("list");
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
    }
    #outer>div{
        float:left;
    } 
    #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    }
    /* 닉네임 포인트내역 글 영역*/
    .area1{
        width: 1000px;
        height: 100px;
       
        font-weight: bold;
        color: white;
        margin-top: 50px;
        margin-left: 100px;
    }
    /* 포인트조회영역 */
    .area2{
        width: 1000px;
        height: 200px;
        
        font-weight: bold;
       
        margin-top: 40px;
        margin-left: 100px;
        background: rgb(227, 220, 210);;
    }


    /* 7일 ,한달, 3개월 6개월 조회버튼 */
    .dateSearch{
        margin: 8px 20px 0px 70px;
        display: inline-block;
        width: 150px;
       
    }
    .dateSearch>button{
        border-radius: 5px;
        font-weight: bold;
        background: none;
    }
    /* 달력 div */
    .datetable{
        display: inline-block;
      
    }
    .datetable>input{
        border-radius: 5px;
        
    }
   /* 분류 */
   .search{
       border: 1px;
        margin-right: 10px;
       
   }
   /*  분류 검색창 영역 */
   .searcharea{
        width: 1000px;
        height: 70px;
        
        margin:30px 0px 10px 90px;
      
      
    }
    .searcharea div{
        display:inline;
    }
    .searcharea form{
        display: inline;
    }

    /* 테이블 영역 */
    .area3{
       
        width: 1000px;
        height: 500px;
        margin: 50px 0px 0px 100px;
       
    }

    #ordercontent{
        color: white;
        text-align: center;

    }

    #refundList{
        color:orange;
    }

    /* 처리,미처리 select */
    .pointstatus{
        display: inline-block;
        margin-left: 30px;
        margin-right: 30px;
    }

    .pointstatus>select{
        border-radius: 5px;
        background: white;
        width: 120px;
        height: 30px;
        text-align: center;
        font-weight: bold;
        
    }
    select>option{
        font-weight: bold;
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
            <span style="color:white; font-size: 25px; font-weight: bold;"> 환불요청목록</span>
            <span style="color: grey; font-size: 18px;"> >환불처리 </span>
            <div style="background: grey; width: 1000px; height: 2px;"></div>
        </div>
        <br><br><br>
        
        <!-- 조회div -->
        <div class="area2">
           
          

            	<form action="<%=contextPath%>/adRefundSearch.pa" method="post">
                <div class="searcharea">
                        <div class="search">
                            <select class="btn btn-outline-secondary" name="refundSearch" >
                                <option selected value="memId" name="memID">회원ID</option>
                                <option value="OrderNo" name="orderNo" >주문번호</option>
                
                            </select>
                        
                        </div>
                    
        
                        <div id="game_search">
                            <input type="text" name="keyword" style="border-radius: 3px; width: 600px; height:40px; border: 1px solid white;" placeholder="검색명을 입력하세요.">
                        </div>
                        
                        <div id="search_btn">
                            <button type="submit" id="icon_btn" style="background: none;"><i class="fas fa-search"></i></button>
                        </div>
               
               
                </div> 
					</form>
               <%for(Refund rf : list){ %>
             <form action="<%=contextPath%>/adRefundDate.pa?mNo="<%=rf.getMemNo()%>" action="post">
               	
               <%} %>
                <div class="dateSearch">
                   <!--
                   <button name="weekend">일주일</button>
                   <button name="month">1개월</button>
                   <button name="threemonth">3개월</button>
                   <button name="sixmonth">6개월</button>
                    -->
                </div>
 			
               <div class="datetable">
                    <input type="date" name="startDate" class="date">
                    <span style="color:black">&nbsp;&nbsp; ~ &nbsp;&nbsp;</span>
                    <input type="date" name="endDate" class="date">
                </div>
            

                <div class="pointstatus">

                    <select name="select">
                        <option name="all"  value="all" selected>전체상태</option>
                        <option name="confirm" value="confirm">처리</option>
                        <option name="noConfirm" value="noConfirm">미처리</option>

                    </select>
                </div>
                
                <button type="submit" class="btn btn-sm btn-secondary" style="width: 50px; height: 35px;">조회</button>

            </form>
        </div>




        <!-- 테이블div -->
            <div class="area3">
                <table class="table table-hover" id="ordercontent">
                    <thead>
                      <tr style="background: white; color: black;">
                        <th>환불번호</th>
                        <th>주문번호</th>
                        <th>회원ID</th>
                        <th>결제일</th>
                        <th>결제금액</th>
                        <th>작성시간</th>
                        <th>상태</th>
                        <th></th>
                      </tr>
                    </thead>
                    
                    <tbody>
                    
                     <%for(Refund rf : list){ %>
                      <tr>
                        <td><%=rf.getRefundNo()%></td>
                        <td><%=rf.getOrderNo() %></td>
                        <td><%=rf.getMemId() %></td>
                        <td><%=rf.getPayDate() %></td>
                        <td><%=rf.getPayAmount() %>원</td>
                        <td><%=rf.getRefundDate() %></td>
                        <td>
                        	<% if(rf.getRefundStatus().equals("N")){ %>
                        			<span style="color: red;">미처리</span>  
                      		<%} else { %>
                      			     <span style="color: blue;">처리</span>	
                      		<%}  %>
                        
                        </td>
                        
                        <td><a href="<%=request.getContextPath()%>/adRefundHandle.pa?ono=<%=rf.getOrderNo()%>&memNo=<%=rf.getMemNo()%>" class="btn btn-success btn-sm">상세보기</a></td>
                      </tr>
                      
                      <%} %>
                     

                      <tr><td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td></tr>
                    </tbody>
                  </table>


            </div>



    </div>

</body>
</html>