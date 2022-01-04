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

h3 {
    font-size: 16px;
}

.container{
    width: 1200px;
    padding-top: 50px;
    text-align: center;
}

/* 장바구니에 아무것도 없을떄 */
.nocart{
    width: 1000px;
    margin: auto;
    margin-left: 150px;
    
}
@import url(http://fonts.googleapis.com/css?family=Calibri:400,300,700);





.btn-primary,
.btn-primary.disabled,
.btn-primary:disabled {
    background-color: #4466f2 !important;
    border-color: #4466f2 !important
}

#cartbar{
    color:orange;
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
         

        <!-- 장바구니에 아무것도없을때 -->

        <br><br><br>
        <div class="nocart">
            <div class="container-fluid mt-100">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card" style="background: rgba(0, 0, 0, 0.445); height: 500px;" >
                            
                            <div class="card-body cart" style=" margin-top: 90px;">
                                <div class="col-sm-12 empty-cart-cls text-center"> <img src="https://i.imgur.com/dCdflKN.png" width="130" height="130" class="img-fluid mb-4 mr-3">
                                    <h3 style="color:white"><strongy> 장바구니가 비어있습니다.</strongy></h3>
                                     <a href="#" class="btn btn-primary cart-btn-transform m-3" data-abc="true">쇼핑계속하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

























</body>
</html>