<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import = 
	"com.TidyGames.member.model.vo.Member,
	 com.TidyGames.company.model.vo.Company,
	 com.TidyGames.member.model.service.MemberService,
	 com.TidyGames.member.model.dao.MemberDao,
	 com.TidyGames.company.model.service.LoginCompanyService,
	 com.TidyGames.company.model.dao.LoginCompanyDao" 
%>
<%
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
	Member loginUser = (Member)session.getAttribute("loginUser");
	Company loginCompany = (Company)session.getAttribute("loginCompany");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        .top-area{
        height:100px;
        display:flex;
        justify-content:space-between;
        margin:auto;
        width:1500px;
    }
    .top-area div{
        display:table-cell;
        color:white;
        float: left;
    }
    .top-area a{
        text-decoration:none;
        color:white;
    }
    .top-area a:hover{
        text-decoration: none;
        color:orange;
    }
    #top1{
        width:200px;
        margin-left:10px;
        margin-top:10px;
    }
    #top1 a{
        font-size:17px;
        font-weight:bold;
    }
    #top2{
       margin-top:20px;
       margin-right:100px;
    }
    #search_box{
        width:600px;
        height:30px;
    }
    #icon_btn{
        background-color:#0e332c; 
        color:white;
        border:0;
        outline:0;
    }
    #icon_btn:hover{
        color:orange;
    }
    #search_form input{width:100%; height:100%;}

    #top3{
        width:60px;
        margin-right:10px;
        margin-top:20px;
    }
    #usericon{padding-left:5px;}
    .top-area{background:#0e332c}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- icon -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


</head>
<body>
   <%
   Cookie[] cookies = request.getCookies();
   
   if(loginUser == null && loginCompany == null && cookies != null){ // 멤버 세션에 값이 없고 쿠키에 값이 있을때 
       for(Cookie c : cookies){
           if(c.getName().equals("MemSessionId")){ // 쿠키에 저장된 Mem객체 sessionId가 있다면?
              String sessionId = c.getValue();
              loginUser = new MemberService().loginMemByCookie(sessionId);
              session.setAttribute("loginUser" ,loginUser);
           } else if(c.getName().equals("ComSessionId")) {
              String sessionId = c.getValue();
              loginCompany = new LoginCompanyService().loginComByCookie(sessionId);
              session.setAttribute("loginCompany" ,loginCompany);
           }
       }
   } 
   %>   

   <% if(alertMsg != null){  %>
      <script>
         alert("<%=alertMsg%>");
      </script>
      <% session.removeAttribute("alertMsg"); %>
   <% } %>
   
    <div class="top-area">
        <div id="top1"><a href="<%=contextPath%>"><img src="<%=contextPath%>/resources/image/tidyLogo.png" width="60px" height="40"> TIDY GAMES</a></div>
        <div id="top2" align="center">
            <form action="<%=contextPath%>/gameList.ga" id="search_form">

                <div id="search_box">
                    <input type="text" name="keyword" style="border-radius:    px;">
                </div>
    
                <div id="search_btn">
                    <button type="submit" id="icon_btn"><i class="fas fa-search"></i></button>
                </div>
            </form>
        </div>
        <div id="top3">
        
           
            <% if(loginUser != null && loginUser.getMemNo() != 1) { %>
            <a href="<%= request.getContextPath()%>/cart.pa?memNo=<%=loginUser.getMemNo()%>"><i class="fas fa-shopping-cart fa-lg"></i></a>
               
            <% } %>
            
            
            
            <% if(loginUser != null && loginUser.getMemNo() != 1) { %>
            	<a href="<%=request.getContextPath()%>/myPage.me" id="usericon"><i class="far fa-user fa-lg"></i></a>
            <% } else if(loginCompany != null) { %>
                <a href="<%=request.getContextPath()%>/myPage.gc" id="usericon"><i class="far fa-user fa-lg"></i></a>
            <% } else if (loginUser != null){ %>
	            <a href="<%=request.getContextPath()%>/memberList.me?cpage=1" id="usericon"><i class="far fa-user fa-lg"></i></a>
    		<% } else {%>        
                <a href="<%=request.getContextPath()%>/login.me" id="usericon"><i class="far fa-user fa-lg"></i></a>
            <% } %>
        </div>
    </div>



</body>
</html>