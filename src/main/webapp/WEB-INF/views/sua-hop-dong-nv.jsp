<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="aht.util.SecurityUtils"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>user</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<c:url value='/resources/admin/assets/vendor/bootstrap/css/bootstrap.min.css'/> ">
<link
	href="<c:url value='/resources/admin/assets/vendor/fonts/circular-std/style.css'/>"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value='/resources/admin/assets/libs/css/style.css'/> ">
<link rel="stylesheet"
	href="<c:url value='/resources/admin/assets/vendor/fonts/fontawesome/css/fontawesome-all.css'/> ">
<link rel="stylesheet"
	href="<c:url value='/resources/admin/assets/vendor/charts/chartist-bundle/chartist.css'/> ">
<link rel="stylesheet"
	href="<c:url value='/resources/admin/assets/vendor/charts/morris-bundle/morris.css'/> ">
<link rel="stylesheet"
	href="<c:url value='/resources/admin/assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css'/> ">
<link rel="stylesheet"
	href="<c:url value='/resources/admin/assets/vendor/charts/c3charts/c3.css'/> ">
<link rel="stylesheet"
	href="<c:url value='/resources/admin/assets/vendor/fonts/flag-icon-css/flag-icon.min.css'/> ">
</head>
<body>
	<div class="dashboard-main-wrapper">
		<!-- header -->
		<jsp:include page="header-user.jsp"></jsp:include>
		<!-- end header -->

		<!-- menu -->
		<jsp:include page="menu-left-user.jsp"></jsp:include>
		<!-- end menu -->

		<div class="dashboard-wrapper" style="margin-top: 5%;">
			<div class="col-md-12 col-sm-12">
				<h2>Cập Nhật Thông Tin Hợp Đồng</h2>
				<a href="<c:url value='/trang-user/quan-ly-hd-nv'/>"><button type="button" class="btn btn-primary" style="margin-top: -6%; height: 38px; width: 27%;">QUAY LẠI</button></a>
				<div class="col-md-6 col-sm-12" style="float: left;margin-left: 22%;">	
					<form:form action="cap-nhat" modelAttribute="contractEmpDTO" method="post">
						<div class="form-group">
						    <form:label path="id">Mã Hợp Đồng</form:label>
						    <form:input path="id" class="form-control" readonly="true"/>
						 </div>
						 <div class="form-group">
						 	<form:label path="employeeDTO.id">Mã nhân viên</form:label>
						 	<form:input path="employeeDTO.id" class="form-control" readonly="true"/>
						 </div>
						 <div class="form-group">
						    <form:label path="employeeDTO.empName">Tên nhân viên</form:label>
						    <form:input path="employeeDTO.empName" class="form-control" readonly="true"/>
						 </div>
						 <div class="form-group">
						 	<form:label path="employeeDTO.department.departmentName">Nhân viên thuộc phòng</form:label>
						    <form:input path="employeeDTO.department.departmentName"
						 		  readonly="true" style="width: 67%;height: 39px"/>
						 </div>
						 	<form:hidden path="employeeDTO.department.id"/>
						 <div class="form-group">
						    <form:label path="contractDTO.id">Loại Hợp Đồng</form:label>
						   <form:select path="contractDTO.id" style="margin-left: 12%; height: 41px; width: 67%;">
						   		<form:options items="${contractDTOs }" itemValue="id" itemLabel="ContractType"/>
						   	</form:select>
						   	<form:hidden path="contractDTO.id" id="test"/>
						 </div>
						 <div class="form-group">
						  	<form:label path="ContractEmpStartDate">Ngàu bắt đầu</form:label>  
						  	<form:input path="ContractEmpStartDate" type="date" style="width: 66%;margin-left: 14%; height: 39px;"/>
						 </div>
						 <div class="form-group">
						    <form:label path="ContractEmpEndDate">Ngày kết thúc</form:label>
						    <form:input path="ContractEmpEndDate" type="date" style="width: 67%; height: 39px; margin-left: 13%;"/>
						 </div>
						 <div class="form-group">
						    <form:label path="ContractEmpStatus">Trạng thái</form:label>
						    <%-- <form:input path="trainingEmpStatus" style="width: 66%; height: 38px;margin-left: 19%;"/> --%>
						    <form:radiobutton path="ContractEmpStatus" value="1" style="margin-left: 18%;"/>Còn Hợp Đồng
						    <form:radiobutton path="ContractEmpStatus" value="0" style="margin-left: 18%;"/>Hết Hợp Đồng
						 </div>
						 <input type="submit" value="Cập Nhật Thông Tin" style="width: 100%;" class="btn btn-success"/>
					</form:form>
				</div>
				<div class="col-md-6 col-sm-12" style="float: right;margin-top: -2%;">
					
				</div>
			</div>
		</div>
	</div>
	<script
		src="<c:url value='/resources/admin/assets/vendor/jquery/jquery-3.3.1.min.js'/>"></script>
	<!-- bootstap bundle js -->
	<script
		src="<c:url value='/resources/admin/assets/vendor/bootstrap/js/bootstrap.bundle.js'/>"></script>
	<!-- slimscroll js -->
	<script
		src="<c:url value='/resources/admin/assets/vendor/slimscroll/jquery.slimscroll.js'/>"></script>
	<!-- main js -->
	<script
		src="<c:url value='/resources/admin/assets/libs/js/main-js.js'/>"></script>
	<!-- chart chartist js -->
	<script
		src="<c:url value='/resources/admin/assets/vendor/charts/chartist-bundle/chartist.min.js'/>"></script>
	<!-- sparkline js -->
	<script
		src="<c:url value='/resources/admin/assets/vendor/charts/sparkline/jquery.sparkline.js'/>"></script>
	<!-- morris js -->
	<script
		src="<c:url value='/resources/admin/assets/vendor/charts/morris-bundle/raphael.min.js'/>"></script>
	<script
		src="<c:url value='/resources/admin/assets/vendor/charts/morris-bundle/morris.js'/>"></script>
	<!-- chart c3 js -->
	<script
		src="<c:url value='/resources/admin/assets/vendor/charts/c3charts/c3.min.js'/>"></script>
	<script
		src="<c:url value='/resources/admin/assets/vendor/charts/c3charts/d3-5.4.0.min.js'/>"></script>
	<script
		src="<c:url value='/resources/admin/assets/vendor/charts/c3charts/C3chartjs.js'/>"></script>
	<script
		src="<c:url value='/resources/admin/assets/libs/js/dashboard-ecommerce.js'/>"></script>
	<script src="<c:url value='/resources/user/quan-ly-hop-dong-nv.js'/>"></script>
</body>
</html>