<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ezs.ser_dmd.model.*"%>

<%
	SerDmdVO serDmdVO = (SerDmdVO) request.getAttribute("serDmdVO");
%>
<%= serDmdVO==null %> --${serDmdVO.dmdID}--  
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>新增需求單 - addSerDmd.jsp</title>

<style>
  table#table-1 {
    width: 450px;
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
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>新增需求單 - addSerDmd.jsp</h3></td><td style="text-align: center">
		 <h4><a href="/CFA104G5_20220129/backend/serDmd/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" enctype="multipart/form-data" ACTION="<%=request.getContextPath()%>/ser_dmd/SerDmdServlet.do" name="form1">
<table>
	<tr>
		<td>需求單狀態:</td>
		<td><input type="TEXT" name="dmdStatus" size="8"
			 value=0 /></td>
	</tr>
	<tr>
		<td>會員ID:</td>
		<td><input type="TEXT" name="dmdMemID" size="50"
			 value="<%= (serDmdVO==null)? "2" : serDmdVO.getDmdMemID() %>"/></td>
	</tr>
	
	<tr>
		<td>服務類別ID:</td>
		<td><input type="TEXT" name="dmdSerClaID" size="8"
			 value="<%= (serDmdVO==null)? "2" : serDmdVO.getDmdSerClaID() %>"/></td>
	</tr>
	<tr>
		<td>需求人姓名:</td>
		<td><input type="TEXT" name="dmdName" 
			 value="<%= (serDmdVO==null)? "劉冠鳴" : serDmdVO.getDmdName() %>"/></td>
	</tr>
	<tr>
		<td>需求人電話:</td>
		<td><input type="TEXT" name="dmdTel" 
			 value="<%= (serDmdVO==null)? "066220167" : serDmdVO.getDmdTel() %>"/></td>
	</tr>
	<tr>
		<td>需求人信箱:</td>
		<td><input type="EMAIL" name="dmdMail" 
			 value="<%= (serDmdVO==null)? "jimmypc03@hotmail.com.tw" : serDmdVO.getDmdMail() %>"/></td>
	</tr>
	<tr>
		<td>案場縣市:</td>
		<td><input type="TEXT" name="dmdCounty" size="20"
			 value="<%= (serDmdVO==null)? "台南市" : serDmdVO.getDmdCounty() %>"/></td>
	</tr>
	<tr>
		<td>案場地區:</td>
		<td><input type="TEXT" name="dmdRegion" size="20"
			 value="<%= (serDmdVO==null)? "柳營區" : serDmdVO.getDmdRegion() %>"/></td>
	</tr>
	<tr>
		<td>案場詳細地址:</td>
		<td><input type="TEXT" name="dmdAddress" size="50"
			 value="<%= (serDmdVO==null)? "是鄰里123號" : serDmdVO.getDmdAddress() %>"/></td>
	</tr>
	<tr>
		<td>空間類別:</td>
		<td><input type="TEXT" name="dmdSpaceClass" size="20"
			 value="<%= (serDmdVO==null)? "豪窄" : serDmdVO.getDmdSpaceClass() %>"/></td>
	</tr>
	<tr>
		<td>坪數:</td>
		<td><input type="TEXT" name="dmdSquare" 
			 value="<%= (serDmdVO==null)? "500" : serDmdVO.getDmdSquare() %>"/></td>
	</tr>
	<tr>
		<td>預算:</td>
		<td><input type="TEXT" name="dmdBudget" 
			 value="<%= (serDmdVO==null)? "50" : serDmdVO.getDmdBudget() %>"/></td>
	</tr>
	<tr>
		<td>需求簡介:</td>
		<td><input type="TEXT" name="dmdIntro" size= "100"
			 value="<%= (serDmdVO==null)? "搞裡頭" : serDmdVO.getDmdIntro() %>"/></td>
	</tr>
	<tr>
		<td>照片:</td>
		<td><input type="file" name="dmdPic" 
			 value="<%= (serDmdVO==null)? "" :serDmdVO.getDmdPic() %>"/></td>
	</tr>

	

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%-- <% 
  java.sql.Date hiredate = null;
  try {
	    hiredate = java.sql.Date.valueOf(request.getParameter("hiredate").trim());
   } catch (Exception e) {
	    hiredate = new java.sql.Date(System.currentTimeMillis());
   }
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script> --%>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
       <%--  $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
 	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=hiredate%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
       --%>  
        
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

        //      1.以下為某一天之前的日期無法選擇
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
</script>
</html>