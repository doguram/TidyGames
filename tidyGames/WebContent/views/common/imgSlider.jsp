<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.TidyGames.game.model.vo.Game"%>
<%
	ArrayList<Game> list = (ArrayList<Game>)request.getAttribute("list");
	System.out.println(list);
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>

  /* Make the image fully responsive*/
  #demo{
	  width:1200px;
	  height:370px;
	  margin:auto;
  }
  .carousel-inner{
	  height:330px;
	  margin: auto;
  }
  </style>
</head>
<body>
<%@ include file="topbar.jsp" %>

<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner" align="center">
    
    
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev" style="width:7%;">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next" style="width:7%;">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>

<script type="text/javascript">
	$(function(){ //페이지로딩되고 곧바로 호출
		
		selectGameImgList();
	
	})
	
function selectGameImgList(){
         $.ajax({
            url:"imgSlider.ma",
            success:function(list){
               
               //console.log(list);
               
               let result = "";
               // 반복문이용해서
                  result += "<div class='carousel-item active'>"
                     + "<a href='<%=contextPath%>/detail.ga?gno=" + list[0].gameNo + "'>" 
                     + "<img width='900' height='330' src='<%=contextPath%>/" + list[0].gameImg + "'>"
                              + "</a>"
                           + "</div>"
                           + "<div class='carousel-item'>"
                           + "<a href='<%=contextPath%>/detail.ga?gno=" + list[1].gameNo + "'>" 
                           + "<img width='900' height='330' src='<%=contextPath%>/" + list[1].gameImg + "'>"
                                    + "</a>"
                                 + "</div>"
                                 + "<div class='carousel-item'>"
                                 + "<a href='<%=contextPath%>/detail.ga?gno=" + list[2].gameNo + "'>" 
                                 + "<img width='900' height='330' src='<%=contextPath%>/" + list[2].gameImg + "'>"
                                          + "</a>"
                                       + "</div>";
               $(".carousel-inner").html(result);
               
            },error:function(){
               console.log("댓글목록조회용 ajax 통신실패");
            }
         })
      }
</script>

</body>
</html>
