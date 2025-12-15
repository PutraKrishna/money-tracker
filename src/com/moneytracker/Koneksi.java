/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.moneytracker;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class Koneksi {
    public static Connection getKoneksi() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/money_tracker_db";
            String user = "root";
            String pass = ""; // Sesuaikan password laptop
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Error Koneksi: " + e.getMessage());
        }
        return conn;
    }
}
