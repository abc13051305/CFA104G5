<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ezs.sec_items.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
SecItemsVO secItemsVO = (SecItemsVO) request.getAttribute("secItemsVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath() %>/frontend/secItems/select_sec_items_page.jsp">回首頁</a>
	<table>
		<tr>
			<th>shID</th>
			<th>shCateID</th>
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
		<tr>
			<td>${secItemsVO.shID}</td>
			<td>${secItemsVO.shCateID}</td>
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
	</table>
</body>
</html>