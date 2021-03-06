<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.game.model.vo.*"%>
<%
	Game g = (Game)request.getAttribute("g");
	ArrayList<Attachment3> alist = (ArrayList<Attachment3>)request.getAttribute("alist");
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
     .outer{
        width: 1200px;
        height:1100px;
        display:flex;
        margin: auto;
        margin-top: 70px;
        background: lightgray;
        flex-wrap: wrap;
    }
    .update-form{
        width: 1200px;
        height:1100px;
        display:flex;
        margin: auto;
        margin-top: 70px;
        background: lightgray;
        flex-wrap: wrap;
    }
    .title{
        color: black;
        font-size:25px;
        margin-bottom: 50px;
    }
    .left-area{
        height: 700px;
        width: 700px;
    }
    #big{
        width:700px;
        height:300px;
    }
    .img11 img, .img11 video{
        width:100%;
        height: 100%;
        object-fit: cover;
    }
    #small{
        background: darkgrey;
        width:700px;
        height:120px;
    }
    #small img{
        width:140px;
        height:90px;
        margin:15px;
    }
    .right-area{
        width:500px;
        height: 700px;
        margin-top: 141px;
    }
    #t-img{
        width:450px;
        height:200px;
        margin: auto;
    }
    .right-area div{
        color: black;
        margin-left: 15px;
    }
    #price{
        width: 200px;
        height:40px;
        margin-top: 30px;
    }
    #content{
        width:450px;
        height:110px;
    }
    .category-btn{
        background: rgb(102, 107, 112);
        text-decoration: none;
        font-size: 12px;
        color:black;
        padding: 5px;
        margin: 5px;
        border-radius: 5px;
    }
    .file-area{
        width:1200px;
        height: 200px;
    }
    .file-area button{
        width:130px;
        height: 50px;
        margin:30px;
        border-radius: 7px;
        font-weight: bold;
    }
    .file-area input{
        margin:-10px;
    }
    #alpha{
        margin-left: 100px;
    }
    .menu-name{
        color: rgba(255, 255, 255, 0.712);
        font-weight: bold;
        font-size: 30px;
        margin-top: 50px;
        margin-left:450px;
    }
    .video-container {
	    position: relative;
	    height: 0;
	    padding-bottom: 56.25%;
	}

	.video-container iframe {
	    position: absolute;
	    top: 0;
	    left: 0;
	    width: 100%;
	    height: 100%;
	}
</style>
</head>
<body style="background-color: #0e332c;">

	<%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
    <%@ include file="../common/companySidebar.jsp"%>


    <div class="menu-name">
        <h2>?????? ????????????</h2>
    </div>

    <div class="outer">
       <form action="<%=contextPath%>/update.gc" class="update-form" method="post" enctype="multipart/form-data">
			<input type="hidden" value="<%=g.getGameNo()%>" name="gno">
            <div class="left-area">
                <div class="title">
                    <input type="text" placeholder="???????????????" name="korName" value="<%=g.getKorName()%>" required><br>
                    <input type="text" placeholder="???????????????" name="engName" value="<%=g.getEngName()%>" required>
                </div>
               
                <div  class="img11" id="big">
                	<% if(alist.get(alist.size()-1).getFileLevel() == 3) { %>
                		<input type="hidden" name="originFileNo1" value="<%= alist.get(alist.size()-1).getFileNo() %>"
>                    	<video src="<%= contextPath %>/<%=alist.get(alist.size()-1).getFilePath() + alist.get(alist.size()-1).getChangeName() %>" id="video" controls autoplay muted onclick="chooseFile(1);" ></video>
                    <% }else { %>
                    	<video src="" id="video" controls autoplay muted onclick="chooseFile(1);" ></video>
                    <% } %>
                </div>
                
                <div style="display:none;">
                <input type="file" name="file1" id="file1" onchange="loadImg(this, 1);">
                </div>
                
                <div class="img11" id="small" align="center">
                	<% for(int i=1; i<5; i++) { // 1 2 3 4%>
                		<% if(i < alist.size() && alist.get(i).getFileLevel() == 2) { %>
                			<input type="hidden" name="originFileNo<%= i+1 %>" value="<%=alist.get(i).getFileNo()%>">
                    		<img src="<%= contextPath %>/<%=alist.get(i).getFilePath() + alist.get(i).getChangeName() %>" id="contentImg<%=i %>" onclick="chooseFile(<%=i+1%>);">
                    	<% }else{ %>
                    		<img src="" id="contentImg<%=i %>" onclick="chooseFile(<%=i+1%>);">
                    	<% } %>
                    	
                	<% } %>
                	
                	<div style="display:none;">
	                    <input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
	                    <input type="file" name="file3" id="file3" onchange="loadImg(this, 3);">
	                    <input type="file" name="file4" id="file4" onchange="loadImg(this, 4);">
	                    <input type="file" name="file5" id="file5" onchange="loadImg(this, 5);">
                	</div>
                	
                </div>
            </div>
           
            <div class="right-area">
                <div class="info-area">
                    <div class="img11" id="t-img">
                    
                			<input type="hidden" value="<%=alist.get(0).getFileNo()%>" name="originFileNo6">
    						<!-- ????????? ?????? ??????????????? ????????? ??????????????? ????????? ????????? ???????????? ????????? ????????????...?????????????????? ????????? -->
                        	<img src="<%= contextPath %>/<%=alist.get(0).getFilePath() + alist.get(0).getChangeName() %>" name="titleImg" id="titleImg"  onclick="chooseFile(6);">
                        	
                        	<div style="display:none;">
                        	<input type="file" name="file6" id="file6" value="" onchange="loadImg(this, 6);">
                        	</div>
                    </div>
                    
                    <div id="price">
                        <span>????????? : <input type="text" name="price" value="<%=g.getPrice()%>"></span>
                    </div>
                    <br>
                    <div id="content">
                        <textarea name="content" id="" cols="55" rows="6" placeholder="?????? ?????? ??? ?????? ??????" required><%=g.getGameIntro()%></textarea>
                    </div>
                    <br><br><br>
                     <tr>
                        <th>?????????</th>
                        <td><input type="text" value="<%=g.getReleaseDate()%>" name="releaseDate" readonly></td>
                     </tr>
                    <br>
                     <tr>
                        <th>??????</th>
                        <td>
                            <select name="genre" id="genre">
                                <option value="">????????????</option>
                        	<% for(Category c : list) {%>
                        		<option value="<%=c.getCategoryNo()%>"><%=c.getCategoryName()%></option>
                        	<% } %>
                            </select>
                        </td>
                     </tr>
                     <br>
                     <tr>
                        <th>????????????</th>
                        <td>
                            <select name="player" id="player">
                            	<option value="">??????????????????</option>
                                <option value="1">??????????????????</option>
                                <option value="2">??????????????????</option>
                            </select>
                        </td>
                     </tr>
                     <br>
                     <tr>
                        <th>????????????</th>
                        <td>
                            <select name="tag" id="tag">
                                <option value="">????????????</option>
                        	<% for(Category c : list) {%>
                        		<option value="<%=c.getCategoryNo()%>"><%=c.getCategoryName() %></option>
                        	<% } %>
                            </select>
                        </td>
                     </tr>
                 </div>
               </div>
          
                    <br>
            <div class="file-area" align="center">
                <pre style="font-weight: bold; font-size: 17px;">
            ??????????????? ??????      ????????????/???????????? zip?????? ??????
                                </pre>
                            
                <input type="file" name="alpha" id="alpha">
                <input type="file" name="minimum">
                <br><br>
                <button type="submit" class="btn btn-sm btn-success" style="width:150px;">?????? ???????????? ??????</button>
            </div>

        </form>
                
     </div>
		          <script>
			          function loadImg(inputFile, num){
				            if(inputFile.files.length == 1) { //??????????????? ????????????
				                 
				               // ????????? ???????????? FileReader ?????? ??????
				               const reader = new FileReader();
				               
				               // ????????? ??????????????? ?????????
				               reader.readAsDataURL(inputFile.files[0]);
				               // ?????? ????????? ??????????????? ?????? ?????? ??? ???????????? ?????????  url??????
				
				               // ?????? ?????????????????? ???????????? ??? ????????? ????????? ???????????????
				               reader.onload = function(e){ // ??????????????? ????????? ???????????? ?????? ?????????????????????
				                   // e.target.result => ???????????? ????????? ????????? url
				                   switch(num){
				                       case 1:$("#video").attr("src", e.target.result); break;
				                       case 2:$("#contentImg1").attr("src", e.target.result); break;
				                       case 3:$("#contentImg2").attr("src", e.target.result); break;
				                       case 4:$("#contentImg3").attr("src", e.target.result); break;
				                       case 5:$("#contentImg4").attr("src", e.target.result); break;
				                       case 6:$("#titleImg").attr("src", e.target.result); break;
				                   }
				               }
				
				            }else{ // ?????? ??????????????? ???????????? ?????????
				               switch(num){
				                       case 1:$("#video").attr("src", null); break;
				                       case 2:$("#contentImg1").attr("src", null); break;
				                       case 3:$("#contentImg2").attr("src", null); break;
				                       case 4:$("#contentImg3").attr("src", null); break;
				                       case 5:$("#contentImg4").attr("src", null); break;
				                       case 6:$("#titleImg").attr("src", null); break;
				                   	}
				           		 }
				      		 }	
	                   function chooseFile(num){
	                   		$("#file" + num).click();
	                   	}	
		       		</script>
                           <!-- ???????????? ?????????????????? ?????????????????? (??????)
                        	$(function(){
                        		$("#update-form option").selected(function(){
                        			$("#tag").append("<button id ='child' value='1234'></button>");
                        		})
                        	})
                        	
                        	???????????? ?????????????????? ????????????
                        	$(function(){
                        		$("#update-form option").each(function(){
                        			if($(this).text() == ?????? ???????????? ???????????????){
                        				$(this).attr("selected", true)
                        			}
                        		})
                        	})
    
	 						-->


</body>
</html>