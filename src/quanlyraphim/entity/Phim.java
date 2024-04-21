/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Phim {

    private String MaPhim;
    private String TenPhim;
    private String MaLoaiPhim;
    private Date NgayBD;
    private Date NgayKT;
    private String HinhAnh;

    public Phim() {
    }

    public Phim(String MaPhim, String TenPhim, String MaLoaiPhim, Date NgayBD, Date NgayKT, String HinhAnh) {
        this.MaPhim = MaPhim;
        this.TenPhim = TenPhim;
        this.MaLoaiPhim = MaLoaiPhim;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.HinhAnh = HinhAnh;
    }

    @Override
    public String toString() {
        return this.TenPhim;
    }

    public Phim(String MaPhim, String TenPhim) {
        this.MaPhim = MaPhim;
        this.TenPhim = TenPhim;
    }

    public String getMaPhim() {
        return MaPhim;
    }

    public void setMaPhim(String MaPhim) {
        this.MaPhim = MaPhim;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String TenPhim) {
        this.TenPhim = TenPhim;
    }

    public String getMaLoaiPhim() {
        return MaLoaiPhim;
    }

    public void setMaLoaiPhim(String MaTheLoai) {
        this.MaLoaiPhim = MaTheLoai;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

}
