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
			<div class="col-md-4 col-sm-12 form-group" style="float:left; margin-top: 2.8%;">
			<hr />
				<form id="form-hop-dong" style="margin-top: 14.8%">
					<label>Mã Hợp Đồng</label> 
					<input type="text" class="form-control" id="ma-hop-dong" name="ContractCode">
					<br />
					<label>Loại Hợp Đồng</label> 
					<input type="text" class="form-control" id="loai-hop-dong" name="ContractType">
					<br /> 
					<button type="button" class="btn btn-dark" id="cancel">Cancel</button>
					<button type="button" class="btn btn-primary cap-nhat-hop-dong" id="cap-nhat-hop-dong">Cập Nhật</button>
					<button id="btn-them-hop-dong" type="button" class="btn btn-success" style="font-size: 12px;">Thêm</button>
				</form>
			</div>
			<div class="col-md-8 col-sm-12" style="float: right;">
			    <h2 style="text-align: right;">Danh Sách Hợp Đồng</h2>
			    <hr />
				<button type="button" class="btn btn-danger" id="button-xoa" 
						style="float: right; display: inline;font-size: 14px; margin-bottom: 2%;">Xóa</button>
				 <table class="table table-hover" id="bang-hop-dong">
					<thead>
						<tr>
							<th><input type="checkbox" class="AllCheckBox" id="allBox"></th>
							<th>Id Hợp Đồng</th>
							<th>Mã Hợp Đồng</th>
							<th>Loại Hợp Đồng</th>
							<th>Chỉnh Sửa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${dsHopDong}" var="HopDong">
							<tr>
								<td><input type="checkbox" value="${HopDong.id}" id="checkbox-id" name="checkbox-id"/></td>
								<td>${HopDong.id}</td>
								<td id="ma-hd">${HopDong.getContractCode()}</td>
								<td id="loai-hd">${HopDong.getContractType()}</td>
								<td><button type="button" class="btn btn-warning"
											value="${HopDong.id}" id="sua-hop-dong" style="font-size: 14px;">Sửa</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table> 
				
				<ul style="display: inline; list-style-type: none; margin-left: -6%;">
					<c:forEach begin="1" end="${tongHopDong}" var="trangThu">
						<li style="display: inline; margin-right: 0.2%;"><a
							 href="/aht/trang-user/quan-ly-hop-dong/${trangThu}" 
							style="padding: 7px 10px; border-radius: 5px; border: 1px blue solid;"><c:out value="${trangThu}" /></a></li>
					</c:forEach>
				</ul>
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
	 <script src="<c:url value='/resources/user/quan-ly-hop-dong.js'/>"></script>
</body>
</html>