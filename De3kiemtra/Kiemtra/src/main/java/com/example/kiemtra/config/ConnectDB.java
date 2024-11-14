package com.example.kiemtra.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB {
    private static String DB_URL = "jdbc:mysql://localhost:3306/quan_ly_sach";
    private static String USER = "root";
    private static String PASSWORD = "";
    private static Connection con;
    public static Connection getConnection() throws IOException {
        con = null;
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = (Connection) DriverManager.getConnection(DB_URL,USER,PASSWORD);
        }
        catch (SQLException ex){
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE,null,ex);
        }
        return (con);
    }
}

