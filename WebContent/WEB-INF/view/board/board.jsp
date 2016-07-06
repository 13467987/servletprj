<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
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
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>날짜</th>
							<th>조회수</th>
						</tr>
					<tbody>
						<c:forEach var="vos" items="${vos}">
							<tr>
								<td>${vos.no}</td>
								<td><a href="/board.do?no=${vos.no}">${vos.title}</a></td>
								<td>${vos.userID}</td>
								<td><fmt:formatDate value="${vos.regDate}"
										pattern="yy-MM-dd" /></td>
								<td>${vos.hit}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- ---기본 페이징 작업--- -->
				<c:choose>
					<c:when test="${searchFlag != null}">
						<nav>
							<ul class="pasgination pager">
								<li><a href="board.do?page=1&searchFlag=true&search=${search}&word=${word}" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach var="num" begin="${pageData.startPage}"
									end="${pageData.endPage}">
									<li class="active"><a href="board.do?page=${num}&searchFlag=true&search=${search}&word=${word}">${num}
											<span class="sr-only">(current)</span>
									</a></li>
								</c:forEach>
								<c:if test="${pageData.endPage< pageData.totalPage}">
									<li><a href="board.do?page=${pageData.page+1}&searchFlag=true&search=${search}&word=${word}">다음</a></li>
									<li><a href="board.do?page=${pageData.totalPage}&searchFlag=true&search=${search}&word=${word}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
								</c:if>
							</ul>
						</nav>
					</c:when>

					<c:otherwise>
						<nav>
							<ul class="pasgination pager">
								<li><a href="board.do?page=1" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<c:forEach var="num" begin="${pageData.startPage}"
									end="${pageData.endPage}">
									<li class="active"><a href="board.do?page=${num}">${num}
											<span class="sr-only">(current)</span>
									</a></li>
								</c:forEach>
								<c:if test="${pageData.endPage< pageData.totalPage}">
									<li><a href="board.do?page=${pageData.page+1}">다음</a></li>
									<li><a href="board.do?page=${pageData.totalPage}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
								</c:if>
							</ul>
						</nav>
					</c:otherwise>
				</c:choose>
				
				<form class="form-inline" action="board.do" method="get">
					<input type="hidden" name="searchFlag" value="true">
					<div class="form-group">
						<label class="sr-only" for="exampleInputEmail3">검색</label> <select
							name="search" class="form-control">
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="userID">작성자</option>
						</select> <input type="text" class="form-control" placeholder="검색"
							name="word">
					</div>
					<input type="submit" class="btn btn-default" value="검색"> <a
						href="board.do?action=boardWrite" class="btn btn-default">글쓰기</a>
				</form>
			</div>
		</div>
	</div>
</body>

	<!-- 활성화 작업 -->
    <script type="text/javascript">  
    $(document).ready(function(){
    	$("#menu li:nth-child(2)").addClass("active");
    });
    </script>
</html>