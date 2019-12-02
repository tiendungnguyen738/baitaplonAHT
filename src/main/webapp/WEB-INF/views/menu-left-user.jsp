<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="nav-left-sidebar sidebar-dark">
            <div class="menu-list">
				<nav class="navbar navbar-expand-lg navbar-light">
                    <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav flex-column">
                            <li class="nav-divider">
                                Menu
                            </li>
                            
                            <!-- Danh mục -->
                            
                            <li class="nav-item ">
                                <a class="nav-link active" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1"><i class="fa fa-fw fa-user-circle"></i>Danh Mục <span class="badge badge-success">6</span></a>
                                <div id="submenu-1" class="collapse submenu" style="">
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value='/trang-user/quan-ly-hop-dong'/>" >Danh Mục Hợp Đồng</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value='/trang-user/quan-ly-hd-nv'/>">Danh Mục Hợp Đồng NV</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value='/trang-user/quan-ly-bo-phan'/>">Danh Mục Bộ Phận</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value='/trang-user/quan-ly-pb'/>">Danh Mục Phòng Ban</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value='/trang-user/quan-ly-training-emp'/>">Danh Mục Khóa Đào Tạo</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            
                            <!--Hết danh mục -->
                           
                            <li class="nav-divider">
                                Features
                            </li>
                            
                           <!-- báo cáo quản lý nhân sự -->
                            <li class="nav-item">
                                <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-6" aria-controls="submenu-6"><i class="fas fa-fw fa-file"></i> Báo Cáo Quản Lý Nhân Sự </a>
                                <div id="submenu-6" class="collapse submenu" style="">
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <a class="nav-link" href="<c:url value='/trang-user/ds-nv-congty'/>">D/S Nhân Viên Công Ty</a>
                                        </li>
                                         <li class="nav-item">
                                            <a class="nav-link" href="pages/blank-page.html">D/S Nhân Viên Thử Việc</a>
                                        </li>
                                         <li class="nav-item">
                                            <a class="nav-link" href="pages/blank-page.html">D/S Nhân Viên Hết Hạn Hợp Đồng</a>
                                        </li>
                                         <li class="nav-item">
                                            <a class="nav-link" href="pages/blank-page.html">D/S Nhân Viên Và Các Khóa Đào Tạo</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                            <!-- hết báo cáo quản lý nhân sự -->
                        </ul>
                    </div>
                </nav>                
            </div>
</div>