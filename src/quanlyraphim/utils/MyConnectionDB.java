/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author baont
 */
public class MyConnectionDB {
    public static Connection getConn(){
        String userName = "sa";
        String password = "123";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyRapPhim";
        try {
            Connection conn = DriverManager.getConnection(url, userName, password);
            return conn;
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
    }
}
