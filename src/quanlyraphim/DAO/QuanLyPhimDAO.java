/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import quanlyraphim.entity.Phim;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author ADMIN
 */
public class QuanLyPhimDAO extends QuanLyRapPhimDAO<Phim, String> {

    public void insert(Phim model) {
        String sql = "INSERT INTO Phim (MaPhim, TenPhim, MaLoaiPhim, NgayBD, NgayKT, HinhAnh) VALUES (?, ?, ?, ? , ? , ?)";
        XJdbc.update(sql,
                model.getMaPhim(),
                model.getTenPhim(),
                model.getMaLoaiPhim(),
                model.getNgayBD(),
                model.getNgayKT(),
                model.getHinhAnh());
    }

    public void update(Phim model) {
        String sql = "UPDATE Phim SET TenPhim=?,MaLoaiPhim=?, NgayBD = ?, NgayKT = ? ,HinhAnh = ? WHERE MaPhim=?";
        XJdbc.update(sql,
                model.getTenPhim(),
                model.getMaLoaiPhim(),
                model.getNgayBD(),
                model.getNgayKT(),
                model.getHinhAnh(),
                model.getMaPhim());
    }

    public void delete(String MaCD) {
        String sql = "DELETE FROM Phim WHERE MaPhim=?";
        XJdbc.update(sql, MaCD);
    }

    public List<Phim> selectAll() {
        String sql = "SELECT * FROM Phim";
        return this.selectBySql(sql);
    }

    public Phim selectById(String maphim) {
        String sql = "SELECT * FROM Phim WHERE MaPhim=?";
        List<Phim> list = this.selectBySql(sql, maphim);
        return list.size() > 0 ? list.get(0) : null;
    }

    public Phim selectByTenPhim(String maphim) {
        String sql = "SELECT * FROM Phim WHERE TenPhim=?";
        List<Phim> list = this.selectBySql(sql, maphim);
        return list.size() > 0 ? list.get(0) : null;
    }

    public Phim HdPhim(String maphim) {
        String sql = "SELECT TenPhim FROM Phim WHERE HinhAnh=?";
        List<Phim> list = this.selectBySql(sql, maphim);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<Phim> HdPhim(String sql, Object... args) {
        List<Phim> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    Phim entity = new Phim();
                    entity.setTenPhim(rs.getString("TenPhim"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    protected List<Phim> selectBySql(String sql, Object... args) {
        List<Phim> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    Phim entity = new Phim();
                    entity.setMaPhim(rs.getString("MaPhim"));
                    entity.setTenPhim(rs.getString("TenPhim"));
                    entity.setMaLoaiPhim(rs.getString("MaLoaiPhim"));
                    entity.setNgayBD(rs.getDate("NgayBD"));
                    entity.setNgayKT(rs.getDate("NgayKT"));
                    entity.setHinhAnh(rs.getString("HinhAnh"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
}
