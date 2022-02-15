<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="ezs.sec_items.model.*"%>

<%
SecItemsService secItemsSvc = new SecItemsService();
List<SecItemsVO> list = secItemsSvc.getAll();
pageContext.setAttribute("list", list);
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有二手商品</title>
<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>
</head>
<body>
	<a href="<%=request.getContextPath() %>/frontend/secItems/select_sec_items_page.jsp">回首頁</a>
	<table>
		<tr>
			<th>shID</th>
			<th>shCateID</th>
			<th>shSellerID</th>
			<th>shName</th>
			<th>shPrice</th>
			<th>shQTY</th>
			<th>shSize</th>
			<th>shDescription</th>
			<th>shCondition</th>
			<th>shTime</th>
			<th>shGuarantee</th>
			<th>shStatus</th>
			<th>shCounty</th>
			<th>shDist</th>
		
		</tr>

		<c:forEach var="secItemsVO" items="${list}">
			<tr>
				<td>${secItemsVO.shID}</td>
				<td>${secItemsVO.shCateID}</td>
				<td>${secItemsVO.shSellerID}</td>
				<td>${secItemsVO.shName}</td>
				<td>${secItemsVO.shPrice}</td>
				<td>${secItemsVO.shQTY}</td>
				<td>${secItemsVO.shSize}</td>
				<td>${secItemsVO.shDescription}</td>
				<td>${secItemsVO.shCondition}</td>
				<td>${secItemsVO.shTime}</td>
				<td>${secItemsVO.shGuarantee}</td>
				<td>${secItemsVO.shStatus}</td>
				<td>${secItemsVO.shCounty}</td>
				<td>${secItemsVO.shDist}</td>
			

			</tr>
		</c:forEach>
	</table>
</body>
</html>