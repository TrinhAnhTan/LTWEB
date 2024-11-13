<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-4">
    <h2 class="text-center mb-4">${video != null ? "Chỉnh Sửa Video" : "Thêm Video Mới"}</h2>

    <form action="${pageContext.request.contextPath}/videos?action=save" method="post">
        <input type="hidden" name="videoId" value="${video != null ? video.videoId : ''}">
        <div class="mb-3">
            <label for="title" class="form-label">Tiêu Đề:</label>
            <input type="text" id="title" name="title" class="form-control" value="${video != null ? video.title : ''}" required>
        </div>
        <div class="mb-3">
            <label for="poster" class="form-label">Poster:</label>
            <input type="text" id="poster" name="poster" class="form-control" value="${video != null ? video.poster : ''}" required>
        </div>
        <div class="mb-3">
            <label for="views" class="form-label">Lượt Xem:</label>
            <input type="number" id="views" name="views" class="form-control" value="${video != null ? video.views : 0}" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô Tả:</label>
            <textarea id="description" name="description" class="form-control" rows="3" required>${video != null ? video.description : ''}</textarea>
        </div>
        <div class="mb-3">
            <label for="active" class="form-label">Trạng Thái Hoạt Động:</label>
            <select id="active" name="active" class="form-select">
                <option value="true" ${video == null || video.active ? "selected" : ""}>Hoạt động</option>
                <option value="false" ${video != null && !video.active ? "selected" : ""}>Không hoạt động</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="categoryId" class="form-label">Danh Mục:</label>
            <input type="number" id="categoryId" name="categoryId" class="form-control" value="${video != null ? video.category.categoryId : ''}" required>
        </div>
        <button type="submit" class="btn btn-success">${video != null ? "Lưu Thay Đổi" : "Thêm Mới"}</button>
        <a href="${pageContext.request.contextPath}/videos" class="btn btn-secondary">Hủy</a>
    </form>
</div>
