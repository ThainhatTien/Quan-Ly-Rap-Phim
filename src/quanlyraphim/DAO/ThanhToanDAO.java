/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import quanlyraphim.entity.HoaDon;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author Tien
 */
public class ThanhToanDAO extends QuanLyRapPhimDAO<HoaDon, String> {

    @Override
    public void insert(HoaDon entity) {
        String sql = "insert into ThanhToan(TenPhim,SoGhe,GiaGhe,ThucAn,GiaThucAn,Tong) values (?,?,?,?,?,?)";
        XJdbc.update(sql,
                entity.getTenPhim(),
                entity.getTenGhe(),
                entity.getGiaGhe(),
                entity.getTenCombo(),
                entity.getGiaCombo(),
                entity.getTong());
    }

    @Override
    public void update(HoaDon entity) {
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public HoaDon selectById(String id) {
        return null;
    }

    public HoaDon selectByIdGiaGhe(String id) {
        String sql = "select GiaVe from LoaiVe join Ve on LoaiVe.MaLoaiVe = Ve.MaLoaiVe where Ve.SoGhe = ?";
        List<HoaDon> list = this.selectBySqlGiaGhe(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    protected List<HoaDon> selectBySqlGiaGhe(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    HoaDon giaVe = new HoaDon();
                    giaVe.setGiaGhe(rs.getDouble("GiaVe"));
                    list.add(giaVe);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    public HoaDon selectByIdMaPhong(String maPhim, String maPhong) {
        String sql = "select SoPhong\n"
                + "FROM (LichChieu INNER JOIN Phim ON LichChieu.MaPhim = Phim.MaPhim)\n"
                + "INNER JOIN Phong ON LichChieu.MaPhong = Phong.MaPhong\n"
                + "where LichChieu.MaPhim = ? and LichChieu.MaPhong = ?";
        List<HoaDon> list = this.selectBySqlMaPhong(sql, maPhim, maPhong);
        return !list.isEmpty() ? list.get(0) : null;
    }

    protected List<HoaDon> selectBySqlMaPhong(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    HoaDon phong = new HoaDon();
                    phong.setPhong(rs.getInt("SoPhong"));
                    list.add(phong);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<HoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        return null;
    }
}
