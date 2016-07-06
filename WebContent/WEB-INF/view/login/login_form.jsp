<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#inputID,#inputPw{
		width: 350px;
	};
</style>
<title>JS Company Beta</title>
<!-- <link href="resource/css/default.css" rel="stylesheet" type="text/css" /> -->
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
<!-- 	----------추가------->
<form class="form-horizontal" action="/loginConfirm.do" method="post">
	<c:if test="${error ==0}"><label>
	아이디 또는 비밀번호가 일치 하지 않습니다.</label>
		<br>
	</c:if>
  <div class="form-group">
    <label for="inputID" class="col-sm-2 control-label">아이디</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputID" placeholder="ID" name="userID">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPw" class="col-sm-2 control-label">패스워드</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPw" placeholder="Password"
      name="password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
      <a href="/joinForm.do" class="btn btn-default">Join us</a>
    </div>
  </div>
</form>
	</div>
	</div>
	</div>
	</body>
</html>