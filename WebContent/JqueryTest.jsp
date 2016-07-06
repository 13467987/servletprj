<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	.active{
		text-decoration: none;
		color: red;
	};
</style>
<script src="./resource/js/jquery-3.0.0.min.js"></script>
<script>  
$(document).ready(function(){
	$("#menu li").click(function(){
		$("p").addClass("active");
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="menu">
	<ul >
		<li id="an"><a href="JqueryTest.jsp">1</a>
		<li><a href="">1</a>
		<li><a href="">1</a>
		<li><a href="">1</a>
	</ul>
	<p>dddd</p>
</div>
</body>
</html>