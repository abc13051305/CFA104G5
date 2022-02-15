<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="ezs.ren_favorites.model.*"%>

<%
	RenFavoritesService renFavSvc = new RenFavoritesService();
    List<RenFavoritesVO> list = renFavSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>房源收藏</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

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
<jsp:include page="/frontend/EZ_header.jsp"></jsp:include>

<table id="table-1">
	<tr><td>
		 <h3>房源收藏</h3>
		 <h4><a href="<%=request.getContextPath()%>/frontend/ren_favorites/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
		<th>會員編號</th>
		<th>房源編號</th>
		<th>加入收藏時間</th>
<!-- 		<th>刪除</th> -->
	</tr>
	<%@ include file="page1.file" %> 
	
	<c:forEach var="renFavoritesVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${renFavoritesVO.favMemId}</td>
			<td>${renFavoritesVO.favLisId}</td>
			<td>${renFavoritesVO.favAddTime}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/RenFavoritesServlet.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="favMemId"  value="${renAppointmentVO.favMemId}">
			     <input type="hidden" name="favLisId"  value="${renAppointmentVO.favLisId}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
<jsp:include page="/frontend/EZ_footer.jsp"></jsp:include>
</body>
</html>
