<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-4">
    <h2 class="text-center mb-4">Danh Sách Video</h2>

    <a href="${pageContext.request.contextPath}/videos?action=new" class="btn btn-primary mb-3">Thêm Video Mới</a>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tiêu Đề</th>
            <th>Poster</th>
            <th>Lượt Xem</th>
            <th>Trạng Thái</th>
            <th>Danh Mục</th>
            <th>Thao Tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="video" items="${videos}">
            <tr>
                <td>${video.videoId}</td>
                <td>${video.title}</td>
                <td><img src="${video.poster}" alt="Poster" style="width: 50px; height: auto;"></td>
                <td>${video.views}</td>
                <td>${video.active ? "Hoạt động" : "Không hoạt động"}</td>
                <td>${video.category.categoryName}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/videos?action=edit&videoId=${video.videoId}" class="btn btn-warning btn-sm">Sửa</a>
                    <a href="${pageContext.request.contextPath}/videos?action=delete&videoId=${video.videoId}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                    <a href="${pageContext.request.contextPath}/videos?action=details&videoId=${video.videoId}" class="btn btn-info btn-sm">Xem Chi Tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
