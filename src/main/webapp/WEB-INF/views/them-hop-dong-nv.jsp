<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="aht.util.SecurityUtils"%>
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
				<h2>Thông Tin Hợp Đồng</h2>
				<div class="col-md-6 col-sm-12" style="float: left;">
					<form id="formHopDongNV">
						<div class="form-group">
						    <label for="contractEmpStartDate">Ngày Bắt Đầu</label>
						    <input type="date" class="form-control" id="contractEmpStartDate" name="contractEmpStartDate">
						 </div>
						 <div class="form-group">
						    <label for="contractEmpEndDate">Ngày Kết Thúc</label>
						    <input type="date" class="form-control" id="contractEmpEndDate" name="contractEmpEndDate">
						 </div>
						 <div class="radio">
						    <label for="contractEmpStatus">Trạng Thái</label>
						    <input type="radio" name="contractEmpStatus" value="1" style="margin-left: 3%;" checked>Còn Hợp Đồng
						    <input type="radio" name="contractEmpStatus" value="0" style="margin-left: 10%;">Hết Hợp Đồng
						 </div>
						 <div class="form-group">
						    <label for="inputPassword">Danh Sách Hợp Đồng</label>
						    <select id="inputPassword" style="height: 46px; margin-left: 66px;" name="contractDTO">
								<option>------------------------------------------------</option>
								<c:forEach items="${ contractDTOs}" var="contractDTO">
									<option value="${contractDTO.getId() }">${contractDTO.getContractType() }</option>
								</c:forEach>
							</select>
						 </div>
						<div class="form-group">
							<label for="inputPassword">Nhân Viên Thuộc Phòng</label> 
							<select id="employeeDTO" style="height: 43px;margin-left: 10%;">
								<option>------------------------------------------------</option>
								<c:forEach items="${ departmentDTOs}" var="departmentDTO">
									<option value="${departmentDTO.getId() }">${departmentDTO.getDepartmentName() }</option>
								</c:forEach>
							</select>
						</div>
					</form>
					<a href="<c:url value='/trang-user/quan-ly-hd-nv'/>"><button type="button" class="btn btn-primary">QUAY LẠI</button></a>
				</div>
				<div class="col-md-6 col-sm-12" style="float: right;margin-top: -2%;">
					<h3 id="phong">Danh Sách Nhân Viên Phòng </h3>
					<table class="table table-hover" id="danh-sach-nv">
						<thead>
							<tr>
								<th>Mã Nhân Viên</th>
								<th>Tên Nhân Viên</th>
								<th>Thêm Vào Hợp Đồng</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
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