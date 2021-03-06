<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>연암 부동산</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="mycss.css" rel="stylesheet">
<style type="text/css">
</style>
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
		<h1 style="text-align: center;">전체 매물 보기</h1>
		<div id="map"
			style="display: block; margin: auto; width: 60vw; height: 30vh"></div>
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=baca3a5f6f931f8a69d6569bf6473bf5&libraries=services"></script>

		<a href="view/charter.view" target="main_frame"
			class="btn btn-primary">전세</a> 
		<a href="view/monthlyRent.view" target="main_frame" 
			class="btn btn-primary">월세</a> 
		<a href="view/land.view" target="main_frame"
			class="btn btn-primary">토지</a> 
		<a href="view/trading.view" target="main_frame" 
			class="btn btn-primary">매매</a>

	</div>
	<iframe src="<c:url value='/view/trading.view' />"
		style="display: block; margin: auto; width: 95vw; height: 50vh"
		id="main_frame" name="main_frame"> </iframe>

	<script>
		viewInKakaoMap('경상남도 진주시 가좌동 780', '학교');
		function viewInKakaoMap(address, locate) {
			////////////////////// 카카오 지도 API S /////////////////// 
			var coordXY = document.getElementById("coordXY"); //검색 지도 경도위도 알아내기 
			var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스 
			var options = {
				center : new kakao.maps.LatLng(33.450701, 126.570667), // 위도경도 
				level : 3
			//지도의 레벨(확대, 축소 정도) 
			};
			var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴 
			// 지도타입 컨트롤, 줌 컨트롤 생성 
			var mapTypeControl = new kakao.maps.MapTypeControl();
			map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
			var zoomControl = new kakao.maps.ZoomControl();
			map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
			// ★ 주소-좌표 변환 객체를 생성 
			var geocoder = new kakao.maps.services.Geocoder();
			// ★ 주소로 좌표를 검색 
			geocoder
					.addressSearch(
							address,
							function(result, status) {
								// 정상적으로 검색이 완료됐으면 
								if (status === kakao.maps.services.Status.OK) {
									var coords = new kakao.maps.LatLng(
											result[0].y, result[0].x);
									yy = result[0].x;
									xx = result[0].y;
									// 결과값으로 받은 위치를 마커로 표시 
									var marker = new kakao.maps.Marker({
										map : map,
										position : coords
									});
									// 인포윈도우로 장소에 대한 설명을 표시 
									var iwContent = '<div style="padding:5px;">'
											+ locate
											+ '<br>'
											+ '<a href="https://map.kakao.com/link/map/'+locate+','+ xx +', '+ yy +'" style="color:blue" target="_blank">큰지도보기</a>'
											+ " "
											+ '<a href="https://map.kakao.com/link/to/'+locate+','+ xx +', '+ yy +'" style="color:blue" target="_blank">길찾기</a>'
											+ '</div>';
									var infowindow = new kakao.maps.InfoWindow(
											{
												content : iwContent
											});
									infowindow.open(map, marker);
									// 지도의 중심을 결과값으로 받은 위치로 이동 
									map.setCenter(coords);
									// ★ resize 마커 중심 
									var markerPosition = marker.getPosition();
									$(window).on('resize', function() {
										map.relayout();
										map.setCenter(markerPosition);
									});
									// ★ 검색 경도위도 표시 
									coordXY.innerHTML = "<br>해당 주소의 X좌표(경도) : "
											+ xx + "<br><br>해당 주소의 Y좌표(위도) : "
											+ yy;
								} else {
									console.log('에러');
								}
							});
			//////////////////// // 카카오 지도 API E ///////////////////
		}
	</script>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.slim.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>



