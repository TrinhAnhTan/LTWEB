package com.example.kiemtra.dao.Impl;

import com.example.kiemtra.config.ConnectDB;
import com.example.kiemtra.dao.IUserDao_20146041;
import com.example.kiemtra.model.User_20146041;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao_20146041 implements IUserDao_20146041 {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public User_20146041 getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                User_20146041 user = new User_20146041();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPhone(rs.getString("phone"));
                user.setPasswd(rs.getString("passwd"));
                user.setSignupDate(rs.getTimestamp("signup_date").toLocalDateTime());
                user.setLastLogin(rs.getTimestamp("last_login") != null ? rs.getTimestamp("last_login").toLocalDateTime() : null);
                user.setIsAdmin(rs.getInt("is_admin"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public User_20146041 getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                User_20146041 user = new User_20146041();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPhone(rs.getString("phone"));
                user.setPasswd(rs.getString("passwd"));
                user.setSignupDate(rs.getTimestamp("signup_date").toLocalDateTime());
                user.setLastLogin(rs.getTimestamp("last_login") != null ? rs.getTimestamp("last_login").toLocalDateTime() : null);
                user.setIsAdmin(rs.getInt("is_admin"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public Boolean checkUserExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE fullname = ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public void updateUser(User_20146041 user) {
        String sql = "UPDATE users SET email = ?, fullname = ?, phone = ?, passwd = ?, signup_date = ?, last_login = ?, is_admin = ? WHERE id = ?";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFullname());
            ps.setObject(3, user.getPhone());
            ps.setString(4, user.getPasswd());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(user.getSignupDate()));
            ps.setTimestamp(6, user.getLastLogin() != null ? java.sql.Timestamp.valueOf(user.getLastLogin()) : null);
            ps.setInt(7, user.getIsAdmin());
            ps.setInt(8, user.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void insertUser(User_20146041 user) {
        String sql = "INSERT INTO users (email, fullname, phone, passwd, signup_date, last_login, is_admin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFullname());
            ps.setObject(3, user.getPhone());
            ps.setString(4, user.getPasswd());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(user.getSignupDate()));
            ps.setTimestamp(6, user.getLastLogin() != null ? java.sql.Timestamp.valueOf(user.getLastLogin()) : null);
            ps.setInt(7, user.getIsAdmin());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
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
    public List<User_20146041> getAllUsers() {
        List<User_20146041> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try {
            con = ConnectDB.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                User_20146041 user = new User_20146041();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setFullname(rs.getString("fullname"));
                user.setPhone(rs.getString("phone"));
                user.setPasswd(rs.getString("passwd"));
                user.setSignupDate(rs.getTimestamp("signup_date").toLocalDateTime());
                user.setLastLogin(rs.getTimestamp("last_login") != null ? rs.getTimestamp("last_login").toLocalDateTime() : null);
                user.setIsAdmin(rs.getInt("is_admin"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return users;
    }


    // Đóng kết nối và giải phóng tài nguyên
    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
