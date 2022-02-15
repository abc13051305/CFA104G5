<!-- !!!!!!!!!!!	暫存放這 可能刪掉	!!!!!!!!!!!!!!! -->


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="ezs.ren_appointment.model.*"%>


<%
	RenAppointmentService renAppSvc = new RenAppointmentService();
    List<RenAppointmentVO> list = renAppSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>BACKEND 所有預約訂單資料 - listAllRenAppointment.jsp</title>

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
<body bgcolor='white'>
<jsp:include page="/frontend/EZ_header.jsp"></jsp:include>


<table id="table-1">
	<tr><td>
		 <h3>BACKEND 所有預約訂單資料 - listAllRenAppointment.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
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
		<th>預約訂單ID</th>
		<th>會員ID</th>
		<th>房東ID</th>
		<th>房源ID</th>
		<th>預約單狀態</th>
		<th>預約時間</th>
		<th>預約訂單成立時間</th>
<!-- 		<th>修改</th> -->
<!-- 		<th>刪除</th> -->
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="renAppointmentVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${renAppointmentVO.aptId}</td>
			<td>${renAppointmentVO.aptMemId}</td>
			<td>${renAppointmentVO.aptLddId}</td>
			<td>${renAppointmentVO.aptLisId}</td>
			<td>
				<c:if test="${renAppointmentVO.aptStatus == 0}">待確認預約</c:if>
				<c:if test="${renAppointmentVO.aptStatus == 1}">已確認預約</c:if>
				<c:if test="${renAppointmentVO.aptStatus == 2}">已取消</c:if>
			</td>
			<td>${renAppointmentVO.aptTime}</td> 
			<td>${renAppointmentVO.aptTimestamp}</td>
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ren_appointment/ren_appointment.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="修改"> -->
<%-- 			     <input type="hidden" name="aptId"  value="${renAppointmentVO.aptId}"> --%>
<!-- 			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM> -->
<!-- 			</td> -->
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ren_appointment/ren_appointment.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="刪除"> -->
<%-- 			     <input type="hidden" name="aptId"  value="${renAppointmentVO.aptId}"> --%>
<!-- 			     <input type="hidden" name="action" value="delete"></FORM> -->
<!-- 			</td> -->
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
<jsp:include page="/frontend/EZ_footer.jsp"></jsp:include>
</body>
</html>