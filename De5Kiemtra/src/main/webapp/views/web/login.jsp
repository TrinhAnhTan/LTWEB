<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="d-flex justify-content-center align-items-center vh-100"
     style="background: linear-gradient(to bottom, rgba(0, 0, 0, 1) 0%, rgba(0, 0, 0, 0.7) 20%, rgba(148, 0, 211, 0.3) 50%, rgba(72, 61, 139, 0.6) 80%, rgba(0, 0, 0, 1) 100%);
            padding: 0; width: 100%; height: 100vh;">
    <div class="card p-4 shadow-lg" style="width: 100%; max-width: 400px; background: rgba(0, 0, 0, 0.8); border-radius: 10px;">
        <h2 class="text-center text-primary mb-4" style="font-family: 'Poppins', sans-serif; color: #fff;">Đăng Nhập</h2>

        <form action="${pageContext.request.contextPath}/login" method="POST">
            <!-- Tên đăng nhập -->
            <div class="mb-3">
                <label for="username" class="form-label text-white">Tên Đăng Nhập</label>
                <input type="text" class="form-control" id="username" name="username" required style="background-color: rgba(255, 255, 255, 0.2); border: 1px solid rgba(255, 255, 255, 0.3); color: #fff;">
            </div>

            <!-- Mật khẩu -->
            <div class="mb-3">
                <label for="password" class="form-label text-white">Mật Khẩu</label>
                <input type="password" class="form-control" id="password" name="password" required style="background-color: rgba(255, 255, 255, 0.2); border: 1px solid rgba(255, 255, 255, 0.3); color: #fff;">
            </div>

            <!-- Nút đăng nhập -->
            <button type="submit" class="btn btn-primary w-100" style="transition: transform 0.2s ease; border-radius: 20px; background: linear-gradient(45deg, rgba(75, 0, 130, 0.7), rgba(148, 0, 211, 0.7)); color: #fff; font-weight: bold;">
                Đăng Nhập
            </button>
        </form>

        <div class="mt-3 text-center">
            <a href="${pageContext.request.contextPath}/forgot-password" class="text-decoration-none text-light" style="transition: color 0.3s; font-size: 14px;">
                Quên mật khẩu?
            </a>
        </div>
        <div class="mt-3 text-center">
            <a href="${pageContext.request.contextPath}/register" class="text-decoration-none text-light" style="transition: color 0.3s; font-size: 14px;">
                Đăng ký
            </a>
        </div>
    </div>
</div>

<style><%@ include file="/assets/css/login.css" %></style>
