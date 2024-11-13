<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<div class="homepage-container">
    <div class="homepage-content">
        <h1 class="homepage-title">Welcome</h1>
        <p class="homepage-text">Trịnh Anh Tân - 20146041</p>
    </div>
</div>

<style>
/* CSS được bọc kỹ để tránh trùng lặp */
.homepage-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: calc(100vh - 100px); /* Điều chỉnh chiều cao trừ header và footer */
    background: linear-gradient(to bottom right, #474ca5, #8f94fb);
    text-align: center;
}

.homepage-content {
    padding: 20px;
    background: rgba(0, 0, 0, 0.6);
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    color: white;
}

.homepage-title {
    font-size: 2.5rem;
    margin-bottom: 15px;
}s

.homepage-text {
    font-size: 1rem;
    line-height: 1.5;
}
</style>
