<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>연암 부동산</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container">
			<jsp:include page="./DB/layout/top.jsp" flush="false" />
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<c:if test='<%=session.getAttribute("userType") != null%>'>
			<c:choose>
				<c:when test="${userType eq '매수자'}">
					<div class="row">
						<div class="col-lg-12 text-center">
							<h1 class="mt-5">
								${userInfo.name} 매수자님 환영합니다!
							</h1>
							<p>2학년때 만들었던 JSP 프로젝트를 Spring을 이용해 재구성한 프로젝트 연암부동산 입니다!</p>
						</div>
					</div>
				</c:when>
				<c:when test="${userType eq '매도자'}">

					<div class="row">
						<div class="col-lg-12 text-center">
							<h1 class="mt-5">
								${userInfo.name} 매도자님 환영합니다!
							</h1>

							<p>2학년때 만들었던 JSP 프로젝트를 Spring을 이용해 재구성한 프로젝트 연암부동산 입니다!</p>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="col-lg-12 text-center">
							<h1 class="mt-5">연암공과대학교 전공심화 4A 이경민</h1>
							<p class="lead">학번 : 21660072</p>
							<p>2학년때 만들었던 JSP 프로젝트를 Spring을 이용해 재구성한 프로젝트 연암부동산 입니다!</p>
							에러
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</c:if>
	</div>
	<c:if test="${empty userType}">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h1 class="mt-5">연암공과대학교 스마트SW 학과 2B 이경민</h1>
				<p class="lead">학번 : 21660072</p>
				<p>2학년때 만들었던 JSP 프로젝트를 Spring을 이용해 재구성한 프로젝트 연암부동산 입니다!</p>
			</div>
		</div>
	</c:if>
	
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.slim.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
