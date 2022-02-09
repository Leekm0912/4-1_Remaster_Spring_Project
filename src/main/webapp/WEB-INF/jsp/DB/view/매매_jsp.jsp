<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.CallableStatement"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="db.vo.ItemVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>전세</title>

<!-- Bootstrap core CSS -->
<link href='<c:url value="/vendor/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
<link href='<c:url value="/vendor/mycss.css" />' rel="stylesheet">
<style type="text/css">
</style>
</head>
<body>
	<form action="to.jsp" method="post">
		<table class="type1">
			<%
			String type = (String)request.getAttribute("type");
			System.out.println(type);
			out.print("<input type='hidden' name='type' value='" + type + "'>");
			%>
			<tr>
				<th scope="cols">매물등록번호</th>
				<th scope="cols">등록일자</th>
				<th scope="cols">매도자명</th>
				<th scope="cols">주소</th>
				<th scope="cols">가격</th>
				<%
				
				if (type.equals("sell")) {
					out.print("<th scope='cols'>구매 버튼</th>");
					out.print("<th scope='cols'>지도 보기</th>");
				} else if (type.equals("update")) {
					out.print("<th scope='cols'>삭제 버튼</th>");
				} else {
					out.print("<th scope='cols'>지도 보기</th>");
				}
				%>

			</tr>
			<%
			List<ItemVO> data = (List<ItemVO>)request.getAttribute("data");

			for(ItemVO item : data){
				out.print("<tr>");
				out.print("<td style='text-align:center;'>" + item.getItemNumber() + "</td>");
				out.print("<td>" + item.getItemAddDate() + "</td>");
				out.print("<td style='text-align:center;'>" + item.getSellerName() + "</td>");
				out.print("<td>" + item.getAddress() + "</td>");
				out.print("<td>" + item.getPrice() + "원" + "</td>");
				
				if (type.equals("sell")) {
					out.print("<td><input type='submit' value='구매신청' name='data" + item.getItemNumber() + "' class='btn btn-primary'></td>");
					out.print("<td style='text-align:center;'><span onclick=\"btn('" + item.getAddress() + "', '" + item.getItemNumber()
					+ "번 매물')\" class='btn btn-primary'>지도 보기</span></td>");

				} else if (type.equals("update")) {
					out.print("<td><input type='submit' value='삭제' name='remove_data" + item.getItemNumber()
					+ "' class='btn btn-primary'></td>");
				} else {
					out.print("<td style='text-align:center;'><span onclick=\"btn('" + item.getAddress() + "', '" + item.getItemNumber()
					+ "번 매물')\" class='btn btn-primary'>지도 보기</span></td>");

				}
				
				out.print("</tr>");
			};
			%>
		</table>
	</form>

	<script>
		function btn(address,locate="") {
			parent.viewInKakaoMap(address,locate);
		}
	</script>


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.slim.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>