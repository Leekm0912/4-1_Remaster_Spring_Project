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
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div style="text-align:center;">
	<h1>${ title }</h1>
	<form action="start" method="post">
		<input type="hidden" name="selectItem" value="${title}"/>
		<c:forEach var="d" items='${ data }'>
			<h5>${ d.value }</h5>
			<input type="text" name="${ d.key }" size="50" class="form-control" id="exampleTextarea" style="width: 60%; margin:auto"> <br>
		</c:forEach>
		<div style="margin: auto; text-align: center;">
			<input type="submit" value="입력완료" class="btn btn-primary">
		</div>
	</form>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="../vendor/jquery/jquery.slim.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="vendor/jquery/jquery.slim.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>