<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="register-container">
    <div class="register-card">
        <h2 class="register-title">Đăng Ký Tài Khoản</h2>

        <form action="${pageContext.request.contextPath}/register" method="POST">
            <div class="form-group">
                <label for="fullname" class="form-label">Tên Đầy Đủ</label>
                <input type="text" class="form-control" id="fullname" name="fullname" required>
            </div>

            <div class="form-group">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="phone" class="form-label">Số Điện Thoại</label>
                <input type="text" class="form-control" id="phone" name="phone" required>
            </div>

            <div class="form-group">
                <label for="passwd" class="form-label">Mật Khẩu</label>
                <input type="password" class="form-control" id="passwd" name="passwd" required>
            </div>

            <div class="form-group">
                <label for="confirmPassword" class="form-label">Xác Nhận Mật Khẩu</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            </div>

            <button type="submit" class="register-btn">Đăng Ký</button>
        </form>

        <div class="register-footer">
            <p>Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập ngay</a></p>
        </div>
    </div>
</div>

<style>
.register-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background: #f5f5f5;
}

.register-card {
    width: 100%;
    max-width: 400px;
    padding: 20px;
    background: #fff;
    border: 1px solid #ddd;
    border-radius: 5px;
}

.register-title {
    text-align: center;
    margin-bottom: 20px;
    font-size: 1.5rem;
    color: #333;
}

.form-group {
    margin-bottom: 15px;
}

.form-label {
    display: block;
    margin-bottom: 5px;
    color: #333;
}

.form-control {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.register-btn {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 5px;
    background: #333;
    color: #fff;
    cursor: pointer;
}

.register-footer {
    margin-top: 15px;
    text-align: center;
}

.register-footer a {
    color: #333;
    text-decoration: none;
}
</style>
