<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="aht.util.SecurityUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>admin</title>
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
		<jsp:include page="header-admin.jsp"></jsp:include>
		<!-- end header -->

		<!-- menu -->
		<jsp:include page="menu-left-admin.jsp"></jsp:include>
		<!-- end menu -->

		<div class="dashboard-wrapper" style="margin-top: 5%;">
			<div class="col-md-12 col-sm-12 form-group"
				style="float: left; margin-top: 5%">
				<div class="row">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
						<div class="card">
							<a href="<c:url value='/quan-tri/trang-chu/quan-ly-user'/>" style="margin-left: 1.4%;">
								<button class="btn btn-space btn-primary">QUAY LẠI</button>
							</a>
							<h5 class="card-header">Cập Nhật Thông Tin User</h5>
							<div class="card-body">
								<form:form id="validationform" modelAttribute="userDTO" method="post" 
								action="/aht/quan-tri/trang-chu/sua-user">
									<div class="form-group row">
										<form:label path="id" class="col-12 col-sm-3 col-form-label text-sm-right">Mã Người Dùng</form:label>
										<div class="col-12 col-sm-8 col-lg-6">
											<form:input path="id" class="form-control" readonly="true"/>
										</div>
									</div>
									<div class="form-group row">
										<form:label path="userName" class="col-12 col-sm-3 col-form-label text-sm-right">Tên Người Dùng</form:label>
										<div class="col-12 col-sm-8 col-lg-6">
											<form:input path="userName" class="form-control"/>
										</div>
									</div>
									
									<div class="form-group row">
										<label for="check" class="col-12 col-sm-3 col-form-label text-sm-right">Có Thay Đổi Mật Khẩu Ko</label>
										<div class="col-12 col-sm-8 col-lg-6">
											<input type="checkbox" id="check" style="margin-top: 2%;"/>
										</div>
									</div>

									<div class="form-group row">
										<form:label path="userPass" class="col-12 col-sm-3 col-form-label text-sm-right">Mật Khẩu</form:label>
										<div class="col-sm-4 col-lg-3 mb-3 mb-sm-0">
											<form:password path="userPass" class="form-control" placeholder="nhập mật khẩu" readonly="true"/>
										</div>
										 <div class="col-sm-4 col-lg-3">
											<input type="password" required="" id="nhaplaimatkhau"
												data-parsley-equalto="#pass2" placeholder="Nhập lại Mật Khẩu" readonly="true"
												class="form-control">
										</div> 
										<label id="error"></label>
									</div>
									<div class="form-group row">
										<label class="col-12 col-sm-3 col-form-label text-sm-right">E-Mail</label>
										<div class="col-12 col-sm-8 col-lg-6">
											<form:input path="userMail" class="form-control"/>
										</div>
									</div>
									<div class="form-group row text-right">
										<div class="col col-sm-10 col-lg-9 offset-sm-1 offset-lg-0">
											<button type="submit" class="btn btn-space btn-primary" id="submit">UPDATE</button>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
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
	<script src="<c:url value='/resources/user/sua-user.js'/>"></script>
</body>
</html>