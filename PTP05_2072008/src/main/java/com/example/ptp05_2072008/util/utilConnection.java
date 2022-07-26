package com.example.ptp05_2072008.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class utilConnection {
    public static Connection getConnection(){
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/PTP04_2072008_DB",
                    "root",
                    ""
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

}
