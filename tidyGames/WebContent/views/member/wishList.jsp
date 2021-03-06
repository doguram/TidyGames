<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.ArrayList,com.TidyGames.common.model.vo.*, com.TidyGames.game.model.vo.*, com.TidyGames.member.model.vo.*"%>
    
    
<%

PageInfo pi = (PageInfo)request.getAttribute("pi");

int currentPage = pi.getCurrentPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
int maxPage = pi.getMaxPage();


ArrayList<WishList> wish = (ArrayList<WishList>)request.getAttribute("wish");
Game g = (Game)session.getAttribute("g");
%>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    div{
        box-sizing: border-box;
    }
    #outer{
        width:1500px;
        height: 1300px;
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
    #intro{
        font-size: 30px;
        font-weight: 900;
        color :white;
        margin: 30px 80px 0px 50px;
    }
    .search-game {
        width: 1000px;
        height: 70px;
      
        margin-left: 140px;
    }
    .search-game div{
        display:inline;
    }
    .search-game form{
        display: inline;
    }
    #wishList-array{
        border-radius: 3px;
        border: 1px solid white;
        background: #0e332c;
        color: white;
        height: 30px;

    }

    
    #line1{
        width:1200px;
        height:2px;
        background: rgba(255, 255, 255, 0.555);
        margin-left: 50px;
    }


    
    #allDelete_btn{
        margin-left: 150px;
        border-radius: 3px;
        background: gray;
        font-weight:bolder;
    }

    #name{
        width: 80%;
        font-size: large;
        text-align: center;
        color: white;
    }
    #x_btn{
        width: 20%;
       
    }
    #delete_btn{
        float: right;
        border-radius: 4px;
        border: none;
        background: grey;
        height: 25px;
        width: 25px;
    }


    #price{
        color: white;
        font-size: medium;
        font-weight: bold;
        margin: 10px 10px 0px 0px;
      
    }

    .cart{
        
        margin-top: 100px;
        width: 80px;
    }
    .paging-area{
    
       width: 1000px;
       height: 200px;
       margin-top: 50px;
    }
    .paging-area>button {
        border-radius: 5px;
        background: none;
        border: none;
        color: white;
        font-size: 20px;
       
        
    }
    .paging-area>button:hover {
        cursor:pointer;
        color:orange
    }

    #wishListbar{
        color:orange;
    }
	    table.shoping-cart-table tr td.desc,
	table.shoping-cart-table tr td:first-child {
	  text-align: left;
	}
	    table.shoping-cart-table {
	  margin-bottom: 0;
	}
	table.shoping-cart-table tr td {
	  border: none;
	  text-align: right;
	}
	table.shoping-cart-table tr td.desc,
	table.shoping-cart-table tr td:first-child {
	  text-align: left;
	}
	table.shoping-cart-table tr td:last-child {
	  width: 80px;
	}
	.ibox.collapsed .ibox-content {
	  display: none;
	}
	.ibox-content {
	  background-color: #ffffff;
	  color: inherit;
	  padding: 15px 20px 20px 20px;
	  border-color: #e7eaec;
	  border-image: none;
	  border-style: solid solid none;
	  border-width: 1px 0;
	}
    .area1{
        width: 1000px;
        height: 400px;
       
        background: rgba(0, 0, 0, 0.445);
        
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
        <!-- ????????? ??????????????? -->
        <div id="intro"><h1><%=loginUser.getMemNick() %>?????? ??? ??????</h1></div>
        <br><br><br><br><br>

      

        <div class="search-game">
            
            <form action="<%=contextPath%>/wishSearch.me" id="wishList-search">
			<input type="hidden" value="1" name="cpage">
			
                <div id="game_search">
                    <input type="text" name="keyword" style="border-radius: 3px; width: 900px; height:30px; background:#ffffff; border: 1px solid white;" placeholder="???????????? ??????????????????">
                </div>
                
                <div id="search_btn">
                    <button type="submit" id="icon_btn"><i class="fas fa-search"></i></button>
                </div>
            </form>

           
            
                <!-- 
                <select name ="wishList-array" id="wishList-array">
                    <option selected >????????????</option>
                    <option value="releaseDate" >????????????</option>
                    <option value="gameName">??????</option>
                    <option vlaue="eventGame">?????????</option>
                    <option value="priceAsc">?????????:????????????</option>
                    <option value="priceDesc">?????????:????????????</option>
        
                </select>
				 -->
            

        </div>
        <br>
       
        <div id="line1"></div>
        <br>
        <br><br>

     	  <% if(wish.isEmpty()) { %>

        
            <div class="area1" style="float: right; margin-right: 150px;">
                <div class="col-sm-12 empty-cart-cls text-center"> <img src="https://i.imgur.com/dCdflKN.png" width="200" height="130" class="img-fluid mb-4 mr-3" style="margin-top: 50px;">
                <h3 style="color:white"><strongy> ???????????? ??????????????????.</strongy></h3>
                <a href="<%=contextPath%>" class="btn btn-primary cart-btn-transform m-3" data-abc="true">??????????????????</a>
            </div>
          
            <%}else { %>   
       
        <button id="allDelete_btn" onclick="fnClear();">????????????</button>
        	 <script>
	        	 function fnClear() {
			    		var check = confirm("???????????? ??????????????????????");
			    		if(check) {
			    		location.href = "<%=contextPath %>/cartClear.pa";
			    		}
			    	}
        	</script>
        
       
       
           
        <br><br>
		   <%for(WishList w : wish){ %>
        <div class="ibox-content" style="background: rgba(0, 0, 0, 0.445);  width: 1000px; height: 240px; margin-right: 150px; float: right;">
             <div class="table-responsive" >  
                        <table class="table shoping-cart-table" >
                            <tbody>
                                    <tr>
                                        <td width="150">
                                            <div >
                       							<img src="<%=request.getContextPath()%>/<%=w.getFilePath() + w.getChangeName()%>" width="200px" height="150px">
                                            </div>
                                        </td>

                                    
                                        <td class="desc" width="330">
                                            <h3>
                                            <a href="#" class="text-navy" style="font-size:18px">
                                                   <%=w.getKorName() %> <br>
                   									<%=w.getEngName() %>
                  			                 </a>
                                                       
                                            </h3>
                                            <p class="small" style="color:white;">
                                            <%=w.getGameIntro() %>
                                            </p>
                        

                                            <div class="m-t-sm"></div>
                                                      <a href="" onclick="return wishDelete(<%=w.getGameNo()%>);" class="text-muted"><i class="fa fa-trash"></i> Remove item</a>
                                            </div>
                                        </td>

                                        <!-- ?????????????????? ????????? ?????? -->
                                        <td style="color:white" width="100"> 
                                            <span> <%=w.getPrice()-w.getPoint()*w.getPrice()%>???</span><br>
                                            <s class="small text-muted"> <span><%=w.getPrice()%>???</span></s>
                                        </td>
                                        
                                        <td width="50">
                                            <input type="text" class="form-control" placeholder="1" style="background: none;">
                                        </td>
                                        
                                        <td width="200">
                                            <h4 style="color:white; font-size:19px" >
                                            
                                                <span> <span> <%=w.getPrice()%>???</span></span>
                                                
                                                
                                                  <div class="cart" align="center">

								                      <a href="" onclick="return cartConfirm(<%=w.getGameNo()%>);"><i class="fas fa-cart-plus fa-2x"></i></a>
								                  </div>
                                                
                                                
                                               
                                            </h4>
                                        </td>
                                        
                                    </tr>
                            </tbody>
                        </table>
            
            
                    </div>
                </div>
        
            <% } %>
		<% } %>

        <% if(!wish.isEmpty()) { %>
            <div class="paging-area" style="float: right; margin-top: 100px; margin-right: 150px; text-align: center;">
					
  <%if(currentPage != 1){ %>
            <button onclick="location.href='<%=contextPath%>/wishList.me?cpage=<%=currentPage-1%>';"> &lt; </button>
          <%} %>  
            
            <%for(int p=startPage; p<=endPage; p++){ %>
            
            	<!-- ????????????????????? ??????????????? -->
            	<%if(p== currentPage) { %>
            		<button disabled><%= p %></button>
            	<%}else { %>
            	<!-- ??????????????? ???????????? url ??????-->
            		<button onclick="location.href='<%=contextPath%>/wishList.me?cpage=<%=p%>';"><%= p %></button>
            	<%} %>
            <% } %>
            <% if(currentPage != maxPage) { %>
            <button onclick="location.href='<%=contextPath%>/wishList.me?cpage=<%=currentPage+1%>';"> &gt; </button>
      		 <%} %>


		
			</div>
            
            
            
            
            
            <br><br><br>
          <% } %>
    </div>
    
    
        <script>
    
    function loginMsg(){
    	if(!confirm("???????????? ???????????????. ????????????????????????????")){
    		return false; 
    	}
    }
    
  function cartConfirm(gameNo){
    	
    	$.ajax({
    		url : "cartInsert.pa",
    		data : {
    			
    			gameNo:gameNo
    		},
    		type:"post",
    		success:function(result) {
    			
    			
    			if(result == 1) {
 
    				if(confirm("??????????????? ???????????????. ??????????????? ?????????????????????????")){
    		    		location.href='<%=contextPath%>/cart.pa?memNo=<%=loginUser.getMemNo()%>';
    		    	}
    				
    			}else if(result == 2 ) {
    				alert("??????????????? ?????? ???????????????.")
    			}
    			
    		},error:function() {
    			console.log("???????????? ?????? ??????!")
    		}
    	})
    	return false;
    	
   	
    }
  
  
  function wishDelete(gameNo){
  	
  	$.ajax({
  		url : "wishDe.me",
  		data : {
  			
  			gameNo:gameNo
  		},
  		type:"post",
  		success:function(result) {
  			
  			if(result > 0) {
  			alert("??????????????? ?????????????????????.")
  			}
  		},error:function() {
  			console.log("?????? ??????!")
  		}
  	})
  		
  	
 	
  }
	    
    </script>
   



</body>
</html>