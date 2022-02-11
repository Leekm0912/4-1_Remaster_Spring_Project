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
			<jsp:include page="./layout/top.jsp" flush="false" />
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div style="margin: auto; width: 50%; text-align: center;">
			<h1>매물 등록</h1>

			<a href="<c:url value='/insertItem/charter' />" target="main_frame" class="btn btn-primary">전세</a> 
			<a href="<c:url value='/insertItem/monthlyRent' />" target="main_frame" class="btn btn-primary">월세</a> 
			<a href="<c:url value='/insertItem/land' />" target="main_frame" class="btn btn-primary">토지</a> 
			<a href="<c:url value='/insertItem/trading' />" target="main_frame" class="btn btn-primary">매매</a>
		</div>
	</div>
	<iframe src="<c:url value='/insertItem/charter' />" style="display: block; margin: auto; width: 95vw; height: 80vh" id="main_frame" name="main_frame"> </iframe>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.slim.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script>
		function goToResult(){
			location.href="add_data_result.jsp?page=info";
		}
	</script>
</body>

</html>
