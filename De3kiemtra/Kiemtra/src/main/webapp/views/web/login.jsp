<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="login-container">
    <div class="login-card">
        <h2 class="login-title">Đăng Nhập</h2>

        <form action="${pageContext.request.contextPath}/login" method="POST">
            <div class="form-group">
                <label for="email" class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="password" class="form-label">Mật Khẩu</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>

            <button type="submit" class="login-btn">Đăng Nhập</button>
        </form>

        <div class="extra-links">
            <a href="${pageContext.request.contextPath}/forgot-password">Quên mật khẩu?</a>
            <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
        </div>
    </div>
</div>

<style>
.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background: #f5f5f5;
}

.login-card {
    width: 100%;
    max-width: 400px;
    padding: 20px;
    background: #fff;
    border: 1px solid #ddd;
    border-radius: 5px;
}

.login-title {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
    font-size: 1.5rem;
}

.form-group {
    margin-bottom: 15px;
}

.form-label {
    display: block;
    color: #333;
    margin-bottom: 5px;
}

.form-control {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background: #fff;
    color: #333;
}

.login-btn {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 5px;
    background: #333;
    color: #fff;
    cursor: pointer;
}

.extra-links {
    margin-top: 15px;
    text-align: center;
}

.extra-links a {
    color: #333;
    text-decoration: none;
    font-size: 0.9rem;
}
</style>
