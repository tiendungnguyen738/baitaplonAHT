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
				<h2>Thông Tin Khóa Đào Tạo</h2>
				<div class="col-md-6 col-sm-12" style="float: left;">
					<form id="formKhoaDaoTao">
						<div class="form-group">
						    <label for="idNhanVien">Mã Nhân Viên</label>
						    <input type="text" class="form-control" id="idNhanVien" name="id" value="${khoaDaoTao.getAhtEmployee().getId()}">
						 </div>
						<div class="form-group">
						    <label for="tenNhanVien">Tên Nhân Viên</label>
						    <input type="text" class="form-control" id="tenNhanVien" name="empName" value="${khoaDaoTao.getAhtEmployee().getEmpName()}">
						 </div>
						<div class="form-group">
						    <label for="TrainingEmpStartDate">Ngày Bắt Đầu</label>
						    <input type="date" class="form-control" id="TrainingEmpStartDate" name="trainingEmpStartDate" value="${khoaDaoTao.getTrainingEmpStartDate()}">
						 </div>
						 <div class="form-group">
						    <label for="TrainingEmpEndDate">Ngày Kết Thúc</label>
						    <input type="date" class="form-control" id="TrainingEmpEndDate" name="trainingEmpEndDate" value="${khoaDaoTao.getTrainingEmpEndDate()}">
						 </div>
						 <div class="form-group">
						    <label for="TrainingEmpStatus">Trạng Thái</label>
						    <input type="text" class="form-control" id="TrainingEmpStatus" name="trainingEmpStatus" value="${khoaDaoTao.getTrainingEmpStatus()}">
						 </div>
						 <div class="form-group">
						    <label for="TrainingEmpResult">Kết Quả</label>
						    <input type="text" class="form-control" id="TrainingEmpResult" name="trainingEmpResult" value="${khoaDaoTao.getTrainingEmpResult()}">
						 </div>
						 <div class="form-group">
						    <label for="khoadaotao">Khóa Đào Tạo</label>
						    <select id="khoadaotao" style="height: 46px; margin-left: 66px;" name="trainingDTO" data-value="${khoaDaoTao.getAhtTraining().getId()}">
								<option>------------------------------------------------</option>
								<c:forEach items="${ trainingDTOs}" var="trainingDTO">
									<option value="${trainingDTO.getId() }">${trainingDTO.getTrainingName() }</option>
								</c:forEach>
							</select>
						 </div>
						<div class="form-group">
							<label for="employeeDTO">Nhân Viên Thuộc Phòng</label> 
							<select id="employeeDTO" style="height: 43px;">
								<option>------------------------------------------------</option>
								<c:forEach items="${ departmentDTOs}" var="departmentDTO">
									<option value="${departmentDTO.getId() }">${departmentDTO.getDepartmentName() }</option>
								</c:forEach>
							</select>
						</div>
					</form>
					<a href="<c:url value='/trang-user/quan-ly-training-emp'/>"><button type="button" class="btn btn-primary">Quay Lại</button></a>
					<button type="button" class="btn btn-info" id="update">Cập Nhật Thông Tin</button>
				</div>
				<div class="col-md-6 col-sm-12" style="float: right;margin-top: -2%;">
					<h3 id="phong">Danh Sách Nhân Viên Phòng </h3>
					<table class="table table-hover" id="danh-sach-nv">
						<thead>
							<tr>
								<th>Mã Nhân Viên</th>
								<th>Tên Nhân Viên</th>
								<th>Thêm Vào Khóa Đào Tạo</th>
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
	<script src="<c:url value='/resources/user/quan-ly-khoa-dao-tao.js'/>"></script>
</body>
</html>