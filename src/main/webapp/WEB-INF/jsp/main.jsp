<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title><spring:message code="main.top.title"/></title>

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
		<c:choose>
			<c:when test="${userType eq '매수자'||userType eq '매도자'}">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h1 class="mt-5">
							<spring:message code="main.hello" 
							arguments="${userInfo.name},${userType}"/>
						</h1>
						<p><spring:message code="main.text"/></p>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="col-lg-12 text-center">
						<h1 class="mt-5"><spring:message code="main.title"/></h1>
						<p class="lead"><spring:message code="main.sub"/></p>
						<p><spring:message code="main.text"/></p>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.slim.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
