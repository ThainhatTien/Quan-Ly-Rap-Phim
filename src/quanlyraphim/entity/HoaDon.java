/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.entity;

/**
 *
 * @author Tien
 */
public class HoaDon {

    public static String tenGhe;
    public static String tenPhim;
    public static double giaGhe;
    public static double giaCombo;
    public static String maPhim;
    public static String tenCombo;
    public static double tong;
    public static String Maphong;
    public static int phong;

    public HoaDon() {
    }

    public static String getMaphong() {
        return Maphong;
    }

    public static void setMaphong(String Maphong) {
        HoaDon.Maphong = Maphong;
    }

    public static int getPhong() {
        return phong;
    }

    public static void setPhong(int phong) {
        HoaDon.phong = phong;
    }

    public static String getTenGhe() {
        return tenGhe;
    }

    public static void setTenGhe(String tenGhe) {
        HoaDon.tenGhe = tenGhe;
    }

    public static String getTenPhim() {
        return tenPhim;
    }

    public static void setTenPhim(String tenPhim) {
        HoaDon.tenPhim = tenPhim;
    }

    public static double getGiaGhe() {
        return giaGhe;
    }

    public static void setGiaGhe(double giaGhe) {
        HoaDon.giaGhe = giaGhe;
    }

    public static double getGiaCombo() {
        return giaCombo;
    }

    public static void setGiaCombo(double giaCombo) {
        HoaDon.giaCombo = giaCombo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(giaGhe);
    }

    public static String getMaPhim() {
        return maPhim;
    }

    public static void setMaPhim(String maPhim) {
        HoaDon.maPhim = maPhim;
    }

    public static String getTenCombo() {
        return tenCombo;
    }

    public static void setTenCombo(String tenCombo) {
        HoaDon.tenCombo = tenCombo;
    }

    public static double getTong() {
        return tong = giaCombo + giaGhe;
    }

    public static void setTong(double tong) {
        HoaDon.tong = tong;
    }

}
