<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.qna.model.vo.Qna, com.TidyGames.common.model.vo.Attachment" %>

<%
	Qna gq = (Qna)request.getAttribute("gq");
	Attachment at = (Attachment)request.getAttribute("at");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#qnalistgq {
		color: orange;
	}
    div{
		box-sizing: border-box;
		color:white;
		/* border: 1px solid rgba(255, 255, 255, 0.555); */
	}
	#outer{
        width:1500px;
        /* height:1500px; */
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
        margin: 25px 80px 0px 105px;
    }
    #line_3{
        width:125px;
        height:3px;
        background: rgba(255, 255, 255, 0.555);
        margin: 8px 0px 0px 95px;
    }
    #box{
    	width:1290px;	
    	/* border:1px solid rgba(255, 255, 255, 0.222); */
        /* height: */
        
    }
    #tableBox{
        width:800px;
        height:900px;
        margin: 20px 0px 100px 105px;
        background-color: rgb(197, 197, 197);
        border: 10px solid rgba(255, 255, 255, 0.555);
    }
    #tableTop div{
        float:left;
    }
    #leftTop{   
        width:100%;
        /* margin:20px; */
        margin:30px 20px 50px 0px;
    }
    #leftTop span{
        font-size:30px;
        font-weight: bolder;
        color:black;
        margin: 0px 50px 0px 40px;
    }
    #tableOut1{
        width:100%;
        height:60%;
    }
    #tableOut2{
        width:100%;
        height:40%;
        padding:40px;
    }
    #table{
        margin:auto;
        width:700px;
        background:none;
        color:black;
    }
   /* 여기까지 */
    .table *{
        font-size:14px;
        padding:20px;
    }
    #checkBox{
        width:20px;
        height:20px;
        margin-top:3px;
    }
    #blacklist{
        color:orange;
    }
    tbody a{
        color:gray;
    }
    .btn{
        margin:0px;
        padding:0px;
    }
    #table input{
        width:100%;
        height:100%;
        padding:0px;
        background:none;
        border:none;
    }
    .content{
        margin:0px;
        width:100%;
        /* height:100%;         */
        background:none;
        border:none;
    }
    #answerTable{
        background:none;
        color:black;
    }
    #answer{
        background:rgba(255, 255, 255, 0.383);
        border:1px solid gray;
    }

    textarea:focus{
        outline:none;
    }
    #in{
    display: none;
    }
    #up{
    display: inline;
    }
	a.file { color:black; text-decoration:underline; }

</style>
</head>
<body style="background:#0e332c;">

	<%@ include file="../common/topbar.jsp"%>
	<%@ include file="../common/navibar.jsp"%>
    
    
    <div id="outer">
        
        
        <div id="line_1"></div>
            <%@ include file="../common/companySidebar.jsp"%>
        
        
        <div id="box">
            <div id="intro">QNA</div>
            <div id="line_3"></div>
            <div id="tableBox">
            
            <div id="tableTop">
                <div id="leftTop">
                    <div>
                        <span>게임 문의내역 답변</span>
                    </div>
                </div>
            </div>

            <div id="tableOut1">

                 <table id="table" class="table table-dark" align="center">
                    <tr>
                       <th style="border:none; font-size:17px">게임</th>
                       <td colspan="3" style="font-size:16px; font-weight:600; border:none; padding-left:0px"><%=gq.getGameName() %></td>
                        <th style="border:none;" align=right>작성일시 </th>
                        <td style="padding-left:0px; border:none;"><%=gq.getQnaDate() %></td>
                    </tr>
                    <tr>
                        <th width="30" style="font-size:17px">제목</th>
                        <td colspan="3" width="300" style="padding-left:0px">
                            <input type="text" style="font-size:16px" value="<%=gq.getQnaTitle() %>" readonly>
                        </td>
                        <th width="80">작성자</th>
                        <td style="padding-left:0px"><%=gq.getMemNick() %></td>
                        
                    </tr>
                    <tr>
                        <td colspan="6">
                            <textarea name="content" class="content" cols="10" rows="11" style="resize:none" readonly><%=gq.getQnaContent() %></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th width="80">첨부파일 </th>
                        <td colspan="5">
                	<% if(at == null) { %>
                    	<!--case1. 첨부파일이 없을 경우-->
                    	첨부파일이 없습니다.
                    <% }else{ %>
	                    <!--case2. 첨부파일이 있을 경우-->
	                    <a download="<%= at.getOriginName() %>" href="<%=contextPath%>/<%=at.getFilePath() + at.getChangeName()%>" class="file"><%= at.getOriginName() %></a>
	                <% } %>
                </td>
                    </tr>
                </table>


            </div>

            
            <div id="tableOut2" class="answerarea">
            <% if(gq.getQnaCheck().equals("Y")) {%>
                <table id="answerTable" class="table table-dark" align="center">
                    <tr class="">
                        <th width="55" style="padding-right:0px">답변</th>
                        <th width="400"><%=gq.getCompanyName() %></th>
                        <th align=right>작성일시 </th>
                        <td style="padding-left:0px"><%=gq.getQnaAnswerDate() %></td>
                    </tr>
                    <tr>
                        <td colspan="6">
                            <textarea name="answer" id="answer" class="content" cols="10" rows="3" style="resize:none; background: none; border: none;" readonly><%=gq.getQnaAnswer() %></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" align="center">
                        	
                            <button type="button" id="up" class="btn btn-sm btn-primary">수정</button>                            
                            <button onclick="updateAnswer();" id="in" class="btn btn-sm btn-primary">등록</button>           
                            <button onclick="history.back();" class="btn btn-sm btn-secondary">취소</button>
                            
                        </td>
                    </tr>
                </table>
            
            
            
            <%}else{ %>
            
            
                <table id="answerTable" class="table table-dark" align="center">
                    <tr class="">
                        <th width="55" style="padding-right:0px">답변</th>
                        <th width="400"><%=gq.getCompanyName() %></th>
                    </tr>
                    <tr>
                        <td colspan="6">
                            <textarea name="answer" id="answer" class="content" cols="10" rows="5" style="resize:none"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" align="center">
                            <button onclick="insertAnswer();" class="btn btn-sm btn-primary">등록</button>
                            <button onclick="history.back();" class="btn btn-sm btn-secondary">취소</button>
                        </td>
                    </tr>
                </table>
            
            <% } %>

            </div>
     
                
                
        </div>            
      

        <footer>
            <div style="height:100px"></div>
        </footer>
    </div>
</div>

<script>

$(function() {
	$("#up").click(function() {
		$("#in").css("display", "inline");
		$("#up").css("display", "none");
		$("#answer").css({"background":"rgba(255, 255, 255, 0.383)",
        "border":"1px solid gray"});
		$("#answer").removeAttr("readonly");
		
	});
})

function insertAnswer(){
	
	$.ajax({
		url:"insertAnswer.gq",
		data:{
			answer:$("#answer").val(),
			gqno:<%= gq.getQnaNo() %>
		},
		type:"post",
		success:function(result){
			if(result > 0){ 
				swal.fire({
			        icon: "success",
			        title: "등록이 완료되었습니다!"
			}).then((확인) => {
			    
                  document.location.reload();
			    
			});
			}
		},error:function(){
			console.log("답변 작성용 ajax 통신 실패");
		}
	})
	
}

function updateAnswer(){
	
	$.ajax({
		url:"insertAnswer.gq",
		data:{
			answer:$("#answer").val(),
			gqno:<%= gq.getQnaNo() %>
		},
		type:"post",
		success:function(result){
			if(result > 0){ 
				swal.fire({
			        icon: "success",
			        title: "수정이 완료되었습니다!"
			}).then((확인) => {
			    
                  document.location.reload();
			    
			});
			}
		},error:function(){
			console.log("답변 작성용 ajax 통신 실패");
		}
	})
	
}

</script>


</body>
</html>