<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="aht.util.SecurityUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link rel="stylesheet" href="<c:url value='/resources/admin/assets/vendor/charts/c3charts/c3.css'/> ">
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
			<div class="col-md-12 col-sm-12 form-group" style="float:left;margin-top:5%">
			<a href="<c:url value='/quan-tri/trang-chu/user-role/them-user-role'/>" style="margin-left: 1.4%;">
				<button class="btn btn-space btn-primary">Danh Sách User Chưa Phân Quyền</button>
			</a>
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card">
                            <h5 class="card-header">Danh Sách User Đã Phân Quyền</h5>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered first">
                                        <thead>
                                           <tr>
												<td>Id</td>
												<td>Tên User</td>
												<td>Tên Quyền</td>
												<td>Cập Nhật Quyền</td>
												<td>Xóa Quyền</td>
											</tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listUserRole }" var="userRole">
												<tr>
													<td id="idUserRole" data-idUserRole="${userRole.getId() }">${userRole.getId() }</td>
													<td id="idUser" data-idUser="${userRole.getUserDTO().getId() }">${userRole.getUserDTO().getUserName() }</td>
													<td class="sua-quyen">
														<p>${userRole.getRoleDTO().getRoleName() }<p>
														<div>
															<select style="display:none;" class="roleList">
																<c:forEach items="${roleList }" var="role">
																	<option value="${role.getId() }">${role.getRoleName() }</option>
																</c:forEach>
															</select>
														</div>
													</td>
													<td style="text-align: center;" data-value="${userRole.getId()}">
															 <img id="update-quyen" alt="" src="<c:url value='/resources/admin/assets/images/update.jpg'/>" style="width: 40px;">
															 <button id='cancel' style="display:none;">cancel</button>
															<button id='update' style="display:none;">update</button>
													</td>
													<td style="text-align: center;">
														<a href="<c:url value='/quan-tri/trang-chu/user-role/them-user-role/xoa/${userRole.getId()}'/>" onclick="return confirm('you sure????')">
															<img alt="" src="<c:url value='/resources/admin/assets/images/deleteicon.jpg'/>" style="width:40px;">
														</a>
													</td>
												</tr>
											</c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
												<td>Id</td>
												<td>Tên User</td>
												<td>Tên Quyền</td>
												<td>Cập Nhật Quyền</td>
												<td>Xóa Quyền</td>
											</tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
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
	<script src="<c:url value='/resources/user/phan-quyen.js'/>"></script>
</body>
</html>