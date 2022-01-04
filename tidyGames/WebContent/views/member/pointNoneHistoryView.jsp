<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        border: 3px solid blue;
        font-weight: bold;
        color: white;
        margin-top: 50px;
        margin-left: 100px;
    }
    /* 포인트조회영역 */
    .area2{
        width: 1000px;
        height: 200px;
        border: 3px solid red;
        font-weight: bold;
        color: white;
        margin-top: 40px;
        margin-left: 100px;
        background: rgb(227, 220, 210);;
    }
    /* 7일 ,한달, 3개월 6개월 조회버튼 */
    .dateSearch{
        margin: 8px 30px 0px 70px;
        display: inline-block;
   
    }
    .dateSearch>button{
        border-radius: 5px;
        font-weight: bold;
        background: none;
    }
    /* 달력 div */
    .datetable{
        display: inline-block;
    }
    .datetable>input{
        border-radius: 5px;
        font-weight: bold;
    }
    /* 전체상태 div */
    .pointstatus{
        display: inline-block;
        margin-left: 30px;
        margin-right: 10px;
    }

    .pointstatus>select{
        border-radius: 5px;
        background: white;
        width: 150px;
        height: 30px;
        text-align: center;
        font-weight: bold;
        
    }
    select>option{
        font-weight: bold;
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
        <div class="area1">
            <h3>닉네임님의</h3><h2>TIDY POINT 내역</h2>
            <div style="background: grey; width: 1000px; height: 2px;"></div>
        </div>
        <br><br><br>

        <div class="area2">
            <div style="color:black; font-size:18px; font-weight: bold; margin: 10px 0px 0px 70px;">보유 TIDY POINT</div>
            <span style="margin-left: 60px;"><img src="<%=contextPath%>/resources/image/point.png" width="70px" height="70px"></span>
            <!-- 보유포인트 조회 -->
            <span style="font-size: 30px; color:black;">9525 POINT</span>

            <form action="">
                
                <div class="dateSearch">

                   <button name="weekend">일주일</button>
                   <button name="month">1개월</button>
                   <button name="threemonth">3개월</button>
                   <button name="sixmonth">6개월</button>
                
                </div>

                <div class="datetable">
                    <input type="date" name="startdate" class="date">
                    <span style="color:black">&nbsp;&nbsp; ~ &nbsp;&nbsp;</span>
                    <input type="date" name="startdate" class="date">
                </div>
            
                <div class="pointstatus">

                    <select>
                        <option selected>전체상태</option>
                        <option name="save">적립</option>
                        <option name="use">사용</option>

                    </select>
                </div>
                <button type="submit" class="btn btn-sm btn-secondary" style="width: 50px; height: 35px;">조회</button>

            </form>

            <div style="color:grey; margin:10px 0px 0px 70px">적립된 당일로부터 POINT는 5년동안 유지됩니다.</div>
        </div>

        <br><br>
        <div style="width: 1000px; height: 2px; background: gray; margin:30px 0px 30px 100px;"></div>
        <br><br>

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