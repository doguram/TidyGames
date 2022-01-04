<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

      /* 전체div */
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
 /* 닉네임의주문내역 */
 .area1{
       border: 1px solid red;
       font-size: 30px;
        font-weight: 900;
        color :white;
        margin: 30px 80px 0px 50px;
    }
    /* 검색영역 */
    .area2{
        border: 1px solid blue;
        width: 1200px;
        height:80px;
        margin-left: 70px;
        
        
        
    }

     /* 검색바 */
     .searchname div{
        display:inline;
        
    }
    /* select */
    .searchbar{
        margin-top : 60px;
        margin-left: 100px;
    }

    .dateSearch .searchname{
        display: inline;
    }
  /* 주문내역 게임 1개 영역 */
  .area3{
        width: 1200px;
        height: 350px;
        border: 1px solid violet;
        margin-left: 70px;
    }

    .area4{
        background: none;
        text-align: center;
        border: 1px solid blue;
        width: 1000px;
        height: 400px;
        margin-top: 50px;
        margin-left: 100px;
        color:white;
       
    }
    .area4>h4 {
        font-size: 18px;
    }
</style>
</head>
<body>
    <%@ include file="../common/topbar.jsp"%>
    <%@ include file="../common/navibar.jsp"%>
    <div id="outer">
        <div id="line_1"></div>
        <div>
            <%@ include file="../common/memberSidebar.jsp" %>


        </div>

        <!-- 닉네임 불러와지게 -->
        <div class="area1"><span>닉네임</span>님의 주문내역</div>
        <br><br><br><br><br>
        



            <div class="area2">
                <div class="dateSearch">
                   
                    <select class="btn btn-outline-secondary" style="color: white;">
                        <option selected >조회기간</option>
                        <option value="weekend" >일주일</option>
                        <option value="month">한달</option>
                        <option vlaue="threemonth">3개월</option>
                        <option value="sixmonth">6개월</option>
                        <option value="year">1년</option>
            
                    </select>
                    &nbsp; &nbsp;
                    <select class="btn btn-outline-secondary" style="color: white;">
                        <option selected value="uptodate">최신순</option>
                        <option value="olddae" >오래된순</option>

                    </select>
                    
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    <div class="searchname">
                        <div id="game_search">
                            <input type="text" name="keyword" style="border-radius: 3px; width: 800px; height:40px; border: 1px solid white;" placeholder="게임명을 입력해주세요">
                        </div>
                        
                        <div id="search_btn">
                            <button type="submit" id="icon_btn"><i class="fas fa-search"></i></button>
                        </div>
                
                    </div>
                </div>


             </div>
             <div id="line1" style="width: 1150px; height: 2px; background: rgba(255, 255, 255, 0.555); margin-left: 50px;"></div>
        <br><br><br><br>

             <div class="area4">
                 <br><br>
                <img src="<%=contextPath%>/resources/image/warning.png" width="100px" height="100px"><br>
                <br>
                <h2>검색결과가 없습니다.</h2>
                <h4 style="color:gray">설정한 조건에 해당하는 검색결과가 없습니다.</h4>
                <h4 style="color:gray">상세조건을 다시 설정해주세요.</h4>

             </div>


    </div>
        

</body>
</html>