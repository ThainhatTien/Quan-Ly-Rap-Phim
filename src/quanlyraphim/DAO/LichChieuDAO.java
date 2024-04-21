/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import com.sun.jdi.connect.spi.Connection;
import quanlyraphim.entity.LichChieu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import quanlyraphim.utils.XJdbc;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class LichChieuDAO extends QuanLyRapPhimDAO<LichChieu, String> {

    @Override
    public void insert(LichChieu model) {
        String sql = "insert into LichChieu(MaLichChieu,MaPhim,MaPhong,GioChieu,NgayChieu) values (?,?,?,?,?)";
        XJdbc.update(sql,
                model.getMaLichChieu(),
                model.getMaPhim(),
                model.getMaPhong(),
                model.getGioChieu(),
                model.getNgayChieu());
    }

    @Override
    public void update(LichChieu model) {
        String sql = "update LichChieu set MaPhim = ?,MaPhong = ?,  GioChieu = ?, NgayChieu = ? where MaLichChieu = ?";
        XJdbc.update(sql,
                model.getMaPhim(),
                model.getMaPhong(),
                model.getGioChieu(),
                model.getNgayChieu(),
                model.getMaLichChieu());
    }

    @Override
    public void delete(String maLC) {
        String sql = "delete from LichChieu where MaLichChieu = ?";
        XJdbc.update(sql, maLC);
    }

    @Override
    public LichChieu selectById(String maLC) {
        String sql = "select * from LichChieu where MaLichChieu = ?";
        List<LichChieu> list = this.selectBySql(sql, maLC);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<LichChieu> selectByIdmaPhim(String maLC) {
        String sql = "SELECT MaLichChieu, MaPhong, GioChieu, NgayChieu FROM LichChieu JOIN Phim ON LichChieu.MaPhim = Phim.MaPhim WHERE LichChieu.MaPhim = ?";
        return this.selectBySq1maPhim(sql, maLC);
    }

//    public LichChieu selectByIdmaPhim(String maLC) {
//        String sql = "select MaLichChieu,MaPhong,GioChieu,NgayChieu from LichChieu join Phim on LichChieu.MaPhim = Phim.MaPhim where LichChieu.MaPhim = ?";
//        List<LichChieu> list = this.selectBySq1maPhim(sql, maLC);
//        return list.size() > 0 ? list.get(0) : null;
//    }
    protected List<LichChieu> selectBySq1maPhim(String sql, Object... args) {
        List<LichChieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = XJdbc.query(sql, args);
            try {
                while (rs.next()) {
                    LichChieu entity = new LichChieu();
                    entity.setMaLichChieu(rs.getString("MaLichChieu"));
                    entity.setMaPhong(rs.getString("MaPhong"));
                    entity.setGioChieu(rs.getString("GioChieu"));
                    entity.setNgayChieu(rs.getDate("NgayChieu"));
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

    @Override
    public List<LichChieu> selectAll() {
        String sql = "select * from LichChieu";
        return this.selectBySql(sql);
    }

    @Override
    protected List<LichChieu> selectBySql(String sql, Object... args) {
        List<LichChieu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            rs = XJdbc.query(sql, args);
            try {
                while (rs.next()) {
                    LichChieu entity = new LichChieu();
                    entity.setMaLichChieu(rs.getString("MaLichChieu"));
                    entity.setMaPhim(rs.getString("MaPhim"));
                    entity.setMaPhong(rs.getString("MaPhong"));
                    entity.setGioChieu(rs.getString("GioChieu"));
                    entity.setNgayChieu(rs.getDate("NgayChieu"));
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
