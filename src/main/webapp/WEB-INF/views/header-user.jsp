<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="aht.util.SecurityUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ============================================================== -->
        <div class="dashboard-header">
            <nav class="navbar navbar-expand-lg bg-white fixed-top">
                <a class="navbar-brand" href="index.html">USER</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse " id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto navbar-right-top">
                        <li class="nav-item" style="margin-right: 20px;padding-right: 20px;">
                            <%=SecurityUtils.getPrincical().getUsername() %>
                        </li>
                         <li class="nav-item" style="margin-right: 111px;">
                           <a href="<c:url value='/thoat'/>"><i class="ace-icon fa fa-power-off"></i></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>