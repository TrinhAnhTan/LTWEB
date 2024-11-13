<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<style><%@ include file="/assets/css/header.css" %></style>

<header class="text-white shadow-sm">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">Trang Chủ</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto"> <!-- Left-aligned links -->
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/categories">Video theo danh mục</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/videos">CRUD Videos</a>
                    </li>
                </ul>
                <ul class="navbar-nav ms-auto"> <!-- Right-aligned links -->
                    <c:choose>
                        <c:when test="${sessionScope.username != null}"> <!-- Khi người dùng đã đăng nhập -->
                            <c:if test="${sessionScope.role == 'admin'}">
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/admin">Trang quản trị</a>
                                </li>
                            </c:if>
                            <li class="nav-item">
                                <span class="nav-link">Xin chào, ${sessionScope.fullname}</span>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
                            </li>
                        </c:when>
                        <c:otherwise> <!-- Khi người dùng chưa đăng nhập -->
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/register">Đăng ký</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </nav>
    </div>
</header>
