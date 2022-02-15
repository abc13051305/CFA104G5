<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ezs.ren_favorites.model.*"%>

<%
	RenFavoritesVO renFavoritesVO = (RenFavoritesVO) request.getAttribute("renFavoritesVO"); 
%>

<jsp:useBean id="listOneRenFavorites" scope="request" type="java.util.List<RenFavoritesVO>" />

<html>
<head>
<title>收藏房源資料 - listOneRenFavorites.jsp</title>

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
	width: 600px;
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

<table id="table-1">
	<tr><td>
		 <h3>收藏房源資料 - listOneRenFavorites.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>房源編號</th>
		<th>會員編號</th>
		<th>加入收藏時間</th>
	</tr>
	<c:forEach var="renFavoritesVO" items="${listOneRenFavorites}">
		<tr align='center' valign='middle'>
			<td>${renFavoritesVO.favLisId}</td>
			<td>${renFavoritesVO.favMemId}</td>
			<td>${renFavoritesVO.favAddTime}</td>		
		</tr>
	</c:forEach>
</table>

</body>
</html>