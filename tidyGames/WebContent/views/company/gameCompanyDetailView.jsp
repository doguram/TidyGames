<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#mypagegc{
	color: orange;
	}
		
    .outer{
        width:1500px;
        height:800px;
        margin: auto;
    }
    .info{
        background: #d1d3d3e8;
        width: 700px;
        height: 400px;
        font-weight: bold;
        border-radius: 7px;
        margin-top: 80px;
        padding-top: 30px;
    }
    .menu-name{
        color: rgba(255, 255, 255, 0.712);
        font-weight: bold;
        font-size: 30px;
        margin-top: 70px;
        margin-left:390px;
    }
    .tbl{
        width:100%;
        height:90%;
        text-align: center;
        margin: auto;
        border-collapse:separate;
        border-spacing: 25px;
    }
    table>tbody>tr>td{
        border-radius: 10px;
        background-color: rgb(153, 151, 151);
    }
    table>tbody>tr>th{
        width: 140px;
    }
    
    #line_1{
        width:100%;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
    }
    
</style>
</head>
<body style="background-color: #0e332c;">
    
	<%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
    
    
    
    <div class="outer" align="center">
    <div id="line_1"></div>
    <div>
    <%@ include file="../common/companySidebar.jsp"%>
	</div>
        
        <div class="menu-name" align="left">
            <h2>게임사 정보 조회</h2>
        </div>

        <div class="info">
            <table class="tbl">
                <tr>
                    <th>게임사</th>
                    <td colspan="4"><%=loginCompany.getCompanyName()%></td>
                </tr>
                <tr>
                    <th>아이디</th>
                    <td colspan="4"><%=loginCompany.getCompanyId()%></td>
                </tr>
                <tr>
                    <th>등록코드</th>
                    <td colspan="4"><%=loginCompany.getCompanyPwd()%></td>
                </tr>
                <tr>
                    <th>대표자</th>
                    <td colspan="4"><%=loginCompany.getCompanyHead()%></td>
                </tr>
                <tr>
                    <th>등록일자</th>
                    <td colspan="4"><%=loginCompany.getCompanyEnroll()%></td>
                </tr>
            </table>
            <div onclick="logout();" align="right" style="margin-right:25px; color:gray; cursor: pointer;">>> 로그아웃</div>
        </div>
    </div>
 
    <script>
        function logout(){
            if(confirm("로그아웃 하시겠습니까?")) {
                    location.href = "<%= contextPath%>/logout.me";
            } 
        }
    </script>

</body>
</html>