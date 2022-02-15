<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ezs.ren_appointment.model.*"%>


<jsp:useBean id="listRenAppByLDD" scope="request" type="java.util.List<RenAppointmentVO>" />
<jsp:useBean id="memSvc" scope="page" class="ezs.member.model.MemberService" />


<html>
<head><title>房東的所有預約訂單 - listRenAppByLDD.jsp</title>

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
		 <h3>房東的所有預約訂單 - listRenAppByLDD.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/frontend/ren_appointment/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>


<table>
	<tr>
		<th>預約訂單ID</th>
		<th>會員ID</th>
		<th>房源ID</th>
		<th>預約單狀態</th>
		<th>預約時間</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<c:forEach var="renAppointmentVO" items="${listRenAppByLDD}">
		<tr align='center' valign='middle'>
			<td>${renAppointmentVO.aptId}</td>
			<td>${renAppointmentVO.aptMemId}</td>
			<td>${renAppointmentVO.aptLisId}</td>
			<td>
				<c:if test="${renAppointmentVO.aptStatus == 0}">待確認預約</c:if>
				<c:if test="${renAppointmentVO.aptStatus == 1}">已確認預約</c:if>
				<c:if test="${renAppointmentVO.aptStatus == 2}">已取消</c:if>
			</td>
			<td>${renAppointmentVO.aptTime}</td>			

			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/RenAppointmentServlet.do" style="margin-bottom: 0px;">
					<input type="submit" value="修改"> 
					<input type="hidden" name="aptId" value="${renAppointmentVO.aptId}"> 
					<input type="hidden" name="action" value="getOne_For_Update">
				</FORM>
			</td>
			<td>
				<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/RenAppointmentServlet.do" style="margin-bottom: 0px;">
					<input type="submit" value="刪除"> 
					<input type="hidden" name="aptId" value="${renAppointmentVO.aptId}"> 
					<input type="hidden" name="action" value="delete">
				</FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<jsp:include page="/frontend/EZ_footer.jsp"></jsp:include>
</body>
</html>