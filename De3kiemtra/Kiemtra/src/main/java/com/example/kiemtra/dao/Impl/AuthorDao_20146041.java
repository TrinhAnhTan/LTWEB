package com.example.kiemtra.dao.Impl;

import com.example.kiemtra.config.ConnectDB;
import com.example.kiemtra.dao.IAuthorDao_20146041;
import com.example.kiemtra.model.Author_20146041;
import com.example.kiemtra.model.Book_20146041;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorDao_20146041 implements IAuthorDao_20146041 {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public void insertAuthor(Author_20146041 author) {
        String sql = "INSERT INTO author (author_name, date_of_birth) VALUES (?, ?)";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, author.getAuthorName());

            // Chuyển đổi java.util.Date sang java.sql.Date
            java.util.Date utilDate = author.getDateOfBirth();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  // Chuyển đổi

            ps.setDate(2, sqlDate);  // Thiết lập giá trị cho cột date_of_birth
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }


    @Override
    public Author_20146041 getAuthorById(int id) {
        String sql = "SELECT * FROM author WHERE author_id = ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Author_20146041 author = new Author_20146041();
                author.setAuthorId(rs.getInt("author_id"));
                author.setAuthorName(rs.getString("author_name"));
                author.setDateOfBirth(rs.getDate("date_of_birth"));
                return author;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public void updateAuthor(Author_20146041 author) {
        String sql = "UPDATE author SET author_name = ?, date_of_birth = ? WHERE author_id = ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, author.getAuthorName());

            // Chuyển đổi java.util.Date sang java.sql.Date
            java.util.Date utilDate = author.getDateOfBirth();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());  // Chuyển đổi

            ps.setDate(2, sqlDate);  // Thiết lập giá trị cho cột date_of_birth
            ps.setInt(3, author.getAuthorId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void deleteAuthor(int id) {
        String sql = "DELETE FROM author WHERE author_id = ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public List<Author_20146041> getAuthors(int page, int pageSize) {
        List<Author_20146041> authors = new ArrayList<>();
        String sql = "SELECT * FROM author LIMIT ? OFFSET ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);  // Offset calculation
            rs = ps.executeQuery();
            while (rs.next()) {
                Author_20146041 author = new Author_20146041();
                author.setAuthorId(rs.getInt("author_id"));
                author.setAuthorName(rs.getString("author_name"));
                author.setDateOfBirth(rs.getDate("date_of_birth"));
                authors.add(author);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return authors;
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int countAuthors() {
        String query = "SELECT COUNT(*) FROM author";
        try (Connection conn = ConnectDB.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1); // Trả về kết quả đếm
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0; // Nếu có lỗi hoặc không có tác giả
    }

    @Override
    public List<Author_20146041> getAuthorsWithBooks() {
        List<Author_20146041> authors = new ArrayList<>();
        String sql = "SELECT a.author_id, a.author_name, a.date_of_birth, " +
                "b.bookid, b.title, b.publisher, b.publish_date, b.cover_image, b.quantity " +
                "FROM author a " +
                "LEFT JOIN book_author ba ON a.author_id = ba.author_id " +
                "LEFT JOIN books b ON ba.bookid = b.bookid";

        try {
            con = ConnectDB.getConnection(); // Kết nối cơ sở dữ liệu
            ps = con.prepareStatement(sql);  // Chuẩn bị câu lệnh SQL
            rs = ps.executeQuery();          // Thực thi câu lệnh SQL

            Map<Integer, Author_20146041> authorMap = new HashMap<>(); // Lưu trữ tạm để nhóm sách theo tác giả

            while (rs.next()) {
                int authorId = rs.getInt("author_id");

                // Kiểm tra xem tác giả đã tồn tại trong map chưa
                Author_20146041 author = authorMap.getOrDefault(authorId, new Author_20146041());
                if (!authorMap.containsKey(authorId)) {
                    author.setAuthorId(authorId);
                    author.setAuthorName(rs.getString("author_name"));
                    author.setDateOfBirth(rs.getDate("date_of_birth"));
                    author.setBooks(new ArrayList<>()); // Khởi tạo danh sách sách cho tác giả
                    authorMap.put(authorId, author);
                }

                // Nếu có sách, thêm vào danh sách của tác giả
                if (rs.getInt("bookid") != 0) {
                    Book_20146041 book = new Book_20146041();
                    book.setBookId(rs.getInt("bookid"));
                    book.setTitle(rs.getString("title"));
                    book.setPublisher(rs.getString("publisher"));
                    book.setPublishDate(rs.getDate("publish_date"));
                    book.setCoverImage(rs.getString("cover_image"));
                    book.setQuantity(rs.getInt("quantity"));
                    author.getBooks().add(book);
                }
            }

            authors.addAll(authorMap.values()); // Thêm tất cả tác giả vào danh sách kết quả
        } catch (Exception e) {
            e.printStackTrace(); // In lỗi nếu có
        } finally {
            closeResources(); // Đóng tài nguyên
        }
        return authors;
    }

}
