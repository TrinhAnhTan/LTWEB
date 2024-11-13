<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container mt-4">
    <h2 class="text-center mb-4">Chi Tiết Video</h2>

    <div class="row">
        <div class="col-md-4">
            <img src="${video.poster}" alt="${video.title}" class="img-fluid">
        </div>
        <div class="col-md-8">
            <h3>Tiêu đề: ${video.title}</h3>
            <p><strong>Mã video:</strong> ${video.videoId}</p>
            <p><strong>Mã danh mục:</strong> ${video.category.categoryName}</p>
            <p><strong>View:</strong> ${video.views}</p>
            <p><strong>Share:</strong> ${video.shareCount}</p>
        </div>
    </div>

    <div class="mt-4">
        <h4>Mô tả:</h4>
        <p>${video.description}</p>
    </div>

    <div class="mt-4">
        <a href="${pageContext.request.contextPath}/videos" class="btn btn-secondary">Quay Lại Danh Sách</a>
    </div>
</div>
