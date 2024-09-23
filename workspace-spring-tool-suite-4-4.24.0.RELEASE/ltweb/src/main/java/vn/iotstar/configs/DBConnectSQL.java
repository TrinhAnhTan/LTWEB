package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData; // Sửa import này

public class DBConnectSQL {
    private final String serverName = "localhost";
    private final String dbName = "ltweb";
    private final String portName = "1433";
    private final String instance = ""; // Nếu bạn có tên instance cụ thể, điền vào đây
    private final String userID = "sa";
    private final String password = "anhtan257299";

    public Connection getConnection() {
        Connection conn = null;
        
        try {
            // Cấu trúc URL cho SQL Server
            String url = "jdbc:sqlserver://" + serverName + ":" + portName + "\\" + instance + ";databaseName=" + dbName;
            if (instance == null || instance.trim().isEmpty())
                url = "jdbc:sqlserver://" + serverName + ":" + portName + ";databaseName=" + dbName;

            // Kết nối đến SQL Server
            conn = DriverManager.getConnection(url, userID, password);
            
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData(); // Sử dụng java.sql.DatabaseMetaData
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                return conn;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;        
    }
    
    // Test chuong trinh. kich chuot phai chon run as => java
    public static void main(String[] args) {
        try {
            System.out.println(new DBConnectSQL().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}