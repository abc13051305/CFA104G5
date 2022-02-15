<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="ezs.sec_items.model.*"%>
<%@ page import="ezs.sec_pics.model.*"%>

<%
    SecPicsService secPicsSvc = new SecPicsService();
    List<SecPicsVO> list = secPicsSvc.getEachFirst();
    pageContext.setAttribute("list",list);
    
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EASY SPACE</title>
</head>
<body>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<c:forEach var="secPicsVO" items="${list}">
	<img src="${secPicsVO.shPic}">
	
	
	
	
	</c:forEach>


</body>
</html>