<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tidy Games</title>
<style>
    div{
		box-sizing: border-box;
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
        margin: 25px 80px 0px 370px;
    }
    #line_3{
        width:145px;
        height:3px;
        background: rgba(255, 255, 255, 0.555);
        margin: 8px 0px 0px 355px;
    }
    #box{width:1500px;}
    #tableBox{
        width:800px;
        height:700px;
        margin:auto;
        margin-top:50px;
        margin-bottom: 100px;
        background-color: rgb(197, 197, 197);
        border: 10px solid rgba(255, 255, 255, 0.555);
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
        height:100%;
    }
    #table{
        margin:auto;
        width:700px;
        height:440px;
        background:none;
        color:black;
    }
    .table *{
        font-size:14px;
        padding:20px;
    }
    #checkBox{
        width:20px;
        height:20px;
        margin-top:3px;
    }
    #qnaList{
        color:orange;
    }
    tbody a{
        color:gray;
    }
    .btn{
        margin:0px;
        padding:0px;
    }
    #upfile{padding:0px;}
    #textInput{
        width:100%;
        height:100%;
        padding:0px;
        background:rgba(255, 255, 255, 0.383);
        border:1px solid gray;
    }
    .content{
        margin:0px;
        width:100%;
        height:100%;
        background:rgba(255, 255, 255, 0.383);
        border:1px solid gray;
    }
    #answerTable{
        background:none;
        color:black;
    }
    textarea:focus, input:focus{
        outline:none;
    }
    #table th {font-size:19px;}


</style>
</head>
<body style="background:#0e332c;">

    <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
    
    
    <div id="outer">
        <div id="line_1"></div>
 
        
        <div id="box">
            <div id="intro">QNA</div>
            <div id="line_3"></div>
            <div id="tableBox">
                
                <div id="tableTop">
                    <div id="leftTop">
                        <div>
                        <span>1:1 문의하기</span>
                    </div>
                </div>
            </div>
            
                
        <!-- 로그인을 안 한 사용자는 현재 페이지로 접근할 수 없음! -->
        
            <div id="tableOut1">
            <form action="<%= contextPath %>/insertQna.me" method="post" enctype="multipart/form-data">
 				<input type="hidden" name="user" value="<%= loginUser.getMemNo() %>">
                <table id="table" class="table table-dark" align="center">
                    <tr>
                        <td width="100%" align="center">
                            <input id="textInput" type="text" name="title" placeholder="제목을 입력하세요." style="padding-left:10px">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <textarea class="content" name="content" cols="10" rows="6" style="resize:none; padding:10px"></textarea>
                        </td>
                    </tr>
                    <tr>
                        

                        <td colspan="3"><input id="upfile" type="file" name="upfile">
                        	
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" align="center">
                            <button type="button" onclick="history.back();" class="btn btn-sm btn-secondary">취소</button>
                            <button type="submit" class="btn btn-sm btn-primary">등록</button>
                        </td>
                    </tr>
                </table>
            </form>
            </div> 


            </div>        
                
        </div>
        


        <footer>
            <div style="height:100px"></div>
        </footer>
    </div>



</body>
</html>