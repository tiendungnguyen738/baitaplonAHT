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
			<div class="col-md-12 col-sm-12 form-group" style="float:left;margin-top:5%">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card">
                            <h5 class="card-header">DANH SÁCH NHÂN VIÊN THỬ VIỆC</h5>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered first">
                                        <thead>
                                           <tr>
												<td>Mã Nhân Viên</td>
												<td>Tên Nhân Viên</td>
												<td>Ngày Sinh</td>
												<td>Giới Tính</td>
												<td>Số Bảo Hiểm</td>
												<td>Địa Chỉ</td>
												<td>Điện Thoại</td>
												<td>Phòng</td>
											</tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${employeeList }" var="employee">
												<tr>
													<td>${employee.getId() }</td>
													<td>${employee.getEmpName() }</td>
													<td>${employee.getEmpDob() }</td>
														<c:if test="${employee.getEmpSex() == 1 }">
															<td>Nam</td>
														</c:if>
														<c:if test="${employee.getEmpSex() == 0 }">
															<td>Nữ</td>
														</c:if>
													<td>${employee.getEmpNumberInsurance() }</td>
													<td>${employee.getEmpAddress() }</td>
													<td>${employee.getEmpPhone() }</td>
													<td>${employee.getDepartment().getDepartmentName() }</td>
												</tr>
											</c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
												<td>Mã Nhân Viên</td>
												<td>Tên Nhân Viên</td>
												<td>Ngày Sinh</td>
												<td>Giới Tính</td>
												<td>Số Bảo Hiểm</td>
												<td>Địa Chỉ</td>
												<td>Điện Thoại</td>
												<td>Phòng</td>
											</tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <ul class="pagination" style="float: right;	">
	                    <li class="page-item"><a class="page-link" href="<c:url value='/trang-user/ds-nv-thuviec/${trangTruoc}'/>">Previous</a></li>
	                    <c:forEach var="soTrang" begin="1" end="${soTrang}">               	
							  <li class="page-item">
							  	<a class="page-link" href="<c:url value='/trang-user/ds-nv-thuviec/${soTrang}'/>" style="padding-top: 29%;" >${soTrang }</a>
							  </li>
	                    </c:forEach>
	                     <li class="page-item"><a class="page-link" href="<c:url value='/trang-user/ds-nv-thuviec/${trangSau}'/>">Next</a></li>
                    </ul>
            <div style="margin-left: 2%;">
				<a href="<c:url value='/trang-user/ds-nv-thuviec/?type=xlsx'/>">
					<button type="button" class="btn btn-outline-success" style="width: 15%;">
						<img alt="" src="<c:url value='/resources/admin/assets/images/icondownload.png'/>" style="width: 21%;">
						DownLoad Excel
					</button>
				</a>
				<a href="<c:url value='/trang-user/ds-nv-thuviec/?type=pdf'/>">
					<button type="button" class="btn btn-outline-secondary" style="width: 15%;">
						<img alt="" src="<c:url value='/resources/admin/assets/images/icondownload2.ico'/>" style="width: 21%;">
						DownLoad PDF
					</button>
				</a>
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
	<script src="<c:url value='/resources/user/quan-ly-bo-phan.js'/>"></script>
</body>
</html>