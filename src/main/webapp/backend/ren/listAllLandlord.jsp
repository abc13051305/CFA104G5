<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="ezs.ren_landlord.model.*"%>

<%
RenLandlordService renlandlordSvc = new RenLandlordService();
List<RenLandlordVO> list = renlandlordSvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>�Ҧ��ӽЩЪF��� - listAllLandlord.jsp</title>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>�Ҧ��ЪF��� - listAllLandlord.jsp</h3>
				<h4>
					<a href="select.jsp"><img
						src="<%=request.getContextPath()%>/images/ren/back_icon.png"
						width="60" height="60" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<table>
		<tr>
			<th>�ЪF�s��</th>
			<th>�|���s��</th>
			<th>�|���W��</th>
			<th>�f�֪��A</th>
			<th>�ק�</th>
			<th>�R��</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="renLandlordVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<tr>
				<td>${renLandlordVO.lddId}</td>
				<td>${renLandlordVO.lddMemId}</td>
				<td></td>
				<td>
					<c:if test="${renLandlordVO.lddApproval == 0}">�f�֤�</c:if>
					<c:if test="${renLandlordVO.lddApproval == 1}">�f�֥��L</c:if> 
					<c:if test="${renLandlordVO.lddApproval == 2}">�f�֤w�L</c:if>
				</td>

				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/ren_landlord/RenLandlordServlet.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="�ק�"> <input type="hidden"
							name="lddId" value="${renLandlordVO.lddId}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/ren_landlord/RenLandlordServlet.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="�R��"> <input type="hidden"
							name="lddId" value="${renLandlordVO.lddId}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>