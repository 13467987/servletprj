<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@include file="./include/resources.jsp" %>
 <style>
 	.gnb{
 	position: absolute;
 	right: 20px;
 	}
 </style>
<div class="gnb">
<c:if test="${userID ne null}">${userID}님 반갑습니다.
	<a class="btn btn-success" href="logout.do">로그아웃</a>	
	</c:if>
<c:if test="${userID eq null}">
	<a class="btn btn-success" href="login.do">로그인</a>
</c:if>
</div>