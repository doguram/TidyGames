<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .navi-area{
        background:#0e332c;
    }
    .menu{
        display:table-cell; 
        width:200px;
        height:100px;
    }
    .menu a , .menu div{
        text-decoration: none;
        color:white;
        font-size:19px;
        font-weight:bold;
        display:block;
        width:100%;
        height:100%;
        line-height:100px;
    }
    .menu a:hover, .menu div:hover{
        text-decoration: none;
        color:orange;
        cursor:pointer;
    }
</style>
</head>
<body>

    <div class="navi-area" align="center">
        <div class="menu"><a href="<%=request.getContextPath()%>/notice.no?cpage=1" id="notice">NOTICE</a></div>
        <div class="menu"><div id="library">LIBRARY</div></div>
        <div class="menu"><div id="community">COMMUNITY</div></div>
        <div class="menu"><a href="<%=request.getContextPath()%>/faqList.fa" id="faq">HELP</a></div>
    </div>
    
    <script>
    	$(function(){
    		$("#community").click(function(){
    			<% if(loginUser != null) { %>
    				location.href = '<%= request.getContextPath() %>/list.po?cpage=1';
	    		<%} else {%>
	    			Swal.fire('로그인한 회원만 이용할 수 있는 메뉴입니다.');
    			<% } %>
    		});
    		
    		$("#library").click(function(){
    			<% if(loginUser != null) { %>
    				location.href = '<%= request.getContextPath() %>/library.me';
	    		<%} else {%>
	    			Swal.fire('로그인한 회원만 이용할 수 있는 메뉴입니다.');
    			<% } %>
    		});
    	})
    </script>

</body>
</html>