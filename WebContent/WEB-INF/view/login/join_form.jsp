<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>JS Company Beta</title>
<style type="text/css">
#phone input {
	float: left;
	width: 70px;
	margin-left: 5px;
}

.col-sm-10 {
	margin-top: 10px;
}
</style>
<script type="text/javascript" src="../../../../resource/js/jquery-3.0.0.min.js"></script>
<script>
	$(document).ready(function() {
		$("#submit").click(function(event) {
			var id = $("#userID").val();
			var validFlag = validate_id(id);
			if (!validFlag) {
				alert("아이디는 영문또는 숫자로 입력하세요");
				event.preventDefault();
				return;
			}
			var pwd = $("#pw1").val();
			var pwd1 = $("#pw2").val();
			if (pwd != pwd1) { 
				alert("비밀번호를 잘못입력하였습니다.");
				event.preventDefault();
				return;
			}
			if($("#pw1").val()=="" || $("#pw2").val() == ""){
				alert("비밀번호를 입력하세요");
				event.preventDefault();
				return;
			}
			var phone1 =$("#phone1").val();
			var phone2 =$("#phone2").val();
			var phone3 =$("#phone3").val();
			var validPhone1 = validate_phone(phone1);
			var validPhone2 = validate_phone(phone2);
			var validPhone3 = validate_phone(phone3);
			
			if((!validPhone1)||(!validPhone2)||(!validPhone3)){
				alert("핸드폰 번호에는 숫자만 입력해주세요");
				event.preventDefault();
				return;
			}
			
		});
		//중복체크-----------------------------------------------
		var frm = $("form[name='join-form']");
		var uID = frm.find("input[name='userID']");
		var check = false;
		var checkBtn = frm.find("#checkID");
		var checkTxt = frm.find("#userID");
		
		
		
		
		
	});
	function validate_id(user_id) {
		var pattern = new RegExp(/^[a-z0-9]+$/);
		return pattern.test(user_id);
	}
	function validate_phone(phone){
		var pattern = new RegExp(/^[0-9]/);
		return pattern.test(phone);
	}
	
</script>
</head>
<body>
	<header>
		<div class="container">
			<jsp:include page="../header.jsp" flush="true"></jsp:include>
		</div>
	</header>
	<div class="container">
		<jsp:include page="../logo.jsp" flush="true"></jsp:include>
	</div>
	<div class="container">
		<div id="wrap">
			<jsp:include page="../menu.jsp" flush="true"></jsp:include>
			<div id="content">
				<h1>회원가입</h1>
				<form action="/join.do" method="post" name="join-form">
					<div class="col-xs-4">
					<div class="form-inline">
						<br><input type="text" name="userID" class="form-control" id="userID" placeholder="아이디">
							<input class="btn btn-default" id="checkID" type="button" value="중복확인">
					</div>
						<br> 
						<input type="password" name="password"
							class="form-control" id="pw1" placeholder="비밀번호"><br><input type="password" id="pw2" class="form-control" placeholder="비밀번호 확인"><br> 
							<label for="phone" class="control-label">핸드폰</label>
						<div id="phone">
							<input type="text" name="phone1" class="form-control" id="phone1" >
							 <input type="text" name="phone2" class="form-control" id="phone2"> 
							 <input type="text" name="phone3" class="form-control" id="phone3">
						</div>
						<div class="col-sm-offset-2 col-sm-10">
							<input id="submit" class="btn btn-default" type="submit" value="가입" > <a class="btn btn-default" href="index.do">취소</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>