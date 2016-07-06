<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JS Company Beta</title>
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
				준비중 입니다.
	</div>
	</div>
	</div>
	</body>
	    <script type="text/javascript">  
    $(document).ready(function(){
    	$("#menu li:nth-child(3)").addClass("active");
    });
    </script>
</html>