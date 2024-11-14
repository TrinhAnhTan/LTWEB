<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<div class="homepage-container">
    <div class="homepage-content">
        <h1 class="homepage-title">Welcome</h1>
        <p class="homepage-text">Trịnh Anh Tân - 20146041</p>
    </div>
</div>

<style>
.homepage-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color:
    font-family: Arial, sans-serif;
}

.homepage-content {
    text-align: center;
    padding: 20px;
    background: #ffffff;
    border: 1px solid #ddd;
    border-radius: 8px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.homepage-title {
    font-size: 2rem;
    color: #333; /* Màu chữ tối */
    margin-bottom: 10px;
}

.homepage-text {
    font-size: 1rem;
    color: #666; /* Màu chữ nhẹ hơn */
}
</style>
