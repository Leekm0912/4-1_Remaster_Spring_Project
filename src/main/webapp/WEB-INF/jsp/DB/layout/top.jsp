<%@ page contentType="text/html; charset=utf-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title><spring:message code="main.top.title"/></title>


<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1>
		<a href="main" style="color: white;"><spring:message code="main.top.title"/></a>
	</h1>
	&nbsp&nbsp&nbsp&nbsp
	<c:if test='<%=session.getAttribute("userType") != null%>'>
		<c:choose>
			<c:when test="${userType eq '매수자' || userType eq '매도자'}">
				<a href="logout.do" style="color: white;"><spring:message code="main.top.logout"/></a>
			&nbsp&nbsp&nbsp&nbsp
			<a href="mypage.do" style="color: white;"><spring:message code="main.top.info"/></a>
			</c:when>
			<c:otherwise>
				<a href="login.do" style="color: white;"><spring:message code="main.top.login"/></a>
			&nbsp&nbsp&nbsp&nbsp
			<a href="join.do" style="color: white;"><spring:message code="main.top.join"/></a>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:if test="${empty userType}">
		<a href="login.do" style="color: white;"><spring:message code="main.top.login"/></a>
	&nbsp&nbsp&nbsp&nbsp
	<a href="join.do" style="color: white;"><spring:message code="main.top.join"/></a>
	</c:if>
	&nbsp&nbsp&nbsp&nbsp
	
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a class="nav-link" href="main"><spring:message code="main.top.home"/><span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="ViewTable.jsp"><spring:message code="main.top.itemView"/></a></li>
			<li class="nav-item"><a class="nav-link" href="InsertTable.jsp"><spring:message code="main.top.insertItem"/></a></li>
			<li class="nav-item"><a class="nav-link" href="Order.jsp"><spring:message code="main.top.orderItem"/></a></li>
		</ul>
	</div>


	<%-- 
<h1 style="color:white;">연암 부동산</h1>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="main.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ViewTable.jsp">매물 보기</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="InsertTable.jsp">매물 등록</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Order.jsp">매물 구매 신청</a>
          </li>
        </ul>
      </div>
--%>
</body>