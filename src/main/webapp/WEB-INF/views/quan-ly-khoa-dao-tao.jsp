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
	<link rel="stylesheet" href="<c:url value='/resources/admin/assets/vendor/charts/c3charts/c3.css'/> ">
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
			<div class="col-md-12 col-sm-12" style="float: right;">
			 	<h2 style="text-align: right;">Danh Sách Khóa Đào Tạo</h2>
			    <hr />
			    <a href="<c:url value='/trang-user/quan-ly-training-emp/them-khoa-dao-tao'/>">
				    <button type="button" class="btn btn-outline-primary" style="border-radius:27%">ADD</button>
				</a>
				<button type="button" class="btn btn-outline-danger" id="button-xoa" 
						style="float: right; display: inline;margin-right: 4%; margin-bottom: 2%;border-radius: 29%;">Xóa</button>
				<table class="table table-hover" id="bang-bo-phan">
					<thead>
						<tr>
							<th><input type="checkbox" class="AllCheckBox" id="allBox"></th>
							<th>Mã</th>
							<th>Ngày Bắt Đầu</th>
							<th>Ngày Kết Thúc</th>
							<th>Trạng Thái</th>
							<th>Kết Quả</th>
							<th>Tên Nhân Viên</th>
							<th>Khóa Đào Tạo</th>
							<th>Setting</th>
						</tr>
					</thead>
					<tbody>
						 <c:forEach items="${listTraining}" var="training">
							<tr>
								<td><input type="checkbox" value="${training.id}" id="checkbox-id" name="checkbox-id"/></td>
								<td>${training.id}</td>
								<td>${training.getTrainingEmpStartDate()}</td>
								<td>${training.getTrainingEmpEndDate()}</td>
								<c:if test="${training.getTrainingEmpStatus() == 1}">
									<td>Đang Hoạt Động</td>	
								</c:if>
								<c:if test="${training.getTrainingEmpStatus() == 0}">
									<td>Không Hoạt Động</td>
								</c:if>
								<td>${training.getTrainingEmpResult()}</td>
								<td>${training.getEmployeeDTO().getEmpName()}</td>
								<td>${training.getTrainingDTO().getTrainingName()}</td>
								<td>
									<a href="<c:url value='/trang-user/quan-ly-training-emp/sua-thong-tin/${training.id}'/>">
									<button type="button" class="btn btn-outline-warning" style="border-radius: 29%;"
											 value="${training.id}" id="sua-bo-phan">Sửa</button>
									</a>
								</td>
							</tr>
						</c:forEach> 
					</tbody>
				</table>
			</div>		
		</div>
	</div>
	<script src="<c:url value='/resources/admin/assets/vendor/jquery/jquery-3.3.1.min.js'/>"></script>
	<!-- bootstap bundle js -->
	<script src="<c:url value='/resources/admin/assets/vendor/bootstrap/js/bootstrap.bundle.js'/>"></script>
	<!-- slimscroll js -->
	<script src="<c:url value='/resources/admin/assets/vendor/slimscroll/jquery.slimscroll.js'/>"></script>
	<!-- main js -->
	<script src="<c:url value='/resources/admin/assets/libs/js/main-js.js'/>"></script>
	<!-- chart chartist js -->
	<script src="<c:url value='/resources/admin/assets/vendor/charts/chartist-bundle/chartist.min.js'/>"></script>
	<!-- sparkline js -->
	<script src="<c:url value='/resources/admin/assets/vendor/charts/sparkline/jquery.sparkline.js'/>"></script>
	<!-- morris js -->
	<script src="<c:url value='/resources/admin/assets/vendor/charts/morris-bundle/raphael.min.js'/>"></script>
	<script src="<c:url value='/resources/admin/assets/vendor/charts/morris-bundle/morris.js'/>"></script>
	<!-- chart c3 js -->
	<script src="<c:url value='/resources/admin/assets/vendor/charts/c3charts/c3.min.js'/>"></script>
	<script src="<c:url value='/resources/admin/assets/vendor/charts/c3charts/d3-5.4.0.min.js'/>"></script>
	<script src="<c:url value='/resources/admin/assets/vendor/charts/c3charts/C3chartjs.js'/>"></script>
	<script src="<c:url value='/resources/admin/assets/libs/js/dashboard-ecommerce.js'/>"></script>
	<script src="<c:url value='/resources/user/quan-ly-khoa-dao-tao.js'/>"></script>
</body>
</html>