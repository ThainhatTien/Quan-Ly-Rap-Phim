/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.entity;

/**
 *
 * @author ADMIN
 */
public class Luong{

    public NhanVien nv;
    private double Luong, Thuong, TongLuong;

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public double getLuong() {
        return Luong;
    }

    public void setLuong(double Luong) {
        this.Luong = Luong;
    }

    public double getThuong() {
        return Thuong;
    }

    public void setThuong(double Thuong) {
        this.Thuong = Thuong;
    }

    public double getTongLuong() {
        return TongLuong = Luong + Thuong;
    }

}
