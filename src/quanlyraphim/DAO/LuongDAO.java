/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyraphim.DAO;

import quanlyraphim.entity.Luong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlyraphim.entity.NhanVien;
import quanlyraphim.utils.XJdbc;

/**
 *
 * @author ADMIN
 */
public class LuongDAO extends QuanLyRapPhimDAO<Luong, String> {

    List<Luong> ls = new ArrayList<>();

    /**
     *
     * @param pos
     * @return
     */
//    public Luong getAtPosition(int pos) {
//        return ls.get(pos);
//    }

    @Override
    public void insert(Luong entity) {
        String sql = "insert into LuongNhanVien (MaNV,TenNV,Luong,Thuong,TongLuong) values (?,?,?,?,?)";
        XJdbc.update(sql,
                entity.getNv().getMaNV(),
                entity.getNv().getTenNV(),
                entity.getLuong(),
                entity.getThuong(),
                entity.getTongLuong());
    }

    @Override
    public void update(Luong entity) {
        String sql = "update LuongNhanVien set TenNV = ?,Luong = ?, Thuong = ?, TongLuong = ? where MaNV = ?";
        XJdbc.update(sql,
                entity.getNv().getTenNV(),
                entity.getLuong(),
                entity.getThuong(),
                entity.getTongLuong(),
                entity.getNv().getMaNV());
    }

    @Override
    public void delete(String id) {
        String sql = "delete LuongNhanVien where MaNV = ?";
        XJdbc.update(sql, id);
    }

    @Override
    public Luong selectById(String id) {
        String sql = "select * from LuongNhanVien where MaNV = ?";
        List<Luong> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Luong> selectAll() {
        String sql = "select * from LuongNhanVien";
        return this.selectBySql(sql);
    }

    @Override
    protected List<Luong> selectBySql(String sql, Object... args) {
        List<Luong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    Luong entity = new Luong();
                    entity.setNv(new NhanVien(rs.getString("MaNV"), rs.getString("TenNV")));
                    entity.setLuong(rs.getDouble("Luong"));
                    entity.setThuong(rs.getDouble("Thuong"));
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
