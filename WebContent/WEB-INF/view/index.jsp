<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>JS Company Beta</title>
</head>
<body>
	<header>
	<div class="container">
		<jsp:include page="./header.jsp" flush="true"></jsp:include>
	</div>
	</header>
	<div class="container">
	<%@include file="./logo.jsp"%>
</div>
	<div class="container">
		<%@include file="./menu.jsp"%>
		<div id="content">
			<img alt="" src="../resource/img/main.JPG">
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>