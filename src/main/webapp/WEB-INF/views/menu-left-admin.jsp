<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="nav-left-sidebar sidebar-dark">
            <div class="menu-list">
				<nav class="navbar navbar-expand-lg navbar-light">
                    <a class="d-xl-none d-lg-none" href="#">DANH MỤC</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav flex-column">
                            <li class="nav-divider">
                                Danh Mục
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="<c:url value='/quan-tri/trang-chu/quan-ly-user'/>" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1">
                                	<i class="fa fa-fw fa-user-circle"></i>Quản Lý User
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" aria-expanded="false" data-target="#submenu-2" aria-controls="submenu-2">
                                	<i class="fa fa-fw fa-rocket"></i>Danh Mục Role
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="#" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1">
                                	<i class="fa fa-fw fa-user-circle"></i>Phân Quyền User
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>                
            </div>
</div>