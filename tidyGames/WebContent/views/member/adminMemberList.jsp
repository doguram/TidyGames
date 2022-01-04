<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.member.model.vo.Member, com.TidyGames.common.model.vo.PageInfo"%>
    
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");

	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int listCount = pi.getListCount();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tidy Games</title>
<style>
    div{
		box-sizing: border-box;
		color:black;
	}
	#outer{
        width:1500px;
        margin:auto;
    }
    #outer>div{float:left;}
    #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    }
    #intro{
        font-size: 33px;
        font-weight: 900;
        color :white;
        margin: 25px 80px 0px 45px;
    }
    #line_3{
        width:145px;
        height:3px;
        background: rgba(255, 255, 255, 0.555);
        margin: 8px 0px 0px 45px;
    }
    #box{
    	width:1290px;	
        
    }
    #tableBox{
        width:1250px;
        height:790px;
        margin: 30px 0px 100px 35px;
        background-color: rgb(197, 197, 197);
        border: 10px solid rgba(255, 255, 255, 0.555);
    }
    #tableTop div{
        float:left;
    }
    #leftTop{   
        width:1%;
        margin: 50px 20px 20px 20px;
    }
    #midTop{
        width:57%;
        margin: 50px 20px 20px 0px;
    }
    #rightTop{
        margin: 55px 20px 20px 80px;
    }
    #midTop span{
        font-size:30px;
        font-weight: bolder;
        color:black;
        margin: 0px 70px 0px 50px;
    }
    #table{
        margin:auto;
        width:1200px;
    }
    #table *{
        height:15px;
    }
    #table th{
        font-size:18px;
    }
    #btn{
        padding:0px;
        width:46px;
        height:24px;
        margin-left:3px;
    }
    #checkBox{
        width:20px;
        height:20px;
        margin-top:3px;
    }
    #memberList{
        color:orange;
    }
    #table td{padding:4px;}
    #tableOut1{
        width:100%;
        height:94%;
    }
    #tableOut2{
        width:100%;
        height:6%;
    }

    #aColor{color:black;}

    .memPoint{
       width: 200px; 
       height:30px; 
       border:1px solid black;
       display: inline-block;
       border-radius: 5px;
       float: right;
       margin-right: 20px;

       
    }
    .pointcontent{
      
       width: 370px; 
       height:40px; 
       color:black;
       margin-top: 20px;
    }

	.memInfo {width:100%;}
    .memInfo td, .memInfo th{
        padding:10px;
        border:1px solid lightgray;
    }
    .memInfo th{ background: rgba(211, 211, 211, 0.281)}
    #btnA {padding:0px; font-weight: 500;}
    #btnA:hover{
   		cursor: pointer;
    	color: darkgreen;
        font-weight:700;    	
    }  
    .memInfo input{
    	width:100%;
    	height:100%;
    	box-sizing: border-box;
    	border:0px;
    	padding-left:10px;
    }
    .memInfo input:focus{
    	outline:none;
        background: lightgray;    	    	
    }
    .memInfo td {padding:0px}
	

</style>
</head>
<body style="background:#0e332c;">

    <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
    
    
    <div id="outer">
        <div id="line_1"></div>
        <div>
            <%@ include file="../common/adminSidebar.jsp" %>
        </div>
        
        <div id="box">
            <div id="intro">회원 관리</div>
            <div id="line_3"></div>
            
      		
      		
    	    <div id="tableBox">
                <div id="tableTop">
                    <div id="leftTop">
                        
                    </div>
                    
                    <div id="midTop">
                        <div>
                            <span>전체 회원 <label style="color:black"><%= listCount %></label></span>
                        </div>
                    </div>
                     <form action="<%=contextPath%>/memberList.me?cpage=1" mathod="get">
                    <div id="rightTop">
                        <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-dark" disabled>회원 ID</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" disabled>
                                <span class="caret"></span>
                                </button>
                                
                                <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">닉네임</a>
                                <a class="dropdown-item" href="#">이 름</a>
                                </div>
                        </div>
                        <div>
	                        <input type="hidden" name="cpage" value="1">
                            <input type="text" id="selectKeyword" name="word" placeholder="조회를 위한 입력">
                        </div>
                        <button type="submit" class="btn btn-sm btn-dark">조회</button>
                    </div>
                </div>
                </form>
                <div id="tableOut1">
                <table id="table" class="table table-hover">
                    <thead>
                        <tr align="center">
                            <!--  <th width="30"><button type="button" onclick="allCheck();" id="btn" class="btn btn-sm btn-outline-secondary" style="width:24px">V</button></th>  -->
                            <th width="30">No.</th>
                            <th width="130">아이디</th>
                            <th width="100">이름</th>
                            <th width="150">닉네임</th>
                            <th width="150">이메일</th>
                            <th width="100">전화번호</th>
                            <th width="100">적립금</th>
                            <th width="100"> </tr>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <% for(Member m : list) {%>
                        <tr align="center" id="memberData">
                            <!-- <td><input type="checkbox" id="checkBox" name="checkBox" value="<%= m.getMemNo() %>" ></td>  -->
                            <td><%= m.getMemNo() %></td>
                            <td><a id="btnA" onclick="selectMember(<%= m.getMemNo() %>);" data-toggle="modal" data-target="#selectModal">
                                <%= m.getMemId() %></a></td>
                            <td><%= m.getMemName() %></td>
                            <td><%= m.getMemNick() %></td>
                            <td><%= m.getMemEmail() %></td>
                            <td><%= m.getMemPhone() %></td>
                            <td>
                                
                            	<!-- contextPath로 point의 현재보유포인트를 불러올 자리 -->
                                <a href="" id="btn" class="btn btn-sm btn-dark" data-toggle="modal" data-target="#pointModal">변경</a>

                            </td>
                            <td>
                            	<a id="btn" onclick="selectMember(<%= m.getMemNo() %>);" class="btn btn-sm btn-basic" data-toggle="modal" data-target="#updateModal">수정</a>
                            	<button id="btn" onclick='blockMember("<%= m.getMemId() %>");' class="btn btn-sm btn-basic">탈퇴</button>
	                        </td>
                        </tr>
                        <% } %>
                    </tbody>
                  </table>
	           
                </div>

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
                                <div class="pointcontent">
                                    <b style="margin-top: 20px;">회원보유포인트 :</b>
                                    <div class="memPoint"></div>
                                </div>

                                <div class="pointcontent">
                                    <button  class="btn btn-secondary btn-sm" style="width: 30px; height: 30px; margin-left: 55px;">╊</button>&nbsp;
                                    <button  class="btn btn-secondary btn-sm" style="width: 30px; height: 30px;">─</button>
                                    <input type="text" class="memPoint "></input>
                                </div>
                          
                                <div class="pointcontent">
                                    <b style="margin-top: 20px;">&nbsp;
                                        적립/차감 내용 :</b> 
                                    <input type="text" class="memPoint "></input>
                                </div>
                            
                            
                            
                            </div>

							<!-- Modal footer -->
							<div class="modal-footer" >
                                
                                    <button type="submit" class="btn " style="background: #31665c; color: white;" >적립</button>
                                
                                    <button type="button" class="btn btn-danger"data-dismiss="modal" style="background: rgba(255, 0, 0, 0.815);">취소</button>
                              
							</div>
                           
                    
						</div>
					</div>
				</div>
				
				
				<!-- 상세보기 modal -->
				
				  <!-- The Modal -->
				  <div class="modal fade" id="selectModal">
				    <div class="modal-dialog modal-lg">
				      <div class="modal-content">
				      
				        <!-- Modal Header -->
				        <div class="modal-header">
				          <h4 class="modal-title">
				          	<div>회원 상세 정보</div>
				          </h4>
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				        </div>
				        
				        <!-- Modal body -->
				        <div class="modal-body">
				        	<div align="center">
				        		<table id="readMem" class="memInfo">
				        			
				        		</table>
				        	</div>
				        </div>
				        
				        <!-- Modal footer -->
				        <div class="modal-footer">
					          <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                        </div>
				        
				      </div>
				    </div>
				  </div>
				
				
				<!-- 정보변경 modal -->
				
				  <!-- The Modal -->
				  <div class="modal fade" id="updateModal">
				    <div class="modal-dialog modal-lg">
				      <div class="modal-content">
				      
						<form action="updateMember.me">
				        <!-- Modal Header -->
				        <div class="modal-header">
				          <h4 class="modal-title">
				          		회원 정보 변경
				          </h4>
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				        </div>
				        <!-- Modal body -->
				        <div class="modal-body">
				        	<div align="center">
				        		<table class="updateInfo memInfo">
				        			
				        		</table>
				        	</div>
				        </div>
				        
				        <!-- Modal footer -->
				        <div class="modal-footer">
   					          <button type="submit" class="btn btn-secondary">정보수정</button>
					          <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                        </div>
				        
						</form>				        

				      </div>
				    </div>
				  </div>
				
				  


				<div id="tableOut2">
	                    <div class="paging-area" align="center">
	                        <!-- 첫 페이지에서는 이전으로 비활성화 -->
	 						<% if(currentPage != 1) { %>
	            				<button onclick="location.href='<%=contextPath%>/memberList.me?cpage=<%=currentPage-1%>';"> &lt; </button>
	           				 <% } %>
	                        
	                        <% for(int p=startPage; p<=endPage; p++) { %>
	                        <!-- 페이징 버튼 활성화 조건 게시물수에 따른 버튼 활성화  -->
	                            <% if(p == currentPage) { %>
	                                <button disabled><%= p %></button>
	                            <% }else { %>
	                                <button onclick="location.href='<%= contextPath %>/memberList.me?cpage=<%= p %>';"><%= p %></button>
	                            <% } %>
	                        <% } %>
	                        
	                        <% if(currentPage != maxPage) { %>
	                            <button onclick="loaction.href='<%= contextPath %>/memberList.me?cpage<%=currentPage+1%>';"> &gt; </button>
	                            <!-- 현재 페이지가 마지막 페이지일 땐 다음으로 버튼 비활성화 -->
	                        <% } %>
                    </div>
                </div>
                
        </div>
    </div>


        <footer>
            <div style="height:100px">
    
            </div>
        </footer>
    
    </div>
    
    <script>
	
    	function blockMember(x){
			 if(confirm("회원을 탈퇴시키겠습니까?")) {
	    	         location.href ='<%=contextPath%>/deleteMember.me?mid='+ x;
			 }
			 
		}
    	
    	function selectMember(result) {
    	
			$.ajax({
				url:"select.me",
				data:{mno:result},
				success:function(m){
					
					table = "<tr>"  
                                +   "<th>회원번호</th>"
                                +   "<td>" + "<input type='text' name='memNo' value='" + m.memNo + "' readonly>" + "</td>" 
                                +   "<th>생년월일</th>"
                                +   "<td>" + "<input type='text' name='memBirth' value='" + m.memBirth + "'>" + "</td>" +
                                "</tr>" +
                                "<tr>"  
                                +   "<th>아이디</th>"
                                +   "<td>" + "<input type='text' name='memId' value='" + m.memId + "'>" + "</td>" 
                                +   "<th>이름</th>"
                                +   "<td>" + "<input type='text' name='memName' value='" + m.memName + "'>" + "</td>" +
                                "</tr>" +
                                "<tr>"  
                                +   "<th>닉네임</th>"
                                +   "<td>" + "<input type='text' name='memNick' value='" + m.memNick + "'>" + "</td>" 
                                +   "<th>성별</th>"
                                +   "<td>" + "<input type='text' name='memGender' value='" + m.memGender + "' maxlength='1'>" + "</td>" +
                                "</tr>" +
                                "<tr>"  
                                +   "<th>전화번호</th>"
                                +   "<td>" + "<input type='text' name='memPhone' value='" + m.memPhone + "'>" + "</td>" 
                                +   "<th>이메일</th>"
                                +   "<td>" + "<input type='text' name='memEmail' value='" + m.memEmail + "'>" + "</td>" +
                                "</tr>" +
                                "<tr>"  
                                +   "<th>주소</th>"
                                +   "<td colspan='3'>" + "<input type='text' name='memAddress' value='" + m.memAddress + "'>" + "</td>" +
                                "</tr>" +
                                "<tr>"  
                                +   "<th>가입일</th>"
                                +   "<td>" + "<input type='text' name='memDate' value='" + m.date + "'readonly>" + "</td>" 
                                +   "<th>탈퇴여부</th>"
                                +   "<td>" + "<input type='text' name='memStatus' value='" + m.memStatus + "'>" + "</td>" +
                                "</tr>" 
                  
                    $("#formInfo").text("회원 상세 정보");
					$(".memInfo").html(table);
					$("#readMem input").attr('readonly', 'readonly');
					
				}, error:function(){
					console.log("멤버조회 오류");
				}
				
			});
			
    	}
		
    	function updateMember() {
				
    	}
			
    </script>

</body>
</html>