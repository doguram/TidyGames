<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import ="java.util.ArrayList, com.TidyGames.member.model.vo.*"%>
     
 <%
 ArrayList<Point> list = (ArrayList<Point>)request.getAttribute("list");
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
        height: 100px;
        font-weight: bold;
        margin-top: 40px;
        margin-left: 100px;
        background: rgb(227, 220, 210);;
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
        
        margin:30px 0px 10px 120px;
      
      
    }
    .searcharea div{
        display:inline;
    }
    .searcharea form{
        display: inline;
    }

    /* 테이블 영역 */
    .area3{
      
        width: 1050px;
        height: 500px;
        margin: 50px 0px 0px 100px;
       
    }

    #ordercontent{
        color: white;
        text-align: center;

    }

    #pointbar{
        color:orange;
    }

    /* 모달 */
    .pointcontent{
      
      width: 370px; 
      height:40px; 
      color:black;
      margin-top: 20px;
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
            <h2>회원 포인트 내역</h2><br><br>
            <div style="background: grey; width: 1000px; height: 2px;"></div>
        </div>
        <br><br><br>
        
        <!-- 조회div -->
        <div class="area2">
           
            <form action="<%=contextPath%>/adPointSearch.me" method="post">

            

                <div class="searcharea">
                        <div class="search" name="memId">
                            <select class="btn btn-outline-secondary" >
                                <option selected value="memId"  >회원ID</option>
                               <!--<option value="">회원번호</option>  -->
                
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
        </div>




        <!-- 테이블div -->
            <div class="area3">
                <table class="table table-hover" id="ordercontent">
                    <thead>
                      <tr style="background: white; color: black;">
                        
                        <th width="250">회원번호</th>
                        <th width="250">회원ID</th>
                        <th width="250">보유POINT</th>
                        <th width="300"></th>
                       
                       
                      </tr>
                    </thead>
                    <tbody>
                  
                  	<%for(Point po:list ) {%>
                  			
                      <tr>
                		
                        <td class="memNo"><%=po.getMemNo()%></td>
                        <td><%=po.getMemId() %></td>
                        <td id="pointsum"><%=po.getSum()%>POINT</td>
                        <td><!--  <a href="" id="btn" class="btn btn-sm btn-dark" data-toggle="modal" data-target="#pointModal">변경</a>-->
                            <a href="<%= request.getContextPath() %>/adPointDe.me?mNo=<%=po.getMemNo()%>&cpage=1" class="btn btn-success btn-sm">상세보기</a></td>
                      
                     <%} %>
                   
                   </tr> 
                    
                    
                

                    <!-- point modal -->
                  
				<div class="modal" id="pointModal">
					<div class="modal-dialog"  style="width: 400px;">
						<div class="modal-content"> 

							<!-- Modal Header -->
							<div class="modal-header" text-align: center;">
								<h4 class="modal-title" style="margin-left: 75px; font-weight: bold;">회원적립금 등록</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">
							  
								
                                <div class="pointcontent" ">
                                    <b style="margin-top: 20px; id="pointsumModal">회원보유포인트 :</b>
                                    <div class="memPoint"></div>
                                </div>
							 
             					
               	
             				  
                                <div class="pointcontent">
                                    <button  class="btn btn-secondary btn-sm" style="width: 30px; height: 30px; margin-left: 55px;">╊</button>&nbsp;
                                    <button  class="btn btn-secondary btn-sm" style="width: 30px; height: 30px;">─</button>
                                    <input type="text" class="memPoint" name="pointAmount" id="pointA">
                                </div>
                          
                                <div class="pointcontent">
                                    <b style="margin-top: 20px;">&nbsp;
                                      		  적립/차감 내용 :</b> 
                                    <input type="text" class="memPoint" name="pointContent" id="pointC">
                                </div>
                            
                            
                            
                            </div>

							<!-- Modal footer -->
							<div class="modal-footer" >
                                
                                    <button onclick="pointConfirm();" class="btn " style="background: #31665c; color: white;" >적립</button>
                                
                                    <button type="button" class="btn btn-danger"data-dismiss="modal" style="background: rgba(255, 0, 0, 0.815);">취소</button>
                              
							</div>
                          
                    
						</div>
					</div>
				</div>
                    
                 
                      <tr><td></td>
                   
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td>
                     
                      <td></td></tr>
                    </tbody>
                  </table>


            </div>



    </div>
    
    <script>
    
	$(function(){
		
		
			const tmp = $("#pointsum").html();
			
			$("#pointsumModal").html(tmp);
		})
		
		
	function pointConfirm(){
		
		
		$.ajax({
			
			url : "adPointInsert.me",
			data : {
				
				memNo:$(".table-hover>tbody>tr").children().eq(0).text()
				pointAmount: $("#pointA").val()
				pointContent : $("pointC").val()
			},
			type:"post",
			success:function(result) {
				if(result > 0 ) {
					
						if(confirm("포인트변경이 완료되었습니다.")){
    					
    					location.href='<%=contextPath%>/adPoint.me';
    					
    		    		}
					
					
				}else{
					console.log("실패");
				}
				
				
				
			}
			
			
			
			
			
			
		});
		
		
		
		
	}
	
    
    
    </script>

</body>
</html>