<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="d-flex justify-content-center align-items-center vh-100"
     style="background: linear-gradient(to bottom, rgba(0, 0, 0, 1) 0%, rgba(0, 0, 0, 0.7) 20%, rgba(148, 0, 211, 0.3) 50%, rgba(72, 61, 139, 0.6) 80%, rgba(0, 0, 0, 1) 100%);
            padding: 0; width: 100%; height: 100vh;">
    <div class="card p-4 shadow-lg" style="width: 100%; max-width: 400px; background: rgba(0, 0, 0, 0.8); border-radius: 10px;">
        <h2 class="text-center text-primary mb-4" style="font-family: 'Poppins', sans-serif; color: #fff;">Đăng Ký Tài Khoản</h2>

        <form action="${pageContext.request.contextPath}/register" method="POST">
            <!-- Tên đăng nhập -->
            <div class="mb-3">
                <label for="username" class="form-label text-white">Tên Đăng Nhập</label>
                <input type="text" class="form-control" id="username" name="username" required style="background-color: rgba(255, 255, 255, 0.2); border: 1px solid rgba(255, 255, 255, 0.3); color: #fff;">
            </div>

            <!-- Tên đầy đủ -->
            <div class="mb-3">
                <label for="fullname" class="form-label text-white">Tên Đầy Đủ</label>
                <input type="text" class="form-control" id="fullname" name="fullname" required style="background-color: rgba(255, 255, 255, 0.2); border: 1px solid rgba(255, 255, 255, 0.3); color: #fff;">
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label for="email" class="form-label text-white">Email</label>
                <input type="email" class="form-control" id="email" name="email" required style="background-color: rgba(255, 255, 255, 0.2); border: 1px solid rgba(255, 255, 255, 0.3); color: #fff;">
            </div>

            <!-- Số điện thoại -->
            <div class="mb-3">
                <label for="phone" class="form-label text-white">Số Điện Thoại</label>
                <input type="text" class="form-control" id="phone" name="phone" required style="background-color: rgba(255, 255, 255, 0.2); border: 1px solid rgba(255, 255, 255, 0.3); color: #fff;">
            </div>

            <!-- Mật khẩu -->
            <div class="mb-3">
                <label for="password" class="form-label text-white">Mật Khẩu</label>
                <input type="password" class="form-control" id="password" name="password" required style="background-color: rgba(255, 255, 255, 0.2); border: 1px solid rgba(255, 255, 255, 0.3); color: #fff;">
            </div>

            <!-- Xác nhận mật khẩu -->
            <div class="mb-3">
                <label for="confirmPassword" class="form-label text-white">Xác Nhận Mật Khẩu</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required style="background-color: rgba(255, 255, 255, 0.2); border: 1px solid rgba(255, 255, 255, 0.3); color: #fff;">
            </div>

            <!-- Nút đăng ký -->
            <button type="submit" class="btn btn-primary w-100" style="transition: transform 0.2s ease; border-radius: 20px; background: linear-gradient(45deg, rgba(75, 0, 130, 0.7), rgba(148, 0, 211, 0.7)); color: #fff; font-weight: bold;">
                Đăng Ký
            </button>
        </form>

        <div class="mt-3 text-center">
            <p class="text-white">Đã có tài khoản? <a href="${pageContext.request.contextPath}/login" class="text-decoration-none text-light" style="transition: color 0.3s; font-size: 14px;">Đăng nhập ngay</a></p>
        </div>
    </div>
</div>
