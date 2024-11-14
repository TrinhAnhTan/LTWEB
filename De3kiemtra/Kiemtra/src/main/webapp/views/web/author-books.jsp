<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-4">
    <h2 class="text-center text-light mb-4">Danh Sách Tác Giả Và Sách</h2>

    <c:forEach var="author" items="${authors}">
        <div class="author-section mb-5">
            <h3 class="author-name">Tác giả: ${author.authorName}</h3>
            <p class="author-info">Ngày sinh: ${author.dateOfBirth}</p>

            <table class="table table-bordered table-striped table-dark">
                <thead>
                <tr>
                    <th>Hình Ảnh</th>
                    <th>Thông Tin Sách</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${author.books}">
                    <tr>
                        <td>
                            <img src="${book.coverImage}" alt="Cover Image" class="book-image">
                        </td>
                        <td>
                            <p><strong>Tiêu đề:</strong> ${book.title}</p>
                            <p><strong>Nhà xuất bản:</strong> ${book.publisher}</p>
                            <p><strong>Ngày xuất bản:</strong> ${book.publishDate}</p>
                            <p><strong>Số lượng:</strong> ${book.quantity}</p>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:forEach>
</div>

<style>
    .author-section {
        background: #333;
        padding: 15px;
        border-radius: 8px;
        margin-bottom: 20px;
    }

    .author-name {
        color: #007bff;
        margin-bottom: 10px;
        font-size: 1.5rem;
    }

    .author-info {
        color: #ddd;
        margin-bottom: 15px;
    }

    .book-image {
        max-width: 80px;
        border-radius: 5px;
    }
</style>
