<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%
	String contextPath = request.getContextPath();
	String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    div, input, span{
        box-sizing: border-box;
    }
    .outer{
        width: 1500px;
        height: 2200px;
        background-color: #0e332c;
        margin: auto;
        margin-top: 50px;
    }
    #logo>*:hover{
        text-decoration: none;
    }
    #content{
        width: 800px;
        height: 2000px;
        background-color: rgba(255, 255, 255, 0.5);
        margin: auto;
        margin-top: 50px;
        border-radius: 100px;
        position: relative;
    }
    #enroll_form{
        width: 80%;
        height: 90%;
        position: absolute;
        margin: auto;
        top: 0px;
        bottom: 0px;
        left: 0px;
        right: 0px;        
    }
    .sign_up>*{
        margin-top: 10px;
    }
    .sign_up_main{
        color: white;
        font-size: 15px;
        font-weight: bold;
        margin-top: 25px;
    }
    .sign_up_etc{
        color: lightgray;
        font-size: 13px;
    }
    .btn_st{
        border-radius: 10px;
        background-color: #0e332c;
        border: none;
        color: white;
        font-weight: bold;
        font-size: 14px;
    }
    .numInput{
        display: inline-block; 
        width: 60%; 
    }
    #categoryForm>input{
        margin-bottom:5px;
        display: none;
    }
    #categoryForm>label{
        background-color:white;
        color: #0e332c; 
        border: none; 
        font-weight: bold;
    }
    #agreeForm>label{
        color:white;
        margin-left: 5px;
    }
    #agreeForm>input{
        width: 15px;
        height: 15px;
    }
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #0e332c;">

	<% if(alertMsg != null){  %>
		<script>
			alert("<%= alertMsg %>");
		</script>
		<% session.removeAttribute("alertMsg"); %>
	<% } %>
	
    <div class="outer">
        <header>
            <div id="logo" align="center">
                <a href="<%= contextPath %>">
                    <img src="<%=contextPath%>/resources/image/tidyLogo.png" style="width:80px; height: 50px;"> <br>
                    <span style="color: white; font-size: 25px; font-weight: bold;">TIDY GAMES</span>
                </a>
            </div>
        </header>

        <content>
            <div id="content" align="center">
                <form action="<%= contextPath %>/memberEnrollForm.me" method="post" onsubmit="return enrollCheck();">
                    <div id="enroll_form">
                        <div style="color: white; font-size: 22px; font-weight: bold;">SIGN UP</div>

                        <div align="left">
                            <div style="color: white; font-size: 17px; font-weight: bold; margin-top: 40px;">
                                >> 필수 입력 사항<br>
                            </div>
                        </div>
                        <br>

                        <div align="left" class="sign_up">
                            <div class="sign_up_main">● 아이디</div>
                            <input type="text" name="userId" id="userId" style="width: 40%;" required>
                            <button type="button" class="btn_st" id="idCheckBtn" style="width: 19%; height: 30px;" onclick="idCheck();">중복확인</button>
                            <div class="sign_up_etc" style="margin-top:5px;">4~10자의 영문 대소문자, 숫자, 특수문자(_) 사용 가능합니다.</div>

                            <div class="sign_up_main">● 비밀번호</div>
                            <input type="password" name="userPwd" id="userPwd" style ="width: 60%;" required onkeyup="pwdCheck1();">
                            <div class="sign_up_etc" id="pwdMessage1" style="margin-top: 5px; color:red; display:none;">양식에 맞게 비밀번호를 입력해주세요.</div>
                            <div class="sign_up_etc" style="margin-top: 5px;">8~16자의 영문 대소문자, 숫자, 특수문자(!,@,#,$,%,^,&,*) 사용 가능합니다.</div>
                            
                            <div class="sign_up_main">● 비밀번호확인</div>
                            <input type="password" id="pwdCheck" style ="width: 60%;" required onkeyup="pwdCheck2();">
                            <div class="sign_up_etc" id="pwdMessage2" style="margin-top: 5px; color:red; display:none;">비밀번호가 일치하지 않습니다.</div>

                            <div class="sign_up_main">● 닉네임</div>
                            <input type="text" name="userNick" id="userNick" style="width: 40%" required>
                            <button type="button" class="btn_st" id="nickCheckBtn" style="width: 19%; height: 30px;" onclick="nickCheck();">중복확인</button>
                            <div class="sign_up_etc" style="margin-top:5px;">2~8자의 한글, 영문 대소문자, 숫자 사용 가능합니다.</div>

                            <div class="sign_up_main">● 이름</div>
                            <input type="text" name="userName" id="userName" style ="width: 40%;" required>
                            <div class="sign_up_etc" style="margin-top:5px;">2~6자의 한글만 사용 가능합니다.</div>

                            <div class="sign_up_main">● 생년월일</div>
                            <select name="year" id="year" required style="width: 150px; height: 30px;">
								<% Date d = new Date(); %>
								<% for(int i=0; i<100; i++) { %>
									<option>
										<%= d.getYear() + 1900 - i %>
									</option>
								<% } %>
								<option selected style="display: none;">년도</option>
                            </select>
                            <select name="month" id="month" required style="width: 150px; height: 30px;" onchange="createDay(this);">
								<% for(int i=1; i<=9; i++) { %>
									<option>
										0<%= i %>
									</option>
								<% } %>
								<% for(int i=10; i<=12; i++) { %>
									<option>
										<%= i %>
									</option>
								<% } %>
                                <option selected style="display: none;">월</option>
                            </select>
                            <select name="day" id="day" required style="width: 150px; height: 30px;">
                                <option selected style="display: none;">일</option>
                            </select>

                            <div class="sign_up_main">● 휴대폰번호</div>
                            <input type="text" name="phone" id="phone" class="numInput" required maxlength="13">
                            <div class="sign_up_etc" style="margin-top:5px;">'-'를 포함하여 입력해주세요. (000-0000-0000 형태)</div>
                            
                            <div class="sign_up_main">● 이메일 주소</div>
                            <input type="text" name="email" id="email" required style="width: 60%;"> 
                            <div class="sign_up_etc" style="margin-top:5px;">'@'를 포함하여 입력해주세요.</div>
                        </div>

                        <hr style="margin-top:50px; margin-bottom:50px;">

                        <div align="left">
                            <div style="color: white; font-size: 17px; font-weight: bold;">
                                >> 선택 입력 사항<br>
                            </div>
                        </div>
                        <br>

                        <div align="left" class="sign_up">
                            <div class="sign_up_main">● 성별</div>
                            <input type="radio" name="gender" id="M" value="M">
                            <label for="M" style="color: white; margin-right: 10px;">남자</label>
                            <input type="radio" name="gender" id="F" value="F">
                            <label for="F" style="color: white;">여자</label>
                            
                            <div class="sign_up_main">● 주소</div>
                            <input type="text" name="address" id="address" style="width: 70%;">
                            
                            <div class="sign_up_main">● 선호하는 게임 장르를 선택해주세요! (다수 선택 가능)</div>
                            <div id="categoryForm">
                                <input type="checkbox" id="action" name="category" value="action" onclick="btnStyle('action');">
                                <label id="action_btn" class="btn" for="action">액션</label>
                                <input type="checkbox" id="roll" name="category" value="roll" onclick="btnStyle('roll');">
                                <label id="roll_btn" class="btn" for="roll">롤플레잉</label>
                                <input type="checkbox" id="racing" name="category" value="racing" onclick="btnStyle('racing');">
                                <label id="racing_btn" class="btn" for="racing">레이싱</label>
                                <input type="checkbox" id="simul" name="category" value="simul" onclick="btnStyle('simul');">
                                <label id="simul_btn" class="btn" for="simul">시뮬레이션</label>
                                <input type="checkbox" id="strategy" name="category" value="strategy" onclick="btnStyle('strategy');">
                                <label id="strategy_btn" class="btn" for="strategy">전략</label>
                                <input type="checkbox" id="sport" name="category" value="sport" onclick="btnStyle('sport');">
                                <label id="sport_btn" class="btn" for="sport">스포츠</label>
                                <br>
                                <input type="checkbox" id="indie" name="category" value="indie" onclick="btnStyle('indie');">
                                <label id="indie_btn" class="btn" for="indie">인디</label>
                                <input type="checkbox" id="casual" name="category" value="casual" onclick="btnStyle('casual');">
                                <label id="casual_btn" class="btn" for="casual">캐주얼</label>
                                <input type="checkbox" id="horror" name="category" value="horror" onclick="btnStyle('horror');">
                                <label id="horror_btn" class="btn" for="horror">공포</label>
                                <input type="checkbox" id="multi" name="category" value="multi" onclick="btnStyle('multi');">
                                <label id="multi_btn" class="btn" for="multi">멀티플레이</label>
                                <input type="checkbox" id="card" name="category" value="card" onclick="btnStyle('card');">
                                <label id="card_btn" class="btn" for="card">카드</label>
                                <input type="checkbox" id="adventure" name="category" value="adventure" onclick="btnStyle('adventure');">
                                <label id="adventure_btn" class="btn" for="adventure">어드벤처</label>
                                <input type="checkbox" id="puzzle" name="category" value="puzzle" onclick="btnStyle('puzzle');">
                                <label id="puzzle_btn" class="btn" for="puzzle">퍼즐</label>
                                <input type="checkbox" id="cooperation " name="category" value="cooperation " onclick="btnStyle('cooperation ');">
                                <br>
                                <label id="cooperation _btn" class="btn" for="cooperation ">협동</label>
                                <input type="checkbox" id="split" name="category" value="split" onclick="btnStyle('split');">
                                <label id="split_btn" class="btn" for="split">분할화면</label>
                                <input type="checkbox" id="science" name="category" value="science" onclick="btnStyle('science');">
                                <label id="science_btn" class="btn" for="science">공상과학</label>
                                <input type="checkbox" id="first" name="category" value="first" onclick="btnStyle('first');">
                                <label id="first_btn" class="btn" for="first">1인칭</label>
                                <input type="checkbox" id="escape" name="category" value="escape" onclick="btnStyle('escape');">
                                <label id="escape_btn" class="btn" for="escape">방탈출</label>


                            </div>
                            <br><br>

                            <div id="agreeForm">
                                <input type="checkbox" id="allAgree" onclick="checkAll(this);">
                                <label for="allAgree">모두 동의합니다.</label> <br>

                                <input type="checkbox" id="agree1" class="agrees">
                                <label for="agree1">(필수) 이용약관과 개인정보 수집 및 이용에 동의합니다.</label> <br>

                                <input type="checkbox" id="agree2" class="agrees"> 
                                <label for="agree2" style="margin-bottom: 0px;">(필수) 만 14세 이상입니다.</label> <br>
                                <label for="agree2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;만 19세 미만의 미성년자가 결제 시 법정대리인이 거래를 취소할 수 있습니다.</label> <br>

                                <input type="checkbox" id="agree3" class="agrees" name="agree" value="Y"> 
                                <label for="agree3" style="margin-bottom: 0px;">(선택) 이메일 및 SMS 마케팅 정보 수신에 동의합니다.</label> <br>
                                <label for="agree3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원은 언제든지 회원 정보에서 수신 거부로 변경할 수 있습니다.</label> <br>
                            </div>

                        </div>
                        <br><br><br>

                        <button type="submit" class="btn_st" style="width: 70px; height: 35px;">다음</button>
                    </div>
                </form>
                <script>
                    
                    // onsubmit 체크용 int값
                    var idCheckNum = 0;
                    var nickCheckNum = 0;

                    function idCheck(){
                        // 중복확인버튼 클릭시 사용자가 입력한 아이디값 넘겨서 조회 -> 응답데이터 돌려받기
                        // 1) 사용불가능할경우(NNNNN) : alert로 메세지 출력 후 다시입력받게 유도
                        // 2) 사용가능한경우(NNNNY) : 진짜 사용할지 물어본 뒤 (confirm메소드 이용)
                        //					사용하겠다고하면 아이디 수정못하게 픽스 후 회원가입 버튼 활성화
                        //					안한다고하면 다시 입력하게 유도

                        var $idCheck = $("#userId");
                        var $idCheckBtn = $("#idCheckBtn");
                        var regExp = /^[a-z\d_]{4,10}$/i;

                        if(regExp.test($idCheck.val()) == true) {
                            // 아이디 양식이 맞음
                            $.ajax({
                                url:"idCheck.me",
                                data:{checkId:$idCheck.val()}, //키 checkId | 값 $idCheck.val()
                                success:function(result){
                                    if(result == 'NNNNN') {
                                        alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
                                        $idCheck.focus();
                                    } else {
                                        if(confirm("사용가능한 아이디입니다. 해당 아이디를 사용하시겠습니까?\n확인을 누르면 더이상 아이디를 변경할 수 없습니다.")) {
                                            $idCheck.attr("readonly", true);
                                            idCheckNum = 1;
                                            $idCheckBtn.attr("disabled", true);
                                        } else {
                                            $idCheck.focus();
                                        }
                                    }
                                },
                                error:function(){
                                    console.log("아이디 중복체크용 ajax 실패");
                                }
                            })

                        } else {
                            // 아이디 양식이 틀림
                            alert("양식에 맞는 아이디로 다시 입력해주세요.");
                            $idCheck.focus();
                        }

                    }

                    function pwdCheck1(){

                        var userPwd = document.getElementById("userPwd").value;
                        var pwdMessage1 = document.getElementById("pwdMessage1");
                        var regExp = /^[a-z\d!@#$%^&*]{8,16}$/i;

                        if(regExp.test(userPwd) == true) {
                            // 비밀번호 양식에 맞게 입력
                            pwdMessage1.style.display = "none";
                        } else {
                            // 비밀번호 양식에 틀리게 입력
                            pwdMessage1.style.display = "inline-block";
                        }

                    }

                    function pwdCheck2(){

                        var userPwd = document.getElementById("userPwd").value;
                        var pwdCheck = document.getElementById("pwdCheck").value;
                        var pwdMessage2 = document.getElementById("pwdMessage2");

                        if(userPwd == pwdCheck) {
                            // 비밀번호가 일치할때
                            pwdMessage2.style.display = "none";
                        } else {
                            // 비밀번호가 일치하지 않을때
                            pwdMessage2.style.display = "inline-block";
                        }

                    }

                    function nickCheck(){

                        var $nickCheck = $("#userNick");
                        var $nickCheckBtn = $("#nickCheckBtn");
                        var regExp = /^[가-힣a-z\d]{2,8}$/i;

                        if(regExp.test($nickCheck.val()) == true) {
                            // 닉네임 양식이 맞음
                            $.ajax({
                                url:"nickCheck.me",
                                data:{checkNick:$nickCheck.val()}, //키 checkNick | 값 $nickCheck.val()
                                success:function(result){
                                    if(result == 'NNNNN') {
                                        alert("이미 존재하거나 탈퇴한 회원의 닉네임입니다.");
                                        $nickCheck.focus();
                                    } else {
                                        if(confirm("사용가능한 닉네임입니다. 해당 닉네임을 사용하시겠습니까? \n확인을 누르면 더이상 닉네임을 변경할 수 없습니다.\n(가입 후 마이페이지에서 변경 가능)")) {
                                            $nickCheck.attr("readonly", true);
                                            nickCheckNum = 1;
                                            $nickCheckBtn.attr("disabled", true);
                                        } else {
                                            $nickCheck.focus();
                                        }
                                    }
                                },
                                error:function(){
                                    console.log("닉네임 중복체크용 ajax 실패");
                                }
                            })

                        } else {
                            // 닉네임 양식이 틀림
                            alert("양식에 맞는 닉네임으로 다시 입력해주세요.");
                            $nickCheck.focus();
                        }

                    }

                    function createDay(el){
                        var day = document.getElementById("day");
                        var month = el.value;

                        if( month == 1 || month == 3 || month == 5 || 
                            month == 7 || month == 8 || month == 10 || 
                            month == 12 ) {
                            for(var i=1; i<=9; i++) {
                                day.innerHTML += "<option>0" + i + "</option>"
                            }
                            for(var i=10; i<=31; i++) {
                                day.innerHTML += "<option>" + i + "</option>"
                            }
                        } else if(month == 2) {
                            for(var i=1; i<=9; i++) {
                                day.innerHTML += "<option>0" + i + "</option>"
                            }
                            for(var i=10; i<=29; i++) {
                                day.innerHTML += "<option>" + i + "</option>"
                            }
                        } else{
                            for(var i=1; i<=9; i++) {
                                day.innerHTML += "<option>0" + i + "</option>"
                            }
                            for(var i=10; i<=30; i++) {
                                day.innerHTML += "<option>" + i + "</option>"
                            }
                        }
                    }

                    function btnStyle(elId){
                        if(document.getElementById(elId).checked == true) {
                            document.getElementById(elId+"_btn").style.background = "#0e332c";
                            document.getElementById(elId+"_btn").style.color = "white";
                        } else if(document.getElementById(elId).checked == false) {
                            document.getElementById(elId+"_btn").style.background = "white";
                            document.getElementById(elId+"_btn").style.color = "#0e332c";
                        }
                    }

                    function checkAll(checkAll){
 
                        const checkboxes 
                            = document.getElementsByClassName('agrees');
                        
                        for(var i=0; i<checkboxes.length; i++) {
                            checkboxes[i].checked = checkAll.checked;
                        }
                    }

                    function enrollCheck(){

                        // 비밀번호용 객체
                        var userPwd = document.getElementById("userPwd").value;
                        var pwdCheck = document.getElementById("pwdCheck").value;
                        var regExpPwd = /^[a-z\d!@#$%^&*]{8,16}$/i;
                        // 이름용 객체
                        var userName = document.getElementById("userName").value;
                        var regExpName = /^[가-힣]{2,6}$/;
                        // 생년월일용 객체
                        var year = document.getElementById("year").value;
                        var month = document.getElementById("month").value;
                        var day = document.getElementById("day").value;
                        // 휴대폰번호용 객체
                        var phone = document.getElementById("phone").value;
                        var regExpPhone = /^[\d]{3}[-]{1}[\d]{4}[-]{1}[\d]{4}$/;
                        // 이메일용 객체
                        var email = document.getElementById("email").value;
                        var regExpEmail = /^[a-z0-9_-]+@[a-z0-9_-]+\.[a-z0-9_-]+$/i;
                        // 필수동의용 객체
                        var agree1 = document.getElementById("agree1");
                        var agree2 = document.getElementById("agree2");

                        if(idCheckNum == 0) {
                            alert("아이디 중복확인 완료 후 가입할 수 있습니다.");
                            return false;
                        }

                        if(regExpPwd.test(userPwd) == true) {
                            // 비밀번호 양식에 맞게 입력

                            if(userPwd == pwdCheck) {
                                // 비밀번호가 일치할때
                            } else {
                                alert("비밀번호가 일치하지 않습니다.");
                                return false;
                            }

                        } else {
                            alert("비밀번호를 양식에 맞게 입력해주세요.");
                            return false;
                        }

                        if(nickCheckNum == 0) {
                            alert("닉네임 중복확인 완료 후 가입할 수 있습니다.");
                            return false;
                        }

                        if(regExpName.test(userName) == true){
                            // 이름 양식에 맞게 입력
                        } else {
                            alert("이름을 양식에 맞게 입력해주세요.\n7자 이상의 이름이나 외국인 회원은 고객센터로 문의바랍니다.");
                            return false;
                        }

                        if(year == '년도') {
                            alert("생년월일을 모두 입력해주세요.");
                            return false;
                        } else if(month == '월') {
                            alert("생년월일을 모두 입력해주세요.");
                            return false;
                        } else if(day == '일') {
                            alert("생년월일을 모두 입력해주세요.");
                            return false;
                        }

                        if(regExpPhone.test(phone) == true) {
                            // 휴대폰번호 양식에 맞게 입력
                        } else {
                            alert("휴대폰번호를 양식에 맞게 입력해주세요.");
                            return false;
                        }

                        if(regExpEmail.test(email) == true) {
                            // 이메일 양식에 맞게 입력
                        } else {
                            alert("이메일주소를 양식에 맞게 입력해주세요.");
                            return false;
                        }

                        if(agree1.checked == false) {
                            // 필수동의1 체크되어있지 않다면
                            alert("필수약관에 모두 동의해주셔야 가입이 가능합니다.");
                            return false;
                        } else if(agree2.checked == false) {
                            // 필수동의2 체크되어있지 않다면
                            alert("필수약관에 모두 동의해주셔야 가입이 가능합니다.");
                            return false;
                        }


                        return true;
                    }

                </script>
            </div>
        </content>
    </div>
</body>
</html>