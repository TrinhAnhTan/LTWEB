<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<style>
header {
    background-color: #333;
    padding: 10px 0;
}

.navbar {
    max-width: 1200px;
    margin: 0 auto;
    padding: 0 15px;
}

.navbar-brand, .nav-link {
    color: #fff;
    font-size: 14px;
    text-decoration: none;
}

.navbar-brand:hover, .nav-link:hover {
    color: #aaa;
}

.navbar-toggler {
    border-color: #fff;
}

.navbar-toggler-icon {
    background-color: #fff;
}
</style>

<header class="text-white shadow-sm">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-dark">
            <a class="navbar-brand" href="/Kiemtra">Trang Chủ</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/authors">Tác giả</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/users">CRUD Users</a>
                    </li>
                </ul>
                <ul class="navbar-nav ms-auto">
                    <c:if test="${sessionScope.admin == 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/admin">Trang quản trị</a>
                        </li>
                    </c:if>
                    <c:choose>
                        <c:when test="${sessionScope.userId != null}">
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/info">${sessionScope.fullname}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
                            </li>
                        </c:when>
                        <c:otherwise>
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
