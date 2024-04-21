/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class LichChieu {

    private String MaLichChieu;
    private String MaPhong;
    private String MaPhim;
    private String GioChieu;
    private Date NgayChieu;

    public String getMaLichChieu() {
        return MaLichChieu;
    }

    public void setMaLichChieu(String MaLichChieu) {
        this.MaLichChieu = MaLichChieu;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaPhim() {
        return MaPhim;
    }

    public void setMaPhim(String MaPhim) {
        this.MaPhim = MaPhim;
    }

    public String getGioChieu() {
        return GioChieu;
    }

    public void setGioChieu(String GioChieu) {
        this.GioChieu = GioChieu;
    }

    public Date getNgayChieu() {
        return NgayChieu;
    }

    public void setNgayChieu(Date NgayChieu) {
        this.NgayChieu = NgayChieu;
    }

}
