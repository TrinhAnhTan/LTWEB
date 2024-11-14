<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-4">
    <h2 class="text-center mb-4">Danh Sách Người Dùng</h2>

    <!-- Nút Thêm Mới -->
    <a href="${pageContext.request.contextPath}/users?action=new" class="btn btn-primary mb-3">Thêm Người Dùng Mới</a>

    <!-- Bảng Danh Sách -->
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Họ Tên</th>
            <th>Số Điện Thoại</th>
            <th>Quyền Admin</th>
            <th>Thao Tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.fullname}</td>
                <td>${user.phone}</td>
                <td>${user.isAdmin == 1 ? "Yes" : "No"}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/users?action=edit&id=${user.id}" class="btn btn-warning btn-sm">Sửa</a>
                    <a href="${pageContext.request.contextPath}/users?action=delete&id=${user.id}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
