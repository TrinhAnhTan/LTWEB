<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-4">
    <h2 class="text-center mb-4">${user != null ? "Chỉnh Sửa Người Dùng" : "Thêm Người Dùng Mới"}</h2>

    <!-- Form Thêm/Sửa -->
    <form action="${pageContext.request.contextPath}/users?action=save" method="post">
        <input type="hidden" name="id" value="${user != null ? user.id : ''}">
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" id="email" name="email" class="form-control" value="${user != null ? user.email : ''}" required>
        </div>
        <div class="mb-3">
            <label for="fullname" class="form-label">Họ Tên:</label>
            <input type="text" id="fullname" name="fullname" class="form-control" value="${user != null ? user.fullname : ''}" required>
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Số Điện Thoại:</label>
            <input type="text" id="phone" name="phone" class="form-control" value="${user != null ? user.phone : ''}" required>
        </div>
        <div class="mb-3">
            <label for="passwd" class="form-label">Mật Khẩu:</label>
            <input type="password" id="passwd" name="passwd" class="form-control" value="${user != null ? user.passwd : ''}" required>
        </div>
        <div class="mb-3">
            <label for="isAdmin" class="form-label">Quyền Admin:</label>
            <select id="isAdmin" name="isAdmin" class="form-select">
                <option value="0" ${user != null && user.isAdmin == 0 ? "selected" : ""}>Không</option>
                <option value="1" ${user != null && user.isAdmin == 1 ? "selected" : ""}>Có</option>
            </select>
        </div>
        <button type="submit" class="btn btn-success">${user != null ? "Lưu Thay Đổi" : "Thêm Mới"}</button>
        <a href="${pageContext.request.contextPath}/users" class="btn btn-secondary">Hủy</a>
    </form>
</div>
