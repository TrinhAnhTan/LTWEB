<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Main Content for Forgot Password --%>
<div class="d-flex justify-content-center align-items-center vh-100"
     style="background: linear-gradient(to bottom, rgba(0, 0, 0, 1) 0%, rgba(0, 0, 0, 0.7) 20%, rgba(148, 0, 211, 0.3) 50%, rgba(72, 61, 139, 0.6) 80%, rgba(0, 0, 0, 1) 100%);
            padding: 0; width: 100%; height: 100vh;">
    <div class="card p-4 shadow-lg" style="width: 100%; max-width: 400px; background: rgba(0, 0, 0, 0.8); border-radius: 10px;">
        <h2 class="text-center text-primary mb-4" style="font-family: 'Poppins', sans-serif; color: #fff;">Quên Mật Khẩu</h2>

        <p class="text-center text-white">Nhập email để đặt lại mật khẩu.</p>

        <form action="${pageContext.request.contextPath}/forgotpassword" method="POST">
            <div class="mb-3">
                <label for="email" class="form-label text-white">Địa chỉ email</label>
                <input type="email" class="form-control" id="email" name="email" required style="background-color: rgba(255, 255, 255, 0.2); border: 1px solid rgba(255, 255, 255, 0.3); color: #fff;">
            </div>
            <button type="submit" class="btn btn-primary w-100" style="transition: transform 0.2s ease; border-radius: 20px; background: linear-gradient(45deg, rgba(75, 0, 130, 0.7), rgba(148, 0, 211, 0.7)); color: #fff; font-weight: bold;">
                Gửi Yêu Cầu
            </button>
        </form>

        <div class="mt-4 text-center">
            <a href="${pageContext.request.contextPath}/login" class="text-decoration-none text-light" style="transition: color 0.3s; font-size: 14px;">
                Quay lại trang đăng nhập
            </a>
        </div>
    </div>
</div>

<style>
    /* Import Google Fonts */
    @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap');

    /* Card Animation */
    .card {
        animation: cardGlow 3s infinite alternate;
    }

    @keyframes cardGlow {
        0% {
            box-shadow: 0 4px 12px rgba(148, 0, 211, 0.4), 0 0 20px rgba(75, 0, 130, 0.6);
        }
        100% {
            box-shadow: 0 4px 20px rgba(148, 0, 211, 0.6), 0 0 40px rgba(75, 0, 130, 0.8);
        }
    }

    /* Button Hover Effects */
    button:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 16px rgba(148, 0, 211, 0.5);
    }

    /* Links Hover Effects */
    a:hover {
        color: #ffeb3b !important;
    }
</style>
