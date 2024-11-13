package com.example.kiemtra.config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB_20146041 {
    private static String DB_URL = "jdbc:mysql://localhost:3306/qlvideo";
    private static String USER = "sa";
    private static String PASSWORD = "anhtan257299";
    private static Connection con;
    public static Connection getConnection() throws IOException {
        con = null;
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = (Connection) DriverManager.getConnection(DB_URL,USER,PASSWORD);
        }
        catch (SQLException ex){
            Logger.getLogger(ConnectDB_20146041.class.getName()).log(Level.SEVERE,null,ex);
        }
        return (con);
    }
}

