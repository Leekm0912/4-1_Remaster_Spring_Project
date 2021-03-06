<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>ItemView</title>

<!-- Bootstrap core CSS -->
<link href='<c:url value="/vendor/bootstrap/css/bootstrap.min.css"/>'
	rel="stylesheet">
<link href='<c:url value="/vendor/mycss.css" />' rel="stylesheet">
<style type="text/css">
</style>
</head>
<body>
	<form>
		<table class="type1">
			<tr>
				<%-- 얘네 다 리소스 분리 해야함 --%>
				<c:forEach var="menu" items='${ menuList }'>
					<th scope="cols">${ menu }</th>
				</c:forEach>
				<c:choose>
					<c:when test="${ type eq 'sell' }">
						<th scope='cols'>구매 버튼</th>
						<th scope='cols'>지도 보기</th>
					</c:when>
					<c:when test="${ type eq 'update' }">
						<th scope='cols'>삭제 버튼</th>
					</c:when>
					<c:otherwise>
						<th scope='cols'>지도 보기</th>
					</c:otherwise>
				</c:choose>
			</tr>

			<c:forEach var="item" items='${ data }'>
				<tr>
					<td style='text-align: center;'>${ item.itemNumber }</td>
					<td style='text-align: center;'>${ item.itemAddDate }</td>
					<td style='text-align: center;'>${item.sellerName}</td>
					<td style='text-align: center;'>${ item.address }</td>
					<c:if test="${ item.contractMonth ne -1 }">
						<td>${ item.contractMonth }</td>
					</c:if>
					<c:if test="${ item.deposit ne -1 }">
						<td>${ item.deposit }</td>
					</c:if>
					<c:if test="${ item.monthlyRentPrice ne -1 }">
						<td>${ item.monthlyRentPrice }</td>
					</c:if>
					<c:if test="${ item.SQM ne -1 }">
						<td>${ item.SQM }</td>
					</c:if>
					<c:if test="${ item.pricePerSQM ne -1 }">
						<td>${ item.pricePerSQM }</td>
					</c:if>
					<c:if test="${ item.price ne -1 }">
						<td>${ item.price }</td>
					</c:if>
					<c:choose>
						<c:when test="${ type eq 'sell' }">
							<td><input type='submit' value='구매신청'
								name='data" + ${ item.itemNumber }' class='btn btn-primary'>
							</td>
							<td style='text-align: center;'><span
								onclick="btn('${item.address}', '${ item.itemNumber}번 매물')"
								class='btn btn-primary'>지도 보기</span></td>
						</c:when>
						<c:when test="${ type eq 'update' }">
							<td><input type='submit' value='삭제'
								name='remove_data${item.itemNumber}' class='btn btn-primary'>
							</td>
						</c:when>
						<c:otherwise>
							<td style='text-align: center;'><span
								onclick="btn('${item.address}', '${ item.itemNumber}번 매물')"
								class='btn btn-primary'>지도 보기</span></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</form>

	<script>
		function btn(address,locate="") {
			parent.viewInKakaoMap(address,locate);
		}
	</script>


	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='vendor/jquery/jquery.slim.min.js' />"></script>
	<script
		src="<c:url value='vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>